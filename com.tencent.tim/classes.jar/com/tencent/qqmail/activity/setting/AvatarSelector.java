package com.tencent.qqmail.activity.setting;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Toast;
import com.tencent.qqmail.BaseActivityImpl;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.activity.media.ImageCropActivity;
import com.tencent.qqmail.activity.media.MediaFolderSelectActivity;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.model.media.QMAlbumManager.QMMediaIntentType;
import com.tencent.qqmail.model.media.QMCameraManager;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.permission.RxPermissions;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import rx.Observable;

public class AvatarSelector
{
  private static final int CAMERA_REQUEST_CODE = 2702;
  private static final int IMAGE_CROP_REQUEST_CODE = 2701;
  private static final String TAG = AvatarSelector.class.getSimpleName();
  BaseActivityImpl baseActivityImpl;
  private String email;
  private OnAvatarChange mOnAvatarChange;
  private Profile profile;
  
  public AvatarSelector(BaseActivityImpl paramBaseActivityImpl, OnAvatarChange paramOnAvatarChange)
  {
    this.baseActivityImpl = paramBaseActivityImpl;
    this.mOnAvatarChange = paramOnAvatarChange;
  }
  
  private void clickAlbumButton()
  {
    Intent localIntent = MediaFolderSelectActivity.createIntent(QMAlbumManager.QMMediaIntentType.QMMediaIntentType_AVATAR, QMApplicationContext.sharedInstance().getString(2131695697));
    this.baseActivityImpl.startActivityForResult(localIntent, 2701);
  }
  
  private void clickCameraButton()
  {
    String str = FileUtil.getExternalQQMailDirPath();
    if (str == null)
    {
      Toast.makeText(QMApplicationContext.sharedInstance(), 2131719828, 0).show();
      return;
    }
    str = FileUtil.createPhotoDirAtRootPath(str) + QMAttachUtils.generateUploadFileName(null);
    QMCameraManager.sharedInstance().setCameraPhotoPath(str);
    RxPermissions.getInstance(this.baseActivityImpl.getActivity()).request(new String[] { "android.permission.CAMERA" }).subscribe(new AvatarSelector.2(this));
  }
  
  private void clickClearAvatarButton()
  {
    Bitmap localBitmap = new QMAvatar(0).getBitmap();
    if (this.mOnAvatarChange != null) {
      this.mOnAvatarChange.onDefaultAvatar(localBitmap);
    }
    QMPrivateProtocolManager.sharedInstance().delPhoto(this.profile, this.email, Profile.getProtocol(this.profile));
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 2701)
    {
      if ((paramInt2 == -1) && (this.mOnAvatarChange != null))
      {
        Bitmap localBitmap = ImageCropActivity.getCropImage();
        OnAvatarChange localOnAvatarChange = this.mOnAvatarChange;
        if (localBitmap != null)
        {
          paramIntent = localBitmap;
          if (!localBitmap.isRecycled()) {}
        }
        else
        {
          paramIntent = null;
        }
        localOnAvatarChange.onAvatarChange(paramIntent);
        ImageCropActivity.setCropImage(null);
      }
      for (;;)
      {
        return true;
        Log.i(TAG, "IMAGE_CROP: RESULT_CANCELED");
      }
    }
    if (paramInt1 == 2702)
    {
      if (paramInt2 == -1)
      {
        paramIntent = ImageCropActivity.createIntent(QMCameraManager.sharedInstance().getCameraPhotoPath());
        this.baseActivityImpl.startActivityForResult(paramIntent, 2701);
      }
      return true;
    }
    return false;
  }
  
  public void recyle()
  {
    this.baseActivityImpl = null;
    this.mOnAvatarChange = null;
  }
  
  public void selectAvatar(boolean paramBoolean, Profile paramProfile, String paramString)
  {
    if (!FileUtil.hasSdcard())
    {
      Toast.makeText(QMApplicationContext.sharedInstance(), 2131696356, 0).show();
      return;
    }
    this.profile = paramProfile;
    this.email = paramString;
    paramProfile = new QMBottomDialog.BottomListSheetBuilder(this.baseActivityImpl.getActivity());
    paramProfile.setTitle(this.baseActivityImpl.getActivity().getString(2131689740));
    paramProfile.setOnSheetItemClickListener(new AvatarSelector.1(this));
    paramProfile.addItem(this.baseActivityImpl.getActivity().getString(2131691239));
    paramProfile.addItem(this.baseActivityImpl.getActivity().getString(2131690265));
    paramProfile.build().show();
  }
  
  public static abstract interface OnAvatarChange
  {
    public abstract void onAvatarChange(Bitmap paramBitmap);
    
    public abstract void onDefaultAvatar(Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.AvatarSelector
 * JD-Core Version:    0.7.0.1
 */