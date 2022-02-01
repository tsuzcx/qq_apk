import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.richmedia.capture.data.GifDecoder;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

public class ayol
  extends ayob
{
  private float FR;
  private ayol.a a;
  private long aCX;
  private String awD;
  private Rect ay = new Rect();
  private int blH;
  private String cXE;
  private String cXF;
  private String cXG;
  private String cXH;
  private String cXI;
  private boolean dAf;
  private String day;
  private Rect ds;
  private Rect dt;
  private Rect du;
  private int eMg;
  private int eMh;
  private int eMi;
  private int eMj;
  private int eMk;
  private int eMl;
  private int eMm;
  private int eMn;
  private int eMo;
  private int eMp;
  private int eMq;
  private int eMr;
  private int eMs;
  private int eMt;
  private Bitmap hV;
  private Bitmap hW;
  private Bitmap hX;
  private String[] jt = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
  private Paint mBitmapPaint;
  private Paint mDescPaint;
  private GifDecoder mGifDecoder;
  private int mHeight;
  private boolean mPause;
  private Paint mTempPaint;
  private int mWidth;
  private String month;
  
  public ayol(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    G(paramString);
    init();
    eST();
  }
  
  public static String a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt1);
      localJSONObject.put("temperature", paramInt2);
      localJSONObject.put("weather_icon_path", paramString1);
      localJSONObject.put("weather_desc", paramString2);
      localJSONObject.put("weather_symbol_icon_path", paramString3);
      localJSONObject.put("weather_font_path", paramString4);
      localJSONObject.put("weather_line_path", paramString5);
      localJSONObject.put("weather_line_path", paramString5);
      localJSONObject.put("dynamic", paramBoolean);
      paramString1 = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("WeatherStickerDrawable", 2, paramString1);
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WeatherStickerDrawable", 2, paramString1, new Object[0]);
        }
        paramString1 = null;
      }
    }
  }
  
  private void eTf()
  {
    if (this.mPause) {}
    Bitmap localBitmap;
    do
    {
      return;
      long l1 = System.currentTimeMillis();
      if (this.aCX == 0L) {
        this.aCX = l1;
      }
      long l2 = this.aCX;
      this.jdField_a_of_type_Ayol$a.sendEmptyMessageDelayed(0, 40L);
      localBitmap = null;
      if (this.mGifDecoder != null) {
        localBitmap = this.mGifDecoder.getNextGifFrame((l1 - l2) * 1000L * 1000L);
      }
    } while (localBitmap == this.hV);
    this.hV = localBitmap;
    invalidateSelf();
  }
  
  public String[] G(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString != null)
      {
        this.mType = paramString.optInt("type", 0);
        this.blH = paramString.optInt("temperature");
        this.cXE = paramString.optString("weather_icon_path", "");
        this.awD = paramString.optString("weather_desc", "");
        this.cXF = paramString.optString("weather_symbol_icon_path", "");
        this.cXG = paramString.optString("weather_font_path", "");
        this.cXH = paramString.optString("weather_line_path", "");
        this.dAf = paramString.optBoolean("dynamic", true);
      }
      return new String[] { this.cXE, this.awD, this.cXF, this.cXG, this.cXH };
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
    int i = 255;
    int i1;
    int n;
    int m;
    int k;
    int j;
    if (paramArrayList != null)
    {
      i1 = b(paramArrayList, this.eMl, 0);
      n = b(paramArrayList, this.eMm, 0);
      m = b(paramArrayList, this.eMn, 0);
      k = b(paramArrayList, this.eMo, 255);
      j = b(paramArrayList, this.eMp, 255);
      i = b(paramArrayList, this.eMq, 255);
    }
    for (;;)
    {
      if (this.hV != null) {
        paramCanvas.drawBitmap(this.hV, null, this.ds, null);
      }
      this.mTempPaint.setAlpha(k);
      if (this.cXI != null) {
        paramCanvas.drawText(this.cXI, this.eMg + i1, this.FR, this.mTempPaint);
      }
      this.mBitmapPaint.setAlpha(k);
      if (this.hW != null)
      {
        this.ay.set(this.dt);
        this.ay.offset(i1, 0);
        paramCanvas.drawBitmap(this.hW, null, this.ay, this.mBitmapPaint);
      }
      this.mBitmapPaint.setAlpha(j);
      if (this.hX != null)
      {
        this.ay.set(this.du);
        this.ay.offset(n, 0);
        paramCanvas.drawBitmap(this.hX, null, this.ay, this.mBitmapPaint);
      }
      this.mDescPaint.setAlpha(i);
      this.mDescPaint.setTextSize(this.eMt);
      if (this.month != null) {
        paramCanvas.drawText(this.month, this.eMh + m, this.eMi, this.mDescPaint);
      }
      if (this.day != null) {
        paramCanvas.drawText(this.day, this.eMj + m, this.eMi, this.mDescPaint);
      }
      if (this.awD != null)
      {
        if (this.eMs != 0) {
          this.mDescPaint.setTextSize(this.eMs);
        }
        paramCanvas.drawText(this.awD, this.eMk + m, this.eMi, this.mDescPaint);
      }
      return;
      j = 255;
      k = 255;
      m = 0;
      n = 0;
      i1 = 0;
    }
  }
  
  public Bitmap ba()
  {
    Bitmap localBitmap = bb();
    Canvas localCanvas = new Canvas(localBitmap);
    ArrayList localArrayList = this.jdField_a_of_type_Aynr.s(this.jdField_a_of_type_Aynr.getDuration());
    if (this.cXE != null)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.ARGB_4444;
      this.hV = BitmapFactory.decodeFile(this.cXE.replace(".apng", ".bpng"), localOptions);
    }
    a(localCanvas, localArrayList);
    return localBitmap;
  }
  
  protected void eST()
  {
    super.eST();
    if ((this.mGifDecoder != null) && (this.dAf)) {
      this.jdField_a_of_type_Ayol$a.sendEmptyMessage(0);
    }
  }
  
  public Bitmap g(long paramLong)
  {
    Bitmap localBitmap = bb();
    Canvas localCanvas = new Canvas(localBitmap);
    ArrayList localArrayList = this.jdField_a_of_type_Aynr.s(paramLong);
    if (this.mGifDecoder != null) {
      this.hV = this.mGifDecoder.getNextGifFrame(paramLong * 1000L * 1000L);
    }
    a(localCanvas, localArrayList);
    return localBitmap;
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
    this.jdField_a_of_type_Ayol$a = new ayol.a(new WeakReference(this));
    if (new File(this.cXG).exists()) {}
    label1158:
    label1165:
    for (;;)
    {
      int j;
      try
      {
        Object localObject = Typeface.createFromFile(this.cXG);
        if (this.blH != -999) {
          break label1122;
        }
        this.cXI = "--";
        this.mTempPaint = new Paint();
        this.mTempPaint.setAntiAlias(true);
        this.mTempPaint.setDither(true);
        this.mTempPaint.setColor(-1);
        this.mTempPaint.setTextSize(dp2px(40.0F, this.mContext.getResources()));
        this.mTempPaint.setFakeBoldText(true);
        this.mTempPaint.setTypeface((Typeface)localObject);
        Paint.FontMetrics localFontMetrics = this.mTempPaint.getFontMetrics();
        int k = (int)(localFontMetrics.bottom - localFontMetrics.top);
        int i3 = (int)this.mTempPaint.measureText(this.cXI);
        this.mDescPaint = new Paint();
        this.mDescPaint.setAntiAlias(true);
        this.mDescPaint.setDither(true);
        this.mDescPaint.setColor(-1);
        this.mDescPaint.setTypeface((Typeface)localObject);
        this.eMt = dp2px(11.0F, this.mContext.getResources());
        if ((this.awD != null) && (this.awD.length() > 2)) {
          this.eMs = dp2px(9.5F, this.mContext.getResources());
        }
        this.mDescPaint.setTextSize(this.eMt);
        this.mDescPaint.setFakeBoldText(true);
        localObject = this.mDescPaint.getFontMetrics();
        this.mBitmapPaint = new Paint(1);
        Calendar localCalendar = Calendar.getInstance();
        int i = localCalendar.get(2);
        if (i >= this.jt.length) {
          break label1149;
        }
        this.month = this.jt[i];
        this.day = String.format("%02d", new Object[] { Integer.valueOf(localCalendar.get(5)) });
        if (new File(this.cXF).exists())
        {
          this.mGifDecoder = new axsk(this.cXE);
          this.mGifDecoder.init();
        }
        if (new File(this.cXF).exists()) {
          this.hW = BitmapFactory.decodeFile(this.cXF);
        }
        if (new File(this.cXH).exists()) {
          this.hX = BitmapFactory.decodeFile(this.cXH);
        }
        this.eMr = dp2px(90.0F, this.mContext.getResources());
        this.ds = new Rect(0, 0, this.eMr, this.eMr);
        float f = dp2px(16.0F, this.mContext.getResources());
        this.FR = (f - localFontMetrics.top);
        int m = dp2px(1.0F, this.mContext.getResources());
        j = dp2px(1.0F, this.mContext.getResources());
        int n = Math.round(j * 0.5F);
        int i1 = j * 4;
        this.eMg = (this.eMr + j);
        this.eMh = (j * 3 + this.eMr);
        i = dp2px(55.5F, this.mContext.getResources());
        int i2 = dp2px(22.0F, this.mContext.getResources());
        i3 = i3 + this.eMg + i1;
        int i4 = dp2px(31.0F, this.mContext.getResources());
        int i5 = dp2px(23.5F, this.mContext.getResources());
        if (i >= i3 + i2 - this.eMg) {
          break label1165;
        }
        i = i3 + i2 - this.eMg;
        this.dt = new Rect(i3, i5, i2 + i3, i5 + i4);
        i1 = i5 + i4 + i1;
        i2 = this.eMg + j;
        this.du = new Rect(i2, i1, i2 + i, m + i1);
        this.eMi = ((int)((int)(k + f + n) - ((Paint.FontMetrics)localObject).top));
        k = (int)this.mDescPaint.measureText(this.month);
        m = (int)this.mDescPaint.measureText(this.day);
        if (this.eMs == 0) {
          break label1158;
        }
        this.mDescPaint.setTextSize(this.eMs);
        j *= 2;
        this.eMj = (this.eMh + k + j);
        this.eMk = (j + (this.eMj + m));
        this.mWidth = ((int)(this.eMr + i * 1.2D));
        this.mHeight = this.ds.bottom;
        this.eMl = this.jdField_a_of_type_Aynr.a("offsetX", 0L, 650L, (int)(-i * 0.3D), 0, new ayoj());
        this.eMm = this.jdField_a_of_type_Aynr.a("offsetX", 100L, 650L, (int)(-i * 0.3D), 0, new ayoj());
        this.eMn = this.jdField_a_of_type_Aynr.a("offsetX", 200L, 650L, (int)(-i * 0.3D), 0, new ayoj());
        this.eMo = this.jdField_a_of_type_Aynr.a("alpha", 0L, 370L, 0, 255, new rlp(0.33F, 0.0F, 0.67F, 1.0F));
        this.eMp = this.jdField_a_of_type_Aynr.a("alpha", 100L, 370L, 0, 255, new rlp(0.33F, 0.0F, 0.67F, 1.0F));
        this.eMq = this.jdField_a_of_type_Aynr.a("alpha", 200L, 370L, 0, 255, new rlp(0.33F, 0.0F, 0.67F, 1.0F));
        return;
      }
      catch (Exception localException)
      {
        localTypeface = Typeface.DEFAULT;
        continue;
      }
      Typeface localTypeface = Typeface.DEFAULT;
      continue;
      label1122:
      this.cXI = String.format("%02d", new Object[] { Integer.valueOf(this.blH) });
      continue;
      label1149:
      this.month = "";
      continue;
      j *= 5;
    }
  }
  
  public void pause()
  {
    this.mPause = true;
    if (this.jdField_a_of_type_Ayol$a != null) {
      this.jdField_a_of_type_Ayol$a.removeCallbacksAndMessages(null);
    }
  }
  
  static class a
    extends Handler
  {
    private WeakReference<ayol> mDrawableRef;
    
    public a(WeakReference<ayol> paramWeakReference)
    {
      this.mDrawableRef = paramWeakReference;
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (this.mDrawableRef.get() != null) {
        ayol.a((ayol)this.mDrawableRef.get());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayol
 * JD-Core Version:    0.7.0.1
 */