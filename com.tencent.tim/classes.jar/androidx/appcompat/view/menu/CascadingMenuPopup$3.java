package androidx.appcompat.view.menu;

import android.os.Handler;
import android.os.SystemClock;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.MenuItemHoverListener;
import java.util.List;

class CascadingMenuPopup$3
  implements MenuItemHoverListener
{
  CascadingMenuPopup$3(CascadingMenuPopup paramCascadingMenuPopup) {}
  
  public void onItemHoverEnter(@NonNull MenuBuilder paramMenuBuilder, @NonNull MenuItem paramMenuItem)
  {
    this.this$0.mSubMenuHoverHandler.removeCallbacksAndMessages(null);
    int i = 0;
    int j = this.this$0.mShowingMenus.size();
    if (i < j) {
      if (paramMenuBuilder != ((CascadingMenuPopup.CascadingMenuInfo)this.this$0.mShowingMenus.get(i)).menu) {}
    }
    for (;;)
    {
      if (i == -1)
      {
        return;
        i += 1;
        break;
      }
      i += 1;
      if (i < this.this$0.mShowingMenus.size()) {}
      for (CascadingMenuPopup.CascadingMenuInfo localCascadingMenuInfo = (CascadingMenuPopup.CascadingMenuInfo)this.this$0.mShowingMenus.get(i);; localCascadingMenuInfo = null)
      {
        paramMenuItem = new CascadingMenuPopup.3.1(this, localCascadingMenuInfo, paramMenuItem, paramMenuBuilder);
        long l = SystemClock.uptimeMillis();
        this.this$0.mSubMenuHoverHandler.postAtTime(paramMenuItem, paramMenuBuilder, l + 200L);
        return;
      }
      i = -1;
    }
  }
  
  public void onItemHoverExit(@NonNull MenuBuilder paramMenuBuilder, @NonNull MenuItem paramMenuItem)
  {
    this.this$0.mSubMenuHoverHandler.removeCallbacksAndMessages(paramMenuBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.view.menu.CascadingMenuPopup.3
 * JD-Core Version:    0.7.0.1
 */