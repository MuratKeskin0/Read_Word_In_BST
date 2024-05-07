package com.mycompany.wordgame;


class MuratKeskinAndAhmetBagbakanBSTNode {

    String word;
    MuratKeskinAndAhmetBagbakanMyLinkedList<MuratKeskinAndAhmetBagbakanFileCount> fileCounts;
    MuratKeskinAndAhmetBagbakanBSTNode left;
    MuratKeskinAndAhmetBagbakanBSTNode right;

    public MuratKeskinAndAhmetBagbakanBSTNode(String word, MuratKeskinAndAhmetBagbakanMyLinkedList<MuratKeskinAndAhmetBagbakanFileCount> fileCounts) {
        this.word = word;
        this.fileCounts = fileCounts;
        this.left = null;
        this.right = null;
    }

      public void addOrUpdateFile(String fileName) {
        boolean found = false;
        for (MuratKeskinAndAhmetBagbakanFileCount fc : fileCounts) {
            if (fc.fileName.equals(fileName)) {
                fc.count++;
                found = true;
                break;
            }
        }
        if (!found) {
            fileCounts.addLast(new MuratKeskinAndAhmetBagbakanFileCount(fileName, 1));
        }
    }
    
}
