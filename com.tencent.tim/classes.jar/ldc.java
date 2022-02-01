import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJSkinOperationPopupStep.5.1;
import com.tencent.mobileqq.app.ThreadManager;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

public class ldc
  extends mfq.a
{
  ldc(lcz paramlcz) {}
  
  public void a(boolean paramBoolean, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo1, oidb_0x5bd.GuideInfo paramGuideInfo2, oidb_0x5bd.RefreshInfo paramRefreshInfo, int paramInt)
  {
    if ((paramBoolean) && (paramInt == 0)) {
      ThreadManager.excute(new RIJSkinOperationPopupStep.5.1(this, paramGuideInfo2, paramInt, paramRefreshInfo, paramSkinInfo, paramGuideInfo1), 16, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ldc
 * JD-Core Version:    0.7.0.1
 */