import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.b;
import java.util.List;

class nax
  extends mrt<VideoInfo>
{
  nax(naw paramnaw) {}
  
  public boolean Ea()
  {
    return true;
  }
  
  protected VideoPreDownloadMgr.b a(VideoInfo paramVideoInfo)
  {
    return new VideoPreDownloadMgr.b(paramVideoInfo.vid, paramVideoInfo.Wz, paramVideoInfo.busiType, paramVideoInfo.duration);
  }
  
  protected myi a()
  {
    return naw.a(this.b).b().e;
  }
  
  protected List<VideoInfo> be()
  {
    return naw.a(this.b);
  }
  
  protected String getScene()
  {
    return "multi_video";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nax
 * JD-Core Version:    0.7.0.1
 */