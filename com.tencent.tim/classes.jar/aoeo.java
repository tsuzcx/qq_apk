import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;

public class aoeo
  extends aodg
{
  protected int mode = 0;
  
  public aoeo(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
  }
  
  public View a(int paramInt1, aoef paramaoef, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.context).inflate(2131559420, null);
      paramaoef = new aoeo.a(null);
      paramaoef.ZU = ((TextView)paramView.findViewById(2131368208));
      paramaoef.DT = ((ImageView)paramView.findViewById(2131368209));
      paramView.setTag(paramaoef);
    }
    for (;;)
    {
      paramaoef.ZU.setText(2131694534);
      paramaoef.DT.setImageResource(2130840635);
      return paramView;
      paramaoef = (aoeo.a)paramView.getTag();
    }
  }
  
  static class a
  {
    ImageView DT;
    TextView ZU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoeo
 * JD-Core Version:    0.7.0.1
 */