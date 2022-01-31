import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.discussion.LinkShareActionSheetBuilder;
import com.tencent.mobileqq.app.BaseActivity;

public class cek
  extends BaseAdapter
{
  private cek(LinkShareActionSheetBuilder paramLinkShareActionSheetBuilder) {}
  
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
      paramViewGroup = LayoutInflater.from(LinkShareActionSheetBuilder.a(this.a)).inflate(2130903673, null);
    }
    int i;
    int j;
    switch (paramInt)
    {
    default: 
      i = 2131363690;
      j = 2130837667;
      paramInt = 2131363711;
    }
    for (;;)
    {
      paramView = (ImageView)paramViewGroup.findViewById(2131297779);
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131297780);
      paramView.setImageResource(j);
      localTextView.setText(i);
      paramViewGroup.setContentDescription(LinkShareActionSheetBuilder.a(this.a).getString(paramInt));
      return paramViewGroup;
      i = 2131363687;
      j = 2130837669;
      paramInt = 2131363709;
      continue;
      i = 2131363685;
      j = 2130837670;
      paramInt = 2131363708;
      continue;
      i = 2131363684;
      j = 2130837668;
      paramInt = 2131363707;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cek
 * JD-Core Version:    0.7.0.1
 */