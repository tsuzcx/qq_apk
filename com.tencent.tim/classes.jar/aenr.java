import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aenr
  extends aehv<aenq>
{
  @NonNull
  public aenq a(int paramInt)
  {
    return new aenq();
  }
  
  @Nullable
  public aenq a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      aenq localaenq = aenq.a(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("RelationVipGrayProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
      }
      return localaenq;
    }
    return new aenq();
  }
  
  public void a(aenq paramaenq) {}
  
  public Class<aenq> clazz()
  {
    return aenq.class;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 490;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aenr
 * JD-Core Version:    0.7.0.1
 */