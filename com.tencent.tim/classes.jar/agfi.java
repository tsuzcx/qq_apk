import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import com.tencent.qphone.base.util.QLog;

public class agfi
  extends aklk
{
  public agfi(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.i("FileAssistantActivity", 1, " fileRedTouch get push GameCenterObserver ");
    paramBundle = this.this$0.bO.obtainMessage(1);
    this.this$0.bO.sendMessage(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agfi
 * JD-Core Version:    0.7.0.1
 */