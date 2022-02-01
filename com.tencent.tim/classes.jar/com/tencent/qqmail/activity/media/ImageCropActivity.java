package com.tencent.qqmail.activity.media;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.view.imageview.QMGestureImageView;

public class ImageCropActivity
  extends BaseActivityEx
{
  private static final String ARG_IMAGE_PATH = "arg_imagecrop_image_path";
  public static final String TAG = "ImageCropActivity";
  private static Bitmap result;
  private String mImagePath;
  private QMGestureImageView mImageView;
  private QMTopBar topBar;
  
  public static Intent createIntent(String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), ImageCropActivity.class);
    localIntent.putExtra("arg_imagecrop_image_path", paramString);
    return localIntent;
  }
  
  public static Bitmap getCropImage()
  {
    return result;
  }
  
  private void initImageView()
  {
    this.mImageView = ((QMGestureImageView)findViewById(2131368846));
    runInBackground(new ImageCropActivity.3(this));
  }
  
  private void initTopBar()
  {
    this.topBar = ((QMTopBar)findViewById(2131374722));
    this.topBar.setTitle(2131690267);
    this.topBar.setButtonLeftIcon(2130841088);
    this.topBar.getButtonLeft().setOnClickListener(new ImageCropActivity.1(this));
    this.topBar.setButtonRightBlue(2131718919);
    this.topBar.getButtonRight().setOnClickListener(new ImageCropActivity.2(this));
  }
  
  public static void setCropImage(Bitmap paramBitmap)
  {
    result = paramBitmap;
  }
  
  private void setMinScale()
  {
    float f = getResources().getDimensionPixelSize(2131297041);
    if ((this.mImageView.getMeasuredWidth() > f) && (this.mImageView.getMeasuredHeight() > f)) {
      if (this.mImageView.getMeasuredWidth() > this.mImageView.getMeasuredHeight()) {
        f /= this.mImageView.getMeasuredHeight();
      }
    }
    for (;;)
    {
      this.mImageView.setMinScale(f);
      return;
      f /= this.mImageView.getMeasuredWidth();
      continue;
      f = 1.0F;
    }
  }
  
  public void initDataSource()
  {
    this.mImagePath = getIntent().getStringExtra("arg_imagecrop_image_path");
  }
  
  public void initDom()
  {
    initTopBar();
    initImageView();
  }
  
  public void initUI()
  {
    setContentView(2131558490);
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageCropActivity
 * JD-Core Version:    0.7.0.1
 */