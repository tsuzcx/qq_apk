import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;

public class atkd
  extends atjv
{
  protected int mode = 0;
  
  public atkd(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
  }
  
  public View a(int paramInt1, atiu paramatiu, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, atdt.a parama, boolean paramBoolean3, int paramInt2)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.context).inflate(2131558966, null);
      paramOnClickListener = new atkd.a(null);
      paramOnClickListener.lu = paramView.findViewById(2131364742);
      paramOnClickListener.ZU = ((TextView)paramView.findViewById(2131364744));
      paramOnClickListener.lq = paramView.findViewById(2131364761);
      paramOnClickListener.aeP = ((TextView)paramView.findViewById(2131364740));
      paramOnClickListener.DT = ((ImageView)paramView.findViewById(2131364741));
      paramView.setTag(paramOnClickListener);
      paramInt1 = paramViewGroup.getHeight();
      if ((paramViewGroup instanceof XListView)) {}
      paramView.setLayoutParams(new AbsListView.LayoutParams(paramViewGroup.getWidth(), paramInt1));
      paramatiu = (atkt)paramatiu;
      if (paramatiu == null) {
        break label181;
      }
    }
    label181:
    for (paramInt1 = paramatiu.getMode();; paramInt1 = 0)
    {
      if (paramInt1 != 3) {
        break label186;
      }
      paramOnClickListener.lq.setVisibility(0);
      paramOnClickListener.lu.setVisibility(8);
      return paramView;
      paramOnClickListener = (atkd.a)paramView.getTag();
      break;
    }
    label186:
    paramOnClickListener.lq.setVisibility(8);
    paramOnClickListener.lu.setVisibility(0);
    if (this.entrance == 1)
    {
      paramOnClickListener.ZU.setText(2131720904);
      paramOnClickListener.ZU.setVisibility(0);
      paramOnClickListener.DT.setImageResource(2130851569);
      paramOnClickListener.aeP.setText(2131720905);
      paramOnClickListener.aeP.setVisibility(0);
      return paramView;
    }
    if (this.entrance == 8)
    {
      paramOnClickListener.ZU.setText(2131691620);
      paramOnClickListener.ZU.setVisibility(0);
      paramOnClickListener.aeP.setText(2131691621);
      paramOnClickListener.aeP.setVisibility(0);
      return paramView;
    }
    if (paramInt1 == 1)
    {
      paramOnClickListener.ZU.setVisibility(8);
      paramOnClickListener.DT.setVisibility(8);
      paramatiu = (LinearLayout.LayoutParams)paramOnClickListener.aeP.getLayoutParams();
      paramatiu.setMargins(0, 0, 0, 0);
      paramOnClickListener.aeP.setLayoutParams(paramatiu);
      paramOnClickListener.aeP.setText(2131691619);
      paramOnClickListener.aeP.setVisibility(0);
      return paramView;
    }
    if (paramInt1 == 2)
    {
      paramOnClickListener.ZU.setVisibility(8);
      paramOnClickListener.DT.setVisibility(8);
      paramatiu = (LinearLayout.LayoutParams)paramOnClickListener.aeP.getLayoutParams();
      paramatiu.setMargins(0, 0, 0, 0);
      paramOnClickListener.aeP.setLayoutParams(paramatiu);
      paramOnClickListener.aeP.setText(2131691618);
      paramOnClickListener.aeP.setVisibility(0);
      return paramView;
    }
    paramOnClickListener.ZU.setText(2131691616);
    paramOnClickListener.aeP.setVisibility(0);
    return paramView;
  }
  
  public void destroy() {}
  
  static class a
  {
    ImageView DT;
    TextView ZU;
    TextView aeP;
    View lq;
    View lu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atkd
 * JD-Core Version:    0.7.0.1
 */