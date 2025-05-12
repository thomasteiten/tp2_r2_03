import java.util.ArrayList;

class Tavalier extends Piece {

    public Tavalier() {
        super('B', new Position());
    }

    public Tavalier(char couleur, Position position) {
        super(couleur, position);
    }

    public String getType() {
        return "tavalier";
    }

    public ArrayList<Position> getDeplacementPossible(Plateau pl) {
        ArrayList<Position> liste = new ArrayList<>();

        // Ajout des déplacements de la Tour
        int positionDepartX = this.getPosition().getX();
        int positionDepartY = this.getPosition().getY();

        // Vers le bas
        boolean obstacle = false;
        int indiceX = positionDepartX;
        int indiceY = positionDepartY - 1;
        while (!obstacle && indiceY >= 0) {
            Piece pi = pl.getCase(indiceX, indiceY);
            if (pi == null)
                liste.add(new Position(indiceX, indiceY));
            else {
                obstacle = true;
                if (pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(indiceX, indiceY));
            }
            indiceY--;
        }
        // Vers le haut
        obstacle = false;
        indiceX = positionDepartX;
        indiceY = positionDepartY + 1;
        while (!obstacle && indiceY <= 7) {
            Piece pi = pl.getCase(indiceX, indiceY);
            if (pi == null)
                liste.add(new Position(indiceX, indiceY));
            else {
                obstacle = true;
                if (pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(indiceX, indiceY));
            }
            indiceY++;
        }

        // Vers la gauche
        obstacle = false;
        indiceX = positionDepartX - 1;
        indiceY = positionDepartY;
        while (!obstacle && indiceX >= 0) {
            Piece pi = pl.getCase(indiceX, indiceY);
            if (pi == null)
                liste.add(new Position(indiceX, indiceY));
            else {
                obstacle = true;
                if (pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(indiceX, indiceY));
            }
            indiceX--;
        }

        // Vers la droite
        obstacle = false;
        indiceX = positionDepartX + 1;
        indiceY = positionDepartY;
        while (!obstacle && indiceX <= 7) {
            Piece pi = pl.getCase(indiceX, indiceY);
            if (pi == null)
                liste.add(new Position(indiceX, indiceY));
            else {
                obstacle = true;
                if (pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(indiceX, indiceY));
            }
            indiceX++;
        }

        // Ajout des déplacements du Cavalier
        int[][] mouvementsCavalier = {
                {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
                {1, -2}, {1, 2}, {2, -1}, {2, 1}
        };

        for (int[] mouvement : mouvementsCavalier) {
            int x = positionDepartX + mouvement[0];
            int y = positionDepartY + mouvement[1];
            if (x >= 0 && x < 8 && y >= 0 && y < 8) {
                Piece pi = pl.getCase(x, y);
                if (pi == null || pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(x, y));
            }
        }

        return liste;
    }
}
