import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.tencent.biz.qqstory.takevideo.linker.LinkerSummaryView;

public class rpm
{
  public static Intent a(Intent paramIntent, Bundle paramBundle, Activity paramActivity)
  {
    if (paramBundle == null) {
      return paramIntent;
    }
    if (paramBundle.containsKey("ignorePersonalPublish")) {
      paramIntent.putExtra("ignorePersonalPublish", paramBundle.getBoolean("ignorePersonalPublish"));
    }
    paramIntent.putExtra("troop_uin", paramBundle.getInt("troop_uin", 0));
    paramIntent.putExtra("entrance_type", paramBundle.getInt("entrance_type"));
    paramIntent.putExtra("shareGroupType", paramBundle.getString("shareGroupType"));
    paramIntent.putExtra("shareGroupId", paramBundle.getString("shareGroupId"));
    paramIntent.putExtra("shareGroupName", paramBundle.getString("shareGroupName"));
    Object localObject;
    if (paramBundle.getString("widgetinfo") != null)
    {
      paramIntent.putExtra("qq_camera_scheme", aywz.sT(paramBundle.getString("widgetinfo")));
      paramIntent.putExtra("widgetinfo", paramBundle.getString("widgetinfo"));
      localObject = paramBundle.getString("key_camera_material_name");
      axiy.i("StoryIntentUtils", "passStoryRecordExtrasToIntent---takeSameName=" + (String)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label439;
      }
      paramIntent.putExtra("key_camera_material_name", (String)localObject);
      paramIntent.putExtra("qq_camera_top_title", (String)localObject);
    }
    for (;;)
    {
      paramIntent.putExtra("key_scheme_request_from_business_type", paramBundle.getString("key_scheme_request_from_business_type"));
      if ((paramActivity instanceof QIMCameraCaptureActivity))
      {
        localObject = (ViewGroup)((QIMCameraCaptureActivity)paramActivity).getRootView();
        if ((localObject != null) && (((ViewGroup)localObject).findViewById(2131381661) != null))
        {
          localObject = (LinkerSummaryView)((ViewGroup)localObject).findViewById(2131381661);
          if ((localObject == null) || (((LinkerSummaryView)localObject).a == null)) {
            break;
          }
          paramIntent.putExtra("share_url_target_url", ((LinkerSummaryView)localObject).a.mUrl);
          paramIntent.putExtra("share_url_name", ((LinkerSummaryView)localObject).a.zc);
          paramIntent.putExtra("share_url_text", ((LinkerSummaryView)localObject).a.aue);
          paramIntent.putExtra("share_url_thumb_url", ((LinkerSummaryView)localObject).a.auf);
          paramIntent.putExtra("struct_share_key_source_name", ((LinkerSummaryView)localObject).cXN);
          paramIntent.putExtra("struct_share_key_source_icon", ((LinkerSummaryView)localObject).cXM);
        }
      }
      if (((paramActivity instanceof NewPhotoListActivity)) || ((paramActivity instanceof NewPhotoPreviewActivity)))
      {
        paramIntent.putExtra("share_url_target_url", paramBundle.getString("share_url_target_url"));
        paramIntent.putExtra("share_url_name", paramBundle.getString("share_url_name"));
        paramIntent.putExtra("share_url_text", paramBundle.getString("share_url_text"));
        paramIntent.putExtra("share_url_thumb_url", paramBundle.getString("share_url_thumb_url"));
        paramIntent.putExtra("struct_share_key_source_name", paramBundle.getString("struct_share_key_source_name"));
        paramIntent.putExtra("struct_share_key_source_icon", paramBundle.getString("struct_share_key_source_icon"));
      }
      paramIntent.putExtra("video_tag_info", paramBundle.getString("video_tag_info"));
      return paramIntent;
      label439:
      paramIntent.putExtra("qq_camera_top_title", "魔法视频");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rpm
 * JD-Core Version:    0.7.0.1
 */