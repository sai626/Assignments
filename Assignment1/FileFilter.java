package Assignment1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by zemoso on 7/7/17.
 */
public class FileFilter {

    private Pattern pattern;
    private Queue<File> folders=new LinkedList<>();
    private List<File> files=new ArrayList<>();


    /**
     * This adds Files to the list which matches the pattern.
     * @param directory The parent directory
     */
    private void addFiles(File directory){
        File[] fileList= directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                //System.out.println(pattern.matcher(name).matches());
                return pattern.matcher(name).matches();
            }
        });

        if(fileList!=null && fileList.length>0) {
            files.addAll(Arrays.asList(fileList));
        }
    }

    /**
     * This adds all the Folders present under the specified directory to the Queue.
     * @param directory The parent directory
     */
    private void addFolders(File directory){
        File[] folderList= directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir,name).isDirectory();
            }
        });

        if(folderList!=null && folderList.length>0) {
            folders.addAll(Arrays.asList(folderList));
        }
    }

    /**
     * This function recursively enters all the folders and add the files which match the pattern to the
     * file list. It keeps a queue of folders which needs to be searched and then searches them in order
     * of their discovery. As soon as a file matches the pattern it adds this to the list and prints them
     * at the last.
     * @param regex The regular expression which is used to filter the files
     */
    public void displayFiles(String regex){
        pattern=Pattern.compile(regex);
        File home=new File("/home/zemoso/");

        folders.clear();
        files.clear();

        addFolders(home);
        addFiles(home);

        File current;
        while (!folders.isEmpty()){
            current=folders.remove();
            addFolders(current);
            addFiles(current);
        }

        for(File f:files){
            System.out.println(f.getAbsolutePath());
        }
    }
}
