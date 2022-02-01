import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.Advertisement.fragment.WebpageFragment;
import com.tencent.mobileqq.theme.ThemeUtil;

public class jwr
  extends Handler
{
  public jwr(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            int i;
            do
            {
              do
              {
                return;
                i = paramMessage.arg1;
              } while (PublicAccountAdvertisementActivity.a(this.this$0) == null);
              PublicAccountAdvertisementActivity.a(this.this$0).mE(i);
              if ((i > 0) && (i < 100))
              {
                PublicAccountAdvertisementActivity.a(this.this$0).lF(true);
                return;
              }
            } while (i != 100);
            PublicAccountAdvertisementActivity.a(this.this$0).lF(false);
            return;
            switch (paramMessage.arg1)
            {
            case 201: 
            case 202: 
            case 203: 
            default: 
              this.this$0.showToast(2131689696);
              return;
            case -24: 
              this.this$0.lv(this.this$0.getString(2131689693));
              return;
            }
            this.this$0.showToast(2131689697);
            return;
            this.this$0.lv(this.this$0.getString(2131689695));
            return;
          } while (PublicAccountAdvertisementActivity.a(this.this$0) == null);
          VideoCoverFragment localVideoCoverFragment = PublicAccountAdvertisementActivity.a(this.this$0);
          if (paramMessage.arg1 == 1) {}
          for (;;)
          {
            localVideoCoverFragment.lF(bool);
            return;
            bool = false;
          }
        } while (!this.this$0.isResume());
        paramMessage = this.this$0.getSupportFragmentManager().beginTransaction();
        PublicAccountAdvertisementActivity.a(this.this$0, WebpageFragment.a(this.this$0.getIntent()));
        PublicAccountAdvertisementActivity.a(this.this$0).a(PublicAccountAdvertisementActivity.a(this.this$0));
        paramMessage.add(2131382172, PublicAccountAdvertisementActivity.a(this.this$0));
        paramMessage.commit();
      } while (!ThemeUtil.isInNightMode(this.this$0.getAppRuntime()));
      paramMessage = this.this$0.findViewById(2131372391);
    } while (paramMessage == null);
    paramMessage.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jwr
 * JD-Core Version:    0.7.0.1
 */