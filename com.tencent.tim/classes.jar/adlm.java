import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

public class adlm
  implements TencentMap.OnCameraChangeListener
{
  public adlm(ARScanEntryView paramARScanEntryView) {}
  
  public void onCameraChange(CameraPosition paramCameraPosition) {}
  
  public void onCameraChangeFinished(CameraPosition paramCameraPosition)
  {
    if ((ARScanEntryView.a(this.this$0) != null) && (QLog.isColorLevel())) {
      QLog.d("AREngine_ARScanEntryView", 2, "ARLBSPOIDialog onCameraChangeFinish");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adlm
 * JD-Core Version:    0.7.0.1
 */