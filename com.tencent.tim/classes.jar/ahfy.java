import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

public class ahfy
{
  private long aaA;
  private long aaB;
  private long aaC;
  private long aay;
  private long aaz;
  private int cZP;
  private boolean cgH;
  private boolean cgI;
  private boolean cgJ;
  private long installStartTime;
  private long launchCost;
  private long launchStartTime;
  private boolean needReport;
  
  public boolean ang()
  {
    return (this.cgJ) && (this.cgI);
  }
  
  void bB(int paramInt, boolean paramBoolean)
  {
    if (this.launchStartTime > 0L) {
      this.launchCost = (SystemClock.elapsedRealtime() - this.launchStartTime);
    }
    this.cZP = paramInt;
    if ((!paramBoolean) && (this.needReport)) {
      ahgd.a(this.cZP, this.launchCost, this.aaA, this.aaB, this.aaC, this.cgH, this.cgI, this.cgJ);
    }
    QLog.d("QFlutter.LaunchTrace", 1, String.format("[QFlutterLaunchCost]onLaunchFinish,isPreloadProcess: %s, errorCode: %s, isLocalEngineExist: %s, isLocalAppExist: %s, launchCost: %s, installCost: %s, loadAssetCost: %s, loadEngineCost: %s", new Object[] { Boolean.valueOf(this.cgH), Integer.valueOf(paramInt), Boolean.valueOf(this.cgI), Boolean.valueOf(this.cgJ), Long.valueOf(this.launchCost), Long.valueOf(this.aaA), Long.valueOf(this.aaB), Long.valueOf(this.aaC) }));
  }
  
  void ca(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.cgH = paramBoolean1;
    this.needReport = paramBoolean2;
    this.launchStartTime = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, "onLaunchStart");
    }
  }
  
  void cb(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.installStartTime > 0L) {
      this.aaA = (SystemClock.elapsedRealtime() - this.installStartTime);
    }
    this.cgI = paramBoolean1;
    this.cgJ = paramBoolean2;
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, String.format("onInstallFinish, isLocalEngineExist: %s, isLocalAppExist: %s, installCost: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Long.valueOf(this.aaA) }));
    }
  }
  
  void dnm()
  {
    this.installStartTime = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, "installStartTime");
    }
  }
  
  void dnn()
  {
    this.aay = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, "onLoadAssetStart");
    }
  }
  
  void dno()
  {
    if (this.aay > 0L) {
      this.aaB = (SystemClock.elapsedRealtime() - this.aay);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, String.format("onLoadAssetFinish, loadAssetCost: %s", new Object[] { Long.valueOf(this.aaB) }));
    }
  }
  
  void dnp()
  {
    this.aaz = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, "onLoadEngineStart");
    }
  }
  
  void dnq()
  {
    if (this.aaz > 0L) {
      this.aaC = (SystemClock.elapsedRealtime() - this.aaz);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, String.format("onLoadEngineFinish, loadEngineCost: %s", new Object[] { Long.valueOf(this.aaC) }));
    }
  }
  
  public void reset()
  {
    this.launchStartTime = 0L;
    this.installStartTime = 0L;
    this.aaA = 0L;
    this.aay = 0L;
    this.aaB = 0L;
    this.aaz = 0L;
    this.aaC = 0L;
    this.launchCost = 0L;
    this.cZP = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahfy
 * JD-Core Version:    0.7.0.1
 */