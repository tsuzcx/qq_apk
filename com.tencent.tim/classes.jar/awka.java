import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadVideoThumbJob;
import cooperation.troop_homework.jsp.TroopHWJsPlugin.a;
import cooperation.troop_homework.jsp.TroopHWJsPlugin.b;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class awka
  implements awjs.b
{
  public awka(TroopHWJsPlugin.b paramb) {}
  
  public void onComplete(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHWJsPlugin", 2, "onComplete id = " + this.a.id + " url = " + paramString);
    }
    if (this.a.type == 0) {}
    for (int i = 11;; i = 0)
    {
      Object localObject = "uploaded";
      if (this.a.type == 2) {
        localObject = "uploading";
      }
      localObject = this.a.this$0.a(this.a.b.cQV, this.a.id, this.a.type, (String)localObject, paramString, i);
      this.a.videoUrl = paramString;
      do
      {
        for (;;)
        {
          try
          {
            ((JSONObject)localObject).put("result", 0);
            if (2 == this.a.type)
            {
              ((JSONObject)localObject).put("progress", 0.949999988079071D);
              if (this.a.type != 2) {
                this.a.this$0.callJs(this.a.b.mCallback, new String[] { ((JSONObject)localObject).toString() });
              }
              this.a.isUploading = false;
              if (!this.a.cS.get()) {
                break;
              }
              return;
            }
            if (this.a.type == 1)
            {
              ((JSONObject)localObject).put("progress", 1.0D);
              ((JSONObject)localObject).put("size", "[0,400,694,1000]");
              continue;
            }
            if (this.a.type != 0) {
              continue;
            }
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            return;
          }
          ((JSONObject)localObject).put("progress", 1.0D);
        }
      } while (this.a.type != 2);
      paramString = new awkb(this);
      ThreadManager.postImmediately(new TroopHWJsPlugin.UploadVideoThumbJob(this.a.this$0, this.a, paramString, TroopHWJsPlugin.a(this.a.this$0)), null, false);
      return;
    }
  }
  
  public void onError(int paramInt)
  {
    QLog.d("TroopHWJsPlugin", 1, "upload failed! errorCode = " + paramInt);
    this.a.isUploading = false;
    JSONObject localJSONObject = this.a.this$0.a(this.a.b.cQV, this.a.id, this.a.type, "uploaded", "", 0);
    try
    {
      localJSONObject.put("result", paramInt);
      this.a.this$0.callJs(this.a.b.mCallback, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("TroopHWJsPlugin", 1, "upload error!", localException);
      }
    }
  }
  
  public void onProgress(int paramInt)
  {
    JSONObject localJSONObject = this.a.this$0.a(this.a.b.cQV, this.a.id, this.a.type, "uploading", "", 0);
    try
    {
      if (this.a.type == 2)
      {
        float f2 = paramInt / 100.0F * 0.85F + 0.1F;
        f1 = f2;
        if (f2 <= 1.0F) {}
      }
      for (float f1 = 1.0F;; f1 = paramInt / 100.0F)
      {
        localJSONObject.put("progress", f1);
        if (QLog.isDevelopLevel()) {
          QLog.d("TroopHWJsPlugin", 4, "id = " + this.a.id + " progress = " + paramInt + " realProgress = " + f1);
        }
        this.a.this$0.callJs(this.a.b.mCallback, new String[] { localJSONObject.toString() });
        this.a.isUploading = true;
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awka
 * JD-Core Version:    0.7.0.1
 */