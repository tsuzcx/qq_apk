import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility;

public class hei
  extends BaseAdapter
{
  private hei(TroopShareUtility paramTroopShareUtility) {}
  
  public int getCount()
  {
    if (TroopShareUtility.a(this.a).a) {
      return 6;
    }
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
      paramViewGroup = LayoutInflater.from(TroopShareUtility.a(this.a)).inflate(2130904028, null);
    }
    int i;
    int j;
    switch (paramInt)
    {
    default: 
      i = 2131561882;
      j = 2130837749;
      paramInt = 2131561884;
    }
    for (;;)
    {
      paramView = (ImageView)paramViewGroup.findViewById(2131232543);
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131232544);
      paramView.setImageResource(j);
      localTextView.setText(i);
      paramViewGroup.setContentDescription(TroopShareUtility.a(this.a).getString(paramInt));
      return paramViewGroup;
      i = 2131561882;
      j = 2130837749;
      paramInt = 2131561884;
      continue;
      i = 2131561882;
      j = 2130837749;
      paramInt = 2131561884;
      continue;
      i = 2131561870;
      j = 2130839425;
      paramInt = 2131562913;
      continue;
      i = 2131562715;
      j = 2130837751;
      paramInt = 2131562915;
      continue;
      i = 2131560516;
      j = 2130838356;
      paramInt = 2131560493;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hei
 * JD-Core Version:    0.7.0.1
 */