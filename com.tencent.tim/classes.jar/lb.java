import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.etrump.mixlayout.ETEngine;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class lb
{
  public static AtomicBoolean M = new AtomicBoolean(false);
  
  public static boolean aC()
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = BaseApplication.getContext().getSharedPreferences("early_qq.android.native.vipfont.v5", 4).getBoolean("vip_font_so_downloaded", false);
      if (QLog.isColorLevel()) {
        QLog.d("VipFontSoLoader", 2, "VipFontData in sp: vip_font_so_downloaded=" + bool2);
      }
      if (bool2)
      {
        String str = aqnl.getSoDir();
        bool1 = new File(str + "libvipfont808.so").exists();
      }
      return bool1;
    }
    finally {}
  }
  
  public static boolean aD()
  {
    try
    {
      boolean bool = M.get();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean aF()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = BaseApplicationImpl.getApplication();
        if (localObject1 == null)
        {
          bool = false;
          return bool;
        }
        switch (aqnl.af(aqnl.getSoDir(), "libvipfont808.so"))
        {
        case 1: 
          localObject1 = BaseApplicationImpl.getApplication().getRuntime();
          if (!(localObject1 instanceof QQAppInterface)) {
            break label250;
          }
          QQAppInterface localQQAppInterface = (QQAppInterface)localObject1;
          ((VasQuickUpdateManager)localQQAppInterface.getManager(184)).downloadItem(1004L, "libVipFont_808", "FontManager_initHYEngine");
          localObject1 = ((acff)localQQAppInterface.getManager(51)).a(localQQAppInterface.getAccount());
          if ((localObject1 != null) && (0L != ((ExtensionInfo)localObject1).uVipFont) && (((ExtensionInfo)localObject1).vipFontType == 1))
          {
            localObject1 = "0";
            anot.a(localQQAppInterface, "CliOper", "", "", "Font_Mall", "0X80072C8", 0, 0, "1", (String)localObject1, "", "");
            if (!QLog.isColorLevel()) {
              break label250;
            }
            QLog.d("VipFontSoLoader", 2, "VipFontReport: early download start, restartDownload=true, type=" + (String)localObject1);
          }
          break;
        }
      }
      finally {}
      String str = "1";
      continue;
      ETEngine.isSOLoaded.set(true);
      ahxo.a().dqG();
      M.set(true);
      BaseApplication.getContext().getSharedPreferences("early_qq.android.native.vipfont.v5", 4).edit().putBoolean("vip_font_so_downloaded", true).commit();
      boolean bool = true;
      continue;
      label250:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lb
 * JD-Core Version:    0.7.0.1
 */