import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.gamecenter.view.NavBarQQGamePub;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.mobileqq.qipc.QIPCClientHelper;

public class ahvc
  implements arkn
{
  public ahvc(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt == 5)
    {
      paramView = new Intent(this.this$0.getActivity(), AccountDetailActivity.class);
      paramView.putExtra("uin", "2747277822");
      paramView.putExtra("fromQGamePub", true);
      this.this$0.startActivity(paramView);
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        QQGameFeedWebFragment.a(this.this$0, this.this$0.startTime);
        this.this$0.getActivity().finish();
        return;
      }
    } while (paramInt != 4);
    QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "openSessionPage", null, null);
    paramInt = this.this$0.a.Fm();
    paramView = awot.a();
    StringBuilder localStringBuilder = new StringBuilder().append("");
    if (paramInt > 0) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramView.c("", "1", "145", "920", "92001", "206800", "0", "", "20", paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahvc
 * JD-Core Version:    0.7.0.1
 */