import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class wwo
  implements View.OnClickListener
{
  wwo(wwn paramwwn, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (!this.aUj.equals("0"))
      {
        wwn.a(this.a).a.getText().clear();
        wwn.a(this.a).zO(wwn.a(this.a));
      }
      int i = wwn.a(this.a).a.getSelectionStart();
      Editable localEditable = wwn.a(this.a).a.getText();
      this.a.bgi = true;
      localEditable.insert(i, this.aUk);
      this.a.bgi = false;
      wwn.a(this.a).a.setSelection(localEditable.length());
      this.a.ccE();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("QWalletAIOLifeCycleHelper", 1, "onclick  PasswdRedBagTips throw an exception: " + localThrowable);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wwo
 * JD-Core Version:    0.7.0.1
 */