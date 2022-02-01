import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;

public class qbw
  extends qdh
{
  private String awG;
  
  public qbw()
  {
    a(false, true);
  }
  
  public boolean Jp()
  {
    return !TextUtils.isEmpty(this.awG);
  }
  
  protected void M(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramMap.containsKey("UploadImageJob_in_image_file_path"))) {
      this.awG = ((String)k("UploadImageJob_in_image_file_path"));
    }
  }
  
  public void bnE()
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    aooi localaooi = localQQAppInterface.a();
    aool localaool = new aool();
    localaool.b = new qbx(this);
    localaool.dQ = this.awG;
    localaool.cNy = true;
    localaool.mFileType = 196610;
    localaool.mSelfUin = localQQAppInterface.getCurrentUin();
    localaool.mPeerUin = "";
    localaool.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localaooi.a(localaool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qbw
 * JD-Core Version:    0.7.0.1
 */