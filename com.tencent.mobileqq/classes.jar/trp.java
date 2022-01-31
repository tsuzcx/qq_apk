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

class trp
  implements Observer<FeedCloudMeta.StFeed>
{
  trp(tro paramtro) {}
  
  public void a(@Nullable FeedCloudMeta.StFeed paramStFeed)
  {
    boolean bool = false;
    if (paramStFeed == null)
    {
      this.a.a(false);
      return;
    }
    tro.a(this.a, new QQCircleDitto.StCircleDittoDataNew());
    tzv.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 9, 1L);
    try
    {
      tro.a(this.a).mergeFrom(paramStFeed.dittoFeed.dittoDataNew.get().toByteArray());
      paramStFeed = this.a;
      if (tro.a(this.a).multiItemContainter.size() > 0) {
        bool = true;
      }
      paramStFeed.a(bool);
      return;
    }
    catch (Exception paramStFeed)
    {
      paramStFeed.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trp
 * JD-Core Version:    0.7.0.1
 */