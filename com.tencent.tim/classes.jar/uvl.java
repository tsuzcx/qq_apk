import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class uvl
  implements View.OnClickListener
{
  public uvl(EditActivity paramEditActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.gR();
    Object localObject1;
    if (this.this$0.action == 105)
    {
      localObject1 = this.this$0.e.getText();
      if (localObject1 != null)
      {
        localObject1 = localObject1.toString().trim();
        if (((String)localObject1).length() != 0) {
          break label78;
        }
        QQToast.a(this.this$0, this.this$0.getString(2131693104), 0).show();
        break label179;
      }
    }
    label179:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label78:
      if (EditActivity.a(this.this$0, (String)localObject1))
      {
        QQToast.a(this.this$0, this.this$0.getString(2131693105), 0).show();
      }
      else
      {
        Object localObject2 = (afhu)this.this$0.app.getManager(149);
        afhv localafhv = (afhv)this.this$0.app.getManager(103);
        localObject2 = ((afhu)localObject2).ez();
        if ((EditActivity.a(this.this$0) != -1) && (localObject2 != null))
        {
          localObject2 = ((List)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject2).next();
            if (EditActivity.a(this.this$0) != localCustomEmotionData.emoId) {
              break;
            }
            EditActivity.c(this.this$0);
            localafhv.b(localCustomEmotionData, (String)localObject1);
            continue;
            EditActivity.b(this.this$0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uvl
 * JD-Core Version:    0.7.0.1
 */