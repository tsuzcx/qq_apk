import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class ayoh
  extends ayob
{
  ayog c;
  private String cXq = "05:36";
  private String cXr = "2017 SEPTEMBER 30";
  ayog d;
  int lineIndex = 0;
  private Paint mPaint = new Paint();
  private TextPaint mTextPaint = new TextPaint();
  
  public ayoh(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    G(paramString);
    init();
    eST();
  }
  
  private ayog a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Typeface paramTypeface, aynr paramaynr, int paramInt7)
  {
    paramTypeface = new ayog(paramInt1, paramInt2, paramTypeface, paramInt3, paramInt4, paramInt5, paramInt6);
    paramTypeface.a(paramCharSequence, paramaynr, paramInt7);
    return paramTypeface;
  }
  
  public static String k(int paramInt, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("first_line", paramString1);
      localJSONObject.put("second_line", paramString2);
      paramString1 = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("RandomTextDrawable", 2, paramString1);
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RandomTextDrawable", 2, paramString1, new Object[0]);
        }
        paramString1 = null;
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
        this.cXq = paramString.optString("first_line", "");
        this.cXr = paramString.optString("second_line", "");
      }
      return new String[] { this.cXq, this.cXr };
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      paramArrayList = this.c.Gw.iterator();
      ayoa localayoa;
      Bitmap localBitmap;
      TextPaint localTextPaint;
      while (paramArrayList.hasNext())
      {
        localayoa = (ayoa)paramArrayList.next();
        localBitmap = localayoa.mBitmap;
        localTextPaint = this.c.mPaint;
        localTextPaint.setAlpha(((Integer)this.Gv.get(localayoa.eLM)).intValue());
        i = this.c.mStartX;
        paramCanvas.drawBitmap(localBitmap, localayoa.eLL + i, this.c.mStartY, localTextPaint);
      }
      this.mPaint.setStrokeWidth(wja.dp2px(2.0F, this.mContext.getResources()));
      int i = wja.dp2px(55.0F, this.mContext.getResources());
      paramCanvas.drawLine(0.0F, i, ((Integer)this.Gv.get(this.lineIndex)).intValue(), i, this.mPaint);
      paramArrayList = this.d.Gw.iterator();
      while (paramArrayList.hasNext())
      {
        localayoa = (ayoa)paramArrayList.next();
        localBitmap = localayoa.mBitmap;
        localTextPaint = this.d.mPaint;
        localTextPaint.setAlpha(((Integer)this.Gv.get(localayoa.eLM)).intValue());
        i = this.d.mStartX;
        paramCanvas.drawBitmap(localBitmap, localayoa.eLL + i, this.d.mStartY, localTextPaint);
      }
    }
  }
  
  public int getIntrinsicHeight()
  {
    return wja.dp2px(75.0F, this.mContext.getResources());
  }
  
  public int getIntrinsicWidth()
  {
    return this.c.eeR;
  }
  
  protected void init()
  {
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setDither(true);
    this.mPaint.setColor(-1);
    this.mTextPaint = new TextPaint();
    this.mTextPaint.setAntiAlias(true);
    this.mTextPaint.setDither(true);
    this.mTextPaint.setColor(-1);
    Object localObject = this.mContext.getAssets();
    try
    {
      localTypeface1 = Typeface.createFromAsset((AssetManager)localObject, "info_sticker_typeface/roboto-medium.ttf");
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          Typeface localTypeface1;
          localObject = Typeface.createFromAsset((AssetManager)localObject, "info_sticker_typeface/roboto-regular.ttf");
          this.c = a(this.cXq, wja.dp2px(48.0F, this.mContext.getResources()), -1, 0, 0, 0, 600, localTypeface1, this.a, 0);
          this.lineIndex = this.a.a("", 300L, 500L, 0, this.c.eeR, new LinearInterpolator());
          this.d = a(this.cXr, wja.dp2px(11.0F, this.mContext.getResources()), -1, 0, wja.dp2px(60.0F, this.mContext.getResources()), 500, 800, (Typeface)localObject, this.a, this.c.eeR - 10);
          return;
          localException1 = localException1;
          Typeface localTypeface2 = Typeface.DEFAULT;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Typeface localTypeface3 = Typeface.DEFAULT;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayoh
 * JD-Core Version:    0.7.0.1
 */