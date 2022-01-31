import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.richstatus.ActionInfo;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import java.util.ArrayList;

public class edf
  extends BaseAdapter
{
  private edf(EditActivity paramEditActivity) {}
  
  public int getCount()
  {
    return EditActivity.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return EditActivity.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = this.a.getLayoutInflater().inflate(2130903496, null);
    ImageView localImageView;
    TextView localTextView;
    if (paramInt == 3)
    {
      paramView.setBackgroundResource(2130837909);
      paramViewGroup = (Integer)EditActivity.a(this.a).get(paramInt);
      paramViewGroup = EditActivity.a(this.a).a(paramViewGroup.intValue());
      if (paramViewGroup == null) {
        break label247;
      }
      localImageView = (ImageView)paramView.findViewById(2131298217);
      localImageView.setImageDrawable(new StatableBitmapDrawable(this.a.getResources(), EditActivity.a(this.a).a(paramViewGroup.i, 201), false, false));
      localTextView = (TextView)paramView.findViewById(2131298218);
      localTextView.setText(paramViewGroup.c);
      paramView.setTag(Integer.valueOf(paramViewGroup.i));
      if (paramViewGroup.j != 1) {
        break label203;
      }
      localTextView.setCompoundDrawables(null, null, null, null);
    }
    for (;;)
    {
      if (!EditActivity.b(this.a)) {
        break label233;
      }
      localImageView.setVisibility(0);
      localTextView.setVisibility(0);
      return paramView;
      if (paramInt == 5)
      {
        paramView.setBackgroundResource(2130837910);
        break;
      }
      paramView.setBackgroundResource(2130838737);
      break;
      label203:
      localTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.a.getResources().getDrawable(2130837733), null);
      localTextView.setCompoundDrawablePadding(10);
    }
    label233:
    localImageView.setVisibility(4);
    localTextView.setVisibility(4);
    return paramView;
    label247:
    paramView.setTag(Integer.valueOf(-2147483648));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     edf
 * JD-Core Version:    0.7.0.1
 */