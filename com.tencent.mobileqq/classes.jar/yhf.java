import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.adapter.DiscussionListAdapter2;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class yhf
  implements View.OnClickListener
{
  public yhf(DiscussionListAdapter2 paramDiscussionListAdapter2) {}
  
  public void onClick(View paramView)
  {
    ((SlideDetectListView)DiscussionListAdapter2.a(this.a)).a();
    Object localObject = (View)paramView.getParent();
    if ((localObject instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)localObject).d();
    }
    paramView = paramView.getTag();
    if (!(paramView instanceof DiscussionInfo)) {
      return;
    }
    localObject = (DiscussionInfo)paramView;
    if (NetworkUtil.a(DiscussionListAdapter2.a(this.a)) == 0)
    {
      paramView = (BaseActivity)DiscussionListAdapter2.a(this.a);
      QQToast.a(paramView, 2131429834, 0).b(paramView.getTitleBarHeight());
      return;
    }
    if ((!((DiscussionInfo)localObject).hasCollect) && (((DiscussionManager)this.a.a.getManager(52)).a() >= 80))
    {
      paramView = (BaseActivity)DiscussionListAdapter2.a(this.a);
      QQToast.a(paramView, DiscussionListAdapter2.a(this.a).getString(2131429835, new Object[] { String.valueOf(80) }), 0).b(paramView.getTitleBarHeight());
      return;
    }
    DiscussionHandler localDiscussionHandler = (DiscussionHandler)this.a.a.a(6);
    if (((DiscussionInfo)localObject).hasCollect) {}
    for (paramView = "0X8006898";; paramView = "0X8006897")
    {
      ReportController.b(this.a.a, "CliOper", "", "", paramView, paramView, 0, 0, "", "", "", "");
      if (!((DiscussionInfo)localObject).hasCollect) {
        break;
      }
      localDiscussionHandler.e(Long.valueOf(((DiscussionInfo)localObject).uin).longValue());
      return;
    }
    localDiscussionHandler.d(Long.valueOf(((DiscussionInfo)localObject).uin).longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yhf
 * JD-Core Version:    0.7.0.1
 */