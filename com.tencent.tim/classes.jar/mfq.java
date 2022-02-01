import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.ReqBody;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

public class mfq
  extends accg
{
  public mfq(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a(SkinData paramSkinData, GuideData paramGuideData1, RefreshData paramRefreshData, GuideData paramGuideData2, int paramInt)
  {
    paramGuideData1 = new oidb_0x5bd.ReqBody();
    paramGuideData1.uint64_uin.set(this.app.getLongAccountUin(), true);
    paramGuideData1.uint32_source.set(paramInt);
    if (paramSkinData != null) {
      paramGuideData1.msg_current_skin_info.set(paramSkinData.toBody(), true);
    }
    if (paramRefreshData != null) {
      paramGuideData1.msg_current_refresh_info.set(paramRefreshData.toRefreshInfoBody(), true);
    }
    if (paramGuideData2 != null) {
      paramGuideData1.msg_current_guide_info.set(paramGuideData2.toBody(), true);
    }
    jnm.a(this.app, new mfr(this), paramGuideData1.toByteArray(), "OidbSvc.0x5bd_1", 1469, 1, new Bundle(), 6000L);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return mfq.a.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public static class a
    implements acci
  {
    public void a(boolean paramBoolean, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo1, oidb_0x5bd.GuideInfo paramGuideInfo2, oidb_0x5bd.RefreshInfo paramRefreshInfo, int paramInt) {}
    
    public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
    {
      switch (paramInt)
      {
      default: 
        return;
      }
      paramObject = (Object[])paramObject;
      a(paramBoolean, (oidb_0x5bd.SkinInfo)paramObject[0], (oidb_0x5bd.GuideInfo)paramObject[1], (oidb_0x5bd.GuideInfo)paramObject[2], (oidb_0x5bd.RefreshInfo)paramObject[3], ((Integer)paramObject[4]).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mfq
 * JD-Core Version:    0.7.0.1
 */