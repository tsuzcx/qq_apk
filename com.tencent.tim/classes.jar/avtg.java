import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.contentbox.MsgPhotoView;

public class avtg
  implements View.OnClickListener
{
  public avtg(MsgPhotoView paramMsgPhotoView) {}
  
  public void onClick(View paramView)
  {
    if (MsgPhotoView.a(this.this$0) != null)
    {
      if (paramView != MsgPhotoView.a(this.this$0)) {
        break label50;
      }
      MsgPhotoView.a(this.this$0).a(this.this$0.a, paramView, 1);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label50:
      if (paramView == MsgPhotoView.b(this.this$0)) {
        MsgPhotoView.a(this.this$0).a(this.this$0.a, paramView, 2);
      } else if (paramView == MsgPhotoView.c(this.this$0)) {
        MsgPhotoView.a(this.this$0).a(this.this$0.a, paramView, 3);
      } else if (paramView == MsgPhotoView.d(this.this$0)) {
        MsgPhotoView.a(this.this$0).a(this.this$0.a, paramView, 4);
      } else {
        MsgPhotoView.a(this.this$0).a(this.this$0.a, paramView, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avtg
 * JD-Core Version:    0.7.0.1
 */