import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.widget.AbsListView.LayoutParams;

public class aajw
  extends aakb
{
  private int cho;
  private int chp;
  private int chq;
  
  public View a(int paramInt, Object paramObject, aajx paramaajx, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.c paramc)
  {
    if (paramView != null)
    {
      paramaajx = paramView;
      if ("R.layout.conversation_no_chat".equals(paramView.getTag(2131559115))) {}
    }
    else
    {
      paramaajx = View.inflate(paramContext, 2131559115, null);
      this.chp = paramContext.getResources().getDimensionPixelSize(2131299265);
      this.cho = paramContext.getResources().getDimensionPixelSize(2131299268);
      this.chq = paramContext.getResources().getDimensionPixelSize(2131299272);
    }
    int i = paramViewGroup.getHeight() - this.cho * 2 - this.chp;
    if (i > this.chq)
    {
      paramView = new AbsListView.LayoutParams(-1, -1);
      paramView.width = -1;
      paramView.height = i;
      paramaajx.setLayoutParams(paramView);
      paramaajx.setTag(Boolean.valueOf(true));
      paramView = (TextView)paramaajx.findViewById(2131372407);
      paramViewGroup = (Button)paramaajx.findViewById(2131363764);
      if (!(paramObject instanceof Integer)) {
        break label382;
      }
      i = ((Integer)paramObject).intValue();
      if (i != 1) {
        break label263;
      }
      paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130842216, 0, 0);
      paramView.setVisibility(0);
      paramView.setText(2131696924);
      paramView.setTextColor(paramContext.getResources().getColorStateList(2131167385));
      paramViewGroup.setVisibility(8);
      paramViewGroup.setOnClickListener(null);
    }
    for (;;)
    {
      paramaajx.setTag(-1, Integer.valueOf(paramInt));
      paramaajx.setTag(2131559115, "R.layout.conversation_no_chat");
      return paramaajx;
      i = this.chq;
      break;
      label263:
      if (i == 0)
      {
        if ((paramContext instanceof MsgBoxListActivity))
        {
          if (((MsgBoxListActivity)paramContext).bXp)
          {
            paramView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            paramView.setVisibility(0);
            paramView.setText("");
          }
        }
        else
        {
          paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130842216, 0, 0);
          paramView.setVisibility(0);
          paramView.setText(2131696333);
          paramView.setTextColor(paramContext.getResources().getColorStateList(2131167385));
          paramViewGroup.setVisibility(8);
          paramViewGroup.setOnClickListener(null);
        }
      }
      else
      {
        paramView.setVisibility(4);
        paramView.setText("");
        continue;
        label382:
        paramView.setVisibility(8);
        paramView.setText("");
        paramViewGroup.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aajw
 * JD-Core Version:    0.7.0.1
 */