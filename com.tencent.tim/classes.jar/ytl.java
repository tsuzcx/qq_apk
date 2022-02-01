import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.SwipListView;

public class ytl
  implements AbsListView.e
{
  public ytl(SystemMsgListView paramSystemMsgListView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    SystemMsgListView.a(this.this$0, paramInt1);
    SystemMsgListView.a(this.this$0, paramInt1 + paramInt2 - 1);
    if (SystemMsgListView.a(this.this$0).xt() == 23)
    {
      if (paramInt1 >= 1)
      {
        paramAbsListView = (ysa)SystemMsgListView.a(this.this$0).getItem(paramInt1 - 1);
        if ((paramAbsListView instanceof yry)) {
          ((yry)paramAbsListView).cli();
        }
      }
      if (paramInt1 + paramInt2 < paramInt3)
      {
        paramAbsListView = (ysa)SystemMsgListView.a(this.this$0).getItem(paramInt1 + paramInt2);
        if ((paramAbsListView instanceof yry)) {
          ((yry)paramAbsListView).cli();
        }
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    int i = 0;
    int j;
    int k;
    if (SystemMsgListView.a(this.this$0) != null)
    {
      if ((paramInt == 0) || (paramInt == 1)) {
        break label240;
      }
      SystemMsgListView.a(this.this$0).ckT();
      if (paramInt == 0)
      {
        SystemMsgListView.a(this.this$0).ckZ();
        j = SystemMsgListView.a(this.this$0).xt();
        if (SystemMsgListView.a(this.this$0) >= SystemMsgListView.a(this.this$0).getCount() - 2)
        {
          paramAbsListView = SystemMsgListView.a(this.this$0).a();
          if ((paramAbsListView != null) && (paramAbsListView.Ui()) && (paramAbsListView.aCj >= 0) && (SystemMsgListView.a(this.this$0).gL(j)))
          {
            Bundle localBundle = new Bundle();
            localBundle.putString("from", "4");
            SystemMsgListView.a(this.this$0).b(4, paramAbsListView.aCj, localBundle);
          }
        }
        k = SystemMsgListView.a(this.this$0).getFirstVisiblePosition();
        paramAbsListView = SystemMsgListView.a(this.this$0).getChildAt(0);
        if (paramAbsListView != null) {
          break label263;
        }
      }
    }
    label263:
    for (paramInt = i;; paramInt = paramAbsListView.getTop())
    {
      SystemMsgListView.a(this.this$0).remove(j);
      if (SystemMsgListView.a(this.this$0).isShown())
      {
        paramAbsListView = new yrp(j, k, paramInt);
        SystemMsgListView.a(this.this$0).put(j, paramAbsListView);
      }
      return;
      label240:
      SystemMsgListView.a(this.this$0).ckU();
      SystemMsgListView.a(this.this$0).ckV();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ytl
 * JD-Core Version:    0.7.0.1
 */