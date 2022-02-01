import android.content.Context;
import android.text.TextUtils;
import cooperation.qqpim.QQPimTipsInfo;

public class avlr
{
  public static void a(Context paramContext, QQPimTipsInfo paramQQPimTipsInfo)
  {
    if (paramQQPimTipsInfo == null)
    {
      avlp.G(paramContext, "QQPIM_TIPS_CLICK", System.currentTimeMillis());
      return;
    }
    avlp.aq(paramContext, "QQPIM_TIPS_CLICK" + paramQQPimTipsInfo.tipsType, paramQQPimTipsInfo.cMb + ";" + paramQQPimTipsInfo.ext + ";" + System.currentTimeMillis());
  }
  
  public static void b(Context paramContext, QQPimTipsInfo paramQQPimTipsInfo)
  {
    if (paramQQPimTipsInfo == null) {}
    while (TextUtils.isEmpty(avlp.au(paramContext, "QQPIM_TIPS_CLICK" + paramQQPimTipsInfo.tipsType))) {
      return;
    }
    switch (paramQQPimTipsInfo.tipsType)
    {
    case 3: 
    default: 
      return;
    case 1: 
      paramQQPimTipsInfo.bF = 0;
      return;
    case 2: 
      paramQQPimTipsInfo.bF = 0;
      return;
    }
    paramQQPimTipsInfo.bF = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avlr
 * JD-Core Version:    0.7.0.1
 */