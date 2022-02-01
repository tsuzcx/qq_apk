import com.tencent.av.widget.stageview.StageEffectView;
import com.tencent.av.widget.stageview.StageEffectView.d;
import com.tencent.av.widget.stageview.StageMemberView;
import java.util.Comparator;

public class jmi
  implements Comparator<StageMemberView>
{
  public jmi(StageEffectView paramStageEffectView) {}
  
  public int a(StageMemberView paramStageMemberView1, StageMemberView paramStageMemberView2)
  {
    if ((paramStageMemberView1 == null) && (paramStageMemberView2 == null)) {
      return 0;
    }
    if (paramStageMemberView2 == null) {
      return -1;
    }
    if (paramStageMemberView1 == null) {
      return 1;
    }
    paramStageMemberView1 = (StageEffectView.d)paramStageMemberView1.getTag();
    paramStageMemberView2 = (StageEffectView.d)paramStageMemberView2.getTag();
    if (paramStageMemberView1.aBG == paramStageMemberView2.aBG) {
      return 0;
    }
    if (jme.mod(paramStageMemberView1.aBG - 10000, 20000) < jme.mod(paramStageMemberView2.aBG - 10000, 20000)) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jmi
 * JD-Core Version:    0.7.0.1
 */