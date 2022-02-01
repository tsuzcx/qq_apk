import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class abfs
  implements View.OnClickListener
{
  abfs(abfr paramabfr) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof abfr.b)))
    {
      localObject = (abfr.b)localObject;
      aprg.H(abfr.a(this.this$0), abfr.a(this.this$0), ((abfr.b)localObject).uin);
      aptw localaptw = (aptw)abfr.a(this.this$0).getManager(203);
      if ((localaptw != null) && (localaptw.e(abfr.a(this.this$0), ((abfr.b)localObject).uin, abfr.a(this.this$0)))) {
        localaptw.ba(abfr.a(this.this$0), ((abfr.b)localObject).uin);
      }
      if (abfr.a(this.this$0) != null) {
        break label121;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label121:
      anot.a(abfr.a(this.this$0).app, "dc00898", "", "", "", "0X8009F9F", 0, 0, ((abfr.b)localObject).uin, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abfs
 * JD-Core Version:    0.7.0.1
 */