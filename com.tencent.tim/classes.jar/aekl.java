import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aekl
  extends aehv<aekl.a>
{
  public static boolean agL()
  {
    if ((Build.VERSION.SDK_INT >= 26) && (Build.MODEL.toLowerCase().contains("vivo")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocaleConfProcessor", 2, "hide entrance for vivo");
      }
      return false;
    }
    aekl.a locala = (aekl.a)aeif.a().o(552);
    if ((locala != null) && (!TextUtils.isEmpty(locala.byN))) {
      acha.bHZ = "1".equals(locala.byN);
    }
    if (QLog.isColorLevel()) {
      QLog.e("LocaleConfProcessor", 2, new Object[] { "isLocaleEntranceEnable: ", Boolean.valueOf(acha.bHZ) });
    }
    if (!acha.isLocaleCN()) {
      return true;
    }
    return acha.bHZ;
  }
  
  @NonNull
  public aekl.a a(int paramInt)
  {
    return new aekl.a();
  }
  
  @Nullable
  public aekl.a a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      aekl.a locala = aekl.a.a(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("LocaleConfProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
      }
      return locala;
    }
    return new aekl.a();
  }
  
  public void a(aekl.a parama)
  {
    if ((parama != null) && (!TextUtils.isEmpty(parama.byN))) {
      acha.bHZ = "1".equals(parama.byN);
    }
    if (QLog.isColorLevel()) {
      QLog.e("LocaleConfProcessor", 2, "onUpdate, isConfShowEntrance: " + acha.bHZ);
    }
  }
  
  public Class<aekl.a> clazz()
  {
    return aekl.a.class;
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
    return 552;
  }
  
  public static class a
  {
    public String byN = "";
    
    public a() {}
    
    public a(String paramString)
    {
      this.byN = paramString;
    }
    
    public static a a(String paramString)
    {
      try
      {
        paramString = new JSONObject(paramString).optString("ShowLocaleEntrance");
        if (QLog.isColorLevel()) {
          QLog.e("LocaleConfProcessor", 2, "manager parse, showEntrance: " + paramString);
        }
        paramString = new a(paramString.trim());
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aekl
 * JD-Core Version:    0.7.0.1
 */