import android.util.SparseArray;
import cooperation.qzone.util.QZLog;

public class avwy
  extends SparseArray<avwz>
{
  private long aAC;
  private long currentSize;
  private long maxSize;
  
  public avwy(long paramLong)
  {
    this.maxSize = paramLong;
  }
  
  private void ct(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    if (this.currentSize + this.aAC > this.maxSize) {
      if (!paramBoolean) {}
    }
    for (;;)
    {
      int i;
      try
      {
        if (paramInt >= size()) {
          break label150;
        }
        i = paramInt;
        removeAt(i);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        localIndexOutOfBoundsException.printStackTrace();
        if ((aLM()) || (size() <= 0)) {
          continue;
        }
        if (!paramBoolean) {
          break label139;
        }
        i = j;
        removeAt(i);
        QZLog.e("PieceCacheList", "trimToSize: IndexOutOfBoundsException temp " + (size() - (36 - paramInt)));
        return;
      }
      if (paramInt < size())
      {
        i = size() - 1;
      }
      else
      {
        i = size();
        i -= 36 - paramInt;
        continue;
        label139:
        i = size() - 1;
        continue;
        return;
        label150:
        i = 0;
      }
    }
  }
  
  public void a(int paramInt, avwz paramavwz)
  {
    if (paramavwz != null)
    {
      super.put(paramInt, paramavwz);
      this.currentSize += paramavwz.PP();
    }
  }
  
  public void a(int paramInt, avwz paramavwz, boolean paramBoolean)
  {
    if (paramavwz != null) {}
    try
    {
      if (this.aAC == 0L)
      {
        this.aAC = paramavwz.PP();
        if (this.maxSize < this.aAC * 8L) {
          this.maxSize = (this.aAC * 8L);
        }
      }
      ct(paramInt, paramBoolean);
      a(paramInt, paramavwz);
      return;
    }
    finally {}
  }
  
  public boolean aLM()
  {
    if (this.aAC == 0L) {}
    while (this.maxSize > this.aAC * 8L) {
      return false;
    }
    return true;
  }
  
  public void clear()
  {
    super.clear();
    this.currentSize = 0L;
  }
  
  public void remove(int paramInt)
  {
    avwz localavwz = (avwz)get(paramInt);
    if (localavwz != null) {
      localavwz.eCn();
    }
    super.remove(paramInt);
    this.currentSize -= this.aAC;
  }
  
  public void removeAt(int paramInt)
  {
    avwz localavwz = (avwz)valueAt(paramInt);
    if (localavwz != null) {
      localavwz.eCn();
    }
    super.removeAt(paramInt);
    this.currentSize -= this.aAC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avwy
 * JD-Core Version:    0.7.0.1
 */