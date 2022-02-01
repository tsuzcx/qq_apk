import android.view.View;
import com.tencent.ad.tangram.ark.AdArkAdapter.Callback;
import com.tencent.ark.ArkViewImplement.InputCallback;

class tfc
  implements ArkViewImplement.InputCallback
{
  tfc(tez paramtez, AdArkAdapter.Callback paramCallback) {}
  
  public void onFocusChanged(View paramView, boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.onFocusChanged(paramView, paramBoolean);
    }
  }
  
  public void onHideMenu(View paramView) {}
  
  public void onSelectChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onShowMenu(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tfc
 * JD-Core Version:    0.7.0.1
 */