import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aesx
  extends aehv<aesw>
{
  @NonNull
  public aesw a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchRichConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aesw();
  }
  
  @Nullable
  public aesw a(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchRichConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchRichConfProcessor", 2, "onParsed " + paramArrayOfaeic.length);
      }
      return aesw.a(paramArrayOfaeic[0]);
    }
    return null;
  }
  
  public void a(aesw paramaesw)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaesw == null) {
        break label49;
      }
    }
    label49:
    for (paramaesw = paramaesw.toString();; paramaesw = " empty")
    {
      QLog.d("SearchRichConfProcessor", 2, paramaesw);
      amut.a().updateConfig();
      return;
    }
  }
  
  public Class<aesw> clazz()
  {
    return aesw.class;
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
      QLog.e("SearchRichConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 432;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aesx
 * JD-Core Version:    0.7.0.1
 */