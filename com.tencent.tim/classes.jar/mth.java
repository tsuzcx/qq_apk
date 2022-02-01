import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.b;
import java.util.ArrayList;
import java.util.List;

class mth
  extends mrt<VideoInfo>
{
  mth(mtg parammtg) {}
  
  protected VideoPreDownloadMgr.b a(VideoInfo paramVideoInfo)
  {
    return new VideoPreDownloadMgr.b(paramVideoInfo.vid, paramVideoInfo.Wz, paramVideoInfo.busiType, paramVideoInfo.duration);
  }
  
  public List<VideoPreDownloadMgr.b> a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    if (paramInt >= 0)
    {
      List localList = mtg.a(this.this$0);
      ArrayList localArrayList2;
      if (mtg.a(this.this$0) != null)
      {
        localArrayList2 = ((VideoInfo)localList.get(mtg.a(this.this$0).aUv)).jT;
        if (localArrayList2 != null) {
          a(mtg.a(this.this$0).position - 1, true, localArrayList2, localArrayList1);
        }
      }
      a(paramInt, paramBoolean, localList, localArrayList1);
      if (mtg.a(this.this$0) != null)
      {
        localArrayList2 = ((VideoInfo)localList.get(mtg.a(this.this$0).aUv)).jT;
        if (localArrayList2 != null) {
          b(mtg.a(this.this$0).position - 1, false, localArrayList2, localArrayList1);
        }
      }
      b(paramInt - 1, paramBoolean, localList, localArrayList1);
    }
    return localArrayList1;
  }
  
  protected myi a()
  {
    return mtg.a(this.this$0).a.e;
  }
  
  protected List<VideoInfo> be()
  {
    return mtg.a(this.this$0);
  }
  
  protected String getScene()
  {
    return "video_feeds";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mth
 * JD-Core Version:    0.7.0.1
 */