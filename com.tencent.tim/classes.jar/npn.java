import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class npn
  implements npo
{
  private String assetDir;
  private AssetManager assetManager;
  
  public npn(Context paramContext, String paramString)
  {
    this.assetManager = paramContext.getAssets();
    this.assetDir = paramString;
  }
  
  public InputStream a(String paramString)
    throws IOException
  {
    return this.assetManager.open(this.assetDir + "/" + paramString);
  }
  
  public List<String> list()
    throws IOException
  {
    try
    {
      localList = npv.a(this.assetManager, this.assetDir);
      if (localList == null) {
        break label28;
      }
    }
    catch (Exception localException)
    {
      label28:
      do
      {
        List localList;
        QLog.d("ReadAssetFile", 1, "tryLoadTemplateFromAssets fileList size: ", localException);
        arrayOfString = this.assetManager.list(this.assetDir);
        localArrayList = new ArrayList();
        localObject = localArrayList;
      } while (arrayOfString == null);
      j = arrayOfString.length;
      i = 0;
    }
    return localList;
    for (;;)
    {
      String[] arrayOfString;
      ArrayList localArrayList;
      int j;
      int i;
      Object localObject = localArrayList;
      if (i >= j) {
        break;
      }
      localArrayList.add(arrayOfString[i]);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     npn
 * JD-Core Version:    0.7.0.1
 */