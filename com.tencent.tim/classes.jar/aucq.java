import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.fileviewer.viewer.MusicFileViewer.1;

public class aucq
  extends aucp
{
  private TextView SG;
  private TextView SH;
  private TextView SI;
  private TextView SJ;
  private TextView dw;
  private ImageView jn;
  private SeekBar mSeekBar;
  
  public aucq(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void E(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null) {
      this.jn.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void JL(boolean paramBoolean)
  {
    this.mSeekBar.setEnabled(paramBoolean);
  }
  
  public void JM(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jn.setImageResource(2130845191);
      this.jn.setContentDescription(this.mContext.getString(2131692140));
      return;
    }
    this.jn.setImageResource(2130845192);
    this.jn.setContentDescription(this.mContext.getString(2131692142));
  }
  
  public void Jp(String paramString)
  {
    this.SH.setText(paramString);
  }
  
  public void Jq(String paramString)
  {
    this.SG.setText(paramString);
  }
  
  public void Jr(String paramString)
  {
    if (this.SI.getMeasuredWidth() <= 0)
    {
      this.SI.post(new MusicFileViewer.1(this, paramString));
      return;
    }
    this.SI.setText(audx.a(paramString, false, this.SI.getMeasuredWidth(), this.SI.getPaint(), 2));
  }
  
  public void Js(String paramString)
  {
    this.SJ.setText(paramString);
  }
  
  public void OL(int paramInt)
  {
    this.mSeekBar.setProgress(paramInt);
  }
  
  public void OM(int paramInt)
  {
    if (paramInt > 0) {
      this.mSeekBar.setMax(paramInt);
    }
  }
  
  public void a(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    if (paramOnSeekBarChangeListener != null) {
      this.mSeekBar.setOnSeekBarChangeListener(paramOnSeekBarChangeListener);
    }
  }
  
  public void dkq()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: MusicFileViewer initFileView");
    if (this.CS == null)
    {
      this.CS = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2131561063, this.mRootView, false);
      this.jn = ((ImageView)this.CS.findViewById(2131372130));
      this.dw = ((TextView)this.CS.findViewById(2131372657));
      this.SI = ((TextView)this.CS.findViewById(2131367034));
      this.mSeekBar = ((SeekBar)this.CS.findViewById(2131373413));
      this.SH = ((TextView)this.CS.findViewById(2131362688));
      this.SG = ((TextView)this.CS.findViewById(2131373534));
      this.SJ = ((TextView)this.CS.findViewById(2131367029));
    }
  }
  
  public void dks()
  {
    if (acej.aV() > 17.0F)
    {
      float f = this.mContext.getResources().getDisplayMetrics().density;
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams((int)(150.0F * f), (int)(f * 150.0F));
      this.jn.setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aucq
 * JD-Core Version:    0.7.0.1
 */