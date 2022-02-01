import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aeni
  extends aehv<aeng>
{
  @NonNull
  public static aeng a()
  {
    aeng localaeng2 = (aeng)aeif.a().o(630);
    aeng localaeng1 = localaeng2;
    if (localaeng2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QrCodeDisplay.ConfProcessor", 2, "loadConfig(): bean is null then new QrCodeConfBean()");
      }
      localaeng1 = new aeng();
    }
    return localaeng1;
  }
  
  @NonNull
  public aeng a(int paramInt)
  {
    return new aeng();
  }
  
  @Nullable
  public aeng a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length == 0))
    {
      QLog.d("QrCodeDisplay.ConfProcessor", 1, "QrCodeDisplayConfProcessor onParsed, confFiles is null empty");
      return null;
    }
    paramArrayOfaeic = paramArrayOfaeic[0].content;
    if (QLog.isColorLevel()) {
      QLog.d("QrCodeDisplay.ConfProcessor", 2, "QrCodeDisplayConfProcessor onParsed, content:" + paramArrayOfaeic);
    }
    return aeng.a(paramArrayOfaeic);
  }
  
  public void a(aeng paramaeng)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrCodeDisplay.ConfProcessor", 2, "onUpdate " + paramaeng.toString());
    }
  }
  
  public Class<aeng> clazz()
  {
    return aeng.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("QrCodeDisplay.ConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QrCodeDisplay.ConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 630;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeni
 * JD-Core Version:    0.7.0.1
 */