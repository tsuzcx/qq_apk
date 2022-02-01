import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class aynx
  extends ayob
{
  private static int eLD = 30;
  private static int eLE = 30;
  private String cXw;
  private String cdp = "";
  private Rect dn = new Rect(0, 0, 0, 0);
  private int eLB;
  private int eLC;
  private int eLF;
  private int eLG = 16;
  private int eLH = 16;
  private Bitmap hP;
  private int mHeight;
  private int mIconHeight;
  private Paint mPaint = new Paint();
  private TextPaint mTextPaint = new TextPaint();
  private int mWidth;
  private Typeface p;
  
  public aynx(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    G(this.mData);
    init();
    eST();
  }
  
  public static String k(int paramInt, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("iconpath", paramString1);
      localJSONObject.put("locationString", paramString2);
      paramString1 = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("ExpandLocationStickerDrawable", 2, paramString1);
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ExpandLocationStickerDrawable", 2, paramString1, new Object[0]);
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
        this.cdp = paramString.optString("iconpath", "");
        this.cXw = paramString.optString("locationString", "");
      }
      return new String[] { this.cdp, this.cXw };
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
  
  public String Iy()
  {
    return this.cdp;
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    int k = eLD + 0;
    int i = eLE;
    int m = ((Integer)paramArrayList.get(this.eLB)).intValue();
    i += (this.cXw.length() - 1) * (this.eLG - m) / 2;
    int j = ((Integer)paramArrayList.get(this.eLC)).intValue();
    this.mPaint.setAlpha(j);
    this.mTextPaint.setAlpha(j);
    ayog.a(j, this.mTextPaint);
    paramArrayList = new Rect(i, dp2px(1.0F, this.mContext.getResources()) + k, this.eLF + i, this.mIconHeight + k + dp2px(1.0F, this.mContext.getResources()));
    if (this.hP != null) {
      paramCanvas.drawBitmap(this.hP, this.dn, paramArrayList, this.mPaint);
    }
    j = this.eLF;
    j = this.eLH + (j + i);
    i = 0;
    while (i < this.cXw.length())
    {
      paramArrayList = this.cXw.substring(i, i + 1);
      paramCanvas.drawText(paramArrayList, j, this.mIconHeight + k, this.mTextPaint);
      j = j + (int)this.mTextPaint.measureText(paramArrayList) + m;
      i += 1;
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
    this.mPaint.setAntiAlias(true);
    this.mPaint.setDither(true);
    eLD = dp2px(15.0F, this.mContext.getResources());
    eLE = eLD;
    this.eLH = dp2px(10.0F, this.mContext.getResources());
    this.mTextPaint.setAntiAlias(true);
    this.mTextPaint.setDither(true);
    this.mTextPaint.setColor(-1);
    this.eLG = dp2px(9.0F, this.mContext.getResources());
    this.cXw = TroopBarPOI.oC(this.cXw);
    Paint.FontMetrics localFontMetrics;
    label313:
    int j;
    int i;
    if ((this.cXw != null) && (!TextUtils.isEmpty(this.cXw)))
    {
      this.cXw = ChnToSpell.aJ(this.cXw, 1);
      this.cXw = this.cXw.toUpperCase();
      this.p = Typeface.createFromAsset(this.mContext.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
      this.mTextPaint.setTypeface(this.p);
      this.mTextPaint.setFakeBoldText(true);
      this.mTextPaint.setTextSize(dp2px(15.0F, this.mContext.getResources()));
      localFontMetrics = this.mTextPaint.getFontMetrics();
      if (Build.VERSION.SDK_INT >= 21) {
        this.mTextPaint.setLetterSpacing(0.0F);
      }
      this.eLB = this.a.a("X", 190L, 630L, 0, this.eLG, new DecelerateInterpolator());
      this.eLC = this.a.a("T", 190L, 2110L, 0, 255, new DecelerateInterpolator());
      if (!aqhq.fileExists(this.cdp)) {
        break label495;
      }
      this.hP = BitmapFactory.decodeFile(this.cdp);
      if (this.hP == null) {
        break label507;
      }
      j = this.hP.getWidth();
      i = this.hP.getHeight();
    }
    for (;;)
    {
      this.dn = new Rect(0, 0, j, i);
      this.mIconHeight = (-(int)localFontMetrics.ascent - (int)localFontMetrics.descent + dp2px(3.0F, this.mContext.getResources()));
      if (i != 0) {
        this.eLF = (j * this.mIconHeight / i);
      }
      this.mHeight = (this.mIconHeight + eLD * 2);
      float f = this.mTextPaint.measureText(this.cXw);
      i = this.eLF;
      j = eLE;
      int k = this.eLH;
      this.mWidth = ((int)f + (i + j * 2 + k) + this.eLG * (this.cXw.length() - 1) + dp2px(3.0F, this.mContext.getResources()));
      return;
      this.cXw = "YOUR CITY";
      break;
      label495:
      QLog.e("ExpandLocationStickerDrawable", 2, "mIconPath not exist");
      break label313;
      label507:
      i = 0;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aynx
 * JD-Core Version:    0.7.0.1
 */