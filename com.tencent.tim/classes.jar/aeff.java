import android.graphics.Bitmap;
import com.tencent.mobileqq.widget.RoundImageView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class aeff
  implements aduk.a
{
  aeff(aefe paramaefe) {}
  
  public void b(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    paramString2 = (List)aefe.a(this.a).get(paramString1);
    if ((paramString2 != null) && (paramString2.size() > 0))
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        aefe.b localb = (aefe.b)paramString2.next();
        if ((localb != null) && (localb.h != null) && (localb.b != null))
        {
          localb.h.setImageBitmap(paramBitmap);
          localb.b.setDrawCacheDirty(true);
        }
      }
    }
    aefe.a(this.a).remove(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeff
 * JD-Core Version:    0.7.0.1
 */