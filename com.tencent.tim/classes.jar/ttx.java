import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

public class ttx
{
  private final tuh<String> a = new tuh();
  private final AssetManager assetManager;
  @Nullable
  private trr b;
  private String defaultFontFileExtension = ".ttf";
  private final Map<String, Typeface> fontFamilies = new HashMap();
  private final Map<tuh<String>, Typeface> fontMap = new HashMap();
  
  public ttx(Drawable.Callback paramCallback, @Nullable trr paramtrr)
  {
    this.b = paramtrr;
    if (!(paramCallback instanceof View))
    {
      Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
      this.assetManager = null;
      return;
    }
    this.assetManager = ((View)paramCallback).getContext().getAssets();
  }
  
  private Typeface getFontFamily(String paramString)
  {
    Object localObject1 = (Typeface)this.fontFamilies.get(paramString);
    if (localObject1 != null) {
      return localObject1;
    }
    Object localObject2 = null;
    if (this.b != null) {
      localObject2 = this.b.fetchFont(paramString);
    }
    localObject1 = localObject2;
    if (this.b != null)
    {
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        String str = this.b.getFontPath(paramString);
        localObject1 = localObject2;
        if (str != null) {
          localObject1 = Typeface.createFromAsset(this.assetManager, str);
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = "fonts/" + paramString + this.defaultFontFileExtension;
      localObject2 = Typeface.createFromAsset(this.assetManager, (String)localObject1);
    }
    this.fontFamilies.put(paramString, localObject2);
    return localObject2;
  }
  
  private Typeface typefaceForStyle(Typeface paramTypeface, String paramString)
  {
    int i = 0;
    boolean bool1 = paramString.contains("Italic");
    boolean bool2 = paramString.contains("Bold");
    if ((bool1) && (bool2)) {
      i = 3;
    }
    while (paramTypeface.getStyle() == i)
    {
      return paramTypeface;
      if (bool1) {
        i = 2;
      } else if (bool2) {
        i = 1;
      }
    }
    return Typeface.create(paramTypeface, i);
  }
  
  public void a(@Nullable trr paramtrr)
  {
    this.b = paramtrr;
  }
  
  public Typeface getTypeface(String paramString1, String paramString2)
  {
    this.a.set(paramString1, paramString2);
    Typeface localTypeface = (Typeface)this.fontMap.get(this.a);
    if (localTypeface != null) {
      return localTypeface;
    }
    paramString1 = typefaceForStyle(getFontFamily(paramString1), paramString2);
    this.fontMap.put(this.a, paramString1);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ttx
 * JD-Core Version:    0.7.0.1
 */