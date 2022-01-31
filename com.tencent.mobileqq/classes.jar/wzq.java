import WEISHI_USER_GROWTH.WEISHI.stGetPersonalPageRsp;
import java.lang.ref.WeakReference;

final class wzq
  implements wxx<WEISHI.stGetPersonalPageRsp>
{
  private final WeakReference<wzm> a;
  
  public wzq(wzm paramwzm)
  {
    this.a = new WeakReference(paramwzm);
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, WEISHI.stGetPersonalPageRsp paramstGetPersonalPageRsp)
  {
    paramString = (wzm)this.a.get();
    if (paramString == null) {}
    do
    {
      return;
      paramString.a(paramstGetPersonalPageRsp, false);
    } while (paramstGetPersonalPageRsp == null);
    wzm.a(paramString, paramstGetPersonalPageRsp.toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wzq
 * JD-Core Version:    0.7.0.1
 */