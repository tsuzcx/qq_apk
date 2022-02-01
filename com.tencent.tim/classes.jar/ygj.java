import android.content.Context;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.net.URL;

public abstract class ygj
  implements ygl
{
  private boolean bmB;
  
  public boolean TA()
  {
    return true;
  }
  
  public boolean Tz()
  {
    return true;
  }
  
  public URLDrawable.URLDrawableOptions a()
  {
    return URLDrawable.URLDrawableOptions.obtain();
  }
  
  public URLDrawable a(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if (paramURL == null) {
      return null;
    }
    return URLDrawable.getDrawable(paramURL, paramURLDrawableOptions);
  }
  
  public void e(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    this.bmB = true;
  }
  
  public String getImgUrl()
  {
    return null;
  }
  
  public boolean isClicked()
  {
    return this.bmB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ygj
 * JD-Core Version:    0.7.0.1
 */