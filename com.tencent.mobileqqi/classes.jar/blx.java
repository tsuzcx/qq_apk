import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRCardActivity;

class blx
  implements View.OnClickListener
{
  blx(blw paramblw) {}
  
  public void onClick(View paramView)
  {
    if ((QRCardActivity.a(this.a.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity) != null) && (QRCardActivity.a(this.a.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity).isShowing())) {
      QRCardActivity.a(this.a.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity).dismiss();
    }
    paramView = (TextView)this.a.jdField_a_of_type_AndroidViewView.findViewById(2131231118);
    if ((paramView.getText() instanceof String)) {
      this.a.a((String)paramView.getText());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     blx
 * JD-Core Version:    0.7.0.1
 */