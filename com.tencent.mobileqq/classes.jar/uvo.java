import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vip.AioVipDonateHelper;

public class uvo
  implements FileManagerUtil.TipsClickedInterface
{
  public uvo(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void a(View paramView)
  {
    paramView = new Bundle();
    paramView.putString(VasH5PayUtil.e, "QQ会员");
    paramView.putString(VasH5PayUtil.f, "LTMCLUB");
    paramView.putString(VasH5PayUtil.d, "1450000515");
    paramView.putInt(VasH5PayUtil.b, 3);
    paramView.putString(VasH5PayUtil.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    paramView.putString(VasH5PayUtil.i, AioVipDonateHelper.a().c(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    VasH5PayUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uvo
 * JD-Core Version:    0.7.0.1
 */