import java.util.ArrayList;

class Favalier extends Piece {

    public Favalier(){
        super('B', new Position());
    }

    public Favalier(char couleur, Position position){
        super(couleur, position);
    }

    public String getType() {
        return "favalier";
    }

    public ArrayList<Position> getDeplacementPossible(Plateau pl) {
        ArrayList<Position> liste = new ArrayList<>();
        Cavalier c = new Cavalier(this.getCouleur(), this.getPosition());
        liste.addAll(c.getDeplacementPossible(pl));

        Fou f = new Fou(this.getCouleur(), this.getPosition());
        liste.addAll(f.getDeplacementPossible(pl));

        return liste;
    }
    
}