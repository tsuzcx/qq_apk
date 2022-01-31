import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.apollo.view.QQFrameZipDecoder;

public class tje
  implements Runnable
{
  public tje(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    QQSettingMe.a(this.a).setGifData(100, null, ApolloConstant.ad, QQFrameZipDecoder.a(ApolloConstant.ad), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tje
 * JD-Core Version:    0.7.0.1
 */