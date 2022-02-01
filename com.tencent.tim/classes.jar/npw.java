import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class npw
{
  private final String[] bH = new String[0];
  private Map<String, String[]> eO = new HashMap();
  
  public npw(Context paramContext, String paramString)
  {
    init(paramContext, paramString);
  }
  
  private void aR(Context paramContext, String paramString)
  {
    try
    {
      String[] arrayOfString = paramContext.getAssets().list(paramString);
      if (arrayOfString != null)
      {
        this.eO.put(paramString, arrayOfString);
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (!ee(str)) {
            aR(paramContext, paramString + "/" + str);
          }
          i += 1;
        }
      }
      return;
    }
    catch (IOException paramContext)
    {
      QLog.e("Q.readinjoy.proteus", 1, "addFolderChild", paramContext);
    }
  }
  
  private boolean ee(String paramString)
  {
    return (paramString == null) || (paramString.endsWith(".geojson")) || (paramString.equals("manifest"));
  }
  
  private void init(Context paramContext, String paramString)
  {
    aR(paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     npw
 * JD-Core Version:    0.7.0.1
 */