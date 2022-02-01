import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeSwitcher;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine.TagItemInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class aqsu
  extends aqsm
{
  public static final aqsu a = new aqsu();
  
  protected void _onCompleted(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (!ThemeUtil.isIOSTheme(paramString1))
    {
      ThemeSwitcher.onComplete(paramString1, paramInt1);
      if (paramInt1 != 0)
      {
        paramQQAppInterface = ThemeUtil.getIDFromSCID(paramString1);
        aqri.a(null, "individual_v2_theme_download_fail", String.valueOf(paramInt1), "from" + paramString3 + ",httpCode=" + paramInt2 + ",errorCode:" + paramInt1 + ", scid:" + paramString1 + ", cfgScid:" + paramString2, paramQQAppInterface, String.valueOf(paramInt2), null, 0.0F, 0.0F);
        paramQQAppInterface = new HashMap();
        paramQQAppInterface.put("reportKey", "errorCode:" + paramInt1);
        anpc.a(BaseApplication.getContext()).collectPerformance("", "individual_v2_theme_download_fail", false, 0L, -1L, paramQQAppInterface, "", true);
      }
      return;
    }
    QLog.e("ThemeUpdateCallback", 1, "onCompleted ignore ios theme:" + paramString1);
  }
  
  protected void _onProgress(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    if (!ThemeUtil.isIOSTheme(paramString1)) {
      ThemeSwitcher.onProgress(paramString1, paramLong2, paramLong3);
    }
  }
  
  public boolean deleteFiles(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    if (paramQQAppInterface != null) {
      if (!ThemeUtil.isIOSTheme(paramString))
      {
        Object localObject = ThemeUtil.getIDFromSCID(paramString);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = new aogy().a((String)localObject);
          if (paramString.startsWith("theme.android.")) {}
          for (paramQQAppInterface = ((aogy)localObject).a(paramQQAppInterface.getApp(), paramString, "").getZipPath();; paramQQAppInterface = ((aogy)localObject).aS(paramQQAppInterface.getApp()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ThemeUpdateCallback", 2, "deleteFiles: " + paramQQAppInterface);
            }
            return new File(paramQQAppInterface).delete();
          }
        }
      }
      else
      {
        QLog.e("ThemeUpdateCallback", 1, "deleteFiles ignore ios theme:" + paramString);
      }
    }
    return false;
  }
  
  public long getBID()
  {
    return 3L;
  }
  
  public VasQuickUpdateEngine.TagItemInfo getItemInfo(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      VasQuickUpdateEngine.TagItemInfo localTagItemInfo;
      if ("theme_mapping_config_android".equals(paramString))
      {
        localTagItemInfo = new VasQuickUpdateEngine.TagItemInfo();
        localTagItemInfo.bPreConfig = false;
        localTagItemInfo.bSaveInDir = false;
        localTagItemInfo.strSavePath = getSavePath(paramQQAppInterface.getApp(), paramString);
        return localTagItemInfo;
      }
      if (!ThemeUtil.isIOSTheme(paramString))
      {
        Object localObject = ThemeUtil.getIDFromSCID(paramString);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localTagItemInfo = new VasQuickUpdateEngine.TagItemInfo();
          localObject = new aogy().a((String)localObject);
          if (paramString.startsWith("theme.android."))
          {
            localTagItemInfo.bPreConfig = false;
            localTagItemInfo.bSaveInDir = false;
            localTagItemInfo.strSavePath = ((aogy)localObject).a(paramQQAppInterface.getApp(), paramString, "").getZipPath();
            return localTagItemInfo;
          }
          localTagItemInfo.bPreConfig = true;
          localTagItemInfo.bSaveInDir = false;
          localTagItemInfo.strSavePath = ((aogy)localObject).aS(paramQQAppInterface.getApp());
          return localTagItemInfo;
        }
      }
      else
      {
        QLog.e("ThemeUpdateCallback", 1, "getItemInfo ignore ios theme:" + paramString);
      }
    }
    return null;
  }
  
  public boolean isFileExists(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    if ((paramQQAppInterface != null) && (!ThemeUtil.isIOSTheme(paramString)))
    {
      Object localObject = ThemeUtil.getIDFromSCID(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new aogy().a((String)localObject);
        if (paramString.startsWith("theme.android.")) {}
        for (paramQQAppInterface = ((aogy)localObject).a(paramQQAppInterface.getApp(), paramString, "").getZipPath();; paramQQAppInterface = ((aogy)localObject).aS(paramQQAppInterface.getApp())) {
          return new File(paramQQAppInterface).exists();
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqsu
 * JD-Core Version:    0.7.0.1
 */