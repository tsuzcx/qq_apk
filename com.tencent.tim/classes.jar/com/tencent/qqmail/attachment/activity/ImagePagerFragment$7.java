package com.tencent.qqmail.attachment.activity;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

class ImagePagerFragment$7
  extends Handler
{
  ImagePagerFragment$7(ImagePagerFragment paramImagePagerFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while ((ImagePagerFragment.access$1400(this.this$0) == null) || (paramMessage.obj == null));
    ImagePagerFragment.access$1400(this.this$0).setVisibility(0);
    paramMessage = (ImagePagerFragment.LoadImageInfo)paramMessage.obj;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessage.progress);
    localStringBuilder.append("%");
    ImagePagerFragment.access$1400(this.this$0).setText(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerFragment.7
 * JD-Core Version:    0.7.0.1
 */