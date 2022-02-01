import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class sde
  implements View.OnClickListener
{
  sde(scw.d paramd, CertifiedAccountMeta.StComment paramStComment) {}
  
  public void onClick(View paramView)
  {
    if (scw.a(this.b.this$0) != null)
    {
      scw.a(this.b.this$0, scw.a(this.b.this$0).a(scw.a(this.b.this$0), this.f));
      scw.c(this.b.this$0, true);
    }
    scw.a(this.b.this$0).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sde
 * JD-Core Version:    0.7.0.1
 */