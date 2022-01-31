import android.support.v7.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class yhw<E>
  extends RecyclerView.Adapter
{
  public final ArrayList<E> mDataList = new ArrayList();
  
  public void addAll(List<E> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.mDataList.addAll(paramList);
    notifyItemRangeInserted(this.mDataList.size(), paramList.size());
  }
  
  public void addAll(E[] paramArrayOfE)
  {
    if (paramArrayOfE == null) {}
    for (;;)
    {
      return;
      int j = paramArrayOfE.length;
      int i = 0;
      while (i < j)
      {
        E ? = paramArrayOfE[i];
        this.mDataList.add(?);
        i += 1;
      }
    }
  }
  
  public E addData(E paramE)
  {
    if (paramE == null) {}
    do
    {
      return null;
      Iterator localIterator = this.mDataList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (localObject == paramE) {
          return localObject;
        }
        if (isItemEqual(localObject, paramE))
        {
          copyItem(localObject, paramE);
          return localObject;
        }
      }
    } while (!this.mDataList.add(paramE));
    return this.mDataList.get(this.mDataList.size() - 1);
  }
  
  public void addData(E paramE, int paramInt)
  {
    this.mDataList.add(paramInt, paramE);
  }
  
  public void clearData()
  {
    this.mDataList.clear();
  }
  
  protected void copyItem(E paramE1, E paramE2) {}
  
  public void delete(int paramInt)
  {
    if (paramInt < this.mDataList.size()) {
      this.mDataList.remove(paramInt);
    }
  }
  
  public ArrayList<E> getDataList()
  {
    return this.mDataList;
  }
  
  public int getDataNumber()
  {
    return this.mDataList.size();
  }
  
  public int getItemCount()
  {
    return this.mDataList.size();
  }
  
  protected boolean isItemEqual(E paramE1, E paramE2)
  {
    return false;
  }
  
  public void setDatas(ArrayList<E> paramArrayList)
  {
    this.mDataList.clear();
    notifyDataSetChanged();
    if (paramArrayList == null) {
      return;
    }
    this.mDataList.addAll(paramArrayList);
    notifyDataSetChanged();
  }
  
  public void updateData(E paramE, int paramInt)
  {
    if ((paramE == null) || (paramInt >= this.mDataList.size())) {
      return;
    }
    this.mDataList.set(paramInt, paramE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yhw
 * JD-Core Version:    0.7.0.1
 */