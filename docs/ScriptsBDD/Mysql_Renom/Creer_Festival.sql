
-- lors de la création de la base festival, il faut le jeu de caractères
-- UTF-8 et l'interclassement associé utf8_general_ci (ce sont les valeurs 
-- par défaut si vous utilisez le package EasyPHP du CERTA)

GRANT ALL ON festival . * TO 'festival'@'localhost' IDENTIFIED BY 'secret';

DROP TABLE IF EXISTS `Attribution`;
DROP TABLE IF EXISTS `Offre`;
DROP TABLE IF EXISTS `TypeChambre`;
DROP TABLE IF EXISTS `Groupe`;
DROP TABLE IF EXISTS `Etablissement`;

create table Etablissement 
(Eta_Id char(8) not null, 
Eta_Nom varchar(45) not null,
Eta_Rue varchar(45) not null, 
Eta_CP char(5) not null, 
Eta_Ville varchar(35) not null,
Eta_Tel varchar(13) not null,
Eta_Mail varchar(70),
Eta_Type tinyint not null,
Eta_CivilResp varchar(12) not null,
Eta_NomResp varchar(25) not null,
Eta_PrenomResp varchar(25),
constraint pk_Etablissement primary key(Eta_Id))
ENGINE=INNODB;

create table TypeChambre
(TCh_Id char(2) not null, 
TCh_Libelle varchar(15) not null, 
constraint pk_TypeChambre primary key(TCh_Id))
ENGINE=INNODB;

create table Offre
(Off_Etalissement  char(8) not null, 
Off_TypeChambre    char(2) not null, 
Off_NbChambres integer not null, 
constraint pk_Offre primary key(Off_Etablissement, Off_TypeChambre), 
INDEX(Off_TypeChambre),
constraint fk1_Offre foreign key(Off_Etablissement) references Etablissement(Eta_Id) 
ON DELETE CASCADE ON UPDATE CASCADE, 
constraint fk2_Offre foreign key(Off_TypeChambre) references TypeChambre(TCh_Id)
ON DELETE CASCADE ON UPDATE CASCADE)
ENGINE=INNODB;

create table Groupe
(Gp_Id char(4) not null, 
Gp_Nom varchar(40) not null, 
Gp_IdentResp varchar(40) default null,
Gp_Adresse varchar(120) default null,
Gp_NbPers integer not null, 
Gp_NomPays varchar(40) not null, 
Gp_Hebergement char(1) not null,
constraint pk_Groupe primary key(Gp_Id))
ENGINE=INNODB;

create table Attribution
(Att_Etablissement char(8) not null, 
Att_TypeChambre char(2) not null, 
Att_Groupe char(4) not null, 
Att_NbChambres integer not null,
INDEX(Att_TypeChambre),
INDEX(Att_Groupe),
constraint pk_Attribution primary key(Att_Etablissement, Att_TypeChambre, Att_Groupe), 
constraint fk1_Attribution foreign key(Att_Groupe) references Groupe(Gp_Id), 
constraint fk2_Attribution foreign key(Att_Etablissement, Att_TypeChambre) references Offre(Off_Etablissement, Off_TypeChambre) )
ENGINE=INNODB;
