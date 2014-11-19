<!-- cette page s'affiche lors de la réussite de la création d'une personne-->

<!--récupération des données de l'utilisateur créé-->
<?php
$idRole = $_POST['role'];

$role = new M_Role(null, null, null);

$daoRole = new M_DaoRole();
$daoRole->connecter();
$pdo = $daoRole->getPdo();
$role = $daoRole->selectOne($idRole);
//* récupération de toutes les données en rapport avec l'ID du rôle choisi dans la page de création d'une personne

$civilite = $_POST['civilite'];
$nom = $_POST['nom'];
$prenom = $_POST['prenom'];
$mail = $_POST['mail'];
$numTel = $_POST['tel'];
$mobile = $_POST['telP'];
$etudes = $_POST['etudes'];
$formation = $_POST['formation'];

$login = $_POST['login'];
$mdp = sha1($_POST['mdp']);

$specialite = new M_Specialite(null, null, null);

$idSpecialite = $_POST['option'];

$daoSpecialite = new M_DaoSpecialite();
$daoSpecialite->connecter();
$pdo = $daoSpecialite->getPdo();
$specialite = $daoSpecialite->selectOne($idSpecialite);
//* récupération de toutes les données en rapport avec l'ID de la spécialité choisie dans la page de création d'une personne
?>

<h1>La personne a bien été créée</h1>

<h2>Récapitulatif de ses informations personnelles</h2>

<fieldset>
    <legend>Type de compte</legend>
    <label for="role">Rôle :</label>
    <input type="text" readonly="readonly" name="role" id="role" value="<?php echo $role->getLibelle() ?>"></input><br/>
</fieldset>


<fieldset>
    <legend>Ses informations</legend>
    <label for="civilite">Civilité :</label>
    <input type="text" readonly="readonly" name="civilite" id="civilite" value="<?php echo $civilite ?>"></input><br/>
    <label for="nom">Nom :</label>
    <input type="text" name="nom" id="nom" readonly="readonly" value="<?php echo $nom ?>"></input><br/>
    <label for="prenom">Prénom :</label>
    <input type="prenom" name="prenom" id="mdp" readonly="readonly" value="<?php echo $prenom ?>"></input><br/>
    <label for="mail">E-Mail :</label>
    <input type="text" name="mail" id="mail" readonly="readonly" value="<?php echo $mail ?>"></input><br/>
    <label for="tel">Tel :</label>
    <input type="text" name="tel" id="tel" readonly="readonly" value="<?php echo $numTel ?>"></input><br/>
    <label for="tel">Tel portable:</label>
    <input type="text" name="telP" id="telP" readonly="readonly" value="<?php echo $mobile ?>"></input><br/>
</fieldset>


<fieldset>
    <legend>Informations spécifiques à l'étudiant</legend>
    <label for="etudes">Etudes :</label>
    <input type="text" readonly="readonly" name="etudes" id="etudes" value="<?php echo $etudes ?>"></input><br/>
    <label for="formation">Formation :</label>
    <input type="text" readonly="readonly" name="formation" id="formation" value="<?php echo $formation ?>"></input><br/>
    <label for="option">Specialité :</label>
    <input type="text" readonly="readonly" name="specialite" id="specialite" value="<?php echo $specialite->getLibellecCourt() ?>"></input><br/>
</fieldset>


<fieldset>
    <legend>Identifiant de connexion</legend>
    <label for="login">Login :</label>
    <input type="text" readonly="readonly" name="login" id="login" value="<?php echo $login ?>"></input><br/>
</fieldset>

<br/>

<input type="button" value="Retour à la page de création d'un utlisateur" onclick="gotoUrl('.?controleur=AdminPersonnes&action=creerPersonne')">
<br/>