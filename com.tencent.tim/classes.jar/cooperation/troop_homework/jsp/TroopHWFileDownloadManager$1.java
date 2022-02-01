package cooperation.troop_homework.jsp;

import awjt;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class TroopHWFileDownloadManager$1
  implements Runnable
{
  public TroopHWFileDownloadManager$1(awjt paramawjt, String paramString1, String paramString2) {}
  
  public void run()
  {
    awjt.a(this.this$0).startDownloadTask(this.val$url, "resource/tm.android.unknown", this.val$fileName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWFileDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */