import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity.5;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

public class kin
  implements View.OnClickListener
{
  public kin(ReadInJoyNewFeedsActivity.5 param5, FrameLayout paramFrameLayout) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (mfo)this.a.this$0.app.getManager(270);
    if (((mfo)localObject).oH() == 1)
    {
      ((mfo)localObject).nQ(false);
      localObject = ((mfo)localObject).a(this.a.this$0, 0);
      if (localObject != null)
      {
        ((RefreshData)localObject).isShown = false;
        aqmj.l(this.a.this$0, this.a.this$0.app.getCurrentAccountUin(), ((RefreshData)localObject).toJson().toString(), 0);
      }
    }
    ((mfs)this.a.this$0.app.getManager(261)).e(1, this.a.b.skinData.id, false);
    aqmj.ag(this.a.this$0, this.a.this$0.app.getCurrentAccountUin(), this.a.b.skinData.toJson().toString());
    this.a.this$0.a.onDestroy();
    this.W.removeView(this.a.this$0.a);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "set skin ：id = " + this.a.b.skinData.id);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kin
 * JD-Core Version:    0.7.0.1
 */