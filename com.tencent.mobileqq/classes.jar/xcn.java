import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.Arrays;
import java.util.List;

public class xcn
  implements xab
{
  @NonNull
  private final wzy[] a;
  
  public xcn(wzy... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      throw new IllegalArgumentException("layers should not be null or empty");
    }
    this.a = paramVarArgs;
  }
  
  public void a(List<wzy> paramList, DoodleView paramDoodleView)
  {
    paramList.addAll(Arrays.asList(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xcn
 * JD-Core Version:    0.7.0.1
 */