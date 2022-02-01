import BOSSStrategyCenter.tAdvDesc;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import org.json.JSONObject;

public class aajc
{
  public tAdvDesc b;
  public SparseArray<aajc.a> bR;
  public String bdl;
  private int chi;
  public int jumpType;
  public String jumpUrl;
  public int resType;
  public int taskId;
  
  public aajc(tAdvDesc paramtAdvDesc)
  {
    this.b = paramtAdvDesc;
    this.bR = new SparseArray();
    cuD();
  }
  
  public static aajc a(tAdvDesc paramtAdvDesc)
  {
    if ((paramtAdvDesc == null) || (TextUtils.isEmpty(paramtAdvDesc.res_data))) {
      return null;
    }
    switch (paramtAdvDesc.pattern_id)
    {
    default: 
      return null;
    case 1012: 
      return new aajc(paramtAdvDesc);
    case 1108: 
      return new awmm(paramtAdvDesc);
    }
    return new awmo(paramtAdvDesc);
  }
  
  boolean Ww()
  {
    return this.chi == 1;
  }
  
  public boolean Wx()
  {
    int i = 0;
    while (i < this.bR.size())
    {
      aajc.a locala = (aajc.a)this.bR.valueAt(i);
      if ((locala == null) || (TextUtils.isEmpty(locala.filePath)) || (!locala.isFileExist())) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public aaje a()
  {
    if ((this.b == null) || (TextUtils.isEmpty(this.b.res_data))) {
      return null;
    }
    switch (this.b.pattern_id)
    {
    default: 
      return null;
    case 1012: 
      return new aaje();
    case 1108: 
      return new awmn();
    }
    return new awmq();
  }
  
  protected void cuD()
  {
    if ((this.b == null) || (TextUtils.isEmpty(this.b.res_data)))
    {
      QLog.e("QbossADBannerConfigInfo", 1, "parseJsonFromAdvDesc error with data = null");
      return;
    }
    String str1 = this.b.res_data;
    try
    {
      Object localObject = new JSONObject(str1);
      int i = ((JSONObject)localObject).optInt("res_type");
      String str2 = ((JSONObject)localObject).optString("res_url");
      String str3 = ((JSONObject)localObject).optString("res_url_md5");
      int j = ((JSONObject)localObject).optInt("jump_type");
      String str4 = ((JSONObject)localObject).optString("jump_url");
      int k = ((JSONObject)localObject).optInt("WebViewPreloadFlag");
      if (QLog.isColorLevel()) {
        QLog.d("QbossADBannerManager", 2, "webViewPreloadFlag: " + k);
      }
      this.resType = i;
      this.jumpType = j;
      this.jumpUrl = str4;
      this.chi = k;
      this.bdl = this.b.res_traceinfo;
      this.taskId = this.b.task_id;
      localObject = new aajc.a();
      ((aajc.a)localObject).resUrl = str2;
      ((aajc.a)localObject).tT = str3;
      ((aajc.a)localObject).filePath = aajd.a().ii(str2);
      this.bR.put(1, localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("QbossADBannerConfigInfo", 1, "qboss banner parseJson error msg = " + localException.getMessage());
      avyz.a().s(2741, this.b.task_id, 102, "json parseError exception = " + localException.getMessage() + " json string = " + str1);
    }
  }
  
  public static class a
  {
    public String filePath;
    public String resUrl;
    public String tT;
    
    public void Co(boolean paramBoolean)
    {
      if (QZLog.isColorLevel()) {
        QZLog.i("QbossADBannerConfigInfo", 2, " qboss resources down response resUrl = " + this.resUrl + " isSuccess = " + paramBoolean);
      }
    }
    
    public boolean isFileExist()
    {
      if (TextUtils.isEmpty(this.filePath)) {
        return false;
      }
      return ahbj.isFileExists(this.filePath);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aajc
 * JD-Core Version:    0.7.0.1
 */