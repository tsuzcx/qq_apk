import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.qphone.base.util.QLog;

public class lgd
{
  public static final int[] dh = { 0, 1, 2, 3, 4 };
  
  public static SparseArray<lfz> a(ReadInJoyBaseListViewGroup paramReadInJoyBaseListViewGroup)
  {
    SparseArray localSparseArray = new SparseArray();
    int i = 0;
    if (i < dh.length)
    {
      int j = dh[i];
      lfz locallfz = a(j);
      if (locallfz == null) {
        QLog.d("HandlerFactory", 2, new Object[] { "create handler fail, id : ", Integer.valueOf(j) });
      }
      for (;;)
      {
        i += 1;
        break;
        locallfz.a(paramReadInJoyBaseListViewGroup);
        localSparseArray.put(j, locallfz);
      }
    }
    return localSparseArray;
  }
  
  public static Object a(SparseArray<lfz> paramSparseArray, lge paramlge)
  {
    if (paramlge == null) {
      return null;
    }
    int i = -1;
    int j = 0;
    Object localObject = null;
    long l1;
    if (j < paramSparseArray.size())
    {
      l1 = SystemClock.currentThreadTimeMillis();
      paramlge.a((lfz)paramSparseArray.valueAt(j));
      if (paramlge.aI == null) {
        break label189;
      }
      if (localObject == null)
      {
        localObject = paramlge.aI;
        i = ((lfz)paramSparseArray.valueAt(j)).np();
        paramlge.aI = null;
      }
    }
    label189:
    for (;;)
    {
      long l2 = SystemClock.currentThreadTimeMillis();
      QLog.d("HandlerFactory", 2, new Object[] { "execute with return value handler job , id : ", Integer.valueOf(paramSparseArray.keyAt(j)), ", jobName : ", paramlge.aV(), ", cost : ", Long.valueOf(l2 - l1) });
      j += 1;
      break;
      throw new RuntimeException("has more than one handler return value. preHandlerID : " + i + ", now : " + ((lfz)paramSparseArray.valueAt(j)).np());
      return localObject;
    }
  }
  
  public static lfz a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new klc();
    case 2: 
      return new lgb();
    case 0: 
      return new lgf();
    case 3: 
      return new lga();
    }
    return new lgi();
  }
  
  public static void a(SparseArray<lfz> paramSparseArray, lge paramlge)
  {
    if (paramlge == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramSparseArray.size())
      {
        long l1 = SystemClock.currentThreadTimeMillis();
        paramlge.a((lfz)paramSparseArray.valueAt(i));
        long l2 = SystemClock.currentThreadTimeMillis();
        QLog.d("HandlerFactory", 2, new Object[] { "execute handler job , id : ", Integer.valueOf(paramSparseArray.keyAt(i)), ", jobName : ", paramlge.aV(), ", cost : ", Long.valueOf(l2 - l1) });
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lgd
 * JD-Core Version:    0.7.0.1
 */