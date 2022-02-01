import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class anrm
  implements View.OnClickListener
{
  public anrm(StructMsgForGeneralShare paramStructMsgForGeneralShare, Context paramContext, Resources paramResources, PopupWindow paramPopupWindow) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    int k;
    int m;
    try
    {
      ViewGroup localViewGroup = (ViewGroup)((FragmentActivity)this.val$context).getChatFragment().a().mAIORootView.findViewById(2131362727);
      if (localViewGroup == null)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject = null;
      }
      int[] arrayOfInt = new int[2];
      ((ViewGroup)localObject).getLocationOnScreen(arrayOfInt);
      int i = arrayOfInt[1];
      int j = ((ViewGroup)localObject).getHeight();
      localObject = new int[2];
      paramView.getLocationOnScreen((int[])localObject);
      this.this$0.mClickpositionX = localObject[0];
      this.this$0.mClickpositionY = localObject[1];
      k = wja.dp2px(106.0F, this.g);
      m = paramView.getHeight();
      if (this.this$0.mClickpositionY - i + m + k <= j) {
        break label269;
      }
    }
    this.l.setBackgroundDrawable(this.val$context.getResources().getDrawable(2130847973));
    this.l.showAtLocation(paramView, 0, this.this$0.mClickpositionX, this.this$0.mClickpositionY - k);
    for (;;)
    {
      ((kds)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(139)).a(9, this.this$0.message);
      localObject = ((Activity)this.val$context).getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).alpha = 0.5F;
      ((Activity)this.val$context).getWindow().setAttributes((WindowManager.LayoutParams)localObject);
      this.l.setOnDismissListener(new anrn(this));
      break;
      label269:
      this.l.setBackgroundDrawable(this.val$context.getResources().getDrawable(2130847972));
      this.l.showAtLocation(paramView, 0, this.this$0.mClickpositionX, this.this$0.mClickpositionY + m);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anrm
 * JD-Core Version:    0.7.0.1
 */