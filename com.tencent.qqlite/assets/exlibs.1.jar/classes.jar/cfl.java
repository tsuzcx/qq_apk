import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.discussion.LinkShareActionSheetBuilder;
import com.tencent.mobileqq.app.BaseActivity;

public class cfl
  extends BaseAdapter
{
  private cfl(LinkShareActionSheetBuilder paramLinkShareActionSheetBuilder) {}
  
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
      paramViewGroup = LayoutInflater.from(LinkShareActionSheetBuilder.a(this.a)).inflate(2130903682, null);
    }
    int i;
    int j;
    switch (paramInt)
    {
    default: 
      i = 2131363701;
      j = 2130837692;
      paramInt = 2131363722;
    }
    for (;;)
    {
      paramView = (ImageView)paramViewGroup.findViewById(2131297783);
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131297784);
      paramView.setImageResource(j);
      localTextView.setText(i);
      paramViewGroup.setContentDescription(LinkShareActionSheetBuilder.a(this.a).getString(paramInt));
      return paramViewGroup;
      i = 2131363698;
      j = 2130837694;
      paramInt = 2131363720;
      continue;
      i = 2131363696;
      j = 2130837695;
      paramInt = 2131363719;
      continue;
      i = 2131363695;
      j = 2130837693;
      paramInt = 2131363718;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cfl
 * JD-Core Version:    0.7.0.1
 */