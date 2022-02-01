import android.os.SystemClock;
import com.tencent.beacon.event.UserAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class imq
{
  private boolean SC;
  private imp mDoodleLogic;
  public boolean mIsShow;
  private long startTime;
  
  public imq(imp paramimp)
  {
    this.mDoodleLogic = paramimp;
  }
  
  private void aok()
  {
    if (this.mIsShow)
    {
      this.startTime = SystemClock.elapsedRealtime();
      return;
    }
    kZ(this.mDoodleLogic.mColor);
  }
  
  private void kZ(int paramInt)
  {
    if (this.startTime != 0L)
    {
      long l = SystemClock.elapsedRealtime() - this.startTime;
      if (l > 3000L)
      {
        HashMap localHashMap = new HashMap();
        String str1 = Integer.toHexString(paramInt);
        String str2 = String.valueOf(l);
        localHashMap.put("color", str1);
        localHashMap.put("duration", str2);
        UserAction.onUserAction("actAVFunChatDrawing", true, -1L, -1L, localHashMap, true);
        if (QLog.isColorLevel()) {
          QLog.d("DoodleReportController", 2, "onUserAction colorString = " + str1 + ", durationString = " + str2);
        }
        this.SC = true;
      }
    }
  }
  
  public void aol()
  {
    setIsShow(false);
    if (this.SC)
    {
      imr.iF("0X80077C2");
      return;
    }
    imr.iF("0X80077C1");
  }
  
  public void onColorChanged(int paramInt)
  {
    if ((this.mIsShow) && (paramInt != this.mDoodleLogic.mColor))
    {
      kZ(paramInt);
      this.startTime = SystemClock.elapsedRealtime();
    }
  }
  
  public void setIsShow(boolean paramBoolean)
  {
    if (this.mIsShow != paramBoolean)
    {
      this.mIsShow = paramBoolean;
      aok();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     imq
 * JD-Core Version:    0.7.0.1
 */