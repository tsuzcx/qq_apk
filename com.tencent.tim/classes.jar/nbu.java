import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TVIDEO_TYPE_ONLINE_LIVE", "", "TVIDEO_TYPE_ONLINE_VOD", "VIDEO_LIVE_FORMAT_HLS", "VIDEO_LIVE_FORMAT_UNKNOWN", "VIDEO_TYPE_LOCAL_FILE_HLS", "VIDEO_TYPE_LOCAL_FILE_MP4", "VIDEO_TYPE_LOCAL_FILE_UNKNOW", "VIDEO_VOD_FORMAT_HLS", "VIDEO_VOD_FORMAT_MP4", "VIDEO_VOD_FORMAT_UNKNOWN", "generateSPVideoInfo", "Lcom/tencent/superplayer/api/SuperPlayerVideoInfo;", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/PlayerVideoInfo;", "transformFormatForSP", "transformSourceForSP", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class nbu
{
  @NotNull
  public static final SuperPlayerVideoInfo a(@NotNull nbt paramnbt)
  {
    Intrinsics.checkParameterIsNotNull(paramnbt, "$this$generateSPVideoInfo");
    if (b(paramnbt) == 1)
    {
      String str = paramnbt.getPid();
      if (str != null) {
        if (((CharSequence)str).length() > 0)
        {
          i = 1;
          if (i != 1) {
            break label69;
          }
        }
      }
      label69:
      for (paramnbt = SuperPlayerFactory.createVideoInfoForTVideo(4080303, paramnbt.getVid(), paramnbt.getPid());; paramnbt = SuperPlayerFactory.createVideoInfoForTVideo(4080303, paramnbt.getVid()))
      {
        Intrinsics.checkExpressionValueIsNotNull(paramnbt, "if (pid?.isNotEmpty() ==…D_KANDIAN, vid)\n        }");
        return paramnbt;
        i = 0;
        break;
      }
    }
    int i = c(paramnbt);
    paramnbt = SuperPlayerFactory.createVideoInfoForUrl(paramnbt.B(), i, null);
    Intrinsics.checkExpressionValueIsNotNull(paramnbt, "SuperPlayerFactory.creat…orUrl(urls, format, null)");
    return paramnbt;
  }
  
  private static final int b(@NotNull nbt paramnbt)
  {
    switch (paramnbt.getPlayType())
    {
    default: 
      return 3;
    }
    return 1;
  }
  
  private static final int c(@NotNull nbt paramnbt)
  {
    switch (paramnbt.getPlayType())
    {
    default: 
      return 103;
    case 3: 
    case 101: 
      return 101;
    case 4: 
    case 102: 
      return 102;
    case 5: 
    case 103: 
      return 104;
    case 104: 
      return 201;
    }
    return 203;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nbu
 * JD-Core Version:    0.7.0.1
 */