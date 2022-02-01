import GROUP.MessageRemindRsp;
import MQQ.GetRoamToastRsp;
import QC.BubbleRecommendRsp;
import QC.FaceRsp;
import QC.FontRecommendRsp;
import QC.SetFontBubbleRsp;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class aclh
  implements acci
{
  public void JT(int paramInt) {}
  
  public void a(boolean paramBoolean, MessageRemindRsp paramMessageRemindRsp) {}
  
  public void a(boolean paramBoolean, GetRoamToastRsp paramGetRoamToastRsp) {}
  
  public void a(boolean paramBoolean, BubbleRecommendRsp paramBubbleRecommendRsp) {}
  
  public void a(boolean paramBoolean, FaceRsp paramFaceRsp) {}
  
  public void a(boolean paramBoolean, FontRecommendRsp paramFontRecommendRsp) {}
  
  public void a(boolean paramBoolean, SetFontBubbleRsp paramSetFontBubbleRsp, int paramInt) {}
  
  public void aF(boolean paramBoolean, Object paramObject) {}
  
  public void aG(boolean paramBoolean, Object paramObject) {}
  
  public void aH(boolean paramBoolean, Object paramObject) {}
  
  public void aI(boolean paramBoolean, Object paramObject) {}
  
  public void bPd() {}
  
  public void ci(Bundle paramBundle) {}
  
  public void cj(String paramString, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
    case 101: 
      do
      {
        return;
        if ((paramObject instanceof Integer))
        {
          JT(((Integer)paramObject).intValue());
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.e("SVIPObserver", 2, "NOTIFY_TYPE_SVIP_BUBBLE_CHANGE param error");
      return;
    case 100: 
      bPd();
      return;
    case 102: 
      aF(paramBoolean, paramObject);
      return;
    case 103: 
      aG(paramBoolean, paramObject);
      return;
    case 104: 
      aH(paramBoolean, paramObject);
      return;
    case 105: 
      y(paramBoolean, paramObject);
      return;
    case 106: 
      aI(paramBoolean, paramObject);
      return;
    case 113: 
      a(paramBoolean, (MessageRemindRsp)paramObject);
      return;
    case 107: 
      a(paramBoolean, (FontRecommendRsp)paramObject);
      return;
    case 108: 
      a(paramBoolean, (BubbleRecommendRsp)paramObject);
      return;
    case 109: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (SetFontBubbleRsp)paramObject[0], ((Integer)paramObject[1]).intValue());
      return;
    case 110: 
      ci((Bundle)paramObject);
      return;
    case 111: 
      a(paramBoolean, (GetRoamToastRsp)paramObject);
      return;
    case 112: 
      a(paramBoolean, (FaceRsp)paramObject);
      return;
    }
    paramObject = (Object[])paramObject;
    cj((String)paramObject[0], ((Integer)paramObject[1]).intValue());
  }
  
  public void y(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aclh
 * JD-Core Version:    0.7.0.1
 */