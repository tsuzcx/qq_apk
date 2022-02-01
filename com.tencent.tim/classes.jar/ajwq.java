import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.now.FeedsProtocol.GetMediaDetailRsp;
import com.tencent.pb.now.FeedsProtocol.MediaInfo;
import com.tencent.pb.now.FeedsProtocol.PicFeedsInfo;
import com.tencent.pb.now.FeedsProtocol.ShortVideoInfo;
import com.tencent.pb.now.FeedsProtocol.TextFeed;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ajwq
  extends ajwe
{
  private String TAG = "PlayListDataModel";
  private String bSz;
  private int mIndex;
  
  private void a(FeedsProtocol.GetMediaDetailRsp paramGetMediaDetailRsp)
  {
    paramGetMediaDetailRsp = paramGetMediaDetailRsp.media_list.get().iterator();
    while (paramGetMediaDetailRsp.hasNext())
    {
      FeedsProtocol.MediaInfo localMediaInfo = (FeedsProtocol.MediaInfo)paramGetMediaDetailRsp.next();
      if ((localMediaInfo.type.get() != 1) && (localMediaInfo.type.get() != 2)) {
        if (localMediaInfo.type.get() == 3) {
          a(localMediaInfo.is_my_feeds.get(), localMediaInfo.topic_cfg.get(), (FeedsProtocol.ShortVideoInfo)localMediaInfo.short_video.get(), this.mDataList);
        } else if (localMediaInfo.type.get() == 5) {
          a(localMediaInfo.is_my_feeds.get(), localMediaInfo.topic_cfg.get(), (FeedsProtocol.PicFeedsInfo)localMediaInfo.pic_info.get(), this.mDataList);
        } else if (localMediaInfo.type.get() == 6) {
          a(localMediaInfo.is_my_feeds.get(), localMediaInfo.topic_cfg.get(), (FeedsProtocol.TextFeed)localMediaInfo.text_feed.get(), this.mDataList);
        }
      }
    }
  }
  
  public void dd(Bundle paramBundle)
  {
    if ("1".equals(paramBundle.getString("isLocal"))) {}
    do
    {
      return;
      paramBundle = paramBundle.getString("raw_url");
      this.bSz = Uri.parse(paramBundle).getQuery();
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "PlayListDataModel, url=" + paramBundle);
  }
  
  public void dui()
  {
    if (this.mIsEnd) {
      return;
    }
    new ajww(this.app).b(this.bSz + "&start=" + this.mIndex + "&num=" + 10, new ajwr(this));
  }
  
  public int getTotalCount()
  {
    return this.mTotalCount;
  }
  
  public boolean isEnd()
  {
    return this.mIsEnd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajwq
 * JD-Core Version:    0.7.0.1
 */