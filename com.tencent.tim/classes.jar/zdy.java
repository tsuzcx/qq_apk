import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.List;

public class zdy
  extends ReportDialog
{
  private TextView MD;
  private TextView ME;
  private TextView MF;
  private LinearLayout hF;
  private LinearLayout hG;
  private ValueAnimator mAnimator;
  private ProgressBar mProgressBar;
  private RecyclerView mRecyclerView;
  private TextView mText;
  private TextView mTitle;
  private TextView nM;
  private ImageView vh;
  
  public zdy(Context paramContext)
  {
    super(paramContext, 2131756467);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
    setContentView(2131559149);
    this.mTitle = ((TextView)findViewById(2131365867));
    this.mText = ((TextView)findViewById(2131365863));
    this.MD = ((TextView)findViewById(2131365852));
    this.ME = ((TextView)findViewById(2131365858));
    this.MF = ((TextView)findViewById(2131365825));
    this.vh = ((ImageView)findViewById(2131367585));
    this.mRecyclerView = ((RecyclerView)findViewById(2131377971));
    this.nM = ((TextView)findViewById(2131373689));
    this.mProgressBar = ((ProgressBar)findViewById(2131366392));
    this.hF = ((LinearLayout)findViewById(2131365870));
    this.hG = ((LinearLayout)findViewById(2131365899));
  }
  
  public void Fc(int paramInt)
  {
    if (paramInt == 0)
    {
      this.hF.setVisibility(8);
      this.hG.setVisibility(0);
    }
    while (paramInt != 1) {
      return;
    }
    this.hF.setVisibility(0);
    this.hG.setVisibility(8);
  }
  
  public void Fd(int paramInt)
  {
    if (this.mProgressBar == null) {
      return;
    }
    this.mAnimator = zec.a(this.mProgressBar, paramInt);
    this.mAnimator.start();
  }
  
  public zdy a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.MD.setVisibility(8);
      return this;
    }
    this.MD.setText(paramInt);
    this.MD.setContentDescription(getContext().getString(paramInt) + getContext().getString(2131692117));
    this.MD.setVisibility(0);
    this.MD.setOnClickListener(new zdz(this, paramOnClickListener));
    return this;
  }
  
  public zdy a(String paramString)
  {
    if (paramString != null)
    {
      this.mTitle.setText(paramString);
      this.mTitle.setContentDescription(paramString);
      this.mTitle.setVisibility(0);
      return this;
    }
    this.mTitle.setVisibility(8);
    return this;
  }
  
  public zdy a(List<String> paramList, View.OnClickListener paramOnClickListener)
  {
    if ((paramList == null) || (paramOnClickListener == null)) {
      return this;
    }
    this.mRecyclerView.setVisibility(0);
    this.mRecyclerView.setAdapter(new zee(paramList));
    this.mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    paramList = new afid(paramOnClickListener);
    this.mRecyclerView.setLayoutManager(paramList);
    return this;
  }
  
  public zdy b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.MF.setVisibility(8);
      return this;
    }
    this.MF.setText(paramInt);
    this.MF.setContentDescription(getContext().getString(paramInt) + getContext().getString(2131692117));
    this.MF.setVisibility(0);
    this.MF.setOnClickListener(new zea(this, paramOnClickListener));
    return this;
  }
  
  public zdy b(String paramString)
  {
    if ((this.nM == null) || (this.mProgressBar == null)) {
      return this;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.nM.setVisibility(0);
      this.nM.setText(paramString);
      return this;
    }
    this.nM.setVisibility(4);
    return this;
  }
  
  public zdy c(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.ME.setVisibility(8);
      return this;
    }
    this.ME.setText(paramInt);
    this.ME.setContentDescription(getContext().getString(paramInt) + getContext().getString(2131692117));
    this.ME.setVisibility(0);
    this.ME.setOnClickListener(new zeb(this, paramOnClickListener));
    return this;
  }
  
  public void cJ(String paramString, int paramInt)
  {
    if ((this.mAnimator != null) && (paramInt > 0)) {
      this.mAnimator.cancel();
    }
    if ((this.nM == null) || (this.mProgressBar == null)) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(paramString))
      {
        this.nM.setVisibility(0);
        this.nM.setText(paramString);
      }
    } while ((paramInt < 0) || (paramInt > 100));
    this.mProgressBar.setVisibility(0);
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.mProgressBar.setProgress(paramInt, true);
      return;
    }
    this.mProgressBar.setProgress(paramInt);
  }
  
  public void dismiss()
  {
    try
    {
      if (this.mAnimator != null) {
        this.mAnimator.cancel();
      }
      super.dismiss();
      return;
    }
    catch (Exception localException) {}finally
    {
      txb.fixMesssageLeak(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zdy
 * JD-Core Version:    0.7.0.1
 */