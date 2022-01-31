import com.tencent.biz.webviewplugin.QzonePlugin;
import com.tencent.smtt.sdk.WebView;

public class bov
  implements Runnable
{
  public bov(QzonePlugin paramQzonePlugin, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (QzonePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginQzonePlugin) != null) {
      QzonePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginQzonePlugin).postUrl(QzonePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginQzonePlugin), this.jdField_a_of_type_ArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bov
 * JD-Core Version:    0.7.0.1
 */