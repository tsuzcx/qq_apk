import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import mqq.os.MqqHandler;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class afcx
  extends acgf
{
  public afcx(NearbyTransitActivity paramNearbyTransitActivity) {}
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, Boolean paramBoolean1)
  {
    afck.l("NearbyTransitActivity", new Object[] { "onJoinHotChat", Boolean.valueOf(NearbyTransitActivity.a(this.this$0)), Boolean.valueOf(paramBoolean), paramString1 });
    NearbyTransitActivity.ev("onJoinHotChat", 1);
    if (NearbyTransitActivity.a(this.this$0)) {
      return;
    }
    NearbyTransitActivity.a(this.this$0).removeMessages(2);
    NearbyTransitActivity.a(this.this$0).removeMessages(5);
    if (this.this$0.a != null) {
      this.this$0.a.dismiss();
    }
    paramBoolean1 = Message.obtain();
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString1))) {
      paramBoolean1.what = 3;
    }
    for (paramBoolean1.obj = new Object[] { paramString1, paramString2, paramString4 };; paramBoolean1.obj = paramString1)
    {
      NearbyTransitActivity.a(this.this$0).sendMessage(paramBoolean1);
      return;
      paramString1 = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        paramString1 = NearbyTransitActivity.aGn;
      }
      paramBoolean1.what = 1;
      paramBoolean1.arg1 = 11;
    }
  }
  
  public void a(boolean paramBoolean, HotChatInfo paramHotChatInfo, Common.WifiPOIInfo paramWifiPOIInfo, int paramInt, String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramHotChatInfo != null) {
        str = paramHotChatInfo.name;
      }
    }
    if ((NearbyTransitActivity.a(this.this$0) == 1) && (!aqft.equalsWithNullCheck(str, NearbyTransitActivity.a(this.this$0)))) {}
    do
    {
      return;
      NearbyTransitActivity.ev("onQuickJoinHotChat", 1);
      afck.l("NearbyTransitActivity", new Object[] { "onQuickJoinHotChat", Boolean.valueOf(NearbyTransitActivity.a(this.this$0)), Boolean.valueOf(paramBoolean), Integer.valueOf(NearbyTransitActivity.a(this.this$0)), Integer.valueOf(paramInt), str, paramHotChatInfo, paramWifiPOIInfo });
    } while (NearbyTransitActivity.a(this.this$0));
    NearbyTransitActivity.a(this.this$0).removeMessages(2);
    NearbyTransitActivity.a(this.this$0).removeMessages(5);
    if (this.this$0.a != null) {
      this.this$0.a.dismiss();
    }
    paramWifiPOIInfo = Message.obtain();
    if (paramBoolean) {
      if ((paramHotChatInfo != null) && ((paramInt == 1) || (paramInt == 2)))
      {
        paramWifiPOIInfo.what = 3;
        paramWifiPOIInfo.obj = new Object[] { paramHotChatInfo.troopUin, paramHotChatInfo.troopCode, paramHotChatInfo.name };
      }
    }
    while ((NearbyTransitActivity.b(this.this$0) == 1) && (paramWifiPOIInfo.what == 3) && (paramHotChatInfo.mFissionRoomNum > 0))
    {
      ajrk.m("NearbyTransitActivity", new Object[] { "onQuickJoinHotChat allocate room success,is to showing entering tip " });
      paramString = Message.obtain();
      paramString.what = 5;
      paramString.obj = String.format(this.this$0.getResources().getString(2131694652), new Object[] { Integer.valueOf(paramHotChatInfo.mFissionRoomNum) });
      NearbyTransitActivity.a(this.this$0).sendMessage(paramString);
      NearbyTransitActivity.a(this.this$0).sendMessageDelayed(paramWifiPOIInfo, 600L);
      return;
      paramWifiPOIInfo.what = 1;
      paramWifiPOIInfo.arg1 = 5;
      paramWifiPOIInfo.obj = NearbyTransitActivity.aGn;
      continue;
      paramWifiPOIInfo.what = 1;
      paramWifiPOIInfo.arg1 = (paramInt + 100);
      paramWifiPOIInfo.obj = ajpd.eC(paramInt);
    }
    NearbyTransitActivity.a(this.this$0).sendMessage(paramWifiPOIInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afcx
 * JD-Core Version:    0.7.0.1
 */