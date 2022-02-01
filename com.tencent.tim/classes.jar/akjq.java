import android.util.Log;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.redtouch.NearbyOfficalReportHelper.1;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class akjq
{
  public static akjq a = new akjq();
  
  public static akjq a()
  {
    return a;
  }
  
  public void a(NearbyAppInterface paramNearbyAppInterface, String paramString1, String paramString2)
  {
    Object localObject = paramNearbyAppInterface.a().b();
    String str;
    if (((akju)localObject).num > 1)
    {
      paramNearbyAppInterface = "1";
      if (((akju)localObject).dna <= 0) {
        break label136;
      }
      str = "1";
      label33:
      if (((akju)localObject).dmZ <= 0) {
        break label143;
      }
    }
    label136:
    label143:
    for (localObject = "1";; localObject = "0")
    {
      anot.a(null, "dc00899", "grp_lbs", "", paramString1, paramString2, 0, 0, str, (String)localObject, "", paramNearbyAppInterface);
      Log.i(" NearbyRecommend", "reportNearByRedDotEvent op_type = " + paramString1 + " op_name = " + paramString2 + " d1 = " + str + " d2 = " + (String)localObject + " d4 = " + paramNearbyAppInterface);
      return;
      paramNearbyAppInterface = "0";
      break;
      str = "0";
      break label33;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, oidb_0x791.RedDotInfo paramRedDotInfo)
  {
    Object localObject = new akjs();
    ((akjs)localObject).h(paramRedDotInfo);
    if (((akjs)localObject).cst)
    {
      paramQQAppInterface = String.valueOf(ajrb.c(paramQQAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1)));
      paramRedDotInfo = String.valueOf(((akjs)localObject).user_type);
      localObject = String.valueOf(((akjs)localObject).content_type);
      anot.a(null, "dc00899", "grp_lbs", "", "entry", "official_push_received", 0, 0, paramQQAppInterface, paramRedDotInfo, (String)localObject, "");
      Log.i(" NearbyRecommend", "reportLebaRedDotReceive op_name = official_push_receivedd1 = " + paramQQAppInterface + " d2 = " + paramRedDotInfo + " d3 = " + (String)localObject);
    }
  }
  
  public void l(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    ThreadManagerV2.excute(new NearbyOfficalReportHelper.1(this, paramQQAppInterface, paramString1, paramString2), 16, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akjq
 * JD-Core Version:    0.7.0.1
 */