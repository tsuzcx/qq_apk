import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.SubscribePersonalDetailRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import mqq.app.AppRuntime;

public class vvt
{
  private static volatile CertifiedAccountMeta.StUser a;
  
  public static CertifiedAccountMeta.StUser a()
  {
    try
    {
      if (a == null)
      {
        localObject1 = new COMM.StCommonExt();
        COMM.Entry localEntry = new COMM.Entry();
        localEntry.key.set("user_info");
        localEntry.value.set("1");
        ((COMM.StCommonExt)localObject1).mapInfo.add(localEntry);
        if (VSNetworkHelper.a() != null) {
          VSNetworkHelper.a().a(new SubscribePersonalDetailRequest(BaseApplicationImpl.getApplication().getRuntime().getAccount(), (COMM.StCommonExt)localObject1), new vvu());
        }
      }
      Object localObject1 = a;
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    finally {}
  }
  
  public static void a()
  {
    try
    {
      a = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(CertifiedAccountMeta.StUser paramStUser)
  {
    if (a == null) {
      a = new CertifiedAccountMeta.StUser();
    }
    if ((paramStUser == null) || (!a.id.get().equals(paramStUser.id.get()))) {
      return;
    }
    a.id.set(paramStUser.id.get());
    a.nick.set(paramStUser.nick.get());
    a.icon.set(paramStUser.icon.get());
    a.followState.set(paramStUser.followState.get());
    a.attr.set(paramStUser.attr.get());
    a.youZhan.set(paramStUser.youZhan.get());
    a.type.set(paramStUser.type.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     vvt
 * JD-Core Version:    0.7.0.1
 */