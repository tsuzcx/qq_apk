import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.PorterDuff.Mode;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class swe
  extends ReportDialog
{
  private TextView Bc;
  private TextView Bd;
  private TextView backBtn;
  private ImageView oR;
  
  public swe(Context paramContext)
  {
    super(paramContext, 2131756467);
    super.setContentView(2131560614);
    super.getWindow().setWindowAnimations(2131755320);
    Ad();
  }
  
  public void Ad()
  {
    this.backBtn = ((TextView)super.findViewById(2131365852));
    this.Bc = ((TextView)super.findViewById(2131365858));
    this.Bd = ((TextView)super.findViewById(2131379780));
    this.oR = ((ImageView)super.findViewById(2131379781));
    this.oR.setColorFilter(-7745469, PorterDuff.Mode.MULTIPLY);
  }
  
  public void a(DialogInterface.OnClickListener paramOnClickListener)
  {
    if (ujs.aTl) {
      getContext().getResources();
    }
    this.Bc.setOnClickListener(new swg(this, paramOnClickListener));
  }
  
  public void c(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.backBtn.setText(paramString);
    if (ujs.aTl) {
      getContext().getResources();
    }
    this.backBtn.setOnClickListener(new swf(this, paramOnClickListener));
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
  
  public void tV(String paramString)
  {
    if (this.Bd != null) {
      this.Bd.setText(paramString);
    }
  }
  
  public void vh(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.oR.setVisibility(0);
      return;
    }
    this.oR.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     swe
 * JD-Core Version:    0.7.0.1
 */