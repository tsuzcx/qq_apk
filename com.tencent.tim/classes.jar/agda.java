import com.tencent.mobileqq.filemanager.activity.TroopFileZipPreviewActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.widget.XListView;
import java.util.List;

public class agda
  implements smq.j
{
  public agda(TroopFileZipPreviewActivity paramTroopFileZipPreviewActivity, FileManagerEntity paramFileManagerEntity) {}
  
  public void fe(List<agxi.a> paramList)
  {
    this.a.stopTitleProgress();
    if (paramList != null)
    {
      this.a.pw = paramList;
      this.a.b = new sms(paramList, this.a);
      this.a.b.filePath = (this.a.filePath + "/");
      this.a.b.nSessionId = this.a.nSessionId;
      this.a.b.troopUin = this.b.TroopUin;
      this.a.b.aEI = this.a.aEI;
      this.a.b.aEJ = this.a.aEJ;
      this.a.b.aEK = this.a.aEK;
      this.a.b.str_download_dns = this.a.str_download_dns;
      this.a.b.a(this.a.mIsHttps, this.a.aEL, this.a.H);
      this.a.N.setAdapter(this.a.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agda
 * JD-Core Version:    0.7.0.1
 */