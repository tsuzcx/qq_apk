import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.discussion.LinkShareActionSheetBuilder;
import com.tencent.mobileqq.app.BaseActivity;

public class wov
  extends BaseAdapter
{
  private wov(LinkShareActionSheetBuilder paramLinkShareActionSheetBuilder) {}
  
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
      paramViewGroup = LayoutInflater.from(LinkShareActionSheetBuilder.a(this.a)).inflate(2130971668, null);
    }
    int j;
    int i;
    switch (paramInt)
    {
    case 4: 
    default: 
      j = 2130838332;
      i = 2131435309;
      paramInt = 2131435333;
    }
    for (;;)
    {
      paramView = (ImageView)paramViewGroup.findViewById(2131366751);
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131364316);
      paramView.setImageResource(j);
      localTextView.setText(i);
      if (AppSetting.b) {
        paramViewGroup.setContentDescription(LinkShareActionSheetBuilder.a(this.a).getString(paramInt));
      }
      return paramViewGroup;
      i = 2131435301;
      j = 2130838336;
      paramInt = 2131435331;
      continue;
      i = 2131435308;
      j = 2130838337;
      paramInt = 2131435332;
      continue;
      i = 2131435299;
      j = 2130838340;
      paramInt = 2131435330;
      continue;
      i = 2131435298;
      j = 2130838334;
      paramInt = 2131435329;
      continue;
      paramInt = 2131429999;
      i = 2131429999;
      j = 2130840508;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wov
 * JD-Core Version:    0.7.0.1
 */