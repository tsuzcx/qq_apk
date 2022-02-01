package cooperation.qqreader.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import aqiw;
import avmr;
import avni;
import avnt;
import avnu;
import avnv;
import avnw;
import avnx;
import avob.a;
import avoc;
import avom;
import avom.a;
import avop;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qqreader.net.BusinessTask;
import cooperation.qqreader.view.FrameLoading;
import cooperation.qqreader.view.LoadingImageView;
import mqq.os.MqqHandler;

public class ForceUserUpdateActivity
  extends Activity
{
  private TextView Uf;
  private avom jdField_a_of_type_Avom;
  private LoadingImageView jdField_a_of_type_CooperationQqreaderViewLoadingImageView;
  private boolean dnB;
  private avni e = new avnt(this);
  private avni f = new avnu(this);
  private avni g = new avnv(this);
  private Context mContext;
  private long mStartLoadingTime = -1L;
  
  private void ZX(String paramString)
  {
    avoc.e("ForceUserUpdateActivity", paramString);
    ZY("哎呀，升级出了点问题，再试试看吧~");
  }
  
  private void ZY(String paramString)
  {
    if ((isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (isDestroyed()))) {
      avoc.u("ForceUserUpdateActivity", "showRetryDialog: activity 已经销毁，不显示Dialog");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Avom == null) {
        this.jdField_a_of_type_Avom = new avom.a(this).a(paramString).a("退出", new avnx(this)).b("重试", new avnw(this)).a();
      }
    } while (this.jdField_a_of_type_Avom.isShowing());
    this.jdField_a_of_type_Avom.show();
  }
  
  private void aDE()
  {
    if (!aqiw.isNetworkAvailable()) {
      ZY("网络连接异常，请检查网络后重试");
    }
    do
    {
      return;
      if (!avmr.da()) {
        eBg();
      }
    } while (avob.a.cP(this));
    eBi();
  }
  
  private void abO(int paramInt)
  {
    paramInt = Math.max(paramInt, 5);
    ThreadManager.getUIHandler().postDelayed(new ForceUserUpdateActivity.2(this), paramInt * 1000);
  }
  
  private void eBf()
  {
    this.Uf.setVisibility(8);
    this.jdField_a_of_type_CooperationQqreaderViewLoadingImageView.setVisibility(8);
    ThreadManager.getUIHandler().postDelayed(new ForceUserUpdateActivity.1(this), 300L);
  }
  
  private void eBg()
  {
    BusinessTask localBusinessTask = new BusinessTask("QueryUserGrayUpdateStateTask");
    localBusinessTask.a(this.f, false);
    localBusinessTask.execute();
  }
  
  private void eBh()
  {
    BusinessTask localBusinessTask = new BusinessTask("UpdateToQQBookstoreTask");
    localBusinessTask.a(this.g, false);
    localBusinessTask.execute();
  }
  
  private void eBi()
  {
    avop.a(avop.p, this.e);
  }
  
  private void eBj()
  {
    avob.a.bc(this.mContext, 1);
    eBk();
  }
  
  private void eBk()
  {
    long l2 = 1000L;
    long l1;
    if ((!this.dnB) && (avmr.da()) && (avob.a.cP(this.mContext)))
    {
      if (this.mStartLoadingTime <= 0L) {
        break label74;
      }
      l1 = System.currentTimeMillis() - this.mStartLoadingTime;
      if (1000L - l1 <= 0L) {
        break label79;
      }
      l1 = l2;
    }
    label74:
    label79:
    for (;;)
    {
      ThreadManager.getUIHandler().postDelayed(new ForceUserUpdateActivity.8(this), l1);
      return;
      l1 = 0L;
      break;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    this.mContext = this;
    paramBundle = new FrameLoading(this);
    paramBundle.setBackgroundColor(-1);
    setContentView(paramBundle);
    this.Uf = paramBundle.ny;
    this.jdField_a_of_type_CooperationQqreaderViewLoadingImageView = paramBundle.b;
    this.Uf.setText("正在升级到新书城，请稍等...");
    eBf();
    aDE();
    avoc.u("cost_time_tag", "ForceUserUpdateActivity mClickToOnCreateTime=" + (System.currentTimeMillis() - getIntent().getLongExtra("key_click_leba_start_time", 0L)));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_Avom != null) && (this.jdField_a_of_type_Avom.isShowing()))
    {
      this.jdField_a_of_type_Avom.dismiss();
      this.jdField_a_of_type_Avom = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.ui.ForceUserUpdateActivity
 * JD-Core Version:    0.7.0.1
 */