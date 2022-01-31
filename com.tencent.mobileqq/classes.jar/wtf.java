import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MimeHelper;

public final class wtf
  extends MediaFileFilter
{
  public boolean a(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wtf
 * JD-Core Version:    0.7.0.1
 */