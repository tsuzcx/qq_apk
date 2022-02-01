import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.biz.webviewplugin.NewerGuidePlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.avatar.dynamicavatar.MX3DynamicAvatarRecordActivity;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import java.io.File;

public class sto
  implements ausj.a
{
  public sto(NewerGuidePlugin paramNewerGuidePlugin, Activity paramActivity, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.val$sheet.dismiss();
        return;
      }
      catch (Exception paramView) {}
      paramView = DynamicAvatarRecordActivity.class;
      if (anii.isFoundProduct(anii.KEY_NOT_PREVIEW_EXCEPT_MAIN_PROCESS_MODEL)) {
        paramView = MX3DynamicAvatarRecordActivity.class;
      }
      paramView = new Intent(this.val$activity, paramView);
      paramView.putExtra("param_source", 1);
      paramView.putExtra("param_from_newer_guide", true);
      this.a.startActivityForResult(paramView, (byte)100);
      continue;
      paramView = aqep.BR();
      paramInt = aqep.w(this.val$activity);
      Object localObject = new Intent();
      ((Intent)localObject).setClass(this.val$activity, NewPhotoListActivity.class);
      ((Intent)localObject).putExtra("enter_from", 50);
      ((Intent)localObject).putExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME", "ACTION_NEWER_GUIDE_SELECT_AVATAR_RESULT");
      ((Intent)localObject).putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      ((Intent)localObject).putExtra("Business_Origin", 100);
      ((Intent)localObject).putExtra("BUSINESS_ORIGIN_NEW", 100);
      ((Intent)localObject).putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
      ((Intent)localObject).putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      ((Intent)localObject).putExtra("PhotoConst.IS_SINGLE_MODE", true);
      ((Intent)localObject).putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
      ((Intent)localObject).putExtra("PhotoConst.TARGET_PATH", paramView);
      ((Intent)localObject).putExtra("PhotoConst.CLIP_WIDTH", paramInt);
      ((Intent)localObject).putExtra("PhotoConst.CLIP_HEIGHT", paramInt);
      ((Intent)localObject).putExtra("PhotoConst.TARGET_WIDTH", 1080);
      ((Intent)localObject).putExtra("PhotoConst.TARGET_HEIGHT", 1080);
      ((Intent)localObject).putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
      ((Intent)localObject).putExtra("PhotoConst.32_Bit_Config", true);
      this.val$activity.startActivity((Intent)localObject);
      continue;
      if (!ilp.checkAVCameraUsed(BaseApplicationImpl.getContext()))
      {
        paramView = aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "photo/");
        localObject = new File(paramView);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        paramView = new File(paramView + System.currentTimeMillis() + ".jpg");
        localObject = new Intent();
        NewerGuidePlugin.a(this.a, FileProvider7Helper.setSystemCapture(this.val$activity, paramView, (Intent)localObject));
        this.a.startActivityForResult((Intent)localObject, (byte)101);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sto
 * JD-Core Version:    0.7.0.1
 */