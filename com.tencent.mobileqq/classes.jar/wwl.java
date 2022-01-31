import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MimeHelper;

public final class wwl
  extends MediaFileFilter
{
  public boolean a(String paramString)
  {
    paramString = MimeHelper.a(paramString);
    return (paramString == null) || (!"image".equals(paramString[0])) || (!MimeHelper.a(paramString[1]));
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wwl
 * JD-Core Version:    0.7.0.1
 */