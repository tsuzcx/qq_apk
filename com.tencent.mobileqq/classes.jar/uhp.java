import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.qwallet.elem.BaseRedPkgElem;

public class uhp
  extends QQLruCache
{
  public uhp(CustomizeStrategyFactory paramCustomizeStrategyFactory, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  protected void a(boolean paramBoolean, String paramString, BaseRedPkgElem paramBaseRedPkgElem1, BaseRedPkgElem paramBaseRedPkgElem2)
  {
    super.entryRemoved(paramBoolean, paramString, paramBaseRedPkgElem1, paramBaseRedPkgElem2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uhp
 * JD-Core Version:    0.7.0.1
 */