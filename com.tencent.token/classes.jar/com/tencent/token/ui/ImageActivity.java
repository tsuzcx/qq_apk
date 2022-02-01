package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import com.tencent.token.widget.ScaleImageView;
import com.tencent.token.zs;

public class ImageActivity
  extends BaseActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("url");
    ScaleImageView localScaleImageView = new ScaleImageView(this);
    localScaleImageView.setScaleType(ImageView.ScaleType.MATRIX);
    FrameLayout localFrameLayout = new FrameLayout(this);
    localFrameLayout.setBackgroundColor(-1);
    localFrameLayout.addView(localScaleImageView, -1, -1);
    setContentView(localFrameLayout);
    new zs(localScaleImageView).execute(new String[] { paramBundle });
    setTitle("隐私政策");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ImageActivity
 * JD-Core Version:    0.7.0.1
 */