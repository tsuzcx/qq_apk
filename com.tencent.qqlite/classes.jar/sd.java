import com.tencent.biz.webviewplugin.QzonePlugin;
import com.tencent.smtt.sdk.WebView;

public class sd
  implements Runnable
{
  public sd(QzonePlugin paramQzonePlugin, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (QzonePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginQzonePlugin) != null) {
      QzonePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginQzonePlugin).postUrl(QzonePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginQzonePlugin), this.jdField_a_of_type_ArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     sd
 * JD-Core Version:    0.7.0.1
 */