import android.os.Handler;
import com.tencent.mobileqq.teamworkforgroup.GPadInfo;
import java.util.ArrayList;
import java.util.List;

class aoez
  extends aoee
{
  aoez(aoeq paramaoeq) {}
  
  public void a(boolean paramBoolean1, int paramInt1, String arg3, List<GPadInfo> paramList, int paramInt2, boolean paramBoolean2)
  {
    ??? = this.this$0;
    ???.mRequestCount -= 1;
    if ((paramBoolean1) && (paramInt1 == 0)) {
      for (;;)
      {
        synchronized (this.this$0.eo)
        {
          if (this.this$0.GY != null)
          {
            this.this$0.GY.clear();
            this.this$0.dOd = paramInt2;
            this.this$0.mIsEnd = paramBoolean2;
            if (paramList == null) {
              break;
            }
            this.this$0.dOl = paramList.size();
          }
        }
        synchronized (this.this$0.eo)
        {
          this.this$0.GY.addAll(paramList);
          ??? = this.this$0.uiHandler.obtainMessage(5);
          this.this$0.uiHandler.sendMessage(???);
          return;
          this.this$0.GY = new ArrayList();
          continue;
          paramList = finally;
          throw paramList;
        }
      }
    }
    if (this.this$0.cLn) {}
    for (??? = this.this$0.uiHandler.obtainMessage(3);; ??? = this.this$0.uiHandler.obtainMessage(5))
    {
      this.this$0.uiHandler.sendMessage(???);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoez
 * JD-Core Version:    0.7.0.1
 */