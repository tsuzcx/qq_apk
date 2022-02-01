import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class znu
  extends aehv
{
  public static znt a()
  {
    return (znt)aeif.a().o(470);
  }
  
  @NonNull
  public znt a(int paramInt)
  {
    return new znt();
  }
  
  @Nullable
  public znt b(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("mini_msg_config", 2, "parse.configData : " + paramArrayOfaeic[0].content);
    }
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return znt.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<znt> clazz()
  {
    return znt.class;
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
  
  public void onUpdate(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("mini_msg_config", 0, "onUpdate " + paramObject);
    }
  }
  
  public int type()
  {
    return 470;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     znu
 * JD-Core Version:    0.7.0.1
 */