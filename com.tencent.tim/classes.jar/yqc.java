import android.os.Message;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView.a;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class yqc
  extends acnd
{
  public yqc(TroopView paramTroopView) {}
  
  protected void g(boolean paramBoolean, ArrayList<ypn> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("addContacts.TroopView", 2, "onGetAddContactFindTroopClassify isSuccess = " + paramBoolean + ",dataList = " + paramArrayList);
    }
    Object localObject;
    int i;
    if ((TroopView.a(this.b) != null) && (TroopView.a(this.b).isRefreshing()))
    {
      localObject = TroopView.a(this.b);
      if (paramBoolean)
      {
        i = 1;
        localObject = ((TroopView.a)localObject).obtainMessage(14, 0, i);
        TroopView.a(this.b).sendMessage((Message)localObject);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label223;
      }
      TroopView.a(this.b).sendEmptyMessage(4);
    }
    label223:
    for (;;)
    {
      label118:
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        this.b.sV.clear();
        this.b.sV.addAll(paramArrayList);
        TroopView.a(this.b).notifyDataSetChanged();
        localObject = new ArrayList();
        i = 0;
        for (;;)
        {
          if (i < paramArrayList.size())
          {
            ypn localypn = (ypn)paramArrayList.get(i);
            localypn.id = (i + 100);
            ((ArrayList)localObject).add(localypn);
            i += 1;
            continue;
            i = 0;
            break;
            TroopView.a(this.b).sendEmptyMessage(5);
            break label118;
          }
        }
        TroopView.a(this.b).dd((ArrayList)localObject);
        TroopView.a(this.b, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yqc
 * JD-Core Version:    0.7.0.1
 */