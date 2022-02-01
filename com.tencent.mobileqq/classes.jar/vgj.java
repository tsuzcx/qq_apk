import com.tencent.biz.qcircleshadow.lib.delegate.IPluginInfoDelegate;
import java.util.List;

public class vgj
  implements IPluginInfoDelegate
{
  public List<String> getAllPluginInitInfo()
  {
    return vgp.a().a();
  }
  
  public String getCurrentPluginInfo()
  {
    if ((vgw.a().a() == null) || (vgw.a().a().a() == null)) {
      return "";
    }
    return vgw.a().a().a().toString();
  }
  
  public int getCurrentPluginVersion()
  {
    if ((vgw.a().a() == null) || (vgw.a().a().a() == null)) {
      return -1;
    }
    return vgw.a().a().a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgj
 * JD-Core Version:    0.7.0.1
 */