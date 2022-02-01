import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import mqq.app.AppRuntime;

public class ryz
{
  private static CertifiedAccountRead.StGetMainPageRsp a;
  private static volatile CertifiedAccountMeta.StUser b;
  
  public static CertifiedAccountMeta.StUser a()
  {
    try
    {
      if (b == null)
      {
        COMM.StCommonExt localStCommonExt = new COMM.StCommonExt();
        COMM.Entry localEntry = new COMM.Entry();
        localEntry.key.set("user_info");
        localEntry.value.set("1");
        localStCommonExt.mapInfo.add(localEntry);
        if (VSNetworkHelper.a() != null) {
          VSNetworkHelper.a().a(new SubscribePersonalDetailRequest(BaseApplicationImpl.getApplication().getRuntime().getAccount(), localStCommonExt), new rza());
        }
      }
      return b;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static CertifiedAccountRead.StGetMainPageRsp a()
  {
    return a;
  }
  
  public static void bhI()
  {
    try
    {
      b = null;
      a = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void c(CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if (a == null) {
      a = new CertifiedAccountRead.StGetMainPageRsp();
    }
    if (b == null) {
      b = new CertifiedAccountMeta.StUser();
    }
    CertifiedAccountMeta.StUser localStUser = paramStGetMainPageRsp.user;
    if (localStUser == null) {}
    do
    {
      return;
      a.feedCount.set(paramStGetMainPageRsp.feedCount.get());
      a.followCount.set(paramStGetMainPageRsp.followCount.get());
      a.fansCount.set(paramStGetMainPageRsp.fansCount.get());
      a.user.set(paramStGetMainPageRsp.user.get());
      a.share.set(paramStGetMainPageRsp.share);
    } while (!rze.bg(localStUser.attr.get()));
    b.id.set(localStUser.id.get());
    b.nick.set(localStUser.nick.get());
    b.icon.set(localStUser.icon.get());
    b.followState.set(localStUser.followState.get());
    b.attr.set(localStUser.attr.get());
    b.youZhan.set(localStUser.youZhan.get());
    b.type.set(localStUser.type.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ryz
 * JD-Core Version:    0.7.0.1
 */