import Wallet.RedPackGrapInfo;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.aio.item.QQWalletTroopHbItem;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.qphone.base.util.QLog;

public class wzh
  extends FrameLayout
{
  Context jdField_a_of_type_AndroidContentContext;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  QQWalletTroopHbItem jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletTroopHbItem;
  
  public wzh(@NonNull Context paramContext, QQWalletTroopHbItem paramQQWalletTroopHbItem)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletTroopHbItem = paramQQWalletTroopHbItem;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    paramQQWalletTroopHbItem = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    paramQQWalletTroopHbItem.width = -2;
    paramQQWalletTroopHbItem.height = -2;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130844119);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    paramQQWalletTroopHbItem = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    paramQQWalletTroopHbItem.width = UIUtils.a(paramContext, 29.0F);
    paramQQWalletTroopHbItem.height = UIUtils.a(paramContext, 29.0F);
    paramQQWalletTroopHbItem.gravity = 1;
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    paramQQWalletTroopHbItem = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    paramQQWalletTroopHbItem.width = UIUtils.a(paramContext, 28.0F);
    paramQQWalletTroopHbItem.height = UIUtils.a(paramContext, 28.0F);
    paramQQWalletTroopHbItem.gravity = 17;
  }
  
  public void a(RedPackGrapInfo paramRedPackGrapInfo)
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = FaceDrawable.a(TroopUnAccalimedRedPacketList.a(), String.valueOf(paramRedPackGrapInfo.lUin), (byte)3);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletTroopHbItem != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletTroopHbItem.a(paramRedPackGrapInfo);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletTroopHbItem.a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      if (localObject == null) {
        break label116;
      }
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 11.5F);
      localLayoutParams.gravity = 16;
      ((FrameLayout)localObject).setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletTroopHbItem.a((FrameLayout)localObject, paramRedPackGrapInfo, new wzi(this));
    }
    label116:
    while (!QLog.isColorLevel())
    {
      LinearLayout.LayoutParams localLayoutParams;
      return;
    }
    QLog.w(TroopUnAccalimedRedPacketList.b(), 2, "red packet item layout is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wzh
 * JD-Core Version:    0.7.0.1
 */