import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment.a;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afwc
  implements View.OnClickListener
{
  public afwc(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  public void onClick(View paramView)
  {
    anot.a(this.this$0.mApp, "dc00898", "", "", "0X8009E2F", "0X8009E2F", 0, 0, "", "", "", "");
    if (this.this$0.b != null)
    {
      afxv.a().NF(3);
      this.this$0.b.dcN();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afwc
 * JD-Core Version:    0.7.0.1
 */