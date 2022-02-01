import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLEncoder;
import java.util.List;

public class abfx
  extends BaseAdapter
{
  protected aclk a;
  protected int fromType;
  protected QQAppInterface mApp;
  protected Context mContext;
  protected View rootView;
  public List<String> vU;
  
  public abfx(Context paramContext, QQAppInterface paramQQAppInterface, View paramView, int paramInt)
  {
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    this.rootView = paramView;
    this.fromType = paramInt;
    this.a = ((aclk)this.mApp.getManager(299));
  }
  
  public int getCount()
  {
    if (this.vU == null) {
      return 0;
    }
    return this.vU.size();
  }
  
  public String getItem(int paramInt)
  {
    return (String)this.vU.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.mContext).inflate(2131560013, paramViewGroup, false);
      paramView = new abfx.a();
      paramView.iconView = ((ImageView)localView.findViewById(2131368534));
      paramView.Px = ((TextView)localView.findViewById(2131368537));
      paramView.b = ((PressEffectImageView)localView.findViewById(2131377412));
      paramView.ev = localView.findViewById(2131366004);
      paramView.itemView = localView;
      localView.setTag(paramView);
      paramView.pos = paramInt;
      if (this.vU != null) {
        paramView.Px.setText((CharSequence)this.vU.get(paramInt));
      }
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label241;
      }
      paramView.Px.setTextColor(Color.parseColor("#6991B8"));
      paramView.ev.setBackgroundColor(Color.parseColor("#040E1C"));
      paramView.iconView.setImageResource(2130846933);
      paramView.itemView.setBackgroundResource(2130839634);
      paramView.b.setImageResource(2130846931);
    }
    for (;;)
    {
      localView.setOnClickListener(paramView);
      paramView.b.setOnClickListener(paramView);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      abfx.a locala = (abfx.a)paramView.getTag();
      localView = paramView;
      paramView = locala;
      break;
      label241:
      paramView.Px.setTextColor(Color.parseColor("#4D4D4D"));
      paramView.ev.setBackgroundColor(Color.parseColor("#E6E6E6"));
      paramView.iconView.setImageResource(2130846932);
      paramView.itemView.setBackgroundResource(2130839633);
      paramView.b.setImageResource(2130846930);
    }
  }
  
  public void refreshData()
  {
    this.vU = this.a.cD();
    if (this.vU.isEmpty()) {
      this.rootView.setVisibility(8);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.rootView.setVisibility(0);
    }
  }
  
  class a
    implements View.OnClickListener
  {
    public TextView Px;
    public PressEffectImageView b;
    public View ev;
    public ImageView iconView;
    public View itemView;
    public int pos;
    
    a() {}
    
    public void onClick(View paramView)
    {
      String str3 = abfx.this.getItem(this.pos);
      if (paramView == this.b)
      {
        if (abfx.this.a != null) {
          abfx.this.a.JU(this.pos);
        }
        abfx.this.refreshData();
      }
      while (paramView != this.itemView)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
      String str2 = aenm.a().bzV;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "https://sou.qq.com/kandian/kd.html?_bid=3216&_wv=3&_wwv=1293&_wvSb=0&keyword=$KEYWORD$&from=$FROM$";
      }
      str1 = str1.replace("$KEYWORD$", URLEncoder.encode(str3));
      if ((abfx.this.fromType == 25) || (abfx.this.fromType == 10)) {}
      for (str1 = str1.replace("$FROM$", "kandian_history");; str1 = str1.replace("$FROM$", amub.eZ(abfx.this.fromType)))
      {
        str1 = str1.replace("$SEARCHID$", "" + URLEncoder.encode(UniteSearchActivity.caN));
        amxk.g(abfx.this.mApp, abfx.this.mContext, str1);
        abfx.this.a.EO(str3);
        amub.a(null, new ReportModelDC02528().module("all_result").action("clk_search_his").ver2(amub.eZ(abfx.this.fromType)).ver4(str3).ver7("{experiment_id:" + amub.cce + "}"));
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abfx
 * JD-Core Version:    0.7.0.1
 */