import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class wsz
  extends aehv<wsz.a>
{
  @NonNull
  public wsz.a a(int paramInt)
  {
    return new wsz.a();
  }
  
  @Nullable
  public wsz.a a(aeic[] paramArrayOfaeic)
  {
    wsz.a locala = new wsz.a();
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0) && (paramArrayOfaeic[0] != null)) {
      wsz.a.a(locala, paramArrayOfaeic[0].content);
    }
    return locala;
  }
  
  public void a(wsz.a parama) {}
  
  public Class<wsz.a> clazz()
  {
    return wsz.a.class;
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
    return 592;
  }
  
  public static final class a
  {
    public HashMap<String, String> gK = new HashMap();
    
    private void parse(String paramString)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ECommerceDataReportConfigProcessor", 2, "configText : " + paramString);
        }
        try
        {
          paramString = new JSONObject(paramString);
          Iterator localIterator = paramString.keys();
          while (localIterator.hasNext())
          {
            String str1 = (String)localIterator.next();
            if (!TextUtils.isEmpty(str1))
            {
              String str2 = paramString.optString(str1, "");
              if (!TextUtils.isEmpty(str2)) {
                this.gK.put(str1, str2);
              }
            }
          }
          return;
        }
        catch (Throwable paramString)
        {
          QLog.e("ECommerceDataReportConfigProcessor", 1, paramString, new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wsz
 * JD-Core Version:    0.7.0.1
 */