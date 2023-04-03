package Entities.Exo2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Formation
{
    private int idFormation;
    private String nomFormation;
    private int prixFormation;
    private String AjouterParticipant;
    private int NombredePresent;


    private ArrayList<Participant> lesParticipants;

    public Formation(int idFormation, String nomFormation, int prixFormation) {
        this.idFormation = idFormation;
        this.nomFormation = nomFormation;
        this.prixFormation = prixFormation;
        this.lesParticipants = new ArrayList<>();
        this.AjouterParticipant = AjouterParticipant;
        this.NombredePresent = NombredePresent;

    }

    public void AjouterParticipant(Participant unParticipant)
    {
        lesParticipants.add(unParticipant);
    }

    // Cette méthode permet de compter le nombre de participants
    // réellement présents à la formation.
    public int GetNombreDePresents(List<Participant> participants)
    {
        int nombredePresent = 0;


        for (Participant participant : participants) {
            if (participant.isEstPresent()) {
                nombredePresent++;
            }
        }



        return nombredePresent;
    }

    // Cette méthode permet de calculer le montant total
    // des frais kilométriques versés pour une formation
    // en ne prenant en compte que les participants présents.
    // On rembourse 1.89 du KM
    public double CalculerFraisRemboursementKilometriques(List<Participant> participants)
    {
        double montantTotal = 0.0;
        double tauxRemboursement = 1.89;

        for (Participant participant : participants){
            if (participant.isEstPresent()){
                double FraisKilométrique = participant.getNbKm()* tauxRemboursement;
                montantTotal+= FraisKilométrique;
            }
        }

        return montantTotal;
    }

    // Cette méthode permet de calculer le taux de présence
    // par rapport au nombre d'inscrits
    public double TauxDePresence(List<Participant> participants)
    {
        int NombreInscrits = participants.size();
        int nombrePresent = 0;

        for (Participant participant : participants){
            if (participant.isEstPresent()){
                nombrePresent++;
            }
        }

        double tauxdePresence = (double) nombrePresent / NombreInscrits * 100.0;
        return tauxdePresence;
    }

    // Cette méthode permet de calculer le bénéfice de la formation.
    // Ce dernier se détermine en multipliant le nombre de présents par le prix de la formation moins
    // les frais kilométriques versés
    public double BeneficeFormation(List<Participant> participants)
    {
        // A compléter ici
        return  0;
    }
}
