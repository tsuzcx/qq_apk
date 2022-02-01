import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amir
  extends aehv<amir.a>
{
  @NonNull
  public amir.a a(int paramInt)
  {
    return new amir.a();
  }
  
  @Nullable
  public amir.a a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotConfigProcessor", 2, "onParsed : " + paramArrayOfaeic[0].content);
      }
      return amir.a.a(paramArrayOfaeic[0].content);
    }
    return new amir.a();
  }
  
  public void a(amir.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotConfigProcessor", 2, "onUpdate : " + parama);
    }
    amiw.b(parama);
  }
  
  public Class<amir.a> clazz()
  {
    return amir.a.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotConfigProcessor", 2, "onUpdate : " + paramInt);
    }
  }
  
  public int type()
  {
    return 485;
  }
  
  public static class a
  {
    private boolean cCN = true;
    
    public static a a(String paramString)
    {
      boolean bool = true;
      if (paramString == null) {
        return null;
      }
      try
      {
        a locala = new a();
        if (new JSONObject(paramString).optInt("enable", 1) == 1) {}
        for (;;)
        {
          locala.cCN = bool;
          return locala;
          bool = false;
        }
        return null;
      }
      catch (Exception paramString)
      {
        QLog.e("ScreenShotConfigProcessor", 2, "ScreenShotConfigData parse error", paramString);
      }
    }
    
    public boolean agI()
    {
      return this.cCN;
    }
    
    public String toString()
    {
      return "ScreenShotConfigData [mSwitchEnable = " + this.cCN + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amir
 * JD-Core Version:    0.7.0.1
 */