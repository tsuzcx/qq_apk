import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
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

public class win
{
  private static volatile CertifiedAccountMeta.StUser jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser;
  private static CertifiedAccountRead.StGetMainPageRsp jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
  
  public static CertifiedAccountMeta.StUser a()
  {
    try
    {
      if (jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser == null)
      {
        COMM.StCommonExt localStCommonExt = new COMM.StCommonExt();
        COMM.Entry localEntry = new COMM.Entry();
        localEntry.key.set("user_info");
        localEntry.value.set("1");
        localStCommonExt.mapInfo.add(localEntry);
        if (VSNetworkHelper.a() != null) {
          VSNetworkHelper.a().a(new SubscribePersonalDetailRequest(BaseApplicationImpl.getApplication().getRuntime().getAccount(), localStCommonExt), new wio());
        }
      }
      return jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser;
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
    return jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
  }
  
  public static void a()
  {
    try
    {
      jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser = null;
      jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if (jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) {
      jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp = new CertifiedAccountRead.StGetMainPageRsp();
    }
    if (jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser == null) {
      jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser = new CertifiedAccountMeta.StUser();
    }
    CertifiedAccountMeta.StUser localStUser = paramStGetMainPageRsp.user;
    if (localStUser == null) {}
    do
    {
      return;
      jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.feedCount.set(paramStGetMainPageRsp.feedCount.get());
      jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.followCount.set(paramStGetMainPageRsp.followCount.get());
      jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.fansCount.set(paramStGetMainPageRsp.fansCount.get());
      jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.set(paramStGetMainPageRsp.user.get());
      jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.share.set(paramStGetMainPageRsp.share);
    } while (!wit.a(localStUser.attr.get()));
    jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.id.set(localStUser.id.get());
    jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.nick.set(localStUser.nick.get());
    jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.icon.set(localStUser.icon.get());
    jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.followState.set(localStUser.followState.get());
    jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.attr.set(localStUser.attr.get());
    jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.youZhan.set(localStUser.youZhan.get());
    jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser.type.set(localStUser.type.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     win
 * JD-Core Version:    0.7.0.1
 */