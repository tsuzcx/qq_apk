import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.QQAppInterface;

@TargetApi(14)
public class poq
  extends pos
{
  public pof a = new pof();
  public String path;
  public String vid;
  
  public poq(String paramString1, String paramString2)
  {
    this.vid = paramString1;
    this.path = paramString2;
  }
  
  private void bmc()
  {
    aool localaool = new aool();
    localaool.b = new por(this);
    localaool.dQ = this.path;
    localaool.cNy = true;
    localaool.mFileType = 196609;
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
      Object localObject = ((poj)psx.a(14)).a(this.vid);
      if (((poj.a)localObject).b.isSuccess())
      {
        this.path = ((poj.a)localObject).videoUrl;
        if ((TextUtils.isEmpty(this.path)) || (!rox.fileExistsAndNotEmpty(this.path)))
        {
          ram.w("Q.qqstory.publish.upload:StoryVideoFileObject  ", "end composite success but file not exist:%s", new Object[] { this.path });
          localObject = new ErrorMessage(940006, String.format("end composite success but file not exist:%s", new Object[] { this.path }));
          ((ErrorMessage)localObject).extraMsg = "composite";
          super.notifyResult(localObject);
        }
      }
      else
      {
        ((poj.a)localObject).b.extraMsg = "composite";
        super.notifyResult(((poj.a)localObject).b);
        return;
      }
    }
    poe.a().qX(this.vid);
    bmc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     poq
 * JD-Core Version:    0.7.0.1
 */