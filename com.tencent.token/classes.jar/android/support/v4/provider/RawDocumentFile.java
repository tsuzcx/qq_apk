package android.support.v4.provider;

import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class RawDocumentFile
  extends DocumentFile
{
  private File mFile;
  
  RawDocumentFile(DocumentFile paramDocumentFile, File paramFile)
  {
    super(paramDocumentFile);
    this.mFile = paramFile;
  }
  
  private static boolean deleteContents(File paramFile)
  {
    paramFile = paramFile.listFiles();
    boolean bool1 = true;
    if (paramFile != null)
    {
      int j = paramFile.length;
      int i = 0;
      bool1 = true;
      while (i < j)
      {
        File localFile = paramFile[i];
        boolean bool2 = bool1;
        if (localFile.isDirectory()) {
          bool2 = bool1 & deleteContents(localFile);
        }
        bool1 = bool2;
        if (!localFile.delete())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Failed to delete ");
          localStringBuilder.append(localFile);
          Log.w("DocumentFile", localStringBuilder.toString());
          bool1 = false;
        }
        i += 1;
      }
    }
    return bool1;
  }
  
  private static String getTypeForName(String paramString)
  {
    int i = paramString.lastIndexOf('.');
    if (i >= 0)
    {
      paramString = paramString.substring(i + 1).toLowerCase();
      paramString = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
      if (paramString != null) {
        return paramString;
      }
    }
    return "application/octet-stream";
  }
  
  public boolean canRead()
  {
    return this.mFile.canRead();
  }
  
  public boolean canWrite()
  {
    return this.mFile.canWrite();
  }
  
  public DocumentFile createDirectory(String paramString)
  {
    paramString = new File(this.mFile, paramString);
    if ((!paramString.isDirectory()) && (!paramString.mkdir())) {
      return null;
    }
    return new RawDocumentFile(this, paramString);
  }
  
  public DocumentFile createFile(String paramString1, String paramString2)
  {
    String str = MimeTypeMap.getSingleton().getExtensionFromMimeType(paramString1);
    paramString1 = paramString2;
    if (str != null)
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append(".");
      paramString1.append(str);
      paramString1 = paramString1.toString();
    }
    paramString1 = new File(this.mFile, paramString1);
    try
    {
      paramString1.createNewFile();
      paramString1 = new RawDocumentFile(this, paramString1);
      return paramString1;
    }
    catch (IOException paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("Failed to createFile: ");
      paramString2.append(paramString1);
      Log.w("DocumentFile", paramString2.toString());
    }
    return null;
  }
  
  public boolean delete()
  {
    deleteContents(this.mFile);
    return this.mFile.delete();
  }
  
  public boolean exists()
  {
    return this.mFile.exists();
  }
  
  public String getName()
  {
    return this.mFile.getName();
  }
  
  public String getType()
  {
    if (this.mFile.isDirectory()) {
      return null;
    }
    return getTypeForName(this.mFile.getName());
  }
  
  public Uri getUri()
  {
    return Uri.fromFile(this.mFile);
  }
  
  public boolean isDirectory()
  {
    return this.mFile.isDirectory();
  }
  
  public boolean isFile()
  {
    return this.mFile.isFile();
  }
  
  public boolean isVirtual()
  {
    return false;
  }
  
  public long lastModified()
  {
    return this.mFile.lastModified();
  }
  
  public long length()
  {
    return this.mFile.length();
  }
  
  public DocumentFile[] listFiles()
  {
    ArrayList localArrayList = new ArrayList();
    File[] arrayOfFile = this.mFile.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(new RawDocumentFile(this, arrayOfFile[i]));
        i += 1;
      }
    }
    return (DocumentFile[])localArrayList.toArray(new DocumentFile[localArrayList.size()]);
  }
  
  public boolean renameTo(String paramString)
  {
    paramString = new File(this.mFile.getParentFile(), paramString);
    if (this.mFile.renameTo(paramString))
    {
      this.mFile = paramString;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.provider.RawDocumentFile
 * JD-Core Version:    0.7.0.1
 */