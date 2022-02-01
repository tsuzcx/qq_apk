import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

class nos
  implements npc<Bitmap>
{
  nos(nor paramnor) {}
  
  public void release(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    npe.log(nor.tag, "recycle:" + paramBitmap);
    if (!npe.FU())
    {
      paramBitmap.recycle();
      return;
    }
    for (;;)
    {
      synchronized (this.a.ky)
      {
        ArrayList localArrayList = new ArrayList();
        i = 0;
        if (i >= this.a.ky.size()) {
          break label226;
        }
        Bitmap localBitmap = (Bitmap)((SoftReference)this.a.ky.get(i)).get();
        if (localBitmap != null)
        {
          if (localBitmap != paramBitmap) {
            break label231;
          }
          i = 1;
          if (!localArrayList.isEmpty()) {
            this.a.ky.removeAll(localArrayList);
          }
          if (i == 0)
          {
            paramBitmap = new SoftReference(paramBitmap);
            this.a.ky.add(paramBitmap);
          }
        }
        else
        {
          localArrayList.add(this.a.ky.get(i));
        }
      }
      QLog.e(nor.tag, 1, "reuse same bitmap " + paramBitmap);
      return;
      label226:
      int i = 0;
      continue;
      label231:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nos
 * JD-Core Version:    0.7.0.1
 */