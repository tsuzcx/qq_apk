import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;

public class tvn
  implements URLDrawable.URLDrawableListener
{
  private HashMap<URLDrawable, tvp> a = new HashMap();
  
  public void a()
  {
    this.a.clear();
    this.a = null;
  }
  
  public void a(Object paramObject, ImageView paramImageView, int paramInt1, int paramInt2, tvq paramtvq)
  {
    if ((paramObject != null) && ((paramObject instanceof String))) {}
    for (;;)
    {
      try
      {
        paramObject = beyq.a((String)paramObject, paramInt1, paramInt2);
        if (paramObject != null) {
          break label74;
        }
        return;
      }
      catch (IllegalArgumentException paramObject)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SubscriptPicManager", 2, paramObject.toString());
        }
        paramObject = null;
        continue;
      }
      if ((paramObject != null) && ((paramObject instanceof URL)))
      {
        paramObject = beyq.a((URL)paramObject, paramInt1, paramInt2);
        continue;
        label74:
        if (paramObject.getStatus() != 1)
        {
          paramImageView.setTag(2131378223, paramObject.getURL());
          tvp localtvp = new tvp(this, null);
          localtvp.a = new WeakReference(paramImageView);
          localtvp.b = new WeakReference(paramtvq);
          this.a.put(paramObject, localtvp);
          paramObject.setURLDrawableListener(this);
        }
        paramImageView.setImageDrawable(null);
        paramImageView.setImageDrawable(paramObject);
      }
      else
      {
        paramObject = null;
      }
    }
  }
  
  public void a(Object paramObject, ImageView paramImageView, int paramInt1, int paramInt2, tvq paramtvq, int paramInt3)
  {
    if ((paramObject != null) && ((paramObject instanceof String))) {}
    for (;;)
    {
      try
      {
        paramObject = beyq.a((String)paramObject);
        if (paramObject != null) {
          break label68;
        }
        return;
      }
      catch (IllegalArgumentException paramObject)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SubscriptPicManager", 2, paramObject.toString());
        }
        paramObject = null;
        continue;
      }
      if ((paramObject != null) && ((paramObject instanceof URL)))
      {
        paramObject = beyq.a((URL)paramObject);
        continue;
        label68:
        paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (paramObject.getStatus() != 1)
        {
          paramImageView.setTag(2131378223, paramObject.getURL());
          paramImageView.setTag(2131378217, Boolean.TRUE);
          paramImageView.setTag(2131378220, Integer.valueOf(paramInt1));
          paramImageView.setTag(2131378218, Integer.valueOf(paramInt2));
          paramImageView.setTag(2131378219, Integer.valueOf(paramInt3));
          tvp localtvp = new tvp(this, null);
          localtvp.a = new WeakReference(paramImageView);
          localtvp.b = new WeakReference(paramtvq);
          this.a.put(paramObject, localtvp);
          paramObject.setURLDrawableListener(this);
        }
        paramObject.setTag(bhez.b(paramInt1, paramInt2, (int)(paramInt3 * bhlo.a())));
        paramObject.setDecodeHandler(bhez.j);
        paramImageView.setImageDrawable(null);
        paramImageView.setImageDrawable(paramObject);
      }
      else
      {
        paramObject = null;
      }
    }
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if ((this.a == null) || (paramURLDrawable == null)) {}
    Object localObject;
    ImageView localImageView;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (tvp)this.a.get(paramURLDrawable);
        } while (localObject == null);
        this.a.remove(paramURLDrawable);
        localImageView = (ImageView)((tvp)localObject).a.get();
      } while ((localImageView == null) || (!paramURLDrawable.getURL().equals(localImageView.getTag(2131378223))));
      localObject = (tvq)((tvp)localObject).b.get();
    } while ((localObject != null) && (!((tvq)localObject).a(localImageView)));
    if ((localImageView.getTag(2131378217) != null) && (((Boolean)localImageView.getTag(2131378217)).booleanValue()))
    {
      paramURLDrawable.setTag(bhez.b(((Integer)localImageView.getTag(2131378220)).intValue(), ((Integer)localImageView.getTag(2131378218)).intValue(), (int)(((Integer)localImageView.getTag(2131378219)).intValue() * bhlo.a())));
      paramURLDrawable.setDecodeHandler(bhez.j);
    }
    localImageView.setImageDrawable(null);
    localImageView.setImageDrawable(paramURLDrawable);
    localImageView.setTag(2131378223, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tvn
 * JD-Core Version:    0.7.0.1
 */