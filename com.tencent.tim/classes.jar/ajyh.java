import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajyh
  implements AdapterView.OnItemClickListener
{
  public ajyh(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ShortVideoCommentsView.a(this.this$0, (Comments.Comment)paramAdapterView.getAdapter().getItem(paramInt));
    if (ShortVideoCommentsView.a(this.this$0) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      long l = this.this$0.app.getLongAccountUin();
      if (ShortVideoCommentsView.a(this.this$0).uid == l)
      {
        this.this$0.showToast(acfp.m(2131714516));
        ShortVideoCommentsView.a(this.this$0, null);
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("回复 ");
        if (ShortVideoCommentsView.a(this.this$0).name.length() >= 6)
        {
          localStringBuilder.append(ShortVideoCommentsView.a(this.this$0).name.substring(0, 5));
          localStringBuilder.append("...");
        }
        for (;;)
        {
          ShortVideoCommentsView.a(this.this$0).setText("");
          ShortVideoCommentsView.a(this.this$0).setHint(localStringBuilder);
          if (!ShortVideoCommentsView.f(this.this$0)) {
            break label222;
          }
          this.this$0.bhj();
          break;
          localStringBuilder.append(ShortVideoCommentsView.a(this.this$0).name);
        }
        label222:
        ShortVideoCommentsView.a(this.this$0, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajyh
 * JD-Core Version:    0.7.0.1
 */