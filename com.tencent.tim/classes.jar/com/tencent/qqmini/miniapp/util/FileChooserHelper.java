package com.tencent.qqmini.miniapp.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qqmini.miniapp.R.string;
import com.tencent.qqmini.sdk.core.utils.ShortVideoUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.MiniToast;
import com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import java.io.File;
import java.util.List;

public class FileChooserHelper
{
  private static final String CAMCORDER = "camcorder";
  private static final String CAMERA = "camera";
  private static final String MICROPHONE = "microphone";
  private static final String PHOTO_PREFIX = "IMG_";
  private static final String PHOTO_SUFFIX = ".jpg";
  private static final String TAG = "FileChooserHelper";
  private static final String TYPE_ANYTHING = "*/*";
  private static final String TYPE_AUDIO = "audio/";
  private static final String TYPE_IMAGE = "image/";
  private static final String TYPE_VIDEO = "video/";
  private static final String VIDEO_PREFIX = "VID_";
  private static final String VIDEO_SUFFIX = ".mp4";
  private Uri mFileGenerationUri;
  private ValueCallback<Uri[]> mFilePathCallBackForLollipop;
  private ValueCallback<Uri> mFilePathCallback;
  private int mRequestCode;
  
  private void doCallbackWhenChooseFileFailed()
  {
    if (this.mFilePathCallback != null)
    {
      this.mFilePathCallback.onReceiveValue(Uri.EMPTY);
      this.mRequestCode = -2147483648;
      this.mFilePathCallback = null;
      this.mFileGenerationUri = null;
    }
    if (this.mFilePathCallBackForLollipop != null)
    {
      this.mFilePathCallBackForLollipop.onReceiveValue(null);
      this.mFilePathCallBackForLollipop = null;
      this.mFileGenerationUri = null;
      this.mRequestCode = -2147483648;
    }
  }
  
  private void openCamcorder(Activity paramActivity)
  {
    Object localObject = new File(ShortVideoUtil.getCameraPath() + "photo/");
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
    {
      doCallbackWhenChooseFileFailed();
      MiniToast.makeText(paramActivity, 1, paramActivity.getString(R.string.mini_sdk_cant_create_file), 0).show();
      return;
    }
    this.mFileGenerationUri = Uri.fromFile(new File((File)localObject, "VID_" + System.currentTimeMillis() + ".mp4"));
    localObject = new Intent("android.media.action.VIDEO_CAPTURE");
    ((Intent)localObject).putExtra("output", this.mFileGenerationUri);
    ((Intent)localObject).putExtra("android.intent.extra.videoQuality", 1);
    startActivityForResultInSafe(paramActivity, (Intent)localObject, R.string.mini_sdk_camera_can_not_start);
  }
  
  private void openCamera(Activity paramActivity)
  {
    File localFile = new File(ShortVideoUtil.getCameraPath() + "photo/");
    if ((!localFile.exists()) && (!localFile.mkdirs()))
    {
      doCallbackWhenChooseFileFailed();
      MiniToast.makeText(paramActivity, 1, paramActivity.getString(R.string.mini_sdk_cant_create_file), 0).show();
      return;
    }
    Intent localIntent = new Intent();
    this.mFileGenerationUri = FileProviderUtils.setSystemCapture(paramActivity, new File(localFile, "IMG_" + System.currentTimeMillis() + ".jpg"), localIntent);
    startActivityForResultInSafe(paramActivity, localIntent, R.string.mini_sdk_camera_can_not_start);
  }
  
  private void openFileChooser(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
    localIntent.addCategory("android.intent.category.OPENABLE");
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "*/*";
    }
    localIntent.setType(str);
    startActivityForResultInSafe(paramActivity, localIntent, R.string.mini_sdk_cant_open_file_chooser);
  }
  
  private void openMicrophone(Activity paramActivity)
  {
    startActivityForResultInSafe(paramActivity, new Intent("android.provider.MediaStore.RECORD_SOUND"), R.string.mini_sdk_cant_open_sound_recorder);
  }
  
  private void startActivityForResultInSafe(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if ((paramActivity != null) && (paramIntent != null) && (paramInt > 0))
    {
      List localList = paramActivity.getPackageManager().queryIntentActivities(paramIntent, 0);
      if ((localList == null) || (localList.isEmpty())) {}
    }
    else
    {
      try
      {
        paramActivity.startActivityForResult(paramIntent, this.mRequestCode);
        return;
      }
      catch (Exception paramIntent)
      {
        if (QMLog.isColorLevel()) {
          QMLog.w("FileChooserHelper", "Caution: activity for intent was queried but can't started because " + paramIntent.getMessage());
        }
      }
    }
    doCallbackWhenChooseFileFailed();
    MiniToast.makeText(paramActivity, 1, paramInt, 0).show();
  }
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2;
    Object localObject1;
    if (this.mRequestCode == paramInt1) {
      if (this.mFilePathCallback != null)
      {
        if (-1 != paramInt2) {
          break label192;
        }
        localObject2 = this.mFileGenerationUri;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          if (paramIntent == null) {
            break label79;
          }
          localObject1 = paramIntent.getData();
        }
      }
    }
    for (;;)
    {
      this.mFilePathCallback.onReceiveValue(localObject1);
      this.mRequestCode = -2147483648;
      this.mFilePathCallback = null;
      this.mFileGenerationUri = null;
      this.mFilePathCallBackForLollipop = null;
      return true;
      label79:
      localObject1 = Uri.EMPTY;
      continue;
      if (this.mFilePathCallBackForLollipop != null)
      {
        if (-1 != paramInt2) {
          break label186;
        }
        localObject2 = this.mFileGenerationUri;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          if (paramIntent == null) {
            break label156;
          }
          localObject1 = paramIntent.getData();
        }
      }
      for (;;)
      {
        label124:
        localObject2 = this.mFilePathCallBackForLollipop;
        if (localObject1 != null) {}
        for (paramIntent = new Uri[] { localObject1 };; paramIntent = null)
        {
          ((ValueCallback)localObject2).onReceiveValue(paramIntent);
          break;
          label156:
          localObject1 = null;
          break label124;
        }
        if (!QMLog.isColorLevel()) {
          break;
        }
        QMLog.w("FileChooserHelper", "Caution: mFilePathCallback should not be null!");
        break;
        return false;
        label186:
        localObject1 = null;
      }
      label192:
      localObject1 = null;
    }
  }
  
  @TargetApi(21)
  public boolean onShowFileChooser(Activity paramActivity, int paramInt, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramActivity != null)
    {
      bool1 = bool2;
      if (paramValueCallback != null)
      {
        this.mFilePathCallBackForLollipop = paramValueCallback;
        paramValueCallback = paramFileChooserParams.getAcceptTypes();
        if (paramValueCallback == null) {
          break label67;
        }
        paramValueCallback = paramValueCallback[0];
        if (!paramFileChooserParams.isCaptureEnabled()) {
          break label74;
        }
      }
    }
    label67:
    label74:
    for (paramFileChooserParams = "*";; paramFileChooserParams = "")
    {
      showFileChooser(paramActivity, paramInt, null, paramValueCallback, paramFileChooserParams);
      bool1 = true;
      return bool1;
      paramValueCallback = "";
      break;
    }
  }
  
  public void showFileChooser(Activity paramActivity, int paramInt, ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    if ((paramActivity == null) || ((paramValueCallback == null) && (this.mFilePathCallBackForLollipop == null))) {
      return;
    }
    if ((QMLog.isColorLevel()) && (this.mFilePathCallback != null)) {
      QMLog.w("FileChooserHelper", "Caution: mFilePathCallback not null, Plz call doOnActivityResult in the onActivityResult method of caller");
    }
    this.mRequestCode = paramInt;
    this.mFilePathCallback = paramValueCallback;
    this.mFileGenerationUri = null;
    if (paramString1 != null)
    {
      paramString1 = paramString1.toLowerCase();
      if (paramString2 == null) {
        break label98;
      }
    }
    label98:
    for (paramValueCallback = paramString2.toLowerCase();; paramValueCallback = "")
    {
      if (!TextUtils.isEmpty(paramValueCallback)) {
        break label105;
      }
      openFileChooser(paramActivity, paramString1);
      return;
      paramString1 = "";
      break;
    }
    label105:
    if (("camera".equals(paramValueCallback)) || ("camcorder".equals(paramValueCallback)) || ("microphone".equals(paramValueCallback)))
    {
      paramInt = 1;
      if (paramInt != 0) {
        break label409;
      }
      if (!paramString1.contains("image/")) {
        break label253;
      }
      paramValueCallback = "camera";
      paramInt = 1;
    }
    label409:
    for (;;)
    {
      label153:
      if (paramInt != 0)
      {
        paramString2 = ActionSheet.create(paramActivity);
        paramString2.setOnDismissListener(new FileChooserHelper.1(this));
        paramString2.setOnCancelListener(new FileChooserHelper.2(this));
        if (paramValueCallback.equals("camera"))
        {
          paramString2.addButton(paramActivity.getString(R.string.mini_sdk_take_a_picture), 0);
          paramString2.addButton(paramActivity.getString(R.string.mini_sdk_file_browser_title), 0);
          paramString2.setOnButtonClickListener(new FileChooserHelper.3(this, paramActivity, paramString1, paramString2));
        }
        for (;;)
        {
          paramString2.show();
          return;
          paramInt = 0;
          break;
          label253:
          if (paramString1.contains("video/"))
          {
            paramValueCallback = "camcorder";
            paramInt = 1;
            break label153;
          }
          if (!paramString1.contains("audio/")) {
            break label409;
          }
          paramValueCallback = "microphone";
          paramInt = 1;
          break label153;
          if (paramValueCallback.equals("camcorder"))
          {
            paramString2.addButton(paramActivity.getString(R.string.mini_sdk_send_video_by_camera), 0);
            paramString2.addButton(paramActivity.getString(R.string.mini_sdk_file_browser_title), 0);
            paramString2.setOnButtonClickListener(new FileChooserHelper.4(this, paramActivity, paramString1, paramString2));
          }
          else if (paramValueCallback.equals("microphone"))
          {
            paramString2.addButton(paramActivity.getString(R.string.mini_sdk_record_sound), 0);
            paramString2.addButton(paramActivity.getString(R.string.mini_sdk_file_browser_title), 0);
            paramString2.setOnButtonClickListener(new FileChooserHelper.5(this, paramActivity, paramString1, paramString2));
          }
        }
      }
      openFileChooser(paramActivity, paramString1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.FileChooserHelper
 * JD-Core Version:    0.7.0.1
 */