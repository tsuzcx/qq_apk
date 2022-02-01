import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;

public abstract class ixr
  extends OrientationEventListener
{
  public boolean VW;
  Configuration a;
  protected Context mContext;
  Display mDisplay;
  int mLastOrientation = -25;
  boolean mbIsTablet = false;
  
  public ixr(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.mContext = paramContext;
    this.a = this.mContext.getResources().getConfiguration();
    this.mDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    this.mbIsTablet = jkg.isTablet(paramContext);
  }
  
  public abstract void E(int paramInt, boolean paramBoolean);
  
  public void onOrientationChanged(int paramInt)
  {
    if (paramInt == -1) {
      this.mLastOrientation = paramInt;
    }
    do
    {
      return;
      if (this.mLastOrientation < 0) {
        this.mLastOrientation = 0;
      }
    } while ((paramInt - this.mLastOrientation < 20) && (paramInt - this.mLastOrientation > -20) && (!this.VW));
    int i = paramInt;
    if (this.mbIsTablet)
    {
      paramInt -= 90;
      i = paramInt;
      if (paramInt < 0) {
        i = paramInt + 360;
      }
    }
    if (this.VW) {}
    for (paramInt = imh.a(this.mContext.getApplicationContext(), false, false, (byte)0, true) * 90;; paramInt = imh.b(this.mContext.getApplicationContext(), false, false, (byte)0, true) * 90)
    {
      int j = paramInt;
      if (paramInt > 360) {
        j = paramInt % 360;
      }
      i -= j;
      paramInt = i;
      if (i < 0) {
        paramInt = i + 360;
      }
      this.mLastOrientation = paramInt;
      if ((paramInt <= 314) && (paramInt >= 45)) {
        break;
      }
      E(0, this.VW);
      return;
    }
    if ((paramInt > 44) && (paramInt < 135))
    {
      E(90, this.VW);
      return;
    }
    if ((paramInt > 134) && (paramInt < 225))
    {
      E(180, this.VW);
      return;
    }
    E(270, this.VW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ixr
 * JD-Core Version:    0.7.0.1
 */