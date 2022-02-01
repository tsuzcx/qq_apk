import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.d;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aaej
  implements PreloadManager.d
{
  aaej(aaeh paramaaeh, boolean paramBoolean, aaeh.a parama) {}
  
  private void ctR()
  {
    if (this.bvi)
    {
      String str = zyn.getString("", "key_draw_hb_last_succ_model", "");
      if (!TextUtils.isEmpty(str)) {
        aaeh.a(this.this$0, str, this.a, false);
      }
    }
    while (this.a == null) {
      return;
    }
    this.a.onInit(false);
  }
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      try
      {
        String str1 = new File(paramPathResult.folderPath, "quickDraw.tflite").toString();
        String str2 = new File(paramPathResult.folderPath, "classes.txt").toString();
        if ((!new File(str1).exists()) || (!new File(str2).exists()))
        {
          QLog.e("DrawClassifier", 1, "init fail file not exist");
          ctR();
          return;
        }
        aaeh.a(this.this$0, new aaed(str1, str2));
        if (this.a != null) {
          this.a.onInit(true);
        }
        zyn.putString("", "key_draw_hb_last_succ_model", paramPathResult.url);
        aaeh.a(this.this$0, true);
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("DrawClassifier", 2, "init success");
        return;
      }
      catch (Throwable paramPathResult)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DrawClassifier", 2, "init recog fail:" + paramPathResult);
        }
        paramPathResult.printStackTrace();
        ctR();
        return;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("DrawClassifier", 2, "init download fail");
      }
      ctR();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaej
 * JD-Core Version:    0.7.0.1
 */