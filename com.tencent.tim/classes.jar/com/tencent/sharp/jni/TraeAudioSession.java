package com.tencent.sharp.jni;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Process;
import com.tencent.qphone.base.util.QLog;
import jlc;

public class TraeAudioSession
  extends BroadcastReceiver
{
  static int s_nSessionIdAllocator;
  private boolean _canSwtich2Earphone = true;
  private String _connectedDev = "DEVICE_NONE";
  private a a;
  private Context mContext;
  private boolean mIsHostside;
  private long mSessionId = -9223372036854775808L;
  
  public TraeAudioSession(Context paramContext, a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "TraeAudioSession create");
    }
    boolean bool;
    Object localObject;
    if (Process.myPid() == TraeAudioManager._gHostProcessId)
    {
      bool = true;
      this.mIsHostside = bool;
      this.mSessionId = requestSessionId();
      this.a = parama;
      this.mContext = paramContext;
      if ((paramContext == null) && (QLog.isColorLevel()))
      {
        StringBuilder localStringBuilder = new StringBuilder().append("AudioSession | Invalid parameters: ctx = ");
        if (paramContext != null) {
          break label182;
        }
        localObject = "null";
        label101:
        localObject = localStringBuilder.append((String)localObject).append("; cb = ");
        if (parama != null) {
          break label189;
        }
      }
    }
    label182:
    label189:
    for (parama = "null";; parama = "{object}")
    {
      QLog.w("TRAE", 2, parama);
      parama = new IntentFilter();
      parama.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES");
      parama.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
      if ((paramContext != null) && (paramContext.registerReceiver(this, parama) == null)) {}
      L(true);
      return;
      bool = false;
      break;
      localObject = "{object}";
      break label101;
    }
  }
  
  private int L(boolean paramBoolean)
  {
    if (this.mContext == null) {
      return -1;
    }
    if (this.mIsHostside) {
      return TraeAudioManager.a(paramBoolean, this.mSessionId, this.mContext);
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_REGISTERAUDIOSESSION");
    localIntent.putExtra("REGISTERAUDIOSESSION_ISREGISTER", paramBoolean);
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public static long requestSessionId()
  {
    long l = Process.myPid();
    int i = s_nSessionIdAllocator + 1;
    s_nSessionIdAllocator = i;
    return (l << 32) + i;
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, Uri paramUri, String paramString1, boolean paramBoolean, int paramInt3, String paramString2)
  {
    if (this.mIsHostside) {
      return TraeAudioManager.a(paramLong, "OPERATION_STARTRING", this.mSessionId, this.mIsHostside, paramInt1, paramInt2, paramUri, paramString1, paramBoolean, paramInt3, paramString2, false);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_RING_DATASOURCE", paramInt1);
    localIntent.putExtra("PARAM_RING_RSID", paramInt2);
    localIntent.putExtra("PARAM_RING_URI", paramUri);
    localIntent.putExtra("PARAM_RING_FILEPATH", paramString1);
    localIntent.putExtra("PARAM_RING_LOOP", paramBoolean);
    localIntent.putExtra("PARAM_RING_LOOPCOUNT", paramInt3);
    localIntent.putExtra("PARAM_RING_MODE", false);
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", paramString2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STARTRING");
    jlc.a(localIntent, paramLong);
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, Uri paramUri, String paramString1, boolean paramBoolean1, int paramInt3, String paramString2, boolean paramBoolean2)
  {
    if (this.mIsHostside) {
      return TraeAudioManager.a(paramLong, "OPERATION_STARTRING", this.mSessionId, this.mIsHostside, paramInt1, paramInt2, paramUri, paramString1, paramBoolean1, paramInt3, paramString2, paramBoolean2);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_RING_DATASOURCE", paramInt1);
    localIntent.putExtra("PARAM_RING_RSID", paramInt2);
    localIntent.putExtra("PARAM_RING_URI", paramUri);
    localIntent.putExtra("PARAM_RING_FILEPATH", paramString1);
    localIntent.putExtra("PARAM_RING_LOOP", paramBoolean1);
    localIntent.putExtra("PARAM_RING_LOOPCOUNT", paramInt3);
    localIntent.putExtra("PARAM_RING_MODE", paramBoolean2);
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", paramString2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STARTRING");
    jlc.a(localIntent, paramLong);
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int a(long paramLong, String paramString1, String paramString2)
  {
    if (this.mIsHostside) {
      return TraeAudioManager.a(paramLong, "OPERATION_STARTSERVICE", this.mSessionId, this.mIsHostside, paramString1, paramString2);
    }
    if ((this.mContext == null) || (paramString1 == null) || (paramString1.length() <= 0)) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STARTSERVICE");
    localIntent.putExtra("EXTRA_DATA_DEVICECONFIG", paramString1);
    localIntent.putExtra("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON", paramString2);
    jlc.a(localIntent, paramLong);
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int aq(long paramLong)
  {
    return TraeAudioManager.ao(paramLong);
  }
  
  public int ar(long paramLong)
  {
    if (this.mIsHostside) {
      return TraeAudioManager.a(paramLong, "OPERATION_GETCONNECTEDDEVICE", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETCONNECTEDDEVICE");
    jlc.a(localIntent, paramLong);
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int as(long paramLong)
  {
    if (this.mIsHostside) {
      return TraeAudioManager.b(paramLong, "OPERATION_STOPRING", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STOPRING");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int b(long paramLong, String paramString)
  {
    if (this.mIsHostside) {
      return TraeAudioManager.a(paramLong, "OPERATION_CONNECTDEVICE", this.mSessionId, this.mIsHostside, paramString);
    }
    if ((this.mContext == null) || (paramString == null) || (paramString.length() <= 0)) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_CONNECTDEVICE");
    localIntent.putExtra("CONNECTDEVICE_DEVICENAME", paramString);
    jlc.a(localIntent, paramLong);
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int connectHighestPriorityDevice()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.connectHighestPriorityDevice("OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int getDeviceList()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.getDeviceList("OPERATION_GETDEVICELIST", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETDEVICELIST");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int getStreamType()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.getStreamType("OPERATION_GETSTREAMTYPE", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETSTREAMTYPE");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    Object localObject;
    int j;
    long l2;
    boolean bool;
    label305:
    int i;
    label361:
    label1264:
    do
    {
      do
      {
        String str1;
        String str2;
        String str3;
        do
        {
          long l1;
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
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              for (;;)
                              {
                                return;
                                try
                                {
                                  paramContext = paramIntent.getAction();
                                  l1 = paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L);
                                  localObject = paramIntent.getStringExtra("PARAM_OPERATION");
                                  j = paramIntent.getIntExtra("PARAM_RES_ERRCODE", 0);
                                  l2 = jlc.a(paramIntent);
                                  if (QLog.isDevelopLevel()) {
                                    QLog.w("TraeAudioSession", 1, "onReceive, action[" + paramContext + "], nSessionId[" + l1 + "], strOperation[" + (String)localObject + "], errCode[" + j + "], seq[" + l2 + "]");
                                  }
                                  if (!"com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY".equals(paramContext)) {
                                    break label921;
                                  }
                                  if (!"NOTIFY_SERVICE_STATE".equals(localObject)) {
                                    break label305;
                                  }
                                  bool = paramIntent.getBooleanExtra("NOTIFY_SERVICE_STATE_DATE", false);
                                  if (QLog.isColorLevel()) {
                                    QLog.w("TraeAudioSession", 1, "onReceive.onServiceStateUpdate, on[" + bool + "], seq[" + l2 + "]");
                                  }
                                  if (this.a != null)
                                  {
                                    this.a.S(l2, bool);
                                    return;
                                  }
                                }
                                catch (Exception paramContext) {}
                              }
                            } while (!QLog.isColorLevel());
                            QLog.e("TRAE", 2, "AudioSession| nSessinId = " + this.mSessionId + " onReceive::intent:" + paramIntent.toString() + " intent.getAction():" + paramIntent.getAction() + " Exception:" + paramContext.getMessage());
                            return;
                            if (!"NOTIFY_DEVICELISTUPDATE".equals(localObject)) {
                              break;
                            }
                            localObject = paramIntent.getStringArrayExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST");
                            str1 = paramIntent.getStringExtra("EXTRA_DATA_CONNECTEDDEVICE");
                            str2 = paramIntent.getStringExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE");
                            str3 = paramIntent.getStringExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME");
                            paramContext = "\n";
                            bool = true;
                            i = 0;
                            if (i < localObject.length)
                            {
                              paramContext = paramContext + "AudioSession|    " + i + " " + localObject[i] + "\n";
                              if (localObject[i].equals("DEVICE_WIREDHEADSET")) {
                                break label2007;
                              }
                              if (!localObject[i].equals("DEVICE_BLUETOOTHHEADSET")) {
                                break label2010;
                              }
                              break label2007;
                            }
                            paramContext = paramContext + "\n";
                            if (QLog.isColorLevel()) {
                              QLog.w("TRAE", 2, "AudioSession|[onDeviceListUpdate]  connected:" + str1 + " prevConnected:" + str2 + " bt:" + str3 + " Num:" + localObject.length + paramContext);
                            }
                            this._canSwtich2Earphone = bool;
                            this._connectedDev = str1;
                          } while (this.a == null);
                          this.a.a(l2, (String[])localObject, str1, str2, str3);
                          return;
                          if (!"NOTIFY_DEVICECHANGABLE_UPDATE".equals(localObject)) {
                            break;
                          }
                          bool = paramIntent.getBooleanExtra("NOTIFY_DEVICECHANGABLE_UPDATE_DATE", true);
                          if (QLog.isColorLevel()) {
                            QLog.w("TraeAudioSession", 1, "onReceive.onDeviceChangabledUpdate, bIsChangabled[" + bool + "], seq[" + l2 + "]");
                          }
                        } while (this.a == null);
                        this.a.onDeviceChangabledUpdate(bool);
                        return;
                        if (!"NOTIFY_STREAMTYPE_UPDATE".equals(localObject)) {
                          break;
                        }
                        i = paramIntent.getIntExtra("EXTRA_DATA_STREAMTYPE", -1);
                        if (QLog.isColorLevel()) {
                          QLog.w("TraeAudioSession", 1, "onReceive.NOTIFY_STREAMTYPE_UPDATE, errCode[" + j + "], st[" + i + "], seq[" + l2 + "]");
                        }
                      } while (this.a == null);
                      this.a.U(l2, i);
                      return;
                      if (!"NOTIFY_ROUTESWITCHSTART".equals(localObject)) {
                        break;
                      }
                      paramContext = paramIntent.getStringExtra("EXTRA_DATA_ROUTESWITCHSTART_FROM");
                      localObject = paramIntent.getStringExtra("EXTRA_DATA_ROUTESWITCHSTART_TO");
                    } while ((this.a == null) || (paramContext == null) || (localObject == null));
                    this.a.onAudioRouteSwitchStart(paramContext, (String)localObject);
                    return;
                    if (!"NOTIFY_ROUTESWITCHEND".equals(localObject)) {
                      break;
                    }
                    paramContext = paramIntent.getStringExtra("EXTRA_DATA_ROUTESWITCHEND_DEV");
                    l1 = paramIntent.getLongExtra("EXTRA_DATA_ROUTESWITCHEND_TIME", -1L);
                  } while ((this.a == null) || (paramContext == null) || (l1 == -1L));
                  this.a.onAudioRouteSwitchEnd(paramContext, l1);
                  return;
                } while (!"NOTIFY_BEGIN_CONNECTED_DEVICE".equals(localObject));
                paramContext = paramIntent.getStringExtra("CONNECTDEVICE_DEVICENAME");
              } while (this.a == null);
              this.a.kP(paramContext);
              return;
            } while (!"com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES".equals(paramContext));
            QLog.w("TraeAudioSession", 1, "ACTION_TRAEAUDIOMANAGER_RES, mSessionId[" + this.mSessionId + "], nSessionId[" + l1 + "], strOperation[" + (String)localObject + "], seq[" + l2 + "]");
          } while (this.mSessionId != l1);
          if (!"OPERATION_GETDEVICELIST".equals(localObject)) {
            break;
          }
          localObject = paramIntent.getStringArrayExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST");
          str1 = paramIntent.getStringExtra("EXTRA_DATA_CONNECTEDDEVICE");
          str2 = paramIntent.getStringExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE");
          str3 = paramIntent.getStringExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME");
          paramContext = "\n";
          bool = true;
          i = 0;
          if (i < localObject.length)
          {
            paramContext = paramContext + "AudioSession|    " + i + " " + localObject[i] + "\n";
            if (localObject[i].equals("DEVICE_WIREDHEADSET")) {
              break label2017;
            }
            if (!localObject[i].equals("DEVICE_BLUETOOTHHEADSET")) {
              break label2020;
            }
            break label2017;
          }
          paramContext = paramContext + "\n";
          this._canSwtich2Earphone = bool;
          this._connectedDev = str1;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder().append("OPERATION_GETDEVICELIST, errCode[").append(j).append("], connected[").append(str1).append("], prevConnected[").append(str2).append("], bt[").append(str3).append("], Num[").append(localObject.length).append("], mCallback[");
            if (this.a == null) {
              break label2027;
            }
            bool = true;
            QLog.w("TraeAudioSession", 1, bool + "], seq[" + l2 + "], str[" + paramContext + "]");
          }
        } while (this.a == null);
        this.a.onGetDeviceListRes(j, (String[])localObject, str1, str2, str3);
        return;
        if (!"OPERATION_CONNECTDEVICE".equals(localObject)) {
          break;
        }
        paramContext = paramIntent.getStringExtra("CONNECTDEVICE_RESULT_DEVICENAME");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "AudioSession|[onConnectDeviceRes] err:" + j + " dev:" + paramContext);
        }
      } while (this.a == null);
      localObject = this.a;
      if (j != 0) {
        break label2033;
      }
      bool = true;
      ((a)localObject).onConnectDeviceRes(j, paramContext, bool);
      return;
      if (!"OPERATION_EARACTION".equals(localObject)) {
        break;
      }
      i = paramIntent.getIntExtra("EXTRA_EARACTION", -1);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "AudioSession|[onConnectDeviceRes] err:" + j + " earAction:" + i);
      }
    } while (this.a == null);
    label921:
    label1064:
    return;
    label1417:
    if ("OPERATION_ISDEVICECHANGABLED".equals(localObject))
    {
      bool = paramIntent.getBooleanExtra("ISDEVICECHANGABLED_REULT_ISCHANGABLED", false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("AudioSession|[onIsDeviceChangabledRes] err:").append(j).append(" Changabled:");
        if (!bool) {
          break label2039;
        }
      }
    }
    label2007:
    label2010:
    label2017:
    label2020:
    label2027:
    label2033:
    label2039:
    for (paramContext = "Y";; paramContext = "N")
    {
      QLog.w("TRAE", 2, paramContext);
      if (this.a == null) {
        break;
      }
      this.a.onIsDeviceChangabledRes(j, bool);
      return;
      if ("OPERATION_GETCONNECTEDDEVICE".equals(localObject))
      {
        paramContext = paramIntent.getStringExtra("GETCONNECTEDDEVICE_REULT_LIST");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "AudioSession|[onGetConnectedDeviceRes] err:" + j + " dev:" + paramContext);
        }
        if (this.a == null) {
          break;
        }
        this.a.onGetConnectedDeviceRes(j, paramContext);
        return;
      }
      if ("OPERATION_GETCONNECTINGDEVICE".equals(localObject))
      {
        paramContext = paramIntent.getStringExtra("GETCONNECTINGDEVICE_REULT_LIST");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "AudioSession|[onGetConnectingDeviceRes] err:" + j + " dev:" + paramContext);
        }
        if (this.a == null) {
          break;
        }
        this.a.onGetConnectingDeviceRes(j, paramContext);
        return;
      }
      if ("OPERATION_GETSTREAMTYPE".equals(localObject))
      {
        i = paramIntent.getIntExtra("EXTRA_DATA_STREAMTYPE", -1);
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "AudioSession|[onGetStreamTypeRes] err:" + j + " st:" + i);
        }
        if (this.a == null) {
          break;
        }
        this.a.onGetStreamTypeRes(j, i);
        return;
      }
      if ("NOTIFY_RING_COMPLETION".equals(localObject))
      {
        paramContext = paramIntent.getStringExtra("PARAM_RING_USERDATA_STRING");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 1, "\"AudioSession|[onRingCompletion], errCode[" + j + "], userData[" + paramContext + "], seq[" + l2 + "]");
        }
        if (this.a == null) {
          break;
        }
        this.a.g(l2, j, paramContext);
        return;
      }
      if (!"OPERATION_VOICECALL_PREPROCESS".equals(localObject)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "AudioSession|[onVoicecallPreprocess] err:" + j);
      }
      if (this.a == null) {
        break;
      }
      this.a.onVoicecallPreprocessRes(j);
      return;
      bool = false;
      i += 1;
      break label361;
      bool = false;
      i += 1;
      break label1064;
      bool = false;
      break label1264;
      bool = false;
      break label1417;
    }
  }
  
  public void release()
  {
    if (this.mContext != null) {}
    try
    {
      this.mContext.unregisterReceiver(this);
      label15:
      L(false);
      this.mContext = null;
      this.a = null;
      return;
    }
    catch (Exception localException)
    {
      break label15;
    }
  }
  
  public int stopService()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.stopService("OPERATION_STOPSERVICE", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STOPSERVICE");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int voiceCallAudioParamChanged(int paramInt1, int paramInt2)
  {
    if (this.mIsHostside) {
      return TraeAudioManager.voiceCallAudioParamChanged("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST", this.mSessionId, this.mIsHostside, paramInt1, paramInt2);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_MODEPOLICY", paramInt1);
    localIntent.putExtra("PARAM_STREAMTYPE", paramInt2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_AUDIOPARAM_CHANGED");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int voiceCallPostprocess()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.voicecallPostprocess("OPERATION_VOICECALL_POSTROCESS", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_POSTROCESS");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int voiceCallPreprocess(int paramInt1, int paramInt2)
  {
    if (this.mIsHostside) {
      return TraeAudioManager.voicecallPreprocess("OPERATION_VOICECALL_PREPROCESS", this.mSessionId, this.mIsHostside, paramInt1, paramInt2);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_MODEPOLICY", paramInt1);
    localIntent.putExtra("PARAM_STREAMTYPE", paramInt2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_PREPROCESS");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract void S(long paramLong, boolean paramBoolean);
    
    public abstract void U(long paramLong, int paramInt);
    
    public abstract void a(long paramLong, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3);
    
    public abstract void g(long paramLong, int paramInt, String paramString);
    
    public abstract void kP(String paramString);
    
    public abstract void onAudioRouteSwitchEnd(String paramString, long paramLong);
    
    public abstract void onAudioRouteSwitchStart(String paramString1, String paramString2);
    
    public abstract void onConnectDeviceRes(int paramInt, String paramString, boolean paramBoolean);
    
    public abstract void onDeviceChangabledUpdate(boolean paramBoolean);
    
    public abstract void onGetConnectedDeviceRes(int paramInt, String paramString);
    
    public abstract void onGetConnectingDeviceRes(int paramInt, String paramString);
    
    public abstract void onGetDeviceListRes(int paramInt, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3);
    
    public abstract void onGetStreamTypeRes(int paramInt1, int paramInt2);
    
    public abstract void onIsDeviceChangabledRes(int paramInt, boolean paramBoolean);
    
    public abstract void onVoicecallPreprocessRes(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioSession
 * JD-Core Version:    0.7.0.1
 */