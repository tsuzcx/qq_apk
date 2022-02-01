import com.tencent.av.VideoController.b;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class jaz
  extends iin
{
  public jaz(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  protected void c(long paramLong1, long paramLong2, ArrayList<VideoController.b> paramArrayList)
  {
    ThreadManager.getUIHandler().post(new MultiVideoCtrlLayerUIBase.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jaz
 * JD-Core Version:    0.7.0.1
 */