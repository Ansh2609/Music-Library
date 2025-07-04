//Name: Ansh Sapra
//ID: 501165072

import java.util.ArrayList;

/*
 * An AudioBook is a type of AudioContent.
 * It is a recording made available on the internet of a book being read aloud by a narrator
 * 
 */
public class AudioBook extends AudioContent
{
	public static final String TYPENAME =	"AUDIOBOOK";
	
	private String author; 
	private String narrator;
	private ArrayList<String> chapterTitles;
	private ArrayList<String> chapters;
	private int currentChapter = 0;

	
	public AudioBook(String title, int year, String id, String type, String audioFile, int length,
									String author, String narrator, ArrayList<String> chapterTitles, ArrayList<String> chapters)
	{
		super(title, year, id, type, audioFile, length);// We use the constructor in the super class AudioContent.
		// To Initialize additional AudioBook instance variables. 
		this.author = author;
		this.narrator = narrator;
		this.chapterTitles = chapterTitles;
		this.chapters = chapters;
	}
	
	public String getType()
	{
		return TYPENAME;
	}

  	// Print information about the audiobook. First print the basic info of the AudioContent by using the printInfo() method in superclass AudioContent and then print the author name  and narrator name
	
	public void printInfo()
	{
		super.printInfo(); //printing the basic info from super class
		System.out.println("Author: " + author + " Narrated by: " + narrator);
	}
	
 	// Play the audiobook by setting the audioFile to the current chapter title (from chapterTitles array list) 
	// followed by the current chapter (from chapters array list)
	// Then make use of the the play() method of the superclass
	public void play() // method called play used to play audiobooks
	{
		super.setAudioFile(chapterTitles.get(currentChapter) +".\n"+ chapters.get(currentChapter) );
		super.play();
	}
	
	// Print the table of contents of the book - i.e. the list of chapter titles
	// See the video
	public void printTOC()// printing table of contents of the book
	{
		for(int i=0;i<chapterTitles.size();i++){ //looping through the chapterTitles list and printing titles of the chapters in this audiobook
			System.out.println("Chapter " + (i+1) + ". " + chapterTitles.get(i) + "\n");
		}
	}

	// Select a specific chapter to play
	public void selectChapter(int chapter)
	{
		if (chapter >= 1 && chapter <= chapters.size())
		{
			currentChapter = chapter - 1;
		}
	}
	
	//Two AudioBooks are equal if their AudioContent information is equal and both the author and narrators are equal
	public boolean equals(Object other) // check weather two audiobooks are equal by checking if their info is equal or not
	{
		AudioBook peace = (AudioBook)other;
		return super.equals(peace) && this.author.equals((peace.author)) && this.narrator.equals(peace.narrator);
	}
	
	public int getNumberOfChapters()
	{
		return chapters.size();
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public String getNarrator()
	{
		return narrator;
	}

	public void setNarrator(String narrator)
	{
		this.narrator = narrator;
	}

	public ArrayList<String> getChapterTitles()
	{
		return chapterTitles;
	}

	public void setChapterTitles(ArrayList<String> chapterTitles)
	{
		this.chapterTitles = chapterTitles;
	}

	public ArrayList<String> getChapters()
	{
		return chapters;
	}

	public void setChapters(ArrayList<String> chapters)
	{
		this.chapters = chapters;
	}

}
