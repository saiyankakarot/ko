import java.util.*;
class TrieNode{
    boolean ending;
    TrieNode[] children =new TrieNode[26];
}
public class trie {
    static void insert(String word,TrieNode root) {
        int n = word.length();
        TrieNode workingNode = root;
        for(int i = 0; i< n ;i++) {
            int index = word.charAt(i)-'a';
            TrieNode temp;
            if(workingNode.children[index]==null)
                temp = new TrieNode(); // or it could be a new node
            else
                temp = workingNode.children[index];
            workingNode.children[index] = temp; //this temp could be existing node
            if(i == n-1)temp.ending = true;
            workingNode = temp;
        }
    }
    static boolean search(String word,TrieNode root) {
        int n = word.length();
        TrieNode workingNode = root;
        for(int i  = 0;i < n; i++) {
            int index = word.charAt(i)-'a';
            if(workingNode.children[index]==null)
                return false;
            workingNode = workingNode.children[index];
        }
        return workingNode.ending;
    }
    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        // a - c = 2
        // System.out.println('c'-'a');
        insert("code",root);
        insert("anime",root);
        insert("dbz",root);
        insert("coding",root);
        //  System.out.println(root.children['c'-'a']
        //    .children['o'-'a']
        // .children['d'-'a']
        // .children['e'-'a']
        //  .children['i'-'a']
        //   .children['n'-'a']
        //     .children['g'-'a']);
        // if we add here ending before this .children completes, it will return false,and after this code word completed.
        System.out.println(search("cod",root));
        System.out.println(search("anime",root));
        System.out.println(search("dbz",root));
        System.out.println(search("codin",root));
        //here we wrote some words wrong,to see which one shows true and false
        // then we can add .ending it will show true
        //and if it shows an address, then it means there is a node
    }
}
