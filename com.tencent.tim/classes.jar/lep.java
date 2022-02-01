import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class lep
  implements CompoundButton.OnCheckedChangeListener
{
  public lep(ReadInJoySelfFragment paramReadInJoySelfFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ReadInJoySelfFragment.a(this.this$0).mS(paramBoolean);
    if (paramBoolean)
    {
      QQToast.a(this.this$0.mContentView.getContext(), this.this$0.mContentView.getContext().getResources().getString(2131701905), 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
      kbp.a(null, "CliOper", "", "", "0X80067D6", "0X80067D6", 0, 0, "", "", "", kxm.iQ(), false);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      kbp.a(null, "CliOper", "", "", "0X800705C", "0X800705C", 0, 0, "", "", "", kxm.iQ(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lep
 * JD-Core Version:    0.7.0.1
 */