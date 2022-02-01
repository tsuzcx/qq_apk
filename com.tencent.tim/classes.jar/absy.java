import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil.c;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil.d;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class absy
  implements ApolloGameUtil.d
{
  absy(absx paramabsx) {}
  
  public void bX(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.this$0.TAG, 2, new Object[] { "createShortcut result:", Integer.valueOf(paramInt) });
    }
    if (this.a.a != null) {
      this.a.a.HB(paramInt);
    }
    VipUtils.a(null, "cmshow", "Apollo", "sendToDesktopSusessful", 0, paramInt, new String[] { String.valueOf(this.a.val$gameId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     absy
 * JD-Core Version:    0.7.0.1
 */