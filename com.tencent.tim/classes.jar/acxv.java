import android.content.ContentValues;
import android.os.Handler;
import android.os.Looper;
import com.dataline.mpfile.MpfileTaskRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.MpfileTaskProxy.1;
import com.tencent.mobileqq.app.proxy.MpfileTaskProxy.2;
import com.tencent.mobileqq.app.proxy.MpfileTaskProxy.3;
import com.tencent.mobileqq.app.proxy.MpfileTaskProxy.4;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class acxv
  extends acxq
{
  List<MpfileTaskRecord> ya = null;
  
  public acxv(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  private String f(long paramLong, int paramInt)
  {
    String str = MpfileTaskRecord.tableName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * ").append("from " + str + " ");
    if (paramLong != -1L) {
      localStringBuilder.append("where " + str + ".msgId < ? ");
    }
    localStringBuilder.append("limit " + paramInt + " ");
    return localStringBuilder.toString();
  }
  
  public long a(MpfileTaskRecord paramMpfileTaskRecord)
  {
    dv localdv = new dv(false, false);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      a(paramMpfileTaskRecord, null);
      return 0L;
    }
    new Handler(localLooper).post(new MpfileTaskProxy.4(this, paramMpfileTaskRecord, localdv));
    localdv.f(-1L);
    return 0L;
  }
  
  public void a(Entity paramEntity, ProxyListener paramProxyListener)
  {
    dv localdv = new dv(false, false);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      paramEntity = ((MpfileTaskRecord)paramEntity).clone();
      this.a.addMsgQueue(String.valueOf(0), 0, MpfileTaskRecord.tableName(), paramEntity, 0, paramProxyListener);
      return;
    }
    new Handler(localLooper).post(new MpfileTaskProxy.1(this, paramEntity, paramProxyListener, localdv));
    localdv.f(-1L);
  }
  
  public void a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      this.a.addMsgQueue(String.valueOf(0), 0, paramString1, paramContentValues, paramString2, paramArrayOfString, 1, paramProxyListener);
      return;
    }
    new Handler(localLooper).post(new MpfileTaskProxy.2(this, paramString1, paramContentValues, paramString2, paramArrayOfString, paramProxyListener));
  }
  
  public void a(String paramString1, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      this.a.addMsgQueue(String.valueOf(0), 0, paramString1, paramString2, paramArrayOfString, 2, paramProxyListener);
      return;
    }
    new Handler(localLooper).post(new MpfileTaskProxy.3(this, paramString1, paramString2, paramArrayOfString, paramProxyListener));
  }
  
  protected void destory() {}
  
  public List<MpfileTaskRecord> el()
  {
    if (this.ya == null)
    {
      Object localObject = MpfileTaskRecord.tableName();
      EntityManager localEntityManager = this.app.a().createEntityManager();
      localEntityManager.execSQL("create index if not exists " + (String)localObject + "_index ON " + (String)localObject + "(fileId, msgId)");
      List localList = localEntityManager.rawQuery(MpfileTaskRecord.class, f(-1L, 15), null);
      localObject = localList;
      if (localList == null) {
        localObject = new ArrayList();
      }
      this.ya = ((List)localObject);
      localEntityManager.close();
    }
    return this.ya;
  }
  
  protected void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acxv
 * JD-Core Version:    0.7.0.1
 */