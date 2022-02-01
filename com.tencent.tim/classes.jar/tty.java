import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class tty
{
  @Nullable
  private trs b;
  private final Context context;
  private final Map<String, Bitmap> gY = new HashMap();
  private final Map<String, tse> imageAssets;
  private String imagesFolder;
  
  public tty(Drawable.Callback paramCallback, String paramString, trs paramtrs, Map<String, tse> paramMap)
  {
    this.imagesFolder = paramString;
    if ((!TextUtils.isEmpty(paramString)) && (this.imagesFolder.charAt(this.imagesFolder.length() - 1) != '/')) {
      this.imagesFolder += '/';
    }
    if (!(paramCallback instanceof View))
    {
      Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
      this.imageAssets = new HashMap();
      this.context = null;
      return;
    }
    this.context = ((View)paramCallback).getContext();
    this.imageAssets = paramMap;
    a(paramtrs);
  }
  
  public void a(@Nullable trs paramtrs)
  {
    this.b = paramtrs;
  }
  
  @Nullable
  public Bitmap bitmapForId(String paramString)
  {
    Object localObject2 = (Bitmap)this.gY.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = (tse)this.imageAssets.get(paramString);
      if (localObject1 != null) {
        break label42;
      }
      localObject1 = null;
    }
    label42:
    do
    {
      return localObject1;
      if (this.b == null) {
        break;
      }
      localObject2 = this.b.a((tse)localObject1);
      localObject1 = localObject2;
    } while (localObject2 == null);
    this.gY.put(paramString, localObject2);
    return localObject2;
    try
    {
      if (TextUtils.isEmpty(this.imagesFolder)) {
        throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
      }
    }
    catch (IOException paramString)
    {
      Log.w("LOTTIE", "Unable to open asset.", paramString);
      return null;
    }
    localObject1 = this.context.getAssets().open(this.imagesFolder + ((tse)localObject1).getFileName());
    localObject2 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject2).inScaled = true;
    ((BitmapFactory.Options)localObject2).inDensity = 160;
    localObject1 = BitmapFactory.decodeStream((InputStream)localObject1, null, (BitmapFactory.Options)localObject2);
    this.gY.put(paramString, localObject1);
    return localObject1;
  }
  
  public boolean hasSameContext(Context paramContext)
  {
    return ((paramContext == null) && (this.context == null)) || ((paramContext != null) && (this.context.equals(paramContext)));
  }
  
  public void recycleBitmaps()
  {
    Iterator localIterator = this.gY.entrySet().iterator();
    while (localIterator.hasNext())
    {
      ((Bitmap)((Map.Entry)localIterator.next()).getValue()).recycle();
      localIterator.remove();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tty
 * JD-Core Version:    0.7.0.1
 */