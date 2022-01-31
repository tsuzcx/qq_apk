import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRCardActivity;
import com.tencent.widget.MenuPopupDialog;

class pp
  implements View.OnClickListener
{
  pp(pn parampn) {}
  
  public void onClick(View paramView)
  {
    if (QRCardActivity.a(this.a.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity) != null) {
      QRCardActivity.a(this.a.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity).dismiss();
    }
    paramView = (TextView)this.a.jdField_a_of_type_AndroidViewView.findViewById(2131296569);
    if ((paramView.getText() instanceof String)) {
      this.a.a((String)paramView.getText());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     pp
 * JD-Core Version:    0.7.0.1
 */