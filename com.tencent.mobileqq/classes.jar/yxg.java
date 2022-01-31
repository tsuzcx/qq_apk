import WEISHI_USER_GROWTH.WEISHI.stGetPersonalPageRsp;
import java.lang.ref.WeakReference;

final class yxg
  implements yvn<WEISHI.stGetPersonalPageRsp>
{
  private final WeakReference<yxc> a;
  
  public yxg(yxc paramyxc)
  {
    this.a = new WeakReference(paramyxc);
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, WEISHI.stGetPersonalPageRsp paramstGetPersonalPageRsp)
  {
    paramString = (yxc)this.a.get();
    if (paramString == null) {}
    do
    {
      return;
      paramString.a(paramstGetPersonalPageRsp, false);
    } while (paramstGetPersonalPageRsp == null);
    yxc.a(paramString, paramstGetPersonalPageRsp.toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yxg
 * JD-Core Version:    0.7.0.1
 */