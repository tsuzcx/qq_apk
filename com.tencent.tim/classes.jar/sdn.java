import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.subscribe.comment.EmoView;
import com.tencent.biz.subscribe.comment.EmoView.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sdn
  implements AdapterView.OnItemClickListener
{
  public sdn(EmoView paramEmoView, int paramInt) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramInt == 27)
    {
      if (EmoView.a(this.this$0) != null) {
        bool1 = EmoView.a(this.this$0).MD();
      }
      if (!bool1) {
        EmoView.b(this.this$0).MD();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      int i = (this.val$page - 1) * 27 + paramInt;
      if (i < 107)
      {
        String str = sdy.EMO_FAST_SYMBOL[sdq.ex[i]];
        bool1 = bool2;
        if (EmoView.a(this.this$0) != null) {
          bool1 = EmoView.a(this.this$0).fT(str);
        }
        if (!bool1) {
          EmoView.b(this.this$0).fT(str);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sdn
 * JD-Core Version:    0.7.0.1
 */