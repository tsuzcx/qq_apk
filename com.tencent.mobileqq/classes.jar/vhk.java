import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.TroopPobingItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TroopPobingItemBuilder.ConfigableWordingSetter;
import com.tencent.mobileqq.activity.aio.item.TroopPobingItemBuilder.TroopPobingViewHolder;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.qphone.base.util.QLog;

public class vhk
  implements View.OnClickListener
{
  public vhk(TroopPobingItemBuilder paramTroopPobingItemBuilder) {}
  
  public void onClick(View paramView)
  {
    TroopPobingItemBuilder.TroopPobingViewHolder localTroopPobingViewHolder = (TroopPobingItemBuilder.TroopPobingViewHolder)AIOUtils.a(paramView);
    TroopPobingItemBuilder.a(localTroopPobingViewHolder.a.senderuin);
    if (paramView == localTroopPobingViewHolder.b)
    {
      paramView = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if ((paramView != null) && (paramView.a() != null))
      {
        paramView = (TroopChatPie)paramView.a();
        TroopPobingItemBuilder.a(this.a).a(paramView.a);
        TroopPobingItemBuilder.a(this.a).a(0, localTroopPobingViewHolder.a);
      }
      new ReportTask(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("clk_welcome").a(new String[] { localTroopPobingViewHolder.a.frienduin }).a();
      if (QLog.isColorLevel()) {
        QLog.d("TroopPobingItemBuilder", 2, "点击欢迎");
      }
      TroopPobingItemBuilder.a(1);
    }
    while (paramView != localTroopPobingViewHolder.c) {
      return;
    }
    paramView = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment();
    if ((paramView != null) && (paramView.a() != null))
    {
      paramView = (TroopChatPie)paramView.a();
      TroopPobingItemBuilder.a(this.a).a(paramView.a);
      TroopPobingItemBuilder.a(this.a).a(1, localTroopPobingViewHolder.a);
    }
    new ReportTask(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("clk_play").a(new String[] { localTroopPobingViewHolder.a.frienduin }).a();
    if (QLog.isColorLevel()) {
      QLog.d("TroopPobingItemBuilder", 2, "点击撩一下");
    }
    TroopPobingItemBuilder.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vhk
 * JD-Core Version:    0.7.0.1
 */