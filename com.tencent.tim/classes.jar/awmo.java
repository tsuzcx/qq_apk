import BOSSStrategyCenter.tAdvDesc;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import org.json.JSONObject;

public class awmo
  extends aajc
{
  public String auH;
  public String cRA;
  public String cRB;
  public String cRC;
  public String cRv;
  public String cRw;
  
  public awmo(tAdvDesc paramtAdvDesc)
  {
    super(paramtAdvDesc);
  }
  
  protected void cuD()
  {
    super.cuD();
    if ((this.b == null) || (TextUtils.isEmpty(this.b.res_data)))
    {
      QLog.e("QbossADBannerConfigInfo", 1, "parseJsonFromAdvDesc error with data = null");
      return;
    }
    String str = this.b.res_data;
    try
    {
      Object localObject = new JSONObject(str);
      this.cRv = ((JSONObject)localObject).optString("topText");
      this.cRw = ((JSONObject)localObject).optString("bottomText");
      this.auH = ((JSONObject)localObject).optString("textColor");
      this.cRA = ((JSONObject)localObject).optString("cartoon");
      this.cRB = ((JSONObject)localObject).optString("cartoon_md5");
      this.cRC = ((JSONObject)localObject).optString("cartoonNum");
      localObject = new awmo.a(null);
      ((aajc.a)localObject).resUrl = this.cRA;
      ((aajc.a)localObject).tT = this.cRB;
      if (!TextUtils.isEmpty(this.cRA)) {
        ((aajc.a)localObject).filePath = (QzoneZipCacheHelper.getBasePath("qboss_banner", String.valueOf(this.cRA.hashCode())) + ".zip");
      }
      this.bR.put(2, localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("QbossADBannerConfigInfo", 1, "qboss banner parseJson error msg = " + localException.getMessage());
      avyz.a().s(2741, this.b.task_id, 102, "CountDownBanner json parseError exception = " + localException.getMessage() + " json string = " + str);
    }
  }
  
  class a
    extends aajc.a
  {
    private a() {}
    
    public void Co(boolean paramBoolean)
    {
      super.Co(paramBoolean);
      if ((paramBoolean) && (ahbj.isFileExists(this.filePath)))
      {
        String str = QzoneZipCacheHelper.getBasePath("qboss_banner", String.valueOf(awmo.this.cRA.hashCode()));
        File localFile = new File(this.filePath);
        QzoneZipCacheHelper.unzipFile(localFile.getAbsolutePath(), str);
        if (localFile.exists()) {
          ahbj.deleteFile(localFile);
        }
        this.filePath = str;
        if (QZLog.isColorLevel()) {
          QZLog.i("QbossADBannerConfigInfo", 2, "zip success = pathDir = " + str);
        }
      }
    }
    
    public boolean isFileExist()
    {
      if ((TextUtils.isEmpty(this.filePath)) || (TextUtils.isEmpty(awmo.this.cRA))) {}
      String str;
      Object localObject;
      do
      {
        do
        {
          return false;
          str = QzoneZipCacheHelper.getBasePath("qboss_banner", String.valueOf(awmo.this.cRA.hashCode()));
          localObject = new File(str);
        } while ((!((File)localObject).exists()) || (!((File)localObject).isDirectory()));
        localObject = ((File)localObject).listFiles();
      } while ((localObject == null) || (localObject.length <= 0));
      this.filePath = str;
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awmo
 * JD-Core Version:    0.7.0.1
 */