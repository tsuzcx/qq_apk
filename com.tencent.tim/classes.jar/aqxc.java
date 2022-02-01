import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.vipav.VipFullScreenVideoView;
import com.tencent.mobileqq.vipav.VipFunCallPreviewActivity;
import java.util.ArrayList;

public class aqxc
  extends Handler
{
  public aqxc(VipFunCallPreviewActivity paramVipFunCallPreviewActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    BitmapDrawable localBitmapDrawable;
    do
    {
      RelativeLayout localRelativeLayout;
      do
      {
        do
        {
          return;
          if (this.this$0.mUins.size() > 0)
          {
            if (this.this$0.cWL)
            {
              if ((this.this$0.Jn instanceof Button)) {
                ((Button)this.this$0.Jn).setText(acfp.m(2131716761));
              }
              this.this$0.Jn.setEnabled(false);
              return;
            }
            this.this$0.Jn.setEnabled(true);
            return;
          }
          if (this.this$0.cWL)
          {
            this.this$0.Jn.setVisibility(0);
            this.this$0.Jn.setEnabled(true);
            if ((this.this$0.Jn instanceof Button)) {
              ((Button)this.this$0.Jn).setText(acfp.m(2131716755));
            }
            this.this$0.Jn.setEnabled(false);
            this.this$0.hy.setVisibility(8);
            this.this$0.Jm.setVisibility(8);
            return;
          }
          this.this$0.hy.setEnabled(true);
          return;
        } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof BitmapDrawable)));
        localRelativeLayout = (RelativeLayout)this.this$0.findViewById(2131382019);
        localBitmapDrawable = (BitmapDrawable)paramMessage.obj;
      } while ((localBitmapDrawable == null) || (localRelativeLayout == null));
      localRelativeLayout.setBackgroundDrawable(localBitmapDrawable);
    } while (paramMessage.arg1 != 1);
    this.this$0.a.setBackgroundDrawable(localBitmapDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqxc
 * JD-Core Version:    0.7.0.1
 */