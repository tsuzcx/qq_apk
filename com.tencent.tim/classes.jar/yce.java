import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.util.List;
import java.util.Map;

class yce
  extends Handler
{
  yce(ycd paramycd) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 5: 
    case 8: 
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 6: 
    case 9: 
    case 7: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                      } while (((this.this$0.blJ) && ((!this.this$0.blK) || (((acja)this.this$0.app.getManager(56)).c(this.this$0.sessionInfo.aTl) == null))) || ((ycd.a(this.this$0)) && (keo.zc()) && (ycd.a(this.this$0) != null) && (ycd.b(this.this$0).findViewWithTag("echopCustomTabView") != null)) || (this.this$0.mActivity.isFinishing()));
                      try
                      {
                        this.this$0.cgS();
                        return;
                      }
                      catch (Exception paramMessage)
                      {
                        paramMessage.printStackTrace();
                        return;
                      }
                      paramMessage = this.this$0.jdField_b_of_type_Kaw.a(this.this$0.app, this.this$0.oL());
                      this.this$0.gw(paramMessage);
                    } while ((paramMessage == null) || (paramMessage.isEmpty()));
                    if ((!ycd.b(this.this$0)) || (!ahty.anY())) {
                      this.this$0.zP(true);
                    }
                  } while ((ycd.a(this.this$0)) && (keo.za()));
                  this.this$0.zP(true);
                  return;
                } while (((ycd.b(this.this$0)) && (ahty.anY())) || ((ycd.a(this.this$0)) && (keo.za())));
                this.this$0.cgP();
                this.this$0.cgO();
                if (QLog.isColorLevel()) {
                  QZLog.d(this.this$0.TAG, 2, "setInitHeader in INIT_PUBLICACCOUNT_COVER_MENU");
                }
              } while (this.this$0.mPromotionType == 1);
              this.this$0.bYs = 5;
              return;
            } while ((this.this$0.mActivity.isFinishing()) || (this.this$0.mProgress == null) || (!this.this$0.mProgress.isShowing()));
            this.this$0.mProgress.dismiss();
            QQToast.a(this.this$0.mActivity, 2131700605, 0).show(this.this$0.mActivity.getTitleBarHeight());
            return;
          } while ((this.this$0.mActivity.isFinishing()) || (paramMessage.arg2 != 1));
          int i = paramMessage.arg1;
          ycd.a(this.this$0, aqha.a(this.this$0.mContext, 230, null, String.format(acfp.m(2131710209), new Object[] { (String)paramMessage.obj }), acfp.m(2131710217), acfp.m(2131710214), new ycf(this, i), null));
          ycd.a(this.this$0).show();
          return;
          paramMessage = paramMessage.getData();
        } while (paramMessage == null);
        this.this$0.a.nz.put(paramMessage.getString("troopUin"), Integer.valueOf(this.this$0.app.a().A(paramMessage.getString("troopUin"), 1)));
        this.this$0.a.dYB();
        this.this$0.a.dYC();
        this.this$0.a.dYA();
        return;
      } while (this.this$0.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView == null);
      this.this$0.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.springBackOverScrollHeaderView();
      this.this$0.ob = false;
      return;
    }
    if (!(this.this$0.mActivity instanceof SplashActivity))
    {
      this.this$0.mActivity.finish();
      return;
    }
    paramMessage = new Intent(this.this$0.mActivity, SplashActivity.class);
    paramMessage.putExtra("tab_index", MainFragment.bIk);
    paramMessage.putExtra("fragment_id", 1);
    paramMessage.setFlags(67108864);
    this.this$0.mActivity.startActivity(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yce
 * JD-Core Version:    0.7.0.1
 */