import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.apollo.view.ApolloGameInfoFragment;
import com.tencent.mobileqq.apollo.view.ApolloGameInfoFragment.ItemView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class abzl
  implements View.OnClickListener
{
  public abzl(ApolloGameInfoFragment.ItemView paramItemView) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(ApolloGameInfoFragment.ItemView.a(this.b))) && (!ApolloGameInfoFragment.ItemView.a(this.b).equals("0")))
    {
      QQAppInterface localQQAppInterface = this.b.a.mContext.app;
      int i = this.b.a.enter;
      if (this.b.a.b != null)
      {
        localObject = Integer.toString(this.b.a.b.gameId);
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "clk_fuwuhao", i, 0, new String[] { localObject });
        localObject = new Intent(this.b.a.getActivity(), AccountDetailActivity.class);
        ((Intent)localObject).putExtra("uin", ApolloGameInfoFragment.ItemView.a(this.b));
        ((Intent)localObject).putExtra("uintype", 1008);
        this.b.a.getActivity().startActivity((Intent)localObject);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = "";
      break;
      QLog.e("apollo_cmGame_ApolloGameInfoFragment", 1, "[setPubAccountInfo] uin is null or = 0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abzl
 * JD-Core Version:    0.7.0.1
 */