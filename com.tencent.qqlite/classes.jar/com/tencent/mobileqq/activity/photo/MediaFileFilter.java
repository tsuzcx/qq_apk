package com.tencent.mobileqq.activity.photo;

public enum MediaFileFilter
  implements IMediaFilter
{
  MEDIA_FILTER_DEFAULT,  MEDIA_FILTER_SHOW_IMAGE,  MEDIA_FILTER_SHOW_VIDEO;
  
  public static MediaFileFilter filterOfOrdinal(int paramInt)
  {
    MediaFileFilter[] arrayOfMediaFileFilter = values();
    int j = arrayOfMediaFileFilter.length;
    int i = 0;
    while (i < j)
    {
      MediaFileFilter localMediaFileFilter = arrayOfMediaFileFilter[i];
      if (paramInt == localMediaFileFilter.ordinal()) {
        return localMediaFileFilter;
      }
      i += 1;
    }
    return MEDIA_FILTER_DEFAULT;
  }
  
  public boolean filter(String paramString)
  {
    return false;
  }
  
  public boolean showImage()
  {
    return true;
  }
  
  public boolean showVideo()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaFileFilter
 * JD-Core Version:    0.7.0.1
 */