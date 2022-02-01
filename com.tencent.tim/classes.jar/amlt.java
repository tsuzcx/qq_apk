import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class amlt<M extends ampv, V extends amxz>
  extends BaseAdapter
{
  private List<M> modelList = new ArrayList();
  
  public M a(int paramInt)
  {
    if (paramInt >= this.modelList.size()) {
      return null;
    }
    return (ampv)this.modelList.get(paramInt);
  }
  
  protected abstract amsq<M, V> a(int paramInt);
  
  protected abstract amxz a(int paramInt, ViewGroup paramViewGroup);
  
  public void aq(List<M> paramList, boolean paramBoolean)
  {
    cS(paramList);
    super.notifyDataSetChanged();
  }
  
  public void cS(List<M> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "setDataList");
    }
    this.modelList.clear();
    if (paramList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "setDataList， size:" + paramList.size());
      }
      this.modelList.addAll(paramList);
    }
    for (;;)
    {
      paramList = this.modelList.iterator();
      while (paramList.hasNext()) {
        if (paramList.next() == null) {
          paramList.remove();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "setDataList， null");
      }
    }
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.modelList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ampv localampv = a(paramInt);
    Object localObject2;
    Object localObject1;
    if (localampv == null)
    {
      QLog.e("Q.uniteSearch.BaseMvpAdapter", 1, "getView model is null. position=" + paramInt + " list size = " + this.modelList.size());
      localObject2 = null;
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject2;
    }
    if (paramView == null)
    {
      localObject1 = a(paramInt, paramViewGroup);
      paramView = ((amxz)localObject1).getView();
      localObject2 = a(paramInt);
      paramView.setTag(2131381962, localObject2);
      paramView.setTag(2131381965, localObject1);
    }
    for (;;)
    {
      paramView.setTag(2131381960, localampv);
      if (((amxz)localObject1).getView() != null)
      {
        ((amxz)localObject1).getView().setTag(2131381961, Integer.valueOf(paramInt));
        ((amxz)localObject1).getView().setTag(2131381959, Integer.valueOf(getCount()));
      }
      ((amsq)localObject2).a(localampv, (amxz)localObject1);
      localObject1 = paramView;
      localObject2 = paramView;
      break;
      localObject1 = (amxz)paramView.getTag(2131381965);
      localObject2 = (amsq)paramView.getTag(2131381962);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     amlt
 * JD-Core Version:    0.7.0.1
 */