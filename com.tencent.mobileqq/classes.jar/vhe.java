import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import qqcircle.QQCircleBase.StUserBusiData;
import qqcircle.QQCircleBase.UserCircleInfo;

public class vhe
{
  public static FeedCloudMeta.StFeed a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null)
    {
      QLog.e("QCircleHostUtil", 1, "getSimpleFeed param feed is null");
      return null;
    }
    FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
    localStFeed.id.set(paramStFeed.id.get());
    localStFeed.createTime.set(paramStFeed.createTime.get());
    if (paramStFeed.poster != null)
    {
      FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
      localStUser.id.set(paramStFeed.poster.id.get());
      localStFeed.poster.set(localStUser);
      return localStFeed;
    }
    QLog.e("QCircleHostUtil", 1, "getSimpleFeed poster is null");
    return localStFeed;
  }
  
  public static QQCircleBase.StUserBusiData a(FeedCloudMeta.StUser paramStUser)
  {
    if ((paramStUser != null) && (paramStUser.busiData.get() != null)) {
      try
      {
        QQCircleBase.StUserBusiData localStUserBusiData = new QQCircleBase.StUserBusiData();
        localStUserBusiData.mergeFrom(paramStUser.busiData.get().toByteArray());
        return localStUserBusiData;
      }
      catch (Exception paramStUser)
      {
        paramStUser.printStackTrace();
      }
    }
    return null;
  }
  
  public static void a(ArrayList<QQCircleBase.UserCircleInfo> paramArrayList, int paramInt, String paramString)
  {
    if ((paramArrayList == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      localUserCircleInfo = (QQCircleBase.UserCircleInfo)paramArrayList.get(i);
      if ((!paramString.equals(localUserCircleInfo.name.get())) || (localUserCircleInfo.circleTab.get() == 1))
      {
        i += 1;
      }
      else
      {
        localUserCircleInfo.circleTab.set(paramInt);
        return;
      }
    }
    QQCircleBase.UserCircleInfo localUserCircleInfo = new QQCircleBase.UserCircleInfo();
    localUserCircleInfo.name.set(paramString);
    localUserCircleInfo.circleTab.set(paramInt);
    paramArrayList.add(localUserCircleInfo);
  }
  
  public static boolean a(FeedCloudMeta.StUser paramStUser)
  {
    return (paramStUser != null) && (BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(paramStUser.id.get()));
  }
  
  public static boolean b(FeedCloudMeta.StUser paramStUser)
  {
    paramStUser = a(paramStUser);
    return (paramStUser != null) && (paramStUser.certification.get() == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhe
 * JD-Core Version:    0.7.0.1
 */