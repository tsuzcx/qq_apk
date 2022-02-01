import android.view.View;
import java.util.Map;

class lwn
  implements lwm.a
{
  lwn(lwm paramlwm) {}
  
  public void a(View paramView, Map<String, Object> paramMap)
  {
    if (paramView.getId() == 2131381256) {
      this.this$0.cE(paramView);
    }
    do
    {
      return;
      if (paramView != this.this$0.a) {
        break;
      }
      paramView = this.this$0.d.a();
    } while (paramView == null);
    paramView.onRefresh();
    return;
    this.this$0.b(paramView, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lwn
 * JD-Core Version:    0.7.0.1
 */