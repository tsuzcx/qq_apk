import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zcq
{
  private BaseActivity a;
  
  public zcq(BaseActivity paramBaseActivity)
  {
    this.a = paramBaseActivity;
  }
  
  public ausj a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    ausj localausj = (ausj)auss.a(this.a, null);
    GridView localGridView = (GridView)View.inflate(this.a, 2131563287, null);
    localGridView.setBackgroundDrawable(this.a.getResources().getDrawable(2130837650));
    localGridView.setAdapter(new zcq.a(null));
    localGridView.setOnItemClickListener(paramOnItemClickListener);
    localausj.addView(localGridView);
    localausj.addCancelButton(2131721058);
    return localausj;
  }
  
  class a
    extends BaseAdapter
  {
    private a() {}
    
    public int getCount()
    {
      return 6;
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
      if (paramView == null) {
        paramView = LayoutInflater.from(zcq.a(zcq.this)).inflate(2131563252, null);
      }
      for (;;)
      {
        int k;
        int j;
        int i;
        switch (paramInt)
        {
        case 4: 
        default: 
          k = 2130839246;
          j = 2131720166;
          i = 2131720766;
        }
        for (;;)
        {
          ImageView localImageView = (ImageView)paramView.findViewById(2131362847);
          TextView localTextView = (TextView)paramView.findViewById(2131362859);
          localImageView.setImageResource(k);
          localTextView.setText(j);
          if (AppSetting.enableTalkBack) {
            paramView.setContentDescription(zcq.a(zcq.this).getString(i));
          }
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          j = 2131720183;
          k = 2130839252;
          i = 2131720782;
          continue;
          j = 2131720185;
          k = 2130839253;
          i = 2131720783;
          continue;
          j = 2131720191;
          k = 2130839256;
          i = 2131720790;
          continue;
          j = 2131720180;
          k = 2130839249;
          i = 2131720773;
          continue;
          i = 2131717155;
          j = 2131717155;
          k = 2130843301;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zcq
 * JD-Core Version:    0.7.0.1
 */