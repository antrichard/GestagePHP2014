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

<!-- $this->message : à afficher sous le formulaire -->
<form method="post" action=".?controleur=AdminPersonnes&action=validationCreerPersonne" name="CreateUser">
    <h1>Ajouter un Stage</h1>
    <!-- Choix du type de compte pour afficher les différentes informations pour créer un compte spécifique -->
<!--    <fieldset>

        <input type="hidden" readonly="readonly" name="id" id="id"></input>
        <label for="libelle">Libellé :</label>
        <input type="text" name="nom" id="nom"></input><br/>

    </fieldset>-->




    <fieldset>
        <legend>informations étudiant</legend>
        <input type="hidden" readonly="readonly" name="id" id="id"></input>
        <label for="etudiant">Etudiant :</label>
        <select OnChange="javascript:choixRole();"  name="role" id="role"><!-- le OnChange exécute la fonction qui affichera ou non le formulaire etudiant -->
            <option value=""></option>
        </select>
    </fieldset>
    
    <fieldset>
        <legend>informations stage</legend>
        <label for="organisation">Organisation :</label>
        <select OnChange="javascript:choixRole();"  name="role" id="role"><!-- le OnChange exécute la fonction qui affichera ou non le formulaire etudiant -->
        <option value=""></option>
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






    <!-- Information nécessaire uniquement aux maitre de stage -->

    <div id="Formulaire_MaitreStage" style="display:none" height="0">
        <fieldset>
            <legend>Choisir l'entreprise :</legend>

            <label for="login">Entreprise :</label>
            <select type ="select" name="entreprise1" id="entreprise1"><!--selecte de choix d'entreprise-->
                <option value=""></option>

                <?php
//                foreach ($this->lesEntreprise as $LesEntreprise) { // boucle d'affichage de toute les entreprise
//                    // création d'une ligne du selecte 
//                    echo'<option value="' . $LesEntreprise->IDORGANISATION . '">' . $LesEntreprise->NOM_ORGANISATION . '</option>';
//                }
                ?>    
            </select> 

        </fieldset>

    </div>

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