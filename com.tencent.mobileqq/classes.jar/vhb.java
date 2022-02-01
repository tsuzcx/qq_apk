import com.tencent.biz.qcircleshadow.local.requests.QCircleGetMainPageRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.ContactUtils;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudMeta.StUser;
import mqq.app.AppRuntime;

public class vhb
{
  private static volatile FeedCloudMeta.StUser a;
  
  public static FeedCloudMeta.StUser a()
  {
    try
    {
      if (a == null)
      {
        if (VSNetworkHelper.getInstance() != null) {
          VSNetworkHelper.getInstance().sendRequest(new QCircleGetMainPageRequest(BaseApplicationImpl.getApplication().getRuntime().getAccount()), new vhc());
        }
        FeedCloudMeta.StUser localStUser = b();
        return localStUser;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return a;
  }
  
  public static String a()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getAccount();
  }
  
  public static void a()
  {
    a = null;
  }
  
  public static FeedCloudMeta.StUser b()
  {
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    localStUser.id.set(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    QQAppInterface localQQAppInterface = QCircleCommonUtil.getQQAppInterface();
    if (localQQAppInterface != null) {
      localStUser.nick.set(ContactUtils.getAccountNickName(localQQAppInterface, BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    }
    return localStUser;
  }
  
  public static String b()
  {
    QQAppInterface localQQAppInterface = QCircleCommonUtil.getQQAppInterface();
    if (localQQAppInterface != null) {
      return ContactUtils.getAccountNickName(localQQAppInterface, BaseApplicationImpl.getApplication().getRuntime().getAccount());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhb
 * JD-Core Version:    0.7.0.1
 */