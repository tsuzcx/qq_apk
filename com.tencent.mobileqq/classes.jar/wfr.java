import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.biz.qrcode.activity.QRCardActivity;

public class wfr
  implements View.OnLongClickListener
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new wft(this);
  View jdField_a_of_type_AndroidViewView;
  
  public wfr(QRCardActivity paramQRCardActivity) {}
  
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
    bbmf localbbmf = new bbmf();
    localbbmf.a(2131364824, this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.getString(2131691307), 2130838597);
    bbcq.a(paramView, localbbmf, this.jdField_a_of_type_AndroidViewView$OnClickListener, new wfs(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wfr
 * JD-Core Version:    0.7.0.1
 */