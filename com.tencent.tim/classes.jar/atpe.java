import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.tim.filemanager.activity.TroopFileZipPreviewActivity;
import com.tencent.widget.XListView;
import java.util.List;

public class atpe
  implements smq.j
{
  public atpe(TroopFileZipPreviewActivity paramTroopFileZipPreviewActivity, FileManagerEntity paramFileManagerEntity) {}
  
  public void fe(List<agxi.a> paramList)
  {
    this.a.stopTitleProgress();
    if (paramList != null)
    {
      this.a.pw = paramList;
      paramList = new sms(paramList, this.a);
      paramList.filePath = (this.a.filePath + "/");
      paramList.nSessionId = this.a.nSessionId;
      paramList.troopUin = this.b.TroopUin;
      paramList.aEI = this.a.aEI;
      paramList.aEJ = this.a.aEJ;
      paramList.aEK = this.a.aEK;
      paramList.str_download_dns = this.a.str_download_dns;
      this.a.N.setAdapter(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atpe
 * JD-Core Version:    0.7.0.1
 */