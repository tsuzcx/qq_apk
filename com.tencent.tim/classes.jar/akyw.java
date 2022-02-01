import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class akyw
  extends aehv<akyw.a>
{
  @NonNull
  public akyw.a a(int paramInt)
  {
    return new akyw.a();
  }
  
  @Nullable
  public akyw.a a(aeic[] paramArrayOfaeic)
  {
    akyw.a locala = new akyw.a();
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0) && (paramArrayOfaeic[0] != null)) {
      akyw.a.a(locala, paramArrayOfaeic[0].content);
    }
    return locala;
  }
  
  public void a(akyw.a parama) {}
  
  public Class<akyw.a> clazz()
  {
    return akyw.a.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 495;
  }
  
  public static final class a
  {
    final SparseIntArray ab = new SparseIntArray();
    final SparseIntArray ac = new SparseIntArray();
    final SparseIntArray ad = new SparseIntArray();
    final SparseIntArray ae = new SparseIntArray();
    
    private void a(JSONObject paramJSONObject, SparseIntArray paramSparseIntArray)
    {
      if (paramJSONObject != null) {
        try
        {
          Iterator localIterator = paramJSONObject.keys();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            int i = paramJSONObject.optInt(str);
            paramSparseIntArray.put(Integer.parseInt(str), i);
          }
          return;
        }
        catch (Throwable paramJSONObject)
        {
          QLog.e("AIOPlusPanelAppInfoOrderConfigProcessor", 1, paramJSONObject, new Object[0]);
        }
      }
    }
    
    private void parse(String paramString)
    {
      if (!TextUtils.isEmpty(paramString)) {}
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("c2c"))
        {
          paramString = paramString.optJSONObject("c2c");
          if (paramString != null)
          {
            if (paramString.has("defaultTheme")) {
              a(paramString.optJSONObject("defaultTheme"), this.ab);
            }
            if (paramString.has("conciseTheme")) {
              a(paramString.optJSONObject("conciseTheme"), this.ac);
            }
          }
        }
        return;
      }
      catch (JSONException paramString)
      {
        QLog.e("AIOPlusPanelAppInfoOrderConfigProcessor", 1, paramString, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akyw
 * JD-Core Version:    0.7.0.1
 */