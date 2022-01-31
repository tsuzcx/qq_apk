import android.view.View;
import com.tencent.ark.ArkViewImplement.InputCallback;
import com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormComponentView;
import java.lang.ref.WeakReference;

public class yzt
  implements ArkViewImplement.InputCallback
{
  public yzt(GdtCanvasFormComponentView paramGdtCanvasFormComponentView) {}
  
  public void onFocusChanged(View paramView, boolean paramBoolean)
  {
    GdtCanvasFormComponentView.a(this.a, paramBoolean);
    if ((paramBoolean) || (GdtCanvasFormComponentView.a(this.a) == null) || (GdtCanvasFormComponentView.b(this.a).get() == null)) {
      return;
    }
    ((zad)GdtCanvasFormComponentView.c(this.a).get()).setPageViewTopMargin(0);
  }
  
  public void onHideMenu(View paramView) {}
  
  public void onSelectChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onShowMenu(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yzt
 * JD-Core Version:    0.7.0.1
 */