import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

class tlp
  implements tma<Bitmap>
{
  tlp(tlo paramtlo) {}
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    tmd.a(tlo.a, "recycle:" + paramBitmap);
    if (!tmd.a())
    {
      paramBitmap.recycle();
      return;
    }
    for (;;)
    {
      synchronized (this.a.b)
      {
        ArrayList localArrayList = new ArrayList();
        i = 0;
        if (i >= this.a.b.size()) {
          break label226;
        }
        Bitmap localBitmap = (Bitmap)((SoftReference)this.a.b.get(i)).get();
        if (localBitmap != null)
        {
          if (localBitmap != paramBitmap) {
            break label231;
          }
          i = 1;
          if (!localArrayList.isEmpty()) {
            this.a.b.removeAll(localArrayList);
          }
          if (i == 0)
          {
            paramBitmap = new SoftReference(paramBitmap);
            this.a.b.add(paramBitmap);
          }
        }
        else
        {
          localArrayList.add(this.a.b.get(i));
        }
      }
      QLog.e(tlo.a, 1, "reuse same bitmap " + paramBitmap);
      return;
      label226:
      int i = 0;
      continue;
      label231:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tlp
 * JD-Core Version:    0.7.0.1
 */