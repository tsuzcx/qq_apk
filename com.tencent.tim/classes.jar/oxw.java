import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import feedcloud.FeedCloudMeta.StTagInfo;

class oxw
  implements Observer<pel<FeedCloudMeta.StTagInfo>>
{
  oxw(oxv paramoxv) {}
  
  public void b(@Nullable pel<FeedCloudMeta.StTagInfo> parampel)
  {
    if (parampel != null) {
      oxv.a(this.a, (FeedCloudMeta.StTagInfo)parampel.getData());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oxw
 * JD-Core Version:    0.7.0.1
 */