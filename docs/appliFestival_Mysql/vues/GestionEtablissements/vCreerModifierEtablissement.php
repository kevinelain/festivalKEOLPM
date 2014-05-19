<?php
	include("_debut.inc.php");

	// CRÉER OU MODIFIER UN ÉTABLISSEMENT 
	// S'il s'agit d'une création et qu'on ne "vient" pas de ce formulaire (on 
	// "vient" de ce formulaire uniquement s'il y avait une erreur), il faut définir 
	// les champs à vide sinon on affichera les valeurs précédemment saisies
	if ($action == "demanderCreerEtab") 
	{  
		$id = "";
		$nom = "";
		$adresseRue = "";
		$ville = "";
		$codePostal = "";
		$tel = "";
		$mail = "";
		$type = 0;
		$civiliteResp = "Monsieur";
		$nomResp = "";
		$prenomResp = "";
	}

	// S'il s'agit d'une modification et qu'on ne "vient" pas de ce formulaire, il
	// faut récupérer les données sinon on affichera les valeurs précédemment 
	// saisies
	if ($action == "demanderModifierEtab")
	{
		$lgEtab=obtenirDetailEtablissement($id);
	  
		$nom = $lgEtab["nom"];
		$adresseRue = $lgEtab["adresseRue"];
		$codePostal = $lgEtab["codePostal"];
		$ville = $lgEtab["ville"];
		$tel = $lgEtab["tel"];
		$mail = $lgEtab["adresseElectronique"];
		$type = $lgEtab["type"];
		$civiliteResp = $lgEtab["civiliteResponsable"];
		$nomResp = $lgEtab["nomResponsable"];
		$prenomResp = $lgEtab["prenomResponsable"];
	}

	// Initialisations en fonction du mode (création ou modification) 
	if ($action == "demanderCreerEtab" || $action == "validerCreerEtab")
	{
	   $creation = true;
	   $message  = "Nouvel établissement";  // Alimentation du message de l'en-tête
	   $action   = "validerCreerEtab";
	}
	else
	{
	   $creation = false;
	   $message  = "$nom ($id)";            // Alimentation du message de l'en-tête
	   $action  = "validerModifierEtab";
	}

	// Déclaration du tableau des civilités
	$tabCivilite = array("Monsieur","Madame","Mademoiselle");  
?>
	
	<form method="POST" action="cGestionEtablissements.php?">
		<input type="hidden" value="<?php echo $action ; ?>" name="action" />
		<br />
		<table width="85%" cellspacing="0" cellpadding="0" class="tabNonQuadrille">
	   
			<tr class="enTeteTabNonQuad">
				<td colspan="3"><strong><?php echo $message ; ?></strong></td>
			</tr>
<?php			   
			// En cas de création, l'id est accessible sinon l'id est dans un champ
			// caché               
			if ($creation) 
			{
				// On utilise les guillemets comme délimiteur de champ dans l'echo afin
				// de ne pas perdre les éventuelles quotes saisies (même si les quotes
				// ne sont pas acceptées dans l'id, on a le souci de ré-afficher l'id
				// tel qu'il a été saisi) 
?>
			 
				<tr class="ligneTabNonQuad">
					<td> Id*: </td>
					<td><input type="text" value="<?php echo $id ; ?>"  name="id" size ="10" maxlength="8" /></td>
				</tr>
<?php
			}   
			else 
			{
?>
				<tr>
					<td><input type="hidden" value="<?php echo $id ; ?>" name="id" /></td><td></td>
				</tr>
<?php
			}
?>
			<tr class="ligneTabNonQuad">
				<td> Nom*: </td>
				<td><input type="text" value="<?php echo $nom ; ?>" name="nom" size="50" maxlength="45" /></td>
			</tr>
			<tr class="ligneTabNonQuad">
				<td> Adresse*: </td>
				<td><input type="text" value="<?php echo $adresseRue ; ?>" name="adresseRue" size="50" maxlength="45" /></td>
			</tr>
			<tr class="ligneTabNonQuad">
				<td> Code postal*: </td>
				<td><input type="text" value="<?php echo $codePostal ; ?>" name="codePostal" size="7" maxlength="5" /></td>
			</tr>
			<tr class="ligneTabNonQuad">
				<td> Ville*: </td>
				<td><input type="text" value="<?php echo $ville ; ?>" name="ville" size="40" maxlength="35" /></td>
			</tr>
			<tr class="ligneTabNonQuad">
				<td> Téléphone*: </td>
				<td><input type="tel" value="<?php echo $tel ; ?>" name="tel" size ="20" maxlength="10" /></td>
			</tr>
			<tr class="ligneTabNonQuad">
				<td> E-mail: </td>
				<td><input type="text" value="<?php echo $mail ; ?>" name="adresseElectronique" size ="75" maxlength="70" /></td>
			</tr>
			<tr class="ligneTabNonQuad">
				<td> Type*: </td>
				<td>
<?php
					if ($type==1)
					{
	?>
					   
						<input type="radio" name="type" value="1" checked="checked" />  
						Etablissement Scolaire
						<input type="radio" name="type" value="0" />  Autre
<?php
					}
					else
					{
?>
					
						<input type="radio" name="type" value="1" /> 
						Etablissement Scolaire
						<input type="radio" name="type" value="0" checked="checked" /> Autre
<?php
					}
?>
			   
				</td>
			</tr>
			<tr class="ligneTabNonQuad">
				<td colspan="2" ><strong>Responsable:</strong></td>				
			</tr>
			<tr class="ligneTabNonQuad">
				<td> Civilité*: </td>
				<td> 
					<select name="civiliteResponsable">
<?php
						for ($i=0; $i<3; $i++)
						{
							if ($tabCivilite[$i] == $civiliteResp) 
							{
								echo "<option selected='selected'>$tabCivilite[$i]</option>";
							}
							else
							{
								echo "<option >$tabCivilite[$i]</option>";
							}
						}
?>
				  
					</select>
					&nbsp; &nbsp; &nbsp; &nbsp; Nom*: 
					<input type="text" value="<?php echo $nomResp ; ?>" name="nomResponsable" size="26" maxlength="25" />
					&nbsp; &nbsp; &nbsp; &nbsp; Prénom: 
					<input type="text"  value="<?php echo $prenomResp ; ?>" name="prenomResponsable" size="26" maxlength="25" />
				</td>
			 </tr>
		</table>
	   
		<table align="center" cellspacing="15" cellpadding="0">
			<tr>
				<td align="right"><input type="submit" value="Valider" name="valider" />
				</td>
				<td align="left"><input type="reset" value="Annuler" name="annuler"/>
				</td>
			</tr>
		</table>
		<a href="cGestionEtablissements.php">Retour</a>
	</form>
<?php
	include("_fin.inc.php");
?>
