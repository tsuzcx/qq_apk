import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class rrl
  extends ReportDialog
{
  private String azi;
  private String azj;
  private View.OnClickListener cI;
  private View.OnClickListener cJ;
  private String content;
  private Button cq;
  private Button cs;
  private Drawable mDrawable;
  private ImageView ne;
  private ImageView ny;
  private TextView yb;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131561801);
    this.ny = ((ImageView)findViewById(2131375120));
    this.yb = ((TextView)findViewById(2131375164));
    this.ne = ((ImageView)findViewById(2131375163));
    this.cs = ((Button)findViewById(2131375168));
    this.cq = ((Button)findViewById(2131375169));
    ((RelativeLayout)findViewById(2131375119)).setOnClickListener(new rrm(this));
    if (this.mDrawable != null)
    {
      this.ny.setVisibility(0);
      this.ny.setImageDrawable(this.mDrawable);
      if (!TextUtils.isEmpty(this.content)) {
        break label207;
      }
      this.yb.setVisibility(8);
      if (!TextUtils.isEmpty(this.azj)) {
        break label277;
      }
      this.cq.setVisibility(8);
      label160:
      if (!TextUtils.isEmpty(this.azi)) {
        break label335;
      }
      this.cs.setVisibility(8);
    }
    for (;;)
    {
      this.ne.setOnClickListener(new rrp(this));
      return;
      this.ny.setVisibility(8);
      break;
      label207:
      this.yb.setVisibility(0);
      if (this.yb.getPaint().measureText(this.content) > rpq.dip2px(getContext(), 280.0F)) {
        this.yb.setGravity(3);
      }
      for (;;)
      {
        this.yb.setText(this.content);
        break;
        this.yb.setGravity(17);
      }
      label277:
      this.cq.setVisibility(0);
      this.cq.setText(this.azj);
      if (this.cI != null)
      {
        this.cq.setOnClickListener(this.cI);
        break label160;
      }
      this.cq.setOnClickListener(new rrn(this));
      break label160;
      label335:
      this.cs.setVisibility(0);
      this.cs.setTag(this.azi);
      if (this.cJ != null) {
        this.cs.setOnClickListener(this.cJ);
      } else {
        this.cs.setOnClickListener(new rro(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rrl
 * JD-Core Version:    0.7.0.1
 */