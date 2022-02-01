import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.biz.qrcode.activity.QRCardActivity;

public class rud
  implements View.OnLongClickListener
{
  private View.OnClickListener bu = new ruf(this);
  View view;
  
  public rud(QRCardActivity paramQRCardActivity) {}
  
  @SuppressLint({"ServiceCast", "NewApi"})
  void copyContent(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (Build.VERSION.SDK_INT < 11) {
        ((android.text.ClipboardManager)this.this$0.getSystemService("clipboard")).setText(paramString);
      }
    }
    else {
      return;
    }
    android.content.ClipboardManager localClipboardManager = (android.content.ClipboardManager)this.this$0.getSystemService("clipboard");
    alkw.a(localClipboardManager, paramString);
    localClipboardManager.setText(paramString);
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    this.view = paramView;
    paramView.setSelected(true);
    aqoa localaqoa = new aqoa();
    localaqoa.Z(2131365509, this.this$0.getString(2131692330), 2130839077);
    aqgq.a(paramView, localaqoa, this.bu, new rue(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rud
 * JD-Core Version:    0.7.0.1
 */