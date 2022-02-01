import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.util.List;

public class axvg
  extends DynamicTextItem
{
  public static final float Fe = ankt.dip2px(22.0F);
  public static final float Fi = ankt.dip2px(3.0F);
  public static final int MAX_WIDTH;
  public static final int TEXT_SIZE;
  public static final int eIb;
  private static int eIc;
  private RectF ao = new RectF();
  private RectF by = new RectF();
  private Rect dj = new Rect();
  boolean dwK = false;
  private int eId;
  private float mHeight;
  private TextPaint mPaint = new TextPaint();
  private String mText;
  private float mWidth;
  private int[] tV;
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    TEXT_SIZE = wja.dp2px(27.0F, localResources);
    eIb = wja.dp2px(6.0F, localResources);
    int i = ayom.tw();
    MAX_WIDTH = localResources.getDisplayMetrics().widthPixels - rgb.PADDING - i * 2;
  }
  
  public axvg(int paramInt, List<String> paramList, Typeface paramTypeface)
  {
    super(paramInt, paramList);
    this.mPaint.setTypeface(Typeface.DEFAULT);
    this.mPaint.setTextAlign(Paint.Align.CENTER);
    if (paramTypeface == null) {
      this.mPaint.setTypeface(Typeface.defaultFromStyle(1));
    }
    for (;;)
    {
      this.mPaint.setAntiAlias(true);
      this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.mPaint.setTextSize(TEXT_SIZE);
      this.mPaint.setColor(-1);
      this.mPaint.setTextAlign(Paint.Align.LEFT);
      paramTypeface = this.mPaint.getFontMetrics();
      eIc = (int)Math.abs(paramTypeface.bottom - paramTypeface.top);
      if (!paramList.isEmpty()) {
        setText(0, (String)paramList.get(0));
      }
      return;
      this.mPaint.setTypeface(paramTypeface);
    }
  }
  
  private static final boolean f(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  private static final boolean h(char paramChar)
  {
    return ((paramChar >= 'a') && (paramChar <= 'z')) || ((paramChar >= 'A') && (paramChar <= 'Z'));
  }
  
  private static final boolean i(char paramChar)
  {
    return (paramChar >= '一') && (paramChar <= 40891);
  }
  
  private static final boolean j(char paramChar)
  {
    return paramChar == '\n';
  }
  
  private void scanString()
  {
    int n = 0;
    this.tV = new int[this.mText.length()];
    char[] arrayOfChar = new char[this.mText.length()];
    this.mText.getChars(0, this.mText.length(), arrayOfChar, 0);
    int k = 0;
    int m = -1;
    if (k < this.mText.length())
    {
      char c2 = arrayOfChar[k];
      label76:
      char c1;
      if (k <= 0)
      {
        i = -1;
        if (i != -1) {
          break label149;
        }
        c1 = '\000';
        label83:
        if (!i(c2)) {
          break label157;
        }
        this.tV[k] = 2;
      }
      for (;;)
      {
        k += 1;
        m = i;
        break;
        j = k - 1;
        for (;;)
        {
          i = m;
          if (j < 0) {
            break;
          }
          if (arrayOfChar[j] != '\n') {
            break label143;
          }
          j -= 1;
        }
        label143:
        i = j;
        break label76;
        label149:
        c1 = arrayOfChar[i];
        break label83;
        label157:
        if (h(c2))
        {
          this.tV[k] = 3;
          if ((c1 != 0) && (h(c1))) {
            this.tV[i] = -3;
          }
        }
        else if (f(c2))
        {
          this.tV[k] = 4;
        }
        else if (j(c2))
        {
          this.tV[k] = 5;
        }
        else
        {
          this.tV[k] = 1;
          if (c1 != 0) {
            if (i(c1)) {
              this.tV[i] = -2;
            } else if (h(c1)) {
              this.tV[i] = -3;
            } else if (f(c1)) {
              this.tV[i] = -4;
            } else {
              this.tV[i] = -1;
            }
          }
        }
      }
    }
    this.eId = 0;
    arrayOfChar = this.mText.toCharArray();
    int j = arrayOfChar.length;
    int i = n;
    while ((i < j) && (j(arrayOfChar[i])))
    {
      this.eId += 1;
      i += 1;
    }
  }
  
  public int Rv()
  {
    return 1;
  }
  
  public boolean aPK()
  {
    return true;
  }
  
  public float getHeight()
  {
    return this.mHeight;
  }
  
  public float getWidth()
  {
    return this.mWidth;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.b != null)
    {
      this.mPaint.setTextAlign(Paint.Align.LEFT);
      float f2 = super.a(this.b);
      float f3 = this.b.getHeight();
      int j = 0;
      int m;
      for (int i = 0; j < this.b.getLineCount(); i = m)
      {
        this.b.getLineBounds(j, this.dj);
        m = this.b.getLineVisibleEnd(j);
        this.dj.bottom = (this.dj.top + eIc);
        float f1 = 0.0F;
        float[] arrayOfFloat = new float[m - i];
        this.mPaint.getTextWidths(this.mText, i, m, arrayOfFloat);
        int k = i;
        while (k < m) {
          if (String.valueOf(this.mText.charAt(k)).equals("\n"))
          {
            this.dwK = true;
            k += 1;
          }
          else
          {
            if ((k == this.eId) || (this.dwK))
            {
              if (!this.dwK) {
                break label368;
              }
              this.dwK = false;
              if ((this.tV[k] != -1) && (this.tV[k] != 1) && (this.tV[k] != -3) && (this.tV[k] != 3)) {
                break label317;
              }
            }
            for (;;)
            {
              f1 += arrayOfFloat[(k - i)];
              if (this.tV[k] > 0) {
                paramCanvas.drawLine(this.dj.left + f1, this.dj.bottom - Fi, this.dj.left + f1, this.dj.bottom, this.mPaint);
              }
              break;
              label317:
              paramCanvas.drawLine(this.dj.left + f1, this.dj.bottom - Fi, this.dj.left + f1, this.dj.bottom, this.mPaint);
              continue;
              label368:
              paramCanvas.drawLine(this.dj.left + f1, this.dj.bottom - Fi, this.dj.left + f1, this.dj.bottom, this.mPaint);
            }
          }
        }
        paramCanvas.drawLine(this.dj.left, this.dj.bottom, this.dj.left + f1, this.dj.bottom, this.mPaint);
        j += 1;
      }
      this.mPaint.setColor(-65536);
      this.mPaint.setColor(-1);
      this.b.draw(paramCanvas);
      if (super.ou(0))
      {
        this.by.left = 0.0F;
        this.by.top = 0.0F;
        this.by.right = f2;
        this.by.bottom = f3;
        paramCanvas.drawRoundRect(this.by, 6.0F, 6.0F, k());
      }
    }
  }
  
  public void setText(int paramInt, String paramString)
  {
    int i = 0;
    super.setText(paramInt, paramString);
    String str = super.gW(paramInt);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "　　";
    }
    this.mText = paramString;
    this.b = new StaticLayout(paramString, this.mPaint, MAX_WIDTH, Layout.Alignment.ALIGN_NORMAL, 1.0F, Fe, false);
    float f = 0.0F;
    paramInt = i;
    while (paramInt < this.b.getLineCount())
    {
      f = Math.max(f, this.b.getLineWidth(paramInt));
      paramInt += 1;
    }
    this.mWidth = f;
    this.mHeight = this.b.getHeight();
    scanString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axvg
 * JD-Core Version:    0.7.0.1
 */