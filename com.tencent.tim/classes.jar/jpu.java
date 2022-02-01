import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import java.io.File;
import java.util.List;

public class jpu
{
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
    Object localObject = new File(acbn.SDCARD_PATH + "photo/");
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
    {
      doCallbackWhenChooseFileFailed();
      QQToast.a(paramActivity, 1, paramActivity.getString(2131691262), 0).show();
      return;
    }
    this.mFileGenerationUri = Uri.fromFile(new File((File)localObject, "VID_" + System.currentTimeMillis() + ".mp4"));
    localObject = new Intent("android.media.action.VIDEO_CAPTURE");
    ((Intent)localObject).putExtra("output", this.mFileGenerationUri);
    ((Intent)localObject).putExtra("android.intent.extra.videoQuality", 1);
    startActivityForResultInSafe(paramActivity, (Intent)localObject, 2131691240);
  }
  
  private void openCamera(Activity paramActivity)
  {
    File localFile = new File(acbn.SDCARD_PATH + "photo/");
    if ((!localFile.exists()) && (!localFile.mkdirs()))
    {
      doCallbackWhenChooseFileFailed();
      QQToast.a(paramActivity, 1, paramActivity.getString(2131691262), 0).show();
      return;
    }
    Intent localIntent = new Intent();
    this.mFileGenerationUri = FileProvider7Helper.setSystemCapture(paramActivity, new File(localFile, "IMG_" + System.currentTimeMillis() + ".jpg"), localIntent);
    startActivityForResultInSafe(paramActivity, localIntent, 2131691240);
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
    startActivityForResultInSafe(paramActivity, localIntent, 2131691263);
  }
  
  private void openMicrophone(Activity paramActivity)
  {
    startActivityForResultInSafe(paramActivity, new Intent("android.provider.MediaStore.RECORD_SOUND"), 2131691264);
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
        if (QLog.isColorLevel()) {
          QLog.w("FileChooserHelper", 2, "Caution: activity for intent was queried but can't started because " + paramIntent.getMessage());
        }
      }
    }
    doCallbackWhenChooseFileFailed();
    QQToast.a(paramActivity, 1, paramInt, 0).show();
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
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("FileChooserHelper", 2, "Caution: mFilePathCallback should not be null!");
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
          break label66;
        }
        paramValueCallback = paramValueCallback[0];
        if (!paramFileChooserParams.isCaptureEnabled()) {
          break label72;
        }
      }
    }
    label66:
    label72:
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
    if ((QLog.isColorLevel()) && (this.mFilePathCallback != null)) {
      QLog.w("FileChooserHelper", 2, "Caution: mFilePathCallback not null, Plz call doOnActivityResult in the onActivityResult method of caller");
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
        break label104;
      }
      openFileChooser(paramActivity, paramString1);
      return;
      paramString1 = "";
      break;
    }
    label104:
    if (("camera".equals(paramValueCallback)) || ("camcorder".equals(paramValueCallback)) || ("microphone".equals(paramValueCallback)))
    {
      paramInt = 1;
      if (paramInt != 0) {
        break label420;
      }
      if (!paramString1.contains("image/")) {
        break label258;
      }
      paramValueCallback = "camera";
      paramInt = 1;
    }
    label157:
    label420:
    for (;;)
    {
      if (paramInt != 0)
      {
        paramString2 = ausj.b(paramActivity);
        paramString2.a(new jpv(this));
        paramString2.setOnCancelListener(new jpw(this));
        if (paramValueCallback.equals("camera"))
        {
          paramString2.addButton(paramActivity.getString(2131720760), 0);
          paramString2.addButton(paramActivity.getString(2131693630), 0);
          paramString2.a(new jpx(this, paramActivity, paramString1, paramString2));
        }
        for (;;)
        {
          paramString2.show();
          return;
          paramInt = 0;
          break;
          if (paramString1.contains("video/"))
          {
            paramValueCallback = "camcorder";
            paramInt = 1;
            break label157;
          }
          if (!paramString1.contains("audio/")) {
            break label420;
          }
          paramValueCallback = "microphone";
          paramInt = 1;
          break label157;
          if (paramValueCallback.equals("camcorder"))
          {
            paramString2.addButton(paramActivity.getString(2131719513), 0);
            paramString2.addButton(paramActivity.getString(2131693630), 0);
            paramString2.a(new jpy(this, paramActivity, paramString1, paramString2));
          }
          else if (paramValueCallback.equals("microphone"))
          {
            paramString2.addButton(paramActivity.getString(2131718662), 0);
            paramString2.addButton(paramActivity.getString(2131693630), 0);
            paramString2.a(new jpz(this, paramActivity, paramString1, paramString2));
          }
        }
      }
      openFileChooser(paramActivity, paramString1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jpu
 * JD-Core Version:    0.7.0.1
 */