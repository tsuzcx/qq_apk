import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.widget.QFavDownloadProgressDialog;
import com.tencent.mobileqq.widget.QFavDownloadProgressDialog.Callback;
import cooperation.plugin.IPluginManager;

public final class fjt
  implements QFavDownloadProgressDialog.Callback
{
  public fjt(String paramString, QFavDownloadProgressDialog paramQFavDownloadProgressDialog) {}
  
  public void a()
  {
    IPluginManager.a().cancelInstall(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQFavDownloadProgressDialog.dismiss();
  }
  
  public void b()
  {
    IPluginManager.a().cancelInstall(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQFavDownloadProgressDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fjt
 * JD-Core Version:    0.7.0.1
 */