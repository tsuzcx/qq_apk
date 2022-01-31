import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MimeHelper;

public final class wwm
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
 * Qualified Name:     wwm
 * JD-Core Version:    0.7.0.1
 */