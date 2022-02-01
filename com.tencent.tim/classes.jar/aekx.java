import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aekx
  extends aehv<aekw>
{
  public static aekw a()
  {
    return (aekw)aeif.a().o(489);
  }
  
  @NonNull
  public aekw a(int paramInt)
  {
    return new aekw();
  }
  
  public void a(aekw paramaekw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onUpdate " + paramaekw.toString());
    }
  }
  
  @Nullable
  public aekw b(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aekw.a(paramArrayOfaeic);
    }
    return null;
  }
  
  public Class<aekw> clazz()
  {
    return aekw.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onReqNoReceive ");
    }
  }
  
  public int type()
  {
    return 489;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aekx
 * JD-Core Version:    0.7.0.1
 */