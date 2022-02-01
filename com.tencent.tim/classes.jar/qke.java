import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.ReportData;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import org.json.JSONException;
import org.json.JSONObject;

public class qke
  extends SimpleJob<Object>
{
  public qke(VideoViewVideoHolder paramVideoViewVideoHolder, String paramString1, qjq paramqjq, long paramLong1, long paramLong2, int paramInt, String paramString2)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    StoryVideoItem localStoryVideoItem = this.b.b();
    if (localStoryVideoItem == null)
    {
      ram.e(this.this$0.TAG, "video info empty , report error! vid :%s", new Object[] { this.b.vid });
      return null;
    }
    paramJobContext = ((ptf)psx.a(2)).b(localStoryVideoItem.mOwnerUid);
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("author_id", localStoryVideoItem.mOwnerUid + "");
        if (localStoryVideoItem.mStoryType != 2) {
          continue;
        }
        paramJobContext = "6";
        localJSONObject.put("author_type", paramJobContext);
        localJSONObject.put("video_type", "1");
        localJSONObject.put("video_time", this.val$duration + "");
        localJSONObject.put("play_time", this.AU + "");
        localJSONObject.put("video_restrict", localStoryVideoItem.mBanType + "");
        if (localStoryVideoItem.mIsPicture != 1) {
          break label1037;
        }
        i = 1;
        localJSONObject.put("content_type", i);
        if (localStoryVideoItem.mLocalCreateTime > 0L) {
          break label1042;
        }
        i = 1;
        localJSONObject.put("content_origin", i);
        localJSONObject.put("vote_id", rar.c(localStoryVideoItem));
        if (VideoViewVideoHolder.b(this.this$0) <= 0L) {
          continue;
        }
        l = VideoViewVideoHolder.b(this.this$0);
        localVideoListFeedItem = this.b.a();
        localJSONObject.put("load_time", l + "");
        paramVarArgs = null;
        localObject = this.this$0.a();
        if ((((OpenPlayerBuilder.Data)localObject).mInfo instanceof MsgTabPlayInfo)) {
          paramVarArgs = ((MsgTabPlayInfo)((OpenPlayerBuilder.Data)localObject).mInfo).nodeUnionId;
        }
        localJSONObject.put("viewer_id", rar.a(paramVarArgs, localVideoListFeedItem));
        localJSONObject.put("sharefromapp", Integer.toString(ppf.getInteger(2131427369)));
        if (localStoryVideoItem.mTagInfoBase != null) {
          localJSONObject.put("tag_id", localStoryVideoItem.mTagInfoBase.id);
        }
        if (localStoryVideoItem.mSourceType == -1) {
          break label1047;
        }
        bool = true;
        rom.assertTrue(bool, "storyVideoItem.mSourceType is illegal");
        if (!TextUtils.isEmpty(localStoryVideoItem.mLinkInfoJson)) {
          break label1053;
        }
        i = 0;
        localJSONObject.put("video_url", i);
        i = localStoryVideoItem.mSourceType;
        if (localStoryVideoItem.mSourceTagType == 1) {
          i = 1;
        }
        localJSONObject.put("video_origin", i);
        paramVarArgs = pty.a(localStoryVideoItem.mLinkInfoJson);
        if ((paramVarArgs == null) || (paramVarArgs.styleType != 5)) {
          continue;
        }
        localJSONObject.put("video_transmit", 1);
        if ((localStoryVideoItem.mCompInfoBase == null) || (TextUtils.isEmpty(localStoryVideoItem.mCompInfoBase.comparedVid))) {
          continue;
        }
        localJSONObject.put("copruduction", 1);
      }
      catch (JSONException paramJobContext)
      {
        JSONObject localJSONObject;
        long l;
        VideoListFeedItem localVideoListFeedItem;
        Object localObject;
        int j;
        if (!QLog.isColorLevel()) {
          break label1023;
        }
        QLog.w(this.this$0.TAG, 2, "reportViewVideo exception:" + QLog.getStackTraceString(paramJobContext));
        break label1023;
        if ((paramVarArgs == null) || (paramVarArgs.styleType != 3)) {
          continue;
        }
        localJSONObject.put("copruduction", 1);
        continue;
        localJSONObject.put("copruduction", 0);
        continue;
        paramVarArgs = localVideoListFeedItem.feedId;
        continue;
      }
      paramVarArgs = localStoryVideoItem.getVideoGameInfo();
      if (paramVarArgs != null) {
        localJSONObject.put("game_id", paramVarArgs.id);
      }
      localJSONObject.put("mobile_type", Build.MODEL);
      localJSONObject.put("wifi_ssid", rpc.W(this.this$0.n()));
      localJSONObject.put("wifi_mac", rpc.V(this.this$0.n()));
      int i = this.this$0.a().mReportData.from;
      j = this.bmS;
      localObject = localJSONObject.toString();
      if (localVideoListFeedItem == null)
      {
        paramVarArgs = "";
        rar.a("play_video", "video_all_js", i, j, new String[] { localObject, paramVarArgs, this.axI, localStoryVideoItem.mVid });
        rar.a("play_video", "video_property", i, this.bmS, new String[] { localStoryVideoItem.mOwnerUid + "", paramJobContext, "1", localStoryVideoItem.mVid });
        rar.a("play_video", "video_time", i, this.bmS, new String[] { this.val$duration + "", this.AU + "", l + "", localStoryVideoItem.mVid });
        ram.b(this.this$0.TAG, "report user video done , op_result : %d ,json :%s", Integer.valueOf(this.bmS), localJSONObject);
        this.this$0.bmH = 3;
        break label1023;
        if (paramJobContext == null) {
          break label1031;
        }
        if (!paramJobContext.isVip) {
          break label1025;
        }
        paramJobContext = "3";
        continue;
        l = System.currentTimeMillis() - VideoViewVideoHolder.c(this.this$0);
        continue;
        localJSONObject.put("video_transmit", 0);
        continue;
      }
      label1023:
      return null;
      label1025:
      paramJobContext = "1";
      continue;
      label1031:
      paramJobContext = "1";
      continue;
      label1037:
      i = 2;
      continue;
      label1042:
      i = 2;
      continue;
      label1047:
      boolean bool = false;
      continue;
      label1053:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qke
 * JD-Core Version:    0.7.0.1
 */