import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class npp
  implements npo
{
  private File F;
  private npn a;
  private String anl;
  
  public npp(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      throw new IllegalArgumentException("" + paramString1 + " : " + paramString2);
    }
    this.a = new npn(paramContext, paramString2);
    this.anl = paramString1;
    this.F = new File(paramString1);
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
    InputStream localInputStream = this.a.a(paramString);
    QLog.d("TemplateFactory", 1, "使用兜底 file: " + paramString);
    return localInputStream;
  }
  
  public List<String> list()
    throws IOException
  {
    Object localObject2 = this.a.list();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    localObject2 = this.F.list();
    if (localObject2 != null)
    {
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        ((List)localObject1).add(localObject2[i]);
        i += 1;
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     npp
 * JD-Core Version:    0.7.0.1
 */