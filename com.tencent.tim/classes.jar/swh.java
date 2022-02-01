import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class swh
  extends ReportDialog
{
  private TextView Bd;
  private TextView Be;
  private TextView Bf;
  private swh.a a;
  private boolean aNK;
  private TextView backBtn;
  private Context context;
  private View qK;
  private View qL;
  private TextView tips;
  
  public swh(Context paramContext)
  {
    super(paramContext, 2131756467);
    super.setContentView(2131559313);
    this.context = paramContext;
    initUI();
  }
  
  private void initUI()
  {
    this.qK = super.findViewById(2131379782);
    this.qL = super.findViewById(2131379777);
    this.backBtn = ((TextView)super.findViewById(2131365852));
    this.Be = ((TextView)super.findViewById(2131365858));
    this.Bd = ((TextView)super.findViewById(2131379780));
    ((ImageView)super.findViewById(2131379781)).setColorFilter(-7745469, PorterDuff.Mode.MULTIPLY);
    this.Bf = ((TextView)super.findViewById(2131379775));
    ((ImageView)super.findViewById(2131379776)).setColorFilter(-909794, PorterDuff.Mode.MULTIPLY);
    this.tips = ((TextView)super.findViewById(2131378902));
  }
  
  private void vi(boolean paramBoolean)
  {
    int j = 8;
    QLog.i("ShareToQZone", 2, "width:" + this.backBtn.getLayoutParams().width);
    Object localObject;
    if (paramBoolean)
    {
      this.Be.setVisibility(0);
      localObject = this.qL;
      if (!this.aNK) {
        break label126;
      }
      i = 8;
      label65:
      ((View)localObject).setVisibility(i);
      localObject = this.qK;
      if (!this.aNK) {
        break label131;
      }
      i = 0;
      label86:
      ((View)localObject).setVisibility(i);
      localObject = this.tips;
      if (!this.aNK) {
        break label137;
      }
    }
    label131:
    label137:
    for (int i = j;; i = 0)
    {
      ((TextView)localObject).setVisibility(i);
      return;
      this.Be.setVisibility(8);
      break;
      label126:
      i = 0;
      break label65;
      i = 8;
      break label86;
    }
  }
  
  public void a(swh.a parama)
  {
    this.a = parama;
  }
  
  public void c(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.backBtn.setText(paramString);
    this.backBtn.setOnClickListener(new swi(this, paramOnClickListener));
  }
  
  public void d(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      vi(false);
      return;
    }
    vi(true);
    this.Be.setText(paramString);
    this.Be.setOnClickListener(new swj(this, paramOnClickListener));
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
  
  public void onBackPressed()
  {
    QLog.i("ShareResultDialog", 2, "onBackPressed");
    super.onBackPressed();
    swh.a locala;
    if (this.a != null)
    {
      locala = this.a;
      if (this.Be.getVisibility() == 0) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      locala.onBackPressed(bool);
      return;
    }
  }
  
  public void setResult(boolean paramBoolean)
  {
    this.aNK = paramBoolean;
  }
  
  public void yT(int paramInt)
  {
    if (this.Bf != null) {
      this.Bf.setText(paramInt);
    }
  }
  
  public void yU(int paramInt)
  {
    if (this.tips != null)
    {
      if (paramInt != 0) {
        this.tips.setText(paramInt);
      }
    }
    else {
      return;
    }
    this.tips.setText("");
  }
  
  public void yV(int paramInt)
  {
    if (this.Bd != null) {
      this.Bd.setText(paramInt);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onBackPressed(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     swh
 * JD-Core Version:    0.7.0.1
 */