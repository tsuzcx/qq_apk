import android.app.Activity;
import android.content.Intent;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment;

public class tiq
  implements tjl
{
  public tiq(GdtMotiveVideoFragment paramGdtMotiveVideoFragment) {}
  
  public void finish()
  {
    Activity localActivity = getActivity();
    if (localActivity != null) {
      localActivity.finish();
    }
  }
  
  public Activity getActivity()
  {
    return this.a.getActivity();
  }
  
  public void setResult(int paramInt, Intent paramIntent)
  {
    Activity localActivity = getActivity();
    if (localActivity != null) {
      localActivity.setResult(paramInt, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tiq
 * JD-Core Version:    0.7.0.1
 */