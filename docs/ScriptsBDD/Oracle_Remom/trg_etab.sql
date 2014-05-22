CREATE OR REPLACE TRIGGER TRG_ETABLISSEMENT
	BEFORE INSERT OR UPDATE OR DELETE
	ON ETABLISSEMENT
	FOR EACH ROW
BEGIN
	IF INSERTING THEN
		INSERT INTO ARCHI_ETABLISSEMENT(Eta_Id, Eta_Nom, Eta_Rue, Eta_Cp, Eta_Ville, Eta_Tel, Eta_Mail, Eta_Type, Eta_CivilResp, Eta_NomResp, Eta_PrenomResp, Eta_Date, Eta_Manip)
		VALUES (:new.Eta_Id, :new.Eta_Nom, :new.Eta_Rue, :new.Eta_Cp, :new.Eta_Ville, :new.Eta_Tel, :new.Eta_Mail, :new.Eta_Type, :new.Eta_CivilResp, :new.Eta_NomResp, :new.Eta_PrenomResp, SYSDATE, 'I');
	END IF;
	IF UPDATING THEN
		UPDATE ARCHI_ETABLISSEMENT
		SET Eta_Date = SYSDATE, Eta_Manip = 'U';
	END IF;
	IF DELETING THEN
		UPDATE ARCHI_ETABLISSEMENT
		SET Eta_Date = SYSDATE, Eta_Manip = 'D';
	END IF;
END;