import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.util.CustomLruCache;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class aqdx
{
  private CustomLruCache<String, Drawable> a;
  private final HashMap<String, WeakReference<Drawable>> oL = new HashMap();
  
  public aqdx(int paramInt)
  {
    paramInt = Math.max(paramInt, 5);
    if (QLog.isColorLevel()) {
      QLog.d("ImageCache", 2, "Memory cache size = " + paramInt + "MB");
    }
    this.a = new aqdy(this, paramInt * 1024 * 1024);
  }
  
  public void edy()
  {
    this.a.evictAll();
    this.oL.clear();
  }
  
  public void f(String paramString, Drawable paramDrawable)
  {
    if ((this.a != null) && (this.a.get(paramString) == null))
    {
      this.a.put(paramString, paramDrawable);
      this.oL.put(paramString, new WeakReference(paramDrawable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqdx
 * JD-Core Version:    0.7.0.1
 */