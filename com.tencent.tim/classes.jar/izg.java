import com.tencent.av.VideoController.b;
import com.tencent.av.ui.GAudioMembersCtrlActivity;
import com.tencent.av.ui.GAudioMembersCtrlActivity.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class izg
  extends iin
{
  public izg(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity) {}
  
  protected void c(long paramLong1, long paramLong2, ArrayList<VideoController.b> paramArrayList)
  {
    ThreadManager.getUIHandler().post(new GAudioMembersCtrlActivity.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     izg
 * JD-Core Version:    0.7.0.1
 */