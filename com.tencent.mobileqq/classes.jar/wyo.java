import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterManager;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class wyo
  extends bdvu
{
  public wyo(ArtFilterManager paramArtFilterManager) {}
  
  public void onDone(bdvv parambdvv)
  {
    long l2 = -1L;
    super.onDone(parambdvv);
    Object localObject2 = parambdvv.a();
    if (localObject2 == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterManager", 2, "download bundle null");
      }
    }
    String str;
    Object localObject1;
    do
    {
      return;
      str = ((Bundle)localObject2).getString("url");
      localObject1 = ((Bundle)localObject2).getString("md5");
      localObject2 = ((Bundle)localObject2).getString("path");
      if ((str != null) && (localObject1 != null) && (localObject2 != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ArtFilterManager", 2, "download bundle parms null");
    return;
    if (parambdvv.a == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterManager", 2, "[onDone] download finished " + str);
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        this.a.a((String)localObject2);
      }
    }
    for (;;)
    {
      localObject1 = (bavr)ArtFilterManager.a(this.a).getManager(193);
      localObject2 = new File((String)localObject2);
      long l1 = l2;
      if (parambdvv.a == 0)
      {
        l1 = l2;
        if (((File)localObject2).exists()) {
          l1 = ((File)localObject2).length();
        }
      }
      ((bavr)localObject1).a(str, l1);
      return;
      if (((String)localObject1).equalsIgnoreCase(this.a.a((String)localObject2)))
      {
        this.a.a((String)localObject2);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArtFilterManager", 2, "[onDone] checkMd5 failed: " + (String)localObject2);
        }
        bdcs.d((String)localObject2);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ArtFilterManager", 2, "[onDone] downloadFile failed: " + parambdvv.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wyo
 * JD-Core Version:    0.7.0.1
 */