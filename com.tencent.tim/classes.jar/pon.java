import android.annotation.TargetApi;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.utils.pngquant.PngQuantUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.io.IOException;

@TargetApi(14)
public class pon
  extends pos
{
  private final aooi a;
  private final boolean aBa;
  public String aud;
  public String path;
  
  public pon(boolean paramBoolean)
  {
    this.aBa = paramBoolean;
    QQStoryContext.a();
    this.a = QQStoryContext.a().a();
  }
  
  private void bmc()
  {
    aool localaool = new aool();
    localaool.b = new poo(this);
    localaool.dQ = this.path;
    localaool.cNy = true;
    localaool.mFileType = 196610;
    QQStoryContext.a();
    localaool.mSelfUin = QQStoryContext.a().getCurrentUin();
    localaool.mPeerUin = "";
    localaool.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    this.a.a(localaool);
  }
  
  protected void startUpload()
  {
    File localFile2 = new File(this.path);
    if ((!localFile2.exists()) || (localFile2.length() == 0L)) {
      ram.e("Q.qqstory.publish.upload:ImageFileObject", "file not exit %s", new Object[] { this.path });
    }
    Object localObject;
    if ((this.aBa) && (PngQuantUtils.LX())) {
      localObject = null;
    }
    try
    {
      File localFile1 = File.createTempFile("temp", "png", localFile2.getParentFile());
      localObject = localFile1;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ram.w("Q.qqstory.publish.upload:ImageFileObject", "create file", localIOException);
      }
    }
    if (PngQuantUtils.e(localFile2, localObject))
    {
      localFile2.delete();
      localObject.renameTo(localFile2);
    }
    bmc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pon
 * JD-Core Version:    0.7.0.1
 */