package com.tencent.mobileqq.pic;

import android.content.Intent;

public abstract interface InfoBuilder
{
  public abstract CompressInfo a(Intent paramIntent);
  
  public abstract PicDownloadInfo a(Intent paramIntent);
  
  public abstract PicFowardInfo a(Intent paramIntent);
  
  public abstract PicUploadInfo a(Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.InfoBuilder
 * JD-Core Version:    0.7.0.1
 */