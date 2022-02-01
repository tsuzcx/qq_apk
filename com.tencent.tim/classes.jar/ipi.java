import com.tencent.av.VideoController;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;

public class ipi
{
  public static boolean a(PendantItem paramPendantItem1, PendantItem paramPendantItem2)
  {
    if ((paramPendantItem1 == null) && (paramPendantItem2 == null)) {}
    do
    {
      return true;
      if ((paramPendantItem1 == null) || (paramPendantItem2 == null)) {
        break;
      }
    } while ((paramPendantItem1.getId() == null) || (paramPendantItem2.getId() == null) || (paramPendantItem1.getId().equalsIgnoreCase(paramPendantItem2.getId())));
    return false;
    return false;
  }
  
  public static boolean a(FilterDesc paramFilterDesc1, FilterDesc paramFilterDesc2)
  {
    if ((paramFilterDesc1 == null) && (paramFilterDesc2 == null)) {}
    do
    {
      return true;
      if ((paramFilterDesc1 == null) || (paramFilterDesc2 == null)) {
        break;
      }
    } while ((paramFilterDesc1.name == null) || (paramFilterDesc2.name == null) || (paramFilterDesc1.name.equalsIgnoreCase(paramFilterDesc2.name)));
    return false;
    return false;
  }
  
  public static void iE(boolean paramBoolean)
  {
    VideoController.a().hL(paramBoolean);
    if (VideoController.a().kF() == VideoController.alK)
    {
      QLog.i("RenderUtils", 1, "setAEDetectInited, init FaceSDK falied.");
      irm.apN();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ipi
 * JD-Core Version:    0.7.0.1
 */