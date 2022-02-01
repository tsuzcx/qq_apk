import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.widget.QFileSendBarManager.5;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class ahdb
  extends ahda
{
  private arhz Q;
  private TextView SB;
  private TextView SC;
  private String bJv;
  private String bKa;
  private int cZr;
  private int cZs;
  private View.OnClickListener fc = new ahdc(this);
  
  public ahdb(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView)
  {
    super(paramQQAppInterface, paramContext, paramQFileSendBottomView);
    dmB();
  }
  
  private void am(int paramInt)
  {
    if (this.Q != null) {
      btB();
    }
    for (;;)
    {
      if (!this.Q.isShowing()) {
        this.Q.show();
      }
      return;
      this.Q = new arhz(SplashActivity.sTopActivity, SplashActivity.sTopActivity.getResources().getDimensionPixelSize(2131299627));
      this.Q.setCancelable(false);
      this.Q.setMessage(acfp.m(2131714293));
      this.Q.show();
    }
  }
  
  private void btB()
  {
    try
    {
      if ((this.Q != null) && (this.Q.isShowing())) {
        this.Q.cancel();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void dmB()
  {
    this.SB = ((TextView)this.a.M(2131377979));
    this.SC = ((TextView)this.a.M(2131372449));
    this.SB.setOnClickListener(this.fc);
  }
  
  private void dmC()
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      ahao.OS(2131696206);
      return;
    }
    if ((ahav.amK()) && (agmz.fO() > agmx.fJ()))
    {
      ahav.a(true, this.mContext, new ahdd(this), this.cZs);
      return;
    }
    dmE();
  }
  
  private void dmD()
  {
    if (apsv.aH(this.mContext) == 0)
    {
      apsd.ck(this.mContext, this.mContext.getString(2131699827));
      dmE();
    }
    do
    {
      return;
      if (!ahav.amK()) {
        break;
      }
    } while (!armm.a((Activity)this.mContext, 2, new ahde(this)));
    Object localObject = new ahdf(this);
    String str = this.mContext.getString(2131699611);
    localObject = aqha.a(this.mContext, 230, this.mContext.getString(2131699824), str, 2131721058, 2131700020, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
    if ((aequ.d().b.enable) && (!aqvn.a().pz())) {
      ((aqju)localObject).setMessageWithoutAutoLink(aequ.d().b.a(this.mContext, str));
    }
    ((aqju)localObject).show();
    return;
    dmE();
  }
  
  public void cD(Bundle paramBundle)
  {
    super.cD(paramBundle);
    if (this.cgf)
    {
      this.cZr = this.be.getInt("qfile_search_param_exparams_busi_type");
      this.bJv = this.be.getString("qfile_search_param_ex_params_target_uin");
      this.cZs = this.be.getInt("qfile_search_param_exparams_peer_type", -1);
      this.bKa = this.be.getString("qfile_search_param_exparams_send_uin");
    }
  }
  
  public void dko()
  {
    String str = this.mContext.getString(2131693581) + this.mContext.getString(2131693788) + agmz.fN() + this.mContext.getString(2131693789);
    long l = agmz.fP();
    Object localObject1 = "";
    if (l > 0L) {
      localObject1 = this.mContext.getString(2131693579) + ahbj.g(l);
    }
    Object localObject2 = localObject1;
    if (agmz.fQ() > 0L)
    {
      localObject2 = localObject1;
      if (!ahav.bm(this.mContext)) {
        localObject2 = (String)localObject1 + this.mContext.getString(2131693580) + ahbj.g(agmz.fQ());
      }
    }
    this.SB.setText(str);
    localObject1 = this.SB;
    if (agmz.fN() > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      ((TextView)localObject1).setEnabled(bool);
      this.SC.setText((CharSequence)localObject2);
      return;
    }
  }
  
  public void dmE()
  {
    am(2131696937);
    new Handler().postDelayed(new QFileSendBarManager.5(this), 100L);
  }
  
  public void dmz()
  {
    super.dmz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahdb
 * JD-Core Version:    0.7.0.1
 */