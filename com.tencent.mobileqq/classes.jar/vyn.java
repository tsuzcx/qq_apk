import android.widget.ImageView;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.biz.pubaccount.ecshopassit.EcShopObserver;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

public class vyn
  extends EcShopObserver
{
  public vyn(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  protected void d(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (PublicAccountChatPie.a(this.a).getVisibility() != 0))
    {
      if (AIOTopRightButtonConfig.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        PublicAccountChatPie.b(this.a).setVisibility(0);
        PublicAccountChatPie.c(this.a).setOnClickListener(this.a);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight2Icon(2130843935, 2130843936);
      }
    }
    else {
      return;
    }
    PublicAccountChatPie.d(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vyn
 * JD-Core Version:    0.7.0.1
 */