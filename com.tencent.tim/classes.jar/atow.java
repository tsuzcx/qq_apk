import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.LocalFileBrowserActivity;
import java.util.ArrayList;

class atow
  implements View.OnClickListener
{
  atow(atov paramatov, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (atwf.a)this.val$view.getTag();
    this.a.this$0.cWH = ((atwf.a)localObject).cYf;
    localObject = (FileInfo)this.a.this$0.wA.get(this.a.this$0.cWH);
    if ((!aueh.isFileExists(((FileInfo)localObject).getPath())) || (aueh.deleteFile(((FileInfo)localObject).getPath())))
    {
      audx.da(((FileInfo)localObject).getPath());
      this.a.this$0.wA.remove(this.a.this$0.cWH);
      LocalFileBrowserActivity.a(this.a.this$0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      auds.OS(2131693519);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atow
 * JD-Core Version:    0.7.0.1
 */