import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aejm
  extends aehv<aejm.a>
{
  public static boolean isOpened;
  
  @NonNull
  public aejm.a a(int paramInt)
  {
    return new aejm.a();
  }
  
  @Nullable
  public aejm.a a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DarkModeConfigProcessor", 2, "onParsed : " + paramArrayOfaeic[0].content);
      }
      return aejm.a.a(paramArrayOfaeic[0].content);
    }
    return new aejm.a();
  }
  
  public void a(aejm.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeConfigProcessor", 2, "onUpdate : " + parama);
    }
    if (parama != null) {
      isOpened = parama.agI();
    }
  }
  
  public Class<aejm.a> clazz()
  {
    return aejm.a.class;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 531;
  }
  
  public static class a
  {
    private boolean bUx;
    
    public static a a(String paramString)
    {
      boolean bool = true;
      if (paramString == null) {
        return null;
      }
      try
      {
        a locala = new a();
        if (new JSONObject(paramString).optInt("isDefaultOpen", 1) == 1) {}
        for (;;)
        {
          locala.bUx = bool;
          return locala;
          bool = false;
        }
        return null;
      }
      catch (Exception paramString)
      {
        QLog.e("DarkModeConfigProcessor", 2, "DarkModeConfigBean parse error", paramString);
      }
    }
    
    public boolean agI()
    {
      return this.bUx;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aejm
 * JD-Core Version:    0.7.0.1
 */