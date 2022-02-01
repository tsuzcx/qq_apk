package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FtnFileInformationView
  extends RelativeLayout
{
  private TextView fileCreatedDateLabel;
  private TextView fileDownloadCountLabel;
  private TextView fileNameLabel;
  private TextView fileSizeLabel;
  private ImageView fileThumbView;
  private TextView fileValidTimeLabel;
  
  public FtnFileInformationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = LayoutInflater.from(paramContext).inflate(2131559355, this, true);
    this.fileThumbView = ((ImageView)paramContext.findViewById(2131367761));
    this.fileNameLabel = ((TextView)paramContext.findViewById(2131367758));
    this.fileCreatedDateLabel = ((TextView)paramContext.findViewById(2131367754));
    this.fileValidTimeLabel = ((TextView)paramContext.findViewById(2131367762));
    this.fileSizeLabel = ((TextView)paramContext.findViewById(2131367759));
    this.fileDownloadCountLabel = ((TextView)paramContext.findViewById(2131367756));
    setBackgroundColor(getResources().getColor(2131167681));
  }
  
  public void setFileCreatedDate(String paramString)
  {
    this.fileCreatedDateLabel.setText(paramString);
  }
  
  public void setFileDownloadCount(int paramInt)
  {
    setFileDownloadCount(String.valueOf(paramInt));
  }
  
  public void setFileDownloadCount(String paramString)
  {
    this.fileDownloadCountLabel.setText(paramString + getResources().getString(2131692339));
  }
  
  public void setFileName(String paramString)
  {
    this.fileNameLabel.setText(paramString);
  }
  
  public void setFileSize(String paramString)
  {
    this.fileSizeLabel.setText(paramString);
  }
  
  public void setFileThumbDrawable(int paramInt, LinearLayout.LayoutParams paramLayoutParams)
  {
    this.fileThumbView.setBackgroundResource(paramInt);
    if (paramLayoutParams != null) {
      this.fileThumbView.setLayoutParams(paramLayoutParams);
    }
  }
  
  public void setFileThumbDrawable(Drawable paramDrawable)
  {
    this.fileThumbView.setBackgroundDrawable(paramDrawable);
  }
  
  public void setFileValidTime(String paramString)
  {
    this.fileValidTimeLabel.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.FtnFileInformationView
 * JD-Core Version:    0.7.0.1
 */