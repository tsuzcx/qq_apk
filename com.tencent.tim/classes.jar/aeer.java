import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aeer
  extends QIPCModule
  implements aeep.b
{
  private static volatile aeer a;
  
  public aeer()
  {
    super("DanmuDataIPCServer");
  }
  
  public static aeer a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aeer();
      }
      return a;
    }
    finally {}
  }
  
  private static long[] a(List<Long> paramList)
  {
    long[] arrayOfLong = new long[paramList.size()];
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      arrayOfLong[i] = ((Long)paramList.next()).longValue();
      i += 1;
    }
    return arrayOfLong;
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3, SpannableString paramSpannableString)
  {
    QLog.d("DanmuDataIPCServer", 1, "notifyDanmuSendResult");
    String str;
    if (paramSpannableString != null)
    {
      str = paramSpannableString.toString();
      if ((paramString1.length() > str.length()) && (paramString1.startsWith(str)))
      {
        paramSpannableString = paramString1.substring(paramSpannableString.length());
        if (!TextUtils.isEmpty(paramSpannableString)) {
          paramString1 = paramSpannableString;
        }
      }
    }
    for (;;)
    {
      paramSpannableString = (QQAppInterface)axol.getAppInterface();
      str = aqgv.h(paramSpannableString, String.valueOf(paramString2), paramSpannableString.getAccount());
      paramString1 = new DanmuItemBean(Long.parseLong(paramSpannableString.getCurrentUin()), 0L, paramLong1, paramLong2, paramString1, str);
      paramString1.bTv = jof.a().dd(paramString2);
      if (paramString1.bTv)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DanmuDataIPCServer", 2, "notifyDanmuSendResult, anonymousFlag true");
        }
        paramSpannableString = jof.a().a(paramString2);
        paramString1.bwD = paramSpannableString.nickName;
        paramString1.cMq = paramSpannableString.aCw;
      }
      paramSpannableString = new Bundle();
      paramSpannableString.putParcelable("key_barrage_danmu_msg", paramString1);
      paramSpannableString.putLong("key_barrage_msg_seq", paramLong3);
      paramSpannableString.putString("key_barrage_grp_uin", paramString2);
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "DanmuDataIPCClient", "qipc_action_send_barrage", paramSpannableString, null);
      return;
    }
  }
  
  public void a(aeen paramaeen, boolean paramBoolean1, boolean paramBoolean2, int paramInt, ArrayList<DanmuItemBean> paramArrayList, List<Long> paramList)
  {
    QLog.d("DanmuDataIPCServer", 1, new Object[] { "onDanmuPullResult, isPullEnd:", Boolean.valueOf(paramBoolean2) });
    if (paramaeen == null)
    {
      QLog.d("DanmuDataIPCServer", 1, "onDanmuPullResult fail, pullContext is null");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("key_barrage_msg_seq", paramaeen.VP);
    localBundle.putLong("key_barrage_grp_uin", paramaeen.groupUin);
    localBundle.putInt("key_barrage_topic_type", paramaeen.cMl);
    localBundle.putInt("key_barrage_interval_time", paramInt);
    localBundle.putBoolean("key_barrage_is_success", paramBoolean1);
    if (paramaeen.VQ > 0L)
    {
      localBundle.putLong("key_barrage_req_time", paramaeen.VQ);
      localBundle.putLong("key_barrage_net_req_time", paramaeen.VR);
      localBundle.putLong("key_barrage_net_response_time", System.currentTimeMillis());
      paramaeen.VQ = -1L;
    }
    if (paramArrayList != null) {
      localBundle.putParcelableArrayList("key_barrage_danmu_list", paramArrayList);
    }
    if (paramList != null) {
      localBundle.putLongArray("key_barrage_del_seq_list", a(paramList));
    }
    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "DanmuDataIPCClient", "qipc_action_get_barrage_result", localBundle, null);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    long l1;
    long l2;
    int i;
    boolean bool;
    if ("qipc_action_get_barrage".equals(paramString))
    {
      l1 = paramBundle.getLong("key_barrage_msg_seq");
      l2 = paramBundle.getLong("key_barrage_grp_uin");
      i = paramBundle.getInt("key_barrage_topic_type");
      bool = paramBundle.getBoolean("key_barrage_is_update");
      QLog.d("DanmuDataIPCServer", 1, new Object[] { "onCall, msgSeq:", Long.valueOf(l1), " groupUin:", Long.valueOf(l2), " topicType:", Integer.valueOf(i), " peakCached:", Boolean.valueOf(bool) });
      localObject = aeeo.a().a(aeeo.a().h(l2, l1));
      if ((localObject != null) && (!((aeeo.a)localObject).isFinish))
      {
        QLog.d("DanmuDataIPCServer", 1, "filter duplicate request, continue pull is not completed");
        paramString = new Bundle();
        paramString.putBoolean("key_barrage_is_success", false);
        callbackResult(paramInt, EIPCResult.createSuccessResult(paramString));
        return null;
      }
      if (localObject != null) {
        break label262;
      }
    }
    label262:
    for (Object localObject = new aeen(l2, l1, i, bool);; localObject = ((aeeo.a)localObject).a)
    {
      ((aeen)localObject).VQ = paramBundle.getLong("key_barrage_req_time");
      ((aeen)localObject).VR = System.currentTimeMillis();
      ((aeen)localObject).bTt = bool;
      aeeo.a().a((aeen)localObject, this);
      callbackResult(paramInt, EIPCResult.createSuccessResult(paramBundle));
      if ("qipc_action_clear_cache".equals(paramString)) {
        aeeo.a().clear();
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeer
 * JD-Core Version:    0.7.0.1
 */