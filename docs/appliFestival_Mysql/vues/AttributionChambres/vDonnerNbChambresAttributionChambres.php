<?php
	include("_debut.inc.php");

	// SÉLECTIONNER LE NOMBRE DE CHAMBRES SOUHAITÉES
?>
	<form method="POST" action="cAttributionChambres.php">
		<input type="hidden" value="validerModifierAttrib" name="action" />
		<input type="hidden" value="<?php echo $idEtab ; ?>" name="idEtab"/>
		<input type="hidden" value="<?php echo $idTypeChambre ; ?>" name="idTypeChambre" />
		<input type="hidden" value="<?php echo $idGroupe ?>" name="idGroupe" />
<?php
		$nomGroupe = obtenirNomGroupe($idGroupe);
?>
		<br/>
		<center>
			Combien de chambres de type <?php echo $idTypeChambre ; ?> souhaitez-vous pour le 
			groupe <?php echo $nomGroupe ; ?> ?
			<br/><br/><br/>
  
			<select name="nbChambres">
<?php
				for ($i=0; $i<=$nbChambres; $i++)
				{
?>
					<option><?php echo $i ?></option>
<?php
				}
?>
			</select>
		</center>
		<br/>
		<input type="submit" value="Valider" name="valider" />
		&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
		<input type="reset" value="Annuler" name="Annuler" />
		<br/><br/>
		<a href="cAttributionChambres.php?action=demanderModifierAttrib">Retour</a>
	</form>
	
<?php
	include("_fin.inc.php");
?>
