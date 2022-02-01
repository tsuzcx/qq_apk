import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class npq
  implements npo
{
  private File F;
  private String anl;
  
  public npq(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("" + paramString);
    }
    this.anl = paramString;
    this.F = new File(paramString);
  }
  
  public InputStream a(String paramString)
    throws IOException
  {
    Object localObject = new File(this.anl + "/" + paramString);
    if (((File)localObject).exists()) {
      try
      {
        localObject = new FileInputStream((File)localObject);
        return localObject;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        QLog.e("ReadMergeFile", 2, "getFile:" + paramString, localFileNotFoundException);
      }
    }
    return null;
  }
  
  public List<String> list()
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = this.F.list();
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(arrayOfString[i]);
        i += 1;
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     npq
 * JD-Core Version:    0.7.0.1
 */