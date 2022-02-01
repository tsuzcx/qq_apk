import com.tencent.mobileqq.activity.selectmember.TroopDiscussionTroop;
import com.tencent.qphone.base.util.QLog;

public class aayp
  extends acbo
{
  public aayp(TroopDiscussionTroop paramTroopDiscussionTroop) {}
  
  protected void wc(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopDiscussionTroop", 2, "onCacheInited " + paramInt);
      }
    } while (TroopDiscussionTroop.a(this.this$0) == null);
    TroopDiscussionTroop.a(this.this$0).resetData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aayp
 * JD-Core Version:    0.7.0.1
 */