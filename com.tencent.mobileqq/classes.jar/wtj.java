import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MimeHelper;

public final class wtj
  extends MediaFileFilter
{
  public boolean a()
  {
    return true;
  }
  
  public boolean a(String paramString)
  {
    paramString = MimeHelper.a(paramString);
    return (paramString == null) || (!"image".equals(paramString[0])) || (!MimeHelper.a(paramString[1])) || (paramString[1].equals("gif"));
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wtj
 * JD-Core Version:    0.7.0.1
 */