package com.tencent.mobileqq.activity.photo.album;

import android.content.res.Resources;
import android.util.DisplayMetrics;

public class QAlbumCommonUtil
{
  public static final int dp2px(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.QAlbumCommonUtil
 * JD-Core Version:    0.7.0.1
 */