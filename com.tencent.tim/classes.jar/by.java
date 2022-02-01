import android.content.Intent;
import android.view.View;
import com.dataline.activities.LiteAdvanceActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

public class by
  implements ausj.a
{
  public by(LiteAdvanceActivity paramLiteAdvanceActivity, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.b.cancel();
      return;
      anpb.F(this.a.app.getApplication().getApplicationContext(), this.a.app.getCurrentAccountUin(), "dl_ckclearmsg");
      paramView = (acde)this.a.app.getBusinessHandler(8);
      paramView.bm(32, true);
      paramView.cIi();
      this.a.app.b().a(this.a.cM).Bh();
      this.a.getIntent().putExtra("clear_flag", true);
      this.a.setResult(-1, this.a.getIntent());
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     by
 * JD-Core Version:    0.7.0.1
 */