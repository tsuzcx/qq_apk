import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.teamwork.PadInfo;
import java.util.HashMap;
import java.util.List;

class auik
  implements View.OnClickListener
{
  auik(auif paramauif) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (atkw)((atjv.a)paramView.getTag()).a;
    if (((atkw)localObject).getFileType() == 0)
    {
      List localList = auif.a(this.this$0, (atkw)localObject);
      if ((localList != null) && (localList.size() > 0)) {
        auif.a(this.this$0, (atkw)localObject, localList);
      }
    }
    for (;;)
    {
      if (((atkw)localObject).relatedType == 7)
      {
        localObject = (PadInfo)((atkw)localObject).fQ;
        auif.a(this.this$0).put(((PadInfo)localObject).pad_url, localObject);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ((atkw)localObject).n(auif.a(this.this$0), this.this$0.mContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auik
 * JD-Core Version:    0.7.0.1
 */