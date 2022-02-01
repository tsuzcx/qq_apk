import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser.PublicAccountBrowserFragment;
import com.tencent.biz.pubaccount.PublicAccountBrowser.PublicAccountBrowserFragment.1.1;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class kai
  implements View.OnClickListener
{
  public kai(PublicAccountBrowser.PublicAccountBrowserFragment paramPublicAccountBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      onClick(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str;
      if (!this.this$0.jdField_a_of_type_Arcd.a.isFullScreen)
      {
        str = this.this$0.jdField_a_of_type_Aqzl.rightViewText.getText().toString();
        this.this$0.j.loadUrl("javascript:onRightBtn(\"" + str + "\")");
      }
      else if (PublicAccountBrowser.PublicAccountBrowserFragment.a(this.this$0) == 1001)
      {
        ThreadManager.executeOnSubThread(new PublicAccountBrowser.PublicAccountBrowserFragment.1.1(this));
        this.this$0.getActivity().finish();
      }
      else
      {
        onClick(paramView);
        continue;
        if (!this.this$0.jdField_a_of_type_Arcd.a.isFullScreen)
        {
          str = this.this$0.jdField_a_of_type_Aqzl.leftView.getText().toString();
          if (str.equals(PublicAccountBrowser.PublicAccountBrowserFragment.a(this.this$0).getStringExtra("leftViewText"))) {
            this.this$0.biT();
          } else {
            this.this$0.j.loadUrl("javascript:onLeftBtn(\"" + str + "\")");
          }
        }
        else
        {
          onClick(paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kai
 * JD-Core Version:    0.7.0.1
 */