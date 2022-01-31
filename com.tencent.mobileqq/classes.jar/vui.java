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

public class vui
  extends SimpleJob<Object>
{
  public vui(VideoViewVideoHolder paramVideoViewVideoHolder, String paramString1, vtt paramvtt, long paramLong1, long paramLong2, int paramInt, String paramString2)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Vtt.a();
    if (localStoryVideoItem == null)
    {
      wxe.e(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "video info empty , report error! vid :%s", new Object[] { this.jdField_a_of_type_Vtt.jdField_a_of_type_JavaLangString });
      return null;
    }
    paramJobContext = ((uwm)uwa.a(2)).b(localStoryVideoItem.mOwnerUid);
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
        localJSONObject.put("video_time", this.jdField_a_of_type_Long + "");
        localJSONObject.put("play_time", this.b + "");
        localJSONObject.put("video_restrict", localStoryVideoItem.mBanType + "");
        if (localStoryVideoItem.mIsPicture != 1) {
          break label1034;
        }
        i = 1;
        localJSONObject.put("content_type", i);
        if (localStoryVideoItem.mLocalCreateTime > 0L) {
          break label1039;
        }
        i = 1;
        localJSONObject.put("content_origin", i);
        localJSONObject.put("vote_id", wxj.a(localStoryVideoItem));
        if (VideoViewVideoHolder.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder) <= 0L) {
          continue;
        }
        l = VideoViewVideoHolder.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder);
        localVideoListFeedItem = this.jdField_a_of_type_Vtt.a();
        localJSONObject.put("load_time", l + "");
        paramVarArgs = null;
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.a();
        if ((((OpenPlayerBuilder.Data)localObject).mInfo instanceof MsgTabPlayInfo)) {
          paramVarArgs = ((MsgTabPlayInfo)((OpenPlayerBuilder.Data)localObject).mInfo).nodeUnionId;
        }
        localJSONObject.put("viewer_id", wxj.a(paramVarArgs, localVideoListFeedItem));
        localJSONObject.put("sharefromapp", Integer.toString(uqn.a(2131427362)));
        if (localStoryVideoItem.mTagInfoBase != null) {
          localJSONObject.put("tag_id", localStoryVideoItem.mTagInfoBase.jdField_a_of_type_Long);
        }
        if (localStoryVideoItem.mSourceType == -1) {
          break label1044;
        }
        bool = true;
        xqq.a(bool, "storyVideoItem.mSourceType is illegal");
        if (!TextUtils.isEmpty(localStoryVideoItem.mLinkInfoJson)) {
          break label1050;
        }
        i = 0;
        localJSONObject.put("video_url", i);
        i = localStoryVideoItem.mSourceType;
        if (localStoryVideoItem.mSourceTagType == 1) {
          i = 1;
        }
        localJSONObject.put("video_origin", i);
        paramVarArgs = uxp.a(localStoryVideoItem.mLinkInfoJson);
        if ((paramVarArgs == null) || (paramVarArgs.jdField_a_of_type_Int != 5)) {
          continue;
        }
        localJSONObject.put("video_transmit", 1);
        if ((localStoryVideoItem.mCompInfoBase == null) || (TextUtils.isEmpty(localStoryVideoItem.mCompInfoBase.c))) {
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
          break label1020;
        }
        QLog.w(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, 2, "reportViewVideo exception:" + QLog.getStackTraceString(paramJobContext));
        break label1020;
        if ((paramVarArgs == null) || (paramVarArgs.jdField_a_of_type_Int != 3)) {
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
        localJSONObject.put("game_id", paramVarArgs.jdField_a_of_type_JavaLangString);
      }
      localJSONObject.put("mobile_type", Build.MODEL);
      localJSONObject.put("wifi_ssid", xrn.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.a()));
      localJSONObject.put("wifi_mac", xrn.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.a()));
      int i = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.a().mReportData.from;
      j = this.jdField_a_of_type_Int;
      localObject = localJSONObject.toString();
      if (localVideoListFeedItem == null)
      {
        paramVarArgs = "";
        wxj.a("play_video", "video_all_js", i, j, new String[] { localObject, paramVarArgs, this.jdField_a_of_type_JavaLangString, localStoryVideoItem.mVid });
        wxj.a("play_video", "video_property", i, this.jdField_a_of_type_Int, new String[] { localStoryVideoItem.mOwnerUid + "", paramJobContext, "1", localStoryVideoItem.mVid });
        wxj.a("play_video", "video_time", i, this.jdField_a_of_type_Int, new String[] { this.jdField_a_of_type_Long + "", this.b + "", l + "", localStoryVideoItem.mVid });
        wxe.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "report user video done , op_result : %d ,json :%s", Integer.valueOf(this.jdField_a_of_type_Int), localJSONObject);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.d = 3;
        break label1020;
        if (paramJobContext == null) {
          break label1028;
        }
        if (!paramJobContext.isVip) {
          break label1022;
        }
        paramJobContext = "3";
        continue;
        l = System.currentTimeMillis() - VideoViewVideoHolder.c(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder);
        continue;
        localJSONObject.put("video_transmit", 0);
        continue;
      }
      label1020:
      return null;
      label1022:
      paramJobContext = "1";
      continue;
      label1028:
      paramJobContext = "1";
      continue;
      label1034:
      i = 2;
      continue;
      label1039:
      i = 2;
      continue;
      label1044:
      boolean bool = false;
      continue;
      label1050:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vui
 * JD-Core Version:    0.7.0.1
 */