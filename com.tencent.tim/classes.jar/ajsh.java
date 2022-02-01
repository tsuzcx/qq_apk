import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.a;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.b;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

public class ajsh
  implements ardq.a<oidb_0x8e4.RspBody>
{
  public ajsh(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if ((paramInt == 0) || (paramInt == 1004))
    {
      this.this$0.mGameRoomAVController.dyZ();
      aqmj.a(this.this$0, this.this$0.app.getCurrentAccountUin(), false, System.currentTimeMillis());
      this.this$0.ni = true;
      this.this$0.mOwnerUin = this.this$0.app.getLongAccountUin();
      this.this$0.OG = null;
      GameRoomInviteActivity.bSp = null;
      this.this$0.mUsers = null;
      this.this$0.jq.setVisibility(8);
      if (this.this$0.DB != null) {
        this.this$0.DB.clear();
      }
      this.this$0.uY = false;
      this.this$0.refreshUI();
      paramRspBody = this.this$0.a();
      if ((paramRspBody != null) && (paramRspBody.isPrepared)) {
        QQToast.a(this.this$0, acfp.m(2131706758), 0).show();
      }
      this.this$0.a.notifyDataSetChanged();
      this.this$0.EL.setVisibility(8);
    }
    for (;;)
    {
      this.this$0.EL.setEnabled(true);
      return;
      this.this$0.a(paramInt, paramRspBody, (String)GameRoomInviteActivity.cY.get(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajsh
 * JD-Core Version:    0.7.0.1
 */