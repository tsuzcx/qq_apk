import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.ReportData;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import org.json.JSONException;
import org.json.JSONObject;

public class qkf
  extends SimpleJob<Object>
{
  public qkf(VideoViewVideoHolder paramVideoViewVideoHolder, String paramString1, StoryVideoItem paramStoryVideoItem, long paramLong1, long paramLong2, int paramInt, String paramString2)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    int j = 1;
    for (;;)
    {
      try
      {
        paramJobContext = new JSONObject();
        paramJobContext.put("author_id", this.val$storyVideoItem.mOwnerUid + "");
        paramJobContext.put("author_type", "1");
        paramJobContext.put("video_type", "1");
        paramJobContext.put("video_time", this.val$duration + "");
        paramJobContext.put("play_time", this.AU + "");
        paramJobContext.put("video_restrict", this.val$storyVideoItem.mBanType + "");
        if (this.val$storyVideoItem.mIsPicture == 1)
        {
          i = 1;
          paramJobContext.put("content_type", i);
          if (this.val$storyVideoItem.mLocalCreateTime > 0L) {
            break label426;
          }
          i = j;
          paramJobContext.put("content_origin", i);
          paramJobContext.put("mobile_type", Build.MODEL);
          paramJobContext.put("wifi_ssid", rpc.W(this.this$0.n()));
          paramJobContext.put("wifi_mac", rpc.V(this.this$0.n()));
          long l1;
          if (VideoViewVideoHolder.b(this.this$0) > 0L)
          {
            l1 = VideoViewVideoHolder.b(this.this$0);
            paramJobContext.put("load_time", l1 + "");
            rar.a("story_grp", "play_video_js", this.this$0.a().mReportData.from, this.bmS, new String[] { paramJobContext.toString(), "", this.axI, this.val$storyVideoItem.mVid });
            this.this$0.bmH = 3;
          }
          else
          {
            l1 = System.currentTimeMillis();
            long l2 = VideoViewVideoHolder.c(this.this$0);
            l1 -= l2;
            continue;
          }
          return null;
        }
      }
      catch (JSONException paramJobContext)
      {
        if (QLog.isColorLevel()) {
          QLog.w(this.this$0.TAG, 2, "reportTroopVideo exception:" + QLog.getStackTraceString(paramJobContext));
        }
      }
      int i = 2;
      continue;
      label426:
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qkf
 * JD-Core Version:    0.7.0.1
 */