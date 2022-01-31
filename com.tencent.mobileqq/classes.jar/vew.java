import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.SignatureView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import mqq.app.MobileQQ;

public class vew
  implements URLDrawable.URLDrawableListener
{
  public vew(RichStatItemBuilder paramRichStatItemBuilder, RichStatItemBuilder.Holder paramHolder) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.a.a = SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources(), this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager, RichStatItemBuilder.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    paramURLDrawable = ((SignatureManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(57)).a(Integer.toString(RichStatItemBuilder.a().tplId));
    if (!TextUtils.isEmpty(paramURLDrawable.p)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.a.c = Color.parseColor(paramURLDrawable.p);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder$Holder.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vew
 * JD-Core Version:    0.7.0.1
 */