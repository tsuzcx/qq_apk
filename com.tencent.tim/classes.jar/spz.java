import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class spz
  extends aehv<spy>
{
  @NonNull
  public spy a(int paramInt)
  {
    return new spy();
  }
  
  @Nullable
  public spy a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      spy localspy = spy.a(paramArrayOfaeic[0].content);
      a(localspy);
      QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
      return localspy;
    }
    return null;
  }
  
  public void a(spy paramspy)
  {
    QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onUpdate ");
    if (paramspy != null)
    {
      QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onUpdate " + paramspy.toString());
      spp.a().m("subscribe_entrance_enable", paramspy.nJ());
      spp.a().m("is_open_sharing", paramspy.nK());
      spp.a().m("subscribe_account_title", paramspy.nL());
      spp.a().m("newfollowlist", paramspy.nM());
      spp.a().m("subscribe_publish_entrance_enable", paramspy.nN());
    }
  }
  
  public Class<spy> clazz()
  {
    return spy.class;
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
    return 463;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     spz
 * JD-Core Version:    0.7.0.1
 */