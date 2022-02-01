package com.tencent.qqmail.activity.compose;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqmail.utilities.ui.QMLoading;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public class QMComposeAttachItem
  extends LinearLayout
{
  private static final String TAG = "QMComposeAttachItem";
  public ImageView attachImage;
  public RelativeLayout attachLoading;
  public TextView fileName;
  public TextView fileSize;
  public View mask;
  
  public QMComposeAttachItem(Context paramContext)
  {
    super(paramContext);
  }
  
  public QMComposeAttachItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void hideLoading()
  {
    if (this.attachLoading != null) {
      this.attachLoading.setVisibility(4);
    }
  }
  
  public void hidePressed()
  {
    this.mask.setSelected(true);
  }
  
  public void loadViews()
  {
    this.attachImage = ((ImageView)findViewById(2131363033));
    this.fileName = ((TextView)findViewById(2131367034));
    this.fileSize = ((TextView)findViewById(2131367037));
    this.attachLoading = ((RelativeLayout)findViewById(2131363036));
    QMLoading localQMLoading = new QMLoading(getContext(), QMLoading.SIZE_MINI);
    this.attachLoading.addView(localQMLoading);
    this.mask = findViewById(2131363035);
  }
  
  public void setAttachImage(int paramInt)
  {
    if (this.attachImage != null) {
      this.attachImage.setImageResource(paramInt);
    }
  }
  
  public void setAttachImage(Bitmap paramBitmap)
  {
    if (this.attachImage != null) {
      this.attachImage.setImageBitmap(paramBitmap);
    }
  }
  
  public void setAttachName(String paramString)
  {
    if (this.fileName != null)
    {
      float f = Resources.getSystem().getDisplayMetrics().density;
      Boolean localBoolean2 = Boolean.valueOf(false);
      Boolean localBoolean1 = localBoolean2;
      if (f > 1.331D)
      {
        localBoolean1 = localBoolean2;
        if (f < 1.332D) {
          localBoolean1 = Boolean.valueOf(true);
        }
      }
      if (localBoolean1.booleanValue()) {
        this.fileName.setText(paramString);
      }
    }
    else
    {
      return;
    }
    this.fileName.setText(paramString + QMUIKit.ELLIPSIZE_FIXED);
  }
  
  public void setAttachNameDefaultColor()
  {
    this.fileName.setTextColor(getResources().getColor(2131167519));
    this.fileSize.setTextColor(getResources().getColor(2131167531));
  }
  
  public void setAttachNameRed()
  {
    this.fileName.setTextColor(getResources().getColor(2131167539));
    this.fileSize.setTextColor(getResources().getColor(2131167539));
  }
  
  public void setAttachSize(String paramString)
  {
    if ((this.fileSize != null) && (paramString != null)) {
      this.fileSize.setText(paramString);
    }
  }
  
  public void showLoading()
  {
    if (this.attachLoading != null) {
      this.attachLoading.setVisibility(0);
    }
  }
  
  public void showPressed()
  {
    this.mask.setSelected(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMComposeAttachItem
 * JD-Core Version:    0.7.0.1
 */