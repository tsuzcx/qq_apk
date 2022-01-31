import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.discussion.LinkShareActionSheetBuilder;
import com.tencent.mobileqq.app.BaseActivity;

public class wug
  extends BaseAdapter
{
  private wug(LinkShareActionSheetBuilder paramLinkShareActionSheetBuilder) {}
  
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
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = LayoutInflater.from(LinkShareActionSheetBuilder.a(this.a)).inflate(2130971697, null);
    }
    int j;
    int i;
    switch (paramInt)
    {
    case 4: 
    default: 
      j = 2130838337;
      i = 2131435325;
      paramInt = 2131435349;
    }
    for (;;)
    {
      paramView = (ImageView)paramViewGroup.findViewById(2131366749);
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131364341);
      paramView.setImageResource(j);
      localTextView.setText(i);
      if (AppSetting.b) {
        paramViewGroup.setContentDescription(LinkShareActionSheetBuilder.a(this.a).getString(paramInt));
      }
      return paramViewGroup;
      i = 2131435317;
      j = 2130838341;
      paramInt = 2131435347;
      continue;
      i = 2131435324;
      j = 2130838342;
      paramInt = 2131435348;
      continue;
      i = 2131435315;
      j = 2130838345;
      paramInt = 2131435346;
      continue;
      i = 2131435314;
      j = 2130838339;
      paramInt = 2131435345;
      continue;
      paramInt = 2131430001;
      i = 2131430001;
      j = 2130840523;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wug
 * JD-Core Version:    0.7.0.1
 */