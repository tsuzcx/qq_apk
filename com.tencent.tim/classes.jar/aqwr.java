import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.vip.lianghao.view.LiangHaoDialogView;

public class aqwr
  implements aqha.b
{
  private Dialog dialog;
  
  public Dialog a(Context paramContext, aqwl paramaqwl, View.OnClickListener paramOnClickListener)
  {
    this.dialog = aqha.a(paramContext, 2131695264, this, paramaqwl, 2131721058, 2131695262, new aqws(this), paramOnClickListener, false, false);
    return this.dialog;
  }
  
  public View a(Context paramContext, Object paramObject)
  {
    paramContext = new LiangHaoDialogView(paramContext);
    paramContext.c((aqwl)paramObject);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqwr
 * JD-Core Version:    0.7.0.1
 */