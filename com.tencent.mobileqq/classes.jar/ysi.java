import android.content.Context;
import com.tencent.ad.tangram.dialog.AdProgressDialogAdapter;

public class ysi
  implements AdProgressDialogAdapter
{
  private bcpq a;
  
  public void dismiss()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
  }
  
  public void show(Context paramContext, int paramInt)
  {
    if ((this.a == null) && (paramContext != null) && (paramContext.getResources() != null)) {
      this.a = new bcpq(paramContext, paramInt);
    }
    if (this.a != null) {
      this.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ysi
 * JD-Core Version:    0.7.0.1
 */