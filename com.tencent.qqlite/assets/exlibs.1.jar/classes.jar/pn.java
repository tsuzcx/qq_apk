import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.biz.qrcode.activity.QRCardActivity;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.widget.MenuPopupDialog;

public class pn
  implements View.OnLongClickListener
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new pp(this);
  View jdField_a_of_type_AndroidViewView;
  
  public pn(QRCardActivity paramQRCardActivity) {}
  
  @SuppressLint({"ServiceCast", "NewApi"})
  void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (Build.VERSION.SDK_INT < 11) {
        ((android.text.ClipboardManager)this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.getSystemService("clipboard")).setText(paramString);
      }
    }
    else {
      return;
    }
    ((android.content.ClipboardManager)this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.getSystemService("clipboard")).setText(paramString);
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    paramView.setSelected(true);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131298937, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.getString(2131363564));
    QRCardActivity.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity, MenuPopupDialog.a(paramView, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.getString(2131363277), localQQCustomMenu, this.jdField_a_of_type_AndroidViewView$OnClickListener, new po(this, paramView)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     pn
 * JD-Core Version:    0.7.0.1
 */