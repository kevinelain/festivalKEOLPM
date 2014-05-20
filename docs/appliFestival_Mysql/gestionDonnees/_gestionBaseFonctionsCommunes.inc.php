<?php

// FONCTIONS DE GESTION DES ÉTABLISSEMENTS

function obtenirReqIdNomEtablissements()
{
	$sReq = "select id, nom 
			 from Etablissement 
			 order by id";
	return ($sReq) ;
}

function obtenirReqIdNomEtablissementsOffrantChambres()
{
	$sReq = "select distinct id, nom 
			 from Etablissement, Offre 
			 where id = idEtab 
			 order by id";
	return ($sReq);
}

function obtenirReqNomEtablissementsOffrantChambres()
{
	$sReq = "select distinct nom 
			 from Etablissement, Offre 
			 where id = idEtab 
			 order by id";
	return ($sReq);
}

function obtenirReqIdEtablissementsOffrantChambres()
{
	$sReq = "select distinct id 
			 from Etablissement, Offre 
			 where id = idEtab 
			 order by id";
	return ($sReq) ;
}

function obtenirDetailEtablissement($pId)
{
	global $oCnx;
	$sReq = "select * 
			 from Etablissement 
			 where id = '" . $pId . "'";
	$rstEtab = mysql_query($sReq,$oCnx);
	return (mysql_fetch_array($rstEtab));
}

function supprimerEtablissement($pId)
{
   global $oCnx;
   $sReq = " delete from Etablissement 
		     where id = '" . $pId . "'" ;
   mysql_query($sReq,$oCnx);
}
 
function creerModifierEtablissement($pMode, $pId, $pNom, $pAdrRue, $pCP, 
                                    $pVille, $pTel, $pMail, $pType, 
                                    $pCiviliteResp, $pNomResp, $pPrenomResp)
{  
	global $oCnx;
	$nom        = str_replace("'", "''", $pNom);
	$adrRue     = str_replace("'","''",$pAdrRue);
	$ville      = str_replace("'","''",$pVille);
	$mail       = str_replace("'","''",$pMail);
	$nomResp    = str_replace("'","''",$pNomResp);
	$prenomResp = str_replace("'","''",$pPrenomResp);
	if ($pMode == 'C')
	{
		$sReq = " insert into Etablissement 
				  values ('" . $pId . "','" . $nom . "','" . $adrRue . "',
						  '" . $pCP ."','" . $ville . "',
						  '" . $pTel . "','" . $mail . "',
						  '" . $pType ."','" . $pCiviliteResp . "',
						  '" . $nomResp . "','" . $prenomResp . "')";
	}
	else
	{
		$sReq = "update Etablissement 
				 set nom = '" . $nom . "',
					adresseRue = '" . $adrRue . "',
					codePostal = '" . $pCP . "',
					ville = '" . $ville . "',
					tel = '" . $pTel  . "',
					adresseElectronique = '" . $mail . "',
					type = '" . $pType . "',
					civiliteResponsable = '" . $pCiviliteResp ."',
					nomResponsable = '" . $nomResp ."',
					prenomResponsable = '" . $prenomResp ."' 
				where id = '" . $pId . "'";
	}
	mysql_query($sReq,$oCnx);
}

function estUnIdEtablissement($pId)
{
	global $oCnx;
	$sReq = "select * 
			from Etablissement 
			where id = '". $pId . "'";
	$rstEtab = mysql_query($sReq,$oCnx);
	return (mysql_fetch_array($rstEtab));
}

function estUnNomEtablissement($pMode, $pId, $pNom)
{
	global $oCnx;
	$nom = str_replace("'", "''", $pNom);
	// S'il s'agit d'une création, on vérifie juste la non existence du nom sinon
	// on vérifie la non existence d'un autre établissement (id!='$pId') portant 
	// le même nom
	if ($pMode == 'C')
	{
		$sReq = "select * 
			    from Etablissement 
			    where nom = '" . $pNom . "'";
	}
	else
	{
		$sReq = "select * 
			    from Etablissement 
			    where nom = '". $nom . "' 
			    and id   != '". $pId . "'";
	}
	$rstEtab = mysql_query($sReq,$oCnx);
	return (mysql_fetch_array($rstEtab));
}

function obtenirNbEtab()
{
	global $oCnx;
	$sReq = "select count(*) as nbEtab 
		     from Etablissement";
	$rstEtab = mysql_query($sReq,$oCnx);
	$lgEtab = mysql_fetch_array($rstEtab);
	return ($lgEtab["nbEtab"]);
}

function obtenirNbEtabOffrantChambres()
{
	global $oCnx;
	$sReq = "select count(distinct idEtab) as nbEtab 
		     from Offre";
	$rstEtabOffrantChambres = mysql_query($sReq,$oCnx);
	$lgEtabOffrantChambres = mysql_fetch_array($rstEtabOffrantChambres);
	return ($lgEtabOffrantChambres["nbEtab"]);
}

// FONCTIONS DE GESTION DES TYPES DE CHAMBRES

function obtenirReqTypesChambres()
{
	$sReq = " Select * 
		      from TypeChambre";
	return ($sReq) ;
}

function obtenirReqIdTypesChambres()
{
	$sReq = " select id 
			  from TypeChambre";
	return ($sReq);
}

function obtenirReqLibelleTypesChambres()
{
	$sReq = "select libelle 
		     from TypeChambre 
		     order by id";
    return ($sReq) ;
}

function obtenirLibelleTypeChambre($pId)
{
	global $oCnx;
	$sReq = " select libelle 
			  from TypeChambre 
			  where id = '" . $pId ."'";
	$rstTypeChambre = mysql_query($sReq,$oCnx);
	$lgTypeChambre = mysql_fetch_array($rstTypeChambre);
	return ($lgTypeChambre["libelle"]);
}

function obtenirNbTypesChambres()
{
	global $oCnx;
	$sReq = " select count(*) as nbTypesCh 
			  from TypeChambre";
	$rstNbTypesChambres = mysql_query($sReq,$oCnx);
	$lgNbTypesChambres = mysql_fetch_array($rstNbTypesChambres);
	return ($lgNbTypesChambres["nbTypesCh"]);
}

function supprimerTypeChambre($pId)
{
	global $oCnx;
	$sReq = " delete from TypeChambre 
			  where id = '" . $pId ."'";
	mysql_query($sReq,$oCnx);
}

function obtenirDetailTypeChambre($pId)
{
	global $oCnx;
	$sReq = " select * 
			  from TypeChambre 
			  where id = '". $pId ."'";
	$rstTypeChambre = mysql_query($sReq,$oCnx);
	$lgTypeChambre = mysql_fetch_array($rstTypeChambre);
	return ($lgTypeChambre) ;
}

function creerModifierTypeChambre($pMode, $pId, $pLibelle)
{
	global $oCnx;
	$pLibelle = str_replace("'","''",$pLibelle);
	if ($pMode == 'C')
	{
		$sReq = "insert into TypeChambre 
				values ('". $pId . "', '". $pLibelle. "')";
	}
	else
	{
		$sReq = "update TypeChambre 
				set libelle = '". $pLibelle . "' 
				where id    = '". $pId . "'";
	}
	mysql_query($sReq,$oCnx);
}

function estUnIdTypeChambre($pId)
{
	global $oCnx;
	$sReq = " select * 
			  from TypeChambre 
			  where id = '" . $pId . "'";
	$rstTypeChambre = mysql_query($sReq,$oCnx);
	return mysql_fetch_array($rstTypeChambre);
}

function estUnLibelleTypeChambre($pMode, $pId, $pLibelle)
{
	global $oCnx;
	$pLibelle = str_replace("'","''",$pLibelle);
	// S'il s'agit d'une création, on vérifie juste la non existence du libellé
	// sinon on vérifie la non existence d'un autre type chambre (id!='$pId') 
	// ayant le même libelle
	if ($pMode == 'C')
	{
		$sReq = "select * 
				from TypeChambre 
				where libelle = '". $pLibelle ."'";
	}
	else
	{
		$sReq = "select * 
				from TypeChambre 
				where libelle = '" . $pLibelle ."' 
				and id != '". $pId ."'";
	}
	$rstTypeChambre=mysql_query($sReq,$oCnx);
	return (mysql_fetch_array($rstTypeChambre));
}

// FONCTIONS RELATIVES AUX GROUPES

function obtenirReqIdNomGroupesAHeberger()
{
	$sReq = " select id, nom 
			  from Groupe 
			  where hebergement = 'O' 
			  order by id";
	return ($sReq) ;
}

function obtenirNomGroupe($pId)
{
	global $oCnx;
	$sReq = " select nom 
			  from Groupe 
			  where id = '". $pId ."'";
	$rstGroupe = mysql_query($sReq,$oCnx);
	$lgGroupe = mysql_fetch_array($rstGroupe);
	return ($lgGroupe["nom"]);
}

// FONCTIONS RELATIVES AUX OFFRES

// Met à jour (suppression, modification ou ajout) l'offre correspondant à l'id
// étab et à l'id type chambre transmis
function modifierOffreHebergement($pIdEtab,$pIdTypeChambre,$pNbChambresDemandees)
{
	global $oCnx;
	$sReq = " select nombreChambres 
			  from Offre 
			  where idEtab = '" . $pIdEtab ."' 
			  and idTypeChambre = '" . $pIdTypeChambre ."'";
	$rstOffre = mysql_query($sReq,$oCnx);
	$lgOffre = mysql_fetch_array($rstOffre);
	if($pNbChambresDemandees==0)
		$sReq = "delete from Offre 
				 where idEtab = '". $pIdEtab ."' 
				 and idTypeChambre = '". $pIdTypeChambre ."'";
	else
	{
		if($lgOffre["nombreChambres"]!=0)
			$sReq = "update Offre 
					 set nombreChambres = " . $pNbChambresDemandees  . "
					 where idEtab = '" . $pIdEtab ."' 
					 and idTypeChambre = '" . $pIdTypeChambre ."'";
		else
			$sReq = " insert into Offre 
					  values('" . $pIdEtab . "','" . $pIdTypeChambre . "',". $pNbChambresDemandees . ")";
	}
	mysql_query($sReq,$oCnx);
}

// Retourne le nombre de chambres offertes pour l'id étab et l'id type chambre 
// transmis
function obtenirNbOffre($pIdEtab, $pIdTypeChambre)
{
	global $oCnx;
	$sReq = "select nombreChambres 
			from Offre 
			where idEtab = '" . $pIdEtab ."' 
			and idTypeChambre = '" . $pIdTypeChambre . "'";
	$rsttOffre = mysql_query($sReq, $oCnx);
	if ($lgOffre = mysql_fetch_array($rsttOffre))
		return ($lgOffre["nombreChambres"]) ;
	else
		return (0) ;
}

// Retourne false si le nombre de chambres transmis est inférieur au nombre de 
// chambres occupées pour l'établissement et le type de chambre transmis 
// Retourne true dans le cas contraire
function estModifOffreCorrecte($pIdEtab,$pIdTypeChambre,$pNbChambres)
{
	$iNbOccup = obtenirNbOccup($pIdEtab,$pIdTypeChambre);
	return ($pNbChambres >= $iNbOccup);
}

// FONCTIONS RELATIVES AUX ATTRIBUTIONS

// Teste la présence d'attributions pour l'établissement transmis    
function existeAttributionsEtab($pId)
{
	global $oCnx;
	$sReq = "select * 
			 From Attribution 
			 where idEtab = '" . $pId ."'";
	$rstAttrib = mysql_query($sReq, $oCnx);
	return (mysql_fetch_array($rstAttrib));
}

// Teste la présence d'attributions pour le type de chambre transmis 
function existeAttributionsTypeChambre($pId)
{
	global $oCnx;
	$sReq = "select * 
			From Attribution 
			where idTypeChambre = '" . $pId . "'";
	$rstAttrib = mysql_query($sReq, $oCnx);
	return (mysql_fetch_array($rstAttrib));
}

// Retourne le nombre de chambres occupées pour l'id étab et l'id type chambre
// transmis
function obtenirNbOccup($pIdEtab, $pIdTypeChambre)
{
	global $oCnx;
	$sReq = "select IFNULL(sum(nombreChambres), 0) as totalChambresOccup 
			 from Attribution 
			 where idEtab = '" . $pIdEtab . "' 
			 and idTypeChambre = '" . $pIdTypeChambre ."'";
	$rstOccup = mysql_query($sReq,$oCnx);
	$lgOccup  = mysql_fetch_array($rstOccup);
	return ($lgOccup["totalChambresOccup"]);
}

?>
