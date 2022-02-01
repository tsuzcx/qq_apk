import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.util.ArrayList;
import java.util.List;

public class axts
  extends DynamicTextItem
{
  private float EA = 0.9F;
  private float EB = 2.0F;
  private float Ez = 0.85F;
  private int QC = 36;
  private InputFilter b;
  private RectF bw = new RectF();
  private String cWf = "";
  private Rect dh = new Rect();
  private int eHb = 4;
  private int eHc = 4;
  private int eHd = 36;
  private int eHe = 95;
  private int eHf = 180;
  private int eHg = 1;
  private Bitmap hr;
  private Bitmap hs;
  private Bitmap ht;
  private RectF mBgRect = new RectF();
  private int mHorizontalSpacing;
  private int mLeftPadding;
  private Resources mRes;
  private TextPaint mTextPaint;
  private float mTextSize;
  private ArrayList<String> mTexts = new ArrayList();
  private int mTopPadding;
  private TextPaint n;
  
  public axts(int paramInt, @NonNull List<String> paramList, Typeface paramTypeface, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    super(paramInt, paramList);
    this.hr = paramBitmap1;
    this.hs = paramBitmap2;
    this.ht = paramBitmap3;
    this.mRes = BaseApplicationImpl.getContext().getResources();
    this.eHb = wja.dp2px(this.eHb, this.mRes);
    this.QC = wja.dp2px(this.QC, this.mRes);
    this.eHc = wja.dp2px(this.eHc, this.mRes);
    this.eHd = wja.dp2px(this.eHd, this.mRes);
    this.eHe = wja.dp2px(this.eHe, this.mRes);
    this.eHf = wja.dp2px(this.eHf, this.mRes);
    this.mTopPadding = this.eHb;
    e(paramTypeface);
    int i = Math.min(paramList.size(), Rv());
    paramInt = 0;
    while (paramInt < i)
    {
      setText(paramInt, (String)paramList.get(paramInt));
      paramInt += 1;
    }
  }
  
  private void e(Typeface paramTypeface)
  {
    this.mTextPaint = new TextPaint();
    this.mTextPaint.setTypeface(paramTypeface);
    this.mTextPaint.setAntiAlias(true);
    this.mTextPaint.setColor(Color.parseColor("#045389"));
    this.mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.mTextPaint.setTextAlign(Paint.Align.CENTER);
    this.n = new TextPaint();
    this.n.setTypeface(paramTypeface);
    this.n.setAntiAlias(true);
    this.n.setStyle(Paint.Style.STROKE);
    this.n.setStrokeJoin(Paint.Join.ROUND);
    this.n.setStrokeCap(Paint.Cap.ROUND);
    this.n.setTextAlign(Paint.Align.CENTER);
    this.n.setColor(Color.parseColor("#ddf3fd"));
    this.n.setStrokeWidth(wja.dp2px(2.0F, this.mRes));
    if (Build.VERSION.SDK_INT >= 21) {
      this.n.setShadowLayer(wja.dp2px(1.0F, this.mRes), wja.dp2px(1.0F, this.mRes), wja.dp2px(1.0F, this.mRes), Color.parseColor("#33000000"));
    }
  }
  
  private void eOR()
  {
    this.mTextSize *= this.EA;
  }
  
  public int Rv()
  {
    return 1;
  }
  
  public InputFilter a()
  {
    if (this.b == null) {
      this.b = new axtu(this, 20);
    }
    return this.b;
  }
  
  public boolean aPK()
  {
    return true;
  }
  
  public float getHeight()
  {
    return this.mBgRect.height();
  }
  
  public float getWidth()
  {
    return this.mBgRect.width();
  }
  
  public boolean isEmpty()
  {
    return (TextUtils.isEmpty(this.cWf)) || (super.isEmpty());
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    Object localObject;
    if (1 == this.eHg) {
      localObject = this.hr;
    }
    for (;;)
    {
      if (localObject != null)
      {
        this.dh.set(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        paramCanvas.drawBitmap((Bitmap)localObject, this.dh, this.mBgRect, null);
      }
      if (super.ou(0)) {
        paramCanvas.drawRoundRect(this.bw, 6.0F, 6.0F, k());
      }
      this.mTextPaint.setTextSize(this.mTextSize);
      this.n.setTextSize(this.mTextSize);
      int k = (int)(this.eHc + this.mLeftPadding + this.mTextSize * 0.5D);
      int i = (int)(this.eHb + this.mTextSize * this.Ez + this.mTopPadding);
      int j = this.mTexts.size() - 1;
      for (;;)
      {
        if (j < 0) {
          break label341;
        }
        localObject = (String)this.mTexts.get(j);
        int i2 = ((String)localObject).length();
        int i1 = 0;
        int m = i;
        i = i1;
        for (;;)
        {
          if (i < i2)
          {
            paramCanvas.drawText(((String)localObject).substring(i, i + 1), k, m, this.n);
            paramCanvas.drawText(((String)localObject).substring(i, i + 1), k, m, this.mTextPaint);
            m = (int)(m + this.mTextSize);
            i += 1;
            continue;
            if (2 == this.eHg)
            {
              localObject = this.hs;
              break;
            }
            if (3 != this.eHg) {
              break label342;
            }
            localObject = this.ht;
            break;
          }
        }
        k = (int)(k + (this.mHorizontalSpacing + this.mTextSize));
        i = (int)(this.eHb + this.mTextSize * this.Ez + this.mTopPadding);
        j -= 1;
      }
      label341:
      return;
      label342:
      localObject = null;
    }
  }
  
  public void setText(int paramInt, String paramString)
  {
    super.setText(paramInt, paramString);
    paramString = apsv.filterEmoji(super.a(paramInt, new axtt(this))).replaceAll("\n", "");
    this.cWf = paramString;
    this.mTexts.clear();
    paramInt = paramString.length();
    if (paramInt > 10)
    {
      this.mTexts.add(paramString.substring(0, 10));
      this.mTexts.add(paramString.substring(10, Math.min(20, paramInt)));
      this.mTextSize = Math.min(this.eHf / 10, this.QC / this.EB);
      eOR();
      paramInt = (int)((this.QC - this.mTextSize * 2.0F) / 3.0F);
      this.mLeftPadding = paramInt;
      this.mHorizontalSpacing = paramInt;
      this.mBgRect.set(0.0F, 0.0F, this.QC + this.eHc * 2, 10.0F * this.mTextSize + this.eHb * 2 + this.mTopPadding * 2);
      this.eHg = 3;
    }
    for (;;)
    {
      this.bw.set(this.mBgRect.left + this.eHc * 1.2F, this.mBgRect.top + this.eHb * 1.2F, this.mBgRect.right - this.eHc * 1.2F, this.mBgRect.bottom - this.eHb * 1.2F);
      return;
      if (paramInt > 5)
      {
        this.mTexts.add(paramString.substring(0, 5));
        this.mTexts.add(paramString.substring(5, paramInt));
        this.mTextSize = ((int)Math.min(this.eHe / 5, this.QC / this.EB));
        eOR();
        paramInt = (int)((this.QC - this.mTextSize * 2.0F) / 3.0F);
        this.mLeftPadding = paramInt;
        this.mHorizontalSpacing = paramInt;
        this.mBgRect.set(0.0F, 0.0F, this.QC + this.eHc * 2, 5.0F * this.mTextSize + this.eHb * 2 + this.mTopPadding * 2);
        this.eHg = 2;
      }
      else if (paramInt > 1)
      {
        this.mTexts.add(paramString);
        this.mTextSize = Math.min(this.QC, this.eHe / paramInt);
        eOR();
        this.mHorizontalSpacing = 0;
        this.mLeftPadding = ((int)((this.QC - this.mTextSize) / 2.0F));
        this.mBgRect.set(0.0F, 0.0F, this.QC + this.eHc * 2, paramInt * this.mTextSize + this.eHb * 2 + this.mTopPadding * 2);
        this.eHg = 2;
      }
      else
      {
        this.mTexts.add(paramString);
        this.mTextSize = this.QC;
        eOR();
        this.mBgRect.set(0.0F, 0.0F, this.QC + this.eHc * 2, this.mTextSize + this.eHb * 2 + this.mTopPadding * 2);
        this.mHorizontalSpacing = 0;
        this.mLeftPadding = ((int)((this.QC - this.mTextSize) / 2.0F));
        this.eHg = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axts
 * JD-Core Version:    0.7.0.1
 */