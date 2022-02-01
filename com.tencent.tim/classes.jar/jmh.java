import android.view.View;
import com.tencent.av.widget.stageview.StageEffectView;
import com.tencent.av.widget.stageview.StageEffectView.d;
import java.util.Comparator;

public class jmh
  implements Comparator<Integer>
{
  public jmh(StageEffectView paramStageEffectView) {}
  
  public int compare(Integer paramInteger1, Integer paramInteger2)
  {
    paramInteger1 = (StageEffectView.d)this.this$0.getChildAt(paramInteger1.intValue()).getTag();
    paramInteger2 = (StageEffectView.d)this.this$0.getChildAt(paramInteger2.intValue()).getTag();
    if (paramInteger1.z < paramInteger2.z) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jmh
 * JD-Core Version:    0.7.0.1
 */