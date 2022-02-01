import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;

public class awie
  extends PopupWindow
{
  private WeakReference<Context> mContext;
  
  public awie(Context paramContext)
  {
    super(paramContext);
    this.mContext = new WeakReference(paramContext);
  }
  
  public void showAsDropDown(View paramView)
  {
    if (this.mContext.get() == null) {
      return;
    }
    super.showAsDropDown(paramView);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    if (this.mContext.get() == null) {
      return;
    }
    super.showAsDropDown(paramView, paramInt1, paramInt2);
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mContext.get() == null) {
      return;
    }
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awie
 * JD-Core Version:    0.7.0.1
 */