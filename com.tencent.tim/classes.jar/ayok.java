import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ayok
  extends ayob
{
  private static int eLD = 30;
  private static int eLE = 30;
  private int bRa;
  private String cXC = "";
  private String cXD = "SHENZHEN";
  private String cXw = acfp.m(2131715445);
  private String cdp = "";
  private Rect dn = new Rect(0, 0, 0, 0);
  private int eLB;
  private int eLC;
  private int eLF;
  private int eLW;
  private int eLX;
  private int eLY;
  private int eLZ;
  private int eMa = 8;
  private int eMb = 4;
  private int eMc;
  private int eMd;
  private int eMe;
  private int eMf;
  private Bitmap hP;
  private Bitmap hT;
  private Bitmap hU;
  private int mHeight;
  private int mIconHeight;
  private Paint mPaint = new Paint();
  private TextPaint mTextPaint = new TextPaint();
  private int mTextWidth;
  private int mWidth;
  private Typeface p;
  private Typeface v;
  private TextPaint x = new TextPaint();
  
  public ayok(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    G(this.mData);
    init();
    eST();
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("iconpath", paramString1);
      localJSONObject.put("ttfpath", paramString2);
      localJSONObject.put("locationString", paramString3);
      paramString1 = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("TriangleLocationStickerDrawble", 2, paramString1);
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TriangleLocationStickerDrawble", 2, paramString1, new Object[0]);
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
        this.cXC = paramString.optString("ttfpath", "");
        this.cXw = paramString.optString("locationString", "");
      }
      return new String[] { this.cdp, this.cXC, this.cXw };
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
    int i = 0;
    int j = ((Integer)paramArrayList.get(this.eLC)).intValue();
    this.mPaint.setAlpha(j);
    j = ((Integer)paramArrayList.get(this.eLB)).intValue();
    if (j != 0)
    {
      i = (int)(j * this.mTextWidth / 100.0D);
      localRect1 = new Rect((this.mTextWidth - i) / 2, 0, (this.mTextWidth + i) / 2, this.eMf);
      Rect localRect2 = new Rect((this.mWidth - i) / 2, eLD, (this.mWidth + i) / 2, eLD + this.eMf);
      paramCanvas.drawBitmap(this.hU, localRect1, localRect2, this.mPaint);
      i = ((Integer)paramArrayList.get(this.eLY)).intValue() + i / 2;
    }
    int k = ((Integer)paramArrayList.get(this.eLW)).intValue();
    j = k;
    if (k == this.eMd) {
      j = ((Integer)paramArrayList.get(this.eLX)).intValue();
    }
    j = this.bRa - j - this.mIconHeight - dp2px(1.0F, this.mContext.getResources());
    k = this.mWidth / 2 - this.eLF - i;
    i += this.mWidth / 2;
    paramArrayList = new Rect(k, eLD + j, this.eLF + k, this.mIconHeight + j + eLD);
    Rect localRect1 = new Rect(i, eLD + j, this.eLF + i, j + this.mIconHeight + eLD);
    if (this.hP != null) {
      paramCanvas.drawBitmap(this.hP, this.dn, paramArrayList, this.mPaint);
    }
    if (this.hT != null) {
      paramCanvas.drawBitmap(this.hT, this.dn, localRect1, this.mPaint);
    }
  }
  
  public String getFontPath()
  {
    return this.cXC;
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
    int k = 0;
    this.cXw = TroopBarPOI.oC(this.cXw);
    label134:
    label401:
    label446:
    int i;
    int j;
    Object localObject1;
    if ((this.cXw == null) || (TextUtils.isEmpty(this.cXw)))
    {
      this.cXw = acfp.m(2131715443);
      this.cXD = "YOUR CITY";
      if ((this.cXD == null) || (TextUtils.isEmpty(this.cXD))) {
        this.cXD = "YOUR CITY";
      }
      eLD = dp2px(15.0F, this.mContext.getResources());
      eLE = eLD;
      this.p = Typeface.createFromAsset(this.mContext.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
      if (!aqhq.fileExists(this.cXC)) {
        break label1278;
      }
      this.v = Typeface.createFromFile(this.cXC);
      if (this.v == null) {
        this.v = Typeface.createFromAsset(this.mContext.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
      }
      this.eLZ = dp2px(24.0F, this.mContext.getResources());
      this.eMb = dp2px(3.0F, this.mContext.getResources());
      this.eMa = dp2px(4.5F, this.mContext.getResources());
      this.mPaint = new Paint();
      this.mPaint.setAntiAlias(true);
      this.mPaint.setDither(true);
      this.mTextPaint.setAntiAlias(true);
      this.mTextPaint.setDither(true);
      this.mTextPaint.setColor(-1);
      this.mTextPaint.setTypeface(this.v);
      this.mTextPaint.setTextSize(dp2px(28.0F, this.mContext.getResources()));
      this.x.setAntiAlias(true);
      this.x.setDither(true);
      this.x.setColor(-1);
      this.x.setTypeface(this.p);
      this.x.setFakeBoldText(true);
      this.x.setTextSize(dp2px(9.0F, this.mContext.getResources()));
      if (Build.VERSION.SDK_INT < 21) {
        break label1288;
      }
      this.mTextPaint.setShadowLayer(ayob.eLN, 0.0F, 0.0F, 1711276032);
      this.x.setShadowLayer(ayob.eLN, 0.0F, 0.0F, 1711276032);
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.mTextPaint.setLetterSpacing(0.0F);
        this.x.setLetterSpacing(0.0F);
      }
      if (!aqhq.fileExists(this.cdp)) {
        break label1313;
      }
      this.hT = BitmapFactory.decodeFile(this.cdp);
      if (this.hT == null) {
        break label1414;
      }
      i = this.hT.getWidth();
      j = this.hT.getHeight();
      localObject1 = new Matrix();
      ((Matrix)localObject1).setRotate(180.0F, i / 2.0F, j / 2.0F);
      this.hP = Bitmap.createBitmap(this.hT, 0, 0, i, j, (Matrix)localObject1, true);
    }
    for (;;)
    {
      this.dn = new Rect(0, 0, i, j);
      this.mIconHeight = dp2px(20.5F, this.mContext.getResources());
      this.eLF = dp2px(10.5F, this.mContext.getResources());
      this.dn.left = 0;
      this.dn.top = 0;
      this.dn.right = i;
      this.dn.bottom = j;
      i = (int)this.mTextPaint.measureText(this.cXw) + this.eMb * (this.cXw.length() - 1);
      int m = (int)this.x.measureText(this.cXD) + this.eMa * (this.cXD.length() - 1);
      if (i > m) {}
      Object localObject2;
      for (this.mTextWidth = i;; this.mTextWidth = m)
      {
        this.mWidth = (this.mTextWidth + (this.eLF + this.eLZ) * 2 + eLE * 2);
        localObject1 = this.mTextPaint.getFontMetrics();
        localObject2 = this.x.getFontMetrics();
        this.eMc = (-(int)((Paint.FontMetrics)localObject1).top);
        j = -(int)((Paint.FontMetrics)localObject2).top;
        this.eMd = (dp2px(33.0F, this.mContext.getResources()) + dp2px(5.0F, this.mContext.getResources()));
        this.eMe = (this.eMd - dp2px(5.0F, this.mContext.getResources()));
        this.eMf = (this.eMc + j + dp2px(4.0F, this.mContext.getResources()));
        this.mHeight = (j + this.eMc + dp2px(3.0F, this.mContext.getResources()) + eLD * 2);
        this.bRa = (this.eMc + this.eMe + dp2px(5.0F, this.mContext.getResources()));
        this.eLC = this.a.a("T", 0L, 165L, 0, 255, new LinearInterpolator());
        this.eLW = this.a.a("X", 0L, 330L, 0, this.eMd, new DecelerateInterpolator());
        this.eLX = this.a.a("X", 330L, 340L, this.eMd, this.eMe, new AccelerateInterpolator());
        this.eLB = this.a.a("X", 825L, 200L, 0, 100, new DecelerateInterpolator());
        this.eLY = this.a.a("X", 825L, 355L, dp2px(10.0F, this.mContext.getResources()), dp2px(20.0F, this.mContext.getResources()), new DecelerateInterpolator());
        if (this.hU != null) {
          break label1413;
        }
        this.hU = Bitmap.createBitmap(this.mTextWidth, this.eMf, Bitmap.Config.ARGB_8888);
        localObject1 = new Canvas(this.hU);
        j = (this.mTextWidth - i) / 2;
        i = 0;
        while (i < this.cXw.length())
        {
          localObject2 = this.cXw.substring(i, i + 1);
          ((Canvas)localObject1).drawText((String)localObject2, j, this.eMc, this.mTextPaint);
          j = j + (int)this.mTextPaint.measureText((String)localObject2) + this.eMb;
          i += 1;
        }
        this.cXD = ChnToSpell.aJ(this.cXw, 1);
        this.cXD = this.cXD.toUpperCase();
        if ((this.cXw == null) || (this.cXw.contains(acfp.m(2131715447))) || (this.cXw.contains(acfp.m(2131715446))) || (this.cXw.endsWith(acfp.m(2131715441))) || (this.cXw.endsWith(acfp.m(2131715442)))) {
          break;
        }
        this.cXw += acfp.m(2131715444);
        break;
        label1278:
        this.v = Typeface.DEFAULT_BOLD;
        break label134;
        label1288:
        this.mTextPaint.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
        this.x.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
        break label401;
        label1313:
        QLog.e("TriangleLocationStickerDrawble", 2, "mIconPath not exist");
        break label446;
      }
      j = (this.mTextWidth - m) / 2;
      i = k;
      while (i < this.cXD.length())
      {
        localObject2 = this.cXD.substring(i, i + 1);
        ((Canvas)localObject1).drawText((String)localObject2, j, this.eMf, this.x);
        j = j + (int)this.x.measureText((String)localObject2) + this.eMa;
        i += 1;
      }
      label1413:
      return;
      label1414:
      j = 0;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayok
 * JD-Core Version:    0.7.0.1
 */