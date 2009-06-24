package myarchive;

import wsiarchive.*;

// Archiv, das nach Prädikaten entscheidet, in welches Teilarchiv geschrieben wird.
public class SemanticArchive implements IArchive {

    // Die Archive in archivesAndPredicates werden der Reihe nach durchprobiert;
    // wenn kein Prädikat passt, wird in das Archiv standard geschrieben.
    public SemanticArchive(String name,
                           IArchiveAndPredicateList archivesAndPredicates,
                           IArchive standard) {
    }

}
