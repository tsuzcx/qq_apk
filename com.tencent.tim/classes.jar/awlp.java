import android.content.Context;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.apollo.view.ApolloLottieAnim;
import com.tencent.mobileqq.app.QQAppInterface;

public class awlp
  extends ApolloLottieAnim
{
  private Downloader mDownloader;
  
  public awlp(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
    this.mDownloader = DownloaderFactory.getInstance(paramContext).getCommonDownloader();
  }
  
  public void P(String paramString1, String paramString2, String paramString3)
  {
    this.mState = 1;
    paramString3 = new awlq(this, paramString2, paramString3);
    this.mDownloader.download(paramString1, paramString2, false, paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awlp
 * JD-Core Version:    0.7.0.1
 */