public class Library {
    private String libraryName;

    public Library(String libraryName){
        this.libraryName = libraryName;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void displayInfo() {
        System.out.println("Library: " + libraryName);
    }
}

