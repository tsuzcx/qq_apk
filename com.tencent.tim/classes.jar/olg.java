import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stOpVideo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import com.google.gson.Gson;

public class olg
{
  public static final String aqi = String.valueOf(bfn);
  public static int bfn = 20191226;
  
  public static oli a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    int j = 0;
    oli localoli = new oli();
    Object localObject = paramstSimpleMetaFeed.video;
    localoli.id = paramstSimpleMetaFeed.id;
    localoli.mVideoUrl = paramstSimpleMetaFeed.video_url;
    localoli.mTitle = paramstSimpleMetaFeed.feed_desc;
    int i;
    if (localObject != null)
    {
      i = ((stMetaUgcVideoSeg)localObject).duration;
      localoli.mDuration = i;
      if (localObject == null) {
        break label202;
      }
      i = paramstSimpleMetaFeed.video.width;
      label70:
      localoli.mWidth = i;
      if (localObject == null) {
        break label207;
      }
      i = paramstSimpleMetaFeed.video.height;
      label88:
      localoli.mHeight = i;
      localoli.mCoverUrl = opn.b(paramstSimpleMetaFeed, false);
      localoli.mVideoType = paramstSimpleMetaFeed.video_type;
      localoli.mVideoPoolType = paramstSimpleMetaFeed.videoPoolType;
      if (paramstSimpleMetaFeed.poster == null) {
        break label212;
      }
    }
    label202:
    label207:
    label212:
    for (localObject = paramstSimpleMetaFeed.poster.id;; localObject = "")
    {
      localoli.aql = ((String)localObject);
      localoli.traceId = paramstSimpleMetaFeed.traceId;
      localoli.aqm = new Gson().toJson(paramstSimpleMetaFeed.map_ext);
      i = j;
      if (paramstSimpleMetaFeed.opVideo != null) {
        i = paramstSimpleMetaFeed.opVideo.videoType;
      }
      localoli.bfp = i;
      return localoli;
      i = 0;
      break;
      i = 0;
      break label70;
      i = 0;
      break label88;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     olg
 * JD-Core Version:    0.7.0.1
 */