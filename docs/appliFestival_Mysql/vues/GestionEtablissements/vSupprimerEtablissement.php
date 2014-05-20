<?php
	include("_debut.inc.php");

	// SUPPRIMER L'ÉTABLISSEMENT SÉLECTIONNÉ

	$id = $_REQUEST["id"];  // Non obligatoire mais plus propre
	$lgEtab = obtenirDetailEtablissement($id);
	$nom = $lgEtab["nom"];
?>
	
	<br/>
	<center>Voulez-vous vraiment supprimer l'établissement <?php echo $nom ; ?> ?
	<h3><br/>
	<a href="cGestionEtablissements.php?action=validerSupprimerEtab&id=<?php echo $id ; ?>">Oui</a>
	&nbsp; &nbsp; &nbsp; &nbsp;
	<a href="cGestionEtablissements.php">Non</a></h3>
	</center>
<?php
	include("_fin.inc.php");
?>
