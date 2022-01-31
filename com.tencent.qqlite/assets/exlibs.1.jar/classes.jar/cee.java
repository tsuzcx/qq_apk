import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.discussion.LinkShareActionSheetBuilder;
import com.tencent.mobileqq.app.BaseActivity;

public class cee
  extends BaseAdapter
{
  private cee(LinkShareActionSheetBuilder paramLinkShareActionSheetBuilder) {}
  
  public int getCount()
  {
    return 4;
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
      paramViewGroup = LayoutInflater.from(LinkShareActionSheetBuilder.a(this.a)).inflate(2130903690, null);
    }
    int i;
    int j;
    switch (paramInt)
    {
    default: 
      i = 2131363696;
      j = 2130837665;
      paramInt = 2131363717;
    }
    for (;;)
    {
      paramView = (ImageView)paramViewGroup.findViewById(2131297783);
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131297784);
      paramView.setImageResource(j);
      localTextView.setText(i);
      paramViewGroup.setContentDescription(LinkShareActionSheetBuilder.a(this.a).getString(paramInt));
      return paramViewGroup;
      i = 2131363693;
      j = 2130837667;
      paramInt = 2131363715;
      continue;
      i = 2131363691;
      j = 2130837668;
      paramInt = 2131363714;
      continue;
      i = 2131363690;
      j = 2130837666;
      paramInt = 2131363713;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cee
 * JD-Core Version:    0.7.0.1
 */