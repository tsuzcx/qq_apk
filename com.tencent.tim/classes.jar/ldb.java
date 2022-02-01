import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class ldb
  implements View.OnClickListener
{
  ldb(lcz paramlcz, QQAppInterface paramQQAppInterface, GuideData paramGuideData, FrameLayout paramFrameLayout) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (mfo)this.val$app.getManager(270);
    if (((mfo)localObject).oH() == 1)
    {
      ((mfo)localObject).nQ(false);
      localObject = ((mfo)localObject).a(lcz.a(this.this$0), 0);
      if (localObject != null)
      {
        ((RefreshData)localObject).isShown = false;
        aqmj.l(lcz.a(this.this$0), this.val$app.getCurrentAccountUin(), ((RefreshData)localObject).toJson().toString(), 0);
      }
    }
    ((mfs)this.val$app.getManager(261)).e(1, this.b.skinData.id, false);
    lcz.a(this.this$0).onDestroy();
    this.W.removeView(lcz.a(this.this$0));
    lcz.a(this.this$0, null);
    aqmj.ag(lcz.a(this.this$0), this.val$app.getCurrentAccountUin(), this.b.skinData.toJson().toString());
    if (QLog.isColorLevel()) {
      QLog.d("RIJSkinOperationPopupStep", 2, "set skin: id = " + this.b.skinData.id);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ldb
 * JD-Core Version:    0.7.0.1
 */