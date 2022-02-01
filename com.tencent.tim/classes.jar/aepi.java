import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aepi
  extends aehv<aeph>
{
  public static aeph a()
  {
    aeph localaeph2 = (aeph)aeif.a().o(493);
    aeph localaeph1 = localaeph2;
    if (localaeph2 == null) {
      localaeph1 = new aeph();
    }
    return localaeph1;
  }
  
  @NonNull
  public aeph a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SearchBusinessConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aeph();
  }
  
  @Nullable
  public aeph a(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchBusinessConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfProcessor", 2, "onParsed " + paramArrayOfaeic.length);
      }
      return aeph.a(paramArrayOfaeic[0]);
    }
    return null;
  }
  
  public void a(aeph paramaeph)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaeph == null) {
        break label43;
      }
    }
    label43:
    for (paramaeph = paramaeph.toString();; paramaeph = " empty")
    {
      QLog.d("SearchBusinessConfProcessor", 2, paramaeph);
      return;
    }
  }
  
  public Class<aeph> clazz()
  {
    return aeph.class;
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
      QLog.e("SearchBusinessConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 493;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aepi
 * JD-Core Version:    0.7.0.1
 */