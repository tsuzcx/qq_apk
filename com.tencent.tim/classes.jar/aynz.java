import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class aynz
  extends ayob
{
  private String cXt = "15:29";
  int eLI = 0;
  int eLJ = 0;
  int eLK;
  int mHeight = 0;
  private TextPaint mTextPaint = new TextPaint();
  int mWidth = 0;
  
  public aynz(Context paramContext, String paramString)
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
      localJSONObject.put("first_line", paramString);
      paramString = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("FilmDigitInfoStickerDrawable", 2, paramString);
      }
      return paramString;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FilmDigitInfoStickerDrawable", 2, paramString, new Object[0]);
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
        String str = paramString.optString("first_line", "");
        paramString = str;
        if (str.contains("·")) {
          paramString = str.substring(0, str.indexOf("·"));
        }
        this.cXt = ChnToSpell.aJ(paramString, 1);
      }
      return new String[] { this.cXt };
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
  
  public String Iz()
  {
    return this.cXt;
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    int i = paramCanvas.saveLayer(0.0F, 0.0F, getIntrinsicWidth(), getIntrinsicWidth(), this.mTextPaint, 31);
    int j = dp2px(2.0F, this.mContext.getResources());
    float f1 = Math.abs(this.mTextPaint.getFontMetrics().ascent);
    float f2 = ((Integer)paramArrayList.get(this.eLK)).intValue() % 100 * 1.0F / 99.0F;
    this.mTextPaint.setShadowLayer(f2 * 20.0F, 0.0F, 0.0F, this.mContext.getResources().getColor(2131165811));
    paramCanvas.drawText(this.cXt, dp2px(7.0F, this.mContext.getResources()), j + f1, this.mTextPaint);
    paramCanvas.restoreToCount(i);
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
    this.mTextPaint = new TextPaint();
    this.mTextPaint.setAntiAlias(true);
    this.mTextPaint.setDither(true);
    this.mTextPaint.setColor(this.mContext.getResources().getColor(2131165810));
    Object localObject = Typeface.createFromAsset(this.mContext.getResources().getAssets(), "info_sticker_typeface/dov_digital.ttf");
    this.mTextPaint.setTypeface((Typeface)localObject);
    this.mTextPaint.setTextSize(dp2px(30.0F, this.mContext.getResources()));
    localObject = this.mTextPaint.getFontMetrics();
    this.eLJ = ((int)(((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top));
    this.eLI = ((int)this.mTextPaint.measureText(this.cXt, 0, this.cXt.length()));
    this.mWidth = (this.eLI + dp2px(7.0F, this.mContext.getResources()));
    this.mHeight = (dp2px(30.0F, this.mContext.getResources()) + dp2px(10.0F, this.mContext.getResources()));
    this.eLK = this.a.a("anim", 0L, 1000L, 0, 999, new LinearInterpolator());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aynz
 * JD-Core Version:    0.7.0.1
 */