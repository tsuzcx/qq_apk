import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class aytc
  extends BaseAdapter
{
  @Nullable
  private rmw a;
  private Context mContext;
  private List<rmw> nD = new ArrayList();
  
  public aytc(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  @Nullable
  public rmw a()
  {
    return this.a;
  }
  
  public void a(@Nullable rmw paramrmw)
  {
    this.a = paramrmw;
  }
  
  public int getCount()
  {
    return this.nD.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.nD.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131561980, null);
      localObject = new aytc.a(paramView);
      paramView.setTag(localObject);
    }
    for (;;)
    {
      ((aytc.a)localObject).a((rmw)this.nD.get(paramInt), this.a);
      localObject = ((aytc.a)localObject).itemView;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      localObject = (aytc.a)paramView.getTag();
    }
  }
  
  public void setTags(List<rmw> paramList)
  {
    if (paramList == null)
    {
      this.nD.clear();
      return;
    }
    this.nD.clear();
    this.nD.addAll(paramList);
  }
  
  static class a
  {
    TextView bd;
    TextView desc;
    ImageView icon;
    View itemView;
    TextView title;
    TextView yT;
    
    public a(View paramView)
    {
      this.itemView = paramView;
      this.icon = ((ImageView)paramView.findViewById(2131379211));
      this.title = ((TextView)paramView.findViewById(2131379234));
      this.desc = ((TextView)paramView.findViewById(2131379202));
      this.bd = ((TextView)paramView.findViewById(2131379201));
      this.yT = ((TextView)paramView.findViewById(2131379239));
    }
    
    private void c(TextView paramTextView, String paramString)
    {
      if (TextUtils.isEmpty(paramString))
      {
        paramTextView.setVisibility(8);
        return;
      }
      paramTextView.setVisibility(0);
      paramTextView.setText(paramString);
    }
    
    public void a(rmw paramrmw1, rmw paramrmw2)
    {
      c(this.title, paramrmw1.a.name);
      c(this.desc, paramrmw1.a.desc);
      if (paramrmw1.joinCount <= 0) {
        this.bd.setVisibility(8);
      }
      for (;;)
      {
        c(this.yT, paramrmw1.wording);
        if (!paramrmw1.equals(paramrmw2)) {
          break;
        }
        this.icon.setImageResource(2130847714);
        this.title.setTextColor(Color.parseColor("#12B7F5"));
        return;
        c(this.bd, paramrmw1.joinCount + acfp.m(2131712463));
      }
      this.icon.setImageResource(2130847718);
      this.title.setTextColor(Color.parseColor("#FFFFFF"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aytc
 * JD-Core Version:    0.7.0.1
 */