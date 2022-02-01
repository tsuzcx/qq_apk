import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.vip.qqbanner.QbossADImmersionBannerManager.1;
import mqq.os.MqqHandler;

public class awmq
  extends aaje
{
  private ImageView HH;
  private TextView HV;
  private TextView Wj;
  private awij a;
  private TextView agE;
  private awmo b;
  private RelativeLayout fj;
  private ImageView gH;
  private RelativeLayout nP;
  
  private void PZ()
  {
    ViewGroup.LayoutParams localLayoutParams = this.zz.getLayoutParams();
    if (localLayoutParams == null) {
      localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
    }
    for (;;)
    {
      localLayoutParams.width = yF();
      localLayoutParams.height = yG();
      this.zz.setLayoutParams(localLayoutParams);
      Object localObject = (ViewGroup.MarginLayoutParams)this.fj.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
      this.fj.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.nP.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = yF();
      ((ViewGroup.LayoutParams)localObject).height = super.yG();
      this.nP.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.HH.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = ((int)(localLayoutParams.height * 2.050848F));
      ((ViewGroup.LayoutParams)localObject).height = localLayoutParams.height;
      this.HH.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
  }
  
  private int a(awmo paramawmo)
  {
    if ((paramawmo == null) || (TextUtils.isEmpty(paramawmo.cRC))) {
      return 24;
    }
    try
    {
      int i = Integer.parseInt(paramawmo.cRC);
      return i;
    }
    catch (Exception paramawmo)
    {
      paramawmo.printStackTrace();
      QLog.i("QbossADBannerManager", 1, "getFrameRate exception");
    }
    return 24;
  }
  
  private void eEv()
  {
    if ((this.mActivity == null) || (this.mActivity.app == null)) {
      return;
    }
    MqqHandler localMqqHandler = this.mActivity.app.getHandler(Conversation.class);
    if (localMqqHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1062;
      localMessage.obj = new View[] { this.mLayout, this.HV, this.gH };
      localMqqHandler.sendMessage(localMessage);
      return;
    }
    QLog.i("QbossADBannerManager", 1, "handle is null.");
  }
  
  private void eEw()
  {
    if ((this.mActivity == null) || (this.mActivity.app == null)) {
      return;
    }
    MqqHandler localMqqHandler = this.mActivity.app.getHandler(Conversation.class);
    if (localMqqHandler != null)
    {
      localMqqHandler.sendEmptyMessage(1063);
      return;
    }
    QLog.i("QbossADBannerManager", 1, "handle is null.");
  }
  
  public void Cp(boolean paramBoolean)
  {
    super.Cp(paramBoolean);
    if (this.a != null)
    {
      if (paramBoolean) {
        this.a.stop();
      }
    }
    else {
      return;
    }
    this.a.start();
  }
  
  protected void a(aajc paramaajc)
  {
    super.a(paramaajc);
    ThreadManagerV2.getUIHandlerV2().post(new QbossADImmersionBannerManager.1(this, paramaajc));
  }
  
  public View bH()
  {
    View localView = super.bH();
    this.Wj = ((TextView)localView.findViewById(2131380796));
    this.agE = ((TextView)localView.findViewById(2131380921));
    this.HV = ((TextView)localView.findViewById(2131369627));
    this.gH = ((ImageView)localView.findViewById(2131365438));
    this.HH = ((ImageView)localView.findViewById(2131368900));
    this.fj = ((RelativeLayout)localView.findViewById(2131365429));
    this.nP = ((RelativeLayout)localView.findViewById(2131370290));
    PZ();
    return new View(this.mActivity);
  }
  
  public void cuG()
  {
    super.cuG();
    eEv();
  }
  
  public void cuI()
  {
    super.cuI();
    if (this.a != null)
    {
      this.a.stop();
      this.a.release();
    }
    eEw();
  }
  
  public void onRecycle()
  {
    super.onRecycle();
    if (this.a != null)
    {
      this.a.stop();
      this.a.release();
    }
  }
  
  protected int yE()
  {
    return 2131562129;
  }
  
  protected int yG()
  {
    return super.yG() + ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) + aqnm.dpToPx(50.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awmq
 * JD-Core Version:    0.7.0.1
 */