import WEISHI_USER_GROWTH.WEISHI.stGetPersonalPageRsp;
import java.lang.ref.WeakReference;

final class xin
  implements xgu<WEISHI.stGetPersonalPageRsp>
{
  private final WeakReference<xij> a;
  
  public xin(xij paramxij)
  {
    this.a = new WeakReference(paramxij);
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, WEISHI.stGetPersonalPageRsp paramstGetPersonalPageRsp)
  {
    paramString = (xij)this.a.get();
    if (paramString == null) {}
    do
    {
      return;
      paramString.a(paramstGetPersonalPageRsp, false);
    } while (paramstGetPersonalPageRsp == null);
    xij.a(paramString, paramstGetPersonalPageRsp.toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xin
 * JD-Core Version:    0.7.0.1
 */