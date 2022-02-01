import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class ztx
  extends ReportDialog
{
  public ztx(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  @TargetApi(19)
  public void I_()
  {
    int i = 0;
    if (Build.VERSION.SDK_INT >= 19)
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label84;
      }
      if ((getWindow() != null) && (getWindow().getDecorView() != null))
      {
        getWindow().clearFlags(67108864);
        getWindow().getDecorView().setSystemUiVisibility(1280);
        getWindow().addFlags(-2147483648);
        getWindow().setStatusBarColor(0);
        break label83;
        break label83;
        break label83;
      }
    }
    label74:
    Object localObject = getWindow();
    if (localObject == null) {}
    label188:
    for (;;)
    {
      label83:
      return;
      label84:
      if (getWindow() == null) {
        break label74;
      }
      getWindow().addFlags(67108864);
      break label74;
      localObject = ((Window)localObject).getDecorView();
      if (!(localObject instanceof ViewGroup)) {
        break;
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if (!(localObject instanceof ViewGroup)) {
        break;
      }
      int j = ((ViewGroup)localObject).getChildCount();
      for (;;)
      {
        if (i >= j) {
          break label188;
        }
        View localView = ((ViewGroup)localObject).getChildAt(i);
        if ((localView == null) || (localView.getId() == 16908290)) {
          break;
        }
        if (!(localView instanceof ViewStub)) {
          localView.setAlpha(0.0F);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ztx
 * JD-Core Version:    0.7.0.1
 */