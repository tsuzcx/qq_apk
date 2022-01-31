import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MimeHelper;

public final class xca
  extends MediaFileFilter
{
  public boolean a()
  {
    return false;
  }
  
  public boolean a(String paramString)
  {
    return !MimeHelper.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xca
 * JD-Core Version:    0.7.0.1
 */