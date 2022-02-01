import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ryl
  extends rxk
  implements View.OnClickListener
{
  private FrameLayout aJ;
  private ryi c;
  private ImageView iQ;
  private TextView oq;
  
  public ryl(ryi paramryi)
  {
    this.c = paramryi;
  }
  
  protected void dC(View paramView)
  {
    TextView localTextView;
    if (paramView != null)
    {
      this.aJ = ((FrameLayout)paramView.findViewById(2131367202));
      this.iQ = ((ImageView)paramView.findViewById(2131369671));
      this.oq = ((TextView)paramView.findViewById(2131380976));
      this.iQ.setOnClickListener(this);
      this.oq.setOnClickListener(this);
      if (this.c != null)
      {
        localTextView = this.oq;
        if (TextUtils.isEmpty(this.c.getTitle())) {
          break label109;
        }
      }
    }
    label109:
    for (paramView = this.c.getTitle();; paramView = "")
    {
      localTextView.setText(paramView);
      this.c.initTitleBar(this.aJ);
      return;
    }
  }
  
  public String getLogTag()
  {
    return "PublicTitleBarPart";
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((!b().onBackEvent()) && (getActivity() != null)) {
        getActivity().finish();
      }
      if ((sox.fY("PublicTitleBarPart")) && (this.c != null)) {
        this.c.onDoubleClickTitle();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ryl
 * JD-Core Version:    0.7.0.1
 */