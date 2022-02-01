import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.AnimationPoint;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class rrq
  extends ReportDialog
{
  protected AnimationPoint a;
  protected TextView zc;
  
  public rrq(Context paramContext)
  {
    super(paramContext, 2131755016);
    View localView = LayoutInflater.from(paramContext).inflate(2131561909, null);
    localView.setOnTouchListener(new rrr(this));
    super.setContentView(localView);
    this.a = ((AnimationPoint)super.findViewById(2131362723));
    this.zc = ((TextView)super.findViewById(2131368276));
    this.a.setRadius(rpq.dip2px(paramContext, 25.0F));
    this.a.setLoopTime(2000L);
    this.a.setDuration(4000L);
    this.a.setOnAnimationListener(new rrs(this, paramContext));
  }
  
  public void dismiss()
  {
    this.a.stopAnimation();
    super.dismiss();
  }
  
  public void sI(String paramString)
  {
    this.zc.setText(paramString);
  }
  
  public void setIsVertical(boolean paramBoolean)
  {
    this.a.setIsVertical(paramBoolean);
  }
  
  public void show()
  {
    this.a.startAnimation();
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rrq
 * JD-Core Version:    0.7.0.1
 */