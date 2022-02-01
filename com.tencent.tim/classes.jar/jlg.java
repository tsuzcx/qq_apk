import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.view.View;
import java.io.InputStream;

public class jlg
  extends BitmapDrawable
{
  private ColorStateList mColorStateList;
  
  public jlg(Resources paramResources, Bitmap paramBitmap, int paramInt)
  {
    super(paramResources, paramBitmap);
    this.mColorStateList = paramResources.getColorStateList(paramInt);
    onStateChange(getState());
  }
  
  public jlg(Resources paramResources, InputStream paramInputStream, int paramInt)
  {
    super(paramResources, paramInputStream);
    this.mColorStateList = paramResources.getColorStateList(paramInt);
    onStateChange(getState());
  }
  
  public static jlg a(Resources paramResources, int paramInt1, int paramInt2)
  {
    return new jlg(paramResources, paramResources.openRawResource(paramInt1), paramInt2);
  }
  
  public static jlg a(Resources paramResources, Bitmap paramBitmap, int paramInt)
  {
    return new jlg(paramResources, paramBitmap, paramInt);
  }
  
  @TargetApi(16)
  public static void j(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return;
    }
    jlg localjlg = a(paramView.getResources(), paramInt1, paramInt2);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.setBackground(localjlg);
      return;
    }
    paramView.setBackgroundDrawable(localjlg);
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = this.mColorStateList.getColorForState(paramArrayOfInt, 0);
    if (i != 0) {
      setColorFilter(i, PorterDuff.Mode.MULTIPLY);
    }
    for (;;)
    {
      invalidateSelf();
      return super.onStateChange(paramArrayOfInt);
      clearColorFilter();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jlg
 * JD-Core Version:    0.7.0.1
 */