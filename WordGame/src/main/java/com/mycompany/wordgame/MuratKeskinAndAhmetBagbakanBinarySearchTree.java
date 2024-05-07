/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wordgame;

import java.util.NoSuchElementException;

/**
 *
 * @author murat
 */
class MuratKeskinAndAhmetBagbakanBinarySearchTree {

    public MuratKeskinAndAhmetBagbakanBSTNode root;

    public MuratKeskinAndAhmetBagbakanBinarySearchTree() {
        root = null;
    }

    public boolean insertOrUpdate(String word, String fileName) {
        boolean isNewInsert = false;
        root = insertOrUpdate(root, word.toLowerCase(), fileName, isNewInsert);
        return isNewInsert;
    }

    private MuratKeskinAndAhmetBagbakanBSTNode insertOrUpdate(MuratKeskinAndAhmetBagbakanBSTNode node, String word, String fileName, boolean isNewInsert) {
        if (node == null) {
            MuratKeskinAndAhmetBagbakanMyLinkedList<MuratKeskinAndAhmetBagbakanFileCount> list = new MuratKeskinAndAhmetBagbakanMyLinkedList<>();
            list.addLast(new MuratKeskinAndAhmetBagbakanFileCount(fileName, 1));
            isNewInsert = true;
            return new MuratKeskinAndAhmetBagbakanBSTNode(word, list);
        } else if (node.word.equals(word)) {
            node.addOrUpdateFile(fileName);
            isNewInsert = false;
            return node;
        } else if (word.compareTo(node.word) < 0) {
            node.left = insertOrUpdate(node.left, word, fileName, isNewInsert);
        } else {
            node.right = insertOrUpdate(node.right, word, fileName, isNewInsert);
        }
        return node;
    }

    public MuratKeskinAndAhmetBagbakanMyLinkedList<String> collectWordsInOrder() {
        MuratKeskinAndAhmetBagbakanMyLinkedList<String> words = new MuratKeskinAndAhmetBagbakanMyLinkedList<>();
        inorderRec(root, words);
        return words;
    }

    private void inorderRec(MuratKeskinAndAhmetBagbakanBSTNode root, MuratKeskinAndAhmetBagbakanMyLinkedList<String> words) {
        if (root != null) {
            inorderRec(root.left, words);
            int totalFrequency = 0;
            for (MuratKeskinAndAhmetBagbakanFileCount fc : root.fileCounts) {
                totalFrequency += fc.count;
            }
            words.addLast(root.word + ", total frequency=" + totalFrequency);
            inorderRec(root.right, words);
        }
    }

    public MuratKeskinAndAhmetBagbakanMyLinkedList<String> collectWordsPreOrder() {
        MuratKeskinAndAhmetBagbakanMyLinkedList<String> words = new MuratKeskinAndAhmetBagbakanMyLinkedList<>();
        preorderRec(root, words);
        return words;
    }

    private void preorderRec(MuratKeskinAndAhmetBagbakanBSTNode root, MuratKeskinAndAhmetBagbakanMyLinkedList<String> words) {
        if (root != null) {
            // Calculate total frequency by manually summing up counts
            int totalFrequency = 0;
            for (MuratKeskinAndAhmetBagbakanFileCount fc : root.fileCounts) {
                totalFrequency += fc.count;
            }
            words.addLast(root.word + ", total frequency=" + totalFrequency);

            preorderRec(root.left, words);
            preorderRec(root.right, words);
        }
    }

    public MuratKeskinAndAhmetBagbakanMyLinkedList<String> collectWordsPostOrder() {
        MuratKeskinAndAhmetBagbakanMyLinkedList<String> words = new MuratKeskinAndAhmetBagbakanMyLinkedList<>();
        postorderRec(root, words);
        return words;
    }

    private void postorderRec(MuratKeskinAndAhmetBagbakanBSTNode root, MuratKeskinAndAhmetBagbakanMyLinkedList<String> words) {
        if (root != null) {
            postorderRec(root.left, words);
            postorderRec(root.right, words);

            // Calculate total frequency by manually summing up counts
            int totalFrequency = 0;
            for (MuratKeskinAndAhmetBagbakanFileCount fc : root.fileCounts) {
                totalFrequency += fc.count;
            }
            words.addLast(root.word + ", total frequency=" + totalFrequency);
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public MuratKeskinAndAhmetBagbakanMyLinkedList<String> searchFilesContainingWord(String searchWord) {
        return searchRec(root, searchWord.toLowerCase());
    }

    private MuratKeskinAndAhmetBagbakanMyLinkedList<String> searchRec(MuratKeskinAndAhmetBagbakanBSTNode root, String searchWord) {
        if (root == null) {

            throw new NoSuchElementException("Word not found in any files.");
        }
        if (searchWord.equals(root.word)) {

            MuratKeskinAndAhmetBagbakanMyLinkedList<String> fileDetails = new MuratKeskinAndAhmetBagbakanMyLinkedList<>();
            for (MuratKeskinAndAhmetBagbakanFileCount fc : root.fileCounts) {
                fileDetails.addLast(fc.fileName + " (frequency=" + fc.count + ")");
            }
            return fileDetails;
        } else if (searchWord.compareTo(root.word) < 0) {

            return searchRec(root.left, searchWord);
        } else {

            return searchRec(root.right, searchWord);
        }
    }
}
