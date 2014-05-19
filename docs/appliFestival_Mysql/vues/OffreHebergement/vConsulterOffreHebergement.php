<?php
	include("_debut.inc.php");

	// CONSULTER LES OFFRES DE TOUS LES ÉTABLISSEMENTS

	// IL FAUT QU'IL Y AIT AU MOINS UN ÉTABLISSEMENT ET UN TYPE CHAMBRE POUR QUE 
	// L'AFFICHAGE SOIT EFFECTUÉ
	$nbEtab = obtenirNbEtab();
	$nbTypesChambres = obtenirNbTypesChambres();

	if ($nbEtab != 0 && $nbTypesChambres != 0)
	{
		// POUR CHAQUE ÉTABLISSEMENT : AFFICHAGE DU NOM ET D'UN TABLEAU COMPORTANT 1
		// LIGNE D'EN-TÊTE ET 1 LIGNE PAR TYPE DE CHAMBRE

		$reqEtab = obtenirReqIdNomEtablissements();
		$rsEtab = mysql_query($reqEtab,$oCnx);

		// BOUCLE SUR LES ÉTABLISSEMENTS
		while ($lgEtab = mysql_fetch_array($rsEtab))
		{
			$idEtab = $lgEtab["id"];
			$nom    = $lgEtab["nom"];
			 
			// AFFICHAGE DU NOM DE L'ÉTABLISSEMENT ET D'UN LIEN VERS LE FORMULAIRE DE
			// MODIFICATION
?>
			<strong><?php echo $nom ; ?></strong><br/>
			<a href="cOffreHebergement.php?action=demanderModifierOffre&idEtab=<?php echo $idEtab ; ?>">
			Modifier</a>
	   
			<table width="45%" cellspacing="0" cellpadding="0" class="tabQuadrille">
		  
				<!-- AFFICHAGE DE LA LIGNE D'EN-TÊTE -->
			 
				<tr class="enTeteTabQuad">
					<td width="30%">Type</td>
					<td width="35%">Capacité</td>
					<td width="35%">Nombre de chambres</td> 
				</tr>
<?php			   
				$req = obtenirReqTypesChambres();
				$rsTypeChambre = mysql_query($req,$oCnx);
				
				// BOUCLE SUR LES TYPES DE CHAMBRES (AFFICHAGE D'UNE LIGNE PAR TYPE DE 
				// CHAMBRE AVEC LE NOMBRE DE CHAMBRES OFFERTES DANS L'ÉTABLISSEMENT POUR 
				// LE TYPE DE CHAMBRE)
				while($lgTypeChambre=mysql_fetch_array($rsTypeChambre))  
				{
					$idTypeChambre = $lgTypeChambre["id"];
					$libelle = $lgTypeChambre["libelle"];
?>			 
					<tr class="ligneTabQuad">
						<td><?php echo $idTypeChambre ; ?></td>
						<td><?php echo $libelle ; ?></td>
<?php
						// On récupère le nombre de chambres offertes pour l'établissement 
						// et le type de chambre actuellement traités
						$nbOffre = obtenirNbOffre($idEtab,$idTypeChambre);
?>
						<td><?php echo $nbOffre ; ?></td>
					</tr>
<?php
				}
?>
			</table><br/>
<?php
		}
	}

	include("_fin.inc.php");
?>
