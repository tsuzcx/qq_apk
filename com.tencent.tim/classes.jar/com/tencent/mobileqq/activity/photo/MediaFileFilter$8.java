package com.tencent.mobileqq.activity.photo;

final class MediaFileFilter$8
  extends MediaFileFilter
{
  public boolean filter(String paramString)
  {
    if (!super.filter(paramString)) {}
    do
    {
      return false;
      paramString = MimeHelper.getMimeType(paramString);
    } while ((paramString != null) && ("image".equals(paramString[0])) && (MimeHelper.validateImageType(paramString[1])) && (!paramString[1].equals("gif")));
    return true;
  }
  
  public boolean isSupportHeif()
  {
    return true;
  }
  
  public boolean showImage()
  {
    return true;
  }
  
  public boolean showVideo()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaFileFilter.8
 * JD-Core Version:    0.7.0.1
 */