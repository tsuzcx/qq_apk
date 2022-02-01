import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View.OnTouchListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.AdapterView.e;
import com.tencent.widget.ListView;

public class akkc
{
  akkd a;
  boolean csx;
  ListAdapter d;
  final AbsListView e;
  View.OnTouchListener f;
  AdapterView.e mOnItemSelectedListener;
  AbsListView.e mOnScrollListener;
  
  public akkc(AbsListView paramAbsListView)
  {
    this.e = paramAbsListView;
    this.d = null;
    this.a = null;
    this.csx = false;
    this.mOnScrollListener = null;
    this.f = null;
    this.mOnItemSelectedListener = null;
  }
  
  View.OnTouchListener a()
  {
    return this.f;
  }
  
  ListAdapter a(akkd paramakkd, ListAdapter paramListAdapter)
  {
    this.d = paramListAdapter;
    Object localObject = paramListAdapter;
    if (paramakkd != null)
    {
      localObject = paramListAdapter;
      if (paramListAdapter != null) {
        localObject = new akkb(paramakkd, (BaseAdapter)paramListAdapter);
      }
    }
    return localObject;
  }
  
  public ListAdapter a(ListAdapter paramListAdapter)
  {
    return a(this.a, paramListAdapter);
  }
  
  public boolean arR()
  {
    return this.a != null;
  }
  
  AbsListView b()
  {
    return this.e;
  }
  
  @TargetApi(11)
  void b(ListAdapter paramListAdapter)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      this.e.setAdapter(paramListAdapter);
    }
    while (!(this.e instanceof ListView)) {
      return;
    }
    ((ListView)this.e).setAdapter(paramListAdapter);
  }
  
  public void dBB()
  {
    if ((arR()) && (this.d != null)) {
      this.a.dBC();
    }
  }
  
  public void dtE()
  {
    if (this.a != null) {
      this.a.dtE();
    }
  }
  
  ListAdapter getAdapter()
  {
    ListAdapter localListAdapter2 = (ListAdapter)this.e.getAdapter();
    ListAdapter localListAdapter1 = localListAdapter2;
    if ((localListAdapter2 instanceof WrapperListAdapter)) {
      localListAdapter1 = ((WrapperListAdapter)localListAdapter2).getWrappedAdapter();
    }
    return localListAdapter1;
  }
  
  AdapterView.e getOnItemSelectedListener()
  {
    return this.mOnItemSelectedListener;
  }
  
  AbsListView.e getOnScrollListener()
  {
    return this.mOnScrollListener;
  }
  
  public void setItemManager(akkd paramakkd)
  {
    if (this.a != null)
    {
      this.a.a(null);
      this.a = null;
    }
    this.csx = true;
    if (paramakkd != null)
    {
      paramakkd.a(this);
      b(a(paramakkd, this.d));
    }
    for (;;)
    {
      this.a = paramakkd;
      this.csx = false;
      dBB();
      return;
      this.e.setOnScrollListener(this.mOnScrollListener);
      this.e.setOnTouchListener(this.f);
      this.e.setOnItemSelectedListener(this.mOnItemSelectedListener);
      b(this.d);
    }
  }
  
  public void setOnItemSelectedListener(AdapterView.e parame)
  {
    if (this.csx) {
      return;
    }
    this.mOnItemSelectedListener = parame;
  }
  
  public void setOnScrollListener(AbsListView.e parame)
  {
    if (this.csx) {
      return;
    }
    this.mOnScrollListener = parame;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    if (this.csx) {
      return;
    }
    this.f = paramOnTouchListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akkc
 * JD-Core Version:    0.7.0.1
 */