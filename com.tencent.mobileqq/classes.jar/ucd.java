import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;

public class ucd
  implements URLDrawable.URLDrawableListener
{
  private HashMap<URLDrawable, ucf> a = new HashMap();
  
  public void a()
  {
    this.a.clear();
    this.a = null;
  }
  
  public void a(Object paramObject, ImageView paramImageView, int paramInt1, int paramInt2, ucg paramucg)
  {
    if ((paramObject != null) && ((paramObject instanceof String))) {}
    for (;;)
    {
      try
      {
        paramObject = URLDrawableHelper.getDrawable((String)paramObject, paramInt1, paramInt2);
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
        paramObject = URLDrawableHelper.getDrawable((URL)paramObject, paramInt1, paramInt2);
        continue;
        label74:
        if (paramObject.getStatus() != 1)
        {
          paramImageView.setTag(2131377993, paramObject.getURL());
          ucf localucf = new ucf(this, null);
          localucf.a = new WeakReference(paramImageView);
          localucf.b = new WeakReference(paramucg);
          this.a.put(paramObject, localucf);
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
  
  public void a(Object paramObject, ImageView paramImageView, int paramInt1, int paramInt2, ucg paramucg, int paramInt3)
  {
    if ((paramObject != null) && ((paramObject instanceof String))) {}
    for (;;)
    {
      try
      {
        paramObject = URLDrawableHelper.getDrawable((String)paramObject);
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
        paramObject = URLDrawableHelper.getDrawable((URL)paramObject);
        continue;
        label68:
        paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (paramObject.getStatus() != 1)
        {
          paramImageView.setTag(2131377993, paramObject.getURL());
          paramImageView.setTag(2131377987, Boolean.TRUE);
          paramImageView.setTag(2131377990, Integer.valueOf(paramInt1));
          paramImageView.setTag(2131377988, Integer.valueOf(paramInt2));
          paramImageView.setTag(2131377989, Integer.valueOf(paramInt3));
          ucf localucf = new ucf(this, null);
          localucf.a = new WeakReference(paramImageView);
          localucf.b = new WeakReference(paramucg);
          this.a.put(paramObject, localucf);
          paramObject.setURLDrawableListener(this);
        }
        paramObject.setTag(bfol.b(paramInt1, paramInt2, (int)(paramInt3 * DeviceInfoUtil.getDesity())));
        paramObject.setDecodeHandler(bfol.j);
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
          localObject = (ucf)this.a.get(paramURLDrawable);
        } while (localObject == null);
        this.a.remove(paramURLDrawable);
        localImageView = (ImageView)((ucf)localObject).a.get();
      } while ((localImageView == null) || (!paramURLDrawable.getURL().equals(localImageView.getTag(2131377993))));
      localObject = (ucg)((ucf)localObject).b.get();
    } while ((localObject != null) && (!((ucg)localObject).a(localImageView)));
    if ((localImageView.getTag(2131377987) != null) && (((Boolean)localImageView.getTag(2131377987)).booleanValue()))
    {
      paramURLDrawable.setTag(bfol.b(((Integer)localImageView.getTag(2131377990)).intValue(), ((Integer)localImageView.getTag(2131377988)).intValue(), (int)(((Integer)localImageView.getTag(2131377989)).intValue() * DeviceInfoUtil.getDesity())));
      paramURLDrawable.setDecodeHandler(bfol.j);
    }
    localImageView.setImageDrawable(null);
    localImageView.setImageDrawable(paramURLDrawable);
    localImageView.setTag(2131377993, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ucd
 * JD-Core Version:    0.7.0.1
 */