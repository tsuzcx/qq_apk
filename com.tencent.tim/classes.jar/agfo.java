import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agfo
  implements View.OnClickListener
{
  public agfo(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(QfileBaseLocalFileTabView.TAG, 2, "qfilebaserecenttabview del error, tag is null");
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    FileInfo localFileInfo = (FileInfo)paramView.getTag();
    if (localFileInfo != null)
    {
      if (this.this$0.b != null) {
        this.this$0.b.bk(null);
      }
      if (!ahbj.deleteFile(localFileInfo.getPath())) {
        break label108;
      }
      this.this$0.b(localFileInfo);
    }
    for (;;)
    {
      this.this$0.b.bk(Integer.valueOf(-1));
      paramView.setVisibility(4);
      this.this$0.refreshList();
      break;
      label108:
      String str = QfileBaseLocalFileTabView.a(this.this$0).getString(2131693521);
      ahao.JD(ahav.kY(localFileInfo.getName()) + str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agfo
 * JD-Core Version:    0.7.0.1
 */