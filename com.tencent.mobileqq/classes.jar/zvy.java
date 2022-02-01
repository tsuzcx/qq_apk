import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.biz.qrcode.activity.QRCardActivity;

public class zvy
  implements View.OnLongClickListener
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new zwa(this);
  View jdField_a_of_type_AndroidViewView;
  
  public zvy(QRCardActivity paramQRCardActivity) {}
  
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
    bhuk localbhuk = new bhuk();
    localbhuk.a(2131365191, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.getString(2131691140), 2130838930);
    bhkx.a(paramView, localbhuk, this.jdField_a_of_type_AndroidViewView$OnClickListener, new zvz(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zvy
 * JD-Core Version:    0.7.0.1
 */