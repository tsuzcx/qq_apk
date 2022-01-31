import com.tencent.mobileqq.activity.richmedia.subtitles.RDBaseDataManager;
import com.tencent.mobileqq.activity.richmedia.subtitles.RDConfigServletProxy.RDConfigServletProxyListener;

public class xta
  implements RDConfigServletProxy.RDConfigServletProxyListener
{
  public xta(RDBaseDataManager paramRDBaseDataManager) {}
  
  public boolean a(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
  {
    if ((paramInt1 != this.a.a) && (this.a.a != 0)) {
      return false;
    }
    return RDBaseDataManager.a(this.a, paramInt1, paramInt2, paramString, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xta
 * JD-Core Version:    0.7.0.1
 */