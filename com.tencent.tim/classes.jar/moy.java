import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ResultRecord;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class moy
  extends BaseAdapter
  implements mmf.a<ObservableArrayList<ResultRecord>>
{
  private boolean anw;
  private ObservableArrayList<ResultRecord> b = new ObservableArrayList();
  private PorterDuffColorFilter mColorFilter = new PorterDuffColorFilter(-1711276033, PorterDuff.Mode.SRC_ATOP);
  
  public moy(@NonNull ObservableArrayList<ResultRecord> paramObservableArrayList)
  {
    this.b = paramObservableArrayList;
    this.b.addOnListChangedCallback(this);
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2) {}
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void aQU()
  {
    int i = this.b.size();
    if (i > 0)
    {
      if (this.anw) {
        this.b.remove(i - 1);
      }
    }
    else {
      return;
    }
    this.anw = true;
    notifyDataSetChanged();
  }
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList)
  {
    notifyDataSetChanged();
  }
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    this.anw = false;
    notifyDataSetChanged();
  }
  
  public void c(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    this.anw = false;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (paramView != null)
    {
      localObject1 = (ReadInJoyHeadImageView)paramView.getTag();
      Object localObject2 = getItem(paramInt);
      if ((localObject2 != null) && ((localObject2 instanceof ResultRecord))) {
        ((ReadInJoyHeadImageView)localObject1).setHeadImgByUin(((ResultRecord)localObject2).getUin());
      }
      int i = getCount();
      localObject1 = paramView.findViewById(2131368950);
      if ((!this.anw) || (paramInt != i - 1)) {
        break label132;
      }
      ((View)localObject1).setVisibility(0);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560469, paramViewGroup, false);
      localObject1 = (ReadInJoyHeadImageView)paramView.findViewById(2131368949);
      paramView.setTag(localObject1);
      break;
      label132:
      ((View)localObject1).setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moy
 * JD-Core Version:    0.7.0.1
 */