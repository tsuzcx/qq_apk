import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher;

public class zmq
  implements Runnable
{
  public zmq(SVIPHandler paramSVIPHandler, String paramString) {}
  
  public void run()
  {
    BubbleDiyFetcher localBubbleDiyFetcher = BubbleDiyFetcher.a();
    localBubbleDiyFetcher.a(this.jdField_a_of_type_ComTencentMobileqqAppSVIPHandler.b, this.jdField_a_of_type_JavaLangString, new zmr(this, localBubbleDiyFetcher));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zmq
 * JD-Core Version:    0.7.0.1
 */