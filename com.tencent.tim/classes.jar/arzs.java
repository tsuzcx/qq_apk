import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.MyAppDialog.1;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class arzs
  extends ReportDialog
{
  public TextView adc;
  public TextView lBtn;
  protected final WeakReference<Activity> mActivity;
  public ProgressBar progressBar;
  TextView rBtn;
  TextView text;
  TextView title;
  
  public arzs(Activity paramActivity)
  {
    super(paramActivity);
    this.mActivity = new WeakReference(paramActivity);
    requestWindowFeature(1);
    paramActivity = new ColorDrawable();
    paramActivity.setAlpha(0);
    getWindow().setBackgroundDrawable(paramActivity);
    setContentView(2131559862);
  }
  
  public arzs a(int paramInt)
  {
    this.text.setTextColor(paramInt);
    return this;
  }
  
  public arzs a(int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setText(paramInt1);
    this.lBtn.setTextColor(paramInt2);
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new arzu(this, paramOnClickListener, paramInt1, paramBoolean));
    return this;
  }
  
  public arzs a(int paramInt, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setText(paramInt);
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new arzt(this, paramOnClickListener, paramInt, paramBoolean));
    return this;
  }
  
  public arzs a(String paramString)
  {
    if (paramString != null) {
      this.title.setText(paramString);
    }
    return this;
  }
  
  public void ag(Drawable paramDrawable)
  {
    this.progressBar.setProgressDrawable(paramDrawable);
  }
  
  public arzs b(int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramInt1);
    this.rBtn.setTextColor(paramInt2);
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new arzw(this, paramOnClickListener, paramInt1, paramBoolean));
    return this;
  }
  
  public arzs b(int paramInt, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramInt);
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new arzv(this, paramOnClickListener, paramInt, paramBoolean));
    return this;
  }
  
  public arzs b(String paramString)
  {
    if (paramString != null) {
      this.text.setText(paramString);
    }
    return this;
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public Activity getActivity()
  {
    Activity localActivity2 = (Activity)this.mActivity.get();
    Activity localActivity1 = localActivity2;
    if (localActivity2 == null) {
      localActivity1 = null;
    }
    return localActivity1;
  }
  
  public void iq(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new MyAppDialog.1(this, paramInt1, paramInt2));
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.title = ((TextView)findViewById(2131365867));
    this.text = ((TextView)findViewById(2131365863));
    this.lBtn = ((TextView)findViewById(2131365852));
    this.lBtn.getPaint().setFakeBoldText(true);
    this.rBtn = ((TextView)findViewById(2131365858));
    this.progressBar = ((ProgressBar)findViewById(2131373659));
    this.adc = ((TextView)findViewById(2131373687));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arzs
 * JD-Core Version:    0.7.0.1
 */