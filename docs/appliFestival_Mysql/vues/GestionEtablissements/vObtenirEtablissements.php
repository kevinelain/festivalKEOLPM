<?php
	include("_debut.inc.php");

	// AFFICHER L'ENSEMBLE DES ÉTABLISSEMENTS
	// CETTE PAGE CONTIENT UN TABLEAU CONSTITUÉ D'1 LIGNE D'EN-TÊTE ET D'1 LIGNE PAR
	// ÉTABLISSEMENT
?>

	<br/>
	<table width="55%" cellspacing="0" cellpadding="0" class="tabNonQuadrille">
	
		<tr class="enTeteTabNonQuad">
			<td colspan="4"><strong>Etablissements</strong></td>
		</tr>
	
<?php    
			$req = obtenirReqIdNomEtablissements();
			$rsEtab = mysql_query($req,$oCnx);
						
		   // BOUCLE SUR LES ÉTABLISSEMENTS
			while ($lgEtab = mysql_fetch_array($rsEtab))
			{
				$id  = $lgEtab["id"];
				$nom = $lgEtab["nom"];
?>
				<tr class="ligneTabNonQuad">
					<td width="52%"><?php echo $nom ; ?></td>         
					<td width="16%" align="center"> 
						<a href="cGestionEtablissements.php?action=detailEtab&id=<?php echo $id; ?>">
						Voir détail</a> 			
					</td>
         
					<td width="16%" align="center"> 
						<a href="cGestionEtablissements.php?action=demanderModifierEtab&id=<?php echo $id; ?>">
						Modifier</a>
					</td> 
 <?php     	
					// S'il existe déjà des attributions pour l'établissement, il faudra
					// d'abord les supprimer avant de pouvoir supprimer l'établissement
					if (! existeAttributionsEtab($id))
					{
?>				
						<td width="16%" align="center"> 
<?php
						echo "
							<a href='cGestionEtablissements.php?action=demanderSupprimerEtab&id=$id'>
							Supprimer</a>
						</td> " ;

					}
					else
					{
?>
					
						<td width="16%">&nbsp; </td>
<?php					
					}
?>
		
				</tr>
<?php
			}
?>
  
	</table>
	<br/>
	<a href="cGestionEtablissements.php?action=demanderCreerEtab">Création d'un établissement</a >
<?php
	include("_fin.inc.php");
?>
