import android.graphics.Path;
import com.tencent.lottieNew.model.content.Mask;
import java.util.ArrayList;
import java.util.List;

public class ttm
{
  private final List<ttg<tvv, Path>> maskAnimations;
  private final List<Mask> masks;
  private final List<ttg<Integer, Integer>> opacityAnimations;
  
  public ttm(List<Mask> paramList)
  {
    this.masks = paramList;
    this.maskAnimations = new ArrayList(paramList.size());
    this.opacityAnimations = new ArrayList(paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      this.maskAnimations.add(((Mask)paramList.get(i)).a().g());
      tuq localtuq = ((Mask)paramList.get(i)).b();
      this.opacityAnimations.add(localtuq.g());
      i += 1;
    }
  }
  
  public List<ttg<tvv, Path>> getMaskAnimations()
  {
    return this.maskAnimations;
  }
  
  public List<Mask> getMasks()
  {
    return this.masks;
  }
  
  public List<ttg<Integer, Integer>> getOpacityAnimations()
  {
    return this.opacityAnimations;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ttm
 * JD-Core Version:    0.7.0.1
 */