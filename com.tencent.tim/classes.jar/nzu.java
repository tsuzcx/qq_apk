import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;

public class nzu
  implements URLDrawable.URLDrawableListener
{
  private HashMap<URLDrawable, nzu.a> eD = new HashMap();
  
  public void a(Object paramObject, ImageView paramImageView, int paramInt1, int paramInt2, nzu.b paramb)
  {
    if ((paramObject != null) && ((paramObject instanceof String))) {}
    for (;;)
    {
      try
      {
        paramObject = aoop.getDrawable((String)paramObject, paramInt1, paramInt2);
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
        paramObject = aoop.getDrawable((URL)paramObject, paramInt1, paramInt2);
        continue;
        label74:
        if (paramObject.getStatus() != 1)
        {
          paramImageView.setTag(2131378988, paramObject.getURL());
          nzu.a locala = new nzu.a(null);
          locala.cB = new WeakReference(paramImageView);
          locala.cC = new WeakReference(paramb);
          this.eD.put(paramObject, locala);
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
  
  public void a(Object paramObject, ImageView paramImageView, int paramInt1, int paramInt2, nzu.b paramb, int paramInt3)
  {
    if ((paramObject != null) && ((paramObject instanceof String))) {}
    for (;;)
    {
      try
      {
        paramObject = aoop.getDrawable((String)paramObject);
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
        paramObject = aoop.getDrawable((URL)paramObject);
        continue;
        label68:
        paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (paramObject.getStatus() != 1)
        {
          paramImageView.setTag(2131378988, paramObject.getURL());
          paramImageView.setTag(2131378982, Boolean.TRUE);
          paramImageView.setTag(2131378985, Integer.valueOf(paramInt1));
          paramImageView.setTag(2131378983, Integer.valueOf(paramInt2));
          paramImageView.setTag(2131378984, Integer.valueOf(paramInt3));
          nzu.a locala = new nzu.a(null);
          locala.cB = new WeakReference(paramImageView);
          locala.cC = new WeakReference(paramb);
          this.eD.put(paramObject, locala);
          paramObject.setURLDrawableListener(this);
        }
        paramObject.setTag(aqbn.d(paramInt1, paramInt2, (int)(paramInt3 * aqgz.getDesity())));
        paramObject.setDecodeHandler(aqbn.a);
        paramImageView.setImageDrawable(null);
        paramImageView.setImageDrawable(paramObject);
      }
      else
      {
        paramObject = null;
      }
    }
  }
  
  public void destroy()
  {
    this.eD.clear();
    this.eD = null;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if ((this.eD == null) || (paramURLDrawable == null)) {}
    Object localObject;
    ImageView localImageView;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (nzu.a)this.eD.get(paramURLDrawable);
        } while (localObject == null);
        this.eD.remove(paramURLDrawable);
        localImageView = (ImageView)((nzu.a)localObject).cB.get();
      } while ((localImageView == null) || (!paramURLDrawable.getURL().equals(localImageView.getTag(2131378988))));
      localObject = (nzu.b)((nzu.a)localObject).cC.get();
    } while ((localObject != null) && (!((nzu.b)localObject).a(localImageView)));
    if ((localImageView.getTag(2131378982) != null) && (((Boolean)localImageView.getTag(2131378982)).booleanValue()))
    {
      paramURLDrawable.setTag(aqbn.d(((Integer)localImageView.getTag(2131378985)).intValue(), ((Integer)localImageView.getTag(2131378983)).intValue(), (int)(((Integer)localImageView.getTag(2131378984)).intValue() * aqgz.getDesity())));
      paramURLDrawable.setDecodeHandler(aqbn.a);
    }
    localImageView.setImageDrawable(null);
    localImageView.setImageDrawable(paramURLDrawable);
    localImageView.setTag(2131378988, null);
  }
  
  class a
  {
    WeakReference<ImageView> cB;
    WeakReference<nzu.b> cC;
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract boolean a(ImageView paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nzu
 * JD-Core Version:    0.7.0.1
 */