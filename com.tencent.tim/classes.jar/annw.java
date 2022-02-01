import android.os.Bundle;
import com.tencent.mobileqq.statistics.DailyReport;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.io.File;

public class annw
  extends aquy
{
  public annw(DailyReport paramDailyReport, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(aquz paramaquz)
  {
    super.onDone(paramaquz);
    long l = paramaquz.getParams().getLong("id");
    VasWebviewUtil.reportVasStatus("AvatarPendant", "AvatarPendantOn", String.valueOf(l), 0, 0, 0, 0, aqgm.x(new File(aqgm.m(l, 4))), "");
  }
  
  public boolean onStart(aquz paramaquz)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     annw
 * JD-Core Version:    0.7.0.1
 */