import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aldx
{
  public static boolean W(Context paramContext, String paramString)
  {
    if ("cardWZ.zip".equals(paramString))
    {
      String str = aE(paramContext);
      paramContext = new File(str, "xydata.json");
      if (aldw.a == null) {
        aldw.iU(paramContext.getAbsolutePath());
      }
      if (aldw.a != null)
      {
        paramContext = new File(str, "logo.png");
        paramString = new File(str, "bgImage.jpg");
        Object localObject = new File(str, "shimmer_mask.png");
        File localFile1 = new File(str, "logo_bg.png");
        File localFile2 = new File(str, "font_chs.tff");
        File localFile3 = new File(str, "font_num.tff");
        File localFile4 = new File(str, "addIcon.png");
        int i;
        if ((paramContext.exists()) && (paramString.exists()) && (((File)localObject).exists()) && (localFile1.exists()) && (localFile2.exists()) && (localFile3.exists()) && (localFile4.exists()))
        {
          bool1 = true;
          localObject = aldw.a;
          if (((aldw)localObject).dh == null) {
            break label338;
          }
          i = 0;
          label207:
          bool2 = bool1;
          if (i >= ((aldw)localObject).dh.size()) {
            break label341;
          }
          paramContext = (aldw.a)((aldw)localObject).dh.valueAt(i);
          bool2 = bool1;
          if (paramContext.a != null)
          {
            bool2 = bool1;
            if (!TextUtils.isEmpty(paramContext.a.src))
            {
              paramString = paramContext.a.src;
              paramContext = paramString;
              if (paramString.contains("/")) {
                paramContext = paramString.substring(paramString.lastIndexOf("/"));
              }
              paramContext = new File(str, paramContext);
              if ((!bool1) || (!paramContext.exists())) {
                break label333;
              }
            }
          }
        }
        label333:
        for (boolean bool1 = true;; bool1 = false)
        {
          bool2 = bool1;
          i += 1;
          bool1 = bool2;
          break label207;
          bool1 = false;
          break;
        }
      }
    }
    label338:
    boolean bool2 = false;
    label341:
    return bool2;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, VasQuickUpdateManager.CallBacker paramCallBacker)
  {
    paramQQAppInterface = (VasQuickUpdateManager)paramQQAppInterface.getManager(184);
    paramQQAppInterface.addCallBacker(paramCallBacker);
    paramQQAppInterface.downloadItem(15L, "cardWZ.zip", "ProfileCard");
  }
  
  public static String aE(Context paramContext)
  {
    return aqep.aY(paramContext) + "wzryTemplate/";
  }
  
  public static boolean cz(long paramLong)
  {
    return (paramLong == alcs.agl) || (paramLong == alcs.agm);
  }
  
  public static void l(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (paramInt == 0) {
      if ("cardWZ.zip".equals(paramString1))
      {
        paramQQAppInterface = aE(paramQQAppInterface.getApp()) + "xydata.json";
        aldw.iU(paramQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("VipWZRYTemplateHelper", 2, "onDownloadComplete, parseConfig " + paramQQAppInterface);
        }
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("VipWZRYTemplateHelper", 2, "onDownloadComplete failed, errorCode = " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aldx
 * JD-Core Version:    0.7.0.1
 */