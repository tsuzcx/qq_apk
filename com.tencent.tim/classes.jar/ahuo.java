import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageSwitcher;
import com.tencent.TMG.utils.QLog;
import com.tencent.image.URLDrawable;
import java.lang.ref.WeakReference;
import java.util.List;

public class ahuo
  implements Handler.Callback
{
  private int dbh;
  private int dbi = 1;
  private WeakReference<ImageSwitcher> gY;
  private WeakReference<ImageSwitcher> gZ;
  private List<String> icons;
  private Handler mUiHandler;
  
  public ahuo(ImageSwitcher paramImageSwitcher1, ImageSwitcher paramImageSwitcher2)
  {
    this.gY = new WeakReference(paramImageSwitcher1);
    this.gZ = new WeakReference(paramImageSwitcher2);
    paramImageSwitcher1.setAnimateFirstView(false);
    paramImageSwitcher1.setAnimateFirstView(false);
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation1.setDuration(1400L);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation2.setDuration(1400L);
    paramImageSwitcher1.setInAnimation(localAlphaAnimation1);
    paramImageSwitcher2.setInAnimation(localAlphaAnimation2);
    localAlphaAnimation1 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation1.setDuration(1400L);
    paramImageSwitcher1.setOutAnimation(localAlphaAnimation1);
    paramImageSwitcher2.setOutAnimation(localAlphaAnimation1);
    this.mUiHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGameImagePlayHelper", 0, "[handleMessage] set next image");
      }
      int i;
      if ((this.gY != null) && (this.gY.get() != null))
      {
        paramMessage = (ImageSwitcher)this.gY.get();
        i = this.dbh + 1;
        this.dbh = i;
        if (i == this.icons.size()) {
          this.dbh = 0;
        }
        paramMessage.setImageDrawable(URLDrawable.getDrawable((String)this.icons.get(this.dbh)));
      }
      if ((this.gZ != null) && (this.gZ.get() != null))
      {
        paramMessage = (ImageSwitcher)this.gZ.get();
        i = this.dbi + 1;
        this.dbi = i;
        if (i == this.icons.size()) {
          this.dbi = 0;
        }
        paramMessage.setImageDrawable(URLDrawable.getDrawable((String)this.icons.get(this.dbi)));
      }
      this.mUiHandler.removeMessages(1);
      this.mUiHandler.sendEmptyMessageDelayed(1, 5000L);
      return false;
    }
    catch (Exception paramMessage)
    {
      QLog.e("QQGameImagePlayHelper", 1, "[handleMessage] ");
    }
    return false;
  }
  
  public void kZ(List<String> paramList)
  {
    this.icons = paramList;
    this.mUiHandler.removeMessages(1);
    this.mUiHandler.sendEmptyMessageDelayed(1, 3000L);
    if (QLog.isColorLevel()) {
      QLog.d("QQGameImagePlayHelper", 0, "[startPlay] set next image :" + this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahuo
 * JD-Core Version:    0.7.0.1
 */