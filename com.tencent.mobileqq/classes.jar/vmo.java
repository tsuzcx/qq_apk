import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.photo.AlbumListActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.tencent.biz.qqstory.takevideo.linker.LinkerSummaryView;

public class vmo
{
  public static Intent a(Intent paramIntent, Bundle paramBundle, Activity paramActivity)
  {
    if (paramBundle == null) {}
    Object localObject;
    do
    {
      return paramIntent;
      if (paramBundle.containsKey("ignorePersonalPublish")) {
        paramIntent.putExtra("ignorePersonalPublish", paramBundle.getBoolean("ignorePersonalPublish"));
      }
      paramIntent.putExtra("troop_uin", paramBundle.getInt("troop_uin", 0));
      paramIntent.putExtra("entrance_type", paramBundle.getInt("entrance_type"));
      paramIntent.putExtra("shareGroupType", paramBundle.getString("shareGroupType"));
      paramIntent.putExtra("shareGroupId", paramBundle.getString("shareGroupId"));
      paramIntent.putExtra("shareGroupName", paramBundle.getString("shareGroupName"));
      paramIntent.putExtra("qq_camera_top_title", paramBundle.getString("qq_camera_top_title"));
      paramIntent.putExtra("qq_camera_scheme", paramBundle.getString("qq_camera_scheme"));
      paramIntent.putExtra("widgetinfo", paramBundle.getString("widgetinfo"));
      paramIntent.putExtra("key_scheme_request_from_business_type", paramBundle.getString("key_scheme_request_from_business_type"));
      if (!(paramActivity instanceof QIMCameraCaptureActivity)) {
        break;
      }
      localObject = (ViewGroup)((QIMCameraCaptureActivity)paramActivity).a();
      if ((localObject == null) || (((ViewGroup)localObject).findViewById(2131313133) == null)) {
        break;
      }
      localObject = (LinkerSummaryView)((ViewGroup)localObject).findViewById(2131313133);
    } while ((localObject == null) || (((LinkerSummaryView)localObject).jdField_a_of_type_Bism == null));
    paramIntent.putExtra("share_url_target_url", ((LinkerSummaryView)localObject).jdField_a_of_type_Bism.jdField_a_of_type_JavaLangString);
    paramIntent.putExtra("share_url_name", ((LinkerSummaryView)localObject).jdField_a_of_type_Bism.b);
    paramIntent.putExtra("share_url_text", ((LinkerSummaryView)localObject).jdField_a_of_type_Bism.c);
    paramIntent.putExtra("share_url_thumb_url", ((LinkerSummaryView)localObject).jdField_a_of_type_Bism.d);
    paramIntent.putExtra("struct_share_key_source_name", ((LinkerSummaryView)localObject).b);
    paramIntent.putExtra("struct_share_key_source_icon", ((LinkerSummaryView)localObject).jdField_a_of_type_JavaLangString);
    if (((paramActivity instanceof PhotoListActivity)) || ((paramActivity instanceof PhotoPreviewActivity)) || ((paramActivity instanceof AlbumListActivity)))
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vmo
 * JD-Core Version:    0.7.0.1
 */