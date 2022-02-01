package com.tencent.mobileqq.activity.history;

import aavw;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import aqha;
import aqju;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import java.util.ArrayList;
import zej;
import zek;
import zel;
import zer;
import zgr;
import zja;
import zjl;
import zjl.a;

public abstract class ChatHistoryBaseFragment
  extends ReportV4Fragment
{
  aqju D;
  Dialog G;
  public aavw a;
  protected ProgressView a;
  protected zer a;
  zgr jdField_a_of_type_Zgr = new zel(this);
  public zja a;
  zjl.a jdField_a_of_type_Zjl$a = new zek(this);
  public zjl a;
  public boolean aTT;
  public boolean bqX;
  private int cdl;
  protected Dialog g;
  public BaseActivity mActivity;
  public QQAppInterface mApp;
  protected View mContentView;
  protected Handler mHandler = new Handler(Looper.getMainLooper());
  private int mPos;
  protected String mUin;
  public boolean mk;
  
  public void BA(boolean paramBoolean) {}
  
  public void Fe(int paramInt)
  {
    this.cdl = paramInt;
  }
  
  public void a(CharSequence paramCharSequence, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler.post(new ChatHistoryBaseFragment.4(this, paramOnCancelListener, paramCharSequence));
  }
  
  public void a(zer paramzer)
  {
    this.jdField_a_of_type_Zer = paramzer;
  }
  
  protected abstract void bpM();
  
  protected abstract void bpN();
  
  public void bpm()
  {
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler.post(new ChatHistoryBaseFragment.5(this));
  }
  
  protected void coH()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(4));
    this.jdField_a_of_type_Zjl.hk(localArrayList);
  }
  
  public void coI()
  {
    this.jdField_a_of_type_Zja.cpw();
    this.jdField_a_of_type_Zer.coI();
    this.aTT = false;
  }
  
  public void coJ() {}
  
  public void coK() {}
  
  public void coL() {}
  
  public void coM() {}
  
  public void coN() {}
  
  public void coO() {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Zjl != null) {
      this.jdField_a_of_type_Zjl.dismiss();
    }
    bpN();
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_Zjl != null) {
      this.jdField_a_of_type_Zjl.dismiss();
    }
    this.jdField_a_of_type_Aavw.Ck(9);
  }
  
  public void doOnResume()
  {
    this.jdField_a_of_type_Zer.a(this.jdField_a_of_type_Zgr);
    this.jdField_a_of_type_Zer.Fg(yg());
    this.jdField_a_of_type_Zer.BB(true);
    this.jdField_a_of_type_Aavw.Ck(5);
  }
  
  public String getUin()
  {
    return this.mUin;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Zja = new zja();
    this.jdField_a_of_type_Aavw = new aavw(this);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mContentView = paramView;
    if ((this.mContentView != null) && (this.bqX))
    {
      doOnResume();
      this.mk = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.BaseFragment", 2, "onViewCreated " + xZ());
    }
    if (this.mActivity == null) {
      return;
    }
    this.jdField_a_of_type_Zjl = new zjl(this.mActivity, (ViewGroup)getView());
    this.jdField_a_of_type_Zjl.a(this.jdField_a_of_type_Zjl$a);
    coH();
  }
  
  public void pH(boolean paramBoolean)
  {
    if (this.mContentView != null)
    {
      if ((!paramBoolean) || (this.mk)) {
        break label71;
      }
      doOnResume();
    }
    label71:
    label96:
    for (;;)
    {
      this.mk = paramBoolean;
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "onTabChange " + paramBoolean + " " + xZ());
      }
      return;
      if (!paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        if ((i & this.mk) == 0) {
          break label96;
        }
        doOnPause();
        break;
      }
    }
  }
  
  public void setActivity(BaseActivity paramBaseActivity)
  {
    this.mActivity = paramBaseActivity;
  }
  
  public void setApp(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    bpM();
  }
  
  public void setPos(int paramInt)
  {
    this.mPos = paramInt;
  }
  
  public void setUin(String paramString)
  {
    this.mUin = paramString;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    this.bqX = paramBoolean;
  }
  
  public void showProgressDialog()
  {
    if (this.G == null)
    {
      this.G = new ReportDialog(getActivity(), 2131756467);
      this.G.setCanceledOnTouchOutside(false);
      this.G.setContentView(2131559761);
    }
    TextView localTextView = (TextView)this.G.findViewById(2131373180);
    localTextView.setText(localTextView.getResources().getString(2131690167));
    if (!this.G.isShowing()) {}
    try
    {
      this.G.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void showTipsDialog(String paramString)
  {
    if (this.D == null)
    {
      this.D = aqha.a(getActivity(), 230);
      this.D.setNegativeButton(2131720227, new zej(this));
    }
    if (!this.D.isShowing()) {
      this.D.setMessage(paramString);
    }
    for (;;)
    {
      try
      {
        this.D.show();
        return;
      }
      catch (Throwable paramString) {}
      this.D.dismiss();
    }
  }
  
  public int xZ()
  {
    return this.mPos;
  }
  
  public int yf()
  {
    return this.cdl;
  }
  
  protected int yg()
  {
    return 1600;
  }
  
  static class ProgressView
    extends FrameLayout
  {
    private ProgressBar mProgressBar;
    private TextView nM;
    
    public ProgressView(Context paramContext)
    {
      super();
      init(paramContext);
    }
    
    public ProgressView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      init(paramContext);
    }
    
    private void init(Context paramContext)
    {
      LayoutInflater.from(paramContext).inflate(2131562047, this);
      this.mProgressBar = ((ProgressBar)findViewById(2131373659));
      this.nM = ((TextView)findViewById(2131379401));
    }
    
    public void setProgressText(CharSequence paramCharSequence)
    {
      if ((paramCharSequence == null) || (paramCharSequence.length() <= 0))
      {
        this.nM.setVisibility(8);
        return;
      }
      this.nM.setVisibility(0);
      this.nM.setText(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment
 * JD-Core Version:    0.7.0.1
 */