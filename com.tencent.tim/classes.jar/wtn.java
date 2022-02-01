import android.app.Dialog;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AIOJubaoDialogHelper.3;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import mqq.os.MqqHandler;

public class wtn
  implements wuy, wvs
{
  private final BaseChatPie a;
  Dialog ab;
  public Dialog ac;
  public Dialog ad;
  private final QQAppInterface app;
  Dialog k;
  private final BaseActivity mActivity;
  private final Context mContext;
  private final SessionInfo sessionInfo;
  
  public wtn(wvm paramwvm, BaseChatPie paramBaseChatPie)
  {
    this.mContext = paramBaseChatPie.mContext;
    this.mActivity = paramBaseChatPie.a();
    this.sessionInfo = paramBaseChatPie.sessionInfo;
    this.app = paramBaseChatPie.app;
    this.a = paramBaseChatPie;
    paramwvm.a(this);
  }
  
  public int[] C()
  {
    return new int[0];
  }
  
  public void Ck(int paramInt) {}
  
  public void cbJ()
  {
    if ((this.k != null) && (this.k.isShowing())) {
      this.mActivity.dismissDialog(231);
    }
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 230: 
      this.ab = new ReportDialog(this.mContext, 2131756467);
      this.ab.setContentView(2131559151);
      localTextView1 = (TextView)this.ab.findViewById(2131365867);
      localObject = (TextView)this.ab.findViewById(2131365863);
      TextView localTextView2 = (TextView)this.ab.findViewById(2131365852);
      TextView localTextView3 = (TextView)this.ab.findViewById(2131365858);
      localTextView1.setText(2131718818);
      ((TextView)localObject).setText(2131718816);
      localTextView3.setText(2131718817);
      localTextView3.setOnClickListener(new wto(this));
      localTextView2.setText(2131721058);
      localTextView2.setOnClickListener(new wtp(this));
      return this.ab;
    case 231: 
      this.k = new ReportDialog(this.mContext, 2131756467);
      this.k.setContentView(2131558460);
      ((TextView)this.k.findViewById(2131365863)).setText(2131718822);
      return this.k;
    case 232: 
      this.ac = new ReportDialog(this.mContext, 2131756467);
      this.ac.setContentView(2131563214);
      localTextView1 = (TextView)this.ac.findViewById(2131379419);
      localObject = (ImageView)this.ac.findViewById(2131368846);
      localTextView1.setText(2131691296);
      ((ImageView)localObject).setImageResource(2130840113);
      return this.ac;
    }
    this.ad = new ReportDialog(this.mContext, 2131756467);
    this.ad.setContentView(2131563214);
    TextView localTextView1 = (TextView)this.ad.findViewById(2131379419);
    Object localObject = (ImageView)this.ad.findViewById(2131368846);
    localTextView1.setText(2131691294);
    ((ImageView)localObject).setImageResource(2130840095);
    return this.ad;
  }
  
  public void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.a.getUIHandler().postDelayed(new AIOJubaoDialogHelper.3(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wtn
 * JD-Core Version:    0.7.0.1
 */