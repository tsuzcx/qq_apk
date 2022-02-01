import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;
import android.webkit.WebView;
import android.widget.ScrollView;
import com.tencent.mobileqq.activity.contacts.alphabet.AlphabetPinnedHeaderListView;
import com.tencent.mobileqq.activity.contacts.friend.ContactsFPSPinnedHeaderExpandableListView;
import com.tencent.mobileqq.activity.contacts.troop.TroopFragment.ContactsPinnedHeaderExpandableListView;

public class yzo
{
  private yzo.a a;
  private int cbU = Build.VERSION.SDK_INT;
  
  private boolean a(android.widget.AdapterView paramAdapterView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAdapterView != null)
    {
      bool1 = bool2;
      if (paramAdapterView.getFirstVisiblePosition() == 0)
      {
        paramAdapterView = paramAdapterView.getChildAt(0);
        if (paramAdapterView != null)
        {
          bool1 = bool2;
          if (paramAdapterView.getTop() != 0) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean a(ScrollView paramScrollView)
  {
    return (paramScrollView == null) || (paramScrollView.getScrollY() <= 0);
  }
  
  private boolean a(com.tencent.widget.AdapterView paramAdapterView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAdapterView != null)
    {
      bool1 = bool2;
      if (paramAdapterView.getFirstVisiblePosition() == 0)
      {
        paramAdapterView = paramAdapterView.getChildAt(0);
        if (paramAdapterView != null)
        {
          bool1 = bool2;
          if (paramAdapterView.getTop() != 0) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private View e()
  {
    if (this.a == null) {
      return null;
    }
    return this.a.e();
  }
  
  public boolean isTop()
  {
    View localView = e();
    if (localView == null) {
      return true;
    }
    if ((localView instanceof com.tencent.widget.AdapterView)) {
      return a((com.tencent.widget.AdapterView)localView);
    }
    if ((localView instanceof android.widget.AdapterView)) {
      return a((android.widget.AdapterView)localView);
    }
    if ((localView instanceof ScrollView)) {
      return a((ScrollView)localView);
    }
    return true;
  }
  
  public void setChildViewCanAction(boolean paramBoolean)
  {
    View localView = e();
    if (localView != null)
    {
      if (!(localView instanceof ContactsFPSPinnedHeaderExpandableListView)) {
        break label25;
      }
      ((ContactsFPSPinnedHeaderExpandableListView)localView).setChildViewCanAction(paramBoolean);
    }
    label25:
    do
    {
      return;
      if ((localView instanceof TroopFragment.ContactsPinnedHeaderExpandableListView))
      {
        ((TroopFragment.ContactsPinnedHeaderExpandableListView)localView).setChildViewCanAction(paramBoolean);
        return;
      }
    } while (!(localView instanceof AlphabetPinnedHeaderListView));
    ((AlphabetPinnedHeaderListView)localView).setChildViewCanAction(paramBoolean);
  }
  
  public void setCurrentScrollableContainer(yzo.a parama)
  {
    this.a = parama;
  }
  
  @SuppressLint({"NewApi"})
  public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3)
  {
    View localView = e();
    if ((localView instanceof android.widget.AbsListView)) {
      ((android.widget.AbsListView)localView).smoothScrollBy(paramInt2, paramInt3);
    }
    do
    {
      return;
      if ((localView instanceof com.tencent.widget.AbsListView))
      {
        ((com.tencent.widget.AbsListView)localView).smoothScrollBy(paramInt2, paramInt3);
        return;
      }
      if ((localView instanceof ScrollView))
      {
        ((ScrollView)localView).fling(paramInt1);
        return;
      }
    } while (!(localView instanceof WebView));
    ((WebView)localView).flingScroll(0, paramInt1);
  }
  
  public static abstract interface a
  {
    public abstract View e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yzo
 * JD-Core Version:    0.7.0.1
 */