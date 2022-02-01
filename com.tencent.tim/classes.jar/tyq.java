import com.tencent.qapmsdk.base.listener.IMemoryCellingListener;
import com.tencent.qapmsdk.memory.DumpMemInfoHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class tyq
  implements IMemoryCellingListener
{
  static void fC(long paramLong) {}
  
  public void onBeforeUploadJson()
  {
    QLog.i("QAPM_QQ_Impl", 1, "Celling onBeforeUploadJson");
  }
  
  public boolean onCanDump(long paramLong)
  {
    fC(paramLong);
    return false;
  }
  
  public void onFinishDump(boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2) {}
  
  public void onLowMemory(long paramLong)
  {
    tyj.a().onLowMemory(paramLong);
  }
  
  @NotNull
  public List<String> onPrepareDump(@NotNull String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = DumpMemInfoHandler.generateHprof(paramString);
    boolean bool = ((Boolean)paramString[0]).booleanValue();
    if ((bool) && (paramString[1] != null)) {
      localArrayList.add((String)paramString[1]);
    }
    QLog.i("QAPM_QQ_Impl", 1, "Celling onBeforeDump " + bool);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tyq
 * JD-Core Version:    0.7.0.1
 */