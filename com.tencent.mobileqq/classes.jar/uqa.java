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

public class uqa
  implements URLDrawable.URLDrawableListener
{
  private HashMap<URLDrawable, uqc> a = new HashMap();
  
  public void a()
  {
    this.a.clear();
    this.a = null;
  }
  
  public void a(Object paramObject, ImageView paramImageView, int paramInt1, int paramInt2, uqd paramuqd)
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
          paramImageView.setTag(2131378281, paramObject.getURL());
          uqc localuqc = new uqc(this, null);
          localuqc.a = new WeakReference(paramImageView);
          localuqc.b = new WeakReference(paramuqd);
          this.a.put(paramObject, localuqc);
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
  
  public void a(Object paramObject, ImageView paramImageView, int paramInt1, int paramInt2, uqd paramuqd, int paramInt3)
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
          paramImageView.setTag(2131378281, paramObject.getURL());
          paramImageView.setTag(2131378275, Boolean.TRUE);
          paramImageView.setTag(2131378278, Integer.valueOf(paramInt1));
          paramImageView.setTag(2131378276, Integer.valueOf(paramInt2));
          paramImageView.setTag(2131378277, Integer.valueOf(paramInt3));
          uqc localuqc = new uqc(this, null);
          localuqc.a = new WeakReference(paramImageView);
          localuqc.b = new WeakReference(paramuqd);
          this.a.put(paramObject, localuqc);
          paramObject.setURLDrawableListener(this);
        }
        paramObject.setTag(bgxc.b(paramInt1, paramInt2, (int)(paramInt3 * DeviceInfoUtil.getDesity())));
        paramObject.setDecodeHandler(bgxc.j);
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
          localObject = (uqc)this.a.get(paramURLDrawable);
        } while (localObject == null);
        this.a.remove(paramURLDrawable);
        localImageView = (ImageView)((uqc)localObject).a.get();
      } while ((localImageView == null) || (!paramURLDrawable.getURL().equals(localImageView.getTag(2131378281))));
      localObject = (uqd)((uqc)localObject).b.get();
    } while ((localObject != null) && (!((uqd)localObject).a(localImageView)));
    if ((localImageView.getTag(2131378275) != null) && (((Boolean)localImageView.getTag(2131378275)).booleanValue()))
    {
      paramURLDrawable.setTag(bgxc.b(((Integer)localImageView.getTag(2131378278)).intValue(), ((Integer)localImageView.getTag(2131378276)).intValue(), (int)(((Integer)localImageView.getTag(2131378277)).intValue() * DeviceInfoUtil.getDesity())));
      paramURLDrawable.setDecodeHandler(bgxc.j);
    }
    localImageView.setImageDrawable(null);
    localImageView.setImageDrawable(paramURLDrawable);
    localImageView.setTag(2131378281, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uqa
 * JD-Core Version:    0.7.0.1
 */