import com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel.IRequestHandler;
import java.util.Comparator;

public class ynv
  implements Comparator
{
  public ynv(CmGameCmdChannel paramCmGameCmdChannel) {}
  
  public int a(CmGameCmdChannel.IRequestHandler paramIRequestHandler1, CmGameCmdChannel.IRequestHandler paramIRequestHandler2)
  {
    return paramIRequestHandler1.a() - paramIRequestHandler2.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ynv
 * JD-Core Version:    0.7.0.1
 */