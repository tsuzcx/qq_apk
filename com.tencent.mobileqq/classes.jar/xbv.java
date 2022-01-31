import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.biz.webviewplugin.NewerGuidePlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.avatar.dynamicavatar.MX3DynamicAvatarRecordActivity;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import java.io.File;

public class xbv
  implements begw
{
  public xbv(NewerGuidePlugin paramNewerGuidePlugin, Activity paramActivity, begr parambegr) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Begr.dismiss();
        return;
      }
      catch (Exception paramView) {}
      paramView = DynamicAvatarRecordActivity.class;
      if (awii.d(awii.c)) {
        paramView = MX3DynamicAvatarRecordActivity.class;
      }
      paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, paramView);
      paramView.putExtra("param_source", 1);
      paramView.putExtra("param_from_newer_guide", true);
      this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin.startActivityForResult(paramView, (byte)100);
      continue;
      paramView = azyk.a();
      paramInt = azyk.b(this.jdField_a_of_type_AndroidAppActivity);
      Intent localIntent = new Intent();
      localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, PhotoListActivity.class);
      localIntent.putExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME", "ACTION_NEWER_GUIDE_SELECT_AVATAR_RESULT");
      localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      localIntent.putExtra("Business_Origin", 100);
      localIntent.putExtra("BUSINESS_ORIGIN_NEW", 100);
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      localIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
      localIntent.putExtra("PhotoConst.TARGET_PATH", paramView);
      localIntent.putExtra("PhotoConst.CLIP_WIDTH", paramInt);
      localIntent.putExtra("PhotoConst.CLIP_HEIGHT", paramInt);
      localIntent.putExtra("PhotoConst.TARGET_WIDTH", 1080);
      localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 1080);
      localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
      localIntent.putExtra("PhotoConst.32_Bit_Config", true);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      continue;
      if (!kzy.b(BaseApplicationImpl.getContext()))
      {
        paramView = new File(ajed.aU + "photo/");
        if (!paramView.exists()) {
          paramView.mkdirs();
        }
        paramView = new File(ajed.aU + "photo/" + System.currentTimeMillis() + ".jpg");
        localIntent = new Intent();
        NewerGuidePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin, FileProvider7Helper.setSystemCapture(this.jdField_a_of_type_AndroidAppActivity, paramView, localIntent));
        this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin.startActivityForResult(localIntent, (byte)101);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xbv
 * JD-Core Version:    0.7.0.1
 */