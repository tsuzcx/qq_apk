import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.QQAppInterface;

public class aori
  extends pos
{
  public pof a = new pof();
  public String path;
  
  public aori(String paramString)
  {
    this.path = paramString;
  }
  
  private void bmc()
  {
    aool localaool = new aool();
    localaool.b = new aorj(this);
    localaool.dQ = this.path;
    localaool.cNy = true;
    localaool.mFileType = 327681;
    QQStoryContext.a();
    localaool.mSelfUin = QQStoryContext.a().getCurrentUin();
    localaool.mPeerUin = "";
    localaool.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    QQStoryContext.a();
    QQStoryContext.a().a().a(localaool);
  }
  
  protected void startUpload()
  {
    if ((TextUtils.isEmpty(this.path)) || (!rox.fileExistsAndNotEmpty(this.path)))
    {
      ram.w("tribe_publish_TribeVideoFileObject", "end composite success but file not exist:%s", new Object[] { this.path });
      super.notifyResult(new ErrorMessage(940006, String.format("end composite success but file not exist:%s", new Object[] { this.path })));
      return;
    }
    bmc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aori
 * JD-Core Version:    0.7.0.1
 */