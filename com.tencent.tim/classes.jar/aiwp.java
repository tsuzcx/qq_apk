import android.graphics.Paint;
import java.util.ArrayList;

public class aiwp
{
  public aiwq a = new aiwq();
  public aiwq b = new aiwq();
  public long mDuration;
  public long mStartTime;
  public String mText;
  public ArrayList<aiwr> xu = new ArrayList();
  public ArrayList<aiwm> xv;
  
  public int Ga()
  {
    return this.xu.size();
  }
  
  public aiwp a()
  {
    aiwp localaiwp = new aiwp();
    localaiwp.mText = this.mText;
    localaiwp.mDuration = this.mDuration;
    localaiwp.mStartTime = this.mStartTime;
    if (this.xv != null)
    {
      localaiwp.xv = new ArrayList();
      localaiwp.xv.addAll(this.xv);
    }
    localaiwp.xu.addAll(this.xu);
    return localaiwp;
  }
  
  public void a(Paint paramPaint1, Paint paramPaint2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.xu.clear();
    int k = (int)paramPaint1.measureText(this.mText);
    int m = (int)paramPaint2.measureText(this.mText);
    int j = 0;
    int i = 0;
    if (k <= paramInt) {
      if (paramBoolean2)
      {
        paramInt = j;
        paramPaint1 = new aiwr(this.mText, paramInt, i, m, k, this.xv);
        this.xu.add(paramPaint1);
      }
    }
    String[] arrayOfString;
    int i6;
    do
    {
      return;
      i = paramInt - (int)paramPaint2.measureText(this.mText) >> 1;
      j = paramInt - k >> 1;
      paramInt = i;
      i = j;
      break;
      if (paramBoolean1)
      {
        paramPaint1 = new aiwr(this.mText, 0, 0, m, k, this.xv);
        this.xu.add(paramPaint1);
        return;
      }
      arrayOfString = aiwo.a(this.mText, paramPaint1, paramInt, paramInt);
      i6 = arrayOfString.length;
    } while (i6 <= 0);
    int n = 0;
    j = 0;
    i = 0;
    int i3 = 0;
    int i1 = 0;
    int i2 = 0;
    m = 0;
    k = 0;
    label198:
    label210:
    Object localObject;
    int i4;
    aiwm localaiwm;
    if (i3 < i6)
    {
      if (!paramBoolean2) {
        break label481;
      }
      localObject = null;
      if (this.xv == null) {
        break label705;
      }
      n += arrayOfString[i3].length();
      localObject = new ArrayList();
      i4 = m;
      m = j;
      j = k;
      k = i4;
      if (m >= this.xv.size()) {
        break label678;
      }
      localaiwm = (aiwm)this.xv.get(m);
      if ((i3 == 0) || (i != m)) {
        break label663;
      }
      k = n - arrayOfString[i3].length();
      i4 = localaiwm.mStart;
      j = k;
      k = i4 - k;
      label327:
      if ((localaiwm.mStart > n) || (localaiwm.mEnd < n)) {
        break label573;
      }
      if (i3 != 0) {
        break label520;
      }
      ((ArrayList)localObject).add(new aiwm(localaiwm.mStartTime, localaiwm.mDuration, localaiwm.mStart, arrayOfString[i3].length()));
      label388:
      m += 1;
      i4 = m;
      i = n;
      n = k;
      k = i4;
    }
    for (;;)
    {
      localObject = new aiwr(arrayOfString[i3], i1, i2, (ArrayList)localObject);
      this.xu.add(localObject);
      int i5 = i3 + 1;
      i3 = k;
      i4 = m;
      m = j;
      k = n;
      j = i4;
      n = i;
      i = i3;
      i3 = i5;
      break label198;
      break;
      label481:
      i1 = (int)paramPaint2.measureText(arrayOfString[i3]);
      i2 = paramInt - (int)paramPaint1.measureText(arrayOfString[i3]) >> 1;
      i1 = paramInt - i1 >> 1;
      break label210;
      label520:
      i = localaiwm.mStart;
      i4 = arrayOfString[i3].length();
      ((ArrayList)localObject).add(new aiwm(localaiwm.mStartTime, localaiwm.mDuration, i - j - k, i4));
      break label388;
      label573:
      if (i3 == 0) {
        ((ArrayList)localObject).add(localaiwm);
      }
      for (;;)
      {
        i4 = k;
        m += 1;
        k = j;
        j = i4;
        break;
        i4 = localaiwm.mStart;
        i5 = localaiwm.mEnd;
        ((ArrayList)localObject).add(new aiwm(localaiwm.mStartTime, localaiwm.mDuration, i4 - j - k, i5 - j - k));
      }
      label663:
      i4 = j;
      j = k;
      k = i4;
      break label327;
      label678:
      i4 = k;
      i5 = j;
      k = i;
      i = n;
      j = i4;
      n = i5;
      continue;
      label705:
      i4 = k;
      i5 = j;
      k = i;
      i = n;
      j = m;
      n = i4;
      m = i5;
    }
  }
  
  public ArrayList<aiwr> dj()
  {
    return this.xu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiwp
 * JD-Core Version:    0.7.0.1
 */