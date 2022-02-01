import android.os.Handler;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class yol
  implements yob.a
{
  public yol(SearchBaseFragment paramSearchBaseFragment) {}
  
  public void c(int paramInt1, boolean paramBoolean, Object paramObject, int paramInt2, String paramString)
  {
    int i = 3;
    this.b.bpm();
    if (paramBoolean)
    {
      if ((paramObject != null) && ((paramObject instanceof ArrayList)))
      {
        paramObject = (ArrayList)paramObject;
        if (paramObject.size() != 0) {
          break label94;
        }
        if (this.b.uiHandler != null)
        {
          paramObject = this.b.uiHandler;
          if (!this.b.bnO) {
            break label89;
          }
          paramInt1 = 3;
          paramObject.sendEmptyMessage(paramInt1);
        }
        if (QLog.isColorLevel()) {
          QLog.d(SearchBaseFragment.access$000(), 2, "error! SearchResult is null!");
        }
      }
      for (;;)
      {
        return;
        label89:
        paramInt1 = 2;
        break;
        label94:
        if (paramObject.size() > 0) {}
        try
        {
          paramString = (yow)paramObject.get(0);
          if ((this.b.A(paramObject)) && (this.b.uiHandler != null))
          {
            this.b.uiHandler.sendEmptyMessage(0);
            return;
          }
        }
        catch (Exception paramObject)
        {
          if (QLog.isColorLevel()) {
            QLog.d(SearchBaseFragment.access$000(), 2, "", paramObject);
          }
          paramObject = this.b.uiHandler;
          if (!this.b.bnO) {}
        }
      }
      for (paramInt1 = i;; paramInt1 = 2)
      {
        paramObject.sendEmptyMessage(paramInt1);
        return;
      }
    }
    this.b.a(paramInt1, paramObject, paramInt2, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yol
 * JD-Core Version:    0.7.0.1
 */