import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aypu
  extends BaseAdapter
  implements aypv.a, AdapterView.c
{
  private int bsM;
  private List<aypv> oZ = new ArrayList();
  
  public aypu(@NonNull List<aypv> paramList)
  {
    if (paramList.isEmpty()) {
      ram.w("Q.qqstory.publish.editPermissionListAdapter", "part list is empty.");
    }
    this.oZ.addAll(paramList);
    bvj();
    paramList = this.oZ.iterator();
    while (paramList.hasNext()) {
      ((aypv)paramList.next()).a(this);
    }
  }
  
  @NonNull
  private aypu.a a(int paramInt)
  {
    Iterator localIterator = this.oZ.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      aypv localaypv = (aypv)localIterator.next();
      j = localaypv.tz() + i;
      if (paramInt <= j - 1) {
        return new aypu.a(localaypv, paramInt - i);
      }
    }
    throw new IllegalStateException("unable find PermissionPart, position:" + paramInt);
  }
  
  private void bvj()
  {
    Iterator localIterator = this.oZ.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((aypv)localIterator.next()).tz() + i) {}
    this.bsM = i;
  }
  
  @Nullable
  public aypv a()
  {
    Iterator localIterator = this.oZ.iterator();
    while (localIterator.hasNext())
    {
      aypv localaypv = (aypv)localIterator.next();
      if (localaypv.aHE) {
        return localaypv;
      }
    }
    return null;
  }
  
  public void a(aypv paramaypv)
  {
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.bsM;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    aypu.a locala = a(paramInt);
    return locala.a.J(locala.bsN);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    aypu.a locala = a(paramInt);
    aypv localaypv = locala.a;
    int i = locala.bsN;
    if (paramView == null) {
      paramView = localaypv.d(i, paramViewGroup);
    }
    for (;;)
    {
      localaypv.m(i, paramView);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public void notifyDataSetChanged()
  {
    bvj();
    super.notifyDataSetChanged();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = a(paramInt);
    paramAdapterView = paramView.a;
    if (!paramAdapterView.enable) {}
    do
    {
      return;
      paramAdapterView.onClick(paramView.bsN);
    } while ((paramAdapterView instanceof aypt));
    paramAdapterView.setSelect(true);
    paramView = this.oZ.iterator();
    while (paramView.hasNext())
    {
      aypv localaypv = (aypv)paramView.next();
      if (localaypv != paramAdapterView)
      {
        localaypv.setSelect(false);
        localaypv.setOpen(false);
      }
    }
    notifyDataSetChanged();
  }
  
  static class a
  {
    final aypv a;
    final int bsN;
    
    public a(aypv paramaypv, int paramInt)
    {
      this.a = paramaypv;
      this.bsN = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aypu
 * JD-Core Version:    0.7.0.1
 */