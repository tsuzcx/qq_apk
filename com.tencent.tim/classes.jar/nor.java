import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class nor
{
  public static final String tag = "zimage." + nor.class.getSimpleName();
  public not a;
  public npc<Bitmap> a;
  int baI = 0;
  int baJ = 0;
  public List<byte[]> kx = Collections.synchronizedList(new LinkedList());
  final List<SoftReference<Bitmap>> ky = Collections.synchronizedList(new ArrayList());
  
  nor(int paramInt)
  {
    this.jdField_a_of_type_Not = new not(2097152);
    while (paramInt < 5)
    {
      this.kx.add(new byte[16384]);
      paramInt += 1;
    }
    this.jdField_a_of_type_Npc = new nos(this);
  }
  
  public Bitmap a(BitmapFactory.Options paramOptions)
  {
    for (;;)
    {
      int i;
      try
      {
        this.baJ += 1;
        ArrayList localArrayList = new ArrayList();
        List localList = this.ky;
        i = 0;
        try
        {
          if (i < this.ky.size())
          {
            localBitmap = (Bitmap)((SoftReference)this.ky.get(i)).get();
            if (localBitmap != null)
            {
              if (npe.canUseForInBitmap(localBitmap, paramOptions))
              {
                localArrayList.add(this.ky.get(i));
                str = "cache";
                if (!localArrayList.isEmpty()) {
                  this.ky.removeAll(localArrayList);
                }
                if (localBitmap != null) {
                  this.baI += 1;
                }
                if (QLog.isColorLevel()) {
                  npe.log(tag, "getReuseableBitmap found:" + str + " picSize:" + paramOptions.outWidth + "x" + paramOptions.outHeight + " bitmap:" + localBitmap + " state:" + toString());
                }
                return localBitmap;
              }
            }
            else {
              localArrayList.add(this.ky.get(i));
            }
          }
        }
        finally {}
        String str = "notFound";
      }
      finally {}
      Bitmap localBitmap = null;
      continue;
      i += 1;
    }
  }
  
  nov a(noz paramnoz)
  {
    if (paramnoz == null) {}
    do
    {
      return null;
      paramnoz = aqgs.a(paramnoz.getCacheKey());
    } while ((paramnoz == null) || (!paramnoz.isValid()));
    return paramnoz.a();
  }
  
  public void b(noz paramnoz, nov paramnov)
  {
    if (paramnoz == null) {}
    for (;;)
    {
      return;
      try
      {
        aqgs.a(paramnoz.getCacheKey(), paramnov);
      }
      finally {}
    }
  }
  
  public void clean()
  {
    try
    {
      this.jdField_a_of_type_Not.clean();
      this.ky.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("total:");
    localStringBuilder.append(this.baJ);
    localStringBuilder.append(" reuse:");
    localStringBuilder.append(this.baI);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nor
 * JD-Core Version:    0.7.0.1
 */