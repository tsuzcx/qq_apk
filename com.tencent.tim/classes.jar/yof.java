import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.List;

public class yof
  extends BaseAdapter
  implements View.OnClickListener
{
  public yof.a a;
  WeakReference<Context> eA;
  List<ReadInJoySearchHistoryEntity> mDataList;
  
  public yof(Context paramContext, List<ReadInJoySearchHistoryEntity> paramList, yof.a parama)
  {
    this.eA = new WeakReference(paramContext);
    cS(paramList);
    this.a = parama;
  }
  
  private void cS(List<ReadInJoySearchHistoryEntity> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.mDataList = null;
      return;
    }
    if (paramList.size() < 6)
    {
      this.mDataList = paramList;
      return;
    }
    this.mDataList = paramList.subList(0, 5);
  }
  
  public void bJ(List<ReadInJoySearchHistoryEntity> paramList)
  {
    cS(paramList);
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if ((this.mDataList == null) || (this.mDataList.size() == 0)) {
      return 0;
    }
    return this.mDataList.size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.mDataList.size()) {
      return (ReadInJoySearchHistoryEntity)this.mDataList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (Context)this.eA.get();
    View localView;
    if (localObject == null)
    {
      localView = null;
      localObject = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
      return localView;
    }
    if (paramView == null)
    {
      paramView = LayoutInflater.from((Context)localObject).inflate(2131560004, null);
      localObject = new yof.b();
      ((yof.b)localObject).name = ((TextView)paramView.findViewById(2131368538));
      ((yof.b)localObject).ht = ((LinearLayout)paramView.findViewById(2131370081));
      ((yof.b)localObject).im = ((RelativeLayout)paramView.findViewById(2131364648));
      paramView.setTag(localObject);
      paramView.setOnClickListener(this);
      label120:
      ((yof.b)localObject).position = paramInt;
      if (paramInt >= this.mDataList.size()) {
        break label203;
      }
      ((yof.b)localObject).im.setVisibility(8);
      ((yof.b)localObject).ht.setVisibility(0);
      ((yof.b)localObject).name.setText(((ReadInJoySearchHistoryEntity)this.mDataList.get(paramInt)).keyWord);
    }
    for (;;)
    {
      localObject = paramView;
      localView = paramView;
      break;
      localObject = (yof.b)paramView.getTag();
      break label120;
      label203:
      if (paramInt == this.mDataList.size())
      {
        ((yof.b)localObject).im.setVisibility(0);
        ((yof.b)localObject).ht.setVisibility(8);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((paramView.getTag() instanceof yof.b))
    {
      localObject = (yof.b)paramView.getTag();
      if (((yof.b)localObject).position >= this.mDataList.size()) {
        break label76;
      }
      if (this.a != null)
      {
        localObject = (ReadInJoySearchHistoryEntity)this.mDataList.get(((yof.b)localObject).position);
        this.a.a((ReadInJoySearchHistoryEntity)localObject);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label76:
      if ((((yof.b)localObject).position == this.mDataList.size()) && (this.a != null)) {
        this.a.bcs();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(ReadInJoySearchHistoryEntity paramReadInJoySearchHistoryEntity);
    
    public abstract void bcs();
  }
  
  class b
  {
    public LinearLayout ht;
    public RelativeLayout im;
    public TextView name;
    public int position;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yof
 * JD-Core Version:    0.7.0.1
 */