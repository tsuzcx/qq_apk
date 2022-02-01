import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import java.text.ParseException;

public class atjy
  extends atjv
{
  public atjy(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
  }
  
  public View a(int paramInt1, atiu paramatiu, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, atdt.a parama, boolean paramBoolean3, int paramInt2)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.context).inflate(2131558960, null);
      paramViewGroup = new atjy.a();
      a(paramViewGroup, paramView);
      paramViewGroup.Kv.setVisibility(8);
      wja.dp2px(12.0F, this.context.getResources());
      paramOnClickListener = new LinearLayout.LayoutParams(-1, -2);
      if (!paramBoolean1) {
        break label137;
      }
    }
    label137:
    for (paramInt1 = wja.dp2px(17.0F, this.context.getResources());; paramInt1 = wja.dp2px(12.0F, this.context.getResources()))
    {
      paramOnClickListener.setMargins(paramInt1, 0, 0, 0);
      paramViewGroup.ka.setLayoutParams(paramOnClickListener);
      try
      {
        paramViewGroup.ka.setText(auqb.cr(paramatiu.getSortTime()));
        return paramView;
      }
      catch (ParseException paramatiu)
      {
        paramatiu.printStackTrace();
      }
      paramViewGroup = (atjy.a)paramView.getTag();
      break;
    }
    return paramView;
  }
  
  public void a(atjy.a parama, View paramView)
  {
    parama.ka = ((TextView)paramView.findViewById(2131364713));
    parama.Kv = paramView.findViewById(2131369422);
    paramView.setTag(parama);
  }
  
  public void destroy() {}
  
  public static class a
  {
    View Kv;
    TextView ka;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atjy
 * JD-Core Version:    0.7.0.1
 */