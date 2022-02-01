import android.util.SparseIntArray;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;

public class akjy
{
  public static final SparseIntArray Z = new SparseIntArray(4);
  public static final SparseIntArray aa = new SparseIntArray(4);
  
  static
  {
    Z.put(1, 0);
    Z.put(2, 5);
    Z.put(3, 3);
    Z.put(4, 4);
    aa.put(0, 1);
    aa.put(5, 2);
    aa.put(3, 3);
    aa.put(4, 4);
  }
  
  public static void a(RedTouchItem paramRedTouchItem1, RedTouchItem paramRedTouchItem2)
  {
    paramRedTouchItem1.count = paramRedTouchItem2.count;
    paramRedTouchItem1.receiveTime = paramRedTouchItem2.receiveTime;
    paramRedTouchItem1.redtouchType = paramRedTouchItem2.redtouchType;
    paramRedTouchItem1.curSeq = paramRedTouchItem2.curSeq;
    paramRedTouchItem1.icon = paramRedTouchItem2.icon;
    paramRedTouchItem1.unReadFlag = paramRedTouchItem2.unReadFlag;
    paramRedTouchItem1.validTimeRemained = paramRedTouchItem2.validTimeRemained;
    paramRedTouchItem1.isClosed = paramRedTouchItem2.isClosed;
  }
  
  public static int is(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 4)) {
      return Z.get(paramInt);
    }
    return Z.get(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akjy
 * JD-Core Version:    0.7.0.1
 */