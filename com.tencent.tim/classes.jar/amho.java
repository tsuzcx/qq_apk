import PersonalState.HotRishState;
import PersonalState.RespGetSameStateList;
import PersonalState.UserProfile;
import android.os.Bundle;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusServlet.RspGetHistory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.observer.BusinessObserver;

public class amho
  implements BusinessObserver
{
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, byte[] paramArrayOfByte, ArrayList<UserProfile> paramArrayList) {}
  
  protected void c(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, ArrayList<RichStatus> paramArrayList, boolean paramBoolean3) {}
  
  protected void d(boolean paramBoolean, List<byte[]> paramList, List<Integer> paramList1) {}
  
  protected void g(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void h(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void l(boolean paramBoolean, ArrayList<HotRishState> paramArrayList) {}
  
  protected void l(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void m(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    switch (paramInt)
    {
    }
    do
    {
      return;
      if (paramBoolean) {
        bool1 = paramBundle.getBoolean("k_sync_ss", false);
      }
      l(paramBoolean, bool1);
      return;
      bool1 = bool2;
      if (paramBoolean) {
        bool1 = paramBundle.getBoolean("k_sync_ss", false);
      }
      m(paramBoolean, bool1);
      return;
      bool1 = paramBundle.getBoolean("k_is_first");
      paramInt = paramBundle.getInt("k_fetch_sex");
      if (paramBoolean)
      {
        paramBundle = (RespGetSameStateList)paramBundle.getSerializable("k_resp_mate");
        a(paramBoolean, bool1, paramInt, paramBundle.vCookie, paramBundle.vUserInfos);
        return;
      }
      a(false, bool1, paramInt, null, null);
      return;
      paramBundle = (StatusServlet.RspGetHistory)paramBundle.getSerializable("k_data");
      c(paramBoolean, paramBundle.startTime, paramBundle.endTime, paramBundle.over, paramBundle.richStatus, paramBundle.isAddFromCard);
      return;
      Object localObject = paramBundle.getStringArrayList("k_status_key");
      ArrayList localArrayList = new ArrayList();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList.add(((String)((Iterator)localObject).next()).getBytes());
        }
      }
      d(paramBoolean, localArrayList, paramBundle.getIntegerArrayList("k_status_err_code_list"));
      return;
      l(paramBoolean, (ArrayList)paramBundle.get("k_resp_hot_status"));
      return;
      g(paramBoolean, paramBundle);
      return;
      h(paramBoolean, paramBundle);
    } while (!QLog.isColorLevel());
    QLog.d("StatusObserver", 2, "clear self sign ret:" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amho
 * JD-Core Version:    0.7.0.1
 */