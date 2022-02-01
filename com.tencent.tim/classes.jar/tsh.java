import com.tencent.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class tsh
{
  private boolean enabled;
  private final Comparator<Pair<String, Float>> floatComparator = new tsi(this);
  private final Set<tsh.a> frameListeners = new HashSet();
  private Map<String, tww> layerRenderTimes = new HashMap();
  
  public void recordRenderTime(String paramString, float paramFloat)
  {
    if (!this.enabled) {}
    for (;;)
    {
      return;
      tww localtww2 = (tww)this.layerRenderTimes.get(paramString);
      tww localtww1 = localtww2;
      if (localtww2 == null)
      {
        localtww1 = new tww();
        this.layerRenderTimes.put(paramString, localtww1);
      }
      localtww1.add(paramFloat);
      if (paramString.equals("root"))
      {
        paramString = this.frameListeners.iterator();
        while (paramString.hasNext()) {
          ((tsh.a)paramString.next()).onFrameRendered(paramFloat);
        }
      }
    }
  }
  
  void setEnabled(boolean paramBoolean)
  {
    this.enabled = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void onFrameRendered(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tsh
 * JD-Core Version:    0.7.0.1
 */