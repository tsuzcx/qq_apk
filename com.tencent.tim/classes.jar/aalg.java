import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.widget.AbsListView.LayoutParams;

public class aalg
  extends aakb
{
  private int cho;
  private int chp;
  private int chq;
  private int chu;
  
  public View a(int paramInt, Object paramObject, aajx paramaajx, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.c paramc)
  {
    int i;
    if (paramView == null)
    {
      paramaajx = null;
      if (!"TroopAssistantEmptyItemBuilder".equals(paramaajx))
      {
        paramView = View.inflate(paramContext, 2131563241, null);
        paramView.setTag("TroopAssistantEmptyItemBuilder");
        paramaajx = paramContext.getResources();
        this.chp = paramaajx.getDimensionPixelSize(2131299265);
        this.cho = paramaajx.getDimensionPixelSize(2131299270);
        this.chq = paramaajx.getDimensionPixelSize(2131299272);
        i = paramaajx.getDimensionPixelSize(2131299669);
        this.chu = (paramaajx.getDimensionPixelSize(2131299670) + i);
      }
      i = paramViewGroup.getMeasuredHeight() - this.cho - this.chp - 10 - this.chu;
      if (i <= this.chq) {
        break label210;
      }
      label124:
      paramaajx = new AbsListView.LayoutParams(-1, -1);
      paramaajx.width = -1;
      paramaajx.height = i;
      paramView.setLayoutParams(paramaajx);
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        paramaajx = (TextView)paramView.findViewById(2131380236);
        if (paramObject.intValue() != 4) {
          break label219;
        }
        paramaajx.setText(2131721307);
      }
    }
    for (;;)
    {
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
      paramaajx = paramView.getTag();
      break;
      label210:
      i = this.chq;
      break label124;
      label219:
      paramaajx.setText(2131696924);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aalg
 * JD-Core Version:    0.7.0.1
 */