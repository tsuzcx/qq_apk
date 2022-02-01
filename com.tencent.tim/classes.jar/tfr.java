import android.content.Context;
import com.tencent.ad.tangram.dialog.AdProgressDialogAdapter;

public class tfr
  implements AdProgressDialogAdapter
{
  private arhz c;
  
  public void dismiss()
  {
    if ((this.c != null) && (this.c.isShowing()))
    {
      this.c.dismiss();
      this.c = null;
    }
  }
  
  public void show(Context paramContext, int paramInt)
  {
    if ((this.c == null) && (paramContext != null) && (paramContext.getResources() != null)) {
      this.c = new arhz(paramContext, paramInt);
    }
    if (this.c != null) {
      this.c.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tfr
 * JD-Core Version:    0.7.0.1
 */