import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.predownload.ListenTogetherResDownloader.2.1;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class aiqb
  implements aolm.b
{
  aiqb(aipz paramaipz) {}
  
  public void onResp(aomh paramaomh)
  {
    boolean bool;
    Object localObject1;
    File localFile;
    int i;
    String str;
    label48:
    Object localObject2;
    if (paramaomh.mResult == 0)
    {
      bool = true;
      localObject1 = (aoll)paramaomh.b;
      localFile = new File(((aoll)localObject1).atY);
      i = paramaomh.mErrCode;
      if (paramaomh.clO != null) {
        break label164;
      }
      str = "0";
      localObject2 = (Object[])((aoll)localObject1).U();
      localObject1 = (MusicInfo)localObject2[0];
      localObject2 = (aipz.a)localObject2[1];
      if (!bool) {
        break label173;
      }
      ((aipz.a)localObject2).status = 2;
      this.a.cancel(((MusicInfo)localObject1).id);
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().post(new ListenTogetherResDownloader.2.1(this, paramaomh, bool, (MusicInfo)localObject1));
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.downloader", 2, String.format("onResp, errCode: %s, errDesc: %s, musicReqInfo: %s", new Object[] { Integer.valueOf(i), str, localObject2 }));
      }
      return;
      bool = false;
      break;
      label164:
      str = paramaomh.clO;
      break label48;
      label173:
      if ((localFile != null) && (localFile.exists())) {
        localFile.delete();
      }
      ((aipz.a)localObject2).status = 3;
      aipz.a(this.a, (MusicInfo)localObject1);
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiqb
 * JD-Core Version:    0.7.0.1
 */