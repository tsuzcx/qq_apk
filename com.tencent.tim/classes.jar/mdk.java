import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.OpenRedPacketResultStruct;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.d;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.g;
import com.tencent.common.app.BaseApplicationImpl;

public class mdk
  implements RIJRedPacketManager.d
{
  public mdk(RIJRedPacketManager paramRIJRedPacketManager, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, String paramString2, RIJRedPacketManager.g paramg) {}
  
  public void a(int paramInt, long paramLong, String paramString1, mdp parammdp, String paramString2, String paramString3, String paramString4)
  {
    if (paramInt == 0)
    {
      paramString4 = kgw.a(this.val$activity, 17);
      RIJRedPacketManager.OpenRedPacketResultStruct localOpenRedPacketResultStruct = new RIJRedPacketManager.OpenRedPacketResultStruct();
      localOpenRedPacketResultStruct.uP = paramLong;
      localOpenRedPacketResultStruct.agh = paramString1;
      if (parammdp != null)
      {
        localOpenRedPacketResultStruct.amc = true;
        localOpenRedPacketResultStruct.agi = parammdp.avatarUrl;
        localOpenRedPacketResultStruct.agj = parammdp.nickName;
        localOpenRedPacketResultStruct.agk = parammdp.wording;
      }
      for (;;)
      {
        localOpenRedPacketResultStruct.buttonWording = paramString2;
        localOpenRedPacketResultStruct.agl = paramString3;
        paramString4.putExtra("key_open_red_packet_result", localOpenRedPacketResultStruct);
        paramString4.putExtra("redpackid", this.agg);
        paramString4.putExtra("share_source_from_content", this.aQz);
        paramString4.putExtra("redpack_type", 2);
        paramString4.putExtra("plat_source", this.aQA);
        paramString4.putExtra("roykey", this.Vw);
        this.val$activity.startActivity(paramString4);
        return;
        localOpenRedPacketResultStruct.amc = false;
      }
    }
    this.a.showToast(paramString4);
  }
  
  public void aOI()
  {
    this.a.showToast(BaseApplicationImpl.getApplication().getString(2131718495));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mdk
 * JD-Core Version:    0.7.0.1
 */