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

class ovq
  implements Observer<FeedCloudMeta.StFeed>
{
  ovq(ovp paramovp) {}
  
  public void a(@Nullable FeedCloudMeta.StFeed paramStFeed)
  {
    boolean bool = false;
    if (paramStFeed == null)
    {
      this.a.ur(false);
      return;
    }
    ovp.a(this.a, new QQCircleDitto.StCircleDittoDataNew());
    pco.h(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 9, 1L);
    try
    {
      ovp.a(this.a).mergeFrom(paramStFeed.dittoFeed.dittoDataNew.get().toByteArray());
      paramStFeed = this.a;
      if (ovp.a(this.a).multiItemContainter.size() > 0) {
        bool = true;
      }
      paramStFeed.ur(bool);
      return;
    }
    catch (Exception paramStFeed)
    {
      paramStFeed.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ovq
 * JD-Core Version:    0.7.0.1
 */