import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aeip
  extends aehv<aeip.a>
{
  @NonNull
  public aeip.a a(int paramInt)
  {
    return new aeip.a();
  }
  
  @Nullable
  public aeip.a a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      aeip.a locala = aeip.a.a(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("AEPituCameraConfigProcessor", 2, "onParsed:" + paramArrayOfaeic[0].content);
      }
      return locala;
    }
    return null;
  }
  
  public void a(aeip.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraConfigProcessor", 2, "onUpdate: " + parama.isOpen());
    }
    ShortVideoUtils.PH(parama.isOpen());
  }
  
  public Class<aeip.a> clazz()
  {
    return aeip.a.class;
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
  
  public int onSend(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraConfigProcessor", 2, "onSend: " + paramInt + ", isOpen:" + ShortVideoUtils.awO());
    }
    return super.onSend(paramInt);
  }
  
  public int type()
  {
    return 574;
  }
  
  public static class a
  {
    private boolean isOpen;
    
    public static a a(String paramString)
    {
      if (paramString == null) {}
      for (;;)
      {
        return null;
        try
        {
          a locala = new a();
          if (new JSONObject(paramString).optInt("showTakeSameEntrance", 0) == 1) {}
          for (boolean bool = true;; bool = false)
          {
            locala.isOpen = bool;
            return locala;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (Exception paramString) {}
      }
      QLog.e("PttAutoChangeProcessor", 1, new Object[] { "parse e:", paramString.toString() });
      return null;
    }
    
    public boolean isOpen()
    {
      return this.isOpen;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeip
 * JD-Core Version:    0.7.0.1
 */