import android.graphics.Color;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.minigame.utils.DpUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class snd
  extends BaseAdapter
{
  private Map<Integer, snd.b> gv = new HashMap();
  private List<snd.a> px = new ArrayList();
  
  public void fg(List<snd.a> paramList)
  {
    this.px.clear();
    this.px.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if ((this.px == null) || (this.px.size() == 0)) {
      return 0;
    }
    return this.px.size();
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
    snd.a locala = (snd.a)this.px.get(paramInt);
    Object localObject;
    if (!this.gv.containsKey(Integer.valueOf(paramInt)))
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560788, paramViewGroup, false);
      paramView.setLayoutParams(new ViewGroup.LayoutParams(-2, DpUtil.dip2px(paramViewGroup.getContext(), 50.0F)));
      localObject = new snd.b();
      ((snd.b)localObject).textView = ((TextView)paramView.findViewById(2131380735));
      ((snd.b)localObject).qn = paramView.findViewById(2131381919);
      if ((locala != null) && (Build.VERSION.SDK_INT >= 4)) {
        paramView.setContentDescription(locala.name);
      }
      ((snd.b)localObject).convertView = paramView;
      this.gv.put(Integer.valueOf(paramInt), localObject);
    }
    label283:
    label293:
    label300:
    for (;;)
    {
      if ((locala != null) && (localObject != null) && (paramView != null))
      {
        ((snd.b)localObject).textView.setText(locala.name);
        TextView localTextView = ((snd.b)localObject).textView;
        if (!locala.selected) {
          break label283;
        }
        i = Color.parseColor("#ffff5b84");
        label194:
        localTextView.setTextColor(i);
        localObject = ((snd.b)localObject).qn;
        if (!locala.selected) {
          break label293;
        }
      }
      for (int i = 0;; i = 8)
      {
        ((View)localObject).setVisibility(i);
        paramView.setSelected(locala.selected);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject = (snd.b)this.gv.get(Integer.valueOf(paramInt));
        if (localObject == null) {
          break label300;
        }
        paramView = ((snd.b)localObject).convertView;
        break;
        i = Color.parseColor("#ff878b99");
        break label194;
      }
    }
  }
  
  public void setSelectedTab(int paramInt)
  {
    int i = 0;
    if (i < this.px.size())
    {
      snd.a locala = (snd.a)this.px.get(i);
      if (i == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        locala.selected = bool;
        i += 1;
        break;
      }
    }
    notifyDataSetChanged();
  }
  
  public static class a
  {
    public String name;
    public boolean selected;
  }
  
  public static class b
  {
    View convertView;
    View qn;
    TextView textView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     snd
 * JD-Core Version:    0.7.0.1
 */