import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextPaint;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.util.LRULinkedHashMap;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class abgn
  implements abgl.a
{
  static LRULinkedHashMap<String, Bitmap> j = new LRULinkedHashMap(10);
  JSONObject bd;
  Bundle mReqBundle;
  WeakReference<MessengerService> o;
  
  public abgn(JSONObject paramJSONObject, Bundle paramBundle, WeakReference<MessengerService> paramWeakReference)
  {
    this.bd = paramJSONObject;
    this.mReqBundle = paramBundle;
    this.o = paramWeakReference;
  }
  
  public Object L()
  {
    return new Object();
  }
  
  public void invalidateSelf()
  {
    Object localObject4 = this.bd.optString("text");
    int k = this.bd.optInt("width");
    int m = this.bd.optInt("height");
    int n = this.bd.optInt("fontId");
    Object localObject1 = this.bd.optString("fontColor");
    int i1 = this.bd.optInt("fontType");
    TextPaint localTextPaint = new TextPaint();
    Rect localRect = new Rect(3, 5, k - 3, m - 3);
    float f = aqgm.a(localTextPaint, localRect, (String)localObject4);
    try
    {
      i = Color.parseColor((String)localObject1);
      if (i1 == 1)
      {
        localObject3 = abgl.a().a(this, (String)localObject4, n, i1, f, i, k, m, localTextPaint);
        if (localObject3 != null) {
          localObject1 = new Bundle();
        }
      }
    }
    catch (Exception localException1)
    {
      try
      {
        do
        {
          int i;
          for (;;)
          {
            localObject4 = new ByteArrayOutputStream();
            ((Bitmap)localObject3).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject4);
            localObject3 = aqgo.encodeToString(((ByteArrayOutputStream)localObject4).toByteArray(), 2);
            ((ByteArrayOutputStream)localObject4).close();
            ((Bundle)localObject1).putBoolean("updateResult", true);
            ((Bundle)localObject1).putString("file", "data:image/png;base64," + (String)localObject3);
            this.mReqBundle.putBundle("response", (Bundle)localObject1);
            if ((this.o != null) && (this.o.get() != null)) {
              ((MessengerService)this.o.get()).cp(this.mReqBundle);
            }
            return;
            localException1 = localException1;
            i = 0;
          }
          localObject2 = abgl.a().a(this, n, i1);
          if (localObject2 != null) {
            localTextPaint.setTypeface((Typeface)localObject2);
          }
          localTextPaint.setColor(i);
          localTextPaint.setTextAlign(Paint.Align.CENTER);
          localTextPaint.setTextSize(f);
          localObject2 = localTextPaint.getFontMetrics();
          f = (localRect.bottom + localRect.top - ((Paint.FontMetrics)localObject2).bottom - ((Paint.FontMetrics)localObject2).top) / 2.0F;
          String str = k + "_" + m;
          localObject3 = (Bitmap)j.get(str);
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            localObject3 = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
            localObject2 = localObject3;
            if (localObject3 != null)
            {
              j.put(str, localObject3);
              localObject2 = localObject3;
            }
          }
          localObject3 = localObject2;
        } while (localObject2 == null);
        Object localObject3 = new Canvas((Bitmap)localObject2);
        ((Canvas)localObject3).drawColor(0, PorterDuff.Mode.CLEAR);
        ((Canvas)localObject3).drawText((String)localObject4, localRect.centerX(), f, localTextPaint);
        localObject3 = localObject2;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject2;
          ((Bundle)localObject2).putBoolean("updateResult", false);
          ((Bundle)localObject2).putString("errMsg", localException2.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abgn
 * JD-Core Version:    0.7.0.1
 */