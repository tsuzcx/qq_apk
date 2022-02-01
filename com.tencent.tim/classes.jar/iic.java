import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class iic
{
  public static String TAG = "GAudioMsgReceiver";
  boolean PJ = false;
  iic.a a;
  VideoAppInterface mApp;
  
  public iic(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
    this.a = new iic.a(paramVideoAppInterface);
  }
  
  public void amw()
  {
    if (this.PJ)
    {
      this.mApp.getApplication().unregisterReceiver(this.a);
      this.PJ = false;
    }
  }
  
  public void amx()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "regist QQGAudioMsg Receiver");
    }
    IntentFilter localIntentFilter = new IntentFilter("tencent.video.q2v.MultiVideo");
    localIntentFilter.addAction("tencent.video.q2v.AddDiscussMember");
    localIntentFilter.addAction("tencent.video.q2v.SwitchToMultiAudo");
    localIntentFilter.addAction("tencent.video.q2v.GroupSystemMsg");
    localIntentFilter.addAction("tencent.video.q2v.SelectMember");
    localIntentFilter.addAction("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED");
    localIntentFilter.addAction("tencent.video.q2v.GvideoGift");
    localIntentFilter.addAction("tencent.video.q2v.GvideoLevelUpgrade");
    localIntentFilter.addAction("tencent.video.q2v.GvideoMemUntInvite");
    localIntentFilter.addAction("tencent.video.q2v.close_invite_msg_box_by_invite_id");
    localIntentFilter.addAction("tencent.video.q2v.randomMultiOwnerOnlinePush");
    localIntentFilter.addAction("tencent.video.q2v.random1V1OnlinePush");
    localIntentFilter.addAction("tencent.video.q2v.avreportOnlinePush");
    localIntentFilter.addAction("tencent.video.q2v.AudioTransPush");
    localIntentFilter.addAction("tencent.video.q2v.AudioEngineReady");
    localIntentFilter.addAction("tencent.video.q2v.GroupInfoChanged");
    if (this.mApp.getApplication().registerReceiver(this.a, localIntentFilter) != null) {
      this.PJ = true;
    }
  }
  
  static class a
    extends BroadcastReceiver
  {
    VideoAppInterface mApp;
    
    a(VideoAppInterface paramVideoAppInterface)
    {
      this.mApp = paramVideoAppInterface;
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
      long l1;
      long l2;
      label873:
      label2410:
      do
      {
        do
        {
          do
          {
            int i;
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        long l3;
                        int j;
                        long l4;
                        int k;
                        do
                        {
                          do
                          {
                            do
                            {
                              boolean bool;
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        String str1;
                                        String str2;
                                        do
                                        {
                                          do
                                          {
                                            do
                                            {
                                              do
                                              {
                                                do
                                                {
                                                  return;
                                                  paramContext = this.mApp.b();
                                                  if (paramContext != null) {
                                                    break;
                                                  }
                                                } while (!QLog.isColorLevel());
                                                QLog.d(iic.TAG, 2, " onReceive: " + paramIntent.getAction());
                                                return;
                                                if (QLog.isColorLevel()) {
                                                  QLog.w(iic.TAG, 1, "GAudioMsgReceiver_onReceive[" + paramIntent.getAction() + "]");
                                                }
                                                if (paramIntent.getAction().equals("tencent.video.q2v.GvideoMemUntInvite"))
                                                {
                                                  l1 = paramIntent.getLongExtra("groupId", 0L);
                                                  l2 = paramIntent.getLongExtra("dealMemUin", 0L);
                                                  paramContext = paramIntent.getStringExtra("invitedId");
                                                  this.mApp.l(new Object[] { Integer.valueOf(513), Long.valueOf(l1), Long.valueOf(l2), paramContext });
                                                  return;
                                                }
                                                if (paramIntent.getAction().equals("tencent.video.q2v.close_invite_msg_box_by_invite_id"))
                                                {
                                                  l1 = paramIntent.getLongExtra("groupId", 0L);
                                                  paramContext = paramIntent.getStringExtra("inviteId");
                                                  this.mApp.l(new Object[] { Integer.valueOf(516), Long.valueOf(l1), paramContext });
                                                  return;
                                                }
                                                if (!paramIntent.getAction().equals("tencent.video.q2v.MultiVideo")) {
                                                  break label1025;
                                                }
                                                i = paramIntent.getIntExtra("type", -1);
                                                if (QLog.isColorLevel()) {
                                                  QLog.d(iic.TAG, 2, "GAudioMsgReceiver type: " + i);
                                                }
                                                if (i != 26) {
                                                  break;
                                                }
                                                l1 = paramIntent.getLongExtra("discussId", 0L);
                                              } while ((!paramContext.OB) || (paramContext.kJ != l1));
                                              paramIntent = new Intent();
                                              paramIntent.setAction("tencent.av.v2q.MultiVideo");
                                              paramIntent.putExtra("type", 25);
                                              paramIntent.putExtra("relationId", l1);
                                              paramIntent.putExtra("relationType", 2);
                                              paramIntent.putExtra("from", "VideoAppInterface1");
                                              paramIntent.setPackage(this.mApp.getApp().getPackageName());
                                              this.mApp.getApp().sendBroadcast(paramIntent);
                                              paramContext.b(paramContext.alr, paramContext.kJ, 88);
                                              this.mApp.l(new Object[] { Integer.valueOf(66), Long.valueOf(l1) });
                                              return;
                                              if (i == 27)
                                              {
                                                paramContext.w(paramIntent.getByteArrayExtra("buffer"));
                                                return;
                                              }
                                              if (i != 30) {
                                                break;
                                              }
                                              paramIntent = paramIntent.getByteArrayExtra("buffer");
                                              try
                                              {
                                                paramContext.x(paramIntent);
                                                return;
                                              }
                                              catch (UnsatisfiedLinkError paramContext) {}
                                            } while (!QLog.isColorLevel());
                                            QLog.d(iic.TAG, 2, "GAudioMsgReceiver TYPE_GAUDIO_AUDIO_C2S_ACK UnsatisfiedLinkError!");
                                            return;
                                            if (i == 24)
                                            {
                                              paramContext.a(paramIntent.getLongExtra("discussId", 0L), paramIntent.getStringExtra("cmdUin"), paramIntent.getStringArrayExtra("uins"));
                                              return;
                                            }
                                            if (i != 31) {
                                              break label873;
                                            }
                                            l1 = paramIntent.getLongExtra("discussId", 0L);
                                            localObject = paramIntent.getStringExtra("cmdUin");
                                            paramIntent = paramIntent.getStringArrayExtra("uins");
                                            if ((paramIntent != null) && (paramIntent.length != 0)) {
                                              break;
                                            }
                                          } while (!QLog.isColorLevel());
                                          QLog.e(iic.TAG, 2, "GAudioMsgReceiver-->uinlist is null");
                                          return;
                                          str1 = paramIntent[0];
                                          str2 = this.mApp.getCurrentAccountUin();
                                          if (QLog.isColorLevel()) {
                                            QLog.d(iic.TAG, 2, "TYPE_GAUDIO_MEMBER_KICKOUT-->discuss id = " + l1 + ", cmdUin = " + (String)localObject + ", outUin = " + str1 + ", selfUin = " + str2 + ", uinList.size = " + paramIntent.length);
                                          }
                                          if ((paramContext.OB) && (paramContext.kJ == l1) && (str1.compareTo(str2) == 0))
                                          {
                                            paramContext.b(paramContext.alr, paramContext.kJ, 75);
                                            paramContext = new Intent();
                                            paramContext.setAction("tencent.av.v2q.MultiVideo");
                                            paramContext.putExtra("type", 25);
                                            paramContext.putExtra("relationId", l1);
                                            paramContext.putExtra("relationType", 2);
                                            paramContext.putExtra("from", "VideoAppInterface2");
                                            paramContext.setPackage(this.mApp.getApp().getPackageName());
                                            this.mApp.getApp().sendBroadcast(paramContext);
                                            return;
                                          }
                                        } while ((paramContext.b().state != 7) || (paramContext.kM != l1) || (str1.compareTo(str2) != 0));
                                        paramContext.b().Y("GAudioMsgReceiver", 0);
                                        this.mApp.l(new Object[] { Integer.valueOf(67), Long.valueOf(paramContext.kM), Integer.valueOf(4) });
                                        paramContext.kM = 0L;
                                        paramContext.alF = 0;
                                        return;
                                        if (i != 34) {
                                          break;
                                        }
                                        l1 = paramIntent.getLongExtra("relationId", 0L);
                                      } while ((!paramContext.OB) || (l1 != paramContext.kJ));
                                      paramContext.b(1, l1, 76);
                                      paramIntent = new Intent();
                                      paramIntent.setAction("tencent.av.v2q.MultiVideo");
                                      paramIntent.putExtra("MultiAVType", paramContext.b().anb);
                                      paramIntent.putExtra("type", 25);
                                      paramIntent.putExtra("relationId", l1);
                                      paramIntent.putExtra("relationType", 1);
                                      paramIntent.putExtra("from", "VideoAppInterface3");
                                      paramIntent.setPackage(this.mApp.getApp().getPackageName());
                                      this.mApp.getApp().sendBroadcast(paramIntent);
                                      return;
                                    } while ((i != 35) || (!paramContext.OB));
                                    paramContext.alG();
                                    return;
                                    if (!paramIntent.getAction().equals("tencent.video.q2v.AddDiscussMember")) {
                                      break;
                                    }
                                  } while (!paramIntent.getBooleanExtra("result", false));
                                  paramContext.d(paramIntent.getLongExtra("roomId", paramContext.kJ), paramIntent.getStringArrayListExtra("newMemberUin"));
                                  return;
                                  if (!paramIntent.getAction().equals("tencent.video.q2v.SwitchToMultiAudo")) {
                                    break;
                                  }
                                } while (!paramIntent.getBooleanExtra("result", false));
                                l1 = paramIntent.getLongExtra("roomId", 0L);
                                Object localObject = paramIntent.getStringArrayListExtra("memberUin");
                                i = paramIntent.getIntExtra("uinType", 3000);
                                l2 = jlc.a(paramIntent);
                                l3 = AudioHelper.hG();
                                QLog.w(iic.TAG, 1, "switchToMultiAudio, seq[" + l2 + "], newseq[" + l3 + "], [discussion]");
                                paramContext.a(l3, i, l1, (ArrayList)localObject);
                                return;
                                if (paramIntent.getAction().equals("tencent.video.q2v.GroupInfoChanged"))
                                {
                                  paramContext = aqji.b.a(paramIntent.getExtras());
                                  this.mApp.l(new Object[] { Integer.valueOf(169), paramContext });
                                  return;
                                }
                                if (!paramIntent.getAction().equals("tencent.video.q2v.GroupSystemMsg")) {
                                  break label1614;
                                }
                                i = paramIntent.getIntExtra("type", -1);
                                j = paramIntent.getIntExtra("relationType", -1);
                                l1 = paramIntent.getLongExtra("relationId", -1L);
                                l2 = paramIntent.getLongExtra("userUin", -1L);
                                bool = paramIntent.getBooleanExtra("needSendCmd", false);
                                if (QLog.isColorLevel()) {
                                  QLog.w(iic.TAG, 1, "GAudioMsgReceiver_onReceive[tencent.video.q2v.GroupSystemMsg], type[" + i + "], relationType[" + j + "], relationId[" + l1 + "], userUin[" + l2 + "], needSendCmd[" + bool + "]");
                                }
                                if ((i != 7) && (i != 8)) {
                                  break label1600;
                                }
                                if ((!paramContext.OB) || (paramContext.kJ != l1)) {
                                  break;
                                }
                              } while ((paramContext.b().anb == 2) && (this.mApp.cq(l1 + "")));
                              paramContext.b(1, l1, 77);
                              paramContext.a(l1, l2, j, i, bool);
                              paramIntent = new Intent();
                              paramIntent.setAction("tencent.av.v2q.MultiVideo");
                              paramIntent.putExtra("type", 25);
                              paramIntent.putExtra("relationId", l1);
                              paramIntent.putExtra("relationType", j);
                              paramIntent.putExtra("MultiAVType", paramContext.b().anb);
                              if (i == 7) {
                                paramIntent.putExtra("reason", 4);
                              }
                              for (;;)
                              {
                                paramIntent.putExtra("from", "VideoAppInterface4");
                                paramIntent.setPackage(this.mApp.getApp().getPackageName());
                                this.mApp.getApp().sendBroadcast(paramIntent);
                                return;
                                paramIntent.putExtra("reason", 8);
                              }
                              paramContext.a(l1, l2, j, i, bool);
                              return;
                              if (!paramIntent.getAction().equals("tencent.video.q2v.SelectMember")) {
                                break;
                              }
                              if (QLog.isColorLevel()) {
                                QLog.d(iic.TAG, 2, "ACTION_SELECT_MEMBER");
                              }
                              i = paramIntent.getIntExtra("InviteCount", 0);
                              paramIntent = paramIntent.getStringExtra("FirstName");
                              if (QLog.isColorLevel()) {
                                QLog.d(iic.TAG, 2, "ACTION_SELECT_MEMBER --> InviteCount = " + i + " , FirstName = " + paramIntent);
                              }
                            } while ((i <= 0) || (paramContext == null));
                            paramContext.O(i, paramIntent);
                            return;
                            if (paramIntent.getAction().equals("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED"))
                            {
                              paramContext.hK(paramIntent.getBooleanExtra("isResume", false));
                              return;
                            }
                            if (!paramIntent.getAction().equals("tencent.video.q2v.GvideoGift")) {
                              break;
                            }
                            i = paramIntent.getIntExtra("type", -1);
                            l1 = paramIntent.getLongExtra("fromUin", -1L);
                            l2 = paramIntent.getLongExtra("toUin", -1L);
                            j = paramIntent.getIntExtra("count", -1);
                            l3 = paramIntent.getLongExtra("seq", -1L);
                            l4 = paramIntent.getLongExtra("groupId", -1L);
                          } while ((i <= 0) || (l1 <= 0L) || (l2 <= 0L) || (j <= 0) || (l4 <= 0L) || (paramContext == null));
                          paramContext.a(i, l1, l2, j, l3, l4);
                          return;
                          if (!paramIntent.getAction().equals("tencent.video.q2v.GvideoLevelUpgrade")) {
                            break;
                          }
                          i = paramIntent.getIntExtra("type", -1);
                          l1 = paramIntent.getLongExtra("fromUin", -1L);
                          l2 = paramIntent.getLongExtra("toUin", -1L);
                          j = paramIntent.getIntExtra("enable", -1);
                          k = paramIntent.getIntExtra("level", -1);
                          l3 = paramIntent.getLongExtra("seq", -1L);
                          l4 = paramIntent.getLongExtra("groupId", -1L);
                        } while ((i <= 0) || (l1 <= 0L) || (l2 <= 0L) || (k <= 0) || (l4 <= 0L) || (paramContext == null));
                        paramContext.a(i, l1, l2, j, k, l3, l4);
                        return;
                        if (!paramIntent.getAction().equals("tencent.video.q2v.randomMultiOwnerOnlinePush")) {
                          break label2140;
                        }
                        if ((paramContext == null) || (paramContext.b() == null)) {
                          break;
                        }
                      } while (paramContext.b().relationType != 7);
                      this.mApp.l(new Object[] { Integer.valueOf(209), Long.valueOf(paramIntent.getLongExtra("group_id", 0L)), Integer.valueOf(paramIntent.getIntExtra("member_num", 0)), paramIntent.getStringExtra("string_data") });
                    } while (!QLog.isColorLevel());
                    QLog.d(iic.TAG, 2, "[random room owner] ACTION_RANDOM_MULTI_OWNER_ONLINE_PUSH");
                    return;
                  } while (paramContext.b() != null);
                  igd.aL(iic.TAG, "ACTION_RANDOM_MULTI_OWNER_ONLINE_PUSH videoController.getSessionInfo() == null");
                  return;
                  if (!paramIntent.getAction().equals("tencent.video.q2v.random1V1OnlinePush")) {
                    break;
                  }
                  if ((paramContext != null) && (paramContext.b() != null))
                  {
                    this.mApp.l(new Object[] { Integer.valueOf(210), Integer.valueOf(paramIntent.getIntExtra("rsptype", 0)), paramIntent.getStringExtra("rspbody") });
                    return;
                  }
                } while (paramContext.b() != null);
                igd.aL(iic.TAG, "ACTION_RANDOM_1V1_ONLINE_PUSH videoController.getSessionInfo() == null");
                return;
                if (!paramIntent.getAction().equals("tencent.video.q2v.AudioTransPush")) {
                  break;
                }
                if ((paramContext != null) && (paramContext.b() != null))
                {
                  i = paramIntent.getIntExtra("rsptype", 0);
                  paramContext = paramIntent.getByteArrayExtra("rspbody");
                  QLog.d(iic.TAG, 2, "ACTION_AUDIO_TRANS_PUSH rsptype=" + i + "|" + paramContext.length);
                  ((iji)this.mApp.getBusinessHandler(0)).d(i, paramContext);
                  return;
                }
              } while (paramContext.b() != null);
              igd.aL(iic.TAG, " ACTION_AUDIO_TRANS_PUSH videoController.getSessionInfo() == null");
              return;
              if (!paramIntent.getAction().equals("tencent.video.q2v.avreportOnlinePush")) {
                break label2410;
              }
              if ((paramContext == null) || (paramContext.b() == null)) {
                break;
              }
              i = paramIntent.getIntExtra("rsptype", 0);
            } while (i != 1);
            itj.a(this.mApp, i, paramIntent.getStringExtra("rspbody"));
            return;
          } while (paramContext.b() != null);
          igd.aL(iic.TAG, "ACTION_AV_REPORT_PUSH videoController.getSessionInfo() == null");
          return;
        } while (!"tencent.video.q2v.AudioEngineReady".equals(paramIntent.getAction()));
        l1 = paramIntent.getLongExtra("c2cuin", 0L);
        l2 = paramIntent.getLongExtra("c2croomid", 0L);
        QLog.d(iic.TAG, 1, "ACTION_OPPOSITE_AUDIO_ENGINE_READY:" + l1 + "|" + l2);
      } while ((l1 == 0L) || (l2 == 0L));
      label1025:
      label1600:
      label1614:
      label2140:
      paramContext.w(l1, l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iic
 * JD-Core Version:    0.7.0.1
 */