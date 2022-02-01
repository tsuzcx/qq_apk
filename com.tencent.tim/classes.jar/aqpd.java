import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.ApngQueuePlayer.RepeatListener.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;

public class aqpd
  extends aoop.a
{
  private static ColorDrawable s = new ColorDrawable(0);
  aqpd.c jdField_a_of_type_Aqpd$c = new aqpd.c();
  URLDrawableDownListener.Adapter jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new aqpe(this);
  private boolean finished = true;
  private ImageView imageView;
  private ArrayDeque<aqpd.a> queue = new ArrayDeque();
  
  public aqpd(ImageView paramImageView)
  {
    this.imageView = paramImageView;
    if ((paramImageView instanceof URLImageView)) {
      ((URLImageView)paramImageView).setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
    }
  }
  
  private Drawable aZ()
  {
    Object localObject = s;
    Drawable localDrawable = this.imageView.getDrawable();
    if (localDrawable != null)
    {
      localObject = localDrawable;
      if ((localDrawable instanceof URLDrawable)) {
        localObject = ((URLDrawable)localDrawable).getCurrDrawable();
      }
      return localObject;
    }
    return localObject;
  }
  
  private void yO()
  {
    Object localObject = (aqpd.a)this.queue.poll();
    if (localObject == null) {
      this.finished = true;
    }
    do
    {
      return;
      this.finished = false;
      localObject = ((aqpd.a)localObject).a(aZ());
      if (((URLDrawable)localObject).getStatus() == 1)
      {
        yO();
        return;
      }
      this.imageView.setImageDrawable((Drawable)localObject);
    } while ((this.imageView instanceof URLImageView));
    ((URLDrawable)localObject).setURLDrawableListener(this);
  }
  
  public void a(aqpd.a parama)
  {
    this.queue.add(parama);
    if (this.finished) {
      yO();
    }
  }
  
  public void clear()
  {
    this.queue.clear();
    this.imageView.setImageDrawable(null);
    this.finished = true;
  }
  
  public void gq(String paramString, int paramInt)
  {
    a(new aqpd.b(paramString, paramInt));
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("ApngQueuePlayer", 1, "onLoadFialed: ", paramThrowable);
    yO();
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = ((ApngDrawable)paramURLDrawable.getCurrDrawable()).getImage();
    if (paramURLDrawable.mFrameCount <= 1)
    {
      yO();
      return;
    }
    if ((paramURLDrawable.apngLoop > 0) && (paramURLDrawable.currentApngLoop >= paramURLDrawable.apngLoop)) {
      paramURLDrawable.replay();
    }
    if (paramURLDrawable.apngLoop != 0)
    {
      this.jdField_a_of_type_Aqpd$c.a(paramURLDrawable);
      return;
    }
    yO();
  }
  
  public static abstract interface a
  {
    public abstract URLDrawable a(Drawable paramDrawable);
  }
  
  public static class b
    implements aqpd.a
  {
    private int loopCount;
    private String path;
    
    public b(String paramString, int paramInt)
    {
      this.loopCount = paramInt;
      this.path = paramString;
    }
    
    public URLDrawable a(Drawable paramDrawable)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_loop", this.loopCount);
      localBundle.putBoolean("key_use_cache", false);
      return aqqx.a(this.path, "dontCacheMe", paramDrawable, null, this.path, localBundle);
    }
  }
  
  public class c
    implements ApngDrawable.OnPlayRepeatListener
  {
    private int loopCount;
    
    c() {}
    
    public void a(ApngImage paramApngImage)
    {
      this.loopCount = paramApngImage.apngLoop;
      paramApngImage.setOnPlayRepeatListener(this);
    }
    
    public void onPlayRepeat(int paramInt)
    {
      if (paramInt == this.loopCount) {
        ThreadManagerV2.getUIHandlerV2().post(new ApngQueuePlayer.RepeatListener.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqpd
 * JD-Core Version:    0.7.0.1
 */