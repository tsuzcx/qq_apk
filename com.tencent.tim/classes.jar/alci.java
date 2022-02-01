import android.graphics.Paint.FontMetricsInt;
import android.graphics.Point;
import android.graphics.Typeface;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View.MeasureSpec;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class alci
{
  private static final BoringLayout.Metrics UNKNOWN_BORING = new BoringLayout.Metrics();
  public static int drx;
  List<CharSequence> EN;
  public List<Layout> EO;
  public boolean bTQ;
  public int bgColor = 0;
  public boolean bold;
  public boolean cvX;
  public boolean cvY;
  boolean cvZ = false;
  public int drw = 0;
  public TextPaint e = new TextPaint(1);
  public Layout layout;
  BoringLayout.Metrics mBoring;
  int maxEms = 0;
  public int mode = 0;
  public Point n = new Point(-1, -1);
  public Point o = new Point(0, 0);
  public float scale = 1.0F;
  public CharSequence text;
  int textColor = -16777216;
  public float textSize;
  
  public alci()
  {
    this.e.setTypeface(Typeface.SANS_SERIF);
  }
  
  public static void SG(int paramInt)
  {
    drx = paramInt;
  }
  
  private static int a(Layout paramLayout)
  {
    int i = 0;
    int j = 0;
    while (i < paramLayout.getLineCount())
    {
      j = Math.max((int)(paramLayout.getLineMax(i) + 0.5F), j);
      i += 1;
    }
    return j;
  }
  
  private static CharSequence c(CharSequence paramCharSequence)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramCharSequence.length() * 2);
    int i = 0;
    while (i < paramCharSequence.length())
    {
      localStringBuilder.append(paramCharSequence.charAt(i));
      if (i != paramCharSequence.length() - 1) {
        localStringBuilder.append('\n');
      }
      i += 1;
    }
    return localStringBuilder.toString().subSequence(0, localStringBuilder.length());
  }
  
  private int iD(int paramInt)
  {
    Object localObject;
    boolean bool;
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onMeasureHorizontal text:").append(this.text).append(" hasImg:");
      if (this.mode == 2)
      {
        bool = true;
        QLog.i("Tag", 2, bool + " ems:" + this.maxEms);
      }
    }
    else
    {
      if (this.mode != 2) {
        break label243;
      }
      i = this.maxEms;
      label84:
      if (!alcj.atm()) {
        break label867;
      }
    }
    label169:
    label461:
    label464:
    label861:
    label867:
    for (int j = 0;; j = i)
    {
      int i1 = drx;
      int m = View.MeasureSpec.getMode(paramInt);
      int i2 = View.MeasureSpec.getSize(paramInt);
      localObject = UNKNOWN_BORING;
      localObject = BoringLayout.isBoring(this.text, this.e, null);
      if (localObject != null) {
        this.mBoring = ((BoringLayout.Metrics)localObject);
      }
      int k;
      if ((localObject == null) || (localObject == UNKNOWN_BORING))
      {
        i = (int)Math.ceil(Layout.getDesiredWidth(this.text, this.e));
        k = i;
        if (j > 0) {
          k = Math.min(i, getLineHeight() * j);
        }
        if ((m != -2147483648) && (m != 1073741824)) {
          break label861;
        }
        if (this.mode != 2) {
          break label257;
        }
        i = Math.min(i2 - i1 * 3, k);
      }
      for (;;)
      {
        m = Math.max(i, 0);
        if (m <= 0)
        {
          return 0;
          bool = false;
          break;
          label243:
          i = 0;
          break label84;
          i = ((BoringLayout.Metrics)localObject).width;
          break label169;
          if (this.mode == 1)
          {
            i = Math.min(i2 - i1 * 2, k);
            continue;
          }
          i = Math.min(i2, k);
          continue;
        }
        this.layout = a(m, (BoringLayout.Metrics)localObject, m, this.text, 0.92F);
        if ((j <= 0) && (this.layout.getLineCount() > 1))
        {
          this.textSize *= 0.8F;
          this.e.setTextSize(this.textSize);
          if (QLog.isColorLevel()) {
            QLog.i("Tag", 2, "onMeasureHorizontal maxEms=0 another round");
          }
          return iD(paramInt);
        }
        k = j;
        if (j == 0)
        {
          k = j;
          if (this.layout.getLineCount() > 1)
          {
            if (m % getLineHeight() <= 0) {
              break label692;
            }
            bool = true;
            j = m / getLineHeight();
            if (QLog.isColorLevel()) {
              QLog.i("Tag", 2, "onMeasureHorizontal baseEms:" + j + " hasExtra:" + bool);
            }
            if (!bool) {
              break label698;
            }
            j += 1;
            k = j;
          }
        }
        if ((k > 1) && (this.layout.getLineCount() > 1))
        {
          k -= 1;
          if (QLog.isDebugVersion()) {
            QLog.i("Tag", 4, "onMeasureHorizontal ems--" + k);
          }
          j = k * getLineHeight();
          if (j <= i) {}
        }
        else
        {
          i = m;
          if (this.layout.getLineCount() >= 1)
          {
            i = a(this.layout);
            if (QLog.isColorLevel()) {
              QLog.i("Tag", 2, "onMeasureHorizontal want:" + m + " actual:" + i);
            }
          }
          k = this.layout.getHeight() - this.drw;
          if (this.mode != 1) {
            break label741;
          }
          j = i + i1 * 2;
        }
        for (;;)
        {
          if (j <= i2) {
            break label764;
          }
          this.textSize *= 0.8F;
          this.e.setTextSize(this.textSize);
          if (QLog.isColorLevel()) {
            QLog.i("Tag", 2, "onMeasureHorizontal width oversize.another round " + this.text);
          }
          return iD(paramInt);
          bool = false;
          break;
          break label461;
          Layout localLayout = a(j, (BoringLayout.Metrics)localObject, j, this.text, 0.92F);
          if (localLayout.getLineCount() != this.layout.getLineCount()) {
            break label532;
          }
          this.layout = localLayout;
          break label464;
          label741:
          j = i;
          if (this.mode == 2) {
            j = i + (i1 * 3 + k);
          }
        }
        label764:
        if (this.mode > 0) {
          this.o.set(j, k + i1 * 2);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Tag", 2, "onMeasureHorizontal w:" + this.o.x + " h:" + this.o.y);
          }
          return this.o.y;
          this.o.set(j, k);
        }
        i = k;
      }
    }
  }
  
  private int iE(int paramInt)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.i("Tag", 2, "onMeasureVertical text:" + this.text);
    }
    int i;
    int m;
    int i1;
    int i2;
    label80:
    int k;
    if (this.mode == 2)
    {
      i = this.maxEms;
      m = drx;
      i1 = View.MeasureSpec.getMode(paramInt);
      i2 = View.MeasureSpec.getSize(paramInt);
      if (this.EN == null)
      {
        if (i > 0) {
          break label318;
        }
        paramInt = 1;
        this.EN = new ArrayList(paramInt);
      }
      if ((i <= 0) || (this.text.length() <= i)) {
        break label394;
      }
      k = this.text.length() / i;
      paramInt = k;
      if (this.text.length() % i > 0) {
        paramInt = k + 1;
      }
      k = this.text.length() / paramInt;
      i = Math.min(i, this.text.length() % paramInt + k);
      paramInt = 0;
      label178:
      if (paramInt < this.text.length())
      {
        if (paramInt + i < this.text.length()) {
          break label364;
        }
        this.EN.add(this.text.subSequence(paramInt, this.text.length()));
      }
    }
    for (;;)
    {
      paramInt = 2147483647;
      if ((i1 == 1073741824) || (i1 == -2147483648)) {
        paramInt = i2 - m * 2;
      }
      k = iF(paramInt);
      i = 0;
      paramInt = j;
      while (paramInt < this.EO.size())
      {
        i = Math.max(((Layout)this.EO.get(paramInt)).getHeight(), i);
        paramInt += 1;
      }
      i = 0;
      break;
      label318:
      if (this.text.length() % i > 0)
      {
        paramInt = this.text.length() / i + 1;
        break label80;
      }
      paramInt = this.text.length() / i;
      break label80;
      label364:
      this.EN.add(this.text.subSequence(paramInt, paramInt + i));
      paramInt += i;
      break label178;
      label394:
      this.EN.add(this.text);
    }
    paramInt = i - this.drw;
    if (this.mode > 0) {
      if (this.mode == 2)
      {
        paramInt = paramInt + k + m * 3;
        this.o.set(m * 2 + k, paramInt);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Tag", 2, "onMeasureVertical w:" + this.o.x + " h:" + this.o.y);
      }
      return this.o.y;
      paramInt += m * 2;
      break;
      this.o.set(k, paramInt);
    }
  }
  
  private int iF(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList(this.EN.size());
    ArrayList localArrayList2 = new ArrayList(this.EN.size());
    if (this.EO == null) {
      this.EO = new ArrayList(this.EN.size());
    }
    int j = 0;
    int i = 0;
    Object localObject;
    while (j < this.EN.size())
    {
      localObject = c((CharSequence)this.EN.get(j));
      int k = (int)Math.ceil(Layout.getDesiredWidth((CharSequence)localObject, this.e));
      i += k;
      if (((i >= paramInt) && (j < this.EN.size() - 1)) || ((j == this.EN.size() - 1) && (i > paramInt)))
      {
        this.textSize *= 0.5F;
        if (this.textSize < 1.0F) {
          return paramInt;
        }
        this.e.setTextSize(this.textSize);
        return iF(paramInt);
      }
      localArrayList1.add(Integer.valueOf(k));
      localArrayList2.add(localObject);
      j += 1;
    }
    paramInt = 0;
    while (paramInt < localArrayList2.size())
    {
      localObject = (CharSequence)localArrayList2.get(paramInt);
      localObject = a(((Integer)localArrayList1.get(paramInt)).intValue(), null, ((Integer)localArrayList1.get(paramInt)).intValue(), (CharSequence)localObject, 0.87F);
      this.EO.add(localObject);
      paramInt += 1;
    }
    return i;
  }
  
  public int Hr()
  {
    int j = this.o.x;
    int i = this.o.y;
    int k = drx;
    if (this.mode == 2) {
      if (this.cvY) {
        i = j - (i - k * 2 + k * 3);
      }
    }
    do
    {
      return i;
      return j - k * 2;
      i = j;
    } while (this.mode != 1);
    return j - k * 2;
  }
  
  public int Hs()
  {
    int i = this.o.x;
    int j = this.o.y;
    int k = drx;
    if (this.mode == 2) {
      if (this.cvY) {
        i = j - k * 2;
      }
    }
    do
    {
      return i;
      return j - (i - k * 2 + k * 3);
      i = j;
    } while (this.mode != 1);
    return j - k * 2;
  }
  
  protected Layout a(int paramInt1, BoringLayout.Metrics paramMetrics, int paramInt2, CharSequence paramCharSequence, float paramFloat)
  {
    Layout.Alignment localAlignment = Layout.Alignment.ALIGN_NORMAL;
    if ((paramCharSequence instanceof Spannable)) {
      return new DynamicLayout(paramCharSequence, this.e, paramInt1, localAlignment, paramFloat, 0.0F, false);
    }
    if (paramMetrics == UNKNOWN_BORING)
    {
      BoringLayout.Metrics localMetrics = BoringLayout.isBoring(paramCharSequence, this.e, this.mBoring);
      paramMetrics = localMetrics;
      if (localMetrics != null)
      {
        this.mBoring = localMetrics;
        paramMetrics = localMetrics;
      }
    }
    for (;;)
    {
      if (paramMetrics != null)
      {
        if (paramMetrics.width <= paramInt1) {
          return BoringLayout.make(paramCharSequence, this.e, paramInt1, localAlignment, paramFloat, 0.0F, paramMetrics, false);
        }
        return new StaticLayout(paramCharSequence, this.e, paramInt1, localAlignment, paramFloat, 0.0F, false);
      }
      return new StaticLayout(paramCharSequence, this.e, paramInt1, localAlignment, paramFloat, 0.0F, false);
    }
  }
  
  public Point c()
  {
    if (this.bTQ) {
      return new Point(0, 0);
    }
    return new Point(this.n.x + (int)(this.o.x * 0.5F), this.n.y + (int)(this.o.y * 0.5F));
  }
  
  public int getLineHeight()
  {
    return this.e.getFontMetricsInt(null);
  }
  
  public int iC(int paramInt)
  {
    int i = this.e.getFontMetricsInt().top;
    this.drw = ((int)((this.e.getFontMetricsInt().ascent - i) * 0.5F));
    if (this.cvY) {
      return iD(paramInt);
    }
    return iE(paramInt);
  }
  
  public void reset()
  {
    this.n.set(-1, -1);
    this.o.set(0, 0);
    this.layout = null;
    if (this.EO != null) {
      this.EO.clear();
    }
    if (this.EN != null) {
      this.EN.clear();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("texts:").append(this.text).append(" w:").append(this.o.x).append(" h:").append(this.o.y);
    localStringBuilder.append(" textSize:").append(this.textSize);
    localStringBuilder.append(" cord.x:").append(this.n.x);
    localStringBuilder.append(" cord.y:").append(this.n.y);
    return localStringBuilder.toString();
  }
  
  public boolean valid()
  {
    if (this.cvY) {}
    while ((this.EO != null) && (this.EO.size() > 0))
    {
      if ((this.layout == null) || (this.n.x < 0) || (this.n.y < 0) || (this.o.x <= 0) || (this.o.y <= 0)) {
        break;
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alci
 * JD-Core Version:    0.7.0.1
 */