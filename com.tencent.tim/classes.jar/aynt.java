import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.animation.LinearInterpolator;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class aynt
  extends ayob
{
  private String cXp;
  private Rect dk;
  private Rect dl = new Rect();
  private int eLl;
  private int eLm;
  private Bitmap hO;
  private int mAlphaIndex;
  private int mHeight;
  private Paint mPaint;
  private int mWidth;
  
  public aynt(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    G(paramString);
    init();
    eST();
  }
  
  public static String S(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("city_bitmap_path", paramString);
      paramString = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("CityStickerDrawable", 2, paramString);
      }
      return paramString;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CityStickerDrawable", 2, paramString, new Object[0]);
        }
        paramString = null;
      }
    }
  }
  
  public String[] G(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString != null)
      {
        this.mType = paramString.optInt("type", 0);
        this.cXp = paramString.optString("city_bitmap_path");
      }
      return new String[] { this.cXp };
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        QLog.e("CityStickerDrawable", 1, paramString, new Object[0]);
        paramString = null;
      }
    }
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    int i;
    int k;
    if (this.hO != null)
    {
      i = 225;
      k = this.mHeight;
      if (paramArrayList == null) {
        break label200;
      }
    }
    for (;;)
    {
      try
      {
        j = ((Integer)paramArrayList.get(this.eLl)).intValue();
        int n;
        QLog.e("CityStickerDrawable", 1, paramArrayList, new Object[0]);
      }
      catch (RuntimeException paramArrayList)
      {
        try
        {
          n = ((Integer)paramArrayList.get(this.mAlphaIndex)).intValue();
          i = n;
          m = ((Integer)paramArrayList.get(this.eLm)).intValue();
          k = n;
          i = j;
          j = m;
          this.mPaint.setAlpha(k);
          paramCanvas.save();
          this.dl.set(this.dk);
          this.dl.offset(0, i);
          paramCanvas.clipRect(0, 0, this.mWidth, j);
          paramCanvas.drawBitmap(this.hO, null, this.dl, this.mPaint);
          paramCanvas.restore();
          return;
        }
        catch (RuntimeException paramArrayList)
        {
          for (;;)
          {
            int m = j;
            j = i;
            i = m;
          }
        }
        paramArrayList = paramArrayList;
        j = 225;
        i = 0;
      }
      m = j;
      int j = k;
      k = m;
      continue;
      label200:
      j = k;
      k = 225;
      i = 0;
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.mHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mWidth;
  }
  
  protected void init()
  {
    if ((this.cXp != null) && (new File(this.cXp).exists()))
    {
      this.hO = BitmapFactory.decodeFile(this.cXp);
      this.mPaint = new Paint(1);
      float f1 = this.hO.getWidth() / 3.0F;
      float f2 = this.hO.getHeight() / 3.0F;
      int i = dp2px(f1, this.mContext.getResources());
      int j = dp2px(f2, this.mContext.getResources());
      this.mWidth = i;
      this.mHeight = j;
      this.dk = new Rect(0, 0, i, j);
      i = dp2px(15.0F, this.mContext.getResources());
      this.eLl = this.a.a("offsetY", 0L, 500L, -i, 0, new LinearInterpolator());
      this.mAlphaIndex = this.a.a("alpha", 0L, 500L, 0, 255, new LinearInterpolator());
      this.eLm = this.a.a("height", 0L, 500L, 0, this.mHeight, new LinearInterpolator());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aynt
 * JD-Core Version:    0.7.0.1
 */