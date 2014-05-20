<?php
	include("_debut.inc.php");

	// CRÉER OU MODIFIER UN TYPE DE CHAMBRE
	// S'il s'agit d'une création et qu'on ne "vient" pas de ce formulaire (on 
	// "vient" de ce formulaire uniquement s'il y avait une erreur), il faut définir 
	// les champs à vide
	if ($action == "demanderCreerTypeChambre") 
	{  
		$id = "";
		$libelle = "";
	}

	// S'il s'agit d'une modification et qu'on ne "vient" pas de ce formulaire, il
	// faut récupérer le libellé
	if ($action == "demanderModifierTypeChambre")
	{
		$libelle = obtenirLibelleTypeChambre($id);
	}

	// Initialisations en fonction du mode (création ou modification) 
	if ($action == "demanderCreerTypeChambre" || $action =="validerCreerTypeChambre")
	{
		$creation = true;
		$message  = "Nouveau type de chambre"; // Alimentation du message de l'en-tête
		$action   = "validerCreerTypeChambre";
	}
	else
	{
		$creation = false;
		$message  = "Type $id";                // Alimentation du message de l'en-tête
		$action   = "validerModifierTypeChambre";
	}
?>
	
	<form method="POST" action="cGestionTypesChambres.php">
		<input type="hidden" value="<?php echo $action ; ?>" name="action" />
		<br/>
		<table width="40%" cellspacing="0" cellpadding="0" class="tabNonQuadrille">
	   
			<tr class="enTeteTabNonQuad">
				<td colspan="3"><strong><?php echo $message ; ?></strong></td>
			</tr>
<?php		   
			// En cas de création, l'id est accessible sinon l'id est dans un champ
			// caché
			if ($creation) 
			{
?>			
				<tr class="ligneTabNonQuad">
					<td> Id*: </td>
					<td><input type="text" value="<?php echo $id ; ?>" name="id" size="2" 
					maxlength="2" /></td>
				</tr>
<?php
			}   
			else 
			{
?>
				<tr class="autreLigne">
					<td><input type="hidden" value="<?php echo $id ; ?>" name="id" />
					</td>
					<td></td>
				</tr>
<?php
			}
?>		  
			
			<tr class="ligneTabNonQuad">
				<td> Libellé*: </td>
				<td><input type="text" value="<?php echo $libelle ; ?>" name="libelle" size="30" 
				maxlength="25" /></td>
			</tr>
		</table>
		 	  
		<table align="center" cellspacing="15" cellpadding="0">
		  <tr>
			 <td align="right"><input type="submit" value="Valider" name="cmd_valider" />
			 </td>
			 <td align="left"><input type="reset" value="Annuler" name="cmd_annuler" />
			 </td>
		  </tr>
	   </table>
	   <a href="cGestionTypesChambres.php">Retour</a>
	</form>
	
<?php
	include("_fin.inc.php");
?>
