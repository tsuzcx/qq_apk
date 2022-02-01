import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ajgq
  extends aehv<ajgq.a>
{
  private static boolean cor;
  public static boolean isOpened;
  
  private static boolean aqB()
  {
    ajgq.a locala2 = (ajgq.a)aeif.a().o(522);
    ajgq.a locala1 = locala2;
    if (locala2 == null)
    {
      locala2 = new ajgq.a();
      locala1 = locala2;
      if (QLog.isColorLevel())
      {
        QLog.d("MsgBackupConfigProcessor", 2, "MsgBackupConfigData = null, general new bean, so switch default");
        locala1 = locala2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "MsgBackupConfigData switch isOpened = " + locala1);
    }
    return locala1.agI();
  }
  
  public static boolean aqC()
  {
    if (cor) {
      return isOpened;
    }
    cor = true;
    isOpened = aqB();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "MsgBackupConfigData isSwitchOpened = " + isOpened);
    }
    return isOpened;
  }
  
  @NonNull
  public ajgq.a a(int paramInt)
  {
    return new ajgq.a();
  }
  
  @Nullable
  public ajgq.a a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackupConfigProcessor", 2, "onParsed : " + paramArrayOfaeic[0].content);
      }
      return ajgq.a.a(paramArrayOfaeic[0].content);
    }
    return new ajgq.a();
  }
  
  public void a(ajgq.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "onUpdate : " + parama);
    }
    if (parama != null) {
      isOpened = parama.agI();
    }
  }
  
  public Class<ajgq.a> clazz()
  {
    return ajgq.a.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackupConfigProcessor", 2, "onReqFailed : " + paramInt);
    }
  }
  
  public int type()
  {
    return 522;
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
        if (new JSONObject(paramString).optInt("isChatMigrateEnable", 0) == 1) {}
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
        QLog.e("MsgBackupConfigProcessor", 2, "MsgBackupConfigData parse error", paramString);
      }
    }
    
    public boolean agI()
    {
      return this.bUx;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajgq
 * JD-Core Version:    0.7.0.1
 */