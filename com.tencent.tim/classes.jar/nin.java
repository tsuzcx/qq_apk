import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.29.1;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.29.2;
import com.tencent.qphone.base.util.QLog;

public class nin
  implements auuw.b
{
  public nin(ReadinjoyTabFrame paramReadinjoyTabFrame, Activity paramActivity) {}
  
  public void a(auuw.a parama)
  {
    switch (parama.id)
    {
    default: 
      QLog.e("ReadInJoyTabFrame", 1, "popupMenuDialog click, not support id, id=" + parama.id);
      return;
    case 0: 
      nhr.a(this.this$0.a(), new ReadinjoyTabFrame.29.1(this));
      return;
    case 1: 
      nhr.a(this.this$0.a(), new ReadinjoyTabFrame.29.2(this));
      return;
    case 2: 
      mix.Q(this.this$0.a(), 1);
      ReadinjoyTabFrame.e(this.this$0);
      return;
    }
    mix.a(this.this$0.a(), null, 1);
    ReadinjoyTabFrame.f(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nin
 * JD-Core Version:    0.7.0.1
 */