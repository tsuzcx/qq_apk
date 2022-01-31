package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.photo.AIOImageInfo;
import com.tencent.mobileqq.data.MessageForPic;

public class ForwardUtils
{
  public static final String a = "foward";
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic)
  {
    return AIOImageInfo.b(paramMessageForPic);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils
 * JD-Core Version:    0.7.0.1
 */