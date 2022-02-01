import android.widget.ImageView;
import com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView;
import com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView.2;
import com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView.2.1.1;
import com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView.2.1.2;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class sij
  implements aolm.b
{
  public sij(AbsSubscribeShareCardView.2 param2) {}
  
  public void onResp(aomh paramaomh)
  {
    if (paramaomh.mResult == 0)
    {
      ((ImageView)this.a.ob.get(this.a.bwX)).setImageBitmap(SafeBitmapFactory.decodeFile(this.a.val$outPath));
      AbsSubscribeShareCardView.a(this.a.this$0);
      if (AbsSubscribeShareCardView.b(this.a.this$0) == this.a.gr.size()) {
        ThreadManager.getUIHandler().post(new AbsSubscribeShareCardView.2.1.1(this));
      }
      return;
    }
    ThreadManager.getUIHandler().post(new AbsSubscribeShareCardView.2.1.2(this));
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sij
 * JD-Core Version:    0.7.0.1
 */