import com.tencent.qapmsdk.base.listener.IMemoryDumpListener;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class tyl
  implements IMemoryDumpListener
{
  tyl(tyk paramtyk) {}
  
  public void onFinishDump(boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2) {}
  
  @NotNull
  public List<String> onPrepareDump(@NotNull String paramString)
  {
    long l1 = Runtime.getRuntime().totalMemory();
    long l2 = Runtime.getRuntime().freeMemory();
    ArrayList localArrayList = new ArrayList(4);
    localArrayList.addAll(tyd.cE());
    localArrayList.add(tyd.generateTraces());
    localArrayList.add(tyd.generateThreadTrace());
    localArrayList.add(tyd.r(paramString, l1 - l2));
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tyl
 * JD-Core Version:    0.7.0.1
 */