import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.qphone.base.util.QLog;

public class vuo
  extends TroopObserver
{
  public vuo(HotChatPie paramHotChatPie) {}
  
  protected void c(boolean paramBoolean, String paramString)
  {
    if ((this.a.s != 2) && (paramBoolean) && (this.a.b != null) && (this.a.a != null) && (this.a.a.troopUin.equals(paramString)) && (this.a.a.hasPostRedPoint())) {
      this.a.b.a(true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseTroopChatPieQ.hotchat.aio_post_red_point", 2, "onBuluoHotChatRedPointComing, troopUin:" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vuo
 * JD-Core Version:    0.7.0.1
 */