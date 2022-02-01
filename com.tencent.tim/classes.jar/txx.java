import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.qapmsdk.base.listener.IBatteryReportListener;
import com.tencent.qapmsdk.battery.BatteryMonitor;
import com.tencent.qphone.base.util.QLog.ILogCallback;
import mqq.util.IServiceCmdCallback;
import org.jetbrains.annotations.NotNull;

class txx
  implements IBatteryReportListener, QLog.ILogCallback, IServiceCmdCallback
{
  @NotNull
  public String getSosoClassName()
  {
    return SosoInterface.class.getPackage().getName();
  }
  
  public void onCmdRequest(String paramString)
  {
    BatteryMonitor.getInstance().onCmdRequest(paramString);
  }
  
  public void onCmdResponse(String paramString) {}
  
  public void onPrintLog(@NotNull String paramString) {}
  
  public void onUsageAlarm(int paramInt1, int paramInt2, int paramInt3, @NotNull String paramString1, @NotNull String paramString2) {}
  
  public void onWriteLog(String paramString1, String paramString2)
  {
    BatteryMonitor.getInstance().onWriteLog(paramString1, paramString2);
  }
  
  public void onWriteLog(String paramString, byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     txx
 * JD-Core Version:    0.7.0.1
 */