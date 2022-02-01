import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class agcj
  implements View.OnClickListener
{
  agcj(agci paramagci, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (agnh.a)this.val$view.getTag();
    this.a.this$0.cWH = ((agnh.a)localObject).cYf;
    localObject = (FileInfo)this.a.this$0.wA.get(this.a.this$0.cWH);
    if ((!ahbj.isFileExists(((FileInfo)localObject).getPath())) || (ahbj.deleteFile(((FileInfo)localObject).getPath())))
    {
      ahav.da(((FileInfo)localObject).getPath());
      this.a.this$0.wA.remove(this.a.this$0.cWH);
      LocalFileBrowserActivity.a(this.a.this$0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ahao.OS(2131693519);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agcj
 * JD-Core Version:    0.7.0.1
 */