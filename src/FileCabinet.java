import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FileCabinet implements Cabinet {
    private List<Folder> folders;
    private MultiFolder multiFolder;


    @Override
    public Optional<Folder> findFolderByName(String name) {
        Folder retriveFolderByName = null;

        for (Folder folder : folders) {
            if (folder.getName() == name){
                retriveFolderByName = folder;
            }
        }
        return Optional.ofNullable(retriveFolderByName);
    }


    @Override
    public List<Folder> findFoldersBySize(String size) {

        List<Folder> foldersBySize = folders.stream()
                .filter(folder -> folder.getSize().equals(size))
                .collect(Collectors.toList());

        return foldersBySize;
    }

    @Override
    public int count() {
        return multiFolder.getFolders().size();
    }
}