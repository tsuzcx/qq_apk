import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aejx
  extends aehv<aejw>
{
  @NonNull
  public static aejw a()
  {
    aejw localaejw2 = (aejw)aeif.a().o(455);
    aejw localaejw1 = localaejw2;
    if (localaejw2 == null) {
      localaejw1 = new aejw();
    }
    return localaejw1;
  }
  
  @NonNull
  public aejw a(int paramInt)
  {
    return new aejw();
  }
  
  @Nullable
  public aejw a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      aejw localaejw = aejw.a(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
      }
      return localaejw;
    }
    return new aejw();
  }
  
  public void a(aejw paramaejw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onUpdate newConf:" + paramaejw);
    }
  }
  
  public Class<aejw> clazz()
  {
    return aejw.class;
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
      QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public int type()
  {
    return 455;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aejx
 * JD-Core Version:    0.7.0.1
 */