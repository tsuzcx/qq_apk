import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;

public class arcr
{
  ImageView Au;
  ImageView Fu;
  String GY = null;
  View Jw;
  View Jx;
  TextView abO;
  TextView abP;
  TextView abQ;
  boolean cYU = false;
  FrameLayout ch;
  FrameLayout ci;
  int eez = 255;
  Activity mOutActivity;
  CustomWebView mWebView = null;
  RelativeLayout titleContainer;
  
  public arcr(Activity paramActivity, CustomWebView paramCustomWebView, ViewGroup paramViewGroup)
  {
    this.mOutActivity = paramActivity;
    this.mWebView = paramCustomWebView;
    T(paramViewGroup);
    init();
  }
  
  public void M(View.OnClickListener paramOnClickListener)
  {
    this.abP.setOnClickListener(paramOnClickListener);
  }
  
  void T(ViewGroup paramViewGroup)
  {
    this.Jw = LayoutInflater.from(this.mOutActivity).inflate(2131563341, paramViewGroup, true);
  }
  
  public void bh(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0)
    {
      this.Jw.getBackground().mutate().setAlpha(paramInt2);
      return;
    }
    aqnc localaqnc = new aqnc(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), new arcs(this, paramInt2));
    localaqnc.setDuration(paramInt3);
    this.cYU = true;
    this.Jw.startAnimation(localaqnc);
  }
  
  void init()
  {
    this.ch = ((FrameLayout)this.Jw.findViewById(2131365344));
    this.titleContainer = ((RelativeLayout)this.Jw.findViewById(2131365354));
    this.ci = ((FrameLayout)this.Jw.findViewById(2131365352));
    this.abO = ((TextView)this.Jw.findViewById(2131369627));
    this.abO.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
    this.abO.setMaxEms(9);
    this.Fu = ((ImageView)this.Jw.findViewById(2131369624));
    this.abP = ((TextView)this.Jw.findViewById(2131369579));
    this.abQ = ((TextView)this.Jw.findViewById(2131369612));
    this.Au = ((ImageView)this.Jw.findViewById(2131369594));
    this.Jx = this.Jw.findViewById(2131363675);
  }
  
  public void kt(int paramInt1, int paramInt2)
  {
    if (this.cYU) {
      this.cYU = false;
    }
    if (paramInt2 == 0)
    {
      this.Jw.getBackground().mutate().setAlpha(paramInt1);
      this.eez = paramInt1;
    }
    while (this.eez == paramInt1) {
      return;
    }
    bh(this.eez, paramInt1, paramInt2);
  }
  
  public void setLeftText(CharSequence paramCharSequence)
  {
    if (this.abP != null)
    {
      this.abP.setText(paramCharSequence);
      this.abP.setVisibility(0);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.abO.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arcr
 * JD-Core Version:    0.7.0.1
 */