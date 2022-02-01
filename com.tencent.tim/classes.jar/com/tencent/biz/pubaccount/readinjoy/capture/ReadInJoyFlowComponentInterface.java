package com.tencent.biz.pubaccount.readinjoy.capture;

import aaqj;
import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;

public class ReadInJoyFlowComponentInterface
  implements aaqj
{
  public static final String TAG = ReadInJoyFlowComponentInterface.class.getName();
  
  public void aG(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 25);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
    localIntent.putExtra("video_refer", getRefer());
    localIntent.putExtra("PhotoConst.IS_PREVIEW_VIDEO", false);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", LocalVideoSelectActivity.class.getName());
    localIntent.putExtra("readinjoy_video", true);
    localIntent.putExtra("needTheme", false);
    localIntent.putExtra("needVideoWording", true);
    localIntent.putExtra("needVideoDoodle", false);
    paramActivity.startActivityForResult(localIntent, 10013);
  }
  
  public String getRefer()
  {
    return "READINJOY_VIDEO";
  }
  
  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void r(Activity paramActivity, Intent paramIntent) {}
  
  public void setRefer(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyFlowComponentInterface
 * JD-Core Version:    0.7.0.1
 */