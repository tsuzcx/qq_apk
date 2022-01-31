import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import java.util.HashMap;

public class bpf
  extends Thread
{
  public bpf(Share paramShare, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void run()
  {
    Object localObject = new HashMap();
    if (this.jdField_a_of_type_Boolean) {
      ((HashMap)localObject).put("url", this.jdField_a_of_type_JavaLangString);
    }
    localObject = HttpUtil.a((HashMap)localObject);
    if (this.jdField_a_of_type_Boolean) {}
    for (localObject = (String)((HashMap)localObject).get("url");; localObject = this.jdField_a_of_type_JavaLangString)
    {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a.runOnUiThread(new bpg(this, (String)localObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bpf
 * JD-Core Version:    0.7.0.1
 */