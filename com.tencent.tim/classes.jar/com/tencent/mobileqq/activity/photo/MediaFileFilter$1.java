package com.tencent.mobileqq.activity.photo;

final class MediaFileFilter$1
  extends MediaFileFilter
{
  public boolean filter(String paramString)
  {
    if (!super.filter(paramString)) {}
    String[] arrayOfString;
    do
    {
      return false;
      arrayOfString = MimeHelper.getMimeType(paramString);
    } while ((arrayOfString != null) && ((("image".equals(arrayOfString[0])) && (MimeHelper.validateImageType(arrayOfString[1]))) || (MimeHelper.validateVideoType(paramString))));
    return true;
  }
  
  public boolean isSupportHeif()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaFileFilter.1
 * JD-Core Version:    0.7.0.1
 */