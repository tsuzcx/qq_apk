import android.os.Handler;
import com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade.ISearchListener;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class cbv
  implements ContactSearchFacade.ISearchListener
{
  public cbv(SearchBaseActivity paramSearchBaseActivity) {}
  
  public void a(int paramInt1, boolean paramBoolean, Object paramObject, int paramInt2, String paramString)
  {
    this.a.n();
    if (paramBoolean)
    {
      if ((paramObject != null) && ((paramObject instanceof ArrayList)))
      {
        paramObject = (ArrayList)paramObject;
        if (paramObject.size() != 0) {
          break label81;
        }
        paramObject = this.a.a;
        if (!this.a.b) {
          break label76;
        }
        paramInt1 = 3;
        paramObject.sendEmptyMessage(paramInt1);
        if (QLog.isColorLevel()) {
          QLog.d(SearchBaseActivity.c(), 2, "error! SearchResult is null!");
        }
      }
      label76:
      label81:
      while (!this.a.a(paramObject)) {
        for (;;)
        {
          return;
          paramInt1 = 2;
        }
      }
      this.a.a.sendEmptyMessage(0);
      return;
    }
    this.a.a(paramInt1, paramObject, paramInt2, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cbv
 * JD-Core Version:    0.7.0.1
 */