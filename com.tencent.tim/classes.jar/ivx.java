import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.av.smallscreen.BaseSmallScreenService;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout;
import com.tencent.av.smallscreen.SmallScreenService;

public class ivx
  extends ivq
{
  public ivx(Context paramContext)
  {
    this.TAG = "SmallScreenVideo";
    this.mLayout = 2131559969;
    this.mWidth = paramContext.getResources().getDimensionPixelSize(2131298332);
    this.mHeight = paramContext.getResources().getDimensionPixelSize(2131298324);
  }
  
  private void lO(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_Ivu.mWindowManager;
    WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_Ivu.b();
    if (((WindowManager)localObject).getDefaultDisplay().getRotation() % 2 == 0) {
      localLayoutParams.width = this.mWidth;
    }
    for (localLayoutParams.height = this.mHeight;; localLayoutParams.height = this.mWidth)
    {
      localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a(paramInt);
      localLayoutParams.x = ((Point)localObject).x;
      localLayoutParams.y = ((Point)localObject).y;
      return;
      localLayoutParams.width = this.mHeight;
    }
  }
  
  public void a(BaseSmallScreenService paramBaseSmallScreenService)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramBaseSmallScreenService instanceof SmallScreenService))
    {
      paramBaseSmallScreenService = ((SmallScreenService)paramBaseSmallScreenService).a;
      bool1 = bool2;
      if (paramBaseSmallScreenService != null)
      {
        bool1 = bool2;
        if (paramBaseSmallScreenService.a != null) {
          bool1 = paramBaseSmallScreenService.a.vX();
        }
      }
    }
    if (bool1)
    {
      int i = jdm.cC(this.mWidth);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.mWidth, i);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.updateLayout();
      return;
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.mWidth, this.mHeight);
    }
  }
  
  public void v(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (!this.jdField_a_of_type_Ivu.vH())) {
      lO(paramInt);
    }
    super.v(paramBoolean, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ivx
 * JD-Core Version:    0.7.0.1
 */