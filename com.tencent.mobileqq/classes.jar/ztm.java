import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher;

public class ztm
  implements Runnable
{
  public ztm(SVIPHandler paramSVIPHandler, String paramString) {}
  
  public void run()
  {
    BubbleDiyFetcher localBubbleDiyFetcher = BubbleDiyFetcher.a();
    localBubbleDiyFetcher.a(this.jdField_a_of_type_ComTencentMobileqqAppSVIPHandler.b, this.jdField_a_of_type_JavaLangString, new ztn(this, localBubbleDiyFetcher));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ztm
 * JD-Core Version:    0.7.0.1
 */