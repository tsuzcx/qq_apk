import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import mqq.app.AppRuntime;
import qqcircle.QQCircleDitto.StCircleDittoDataNew;

class uyt
  implements Observer<FeedCloudMeta.StFeed>
{
  uyt(uys paramuys) {}
  
  public void a(@Nullable FeedCloudMeta.StFeed paramStFeed)
  {
    boolean bool = true;
    if (paramStFeed == null)
    {
      this.a.a(false);
      return;
    }
    uys.a(this.a, paramStFeed);
    uys.a(this.a, new QQCircleDitto.StCircleDittoDataNew());
    vrf.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 9, 1, 0, uys.a(this.a));
    for (;;)
    {
      try
      {
        uys.a(this.a).mergeFrom(paramStFeed.dittoFeed.dittoDataNew.get().toByteArray());
        paramStFeed = this.a;
        if (uys.a(this.a).multiItemContainter.size() > 0)
        {
          paramStFeed.a(bool);
          return;
        }
      }
      catch (Exception paramStFeed)
      {
        paramStFeed.printStackTrace();
        return;
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyt
 * JD-Core Version:    0.7.0.1
 */