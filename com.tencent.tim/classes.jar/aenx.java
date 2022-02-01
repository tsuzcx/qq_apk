import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aenx
  extends aehv<aeny>
{
  @NonNull
  public aeny a(int paramInt)
  {
    return new aeny();
  }
  
  @Nullable
  public aeny a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      aeny localaeny = aeny.a(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowStoryConfig", 2, "onParsed " + paramArrayOfaeic[0].content);
      }
      return localaeny;
    }
    return null;
  }
  
  public void a(aeny paramaeny)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowStoryConfig", 2, new Object[] { paramaeny });
    }
  }
  
  public Class<aeny> clazz()
  {
    return aeny.class;
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
      QLog.d("SlideShowStoryConfig", 2, "onReqFailed");
    }
  }
  
  public int type()
  {
    return 362;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aenx
 * JD-Core Version:    0.7.0.1
 */