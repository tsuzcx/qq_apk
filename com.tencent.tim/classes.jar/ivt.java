import android.content.Context;
import android.content.res.Resources;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout;

public class ivt
  extends ivq
{
  protected static int auz = 3;
  
  public ivt(Context paramContext)
  {
    this.TAG = "SmallScreenShare";
    this.mLayout = 2131559971;
    this.mWidth = paramContext.getResources().getDimensionPixelSize(2131298323);
    this.mHeight = paramContext.getResources().getDimensionPixelSize(2131298322);
  }
  
  public void onDestroy()
  {
    auz = this.a.lH();
    super.onDestroy();
  }
  
  public void v(boolean paramBoolean, int paramInt)
  {
    super.v(paramBoolean, auz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ivt
 * JD-Core Version:    0.7.0.1
 */