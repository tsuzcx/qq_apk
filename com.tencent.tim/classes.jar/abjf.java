import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class abjf
  extends acgf
{
  public abjf(HotChatCenterFragment paramHotChatCenterFragment) {}
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, Boolean paramBoolean1)
  {
    super.a(paramString1, paramString2, paramBoolean, paramString3, paramString4, paramBoolean1);
    QLog.e("HotchatActivity", 1, String.format("join hotchat uin:%s success:%s errorMsg:%s", new Object[] { paramString1, Boolean.valueOf(paramBoolean), paramString3 }));
  }
  
  public void a(boolean paramBoolean, HotChatInfo paramHotChatInfo, Common.WifiPOIInfo paramWifiPOIInfo, int paramInt, String paramString)
  {
    if (!paramBoolean)
    {
      QLog.e("HotchatActivity", 1, String.format("[onQuickJoinHotChat] failed code:%s result:%s", new Object[] { paramString, Integer.valueOf(paramInt) }));
      paramHotChatInfo = Message.obtain();
      paramHotChatInfo.what = 3;
      paramHotChatInfo.obj = acfp.m(2131707202);
      if (HotChatCenterFragment.a(this.this$0) != null) {
        HotChatCenterFragment.a(this.this$0).sendMessage(paramHotChatInfo);
      }
      return;
      break label181;
      break label181;
    }
    label181:
    label488:
    do
    {
      do
      {
        Iterator localIterator;
        do
        {
          do
          {
            paramWifiPOIInfo = paramString;
            if (TextUtils.isEmpty(paramString))
            {
              paramWifiPOIInfo = paramString;
              if (paramHotChatInfo != null) {
                paramWifiPOIInfo = paramHotChatInfo.name;
              }
            }
            if (paramWifiPOIInfo != null) {
              break;
            }
            paramHotChatInfo = Message.obtain();
            paramHotChatInfo.obj = acfp.m(2131707200);
            paramHotChatInfo.what = 3;
          } while (HotChatCenterFragment.a(this.this$0) == null);
          HotChatCenterFragment.a(this.this$0).sendMessage(paramHotChatInfo);
          return;
          if ((this.this$0.ij == null) || (this.this$0.ij.size() <= 0)) {
            break;
          }
          localIterator = this.this$0.ij.entrySet().iterator();
        } while (!localIterator.hasNext());
        Object localObject = (Map.Entry)localIterator.next();
        if (localObject == null) {
          break;
        }
        paramString = (String)((Map.Entry)localObject).getValue();
        localObject = (String)((Map.Entry)localObject).getKey();
        if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(paramWifiPOIInfo))) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("HotchatActivity", 2, "onQuickJoinHotChat, hotcode:" + paramWifiPOIInfo);
        }
        paramWifiPOIInfo = Message.obtain();
        if ((paramHotChatInfo == null) || ((paramInt != 1) && (paramInt != 2))) {
          break label488;
        }
        paramWifiPOIInfo.what = 2;
        paramWifiPOIInfo.obj = new Object[] { paramHotChatInfo.troopUin, paramHotChatInfo.troopCode, paramHotChatInfo.name, Integer.valueOf(paramHotChatInfo.apolloGameId) };
        if (paramHotChatInfo.apolloGameId > 0) {
          VipUtils.a(null, "cmshow", "Apollo", "join_reliao", 1, 0, new String[] { String.valueOf(paramHotChatInfo.apolloGameId) });
        }
        if (HotChatCenterFragment.a(this.this$0).get() != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("HotchatActivity", 2, String.format("[onQuickJoinHotChat] remove uin:%s code:%s", new Object[] { localObject, paramString }));
          }
          ((acfs)HotChatCenterFragment.a(this.this$0).get()).kg((String)localObject);
        }
        this.this$0.ij.remove(localObject);
      } while (HotChatCenterFragment.a(this.this$0) == null);
      HotChatCenterFragment.a(this.this$0).sendMessage(paramWifiPOIInfo);
      HotChatCenterFragment.a(this.this$0).sendEmptyMessage(1);
      return;
      QLog.e("HotchatActivity", 1, "[onQuickJoinHotChat] join failed");
      paramHotChatInfo = Message.obtain();
      paramHotChatInfo.obj = acfp.m(2131707201);
      paramHotChatInfo.what = 3;
    } while (HotChatCenterFragment.a(this.this$0) == null);
    HotChatCenterFragment.a(this.this$0).sendMessage(paramHotChatInfo);
    return;
    QLog.e("HotchatActivity", 1, "[onQuickJoinHotChat] not click at all");
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    super.a(paramBoolean, paramString1, paramInt, paramString2, paramString3);
    QLog.e("HotchatActivity", 1, String.format("Kicked out  hotchat uin:%s success:%s errorMsg:%s", new Object[] { paramString1, Boolean.valueOf(paramBoolean), paramString3 }));
  }
  
  public void b(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    super.b(paramBoolean, paramString1, paramInt, paramString2, paramString3);
    QLog.e("HotchatActivity", 1, String.format("Kicked out hotchat by admin  uin:%s success:%s errorMsg:%s", new Object[] { paramString1, Boolean.valueOf(paramBoolean), paramString3 }));
  }
  
  public void f(String paramString1, boolean paramBoolean, String paramString2)
  {
    super.f(paramString1, paramBoolean, paramString2);
    if (HotChatCenterFragment.a(this.this$0) != null) {
      HotChatCenterFragment.a(this.this$0).sendEmptyMessage(1);
    }
    QLog.e("HotchatActivity", 1, String.format("Exit hotchat uin:%s success:%s errorMsg:%s", new Object[] { paramString1, Boolean.valueOf(paramBoolean), paramString2 }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abjf
 * JD-Core Version:    0.7.0.1
 */