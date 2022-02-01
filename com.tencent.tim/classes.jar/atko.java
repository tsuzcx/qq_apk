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

public class atko
  extends atjv
{
  protected int mode = 0;
  
  public atko(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
  }
  
  public View a(int paramInt1, atiu paramatiu, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, atdt.a parama, boolean paramBoolean3, int paramInt2)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.context).inflate(2131559420, null);
      paramatiu = new atko.a(null);
      paramatiu.ZU = ((TextView)paramView.findViewById(2131368208));
      paramatiu.DT = ((ImageView)paramView.findViewById(2131368209));
      paramView.setTag(paramatiu);
    }
    for (;;)
    {
      paramatiu.ZU.setText(2131694534);
      paramatiu.DT.setImageResource(2130840635);
      return paramView;
      paramatiu = (atko.a)paramView.getTag();
    }
  }
  
  public void destroy() {}
  
  static class a
  {
    ImageView DT;
    TextView ZU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atko
 * JD-Core Version:    0.7.0.1
 */