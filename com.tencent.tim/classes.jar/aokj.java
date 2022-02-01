import java.io.File;
import java.io.IOException;

public class aokj
{
  File directory;
  
  public aokj(File paramFile)
  {
    this.directory = paramFile;
  }
  
  aokj.a a(String paramString)
  {
    return new aokj.a(paramString);
  }
  
  File l(String paramString)
  {
    if (!this.directory.exists()) {
      this.directory.mkdirs();
    }
    return new File(this.directory, paramString);
  }
  
  public class a
  {
    File aS;
    private String key;
    
    a(String paramString)
    {
      if (!aokj.this.directory.exists()) {
        aokj.this.directory.mkdirs();
      }
      this.key = paramString;
      this.aS = new File(aokj.this.directory, paramString + ".tmp");
    }
    
    public File I()
      throws IOException
    {
      File localFile = aokj.this.l(this.key);
      if (localFile.exists()) {
        return localFile;
      }
      if ((!this.aS.exists()) || (this.aS.length() <= 0L))
      {
        this.aS.delete();
        throw new IOException("write 0 length file or null File");
      }
      this.aS.renameTo(localFile);
      return localFile;
    }
    
    public void abort(boolean paramBoolean)
    {
      if ((!paramBoolean) || (this.aS.length() <= 0L)) {
        this.aS.delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aokj
 * JD-Core Version:    0.7.0.1
 */