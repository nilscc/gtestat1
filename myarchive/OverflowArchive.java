package myarchive;

import wsiarchive.*;


// Archiv, bei dem erst ein Archiv vollgeschrieben wird, dann das nächste etc.
public class OverflowArchive implements IArchive {

    // Die Archive werden der Reihe nach gefüllt
    public OverflowArchive(String name, IArchiveList archives) {
    }

}
