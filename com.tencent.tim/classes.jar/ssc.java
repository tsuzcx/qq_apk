import NS_QQ_STORY_CLIENT.CLIENT.StBatchGetMusicInfoRsp;
import NS_QQ_STORY_META.META.StMusic;
import com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicAdapter.2.1;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.HashMap;
import java.util.List;

public class ssc
  implements rxc.a<CLIENT.StBatchGetMusicInfoRsp>
{
  ssc(ssa paramssa, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CLIENT.StBatchGetMusicInfoRsp paramStBatchGetMusicInfoRsp)
  {
    if ((!paramBoolean) || (paramStBatchGetMusicInfoRsp.vecMusic.size() == 0)) {
      return;
    }
    int i = 0;
    if (i < paramStBatchGetMusicInfoRsp.vecMusic.size())
    {
      META.StMusic localStMusic = (META.StMusic)paramStBatchGetMusicInfoRsp.vecMusic.get(i);
      int j;
      if (localStMusic != null)
      {
        j = ((Integer)ssa.a(this.b).get(localStMusic.strSongMid.get())).intValue();
        if ((j >= 0) && (j < ssa.a(this.b).size())) {
          break label109;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label109:
        VsMusicItemInfo localVsMusicItemInfo = (VsMusicItemInfo)ssa.a(this.b).get(j);
        if (localVsMusicItemInfo.mSongMid.equals(localStMusic.strSongMid.get()))
        {
          localVsMusicItemInfo.a(localStMusic);
          localVsMusicItemInfo.aMO = true;
          if (!aqmr.isEmpty(paramString)) {
            localVsMusicItemInfo.mErrorMsg = paramString;
          }
        }
      }
    }
    this.b.a().post(new SmartMusicAdapter.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ssc
 * JD-Core Version:    0.7.0.1
 */