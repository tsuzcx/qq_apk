import PersonalState.UserProfile;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richstatus.StatusManager.3.1;
import com.tencent.mobileqq.richstatus.StatusManager.3.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import mqq.os.MqqHandler;

public class amhm
  extends amho
{
  amhm(amhj paramamhj) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, byte[] paramArrayOfByte, ArrayList<UserProfile> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.mate", 2, "onGetStatusMate " + paramBoolean1 + " " + paramBoolean2 + " " + paramInt + " " + paramArrayList.size());
    }
    if (paramBoolean1) {
      amhj.a(this.e, paramArrayOfByte);
    }
    for (;;)
    {
      if (paramBoolean1) {
        if (paramBoolean2)
        {
          if (amhj.a(this.e) != null)
          {
            amhj.a(this.e, paramArrayList);
            return;
            if (!paramBoolean2) {
              continue;
            }
            amhj.a(this.e, null);
            continue;
          }
          if (amhj.b(this.e) == null) {
            amhj.b(this.e, new ArrayList());
          }
          paramArrayOfByte = this.e.a(amhj.b(this.e), paramArrayList, paramInt);
        }
      }
    }
    for (;;)
    {
      label165:
      if ((amhj.a(this.e) != null) && (amhj.a(this.e).length > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        if (amhj.c(this.e) == null) {
          break label264;
        }
        paramArrayList = amhj.c(this.e).iterator();
        while (paramArrayList.hasNext()) {
          ((amfj)paramArrayList.next()).a(paramBoolean1, paramBoolean2, paramInt, paramArrayOfByte, bool);
        }
        break;
        paramArrayOfByte = this.e.e(paramArrayList);
        break label165;
      }
      label264:
      break;
      paramArrayOfByte = paramArrayList;
    }
  }
  
  @TargetApi(9)
  protected void g(boolean paramBoolean, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new StatusManager.3.1(this, paramBoolean, paramBundle));
  }
  
  protected void h(boolean paramBoolean, Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new StatusManager.3.2(this, paramBoolean));
  }
  
  protected void l(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.shuo", 2, "onGetSyncShuoshuo " + paramBoolean1 + ", " + paramBoolean2);
    }
    label83:
    amfk localamfk;
    if (paramBoolean1)
    {
      amhj.c(this.e, 0L);
      amhj.a(this.e, paramBoolean2);
      if (amhj.b(this.e) == null) {
        return;
      }
      Iterator localIterator = amhj.b(this.e).iterator();
      if (!localIterator.hasNext()) {
        return;
      }
      localamfk = (amfk)localIterator.next();
      if (!paramBoolean1) {
        break label162;
      }
    }
    label162:
    for (int i = 100;; i = -1)
    {
      localamfk.aF(i, paramBoolean2);
      break label83;
      amhj.c(this.e, System.currentTimeMillis() - 180000L + 60000L);
      paramBoolean2 = amhj.b(this.e).getBoolean("k_sync_ss", false);
      break;
    }
  }
  
  protected void m(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.shuo", 2, "onSetSyncShuoshuo " + paramBoolean1 + ", " + paramBoolean2);
    }
    label74:
    amfk localamfk;
    if (paramBoolean1)
    {
      amhj.a(this.e, paramBoolean2);
      if (amhj.b(this.e) == null) {
        return;
      }
      Iterator localIterator = amhj.b(this.e).iterator();
      if (!localIterator.hasNext()) {
        return;
      }
      localamfk = (amfk)localIterator.next();
      if (!paramBoolean1) {
        break label134;
      }
    }
    label134:
    for (int i = 100;; i = -1)
    {
      localamfk.aG(i, paramBoolean2);
      break label74;
      paramBoolean2 = amhj.b(this.e).getBoolean("k_sync_ss", false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amhm
 * JD-Core Version:    0.7.0.1
 */