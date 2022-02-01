import android.view.View;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;

public class agcf
  implements ausj.a
{
  public agcf(LocalFileBrowserActivity paramLocalFileBrowserActivity, ausj paramausj) {}
  
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
        if ((!ahbj.isFileExists(paramView.getPath())) || (ahbj.deleteFile(paramView.getPath())))
        {
          ahav.da(paramView.getPath());
          this.this$0.wA.remove(this.this$0.cWH);
          LocalFileBrowserActivity.a(this.this$0);
        }
        else
        {
          ahao.OS(2131693519);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agcf
 * JD-Core Version:    0.7.0.1
 */