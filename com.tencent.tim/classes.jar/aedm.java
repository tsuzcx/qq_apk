import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.settings.HistoryFormItem;
import com.tencent.mobileqq.colornote.settings.HistoryFormItem.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aedm
  implements View.OnClickListener
{
  public aedm(HistoryFormItem paramHistoryFormItem) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    int i;
    HistoryFormItem localHistoryFormItem;
    if (aeba.canAddColorNote())
    {
      i = 1;
      if ((i != 0) && (this.b.isEnable()))
      {
        localHistoryFormItem = this.b;
        if (HistoryFormItem.a(this.b)) {
          break label119;
        }
      }
    }
    for (;;)
    {
      HistoryFormItem.a(localHistoryFormItem, bool);
      this.b.F(paramView, HistoryFormItem.a(this.b));
      if (HistoryFormItem.a(this.b) != null) {
        HistoryFormItem.a(this.b).f(paramView, HistoryFormItem.a(this.b), HistoryFormItem.a(this.b));
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aebs.ed(paramView.getContext());
      i = 0;
      break;
      label119:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aedm
 * JD-Core Version:    0.7.0.1
 */