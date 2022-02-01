package taiji;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable.Callback;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.Map;
import uilib.doraemon.b;
import uilib.doraemon.c;

public class z
{
  private final Context a;
  private String b;
  private c c;
  private final Map<String, b> d;
  
  public z(Drawable.Callback paramCallback, String paramString, c paramc, Map<String, b> paramMap)
  {
    this.b = paramString;
    if ((!TextUtils.isEmpty(paramString)) && (this.b.charAt(this.b.length() - 1) != '/')) {
      this.b += '/';
    }
    if (!(paramCallback instanceof View))
    {
      Log.w("Doraemon", "DoraemonDrawable must be inside of a view for images to work.");
      this.d = new HashMap();
      this.a = null;
      return;
    }
    this.a = ((View)paramCallback).getContext();
    this.d = paramMap;
    a(paramc);
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.c != null)
    {
      localObject1 = localObject2;
      if (this.d.get(paramString) != null) {
        localObject1 = this.c.a((b)this.d.get(paramString));
      }
    }
    return localObject1;
  }
  
  public void a() {}
  
  public void a(c paramc)
  {
    this.c = paramc;
  }
  
  public boolean a(Context paramContext)
  {
    return ((paramContext == null) && (this.a == null)) || ((paramContext != null) && (this.a.equals(paramContext)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.z
 * JD-Core Version:    0.7.0.1
 */