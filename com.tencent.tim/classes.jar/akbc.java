import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.AnimationPoint;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class akbc
  extends ReportDialog
{
  protected AnimationPoint a;
  protected TextView zc;
  
  public akbc(Context paramContext)
  {
    super(paramContext, 2131755017);
    paramContext = LayoutInflater.from(paramContext).inflate(2131561909, null);
    paramContext.setOnTouchListener(new akbd(this));
    super.setContentView(paramContext);
    this.a = ((AnimationPoint)super.findViewById(2131362723));
    this.zc = ((TextView)super.findViewById(2131368276));
    this.a.setDuration(-1L);
    this.a.setOnAnimationListener(new akbe(this));
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
  
  public void show()
  {
    this.a.startAnimation();
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akbc
 * JD-Core Version:    0.7.0.1
 */