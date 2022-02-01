import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class jfo
  extends ReportDialog
  implements View.OnClickListener
{
  public boolean YS;
  public VideoController a;
  jfn a;
  private int ayB;
  View iq;
  View ir;
  View is;
  Animation.AnimationListener m;
  private Context mContext;
  Button mEarbackBtn;
  public Handler mHandler;
  boolean mIsClosing;
  boolean mIsVideo;
  BroadcastReceiver mReceiver;
  public Runnable mRunnable;
  public TextView mTitleText;
  
  private void updateEarbackBtn()
  {
    int i = 2130843159;
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().Rm) {
      i = 2130843160;
    }
    this.mEarbackBtn.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
  }
  
  public void avM()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      igd.aL("VoiceChangeChooseDialog", "updateDialogStyle mVideoController is null!!");
      return;
    }
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 2) || (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 4))
    {
      bool = true;
      this.mIsVideo = bool;
      if (!this.mIsVideo) {
        break label118;
      }
      this.jdField_a_of_type_Jfn.setTextColor(-1);
      this.ir.setBackgroundColor(16777216);
      this.iq.setBackgroundColor(-534962398);
      this.is.setBackgroundColor(-16777216);
      this.mTitleText.setTextColor(-1);
      this.mEarbackBtn.setTextColor(-1);
    }
    for (;;)
    {
      updateEarbackBtn();
      return;
      bool = false;
      break;
      label118:
      this.jdField_a_of_type_Jfn.setTextColor(-16777216);
      this.ir.setBackgroundColor(-2147483648);
      this.iq.setBackgroundColor(-1);
      this.is.setBackgroundColor(-2170912);
      this.mTitleText.setTextColor(-8947849);
      this.mEarbackBtn.setTextColor(-16777216);
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    if (this.mContext != null)
    {
      this.mContext.unregisterReceiver(this.mReceiver);
      this.mContext = null;
    }
    this.mHandler.removeCallbacks(this.mRunnable);
    this.jdField_a_of_type_Jfn = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      if (!this.mIsClosing)
      {
        this.mIsClosing = true;
        localObject = AnimationUtils.loadAnimation(this.mContext, 2130772198);
        ((Animation)localObject).setAnimationListener(this.m);
        this.iq.startAnimation((Animation)localObject);
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.b();
      if (!this.jdField_a_of_type_ComTencentAvVideoController.b().Rm)
      {
        label99:
        ((iiv)localObject).Rm = bool;
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().YN != 0)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.enableLoopback(this.jdField_a_of_type_ComTencentAvVideoController.b().Rm);
          if (!this.jdField_a_of_type_ComTencentAvVideoController.b().Rm) {
            break label205;
          }
          this.mTitleText.setText(2131698192);
        }
      }
      for (;;)
      {
        updateEarbackBtn();
        if (this.jdField_a_of_type_ComTencentAvVideoController.b().Rm) {
          break label233;
        }
        iwu.b((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 1017);
        jfq.reportClickEvent("0X8007EF4", "");
        break;
        bool = false;
        break label99;
        label205:
        this.mTitleText.setText(2131698191);
        this.mHandler.removeCallbacks(this.mRunnable);
        this.ayB = 0;
      }
      label233:
      jfq.reportClickEvent("0X8007EF3", "");
    }
  }
  
  void setTitle()
  {
    if (this.jdField_a_of_type_Jfn.getCount() == 0)
    {
      this.mTitleText.setText(2131698194);
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().YN == 0)
    {
      this.mTitleText.setText(2131698193);
      return;
    }
    this.mTitleText.setText(2131698192);
  }
  
  public void show()
  {
    int j = 1;
    int k = 0;
    super.show();
    this.mIsClosing = false;
    this.iq.startAnimation(AnimationUtils.loadAnimation(this.mContext, 2130772199));
    int i = k;
    if (this.jdField_a_of_type_Jfn.getCount() == 0)
    {
      this.jdField_a_of_type_Jfn.a(jfp.a().a());
      i = k;
      if (this.jdField_a_of_type_Jfn.getCount() != 0) {
        i = 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().YN == 0) {
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        this.jdField_a_of_type_Jfn.notifyDataSetChanged();
      }
      setTitle();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jfo
 * JD-Core Version:    0.7.0.1
 */