import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyShareFragment;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class lue
  implements ViewBase.OnClickListener
{
  lue(ltz paramltz) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    kvx.a(this.a.b, paramViewBase);
    paramViewBase = lty.a(this.a.this$0, this.a.b.getData());
    if (paramViewBase == null)
    {
      QLog.e(lty.a(this.a.this$0), 1, "daily share info is null");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("share_info_intent", paramViewBase.toString());
    PublicFragmentActivity.start(lty.a(this.a.this$0).getContext(), localIntent, ReadInJoyDailyShareFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lue
 * JD-Core Version:    0.7.0.1
 */