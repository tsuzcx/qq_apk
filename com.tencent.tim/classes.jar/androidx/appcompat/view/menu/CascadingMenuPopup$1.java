package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import androidx.appcompat.widget.MenuPopupWindow;
import java.util.Iterator;
import java.util.List;

class CascadingMenuPopup$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  CascadingMenuPopup$1(CascadingMenuPopup paramCascadingMenuPopup) {}
  
  public void onGlobalLayout()
  {
    Object localObject;
    if ((this.this$0.isShowing()) && (this.this$0.mShowingMenus.size() > 0) && (!((CascadingMenuPopup.CascadingMenuInfo)this.this$0.mShowingMenus.get(0)).window.isModal()))
    {
      localObject = this.this$0.mShownAnchorView;
      if ((localObject != null) && (((View)localObject).isShown())) {
        break label77;
      }
      this.this$0.dismiss();
    }
    for (;;)
    {
      return;
      label77:
      localObject = this.this$0.mShowingMenus.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((CascadingMenuPopup.CascadingMenuInfo)((Iterator)localObject).next()).window.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.view.menu.CascadingMenuPopup.1
 * JD-Core Version:    0.7.0.1
 */