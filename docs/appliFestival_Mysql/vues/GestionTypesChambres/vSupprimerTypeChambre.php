<?php
	include("_debut.inc.php");
	// SUPPRIMER LE TYPE DE CHAMBRE SÉLECTIONNÉ
	$id = $_REQUEST["id"];  // Non obligatoire mais plus propre
?>
	
	<br/>
	<center>Voulez-vous vraiment supprimer le type de chambre <?php echo $id ; ?> ?
	<h3>
	<br/>
	<a href="cGestionTypesChambres.php?action=validerSupprimerTypeChambre&id=<?php echo $id ; ?>">
	Oui</a>&nbsp; &nbsp; &nbsp; &nbsp;
	<a href="cGestionTypesChambres.php">Non</a></h3></center>
<?php
	include("_fin.inc.php");
?>
