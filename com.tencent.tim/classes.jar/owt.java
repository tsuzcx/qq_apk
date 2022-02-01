import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetMainPageRsp;

class owt
  implements Observer<pel<FeedCloudRead.StGetMainPageRsp>>
{
  owt(ows paramows) {}
  
  public void b(@Nullable pel<FeedCloudRead.StGetMainPageRsp> parampel)
  {
    if (parampel != null) {}
    try
    {
      if ((parampel.getState() == 2) || (parampel.getState() == 3))
      {
        ows.a(this.this$0, (FeedCloudRead.StGetMainPageRsp)parampel.getData());
        ows.a(this.this$0, (FeedCloudMeta.StUser)ows.a(this.this$0).user.get());
        ows.a(this.this$0);
        ows.b(this.this$0);
        ows.c(this.this$0);
      }
      return;
    }
    catch (Exception parampel)
    {
      QLog.e("QCirclePersonalTitleBar", 1, "getShareInfo error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     owt
 * JD-Core Version:    0.7.0.1
 */