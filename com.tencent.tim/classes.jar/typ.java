import com.tencent.qapmsdk.base.listener.IMemoryDumpListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class typ
  implements IMemoryDumpListener
{
  typ(tyo paramtyo) {}
  
  public void onFinishDump(boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2)
  {
    QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, "onFinishDump " + paramBoolean + " " + paramString1 + " " + paramString2);
  }
  
  @NotNull
  public List<String> onPrepareDump(@NotNull String paramString)
  {
    QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, "onPrepareDump " + paramString);
    paramString = new ArrayList(4);
    paramString.addAll(tyd.cD());
    paramString.addAll(tyd.cE());
    paramString.add(tyd.generateTraces());
    paramString.add(tyd.generateThreadTrace());
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     typ
 * JD-Core Version:    0.7.0.1
 */