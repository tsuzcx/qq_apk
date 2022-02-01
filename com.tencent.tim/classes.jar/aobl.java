import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.manager.Manager;

public class aobl
  implements Manager
{
  private static String cjL = "https://pub.idqqimg.com/pc/misc/files/20180403/29c998e16c094b10a96b3e0d1589c2f6.png";
  private static String cjM = "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png";
  private static String cjN = "https://pub.idqqimg.com/pc/misc/files/20180410/1fce078ca2434b18bfec613961d526ff.png";
  private static String cjO = "https://pub.idqqimg.com/pc/misc/files/20180410/5349bc325950481ebde04c38208d9028.png";
  QQAppInterface app;
  
  public aobl(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public static String AA()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("tencentdoc_url_config", 4);
    if (localSharedPreferences != null) {
      cjO = localSharedPreferences.getString("tencentdoc_pre_img_url_miniproj_sheet", "https://pub.idqqimg.com/pc/misc/files/20180410/5349bc325950481ebde04c38208d9028.png");
    }
    return cjO;
  }
  
  public static String Ax()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("tencentdoc_url_config", 4);
    if (localSharedPreferences != null) {
      cjL = localSharedPreferences.getString("tencentdoc_pre_img_url_doc", "https://pub.idqqimg.com/pc/misc/files/20180403/29c998e16c094b10a96b3e0d1589c2f6.png");
    }
    return cjL;
  }
  
  public static String Ay()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("tencentdoc_url_config", 4);
    if (localSharedPreferences != null) {
      cjM = localSharedPreferences.getString("tencentdoc_pre_img_url_sheet", "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png");
    }
    return cjM;
  }
  
  public static String Az()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("tencentdoc_url_config", 4);
    if (localSharedPreferences != null) {
      cjN = localSharedPreferences.getString("tencentdoc_pre_img_url_miniproj_doc", "https://pub.idqqimg.com/pc/misc/files/20180410/1fce078ca2434b18bfec613961d526ff.png");
    }
    return cjN;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aobl
 * JD-Core Version:    0.7.0.1
 */