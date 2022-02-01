import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.b;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class axuw
  extends DynamicTextItem
{
  private ArrayList<Integer> Gg = new ArrayList();
  private ArrayList<ArrayList<Integer>> Gh = new ArrayList();
  private ArrayList<Integer> Gi = new ArrayList();
  private InputFilter b;
  private Rect di = new Rect();
  private int eHZ;
  private int eIa;
  private Bitmap hy;
  private int mMaxWidth;
  private Resources mRes;
  private TextPaint mTextPaint;
  private ArrayList<String> mTexts = new ArrayList();
  private TextPaint u;
  
  public axuw(int paramInt, @NonNull List<String> paramList, Typeface paramTypeface1, Typeface paramTypeface2, Bitmap paramBitmap)
  {
    super(paramInt, paramList);
    a(BaseApplicationImpl.getContext(), paramTypeface1, paramTypeface2, paramBitmap);
    if (!paramList.isEmpty()) {
      setText(0, (String)paramList.get(0));
    }
  }
  
  private void a(Context paramContext, Typeface paramTypeface1, Typeface paramTypeface2, Bitmap paramBitmap)
  {
    this.mRes = paramContext.getResources();
    this.hy = paramBitmap;
    a(paramTypeface2, paramTypeface1);
    this.di.set(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
  }
  
  private void a(Typeface paramTypeface1, Typeface paramTypeface2)
  {
    this.mTextPaint = new TextPaint();
    this.mTextPaint.setTypeface(paramTypeface2);
    this.mTextPaint.setAntiAlias(true);
    this.mTextPaint.setColor(Color.parseColor("#ffffff"));
    this.mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.mTextPaint.setTextSize(dp2px(79.5F));
    this.mTextPaint.setTextAlign(Paint.Align.CENTER);
    this.eHZ = ((int)this.mTextPaint.measureText(acfp.m(2131707625)));
    this.u = new TextPaint();
    this.u.setTypeface(paramTypeface1);
    this.u.setAntiAlias(true);
    this.u.setColor(Color.parseColor("#ffffff"));
    this.u.setStyle(Paint.Style.FILL_AND_STROKE);
    this.u.setTextSize(dp2px(14.0F));
    this.mTextPaint.setTextAlign(Paint.Align.LEFT);
    this.eIa = ((int)(this.eHZ * 1.3F));
  }
  
  private int dp2px(float paramFloat)
  {
    return (int)(this.mRes.getDisplayMetrics().density * paramFloat);
  }
  
  private int y(ArrayList<Integer> paramArrayList)
  {
    int i = this.eHZ;
    paramArrayList = paramArrayList.iterator();
    i *= 2;
    if (paramArrayList.hasNext())
    {
      Integer localInteger = (Integer)paramArrayList.next();
      if (localInteger.intValue() <= i) {
        break label51;
      }
      i = localInteger.intValue();
    }
    label51:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public int Rv()
  {
    return 1;
  }
  
  public InputFilter a()
  {
    if (this.b == null) {
      this.b = new axuy(this, 20);
    }
    return this.b;
  }
  
  public boolean aPK()
  {
    return true;
  }
  
  public float getHeight()
  {
    int j = this.eIa;
    if (this.mTexts.size() == 0) {}
    for (int i = 1;; i = this.mTexts.size()) {
      return i * j + 10;
    }
  }
  
  public float getWidth()
  {
    return this.mMaxWidth + 10;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (super.ou(0)) {
      paramCanvas.drawRoundRect(new RectF(5.0F, 5.0F, getWidth() - 5.0F, getHeight() - 5.0F), 6.0F, 6.0F, k());
    }
    paramCanvas.save();
    paramCanvas.translate(this.mMaxWidth - dp2px(77.0F), this.eIa - dp2px(78.0F));
    Object localObject1 = new RectF();
    ((RectF)localObject1).set(0.0F, 0.0F, dp2px(45.0F), dp2px(45.0F));
    paramCanvas.drawBitmap(this.hy, this.di, (RectF)localObject1, null);
    paramCanvas.restore();
    int i = this.eIa;
    int i1 = this.mTexts.size();
    int j = 0;
    while (j < i1)
    {
      int n = (this.mMaxWidth - ((Integer)this.Gi.get(j)).intValue()) / 2;
      String str = (String)this.mTexts.get(j);
      int k = 0;
      int m = 0;
      if (m < str.length())
      {
        Object localObject2 = str.substring(m, m + 1);
        label240:
        int i3;
        int i2;
        if (axvo.f(((String)localObject2).charAt(0)) == 3)
        {
          localObject1 = localObject2;
          Rect localRect = new Rect();
          this.mTextPaint.getTextBounds((String)localObject2, 0, 1, localRect);
          i3 = Math.abs(localRect.top - localRect.bottom) + 20;
          i2 = Math.abs(localRect.right - localRect.left) + 20;
          paramCanvas.drawText((String)localObject2, n, i - 0.085F * this.eIa, this.mTextPaint);
          float f1 = n;
          float f2 = i - this.eIa + (this.eIa - i3) / 2;
          float f3 = n + i2;
          int i4 = this.eIa;
          localObject2 = new RectF(f1, f2, f3, (i3 + this.eIa) / 2 + (i - i4));
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localRect = new Rect();
            this.u.getTextBounds((String)localObject1, 0, ((String)localObject1).length(), localRect);
            i3 = localRect.right - localRect.left;
            if (k % 2 != 0) {
              break label508;
            }
            paramCanvas.drawText((String)localObject1, (i2 - i3) / 2 + n, ((RectF)localObject2).top, this.u);
          }
        }
        for (;;)
        {
          n += i2;
          m += 1;
          k += 1;
          break;
          localObject1 = ChnToSpell.a((String)localObject2, 1).csX;
          break label240;
          label508:
          paramCanvas.drawText((String)localObject1, (i2 - i3) / 2 + n, ((RectF)localObject2).bottom + 30.0F, this.u);
        }
      }
      k = this.eIa;
      j += 1;
      i += k;
    }
  }
  
  public void setText(int paramInt, String paramString)
  {
    super.setText(paramInt, paramString);
    this.mTexts.clear();
    this.Gi.clear();
    paramString = super.a(paramInt, new axux(this)).split("\n");
    int i = paramString.length;
    paramInt = 0;
    if (paramInt < i)
    {
      Object localObject = paramString[paramInt];
      if ((((String)localObject).length() == 6) && (i == 1))
      {
        this.mTexts.add(localObject);
        this.Gi.add(Integer.valueOf((int)this.mTextPaint.measureText((String)localObject)));
      }
      for (;;)
      {
        paramInt += 1;
        break;
        String str;
        if (((String)localObject).length() > 15)
        {
          str = ((String)localObject).substring(0, 5);
          this.mTexts.add(str);
          this.Gi.add(Integer.valueOf((int)this.mTextPaint.measureText(str)));
          str = ((String)localObject).substring(5, 10);
          this.mTexts.add(str);
          this.Gi.add(Integer.valueOf((int)this.mTextPaint.measureText(str)));
          str = ((String)localObject).substring(10, 15);
          this.mTexts.add(str);
          this.Gi.add(Integer.valueOf((int)this.mTextPaint.measureText(str)));
          localObject = ((String)localObject).substring(15, ((String)localObject).length());
          this.mTexts.add(localObject);
          this.Gi.add(Integer.valueOf((int)this.mTextPaint.measureText((String)localObject)));
        }
        else if (((String)localObject).length() > 10)
        {
          str = ((String)localObject).substring(0, 5);
          this.mTexts.add(str);
          this.Gi.add(Integer.valueOf((int)this.mTextPaint.measureText(str)));
          str = ((String)localObject).substring(5, 10);
          this.mTexts.add(str);
          this.Gi.add(Integer.valueOf((int)this.mTextPaint.measureText(str)));
          localObject = ((String)localObject).substring(10, ((String)localObject).length());
          this.mTexts.add(localObject);
          this.Gi.add(Integer.valueOf((int)this.mTextPaint.measureText((String)localObject)));
        }
        else if (((String)localObject).length() > 5)
        {
          str = ((String)localObject).substring(0, 5);
          this.mTexts.add(str);
          this.Gi.add(Integer.valueOf((int)this.mTextPaint.measureText(str)));
          localObject = ((String)localObject).substring(5, ((String)localObject).length());
          this.mTexts.add(localObject);
          this.Gi.add(Integer.valueOf((int)this.mTextPaint.measureText((String)localObject)));
        }
        else
        {
          this.mTexts.add(localObject);
          this.Gi.add(Integer.valueOf((int)this.mTextPaint.measureText((String)localObject)));
        }
      }
    }
    this.mMaxWidth = y(this.Gi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axuw
 * JD-Core Version:    0.7.0.1
 */