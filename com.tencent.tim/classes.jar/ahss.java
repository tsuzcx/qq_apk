import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;

public class ahss
  implements arkn
{
  public ahss(QQGamePubAccountFragment paramQQGamePubAccountFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if ((paramInt == 5) || (paramInt == 4))
    {
      paramView = new Intent(this.this$0.getActivity(), AccountDetailActivity.class);
      paramView.putExtra("uin", "2747277822");
      this.this$0.startActivity(paramView);
    }
    while (paramInt != 1) {
      return;
    }
    this.this$0.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahss
 * JD-Core Version:    0.7.0.1
 */