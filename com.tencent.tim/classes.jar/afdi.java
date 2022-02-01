import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class afdi
  extends ReportDialog
  implements View.OnClickListener
{
  private afdi.a a;
  
  public afdi(@NonNull Context paramContext)
  {
    super(paramContext, 2131756705);
    super.setContentView(2131558796);
    super.setCanceledOnTouchOutside(false);
    super.setCancelable(false);
    super.findViewById(2131364084).setOnClickListener(this);
  }
  
  public void a(afdi.a parama)
  {
    this.a = parama;
  }
  
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.a(this);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public static abstract interface a
  {
    public abstract void a(afdi paramafdi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afdi
 * JD-Core Version:    0.7.0.1
 */