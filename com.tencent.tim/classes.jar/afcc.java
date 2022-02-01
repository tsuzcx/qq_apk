import android.content.Intent;
import com.tencent.mobileqq.dating.BaseMsgBoxActivity;
import com.tencent.mobileqq.widget.TabBarView.a;
import com.tencent.qphone.base.util.QLog;

public class afcc
  implements TabBarView.a
{
  public afcc(BaseMsgBoxActivity paramBaseMsgBoxActivity) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.msgbox.tab", 2, "BaseMsgBoxActivity, onTabSelected: old=" + paramInt1 + ", cur=" + paramInt2 + ", msgTabIdx=" + this.this$0.bIx + ", unReadMsgNum=" + this.this$0.cQa);
    }
    Intent localIntent;
    if ((paramInt1 == this.this$0.bIx) && (paramInt2 != this.this$0.bIx))
    {
      localIntent = new Intent();
      localIntent.putExtra("curIndex", paramInt2);
      if (!this.this$0.bXg) {
        break label176;
      }
    }
    label176:
    for (paramInt1 = this.this$0.cQa;; paramInt1 = 0)
    {
      localIntent.putExtra("unReadMsgNum", paramInt1);
      this.this$0.setResult(-1, localIntent);
      this.this$0.finish();
      this.this$0.overridePendingTransition(2130772300, 2130772300);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.msgbox.tab", 2, "finish");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afcc
 * JD-Core Version:    0.7.0.1
 */