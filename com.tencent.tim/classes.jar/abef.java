import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class abef
  implements View.OnClickListener
{
  abef(abec paramabec) {}
  
  public void onClick(View paramView)
  {
    ((SlideDetectListView)abec.a(this.b)).eiZ();
    Object localObject = (View)paramView.getParent();
    if ((localObject instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)localObject).eiW();
    }
    localObject = paramView.getTag();
    if (!(localObject instanceof DiscussionInfo)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)localObject;
      if (aqiw.getSystemNetwork(abec.a(this.b)) == 0)
      {
        localObject = (BaseActivity)abec.a(this.b);
        QQToast.a((Context)localObject, 2131698346, 0).show(((BaseActivity)localObject).getTitleBarHeight());
      }
      else if ((!localDiscussionInfo.hasCollect) && (((acdu)this.b.e.getManager(53)).Aq() >= 80))
      {
        localObject = (BaseActivity)abec.a(this.b);
        QQToast.a((Context)localObject, abec.a(this.b).getString(2131698344, new Object[] { String.valueOf(80) }), 0).show(((BaseActivity)localObject).getTitleBarHeight());
      }
      else
      {
        acdt localacdt = (acdt)this.b.e.getBusinessHandler(6);
        if (localDiscussionInfo.hasCollect) {}
        for (localObject = "0X8006898";; localObject = "0X8006897")
        {
          anot.a(this.b.e, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
          if (!localDiscussionInfo.hasCollect) {
            break label269;
          }
          localacdt.ho(Long.valueOf(localDiscussionInfo.uin).longValue());
          break;
        }
        label269:
        localacdt.hn(Long.valueOf(localDiscussionInfo.uin).longValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abef
 * JD-Core Version:    0.7.0.1
 */