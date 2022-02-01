import com.tencent.biz.qcircleshadow.lib.delegate.IPluginInfoDelegate;
import java.util.List;

public class vvc
  implements IPluginInfoDelegate
{
  public List<String> getAllPluginInitInfo()
  {
    return vvj.a().a();
  }
  
  public String getCurrentPluginInfo()
  {
    if ((vvq.a().a() == null) || (vvq.a().a().a() == null)) {
      return "";
    }
    return vvq.a().a().a().toString();
  }
  
  public int getCurrentPluginVersion()
  {
    if ((vvq.a().a() == null) || (vvq.a().a().a() == null)) {
      return -1;
    }
    return vvq.a().a().a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvc
 * JD-Core Version:    0.7.0.1
 */