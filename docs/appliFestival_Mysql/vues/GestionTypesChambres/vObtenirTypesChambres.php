<?php
	include("_debut.inc.php");

	// AFFICHER L'ENSEMBLE DES TYPES DE CHAMBRES 
	// CETTE PAGE CONTIENT UN TABLEAU CONSTITUÉ D'1 LIGNE D'EN-TÊTE ET D'1 LIGNE PAR 
	// TYPE DE CHAMBRE
?>

	<br/>
	<table width="40%" cellspacing="0" cellpadding="0" class="tabNonQuadrille">
		<tr class="enTeteTabNonQuad">
			<td colspan="4"><strong>Types de chambres</strong></td>
		</tr>
<?php          
		$req = obtenirReqTypesChambres();
		$rsTypeChambre = mysql_query($req,$oCnx);
               
		// BOUCLE SUR LES TYPES DE CHAMBRES
		while ($lgTypeChambre = mysql_fetch_array($rsTypeChambre))
		{
			$id = $lgTypeChambre["id"];
			$libelle = $lgTypeChambre["libelle"];
?>
     
			<tr class="ligneTabNonQuad"> 
				<td width="15%"><?php echo $id ; ?></td>
				<td width="33%"><?php echo $libelle ; ?></td>
				<td width="26%" align="center">     
					<a href="cGestionTypesChambres.php?action=demanderModifierTypeChambre&id=<?php echo $id ; ?>">
					Modifier</a>
				</td>
<?php      
				// S'il existe déjà des attributions pour le type de chambre, il faudra
				// d'abord les supprimer avant de pouvoir supprimer le type de chambre
				if (!existeAttributionsTypeChambre($id))
				{
?>
					<td width="26%" align="center">
						<a href="cGestionTypesChambres.php?action=demanderSupprimerTypeChambre&id=<?php echo $id ; ?>"> 
						 Supprimer</a>
					</td>
<?php
				}
				else
				{
?>
					<td width="26%">&nbsp; </td>
<?php
				}
?>                  
			</tr>
<?php
		}
?>
      
	</table>
	<br/>
	<a href="cGestionTypesChambres.php?action=demanderCreerTypeChambre">
	Création d'un type de chambre</a>
<?php
	include("_fin.inc.php"); 
?>
