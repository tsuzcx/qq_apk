import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QQSettingChatOperationFragment;
import com.tencent.mobileqq.fragment.QQSettingChatOperationFragment.2.1;

public class ahol
  implements ausj.a
{
  public ahol(QQSettingChatOperationFragment paramQQSettingChatOperationFragment, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    anot.a(QQSettingChatOperationFragment.a(this.a), "CliOper", "", "", "Setting_tab", "Clk_clean_msg", 0, 0, "0", "0", "", "");
    anot.a(QQSettingChatOperationFragment.a(this.a), "dc00898", "", "", "0X800A0C3", "0X800A0C3", 0, 0, "", "", "", "");
    if (!this.a.getActivity().isFinishing())
    {
      this.ai.cancel();
      QQSettingChatOperationFragment.a(this.a, true);
    }
    ThreadManagerV2.excute(new QQSettingChatOperationFragment.2.1(this), 64, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahol
 * JD-Core Version:    0.7.0.1
 */