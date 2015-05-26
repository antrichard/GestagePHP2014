package com.ppe2groupe8.gestageandroid;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;

import android.util.Log;
import android.util.Xml;
/**
 * Lecteur de ressources XML distantes (liste des classes, des années scolaires, des élèves et détails d'un stage)  
 *
 */
public class UtilWorldXml {
  
  public UtilWorldXml() {
  }

  /**
   * Obtient une liste de classes à partir d'un flux XML via une ressource web (http)
   * @param urlXmlressource l'url à solliciter
   * @param defaultContent un contenu par défaut si chargement impossible
   * @param dest liste d'instance de Classe à valoriser (par classe, seuls l'id et le nom sont valorisés) 
   */
  	  
  static public void parseListeClasses(String urlXmlressource, String defaultContent, ArrayList<Classe> dest) {
		  XmlPullParser parser = Xml.newPullParser();    
	  try {

      // auto-detect the encoding from the stream
      parser.setInput(getInputStream(urlXmlressource, defaultContent), null);

      int eventType = parser.getEventType();
      Classe currentClasse = null;
      boolean done = false;
      while (eventType != XmlPullParser.END_DOCUMENT && !done) {
        String name = null;
        switch (eventType) {
        case XmlPullParser.START_TAG:
          name = parser.getName();
          if (name.equalsIgnoreCase("classe")) {
        	  currentClasse = new Classe();
          } else if (currentClasse != null) {
            if (name.equalsIgnoreCase("numClasse")) {
            	currentClasse.setNumClasse(parser.nextText());
            } else if (name.equalsIgnoreCase("nomClasse")) {
            	currentClasse.setNomClasse(parser.nextText());
            }
          }
          break;
        case XmlPullParser.END_TAG:
          name = parser.getName();
          // si fin de balise classe, on ajoute l'objet dans la liste
          if (name.equalsIgnoreCase("classe") && currentClasse != null) {
            Log.i("ajout classe : ", currentClasse.toString());
            dest.add(currentClasse);
          }
          // fin de classe ?
          else if (name.equalsIgnoreCase("lesclasses")) {
            // oui, on signe l'arrêt de la boucle
            done = true;
          }
          break;
        }
        // avance dans le flux
        eventType = parser.next();
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Obtient une liste d'année scolaire à partir d'un flux XML via une ressource web (http)
   * @param urlXmlressource l'url Ã  solliciter
   * @param defaultContent un contenu par dÃ©faut si chargement impossible
   * @param dest liste d'instance de AnneeScol à valoriser (par année scolaire, seuls l'id et le nom sont valorisés) 
   */
    
  static public void parseListeAnneeScol(String urlXmlressource, String defaultContent, ArrayList<AnneeScol> dest) {
	  XmlPullParser parser = Xml.newPullParser();
    try {

  // auto-detect the encoding from the stream
  parser.setInput(getInputStream(urlXmlressource, defaultContent), null);

  int eventType = parser.getEventType();
  AnneeScol currentAnneeScol = null;
  boolean done = false;
  while (eventType != XmlPullParser.END_DOCUMENT && !done) {
    String name = null;
    switch (eventType) {
    case XmlPullParser.START_TAG:
      name = parser.getName();
      if (name.equalsIgnoreCase("anneeScol")) {
    	  currentAnneeScol = new AnneeScol();
      } else if (currentAnneeScol != null) {
        if (name.equalsIgnoreCase("anneeScol")) {
        	currentAnneeScol.setAnneeScol(parser.nextText());
        }
      }
      break;
    case XmlPullParser.END_TAG:
      name = parser.getName();
      // si fin de balise country, on ajoute l'objet dans la liste
      if (name.equalsIgnoreCase("anneeScol") && currentAnneeScol != null) {
        Log.i("ajout anneeScol : ", currentAnneeScol.toString());
        dest.add(currentAnneeScol);
      }
      // fin de countries ?
      else if (name.equalsIgnoreCase("lesannneesscol")) {
        // oui, on signe l'arrÃªt de la boucle
        done = true;
      }
      break;
    }
    // avance dans le flux
    eventType = parser.next();
  }
} catch (Exception e) {
  throw new RuntimeException(e);
}
}
  
  /**
   * Obtient une liste de élèves à partir d'un flux XML via une ressource web (http)
   * @param urlXmlressource l'url à solliciter
   * @param defaultContent un contenu par défaut si chargement impossible
   * @param dest liste d'instance de Personne à valoriser (par élève, seuls l'id et le nom et le prénom sont valorisés) 
   */

  static public void parseListePersonnes(String urlXmlressource, String defaultContent, ArrayList<Personne> dest) {
		  XmlPullParser parser = Xml.newPullParser();    
	  try {

      // auto-detect the encoding from the stream
      parser.setInput(getInputStream(urlXmlressource, defaultContent), null);

      int eventType = parser.getEventType();
      Personne currentPersonne = null;
      boolean done = false;
      while (eventType != XmlPullParser.END_DOCUMENT && !done) {
        String name = null;
        switch (eventType) {
        case XmlPullParser.START_TAG:
          name = parser.getName();
          if (name.equalsIgnoreCase("personne")) {
        	  currentPersonne = new Personne();
          } else if (currentPersonne != null) {
        	  if (name.equalsIgnoreCase("idPersonne")) {
              	currentPersonne.setIdPersonne(parser.next());
        	} else if (name.equalsIgnoreCase("numClasse")) {
            	currentPersonne.setIdRole(parser.next());
            } else if (name.equalsIgnoreCase("nomPersonne")) {
            	currentPersonne.setNom(parser.nextText());
            } else if (name.equalsIgnoreCase("prenomPersonne")) {
            	currentPersonne.setPrenom(parser.nextText());
            } else if (name.equalsIgnoreCase("loginUtilisateur")) {
            	currentPersonne.setLoginUtilisateur(parser.nextText());
            } else if (name.equalsIgnoreCase("mdpUtilisateur")) {
            	currentPersonne.setMdpUtilisateur(parser.nextText());
            }
          }
          break;
        case XmlPullParser.END_TAG:
          name = parser.getName();
          // si fin de balise classe, on ajoute l'objet dans la liste
          if (name.equalsIgnoreCase("personne") && currentPersonne != null) {
            Log.i("ajout personne : ", currentPersonne.toString());
            dest.add(currentPersonne);
          }
          // fin de classe ?
          else if (name.equalsIgnoreCase("lespersonnes")) {
            // oui, on signe l'arrêt de la boucle
            done = true;
          }
          break;
        }
        // avance dans le flux
        eventType = parser.next();
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
  
  
  /**
   * Obtient une liste de stages à partir d'un flux XML via une ressource web (http)
   * @param urlXmlressource l'url à solliciter
   * @param defaultContent un contenu par défaut si chargement impossible
   * @param dest liste d'instance de Stage à valoriser (par élève ; l'id, le nom et le prénom de l'etudiant, nomOrganisation,
   *  adresseOrganisation, villeOrganisation, maitreStage, dateDebut, dateFin, dateVisiteStage sont valorisés)
   */
  
  static public void parseListeStages(String urlXmlressource, String defaultContent, ArrayList<Stage> dest) {
	  XmlPullParser parser = Xml.newPullParser();    
  try {

  // auto-detect the encoding from the stream
  parser.setInput(getInputStream(urlXmlressource, defaultContent), null);

  int eventType = parser.getEventType();
  Stage currentStage = null;
  boolean done = false;
  while (eventType != XmlPullParser.END_DOCUMENT && !done) {
    String name = null;
    switch (eventType) {
    case XmlPullParser.START_TAG:
      name = parser.getName();
      if (name.equalsIgnoreCase("stage")) {
    	  currentStage = new Stage();
      } else if (currentStage != null) {
        if (name.equalsIgnoreCase("numStage")) {
        	currentStage.setNum_stage(parser.next());
        } else if (name.equalsIgnoreCase("nomEtudiant")) {
        	currentStage.setNomEtudiant(parser.nextText());
        } else if (name.equalsIgnoreCase("prenomEtudiant")) {
        	currentStage.setPrenomEtudiant(parser.nextText());
        } else if (name.equalsIgnoreCase("nomOrganisation")) {
        	currentStage.setNomOrganisation(parser.nextText());
        } else if (name.equalsIgnoreCase("adresseOrganisation")) {
        	currentStage.setAdresseOrganisation(parser.nextText());
        } else if (name.equalsIgnoreCase("villeOrganisation")) {
        	currentStage.setVilleOrganisation(parser.nextText());
        } else if (name.equalsIgnoreCase("nomMaitreStage")) {
        	currentStage.setNomMaitreStage(parser.nextText());
        } else if (name.equalsIgnoreCase("prenomMaitreStage")) {
        	currentStage.setPrenomMaitreStage(parser.nextText());
        } else if (name.equalsIgnoreCase("dateDebut")) {
        	currentStage.setDateDebut(parser.nextText());
        } else if (name.equalsIgnoreCase("dateFin")) {
        	currentStage.setDateFin(parser.nextText());
        } else if (name.equalsIgnoreCase("dateVisiteStage")) {
        	currentStage.setDateVisiteStage(parser.nextText());
        }
      }
      break;
    case XmlPullParser.END_TAG:
      name = parser.getName();
      // si fin de balise classe, on ajoute l'objet dans la liste
      if (name.equalsIgnoreCase("classe") && currentStage != null) {
        Log.i("ajout stage : ", currentStage.toString());
        dest.add(currentStage);
      }
      // fin de classe ?
      else if (name.equalsIgnoreCase("lesclasses")) {
        // oui, on signe l'arrêt de la boucle
        done = true;
      }
      break;
    }
    // avance dans le flux
    eventType = parser.next();
  }
} catch (Exception e) {
  throw new RuntimeException(e);
}
}
  
  static private InputStream getInputStream(String strUrl, String defaulContent) {
    InputStream res = null;
    try {
      Log.i("url", strUrl);			// affichage dans la fenêtre LogCat
      URL url = new URL(strUrl);
      URLConnection urlConnection = url.openConnection();
      res = urlConnection.getInputStream();
//      res = url.openConnection().getInputStream();
    } catch (Exception e) {
      Log.d("Erreur de lecture", strUrl + ":"+ e.getMessage());
    }
    if (res == null)
      // retourne quelque chose tout de mÃªme...
      res = new ByteArrayInputStream(defaulContent.getBytes());
    return res;
  }


  
}
