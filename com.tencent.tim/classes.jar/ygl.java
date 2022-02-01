import android.content.Context;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.net.URL;

public abstract interface ygl
  extends ygk
{
  public abstract boolean TA();
  
  public abstract boolean Tz();
  
  public abstract URLDrawable.URLDrawableOptions a();
  
  public abstract URLDrawable a(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions);
  
  public abstract void be(QQAppInterface paramQQAppInterface);
  
  public abstract URL e();
  
  public abstract void e(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo);
  
  public abstract String getImgUrl();
  
  public abstract boolean isClicked();
  
  public abstract String pA();
  
  public abstract String pz();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ygl
 * JD-Core Version:    0.7.0.1
 */