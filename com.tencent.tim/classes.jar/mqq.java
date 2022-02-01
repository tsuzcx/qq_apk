import android.annotation.SuppressLint;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class mqq
  implements mqn
{
  private mqm<String> a;
  private QQAppInterface app;
  @SuppressLint({"HandlerLeak"})
  private aook b = new mqr(this);
  private String localPath;
  private long uniSeq;
  
  public mqq(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private void aRv()
  {
    this.app.a().b(this.b);
  }
  
  public void a(mqm<String> parammqm)
  {
    this.a = parammqm;
  }
  
  public void nL(String paramString)
  {
    aooi localaooi = this.app.a();
    if (this.b.getFilter().size() == 0) {
      this.b.addFilter(new Class[] { aojg.class });
    }
    localaooi.a(this.b);
    aool localaool = new aool();
    localaool.cNy = true;
    localaool.dOM = 54;
    localaool.dQ = paramString;
    localaool.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localaool.mPeerUin = "0";
    localaool.mSelfUin = this.app.getCurrentAccountUin();
    localaool.mFileType = 24;
    localaool.ckW = "KandianUGCVideoUpload";
    localaooi.a(localaool);
    this.uniSeq = localaool.mUniseq;
    this.localPath = paramString;
    QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "upload, path=" + paramString + ",uniSeq=" + this.uniSeq);
  }
  
  public void nM(String paramString)
  {
    QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "resume, uploadKey=" + paramString);
    if (this.b.getFilter().isEmpty()) {
      this.b.addFilter(new Class[] { aojg.class });
    }
    aooi localaooi = this.app.a();
    localaooi.a(this.b);
    try
    {
      paramString = new JSONObject(paramString);
      if (this.uniSeq == 0L)
      {
        this.uniSeq = paramString.optInt("uniseq", 0);
        this.localPath = paramString.optString("localPath", "");
        QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "resume from app reboot");
      }
      paramString = (aojn)localaooi.a("0", this.uniSeq);
      if (paramString != null)
      {
        paramString.EN();
        return;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        QLog.e("RIJUGC.RIJUgcVideoUploader", 1, "resume, e=" + QLog.getStackTraceString(paramString));
      }
      nL(this.localPath);
    }
  }
  
  public void pause()
  {
    QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "pause, path=" + this.localPath + ",uniSeq=" + this.uniSeq);
    Object localObject = this.app.a();
    if (localObject != null)
    {
      localObject = (aojn)((aooi)localObject).a("0", this.uniSeq);
      if (localObject != null) {
        ((aojn)localObject).pause();
      }
    }
    aRv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mqq
 * JD-Core Version:    0.7.0.1
 */