import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.gameroom.GameQuickWordsPanel;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import java.util.ArrayList;

public class ajrx
  implements AdapterView.c
{
  public ajrx(GameQuickWordsPanel paramGameQuickWordsPanel) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (String)this.b.xZ.get(paramInt);
    paramView = new ujt.d();
    paramView.mMsgSignalNetType = aqiw.getSystemNetwork(BaseApplication.getContext());
    paramView.mMsgSendTime = System.currentTimeMillis();
    ujt.a(this.b.mApp, this.b.mApp.getApp(), this.b.sessionInfo, paramAdapterView, null, paramView);
    this.b.a.hideAllPanels();
    anot.a(this.b.mApp, "dc00899", "Grp_wolf", "", "in_game", "send_default", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajrx
 * JD-Core Version:    0.7.0.1
 */