import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController.b;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class afmt
  implements EmoticonPanelController.b
{
  public afmt(EmoticonPanelController paramEmoticonPanelController, int paramInt, long paramLong) {}
  
  public void day()
  {
    int j = this.cSh;
    int i = j;
    if (this.this$0.bZi)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelController", 2, "switchTabMode mMarketPgkDownloaded = true");
      }
      List localList = this.this$0.zZ;
      i = j;
      if (localList != null)
      {
        i = j;
        if (localList.size() > 0)
        {
          i = this.this$0.a.Dj();
          j = this.this$0.a.Dk();
          if ((j == 0) || (j >= i)) {
            break label110;
          }
          i = j;
        }
      }
    }
    label110:
    for (;;)
    {
      this.this$0.bZi = false;
      EmoticonPanelController.a(this.this$0, this.val$startTime, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afmt
 * JD-Core Version:    0.7.0.1
 */