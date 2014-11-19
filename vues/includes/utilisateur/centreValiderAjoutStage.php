<!-- cette page s'affiche lors de la réussite de l'ajout du stage-->

<!--récupération des données du stage ajouté-->
<?php
$Eleve = $_POST['eleve'];
$daoEleve = new M_DaoPersonne();
$daoEleve->connecter();
$Leleve = $daoEleve->getOneById($Eleve);
$daoEleve->deconnecter();
$AnneeScol = $_POST['annee'];

$Organisation = $_POST['organisation'];
$daoOrganisation = new M_DaoOrganisation();
$daoOrganisation->connecter();
$Lorganisation = $daoOrganisation->getOneById($Organisation);
$daoOrganisation->deconnecter();

$MaitreStage = $_POST['maitrestage'];
$daoMaitreStage = new M_DaoPersonne();
$daoMaitreStage->connecter();
$Lemaitrestage = $daoMaitreStage->getOneById($MaitreStage);
$daoMaitreStage->deconnecter();

if ($_POST['ville'] === "insertVille") {
    $Ville = $_POST['ajoutVille'];
} else {
    $Ville = $_POST['ville'];
}

$DateDebut = $_POST['dateDebut'];
$DateFin = $_POST['dateFin'];

$Divers = $_POST['divers'];
$BilanTravaux = $_POST['bilanTravaux'];
$RessourcesOutils = $_POST['RessourcesOutils'];
$Commantaire = $_POST['Commantaire'];
$ParticipationCCF = $_POST['ParticipationCCF'];

$Professeur = $_POST['professeur'];
$daoProfesseur = new M_DaoPersonne();
$daoProfesseur->connecter();
$Leprofesseur = $daoProfesseur->getOneById($Professeur);
$daoProfesseur->deconnecter();

$DateVisite = $_POST['dateVisite'];
?>

<h1>Le stage a bien été ajouté</h1>

<h2>Récapitulatif des informations</h2>

<fieldset>
    <legend>Informations étudiant</legend>
    <label for="etudiant">Etudiant :</label>
    <input type="text" readonly="readonly" name="eleve" id="eleve" value="<?php echo $Eleve->getNom() . ' ' . $Eleve->getPrenom() ?>"></input><br/>
    <label for="anneescol">Année Scolaire :</label>
    <input type="text" readonly="readonly" name="annee" id="annee" value="<?php echo $AnneeScol ?>"></input><br/>
</fieldset>


<fieldset>
    <legend>Informations stage</legend>
    <label for="organisation">Organisation :</label>
    <input type="text" readonly="readonly" name="organisation" id="organisation" value="<?php echo $Organisation->getNom() ?>"></input><br/>
    <label for="ville">Ville :</label>
    <input type="text" readonly="readonly" name="ville" id="ville" value="<?php echo $Organisation->getVille() ?>"></input><br/>
    <label for="maitrestage">Maitre de stage :</label>
    <input type="text" readonly="readonly" name="maitrestage" id="maitrestage" value="<?php echo $MaitreStage->getNom() . ' ' . $MaitreStage->getPrenom() ?>"></input><br/>
    <label for="datedebut">Date debut :</label>
    <input type="text" readonly="readonly" name="datedebut" id="datedebut" value="<?php echo $DateDebut ?>"></input><br/>
    <label for="datefin">Date fin :</label>
    <input type="text" readonly="readonly" name="datefin" id="datefin" value="<?php echo $DateFin ?>"></input><br/>
</fieldset>

<fieldset>
    <legend>Informations complémentaire</legend>
    <label for="divers">Divers :</label>
    <input type="text" readonly="readonly" name="divers" id="divers" value="<?php echo $Divers ?>"></input><br/>

</fieldset>

<fieldset>
    <legend>Suivi</legend>
    <label for="professeur">Professeur :</label>
    <input type="text" readonly="readonly" name="professeur" id="professeur" value="<?php echo $Professeur->getNom() . ' ' . $Professeur->getPrenom() ?>"></input><br/>
    <label for="datevisite">Date visite :</label>
    <input type="text" readonly="readonly" name="datevisite" id="datevisite" value="<?php echo $DateVisite ?>"></input><br/>
</fieldset>

<br/>
<input type="button" value="Retour à la page d'ajout d'un stage" onclick="gotoUrl('.?controleur=utilisateur&action=ajoutStage')">
<br/>