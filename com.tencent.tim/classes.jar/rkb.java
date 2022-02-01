import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.MusicProviderView;
import java.io.File;

public class rkb
{
  public static void b(BaseActivity paramBaseActivity, int paramInt)
  {
    paramInt = MusicProviderView.lU(paramInt);
    Intent localIntent = new Intent(paramBaseActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s", new Object[] { aqgz.getIMEI(), "", Integer.valueOf(paramInt) }));
    localIntent.putExtra("finish_animation_up_down", true);
    paramBaseActivity.startActivityForResult(localIntent, 1000);
    paramBaseActivity.overridePendingTransition(2130771991, 0);
    if (QLog.isColorLevel()) {
      QLog.d("MusicUtils", 1, new Object[] { "music busType:", Integer.valueOf(paramInt) });
    }
  }
  
  public static final String gh(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new NullPointerException("MusicComposeDialog.createMusicFilePath() musicUrl is null");
    }
    File localFile = new File(plr.atd);
    if ((!localFile.exists()) || (!localFile.isDirectory())) {
      localFile.mkdirs();
    }
    paramString = plr.atd + atad.toMD5(paramString) + "." + rox.getFileExtensionFromUrl(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "createMusicFilePath destPath = " + paramString);
    }
    return paramString;
  }
  
  public static final String i(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= 86400000) {
      return "unknow";
    }
    int i = (int)Math.floor(paramInt / 3600000);
    int j = (int)Math.floor(paramInt % 3600000) / 60000;
    if (paramBoolean) {}
    for (paramInt = Math.round(paramInt % 60000 / 1000.0F); i > 0; paramInt = (int)Math.floor(paramInt % 60000 / 1000)) {
      return String.format("%02d:%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt) });
    }
    return String.format("%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rkb
 * JD-Core Version:    0.7.0.1
 */