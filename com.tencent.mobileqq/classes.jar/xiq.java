import WEISHI_USER_GROWTH.WEISHI.stGetPersonalPageRsp;
import java.lang.ref.WeakReference;

final class xiq
  implements xgx<WEISHI.stGetPersonalPageRsp>
{
  private final WeakReference<xim> a;
  
  public xiq(xim paramxim)
  {
    this.a = new WeakReference(paramxim);
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, WEISHI.stGetPersonalPageRsp paramstGetPersonalPageRsp)
  {
    paramString = (xim)this.a.get();
    if (paramString == null) {}
    do
    {
      return;
      paramString.a(paramstGetPersonalPageRsp, false);
    } while (paramstGetPersonalPageRsp == null);
    xim.a(paramString, paramstGetPersonalPageRsp.toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xiq
 * JD-Core Version:    0.7.0.1
 */