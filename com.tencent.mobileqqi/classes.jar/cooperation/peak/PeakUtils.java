package cooperation.peak;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;

public final class PeakUtils
{
  public static final int a = 5000;
  public static final String a = "PEAK";
  public static final String b = "extra.CAN_FORWARD_TO_GROUP_ALBUM";
  public static final String c = "extra.EXTRA_FORWARD_TO_QZONE_SRC";
  public static final String d = "extra.GROUP_UIN";
  public static final String e = "extra.GROUP_CODE";
  public static final String f = "KEY_THUMBNAL_BOUND";
  public static final String g = "PhotoConst.MAXUM_SELECTED_NUM";
  public static final String h = "PhotoConst.IS_SINGLE_MODE";
  public static final String i = "PhotoConst.IS_CONTAIN_GIF";
  public static final String j = "extra.IMAGE_PROVIDER";
  public static final String k = "extra.EXTRA_CURRENT_IMAGE";
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new Intent(BaseApplicationImpl.a, PhotoListActivity.class);
    paramBundle.putExtras(localBundle);
    paramActivity.startActivityForResult(paramBundle, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("PEAK", 2, "enterPhotoPicker");
    }
    AlbumUtil.a(paramActivity, false, true);
  }
  
  public static void a(Context paramContext, Bundle paramBundle, IAIOImageProvider paramIAIOImageProvider, AIOImageData paramAIOImageData)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new Intent(paramContext, AIOGalleryActivity.class);
    paramBundle.addFlags(603979776);
    localBundle.putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(paramIAIOImageProvider.asBinder()));
    localBundle.putParcelable("extra.EXTRA_CURRENT_IMAGE", paramAIOImageData);
    paramBundle.putExtras(localBundle);
    paramContext.startActivity(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.peak.PeakUtils
 * JD-Core Version:    0.7.0.1
 */