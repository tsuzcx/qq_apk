import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.GetPostListCallBack;
import com.tencent.mobileqq.adapter.HotChatPostListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.widget.XListView;
import mqq.manager.TicketManager;

public class vsc
  implements Runnable
{
  public vsc(HotChatPie paramHotChatPie, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int j = 1;
    if (!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_AndroidContentContext.getString(2131434826), 0).a();
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {
      return;
    }
    Object localObject1 = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (localObject1 != null) {}
    for (localObject1 = ((TicketManager)localObject1).getSkey((String)localObject2);; localObject1 = null)
    {
      Bundle localBundle = new Bundle();
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.getTribeId();
      localBundle.putString("bid", (String)localObject3);
      localBundle.putString("num", this.jdField_a_of_type_Int + "");
      Object localObject4 = new StringBuilder();
      TextView localTextView;
      if (this.b <= 0)
      {
        i = 0;
        localBundle.putString("start", i + "");
        localBundle.putString("Cookie", "uin=o" + (String)localObject2 + ";skey=" + (String)localObject1);
        localBundle.putString("Referer", String.format("https://buluo.qq.com/mobile/barindex.html?bid=%s&scene=detail_titleNav&_wv=1027", new Object[] { localObject3 }));
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_AndroidContentContext;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentWidgetXListView;
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqAdapterHotChatPostListAdapter;
        localObject4 = HotChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie);
        localTextView = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.l;
        if (this.b != 0) {
          break label357;
        }
      }
      label357:
      for (int i = j;; i = 2)
      {
        new HttpCgiAsyncTask("https://buluo.qq.com/cgi-bin/bar/post/get_post_from_reliao", "GET", new HotChatPie.GetPostListCallBack((Context)localObject1, (XListView)localObject2, (HotChatPostListAdapter)localObject3, (PullRefreshHeader)localObject4, localTextView, i)).a(localBundle);
        return;
        i = this.b;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vsc
 * JD-Core Version:    0.7.0.1
 */