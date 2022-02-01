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
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class kdx
  implements View.OnClickListener
{
  kdx(kdv paramkdv, Context paramContext, TextView paramTextView, MessageRecord paramMessageRecord) {}
  
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
      this.val$textView.getLocationOnScreen((int[])localObject);
      kdv.a(this.a, localObject[0]);
      kdv.b(this.a, localObject[1]);
      k = kdv.a(this.a).getContentView().getMeasuredHeight();
      if (QLog.isColorLevel()) {
        QLog.i("parsons", 2, "popheight: " + k);
      }
      m = this.val$textView.getHeight();
      if (kdv.a(this.a) - i + m + k <= j) {
        break label322;
      }
    }
    kdv.a(this.a).setBackgroundDrawable(this.val$context.getResources().getDrawable(2130847973));
    kdv.a(this.a).showAtLocation(this.val$textView, 0, kdv.b(this.a), kdv.a(this.a) - k);
    for (;;)
    {
      ((kds)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(139)).a(9, this.b);
      localObject = ((Activity)this.val$context).getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).alpha = 0.5F;
      ((Activity)this.val$context).getWindow().setAttributes((WindowManager.LayoutParams)localObject);
      kdv.a(this.a).setOnDismissListener(new kdy(this));
      break;
      label322:
      kdv.a(this.a).setBackgroundDrawable(this.val$context.getResources().getDrawable(2130847972));
      kdv.a(this.a).showAtLocation(this.val$textView, 0, kdv.b(this.a), m + kdv.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kdx
 * JD-Core Version:    0.7.0.1
 */