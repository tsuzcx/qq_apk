import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import mqq.app.AppRuntime;
import qqcircle.QQCircleDitto.StItemContainer;

class trk
  implements Observer<FeedCloudMeta.StFeed>
{
  trk(trj paramtrj) {}
  
  public void a(@Nullable FeedCloudMeta.StFeed paramStFeed)
  {
    boolean bool = false;
    if (paramStFeed == null)
    {
      this.a.a(false);
      return;
    }
    trj.a(this.a, new QQCircleDitto.StItemContainer());
    tyj.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 9, 1L);
    try
    {
      trj.a(this.a).mergeFrom(paramStFeed.dittoFeed.dittoData.get().toByteArray());
      paramStFeed = this.a;
      if (trj.a(this.a).items.size() > 0) {
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
 * Qualified Name:     trk
 * JD-Core Version:    0.7.0.1
 */