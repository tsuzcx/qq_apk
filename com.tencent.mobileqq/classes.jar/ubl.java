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

public class ubl
  extends SimpleJob<Object>
{
  public ubl(VideoViewVideoHolder paramVideoViewVideoHolder, String paramString1, StoryVideoItem paramStoryVideoItem, long paramLong1, long paramLong2, int paramInt, String paramString2)
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
        paramJobContext.put("author_id", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid + "");
        paramJobContext.put("author_type", "1");
        paramJobContext.put("video_type", "1");
        paramJobContext.put("video_time", this.jdField_a_of_type_Long + "");
        paramJobContext.put("play_time", this.b + "");
        paramJobContext.put("video_restrict", this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mBanType + "");
        if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mIsPicture == 1)
        {
          i = 1;
          paramJobContext.put("content_type", i);
          if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalCreateTime > 0L) {
            break label426;
          }
          i = j;
          paramJobContext.put("content_origin", i);
          paramJobContext.put("mobile_type", Build.MODEL);
          paramJobContext.put("wifi_ssid", vyp.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.a()));
          paramJobContext.put("wifi_mac", vyp.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.a()));
          long l1;
          if (VideoViewVideoHolder.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder) > 0L)
          {
            l1 = VideoViewVideoHolder.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder);
            paramJobContext.put("load_time", l1 + "");
            vel.a("story_grp", "play_video_js", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.a().mReportData.from, this.jdField_a_of_type_Int, new String[] { paramJobContext.toString(), "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.d = 3;
          }
          else
          {
            l1 = System.currentTimeMillis();
            long l2 = VideoViewVideoHolder.c(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder);
            l1 -= l2;
            continue;
          }
          return null;
        }
      }
      catch (JSONException paramJobContext)
      {
        if (QLog.isColorLevel()) {
          QLog.w(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, 2, "reportTroopVideo exception:" + QLog.getStackTraceString(paramJobContext));
        }
      }
      int i = 2;
      continue;
      label426:
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ubl
 * JD-Core Version:    0.7.0.1
 */