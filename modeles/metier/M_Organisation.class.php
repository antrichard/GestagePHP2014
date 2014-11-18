<?php

/**
 * Description of M_Role
 *
 * @author btssio
 */
class M_Organisation {

    private $id; // type : int
    private $nom; // type : chaîne de caractères
    private $ville; //type : chaîne de caractères
    private $adresse; //type : chaîne de caractères
    private $cp; //type : chaîne de caractères
    private $tel; //type : chaîne de caractères
    private $fax; //type : chaîne de caractères
    private $formeJuridique; //type : chaîne de caractères
    private $activite; //type : chaîne de caractères

    function __construct($id, $nom, $ville, $adresse, $cp, $tel, $fax, $formeJuridique, $activite) {
        $this->id = $id;
        $this->nom = $nom;
        $this->ville = $ville;
        $this->adresse = $adresse;
        $this->cp = $cp;
        $this->tel = $tel;
        $this->fax = $fax;
        $this->formeJuridique = $formeJuridique;
        $this->activite = $activite;
    }

    public function getId() {
        return $this->id;
    }

    public function getNom() {
        return $this->nom;
    }

    public function getVille() {
        return $this->ville;
    }

    public function getAdresse() {
        return $this->adresse;
    }

    public function getCp() {
        return $this->cp;
    }

    public function getTel() {
        return $this->tel;
    }

    public function getFax() {
        return $this->fax;
    }

    public function getFormeJuridique() {
        return $this->formeJuridique;
    }

    public function getActivite() {
        return $this->activite;
    }

    public function setId($id) {
        $this->id = $id;
    }

    public function setNom($nom) {
        $this->nom = $nom;
    }

    public function setVille($ville) {
        $this->ville = $ville;
    }

    public function setAdresse($adresse) {
        $this->adresse = $adresse;
    }

    public function setCp($cp) {
        $this->cp = $cp;
    }

    public function setTel($tel) {
        $this->tel = $tel;
    }

    public function setFax($fax) {
        $this->fax = $fax;
    }

    public function setFormeJuridique($formeJuridique) {
        $this->formeJuridique = $formeJuridique;
    }

    public function setActivite($activite) {
        $this->activite = $activite;
    }

}
