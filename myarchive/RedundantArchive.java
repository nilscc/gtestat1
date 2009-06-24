package myarchive;

import wsiarchive.*;


// Redundantes Archiv, das in mehrere Unterarchive gleichzeitig schreibt
public class RedundantArchive implements IArchive {

    // Das Quorum sagt, auf wievielen Unterarchiven der Schreibvorgang
    // erfolgreich sein muss, damit der Gesamtschreibvorgang erfolgreich ist.
    public RedundantArchive(String name, IArchiveList archives, int quorum) {
    }

}
