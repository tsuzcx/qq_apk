import com.tencent.common.config.AppSetting;
import com.tencent.qapmsdk.base.listener.IInspectorListener;
import com.tencent.qapmsdk.common.util.InspectUUID;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class tyn
  implements IInspectorListener
{
  public void onCheckingLeaked(int paramInt, @NotNull String paramString) {}
  
  public boolean onFilter(@NotNull Object paramObject)
  {
    return false;
  }
  
  public void onFinishDump(boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2)
  {
    QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, "finishDump" + paramString1 + paramString2);
  }
  
  public boolean onLeaked(@NotNull InspectUUID paramInspectUUID)
  {
    if (!AppSetting.isEnableAutoDumpLeak) {}
    return false;
  }
  
  @NotNull
  public List<String> onPrepareDump(@NotNull String paramString)
  {
    ArrayList localArrayList = new ArrayList(4);
    localArrayList.add(tyd.generateTraces());
    localArrayList.add(tyd.generateThreadTrace());
    localArrayList.addAll(tyd.cE());
    QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, "leakDump" + paramString);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tyn
 * JD-Core Version:    0.7.0.1
 */