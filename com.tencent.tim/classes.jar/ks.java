import android.graphics.Rect;
import android.util.SparseArray;
import com.etrump.mixlayout.ETTextView;
import com.tencent.qphone.base.util.QLog;

public class ks
{
  private ETTextView b;
  private SparseArray<Rect> m = new SparseArray();
  private ko mLayout;
  private int[] mTempLocation = new int[2];
  
  public ks(ETTextView paramETTextView, ko paramko)
  {
    this.b = paramETTextView;
    this.mLayout = paramko;
  }
  
  public SparseArray<Rect> b()
  {
    return this.m;
  }
  
  public void clearHighlightContent()
  {
    if (this.m != null) {
      this.m.clear();
    }
    this.b.invalidate();
  }
  
  public void f(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0)) {}
    kr localkr1;
    kr localkr2;
    do
    {
      return;
      localkr1 = this.mLayout.a(paramInt1);
      localkr2 = this.mLayout.a(paramInt2);
    } while ((localkr1 == null) || (localkr2 == null));
    this.m.clear();
    Rect localRect1;
    if (localkr1.lineIndex == localkr2.lineIndex)
    {
      localRect1 = new Rect();
      if (localkr2.f.left >= localkr1.f.left) {
        localRect1.set(localkr1.f.left, localkr1.f.top, localkr2.f.right, localkr2.f.bottom);
      }
      for (;;)
      {
        localRect1.offset(this.b.getPaddingLeft(), this.b.getPaddingTop());
        this.m.append(localkr2.lineIndex, localRect1);
        this.b.invalidate();
        return;
        localRect1.set(localkr2.f.left, localkr2.f.top, localkr1.f.left, localkr1.f.bottom);
      }
    }
    int i = localkr1.lineIndex;
    int j = localkr2.lineIndex;
    paramInt2 = j;
    paramInt1 = i;
    if (i > j)
    {
      paramInt1 = localkr2.lineIndex;
      paramInt2 = localkr1.lineIndex;
    }
    i = paramInt1;
    label243:
    Rect localRect2;
    if (i <= paramInt2)
    {
      localRect1 = new Rect();
      localRect2 = this.mLayout.a(i);
      if (localRect2 == null)
      {
        QLog.e("ETTextSelection", 1, "no lineBound: " + i + " " + this.mLayout.getLines() + " " + paramInt1 + " " + paramInt2);
        return;
      }
      if (localkr2.lineIndex <= localkr1.lineIndex) {
        break label483;
      }
      if (i != paramInt1) {
        break label416;
      }
      localRect1.set(localkr1.f.left, localkr1.f.top, localRect2.right, localRect2.bottom);
    }
    for (;;)
    {
      localRect1.offset(this.b.getPaddingLeft(), this.b.getPaddingTop());
      this.m.append(i, localRect1);
      i += 1;
      break label243;
      break;
      label416:
      if (i == paramInt2)
      {
        localRect1.set(localRect2.left, localRect2.top, localkr2.f.right, localkr2.f.bottom);
      }
      else
      {
        localRect1.set(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
        continue;
        label483:
        if (i == paramInt1) {
          localRect1.set(localkr2.f.left, localkr2.f.top, localRect2.right, localRect2.bottom);
        } else if (i == paramInt2) {
          localRect1.set(localRect2.left, localRect2.top, localkr1.f.left, localkr1.f.bottom);
        } else {
          localRect1.set(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
        }
      }
    }
  }
  
  public void locationByIndex(int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i = paramInt;
    if (!paramBoolean) {
      i = paramInt - 1;
    }
    kr localkr = this.mLayout.a(i);
    if (localkr == null) {}
    while ((paramArrayOfInt == null) || (paramArrayOfInt.length < 2)) {
      return;
    }
    this.b.getLocationInWindow(paramArrayOfInt);
    if (paramBoolean)
    {
      paramArrayOfInt[0] += this.b.getPaddingLeft() + localkr.f.left;
      paramInt = paramArrayOfInt[1];
      i = this.b.getPaddingTop();
      paramArrayOfInt[1] = (localkr.f.bottom + i + paramInt);
      return;
    }
    paramArrayOfInt[0] += this.b.getPaddingLeft() + localkr.f.right;
    paramInt = paramArrayOfInt[1];
    i = this.b.getPaddingTop();
    paramArrayOfInt[1] = (localkr.f.bottom + i + paramInt);
  }
  
  public int touchIndex(int paramInt1, int paramInt2)
  {
    this.b.getLocationInWindow(this.mTempLocation);
    return this.mLayout.h(paramInt1 - this.mTempLocation[0] - this.b.getPaddingLeft(), paramInt2 - this.mTempLocation[1] - this.b.getPaddingTop());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ks
 * JD-Core Version:    0.7.0.1
 */