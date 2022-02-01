import com.tencent.common.app.AppInterface;
import mqq.manager.Manager;

public class aomf
  implements Manager
{
  public aolm f;
  public aolm g;
  
  public aolm a(AppInterface paramAppInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.f == null) {}
      try
      {
        if (this.f == null) {
          this.f = new aomj(paramAppInterface.getHttpCommunicatort(), false);
        }
        return this.f;
      }
      finally {}
    }
    return null;
  }
  
  public void onDestroy()
  {
    if (this.f != null) {
      ((aomj)this.f).destroy();
    }
    if (this.g != null) {
      ((aomj)this.g).destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aomf
 * JD-Core Version:    0.7.0.1
 */