import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agux
  implements View.OnClickListener
{
  agux(aguu paramaguu, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    anot.a(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
    ahbr.a(this.this$0.mAppInterface, this.this$0.mContext, this.g.TroopUin, this.g.strTroopFileID, this.g.strTroopFilePath, this.g.fileName, this.g.fileSize, this.g.busId);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agux
 * JD-Core Version:    0.7.0.1
 */