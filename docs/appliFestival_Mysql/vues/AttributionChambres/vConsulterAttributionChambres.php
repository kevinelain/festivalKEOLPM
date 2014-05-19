<?php
	include("_debut.inc.php");

	// CONSULTER LES ATTRIBUTIONS DE TOUS LES ÉTABLISSEMENTS
	// IL FAUT QU'IL Y AIT AU MOINS UN ÉTABLISSEMENT OFFRANT DES CHAMBRES POUR QUE 
	// L'AFFICHAGE SOIT EFFECTUÉ
	
	$nbEtabOffrantChambres = obtenirNbEtabOffrantChambres();
	if ($nbEtabOffrantChambres !=0)
	{
?>	  
		<center> <a href="cAttributionChambres.php?action=demanderModifierAttrib">
		Effectuer ou modifier les attributions</a> 
		<br/> <br/>
<?php	   
		// POUR CHAQUE ÉTABLISSEMENT : AFFICHAGE D'UN TABLEAU COMPORTANT 2 LIGNES 
		// D'EN-TÊTE (LIGNE NOM ET LIGNE DISPONIBILITÉS) ET LE DÉTAIL DES ATTRIBUTIONS
		$req = obtenirReqIdNomEtablissementsOffrantChambres();
		$rstEtab=mysql_query($req,$oCnx);

		$nbTypesChambres = obtenirNbTypesChambres();
		// Détermination du :
		//    . % de largeur que devra occuper chaque colonne contenant les attributions
		//      (100 - 35 pour la colonne d'en-tête) / nb de types chambres
		//    . nombre de colonnes de chaque tableau
		$pourcCol = 65/$nbTypesChambres;
		$nbCol = $nbTypesChambres + 1;

		// BOUCLE SUR LES ÉTABLISSEMENTS
		while($lgEtab = mysql_fetch_array($rstEtab))
		{
			$idEtab  = $lgEtab["id"];
			$nomEtab = $lgEtab["nom"];
?>	   
		  
			<table width="70%" cellspacing="0" cellpadding="0" class="tabQuadrille">
	   
				<!-- AFFICHAGE DE LA 1ÈRE LIGNE D'EN-TÊTE -->
				<tr class="enTeteTabQuad">
					<td colspan="<?php echo $nbCol; ?>"><strong><?php echo $nomEtab; ?></strong></td>
				</tr>
	   
				<!-- AFFICHAGE DE LA 2ÈME LIGNE D'EN-TÊTE : 1 LIT : NOMBRE DE CHAMBRES -->
				<!-- DISPONIBLES, 2 À 3 LITS : NOMBRE DE CHAMBRES DISPONIBLES...  -->
			 
				<tr class="enTete2TabQuad">
		  			<td width="35%"><i>Disponibilités</i></td>
<?php
						$req = obtenirReqTypesChambres();
						$rstTypeChambre = mysql_query($req,$oCnx);
					  
						// BOUCLE SUR LES TYPES DE CHAMBRES 
						while ($lgTypeChambre = mysql_fetch_array($rstTypeChambre))
						{   
						   $idTypeChambre = $lgTypeChambre["id"];
						   $libelle = $lgTypeChambre["libelle"];
						   // On recherche les disponibilités pour l'établissement et le type
						   // de chambre en question
						   $nbChDispo = obtenirNbDispo($idEtab,$idTypeChambre);
?>
						   <td><center><?php echo $libelle ; ?><br/><?php echo $nbChDispo ; ?>
						   </center></td>
<?php
						}
?>
			 </tr>
<?php				   
			 // AFFICHAGE DU DÉTAIL DES ATTRIBUTIONS : UNE LIGNE PAR GROUPE AFFECTÉ 
			 // DANS L'ÉTABLISSEMENT
				   
			 $req = obtenirReqGroupesEtab($idEtab);
			 $rstGroupe = mysql_query($req,$oCnx);
				   
			 // BOUCLE SUR LES GROUPES (CHAQUE GROUPE EST AFFICHÉ EN LIGNE)
			 while($lgGroupe = mysql_fetch_array($rstGroupe))
			 {
				$idGroupe = $lgGroupe["id"];
				$nomGroupe = $lgGroupe["nom"];
?>
				<tr class="ligneTabQuad">
				   <td width='35%'>&nbsp;<?php echo $nomGroupe ; ?></td>
<?php
				   $req = obtenirReqIdTypesChambres();
				   $rstTypeChambre = mysql_query($req,$oCnx);
						 
				   // BOUCLE SUR LES TYPES DE CHAMBRES (CHAQUE TYPE DE CHAMBRE 
				   // FIGURE EN COLONNE)
				   while($lgTypeChambre = mysql_fetch_array($rstTypeChambre))
				   {
						// On recherche si des chambres du type en question ont 
						// déjà été attribuées à ce groupe dans l'établissement
						$nbOccupGroupe = obtenirNbOccupGroupe($idEtab,$lgTypeChambre["id"], $idGroupe);
?>
					  
						<td width="<?php echo $pourcCol ; ?>%">
							<center><?php echo $nbOccupGroupe ; ?></center>
						</td>
<?php
				   } // Fin de la boucle sur les types de chambres
?>
				</tr>
<?php
			 } // Fin de la boucle sur les groupes
?>
		  
		  </table>
		  <br/>
<?php
	   } // Fin de la boucle sur les établissements
	}

	include("_fin.inc.php");
?>
