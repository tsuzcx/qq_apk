import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ajmq
  implements DownloadParams.DecodeHandler
{
  private static final HashMap<String, ArrayList<Integer>> lJ = new HashMap();
  WeakReference<ajmq.a> callbackRef;
  Object extra;
  String imgUrl;
  
  public ajmq(String paramString, ajmq.a parama, Object paramObject)
  {
    if (parama != null) {
      this.callbackRef = new WeakReference(parama);
    }
    this.imgUrl = paramString;
    this.extra = paramObject;
  }
  
  public static List<Integer> aD(String paramString)
  {
    return (List)lJ.get(paramString);
  }
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (this.callbackRef == null) {}
    for (paramDownloadParams = null;; paramDownloadParams = (ajmq.a)this.callbackRef.get())
    {
      if (paramDownloadParams != null)
      {
        int[] arrayOfInt = ajms.c(Bitmap.createBitmap(paramBitmap, 0, paramBitmap.getHeight() / 2, paramBitmap.getWidth(), paramBitmap.getHeight() / 2));
        if ((arrayOfInt != null) && (arrayOfInt.length >= 2))
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(Integer.valueOf(arrayOfInt[0]));
          localArrayList.add(Integer.valueOf(arrayOfInt[1]));
          if (!lJ.containsKey(this.imgUrl)) {
            lJ.put(this.imgUrl, localArrayList);
          }
        }
        paramDownloadParams.a(this.imgUrl, arrayOfInt[0], arrayOfInt[1], this.extra);
      }
      return paramBitmap;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, int paramInt1, int paramInt2, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajmq
 * JD-Core Version:    0.7.0.1
 */