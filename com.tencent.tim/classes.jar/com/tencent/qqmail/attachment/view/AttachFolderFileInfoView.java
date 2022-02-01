package com.tencent.qqmail.attachment.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AttachFolderFileInfoView
  extends RelativeLayout
{
  private TextView mBackToMail;
  private TextView mFileName;
  private TextView mFileSize;
  private TextView mSendTimeLabel;
  private TextView mSenderLabel;
  private TextView mSubjectLabel;
  private ImageView mThumbNail;
  
  public AttachFolderFileInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBackgroundColor(getResources().getColor(2131167681));
    paramContext = LayoutInflater.from(paramContext).inflate(2131558755, this, true);
    this.mThumbNail = ((ImageView)paramContext.findViewById(2131363063));
    this.mFileName = ((TextView)paramContext.findViewById(2131363054));
    this.mFileSize = ((TextView)paramContext.findViewById(2131363055));
    this.mSenderLabel = ((TextView)paramContext.findViewById(2131363057));
    this.mSubjectLabel = ((TextView)paramContext.findViewById(2131363061));
    this.mSendTimeLabel = ((TextView)paramContext.findViewById(2131363059));
    this.mBackToMail = ((TextView)paramContext.findViewById(2131363053));
  }
  
  public ImageView getImageView()
  {
    return this.mThumbNail;
  }
  
  public void setBackToMailOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.mBackToMail != null) {
      this.mBackToMail.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setFileName(String paramString)
  {
    this.mFileName.setText(paramString);
  }
  
  public void setFileSize(String paramString)
  {
    this.mFileSize.setText(paramString);
  }
  
  public void setFileThumbDrawable(int paramInt)
  {
    this.mThumbNail.setBackgroundResource(paramInt);
  }
  
  public void setSendTime(String paramString)
  {
    this.mSendTimeLabel.setText(paramString);
  }
  
  public void setSender(String paramString)
  {
    this.mSenderLabel.setText(paramString);
  }
  
  public void setSubject(String paramString)
  {
    this.mSubjectLabel.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.view.AttachFolderFileInfoView
 * JD-Core Version:    0.7.0.1
 */