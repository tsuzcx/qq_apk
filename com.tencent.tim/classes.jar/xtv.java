import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.b;

class xtv
  implements GestureSelectGridView.b
{
  boolean aTU;
  boolean aTV = false;
  int mMaxIndex = -2147483648;
  int mMinIndex = 2147483647;
  
  xtv(xtp paramxtp) {}
  
  public xuf a(int paramInt)
  {
    Object localObject = this.this$0.c.j(paramInt);
    if (xuf.class.isInstance(localObject)) {
      return (xuf)localObject;
    }
    return null;
  }
  
  public void onSelectBegin(int paramInt)
  {
    boolean bool2 = false;
    if (!xtp.b(this.this$0)) {}
    xuf localxuf;
    do
    {
      do
      {
        return;
      } while (this.this$0.ww() == 2);
      localxuf = a(paramInt);
    } while (localxuf == null);
    if (localxuf.uG() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.aTV = bool1;
      xtp localxtp = this.this$0;
      bool1 = bool2;
      if (!this.aTV) {
        bool1 = true;
      }
      if (localxtp.a(localxuf, bool1, true))
      {
        this.this$0.ceQ();
        xtp.g(this.this$0).invalidateViews();
      }
      this.aTU = true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOImageListScene", 2, "onSelectBegin beginIndex:" + paramInt);
      return;
    }
  }
  
  public void onSelectChanged(int paramInt1, int paramInt2)
  {
    if (!xtp.c(this.this$0)) {}
    while ((this.this$0.ww() == 2) || (!this.aTU)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "onSelectChanged beginIndex:" + paramInt1 + " selectIndex:" + paramInt2);
    }
    int j;
    int i;
    if (paramInt2 < paramInt1)
    {
      j = paramInt1;
      i = paramInt2;
      if (this.mMinIndex > paramInt2)
      {
        this.mMinIndex = paramInt2;
        i = paramInt2;
        j = paramInt1;
      }
    }
    xuf localxuf;
    for (;;)
    {
      paramInt1 = i;
      for (;;)
      {
        if (paramInt1 > j) {
          break label181;
        }
        localxuf = a(paramInt1);
        if (localxuf != null) {
          break;
        }
        paramInt1 += 1;
      }
      if (this.mMaxIndex < paramInt2) {
        this.mMaxIndex = paramInt2;
      }
      j = paramInt2;
      i = paramInt1;
    }
    xtp localxtp = this.this$0;
    if (!this.aTV) {}
    for (boolean bool = true;; bool = false)
    {
      localxtp.a(localxuf, bool, true);
      break;
    }
    label181:
    paramInt1 = j + 1;
    if (paramInt1 <= this.mMaxIndex)
    {
      localxuf = a(paramInt1);
      if (localxuf == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.this$0.a(localxuf, this.aTV, true);
      }
    }
    paramInt1 = this.mMinIndex;
    if (paramInt1 < i)
    {
      localxuf = a(paramInt1);
      if (localxuf == null) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.this$0.a(localxuf, this.aTV, true);
      }
    }
    this.this$0.ceQ();
    xtp.h(this.this$0).invalidateViews();
  }
  
  public void onSelectEnd()
  {
    if (!xtp.d(this.this$0)) {}
    while ((this.this$0.ww() == 2) || (!this.aTU)) {
      return;
    }
    this.aTU = false;
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "onSelectEnd");
    }
    this.aTV = false;
    this.mMaxIndex = -2147483648;
    this.mMinIndex = 2147483647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xtv
 * JD-Core Version:    0.7.0.1
 */