import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class aefq
  implements accv.b
{
  public aefq(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void D(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "onGetConfig | mDialogType = " + this.this$0.bHl + ", isSuccess = " + paramBoolean + ", resultCode = " + paramInt);
    }
    if ((this.this$0.bHl == 1) || (this.this$0.bHl == 2))
    {
      if (paramBoolean) {
        break label110;
      }
      this.this$0.aqz();
      QQToast.a(this.this$0, 2131691963, 0).show(this.this$0.getTitleBarHeight());
    }
    label110:
    while (paramInt != 2) {
      return;
    }
    this.this$0.aqz();
    this.this$0.LU(this.this$0.bHl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aefq
 * JD-Core Version:    0.7.0.1
 */