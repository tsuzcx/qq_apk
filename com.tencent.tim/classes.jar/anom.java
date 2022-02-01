import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class anom
  extends aehv<anom.a>
{
  @NonNull
  public anom.a a(int paramInt)
  {
    return new anom.a();
  }
  
  @Nullable
  public anom.a a(aeic[] paramArrayOfaeic)
  {
    anom.a locala = new anom.a();
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0) && (paramArrayOfaeic[0] != null)) {
      anom.a.a(locala, paramArrayOfaeic[0].content);
    }
    return locala;
  }
  
  public void a(anom.a parama) {}
  
  public Class<anom.a> clazz()
  {
    return anom.a.class;
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
    return 577;
  }
  
  public static final class a
  {
    public boolean cIO;
    
    private void parse(String paramString)
    {
      if (!TextUtils.isEmpty(paramString)) {
        if (QLog.isColorLevel()) {
          QLog.d("MsgReporterSwitchConfigProcessor", 2, "MsgReporterSwitch configText : " + paramString);
        }
      }
      try
      {
        this.cIO = new JSONObject(paramString).optBoolean("MsgHopperUpload", false);
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e("MsgReporterSwitchConfigProcessor", 1, paramString, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anom
 * JD-Core Version:    0.7.0.1
 */