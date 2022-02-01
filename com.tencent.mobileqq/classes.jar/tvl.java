import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;

public class tvl
  implements URLDrawable.URLDrawableListener
{
  private HashMap<URLDrawable, tvn> a = new HashMap();
  
  public void a()
  {
    this.a.clear();
    this.a = null;
  }
  
  public void a(Object paramObject, ImageView paramImageView, int paramInt1, int paramInt2, tvo paramtvo)
  {
    if ((paramObject != null) && ((paramObject instanceof String))) {}
    for (;;)
    {
      try
      {
        paramObject = bdzx.a((String)paramObject, paramInt1, paramInt2);
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
        paramObject = bdzx.a((URL)paramObject, paramInt1, paramInt2);
        continue;
        label74:
        if (paramObject.getStatus() != 1)
        {
          paramImageView.setTag(2131378066, paramObject.getURL());
          tvn localtvn = new tvn(this, null);
          localtvn.a = new WeakReference(paramImageView);
          localtvn.b = new WeakReference(paramtvo);
          this.a.put(paramObject, localtvn);
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
  
  public void a(Object paramObject, ImageView paramImageView, int paramInt1, int paramInt2, tvo paramtvo, int paramInt3)
  {
    if ((paramObject != null) && ((paramObject instanceof String))) {}
    for (;;)
    {
      try
      {
        paramObject = bdzx.a((String)paramObject);
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
        paramObject = bdzx.a((URL)paramObject);
        continue;
        label68:
        paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (paramObject.getStatus() != 1)
        {
          paramImageView.setTag(2131378066, paramObject.getURL());
          paramImageView.setTag(2131378060, Boolean.TRUE);
          paramImageView.setTag(2131378063, Integer.valueOf(paramInt1));
          paramImageView.setTag(2131378061, Integer.valueOf(paramInt2));
          paramImageView.setTag(2131378062, Integer.valueOf(paramInt3));
          tvn localtvn = new tvn(this, null);
          localtvn.a = new WeakReference(paramImageView);
          localtvn.b = new WeakReference(paramtvo);
          this.a.put(paramObject, localtvn);
          paramObject.setURLDrawableListener(this);
        }
        paramObject.setTag(bgey.b(paramInt1, paramInt2, (int)(paramInt3 * bgln.a())));
        paramObject.setDecodeHandler(bgey.j);
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
          localObject = (tvn)this.a.get(paramURLDrawable);
        } while (localObject == null);
        this.a.remove(paramURLDrawable);
        localImageView = (ImageView)((tvn)localObject).a.get();
      } while ((localImageView == null) || (!paramURLDrawable.getURL().equals(localImageView.getTag(2131378066))));
      localObject = (tvo)((tvn)localObject).b.get();
    } while ((localObject != null) && (!((tvo)localObject).a(localImageView)));
    if ((localImageView.getTag(2131378060) != null) && (((Boolean)localImageView.getTag(2131378060)).booleanValue()))
    {
      paramURLDrawable.setTag(bgey.b(((Integer)localImageView.getTag(2131378063)).intValue(), ((Integer)localImageView.getTag(2131378061)).intValue(), (int)(((Integer)localImageView.getTag(2131378062)).intValue() * bgln.a())));
      paramURLDrawable.setDecodeHandler(bgey.j);
    }
    localImageView.setImageDrawable(null);
    localImageView.setImageDrawable(paramURLDrawable);
    localImageView.setTag(2131378066, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tvl
 * JD-Core Version:    0.7.0.1
 */