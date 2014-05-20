
-- compte festival mdp secret

drop table Attribution cascade constraints;
drop table Offre cascade constraints;
drop table TypeChambre cascade constraints;
drop table Groupe cascade constraints;
drop table Etablissement cascade constraints;

create table Etablissement 
(Eta_Id        char(8) not null, 
Eta_Nom        varchar2(45) not null,
Eta_Rue        varchar2(45) not null, 
Eta_CP         char(5) not null, 
Eta_Ville      varchar2(35) not null,
Eta_Tel        varchar2(13) not null,
Eta_Mail       varchar2(70),
Eta_Type       number(1) not null,
Eta_CivilResp  varchar2(12) not null,
Eta_NomResp    varchar2(25) not null,
Eta_PrenomResp varchar2(25),
constraint pk_Etablissement primary key(Eta_Id));

create table TypeChambre
(TCh_Id     char(2) not null, 
TCh_Libelle varchar2(15) not null, 
constraint pk_TypeChambre primary key(TCh_Id)) ;

create table Offre
(Off_Etalissement  char(8) not null, 
Off_TypeChambre    char(2) not null, 
Off_NbChambres     number(2) not null, 
constraint pk_Offre primary key(Off_Etablissement, Off_TypeChambre));

create index OffreTypeChambre_FK on offre (Off_TypeChambre asc) ;

create table Groupe
(Gp_Id         char(4) not null, 
 Gp_Nom        varchar2(40) not null, 
 Gp_IdentResp  varchar2(40) default null,
Gp_Adresse     varchar2(120) default null,
Gp_NbPers      number(2) not null, 
Gp_NomPays     varchar2(40) not null, 
Gp_Hebergement char(1) not null,
constraint pk_Groupe primary key(Gp_Id));

create table Attribution
(Att_Etablissement char(8) not null, 
Att_TypeChambre    char(2) not null, 
Att_Groupe         char(4) not null, 
Att_NbChambres     number(2) not null,
constraint pk_Attribution primary key(Att_Etablissement, Att_TypeChambre, Att_Groupe)) ;

create index AttributionTypeChambre_FK on attribution (Att_TypeChambre asc) ;
create index AttributionGroupe_FK on attribution (Att_Groupe asc) ;

ALTER TABLE offre
add constraint  fk1_Offre foreign key(Off_Etablissement) references Etablissement(Eta_Id) ;
 
ALTER TABLE offre
constraint fk2_Offre foreign key(Off_TypeChambre) references TypeChambre(TCh_Id);

ALTER TABLE attribution
add constraint fk1_Attribution foreign key(Att_Groupe) references Groupe(Gp_Id) ;

ALTER TABLE attribution
add constraint fk2_Attribution foreign key(Att_Etablissement, Att_TypeChambre) references Offre(Off_Etablissement, Off_TypeChambre) ;
