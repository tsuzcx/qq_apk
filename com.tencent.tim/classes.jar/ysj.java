import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

class ysj
  implements ajdo.a
{
  ysj(ysf paramysf) {}
  
  public void T(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "onRecommendCountChanged = " + paramInt);
    }
    this.this$0.clq();
  }
  
  public void eH(long paramLong) {}
  
  public void sc(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "onBindStateChanged = " + paramInt);
    }
    this.this$0.clq();
  }
  
  public void sd(int paramInt) {}
  
  public void se(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "onUpdateContactList = " + paramInt);
    }
    if ((paramInt & 0x1) != 0) {
      synchronized (ysf.a(this.this$0))
      {
        Iterator localIterator = ysf.a(this.this$0).iterator();
        if (localIterator.hasNext()) {
          ((ysf.a)localIterator.next()).bLV();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ysj
 * JD-Core Version:    0.7.0.1
 */