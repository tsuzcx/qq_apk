import android.content.SharedPreferences;
import com.tencent.mobileqq.richstatus.ISameStatusListener;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.richstatus.StatusObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ecx
  extends StatusObserver
{
  public ecx(StatusManager paramStatusManager) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.shuo", 2, "onGetSyncShuoshuo " + paramBoolean1 + ", " + paramBoolean2);
    }
    label83:
    IStatusListener localIStatusListener;
    if (paramBoolean1)
    {
      StatusManager.c(this.a, 0L);
      StatusManager.a(this.a, paramBoolean2);
      if (StatusManager.b(this.a) == null) {
        return;
      }
      Iterator localIterator = StatusManager.b(this.a).iterator();
      if (!localIterator.hasNext()) {
        return;
      }
      localIStatusListener = (IStatusListener)localIterator.next();
      if (!paramBoolean1) {
        break label162;
      }
    }
    label162:
    for (int i = 100;; i = -1)
    {
      localIStatusListener.a(i, paramBoolean2);
      break label83;
      StatusManager.c(this.a, System.currentTimeMillis() - 180000L + 60000L);
      paramBoolean2 = StatusManager.b(this.a).getBoolean("k_sync_ss", false);
      break;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, byte[] paramArrayOfByte, ArrayList paramArrayList)
  {
    int i;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onGetStatusMate ").append(paramBoolean1).append(" ").append(paramBoolean2).append(" ").append(paramInt).append(" ");
      if (paramArrayList != null)
      {
        i = paramArrayList.size();
        QLog.d("Q.richstatus.mate", 2, i);
      }
    }
    else
    {
      if (!paramBoolean1) {
        break label124;
      }
      StatusManager.a(this.a, paramArrayOfByte);
    }
    for (;;)
    {
      if (paramBoolean1) {
        if (paramBoolean2)
        {
          if (StatusManager.a(this.a) != null)
          {
            StatusManager.a(this.a, paramArrayList);
            return;
            i = -1;
            break;
            label124:
            if (!paramBoolean2) {
              continue;
            }
            StatusManager.a(this.a, null);
            continue;
          }
          if (StatusManager.b(this.a) == null) {
            StatusManager.b(this.a, new ArrayList());
          }
          paramArrayOfByte = this.a.a(StatusManager.b(this.a), paramArrayList, paramInt);
        }
      }
    }
    for (;;)
    {
      label184:
      if ((StatusManager.a(this.a) != null) && (StatusManager.a(this.a).length > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        if (StatusManager.c(this.a) == null) {
          break label283;
        }
        paramArrayList = StatusManager.c(this.a).iterator();
        while (paramArrayList.hasNext()) {
          ((ISameStatusListener)paramArrayList.next()).a(paramBoolean1, paramBoolean2, paramInt, paramArrayOfByte, bool);
        }
        break;
        paramArrayOfByte = this.a.a(paramArrayList);
        break label184;
      }
      label283:
      break;
      paramArrayOfByte = paramArrayList;
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.shuo", 2, "onSetSyncShuoshuo " + paramBoolean1 + ", " + paramBoolean2);
    }
    label74:
    IStatusListener localIStatusListener;
    if (paramBoolean1)
    {
      StatusManager.a(this.a, paramBoolean2);
      if (StatusManager.b(this.a) == null) {
        return;
      }
      Iterator localIterator = StatusManager.b(this.a).iterator();
      if (!localIterator.hasNext()) {
        return;
      }
      localIStatusListener = (IStatusListener)localIterator.next();
      if (!paramBoolean1) {
        break label134;
      }
    }
    label134:
    for (int i = 100;; i = -1)
    {
      localIStatusListener.b(i, paramBoolean2);
      break label74;
      paramBoolean2 = StatusManager.b(this.a).getBoolean("k_sync_ss", false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ecx
 * JD-Core Version:    0.7.0.1
 */