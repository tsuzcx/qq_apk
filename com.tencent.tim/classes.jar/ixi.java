import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ixi
  implements View.OnClickListener
{
  public ixi(AVActivity paramAVActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.isDestroyed()) {}
    label237:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = this.this$0.a.b();
      if (!((iiv)localObject).Ql)
      {
        int i = ((iiv)localObject).amI;
        long l = AudioHelper.hG();
        QLog.w(this.this$0.TAG, 1, "onMsgClick, sessionType[" + i + "], state[" + ((iiv)localObject).state + "], seq[" + l + "]");
        if ((i == 1) || (i == 2))
        {
          if (!((iiv)localObject).tf()) {
            this.this$0.a(l, this.this$0.mPeerUin, this.this$0.mUinType, this.this$0.mName);
          }
        }
        else {
          for (;;)
          {
            if (AVActivity.a(this.this$0) == null) {
              break label237;
            }
            AVActivity.a(this.this$0).onBackPressed();
            break;
            if ((i == 3) || (i == 4))
            {
              localObject = String.valueOf(((iiv)localObject).ll);
              String str = this.this$0.mApp.getDisplayName(this.this$0.mUinType, (String)localObject, null);
              this.this$0.a(l, (String)localObject, this.this$0.mUinType, str);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ixi
 * JD-Core Version:    0.7.0.1
 */