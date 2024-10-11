package com.decentranotes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoteApp {
    private List<Note> notes = new ArrayList<>();

    public static void main(String[] args) {
        NoteApp app = new NoteApp();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. Create Note");
            System.out.println("2. View Notes");
            System.out.println("3. Update Note");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    app.createNote(scanner);
                    break;
                case 2:
                    app.viewNotes();
                    break;
                case 3:
                    app.updateNote(scanner);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void createNote (Scanner scanner) {
        try {
            System.out.print("Enter note title: ");
            String title = scanner.nextLine();
            System.out.print("Enter note content: ");
            String content = scanner.nextLine();
            Note note = new Note(Integer.toString(notes.size() + 1), title, content);
            notes.add(note);
            System.out.println("Note created!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to create note");
        }
    }

    private void viewNotes () {
        for (Note note : notes) {
            System.out.println(note);
        }
    }

    private void updateNote (Scanner scanner) {
        try {
            System.out.print("Enter note ID to update: ");
            String id = scanner.nextLine();
            for (Note note : notes) {
                if (note.getId().equals(id)) {
                    System.out.print("Enter new content: ");
                    String content = scanner.nextLine();
                    note.updateContent(content);
                    System.out.println("Note updated!");
                    return;
                }
            }
            System.out.println("Note not found");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to update note");
        }
    }
}
