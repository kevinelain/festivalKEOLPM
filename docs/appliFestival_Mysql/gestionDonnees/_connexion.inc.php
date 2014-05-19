<?php

	$hote="localhost";
	$login="festival";
	$mdp = "secret";
	$bdd = "festival";
	$oCnx = mysql_connect($hote,$login,$mdp);
	if ($oCnx) 
	{
		$sReq = "SET CHARACTER SET utf8";
		// modification du jeu de caractères de la oCnx
		$res = mysql_query($sReq, $oCnx); 
		mysql_select_db($bdd, $oCnx);
	}
	else 
	{
		ajouterErreur("Echec de la connexion au serveur MySQL");
		ajouterErreur(" => " . mysql_error());
	} 

?>
