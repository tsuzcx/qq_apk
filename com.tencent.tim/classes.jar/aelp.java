import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aelp
  extends aehv<aelo>
{
  public static boolean ahj()
  {
    return true;
  }
  
  @NonNull
  public aelo a(int paramInt)
  {
    return new aelo();
  }
  
  public void a(aelo paramaelo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkIFrameProcessor", 2, "onUpdate " + paramaelo.toString());
    }
  }
  
  @Nullable
  public aelo b(aeic[] paramArrayOfaeic)
  {
    int i = 0;
    if (paramArrayOfaeic == null) {}
    for (;;)
    {
      QLog.d("OpenSdkIFrameProcessor", 1, new Object[] { "onParsed confFiles.length=", Integer.valueOf(i) });
      if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0)) {
        break;
      }
      new aelo();
      return aelo.a(paramArrayOfaeic);
      i = paramArrayOfaeic.length;
    }
    return null;
  }
  
  public Class<aelo> clazz()
  {
    return aelo.class;
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
    return 675;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aelp
 * JD-Core Version:    0.7.0.1
 */