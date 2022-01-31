import android.content.Intent;
import com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoHelper;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.richmedia.CompoundProcessor;
import com.tencent.mobileqq.richmedia.RichmediaClient;
import com.tencent.mobileqq.richmedia.VideoCompoundController;

public class xwv
  implements Runnable
{
  public xwv(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    Object localObject = RichmediaClient.a().a().a(this.a.d);
    if (localObject != null) {
      ((CompoundProcessor)localObject).a(103);
    }
    for (;;)
    {
      localObject = this.a.getIntent();
      ((Intent)localObject).putExtra("flow_back", 0);
      this.a.setResult(1001, (Intent)localObject);
      this.a.a.b();
      this.a.finish();
      return;
      this.a.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xwv
 * JD-Core Version:    0.7.0.1
 */