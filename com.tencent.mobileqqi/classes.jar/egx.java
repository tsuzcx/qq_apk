import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.discussion.LinkShareActionSheetBuilder;
import com.tencent.mobileqq.app.BaseActivity;

public class egx
  extends BaseAdapter
{
  private egx(LinkShareActionSheetBuilder paramLinkShareActionSheetBuilder) {}
  
  public int getCount()
  {
    return 5;
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
      paramViewGroup = LayoutInflater.from(LinkShareActionSheetBuilder.a(this.a)).inflate(2130904030, null);
    }
    int i;
    int j;
    switch (paramInt)
    {
    default: 
      i = 2131561882;
      j = 2130837750;
      paramInt = 2131561884;
    }
    for (;;)
    {
      paramView = (ImageView)paramViewGroup.findViewById(2131232545);
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131232546);
      paramView.setImageResource(j);
      localTextView.setText(i);
      paramViewGroup.setContentDescription(LinkShareActionSheetBuilder.a(this.a).getString(paramInt));
      return paramViewGroup;
      i = 2131562390;
      j = 2130837751;
      paramInt = 2131562913;
      continue;
      i = 2131562715;
      j = 2130837752;
      paramInt = 2131562915;
      continue;
      i = 2131561882;
      j = 2130837750;
      paramInt = 2131561884;
      continue;
      i = 2131561882;
      j = 2130837750;
      paramInt = 2131561884;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     egx
 * JD-Core Version:    0.7.0.1
 */