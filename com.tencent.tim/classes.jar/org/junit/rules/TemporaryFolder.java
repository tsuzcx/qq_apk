package org.junit.rules;

import java.io.File;
import java.io.IOException;

public class TemporaryFolder
  extends ExternalResource
{
  private File folder;
  private final File parentFolder;
  
  public TemporaryFolder()
  {
    this(null);
  }
  
  public TemporaryFolder(File paramFile)
  {
    this.parentFolder = paramFile;
  }
  
  private File createTemporaryFolderIn(File paramFile)
    throws IOException
  {
    paramFile = File.createTempFile("junit", "", paramFile);
    paramFile.delete();
    paramFile.mkdir();
    return paramFile;
  }
  
  private boolean isLastElementInArray(int paramInt, String[] paramArrayOfString)
  {
    return paramInt == paramArrayOfString.length - 1;
  }
  
  private void recursiveDelete(File paramFile)
  {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        recursiveDelete(arrayOfFile[i]);
        i += 1;
      }
    }
    paramFile.delete();
  }
  
  private void validateFolderName(String paramString)
    throws IOException
  {
    if (new File(paramString).getParent() != null) {
      throw new IOException("Folder name cannot consist of multiple path components separated by a file separator. Please use newFolder('MyParentFolder','MyFolder') to create hierarchies of folders");
    }
  }
  
  protected void after()
  {
    delete();
  }
  
  protected void before()
    throws Throwable
  {
    create();
  }
  
  public void create()
    throws IOException
  {
    this.folder = createTemporaryFolderIn(this.parentFolder);
  }
  
  public void delete()
  {
    if (this.folder != null) {
      recursiveDelete(this.folder);
    }
  }
  
  public File getRoot()
  {
    if (this.folder == null) {
      throw new IllegalStateException("the temporary folder has not yet been created");
    }
    return this.folder;
  }
  
  public File newFile()
    throws IOException
  {
    return File.createTempFile("junit", null, getRoot());
  }
  
  public File newFile(String paramString)
    throws IOException
  {
    File localFile = new File(getRoot(), paramString);
    if (!localFile.createNewFile()) {
      throw new IOException("a file with the name '" + paramString + "' already exists in the test folder");
    }
    return localFile;
  }
  
  public File newFolder()
    throws IOException
  {
    return createTemporaryFolderIn(getRoot());
  }
  
  public File newFolder(String paramString)
    throws IOException
  {
    return newFolder(new String[] { paramString });
  }
  
  public File newFolder(String... paramVarArgs)
    throws IOException
  {
    File localFile = getRoot();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      String str = paramVarArgs[i];
      validateFolderName(str);
      localFile = new File(localFile, str);
      if ((!localFile.mkdir()) && (isLastElementInArray(i, paramVarArgs))) {
        throw new IOException("a folder with the name '" + str + "' already exists");
      }
      i += 1;
    }
    return localFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.rules.TemporaryFolder
 * JD-Core Version:    0.7.0.1
 */