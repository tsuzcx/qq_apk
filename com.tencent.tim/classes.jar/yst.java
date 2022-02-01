import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

public class yst
  extends ysa
  implements View.OnClickListener
{
  public yst(Context paramContext, QQAppInterface paramQQAppInterface, ytd paramytd, ytv paramytv)
  {
    super(paramContext, paramQQAppInterface, paramytd, paramytv);
  }
  
  public View a(int paramInt, View paramView)
  {
    yst.a locala;
    if ((paramView == null) || (!(paramView.getTag() instanceof yst.a)))
    {
      locala = new yst.a();
      paramView = LayoutInflater.from(this.mContext).inflate(2131561513, null);
      paramView.setTag(locala);
    }
    for (;;)
    {
      paramView.setOnClickListener(this);
      return paramView;
      locala = (yst.a)paramView.getTag();
    }
  }
  
  public void onClick(View paramView) {}
  
  public static class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yst
 * JD-Core Version:    0.7.0.1
 */