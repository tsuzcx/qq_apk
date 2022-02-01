import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.ui.dialog.DisplayHelper;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class yql
  extends BaseAdapter
{
  private yql.a a;
  protected Context mContext;
  protected View mRootView;
  private String mUin;
  private List<String> sW;
  
  public yql(Context paramContext, View paramView, String paramString)
  {
    this.mContext = paramContext;
    this.mRootView = paramView;
    this.mUin = paramString;
    this.sW = yqm.a().x(paramString);
    if ((this.sW != null) && (this.sW.size() > 0))
    {
      this.mRootView.setVisibility(0);
      return;
    }
    this.mRootView.setVisibility(8);
  }
  
  private boolean h(List<String> paramList1, List<String> paramList2)
  {
    if ((paramList1 == null) && (paramList2 == null)) {
      return true;
    }
    if ((paramList1 == null) || (paramList2 == null) || (paramList1.size() != paramList2.size())) {
      return false;
    }
    return paramList1.equals(paramList2);
  }
  
  public void a(yql.a parama)
  {
    this.a = parama;
  }
  
  public int getCount()
  {
    if (this.sW == null) {
      return 0;
    }
    return this.sW.size();
  }
  
  public String getItem(int paramInt)
  {
    return (String)this.sW.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.mContext).inflate(2131560013, paramViewGroup, false);
      paramView = new yql.b();
      paramView.iconView = ((ImageView)localView.findViewById(2131368534));
      paramView.Lt = ((TextView)localView.findViewById(2131368537));
      paramView.b = ((PressEffectImageView)localView.findViewById(2131377412));
      paramView.ev = localView.findViewById(2131366004);
      paramView.itemView = localView;
      localObject = (LinearLayout.LayoutParams)paramView.iconView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).leftMargin = DisplayHelper.dp2px(this.mContext, 16);
      paramView.iconView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localView.setTag(paramView);
      paramView.pos = paramInt;
      if (this.sW != null) {
        paramView.Lt.setText((CharSequence)this.sW.get(paramInt));
      }
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label273;
      }
      paramView.Lt.setTextColor(Color.parseColor("#A8A8A8"));
      paramView.iconView.setImageResource(2130847093);
      paramView.itemView.setBackgroundResource(2130839634);
      paramView.b.setImageResource(2130847092);
    }
    for (;;)
    {
      paramView.ev.setVisibility(8);
      localView.setOnClickListener(paramView);
      paramView.b.setOnClickListener(paramView);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (yql.b)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label273:
      paramView.Lt.setTextColor(Color.parseColor("#4D4D4D"));
      paramView.iconView.setImageResource(2130846932);
      paramView.itemView.setBackgroundResource(2130839633);
      paramView.b.setImageResource(2130846930);
    }
  }
  
  public void refreshData()
  {
    ArrayList localArrayList = yqm.a().x(this.mUin);
    if (h(this.sW, localArrayList)) {
      return;
    }
    this.sW = localArrayList;
    if (this.sW.isEmpty()) {
      this.mRootView.setVisibility(8);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.mRootView.setVisibility(0);
    }
  }
  
  public static abstract interface a
  {
    public abstract void xP(String paramString);
  }
  
  class b
    implements View.OnClickListener
  {
    public TextView Lt;
    public PressEffectImageView b;
    public View ev;
    public ImageView iconView;
    public View itemView;
    public int pos;
    
    b() {}
    
    public void onClick(View paramView)
    {
      String str = yql.this.getItem(this.pos);
      if (paramView == this.b)
      {
        yqm.a().dM(yql.a(yql.this), str);
        yql.this.refreshData();
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if ((paramView == this.itemView) && (yql.a(yql.this) != null)) {
          yql.a(yql.this).xP(str);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yql
 * JD-Core Version:    0.7.0.1
 */