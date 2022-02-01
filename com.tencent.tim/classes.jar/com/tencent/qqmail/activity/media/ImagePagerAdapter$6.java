package com.tencent.qqmail.activity.media;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

class ImagePagerAdapter$6
  extends Handler
{
  ImagePagerAdapter$6(ImagePagerAdapter paramImagePagerAdapter) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramMessage.obj == null);
      paramMessage = (ImagePagerAdapter.TagData)paramMessage.obj;
    } while (paramMessage.tvProgress == null);
    paramMessage.tvProgress.setVisibility(0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessage.progress);
    localStringBuilder.append("%");
    paramMessage.tvProgress.setText(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImagePagerAdapter.6
 * JD-Core Version:    0.7.0.1
 */