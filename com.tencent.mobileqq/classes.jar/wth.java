import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MimeHelper;

public final class wth
  extends MediaFileFilter
{
  public boolean a()
  {
    return false;
  }
  
  public boolean a(String paramString)
  {
    String[] arrayOfString = MimeHelper.a(paramString);
    return (arrayOfString == null) || (!"video".equals(arrayOfString[0])) || (!"video/mp4".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wth
 * JD-Core Version:    0.7.0.1
 */