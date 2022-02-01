import android.os.Bundle;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class aeep
  extends QIPCModule
  implements aeev
{
  private static volatile aeep a;
  public static boolean bTu;
  private List<aeep.a> yO = new ArrayList();
  
  private aeep()
  {
    super("DanmuDataIPCClient");
  }
  
  public static aeep a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aeep();
      }
      return a;
    }
    finally {}
  }
  
  public static void registerModule()
  {
    aeep localaeep = a();
    if (!bTu)
    {
      QIPCClientHelper.getInstance().register(localaeep);
      bTu = true;
      QLog.d("DanmuDataIPCClient", 1, "registerModule");
    }
  }
  
  public void a(aeep.a parama)
  {
    if ((parama != null) && (!this.yO.contains(parama))) {
      this.yO.add(parama);
    }
  }
  
  public Bundle b(String paramString, Bundle paramBundle)
  {
    long l1;
    long l2;
    int i;
    Object localObject;
    if ("qipc_action_get_barrage".equals(paramString))
    {
      l1 = paramBundle.getLong("key_barrage_msg_seq");
      l2 = paramBundle.getLong("key_barrage_grp_uin");
      i = paramBundle.getInt("key_barrage_topic_type");
      localObject = aeeo.a().h(l2, l1);
      localObject = aeeo.a().a((String)localObject);
      if (localObject == null) {
        break label243;
      }
    }
    label243:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("DanmuDataIPCClient", 2, new Object[] { "get barrage list, msgSeq:", Long.valueOf(l1), " groupUin:", Long.valueOf(l2), " topicType:", Integer.valueOf(i), " peakCached:", Boolean.valueOf(bool) });
      if (bool) {
        QLog.d("DanmuDataIPCClient", 2, new Object[] { "peak listSize:", Integer.valueOf(((aeeo.a)localObject).yN.size()), ", fullList:", ((aeeo.a)localObject).yN.toString() });
      }
      paramBundle.putBoolean("key_barrage_is_update", bool);
      paramBundle.putLong("key_barrage_req_time", System.currentTimeMillis());
      QIPCClientHelper.getInstance().getClient().callServer("DanmuDataIPCServer", "qipc_action_get_barrage", paramBundle, new aeeq(this));
      if ("qipc_action_clear_cache".equals(paramString)) {
        QIPCClientHelper.getInstance().getClient().callServer("DanmuDataIPCServer", "qipc_action_clear_cache", null);
      }
      return null;
    }
  }
  
  public void b(aeep.a parama)
  {
    if ((parama != null) && (this.yO.contains(parama))) {
      this.yO.remove(parama);
    }
  }
  
  public void cWz()
  {
    aeeo.a().clear();
    b("qipc_action_clear_cache", null);
  }
  
  public void co(Bundle paramBundle)
  {
    paramBundle.setClassLoader(DanmuItemBean.class.getClassLoader());
    long l1 = paramBundle.getLong("key_barrage_msg_seq");
    long l2 = paramBundle.getLong("key_barrage_grp_uin");
    int k = paramBundle.getInt("key_barrage_topic_type");
    boolean bool = paramBundle.getBoolean("key_barrage_is_success");
    int m = paramBundle.getInt("key_barrage_interval_time");
    if (QLog.isColorLevel()) {
      QLog.d("DanmuDataIPCClient", 2, new Object[] { "handleGetBarrageEIPCResult, topicSeq:", Long.valueOf(l1), " groupUin:", Long.valueOf(l2), " topicType:", Integer.valueOf(k), " isSuccess:", Boolean.valueOf(bool) });
    }
    if (paramBundle.containsKey("key_barrage_req_time"))
    {
      long l4 = paramBundle.getLong("key_barrage_req_time");
      long l5 = paramBundle.getLong("key_barrage_net_req_time");
      long l3 = paramBundle.getLong("key_barrage_net_response_time");
      l4 = l5 - l4;
      l5 = l3 - l5;
      l3 = System.currentTimeMillis() - l3;
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("ipcReqCost", String.valueOf(l4));
      ((HashMap)localObject1).put("netReqCost", String.valueOf(l5));
      ((HashMap)localObject1).put("ipcRspCost", String.valueOf(l3));
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "DanmuPullCost", false, 0L, 0L, (HashMap)localObject1, null);
      if (QLog.isColorLevel()) {
        QLog.d("DanmuDataIPCClient", 2, new Object[] { "handleGetBarrageEIPCResult, ipcReqCost:", Long.valueOf(l4), " netReqCost:", Long.valueOf(l5), " ipcRspCost:", Long.valueOf(l3) });
      }
    }
    Object localObject1 = paramBundle.getParcelableArrayList("key_barrage_danmu_list");
    Object localObject2 = paramBundle.getLongArray("key_barrage_del_seq_list");
    int i;
    int j;
    label347:
    Object localObject3;
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      i = 1;
      if ((localObject2 == null) || (localObject2.length <= 0)) {
        break label506;
      }
      j = 1;
      localObject3 = aeeo.a().h(l2, l1);
      paramBundle = aeeo.a().a((String)localObject3);
      if (paramBundle != null) {
        break label649;
      }
      paramBundle = aeeo.a().b((String)localObject3);
    }
    label516:
    label649:
    for (;;)
    {
      if ((bool) && ((i != 0) || (j != 0)))
      {
        if (QLog.isColorLevel())
        {
          if (localObject1 == null) {
            break label511;
          }
          i = ((ArrayList)localObject1).size();
          label411:
          if (localObject2 == null) {
            break label516;
          }
        }
        for (j = localObject2.length;; j = 0)
        {
          QLog.d("DanmuDataIPCClient", 2, new Object[] { "handleGetBarrageEIPCResult, danmuItemList size:", Integer.valueOf(i), " delSeqArr size:", Integer.valueOf(j) });
          localObject3 = new ArrayList(localObject2.length);
          j = localObject2.length;
          i = 0;
          while (i < j)
          {
            ((List)localObject3).add(Long.valueOf(localObject2[i]));
            i += 1;
          }
          i = 0;
          break;
          label506:
          j = 0;
          break label347;
          label511:
          i = 0;
          break label411;
        }
        localObject2 = new aeen(l2, l1, k, true);
        paramBundle.a((List)localObject1).b((List)localObject3).a((aeen)localObject2).a(null).bGa();
      }
      if ((bool) && (paramBundle != null) && (!paramBundle.yN.isEmpty()))
      {
        localObject1 = this.yO.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((aeep.a)((Iterator)localObject1).next()).a(l1, String.valueOf(l2), m, paramBundle.yN);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("DanmuDataIPCClient", 2, "handleGetBarrageEIPCResult end");
      }
      return;
    }
  }
  
  public void m(long paramLong1, long paramLong2, int paramInt)
  {
    QLog.d("DanmuDataIPCClient", 1, "getDanmuList start");
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("key_barrage_msg_seq", paramLong1);
      localBundle.putLong("key_barrage_grp_uin", paramLong2);
      localBundle.putInt("key_barrage_topic_type", paramInt);
      a().b("qipc_action_get_barrage", localBundle);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("DanmuDataIPCClient", 1, "getDanmuList fail, ", localException);
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("qipc_action_get_barrage_result".equals(paramString)) {
      co(paramBundle);
    }
    for (;;)
    {
      return null;
      if ("qipc_action_send_barrage".equals(paramString))
      {
        paramBundle.setClassLoader(DanmuItemBean.class.getClassLoader());
        paramString = (DanmuItemBean)paramBundle.getParcelable("key_barrage_danmu_msg");
        long l = paramBundle.getLong("key_barrage_msg_seq");
        paramBundle = paramBundle.getString("key_barrage_grp_uin");
        Iterator localIterator = this.yO.iterator();
        while (localIterator.hasNext()) {
          ((aeep.a)localIterator.next()).a(l, paramBundle, paramString);
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong, String paramString, int paramInt, List<DanmuItemBean> paramList);
    
    public abstract void a(long paramLong, String paramString, DanmuItemBean paramDanmuItemBean);
  }
  
  public static abstract interface b
  {
    public abstract void a(aeen paramaeen, boolean paramBoolean1, boolean paramBoolean2, int paramInt, ArrayList<DanmuItemBean> paramArrayList, List<Long> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeep
 * JD-Core Version:    0.7.0.1
 */