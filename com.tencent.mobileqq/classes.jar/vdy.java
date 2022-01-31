import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletRedPkgUtils;

public class vdy
  implements View.OnClickListener
{
  public vdy(QQWalletMsgItemBuilder paramQQWalletMsgItemBuilder) {}
  
  public void onClick(View paramView)
  {
    paramView = (String)paramView.getTag();
    if (!TextUtils.isEmpty(paramView)) {
      QWalletRedPkgUtils.b(this.a.a, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vdy
 * JD-Core Version:    0.7.0.1
 */