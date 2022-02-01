import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;

public class ysw
  extends ysa
  implements View.OnClickListener
{
  public ysw(Context paramContext, QQAppInterface paramQQAppInterface, ytd paramytd, ytv paramytv)
  {
    super(paramContext, paramQQAppInterface, paramytd, paramytv);
  }
  
  private void a(TextView paramTextView, ytv paramytv)
  {
    if ((paramytv == null) || (!(paramytv instanceof yuc))) {}
    do
    {
      return;
      paramytv = (yuc)paramytv;
    } while ((paramytv.data == null) || (paramytv.data.size() == 0));
    String str = this.mContext.getString(2131701420);
    paramTextView.setVisibility(0);
    paramTextView.setText(str);
    if (paramytv.boH)
    {
      paramTextView.setPadding(0, aqnm.dip2px(16.0F), 0, aqnm.dip2px(6.0F));
      return;
    }
    paramTextView.setPadding(0, aqnm.dip2px(16.0F), 0, aqnm.dip2px(6.0F));
  }
  
  public View a(int paramInt, View paramView)
  {
    View localView;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof ysw.a)))
    {
      paramView = new ysw.a();
      localView = LayoutInflater.from(this.mContext).inflate(2131561510, null);
      paramView.titleText = ((TextView)localView.findViewById(2131379142));
      localView.setTag(paramView);
      localObject = paramView;
    }
    for (;;)
    {
      fK(((ysw.a)localObject).titleText);
      a(((ysw.a)localObject).titleText, this.a);
      localView.setOnClickListener(this);
      return localView;
      localObject = (ysw.a)paramView.getTag();
      localView = paramView;
    }
  }
  
  public void fK(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839642);
      return;
    }
    paramView.setBackgroundResource(2130851238);
  }
  
  public void onClick(View paramView) {}
  
  public static class a
  {
    public TextView titleText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ysw
 * JD-Core Version:    0.7.0.1
 */