import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;

public class aoho
{
  QQAppInterface app;
  SparseArray<aohl> dw;
  
  aoho(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.dw = new SparseArray(aohm.ou.length);
  }
  
  aohl a(int paramInt)
  {
    aohl localaohl = (aohl)this.dw.get(paramInt);
    if (localaohl != null) {
      ??? = localaohl;
    }
    do
    {
      do
      {
        return ???;
        switch (paramInt)
        {
        default: 
          ??? = localaohl;
        }
      } while (this.dw.get(paramInt) != null);
      ??? = localaohl;
    } while (localaohl == null);
    for (;;)
    {
      synchronized (this.dw)
      {
        if (this.dw.get(paramInt) != null) {
          break label148;
        }
        this.dw.put(paramInt, localaohl);
        return localaohl;
      }
      Object localObject2 = new aohv(this.app);
      break;
      localObject2 = new aohu(this.app);
      break;
      localObject2 = new aohw(this.app);
      break;
      label148:
      localObject2 = (aohl)this.dw.get(paramInt);
    }
  }
  
  void destroy()
  {
    for (;;)
    {
      int i;
      synchronized (this.dw)
      {
        int j = this.dw.size();
        i = 0;
        if (i < j)
        {
          aohl localaohl = (aohl)this.dw.valueAt(i);
          if (localaohl != null) {
            localaohl.onDestroy();
          }
        }
        else
        {
          this.dw.clear();
          return;
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoho
 * JD-Core Version:    0.7.0.1
 */