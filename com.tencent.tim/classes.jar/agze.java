import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class agze
  extends agzi
{
  private int cWz;
  private String mPeerUin;
  private long mSessionId;
  
  public agze(FileManagerEntity paramFileManagerEntity)
  {
    this.mSessionId = paramFileManagerEntity.nSessionId;
    this.cWz = paramFileManagerEntity.peerType;
    this.mPeerUin = paramFileManagerEntity.peerUin;
  }
  
  public String vU()
  {
    if ((this.mSessionId == 0L) || (TextUtils.isEmpty(this.mPeerUin)))
    {
      QLog.e("OfflineFileControlReq<QFile>", 1, "key params is null");
      return "";
    }
    return C(this.cWz + "", this.mPeerUin, this.mSessionId + "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agze
 * JD-Core Version:    0.7.0.1
 */