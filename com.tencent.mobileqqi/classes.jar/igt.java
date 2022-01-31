import cooperation.qzone.QzoneCommonProxyActivity;
import cooperation.qzone.QzoneGPUPluginProxyActivity;
import cooperation.qzone.QzonePictureExtPluginProxyActivity;
import cooperation.qzone.QzonePicturePluginProxyActivity;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.QzoneTransNoTitlePluginProxyActivity;
import cooperation.qzone.QzoneTransWithKeyboardPluginProxyActivity;

public class igt
{
  public static Class a()
  {
    return QzoneCommonProxyActivity.class;
  }
  
  public static Class a(String paramString)
  {
    if (QzonePluginProxyActivity.a(QzonePluginProxyActivity.a(), paramString)) {
      return QzonePicturePluginProxyActivity.class;
    }
    if (QzonePluginProxyActivity.a(QzonePluginProxyActivity.b(), paramString)) {
      return QzoneTransNoTitlePluginProxyActivity.class;
    }
    if ("com.qzone.common.activities.FeedActionPanelActivity".equals(paramString)) {
      return QzoneTransWithKeyboardPluginProxyActivity.class;
    }
    if ("com.qzone.face.ui.QzoneMarkFaceActivity".equals(paramString)) {
      return QzonePictureExtPluginProxyActivity.class;
    }
    return QzoneGPUPluginProxyActivity.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     igt
 * JD-Core Version:    0.7.0.1
 */