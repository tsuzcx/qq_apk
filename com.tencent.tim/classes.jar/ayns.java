import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ayns
  extends ayob
{
  private static int eKN;
  private static int eKO = 1;
  private static int eKP = 2;
  private static int eKQ = 3;
  private static int eKR = 4;
  private static int eKS = 5;
  private String cXl;
  private String cXm;
  private String cXn;
  private String cXo;
  private int eKT;
  private int eKU;
  private int eKV;
  private int eKW;
  private int eKX;
  private int eKY;
  private int eKZ = 4;
  private int eLa = 1;
  private int eLb = 22;
  private int eLc = 2;
  private int eLd = 73;
  private int eLe = 62;
  private int eLf;
  private int eLg;
  private int eLh;
  private int eLi;
  private int eLj;
  private int eLk = 4;
  private Bitmap hG;
  private Bitmap hH;
  private Bitmap hI;
  private Bitmap hJ;
  private Bitmap hK;
  private Bitmap hL;
  private Bitmap hM;
  private Bitmap hN;
  private int mHeight;
  private int mIndex;
  private Paint mPaint = new Paint();
  private TextPaint mTextPaint = new TextPaint();
  private int mWidth;
  private Typeface o;
  private int space = 4;
  private int[] uj;
  private int[] uk;
  private int[] ul;
  private Canvas w;
  private Canvas x;
  private Canvas y;
  private Canvas z;
  
  public ayns(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    G(this.mData);
    init();
    eST();
  }
  
  private Matrix a(int paramInt)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[2] = this.eLd;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = this.eLd;
    arrayOfFloat[5] = this.eLe;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = this.eLe;
    if (paramInt >= 0) {
      if (paramInt < 50)
      {
        f1 = paramInt / 50.0F;
        j = this.eLd + (int)((this.eKV - this.eLd) * f1);
        paramInt = (this.eKT - j) / 2;
        i = this.eKT / 2;
        j /= 2;
        k = this.eKT / 2;
        m = this.eLd / 2;
        n = this.eKT / 2;
        i1 = this.eLd / 2;
        i2 = (int)((1.0F - f1) * this.eLe);
        i2 = this.eLe - i2;
        i3 = this.eLe;
        f1 = paramInt;
        f2 = i2;
        f3 = i + j;
        f4 = i2;
        f5 = i1 + n;
        f6 = i3;
        f7 = k - m;
        f8 = i3;
        paramInt = arrayOfFloat.length / 2;
        localMatrix.setPolyToPoly(arrayOfFloat, 0, new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, 0, paramInt);
      }
    }
    while (paramInt <= -50)
    {
      return localMatrix;
      i = paramInt;
      if (paramInt > 100) {
        i = 100;
      }
      f1 = (i - 50) / 50.0F;
      j = this.eLd + (int)((this.eKV - this.eLd) * (1.0D - f1));
      paramInt = (this.eKT - j) / 2;
      i = this.eKT / 2;
      j /= 2;
      k = this.eKT / 2;
      m = this.eLd / 2;
      n = this.eKT / 2;
      i1 = this.eLd / 2;
      i2 = (int)(f1 * this.eLe);
      f1 = k - m;
      f2 = 0;
      f3 = i1 + n;
      f4 = 0;
      f5 = i + j;
      f6 = i2;
      f7 = paramInt;
      f8 = i2;
      paramInt = arrayOfFloat.length / 2;
      localMatrix.setPolyToPoly(arrayOfFloat, 0, new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, 0, paramInt);
      return localMatrix;
    }
    float f1 = (paramInt + 50) / 50.0F;
    int j = this.eKW + (int)((this.eLd - this.eKW) * f1);
    paramInt = (this.eKT - j) / 2;
    int i = this.eKT / 2;
    j /= 2;
    int k = this.eKT / 2;
    int m = this.eLd / 2;
    int n = this.eKT / 2;
    int i1 = this.eLd / 2;
    int i2 = (int)(f1 * this.eLe);
    i2 = this.eLe - i2;
    int i3 = this.eLe;
    f1 = paramInt;
    float f2 = i2;
    float f3 = i + j;
    float f4 = i2;
    float f5 = i1 + n;
    float f6 = i3;
    float f7 = k - m;
    float f8 = i3;
    paramInt = arrayOfFloat.length / 2;
    localMatrix.setPolyToPoly(arrayOfFloat, 0, new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, 0, paramInt);
    return localMatrix;
  }
  
  public static String a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      localJSONObject.put("upFilePath", paramString1);
      localJSONObject.put("downFilePath", paramString2);
      localJSONObject.put("nowHhmm", paramString3);
      localJSONObject.put("lastHhmm", paramString4);
      paramString1 = localJSONObject.toString();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CalendarTimeStickerDrawable", 2, paramString1, new Object[0]);
      }
    }
    return null;
  }
  
  private void a(String paramString, Canvas paramCanvas)
  {
    int k = 0;
    if (paramString.length() != 4) {
      return;
    }
    Object localObject = this.mTextPaint.getFontMetrics();
    int m = (int)((Paint.FontMetrics)localObject).descent;
    int n = (int)((Paint.FontMetrics)localObject).top;
    int i1 = dp2px(2.0F, this.mContext.getResources());
    localObject = new Rect(0, 0, 0, this.eLe);
    Rect localRect1 = new Rect(0, this.eLe + this.eLc, 0, this.eLe * 2 + this.eLc);
    int j;
    int i;
    if (this.hI != null)
    {
      j = this.hI.getWidth();
      i = this.hI.getHeight();
    }
    for (;;)
    {
      Rect localRect2 = new Rect(0, 0, j, i);
      i = k;
      while (i < 4)
      {
        String str = paramString.substring(i, i + 1);
        k = (int)this.mTextPaint.measureText(str);
        j = this.eLd;
        k = (this.eLd - k) / 2;
        int i2 = (this.eLe + (m - n - i1)) / 2;
        ((Rect)localObject).left = (this.eLd * i);
        ((Rect)localObject).right = (((Rect)localObject).left + this.eLd);
        if (this.hI != null) {
          paramCanvas.drawBitmap(this.hI, localRect2, (Rect)localObject, this.mPaint);
        }
        localRect1.left = ((Rect)localObject).left;
        localRect1.right = ((Rect)localObject).right;
        if (this.hJ != null) {
          paramCanvas.drawBitmap(this.hJ, localRect2, localRect1, this.mPaint);
        }
        paramCanvas.drawText(str, k + j * i, i2, this.mTextPaint);
        i += 1;
      }
      break;
      i = 0;
      j = 0;
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
        this.cXl = paramString.optString("upFilePath", "");
        this.cXm = paramString.optString("downFilePath", "");
        this.cXn = paramString.optString("nowHhmm", "");
        this.cXo = paramString.optString("lastHhmm", "");
      }
      return new String[] { this.cXl, this.cXm, this.cXn };
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
  
  public String Iw()
  {
    return this.cXl;
  }
  
  public String Ix()
  {
    return this.cXm;
  }
  
  protected void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList)
  {
    int m = ((Integer)paramArrayList.get(this.eLh)).intValue();
    this.mPaint.setAlpha(m);
    int j;
    int i;
    label52:
    Rect localRect1;
    Rect localRect2;
    Rect localRect3;
    Rect localRect4;
    int k;
    if (((Integer)paramArrayList.get(this.eLi)).intValue() >= 1000)
    {
      j = eKS;
      i = 0;
      if (i >= 4) {
        break label665;
      }
      localRect1 = new Rect(0, 0, 0, 0);
      localRect2 = new Rect(0, 0, 0, 0);
      localRect3 = new Rect(0, 0, 0, this.eLe);
      localRect4 = new Rect(0, this.eLe + this.eLc, 0, this.eLe * 2 + this.eLc);
      localRect1.top = (this.space + this.eLk);
      localRect1.bottom = (localRect1.top + this.eLe);
      k = 0;
      if (i > 1) {
        k = this.eLb - this.space;
      }
      localRect1.left = (k + (this.eLd + this.space) * i + this.eLk);
      localRect1.right = (localRect1.left + this.eLd);
      localRect3.left = (this.eLd * i);
      localRect3.right = (localRect3.left + this.eLd);
      localRect2.top = (this.space + this.eLe + this.eLc + this.eLk);
      localRect2.bottom = (localRect2.top + this.eLe);
      localRect2.left = localRect1.left;
      localRect2.right = localRect1.right;
      localRect4.left = localRect3.left;
      localRect4.right = localRect3.right;
      k = 3 - i;
      if (j != eKS) {
        break label464;
      }
      paramCanvas.drawBitmap(this.hG, localRect3, localRect1, this.mPaint);
      paramCanvas.drawBitmap(this.hG, localRect4, localRect2, this.mPaint);
    }
    for (;;)
    {
      i += 1;
      break label52;
      if (m < 255)
      {
        j = eKN;
        break;
      }
      i = 1;
      k = 0;
      for (;;)
      {
        j = i;
        if (k >= this.eLa) {
          break;
        }
        j = i;
        if (((Integer)paramArrayList.get(this.uk[k])).intValue() == 100) {
          j = i + 1;
        }
        i = j;
        if (j == this.eLa + 1) {
          i = eKS;
        }
        k += 1;
      }
      label464:
      if (j == eKN)
      {
        paramCanvas.drawBitmap(this.hH, localRect3, localRect1, this.mPaint);
        paramCanvas.drawBitmap(this.hH, localRect4, localRect2, this.mPaint);
      }
      else if (j - 1 < k)
      {
        paramCanvas.drawBitmap(this.hH, localRect3, localRect1, this.mPaint);
        paramCanvas.drawBitmap(this.hH, localRect4, localRect2, this.mPaint);
      }
      else if (j - 1 > k)
      {
        paramCanvas.drawBitmap(this.hG, localRect3, localRect1, this.mPaint);
        paramCanvas.drawBitmap(this.hG, localRect4, localRect2, this.mPaint);
      }
      else if (j - 1 == k)
      {
        k = ((Integer)paramArrayList.get(this.ul[k])).intValue();
        if (k > 0)
        {
          this.mPaint.setAlpha(k);
          paramCanvas.drawBitmap(this.hH, localRect4, localRect2, this.mPaint);
          this.mPaint.setAlpha(m);
        }
      }
    }
    label665:
    if ((j != eKN) && (j != eKS))
    {
      k = j - 1;
      j = 3 - k;
      i = ((Integer)paramArrayList.get(this.uj[k])).intValue();
      k = ((Integer)paramArrayList.get(this.uk[k])).intValue();
      if (i > -50)
      {
        paramArrayList = a(i);
        localRect1 = new Rect(0, 0, 0, this.eLe);
        localRect1.left = (this.eLd * j);
        localRect1.right = (localRect1.left + this.eLd);
        int n = (int)((i + 50) * 255.0D / 50.0D);
        this.w.drawColor(0, PorterDuff.Mode.CLEAR);
        this.x.drawColor(0, PorterDuff.Mode.CLEAR);
        this.w.drawBitmap(this.hG, localRect1, new Rect(0, 0, this.eLd, this.eLe), this.mPaint);
        this.x.drawBitmap(this.hK, paramArrayList, this.mPaint);
        paramArrayList = new Rect(0, 0, 0, 0);
        paramArrayList.top = (this.space + this.eLk);
        paramArrayList.bottom = (paramArrayList.top + this.eLe);
        i = 0;
        if (j > 1) {
          i = this.eLb - this.space;
        }
        paramArrayList.left = (i + (this.eLd + this.space) * j + this.eLk - this.eKZ);
        paramArrayList.right = (paramArrayList.left + this.eKV);
        this.mPaint.setAlpha(n);
        paramCanvas.drawBitmap(this.hL, new Rect(0, 0, this.eKV, this.eKX), paramArrayList, this.mPaint);
        this.mPaint.setAlpha(m);
      }
      if (k < 50)
      {
        paramArrayList = a(k);
        localRect1 = new Rect(0, 0, 0, this.eLe);
        localRect1.left = (this.eLd * j);
        localRect1.right = (localRect1.left + this.eLd);
        this.y.drawColor(0, PorterDuff.Mode.CLEAR);
        this.z.drawColor(0, PorterDuff.Mode.CLEAR);
        this.y.drawBitmap(this.hH, localRect1, new Rect(0, 0, this.eLd, this.eLe), this.mPaint);
        this.z.drawBitmap(this.hM, paramArrayList, this.mPaint);
        paramArrayList = new Rect(0, 0, 0, 0);
        paramArrayList.top = (this.space + this.eLk);
        paramArrayList.bottom = (paramArrayList.top + this.eLe);
        i = 0;
        if (j > 1) {
          i = this.eLb - this.space;
        }
        paramArrayList.left = (i + (this.eLd + this.space) * j + this.eLk - this.eKZ);
        paramArrayList.right = (paramArrayList.left + this.eKV);
        paramCanvas.drawBitmap(this.hN, new Rect(0, 0, this.eKV, this.eKX), paramArrayList, this.mPaint);
      }
      if (k > 50)
      {
        paramArrayList = a(k);
        localRect1 = new Rect(0, this.eLe + this.eLc, 0, this.eLe * 2 + this.eLc);
        localRect1.left = (this.eLd * j);
        localRect1.right = (localRect1.left + this.eLd);
        this.y.drawColor(0, PorterDuff.Mode.CLEAR);
        this.z.drawColor(0, PorterDuff.Mode.CLEAR);
        this.y.drawBitmap(this.hG, localRect1, new Rect(0, 0, this.eLd, this.eLe), this.mPaint);
        this.z.drawBitmap(this.hM, paramArrayList, this.mPaint);
        paramArrayList = new Rect(0, 0, 0, 0);
        paramArrayList.top = (this.space + this.eLe + this.eLc + this.eLk);
        paramArrayList.bottom = (paramArrayList.top + this.eLe);
        i = 0;
        if (j > 1) {
          i = this.eLb - this.space;
        }
        paramArrayList.left = (i + j * (this.eLd + this.space) + this.eLk - this.eKZ);
        paramArrayList.right = (paramArrayList.left + this.eKV);
        paramCanvas.drawBitmap(this.hN, new Rect(0, 0, this.eKV, this.eKX), paramArrayList, this.mPaint);
      }
    }
  }
  
  public void eSS()
  {
    int i = 0;
    if (this.cXn.length() != 4) {
      this.cXn = "0000";
    }
    if (this.cXo.length() != 4) {
      this.cXo = "0000";
    }
    this.eLa = 0;
    while (i < 4)
    {
      if (!this.cXn.substring(i, i + 1).equals(this.cXo.substring(i, i + 1))) {
        this.eLa += 1;
      }
      i += 1;
    }
    if (this.eLa == 0) {
      this.eLa = 1;
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
    eSS();
    this.eLh = this.a.a("alpha", 165L, 500, 0, 255, new LinearInterpolator());
    this.uj = new int[this.eLa];
    this.uk = new int[this.eLa];
    this.ul = new int[this.eLa];
    int i = 500;
    int j = 0;
    while (j < this.eLa)
    {
      this.uj[j] = this.a.a("alpha", i, 500, -40, 0, new LinearInterpolator());
      this.uk[j] = this.a.a("frontFlip", i, 500, 0, 100, new LinearInterpolator());
      this.ul[j] = this.a.a("groundOldFlip", i, 500, 255, 0, new LinearInterpolator());
      QLog.e("CalendarTimeStickerDrawable", 2, "groundOldFlip[i]: " + this.ul[j]);
      j += 1;
      i += 500;
    }
    this.eLj = i;
    this.eLi = this.a.a("alpha", 0L, this.eLj, 0, 100, new LinearInterpolator());
    this.o = Typeface.createFromAsset(this.mContext.getResources().getAssets(), "info_sticker_typeface/roboto-medium.ttf");
    this.mPaint.setAntiAlias(true);
    this.mPaint.setDither(true);
    this.mTextPaint.setTextSize(dp2px(60.0F, this.mContext.getResources()));
    this.mTextPaint.setAntiAlias(true);
    this.mTextPaint.setDither(true);
    this.mTextPaint.setColor(-1);
    this.mTextPaint.setTypeface(this.o);
    this.mTextPaint.setAlpha(255);
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.mTextPaint.setShadowLayer(ayob.eLN, 0.0F, 0.0F, 1711276032);
      this.eLk = dp2px(2.0F, this.mContext.getResources());
      this.space = dp2px(1.0F, this.mContext.getResources());
      this.eLb = dp2px(11.0F, this.mContext.getResources());
      this.eLc = dp2px(1.0F, this.mContext.getResources());
      this.eLd = dp2px(36.5F, this.mContext.getResources());
      this.eLe = dp2px(31.0F, this.mContext.getResources());
      this.eKZ = dp2px(2.0F, this.mContext.getResources());
      this.eKV = (this.eLd + this.eKZ * 2);
      this.eKW = ((int)(this.eLd * 2.0D / 3.0D));
      this.eKX = this.eLe;
      this.eKY = 0;
      this.mWidth = (this.space * 4 + this.eLb + this.eLd * 4 + this.eLk * 2);
      this.mHeight = (this.space * 2 + this.eLc + this.eLe * 2 + this.eLk * 2);
      this.eKT = this.eKV;
      this.eKU = this.eLe;
      this.hK = Bitmap.createBitmap(this.eLd, this.eLe, Bitmap.Config.ARGB_8888);
      this.w = new Canvas(this.hK);
      this.hL = Bitmap.createBitmap(this.eKT, this.eKU, Bitmap.Config.ARGB_8888);
      this.x = new Canvas(this.hL);
      this.hM = Bitmap.createBitmap(this.eLd, this.eLe, Bitmap.Config.ARGB_8888);
      this.y = new Canvas(this.hM);
      this.hN = Bitmap.createBitmap(this.eKT, this.eKU, Bitmap.Config.ARGB_8888);
      this.z = new Canvas(this.hN);
      if (!aqhq.fileExists(this.cXl)) {
        break label937;
      }
      this.hI = BitmapFactory.decodeFile(this.cXl);
      label768:
      if (!aqhq.fileExists(this.cXm)) {
        break label949;
      }
      this.hJ = BitmapFactory.decodeFile(this.cXm);
    }
    for (;;)
    {
      this.eLf = (this.eLd * 4);
      this.eLg = (this.eLe * 2 + this.eLc);
      this.hG = Bitmap.createBitmap(this.eLf, this.eLg, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(this.hG);
      a(this.cXn, localCanvas);
      this.hH = Bitmap.createBitmap(this.eLf, this.eLg, Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(this.hH);
      a(this.cXo, localCanvas);
      this.mIndex = this.a.a("X", 825L, 1000L, 0, 100, new DecelerateInterpolator());
      return;
      this.mTextPaint.setShadowLayer(0.0F, 0.0F, 0.0F, -1);
      break;
      label937:
      QLog.e("CalendarTimeStickerDrawable", 2, "mUpFilePath not exist");
      break label768;
      label949:
      QLog.e("CalendarTimeStickerDrawable", 2, "mUpFilePath not exist");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayns
 * JD-Core Version:    0.7.0.1
 */