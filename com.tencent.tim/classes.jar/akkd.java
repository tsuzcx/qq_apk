import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListAdapter;
import com.tencent.mobileqq.nearby.smooth.ItemLoader;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.e;

public final class akkd
{
  final ItemLoader<?, ?> a;
  akkc b;
  boolean csy;
  boolean csz;
  final Handler mHandler;
  int mScrollState;
  
  void a(akkc paramakkc)
  {
    this.b = paramakkc;
    if (this.b != null)
    {
      paramakkc = this.b.b();
      paramakkc.setOnScrollListener(new akkd.b(null));
      paramakkc.setOnTouchListener(new akkd.a(null));
      paramakkc.setOnItemSelectedListener(new akkd.c(null));
    }
  }
  
  void a(View paramView1, View paramView2, int paramInt)
  {
    this.b.b();
    ListAdapter localListAdapter = this.b.getAdapter();
    if ((this.mScrollState != 2) && (!this.csy)) {}
    for (boolean bool = true;; bool = false)
    {
      this.a.a(paramView1, paramView2, localListAdapter, paramInt, bool);
      return;
    }
  }
  
  void dBC()
  {
    Message localMessage = this.mHandler.obtainMessage(1, this);
    this.mHandler.removeMessages(1);
    this.csy = true;
    this.mHandler.sendMessage(localMessage);
  }
  
  void dtE()
  {
    if (this.b == null) {
      throw new IllegalStateException("Cannot cancel requests with no managed view");
    }
    this.a.hw(this.b.b());
  }
  
  class a
    implements View.OnTouchListener
  {
    private a() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      boolean bool3 = true;
      boolean bool2 = false;
      int i = paramMotionEvent.getAction();
      Object localObject = akkd.this;
      boolean bool1 = bool3;
      if (i != 1) {
        if (i != 3) {
          break label105;
        }
      }
      label105:
      for (bool1 = bool3;; bool1 = false)
      {
        ((akkd)localObject).csz = bool1;
        if ((akkd.this.csz) && (akkd.this.mScrollState != 2)) {
          akkd.this.dBC();
        }
        localObject = akkd.this.b.a();
        bool1 = bool2;
        if (localObject != null) {
          bool1 = ((View.OnTouchListener)localObject).onTouch(paramView, paramMotionEvent);
        }
        return bool1;
      }
    }
  }
  
  class b
    implements AbsListView.e
  {
    private b() {}
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      AbsListView.e locale = akkd.this.b.getOnScrollListener();
      if (locale != null) {
        locale.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
    }
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      int j = 0;
      int i;
      Object localObject;
      if ((akkd.this.mScrollState == 2) && (paramInt != 2))
      {
        i = 1;
        if (i == 0) {
          break label136;
        }
        localObject = akkd.this.mHandler.obtainMessage(1, akkd.this);
        akkd.this.mHandler.removeMessages(1);
        if (!akkd.this.csz) {
          break label129;
        }
        i = j;
        label66:
        akkd.this.mHandler.sendMessageDelayed((Message)localObject, i);
        akkd.this.csy = true;
      }
      for (;;)
      {
        akkd.this.mScrollState = paramInt;
        localObject = akkd.this.b.getOnScrollListener();
        if (localObject != null) {
          ((AbsListView.e)localObject).onScrollStateChanged(paramAbsListView, paramInt);
        }
        return;
        i = 0;
        break;
        label129:
        i = 550;
        break label66;
        label136:
        if (paramInt == 2)
        {
          akkd.this.csy = false;
          akkd.this.mHandler.removeMessages(1);
        }
      }
    }
  }
  
  class c
    implements AdapterView.e
  {
    private c() {}
    
    public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      if (akkd.this.mScrollState != 0)
      {
        akkd.this.mScrollState = 0;
        akkd.this.dBC();
      }
      AdapterView.e locale = akkd.this.b.getOnItemSelectedListener();
      if (locale != null) {
        locale.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
      }
    }
    
    public void onNothingSelected(AdapterView<?> paramAdapterView)
    {
      AdapterView.e locale = akkd.this.b.getOnItemSelectedListener();
      if (locale != null) {
        locale.onNothingSelected(paramAdapterView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akkd
 * JD-Core Version:    0.7.0.1
 */