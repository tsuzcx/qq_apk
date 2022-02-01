import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqkv
  implements View.OnClickListener
{
  aqkv(aqku paramaqku, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt) {}
  
  public void onClick(View paramView)
  {
    anot.a(this.val$app, "CliOper", "", "", "0X8009BE7", "0X8009BE7", 1, 0, "", "", "", "");
    this.a.hideSoftInputFromWindow();
    ahjl localahjl = new ahjl(this.a);
    localahjl.k(this.val$app, this.ctZ, this.val$uin, this.alR);
    this.a.addPreviewView(localahjl.getRootView());
    anot.a(this.val$app, "CliOper", "", "", "0X8009AAD", "0X8009AAD", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqkv
 * JD-Core Version:    0.7.0.1
 */