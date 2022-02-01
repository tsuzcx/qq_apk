import android.view.View;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.tim.filemanager.activity.LocalFileBrowserActivity;
import java.util.ArrayList;

public class atos
  implements ausj.a
{
  public atos(LocalFileBrowserActivity paramLocalFileBrowserActivity, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.val$sheet.dismiss();
      return;
      if (this.this$0.cWH != -1)
      {
        paramView = (FileInfo)this.this$0.wA.get(this.this$0.cWH);
        if ((!aueh.isFileExists(paramView.getPath())) || (aueh.deleteFile(paramView.getPath())))
        {
          audx.da(paramView.getPath());
          this.this$0.wA.remove(this.this$0.cWH);
          LocalFileBrowserActivity.a(this.this$0);
        }
        else
        {
          auds.OS(2131693519);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atos
 * JD-Core Version:    0.7.0.1
 */