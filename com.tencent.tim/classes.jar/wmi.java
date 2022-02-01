import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.PlusPanel.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class wmi
  extends BaseAdapter
{
  View.OnClickListener dI;
  ArrayList<PlusPanel.a> qe;
  
  public void cW(ArrayList<PlusPanel.a> paramArrayList)
  {
    this.qe = paramArrayList;
  }
  
  public int getCount()
  {
    if (this.qe != null) {
      return this.qe.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = BaseApplication.getContext();
    Object localObject2;
    if (paramView == null)
    {
      localObject1 = LayoutInflater.from((Context)localObject1).inflate(2131558934, null);
      paramView = new wmi.a();
      paramView.sk = ((ImageView)((View)localObject1).findViewById(2131368847));
      paramView.sl = ((ImageView)((View)localObject1).findViewById(2131367211));
      paramView.Il = ((TextView)((View)localObject1).findViewById(2131379420));
      ((View)localObject1).setTag(paramView);
      localObject2 = (PlusPanel.a)this.qe.get(paramInt);
      paramView.sk.setBackgroundDrawable(((PlusPanel.a)localObject2).drawable);
      paramView.Il.setText(((PlusPanel.a)localObject2).text);
      if (!((PlusPanel.a)localObject2).beg) {
        break label195;
      }
      paramView.sl.setVisibility(0);
    }
    for (;;)
    {
      paramView.actionId = ((PlusPanel.a)localObject2).actionId;
      ((View)localObject1).setContentDescription(((PlusPanel.a)localObject2).contentDescription);
      ((View)localObject1).setOnClickListener(this.dI);
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject2 = (wmi.a)paramView.getTag();
      localObject1 = paramView;
      paramView = (View)localObject2;
      break;
      label195:
      paramView.sl.setVisibility(8);
    }
  }
  
  public void w(View.OnClickListener paramOnClickListener)
  {
    this.dI = paramOnClickListener;
  }
  
  public static class a
  {
    TextView Il;
    public int actionId;
    ImageView sk;
    ImageView sl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wmi
 * JD-Core Version:    0.7.0.1
 */