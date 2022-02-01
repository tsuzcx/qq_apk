import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.3.1;
import com.tencent.mobileqq.nearby.now.view.widget.LikeAniView;

public class akar
  implements GestureDetector.OnDoubleTapListener
{
  akar(ajzv paramajzv) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (System.currentTimeMillis() - ajzv.a(this.this$0) >= 500L)
    {
      int i = (int)paramMotionEvent.getRawX();
      int j = (int)paramMotionEvent.getRawY();
      if ((this.this$0.b != null) && (this.this$0.b.type != 6)) {
        ((LikeAniView)this.this$0.Fb.findViewById(2131370435)).iT(i, j);
      }
      if (!ajzv.a(this.this$0)) {
        break label98;
      }
    }
    for (;;)
    {
      ajzv.a(this.this$0, System.currentTimeMillis());
      return true;
      label98:
      if ((!ajzv.b(this.this$0)) && (this.this$0.Fb.findViewById(2131370435).getVisibility() == 0))
      {
        ajzv.a(this.this$0, false);
        this.this$0.hn(null);
        new ajxs().h("video").i("playpage_double_click").b().dy(this.this$0.app);
        ThreadManagerV2.excute(new PlayOperationViewModel.3.1(this, (ajpj)this.this$0.app.getManager(106)), 16, null, false);
      }
    }
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akar
 * JD-Core Version:    0.7.0.1
 */