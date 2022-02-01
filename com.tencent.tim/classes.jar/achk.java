import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class achk
  implements ajdo.a
{
  achk(achg paramachg) {}
  
  public void T(boolean paramBoolean, int paramInt) {}
  
  public void eH(long paramLong) {}
  
  public void sc(int paramInt)
  {
    boolean bool1 = achg.b(this.this$0);
    achg.a(this.this$0, false);
    boolean bool2 = this.this$0.aaC();
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 2, "onBindStateChanged last:" + bool1 + "  now:" + bool2);
    }
    if (bool1 != bool2) {
      ((FriendListHandler)achg.a(this.this$0).getBusinessHandler(1)).notifyUI(92, true, null);
    }
  }
  
  public void sd(int paramInt) {}
  
  public void se(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     achk
 * JD-Core Version:    0.7.0.1
 */