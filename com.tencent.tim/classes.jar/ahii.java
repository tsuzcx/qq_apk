import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahii
  implements View.OnClickListener
{
  ahii(ahih paramahih) {}
  
  public void onClick(View paramView)
  {
    if (this.a.b != null) {
      if (this.a.e != null) {}
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.e.hideSoftInputFromWindow();
      if (this.a.b.hasReplyText())
      {
        ((alvj)this.a.app.getManager(340)).Y(this.a.b);
        ahjw.a(this.a, this.a.b.uniseq);
      }
      for (;;)
      {
        this.a.dnZ();
        break;
        ahjh localahjh = new ahjh(this.a.e, this.a.app);
        localahjh.a(this.a.mActivity.getString(2131693987), this.a.b);
        this.a.e.addPreviewView(localahjh.getRootView());
      }
      if (QLog.isColorLevel()) {
        QLog.e("ForwardOption.ForwardMixedMsgOption", 2, "no msg not enter preview");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahii
 * JD-Core Version:    0.7.0.1
 */