import android.os.Handler;
import android.view.View;
import com.tencent.biz.ui.CustomMenuBar.a;
import com.tencent.crmqq.structmsg.StructMsg.ButtonInfo;

class xws
  implements CustomMenuBar.a
{
  xws(xwq paramxwq) {}
  
  public void B(String paramString, int paramInt1, int paramInt2)
  {
    wja.bcO = true;
    this.a.xi.setVisibility(0);
    this.a.bV.sendEmptyMessageDelayed(0, 10000L);
    StructMsg.ButtonInfo localButtonInfo = this.a.a(paramInt1);
    afrx.a(this.a.app).a(paramString, this.a.a(), this.a.app, this.a.oL(), localButtonInfo);
    anot.a(this.a.app, "P_CliOper", "Bqq_Crm", "", "Aio_menu", "Clk_menu", 0, 0, this.a.oL(), paramInt1 + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xws
 * JD-Core Version:    0.7.0.1
 */