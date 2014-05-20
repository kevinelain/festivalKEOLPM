<?php

// FONCTIONS UTILISÉES UNIQUEMENT DANS LA GESTION DES ATTRIBUTIONS

// Met à jour (suppression, modification ou ajout) l'attribution correspondant à
// l'id étab, à l'id type chambre et à l'id groupe transmis
function modifierAttribChamb($pIdEtab,$pIdTypeChambre,$pIdGroupe,$pNbChambres)
{
	global $oCnx;
	$sReq = "select count(*) as nombreAttribGroupe 
			from Attribution 
			where idEtab = '$pIdEtab'
			and idTypeChambre='$pIdTypeChambre' 
			and idGroupe='$pIdGroupe'";
	$rstAttrib = mysql_query($sReq,$oCnx);
	$lgAttrib = mysql_fetch_array($rstAttrib);
	if ($pNbChambres == 0)
	{
		$sReq = "delete from Attribution 
				where idEtab='$pIdEtab' 
				and idTypeChambre='$pIdTypeChambre' 
				and idGroupe='$pIdGroupe'";
	}
	else
	{	
		if ($lgAttrib["nombreAttribGroupe"]!=0)
			$sReq = "update Attribution 
					set nombreChambres = $pNbChambres 
					where idEtab = '$pIdEtab' 
					and idTypeChambre ='$pIdTypeChambre' 
					and idGroupe =  '$pIdGroupe'";
		else
			$sReq = "insert into Attribution 
					values('$pIdEtab','$pIdTypeChambre','$pIdGroupe',$pNbChambres)";
	}
	mysql_query($sReq,$oCnx);
}

// Retourne la requête permettant d'obtenir les id et noms des groupes 
// affectés dans l'établissement transmis
function obtenirReqGroupesEtab($pId)
{
	$sReq = "select distinct id, nom 
			from Groupe, Attribution 
			where Attribution.idGroupe=Groupe.id 
			and idEtab='$pId'";
	return ($sReq);
}

// Retourne le nombre de chambres libres pour l'établissement et le type de
// chambre en question (retournera 0 si absence d'offre ou si absence de 
// disponibilité)  
function obtenirNbDispo($pIdEtab, $pIdTypeChambre)
{
	$iNbOffre = obtenirNbOffre($pIdEtab,$pIdTypeChambre);
	if ($iNbOffre != 0)
	{
		// Recherche du nombre de chambres occupées pour l'établissement et le
		// type de chambre en question
		$iNbOccup = obtenirNbOccup($pIdEtab,$pIdTypeChambre);
		// Calcul du nombre de chambres libres
		$iNbChLib = $iNbOffre - $iNbOccup;
		return ($iNbChLib);
	}
	else
		return (0);
}
            
// Retourne le nombre de chambres occupées par le groupe transmis pour l'id étab
// et l'id type chambre transmis
function obtenirNbOccupGroupe($pIdEtab, $pIdTypeChambre, $pIdGroupe)
{
	global $oCnx;
	$sReq = "select nombreChambres 
			 From Attribution 
			 where idEtab='$pIdEtab' 
			 and idTypeChambre='$pIdTypeChambre' 
			 and idGroupe='$pIdGroupe'";
	$rstAttribGroupe = mysql_query($sReq, $oCnx);
	if ($lgAttribGroupe = mysql_fetch_array($rstAttribGroupe))
		return ($lgAttribGroupe["nombreChambres"]) ;
	else
		return (0) ;
}

?>
