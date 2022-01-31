package com.tencent.mobileqq.activity.photo;

 enum MediaFileFilter$1
{
  MediaFileFilter$1()
  {
    super(str, i, null);
  }
  
  public boolean filter(String paramString)
  {
    String[] arrayOfString = MimeHelper.a(paramString);
    if (arrayOfString != null)
    {
      if (("image".equals(arrayOfString[0])) && (MimeHelper.a(arrayOfString[1]))) {}
      while (("video".equals(arrayOfString[0])) && ("video/mp4".equals(paramString))) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaFileFilter.1
 * JD-Core Version:    0.7.0.1
 */