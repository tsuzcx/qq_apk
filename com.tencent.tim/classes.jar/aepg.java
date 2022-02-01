import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aepg
  extends aehv<aepf>
{
  public static aepf a()
  {
    aepf localaepf2 = (aepf)aeif.a().o(583);
    aepf localaepf1 = localaepf2;
    if (localaepf2 == null) {
      localaepf1 = new aepf();
    }
    return localaepf1;
  }
  
  @NonNull
  public aepf a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ExtendFriendBannerProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new aepf();
  }
  
  @Nullable
  public aepf a(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendBannerProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBannerProcessor", 2, "onParsed " + paramArrayOfaeic.length);
      }
      return aepf.a(paramArrayOfaeic[0]);
    }
    return null;
  }
  
  public void a(aepf paramaepf)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramaepf == null) {
        break label43;
      }
    }
    label43:
    for (paramaepf = paramaepf.toString();; paramaepf = " empty")
    {
      QLog.d("ExtendFriendBannerProcessor", 2, paramaepf);
      return;
    }
  }
  
  public Class<aepf> clazz()
  {
    return aepf.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ExtendFriendBannerProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 583;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aepg
 * JD-Core Version:    0.7.0.1
 */