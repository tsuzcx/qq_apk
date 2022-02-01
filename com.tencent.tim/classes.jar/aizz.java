import com.tencent.mobileqq.matchchat.MatchChatSettingFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aizz
  extends afsr
{
  public aizz(MatchChatSettingFragment paramMatchChatSettingFragment) {}
  
  protected void It(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MatchChatSettingFragment", 2, "onGetUnLimitBaseInfo suc:" + paramBoolean);
    }
    MatchChatSettingFragment localMatchChatSettingFragment;
    if (!paramBoolean)
    {
      localMatchChatSettingFragment = this.this$0;
      if (MatchChatSettingFragment.a(this.this$0).isChecked()) {
        break label61;
      }
    }
    label61:
    for (paramBoolean = true;; paramBoolean = false)
    {
      MatchChatSettingFragment.a(localMatchChatSettingFragment, paramBoolean);
      return;
    }
  }
  
  protected void a(boolean paramBoolean1, ArrayList<afub> paramArrayList, boolean paramBoolean2, int paramInt, ArrayList<String> paramArrayList1, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MatchChatSettingFragment", 2, "onGetUnLimitBaseInfo suc:" + paramBoolean1 + " chatSwitchOpen:" + paramBoolean2);
    }
    if (paramBoolean1) {
      MatchChatSettingFragment.a(this.this$0, paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aizz
 * JD-Core Version:    0.7.0.1
 */