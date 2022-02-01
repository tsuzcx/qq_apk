import android.content.Intent;
import android.os.Bundle;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import cooperation.weiyun.AlbumBackupProxyActivity;

public class agfd
  implements auuw.b
{
  public agfd(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void a(auuw.a parama)
  {
    switch (parama.id)
    {
    default: 
      return;
    case 0: 
      parama = new Intent(this.this$0.getApplicationContext(), LiteActivity.class);
      if (this.this$0.cdf) {
        ahau.JH("0X8005534");
      }
      for (;;)
      {
        try
        {
          Bundle localBundle = new Bundle();
          localBundle.putLong("category", 12);
          parama.putExtra("bundle", localBundle);
          parama.putExtra("from", "FileAssistant");
          this.this$0.startActivityForResult(parama, 101);
          return;
        }
        catch (Exception parama)
        {
          parama.printStackTrace();
          return;
        }
        ahau.JH("0X800681A");
      }
    case 1: 
      if (this.this$0.cdf) {
        ahau.JH("0X8005535");
      }
      for (;;)
      {
        FileAssistantActivity.b(this.this$0);
        return;
        ahau.JH("0X800681B");
      }
    case 2: 
      if (this.this$0.cdf) {
        ahau.JH("0X8005536");
      }
      for (;;)
      {
        AlbumBackupProxyActivity.i(this.this$0, this.this$0.app.getCurrentAccountUin(), "source_qfile_assistant", 10001);
        FileAssistantActivity.a(this.this$0, this.this$0.v, "100160.100162");
        return;
        ahau.JH("0X800681C");
      }
    case 3: 
      ahau.JH("0X800A15F");
      parama = new Bundle();
      parama.putString("url", "https://docs.qq.com/desktop/m/templates_list.html?padtype=0&_wv=2&_wwv=512");
      parama.putString("tdsourcetag", "s_qq_myfile_menu_create");
      TeamWorkDocEditBrowserActivity.a(this.this$0, parama, false);
      return;
    }
    ahau.JH("0X8005532");
    ahav.b(this.this$0.app, this.this$0, "_is_from_qfile_shortcut", this.this$0.getString(2131693537), 2130845217);
    ahao.OT(2131693584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agfd
 * JD-Core Version:    0.7.0.1
 */