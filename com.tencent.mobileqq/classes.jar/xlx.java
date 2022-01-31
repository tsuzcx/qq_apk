import android.content.Intent;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.richmedia.CompoundProcessor;
import com.tencent.mobileqq.richmedia.RichmediaClient;
import com.tencent.mobileqq.richmedia.VideoCompoundController;

public class xlx
  implements Runnable
{
  public xlx(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public void run()
  {
    Object localObject = RichmediaClient.a().a().a(this.a.a);
    if (localObject != null) {
      ((CompoundProcessor)localObject).a(103);
    }
    for (;;)
    {
      localObject = this.a.getIntent();
      ((Intent)localObject).putExtra("flow_back", 0);
      this.a.setResult(1001, (Intent)localObject);
      this.a.finish();
      return;
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xlx
 * JD-Core Version:    0.7.0.1
 */