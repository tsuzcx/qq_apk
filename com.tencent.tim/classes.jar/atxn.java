import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

final class atxn
  implements View.OnClickListener
{
  atxn(FileManagerEntity paramFileManagerEntity, agsa paramagsa) {}
  
  public void onClick(View paramView)
  {
    try
    {
      MessageForTroopFile localMessageForTroopFile = new MessageForTroopFile();
      localMessageForTroopFile.frienduin = this.k.peerUin;
      localMessageForTroopFile.bisID = this.k.busId;
      localMessageForTroopFile.url = this.k.strTroopFilePath;
      localMessageForTroopFile.fileName = this.k.fileName;
      localMessageForTroopFile.fileSize = this.k.fileSize;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localMessageForTroopFile);
      apsv.p(this.d.getApp(), localArrayList);
      label92:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label92;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atxn
 * JD-Core Version:    0.7.0.1
 */