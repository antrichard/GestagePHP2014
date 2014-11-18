<script language="JavaScript" type="text/javascript" src="../vues/javascript/fonctionsJavascript.inc.js"></script>
<script language="JavaScript" type="text/javascript" src="../bibliotheques/jquery.js"></script>
<script language="JavaScript" type="text/javascript" src=".../vues/javascript/ajax.inc.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
  $(function() {
    $( ".datepicker" ).datepicker();
  });
</script>

<!-- VARIABLES NECESSAIRES -->

<form method="post" action=".?controleur=Utilisateur&action=validationAjoutStage" name="AjoutStage">
    <h1>Ajouter un Stage</h1>
    <fieldset>
        <legend>informations étudiant</legend>
        <input type="hidden" readonly="readonly" name="id" id="id"></input>
        <label for="etudiant">Etudiant :</label>
        <select name="eleve" id="eleve">
            <option value=""></option>

            <?php
            // remplissage du "SELECT" qui contient les élèves
            foreach ($this->lireDonnee('lesEleves') as $eleve) {
                echo'<option value="' . $eleve->getId() . '">' . $eleve->getNom() . ' ' . $eleve->getPrenom() . '</option>';
            }
            ?>
        </select>
    </fieldset>

<fieldset>
        <legend>informations stage</legend>
        <label for="organisation">Organisation :</label>
        <select name="organisation" id="organisation">
            <option value=""></option>

            <?php
            // remplissage du "SELECT" qui contient les organisations
            foreach ($this->lireDonnee('lesOrganisations') as $organisation) {
                echo'<option value="' . $organisation->getId() . '">' . $organisation->getNom() . '</option>';
            }
            ?>
        </select>
        <label for="maitrestage">Maitre de stage :</label>
        <select OnChange="javascript:choixRole();"  name="role" id="role"><!-- le OnChange exécute la fonction qui affichera ou non le formulaire etudiant -->
        <option value=""></option>
        </select>
        <label for="ville">Ville :</label>
        <input type="text" name="ville" id="ville"></input><br/>
        <label for="datedebut">Date debut :</label>
        <input type="text" class="datepicker">
        <label for="datefin">Date fin :</label>
        <input type="text" class="datepicker">
        <label for="divers">Divers :</label>
        <input type="text" name="divers" id="divers"></input><br/>
    </fieldset>


    <fieldset>
        <legend>Suivi</legend>
        <label for="professeur">Professeur :</label>
        <select OnChange="javascript:choixRole();"  name="role" id="role"><!-- le OnChange exécute la fonction qui affichera ou non le formulaire etudiant -->
        <option value=""></option>
        </select>
        <label for="datevisite">Date visite :</label>
        <select OnChange="javascript:choixRole();"  name="role" id="role"><!-- le OnChange exécute la fonction qui affichera ou non le formulaire etudiant -->
        <option value=""></option>
        </select>
    </fieldset>

    <fieldset>
        <input type="submit" value="Creer" onclick="return valider()"></input><!-- OnClick éxécutera le JS qui testera tout les champ du formulaire. -->
        <input type="button" value="Retour" onclick="history.go(-1)">
    </fieldset>
</form>
<?php
// message de validation de création ou non 
if (isset($this->message)) {
    echo "<strong>" . $this->message . "</strong>";
}
?>
