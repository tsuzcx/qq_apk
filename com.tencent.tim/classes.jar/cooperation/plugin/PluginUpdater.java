package cooperation.plugin;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import anpc;
import avfs;
import avgf;
import avgp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper.PluginInfoParser;
import com.tencent.mobileqq.startup.step.UpdatePluginVersion;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jnl;
import mqq.app.NewIntent;
import protocol.KQQConfig.GPS;
import protocol.KQQConfig.ReqUserInfo;
import tencent.im.plugin.ResourceConfig.GetResourceReqInfoV2;
import tencent.im.plugin.ResourceConfig.GetResourceReqV2;
import tencent.im.plugin.ResourceConfig.GetResourceRespInfoV2;
import tencent.im.plugin.ResourceConfig.GetResourceRespV2;

public class PluginUpdater
  implements Handler.Callback, Runnable
{
  private a a;
  private Context mContext;
  private Handler mHandler;
  private boolean mIsUpdating;
  private Map<String, PluginInfo> mPluginInfos = new HashMap();
  
  public PluginUpdater(Context paramContext, Handler paramHandler)
  {
    this.mContext = paramContext;
    this.mHandler = new Handler(paramHandler.getLooper(), this);
    paramContext = n(paramContext);
    boolean bool = avgf.K(paramContext);
    paramHandler = avgf.e(paramContext);
    if (paramHandler != null)
    {
      int n = paramHandler.length;
      int i = 0;
      if (i < n)
      {
        File localFile = paramHandler[i];
        Object localObject;
        int j;
        if (localFile.isFile())
        {
          if (!bool) {
            break label181;
          }
          int m = 0;
          localObject = UpdatePluginVersion.gV;
          int i1 = localObject.length;
          j = 0;
          label102:
          int k = m;
          if (j < i1)
          {
            String str = localObject[j];
            if (!localFile.getName().equals(str + ".cfg")) {
              break label172;
            }
            localFile.delete();
            k = 1;
          }
          if (k == 0) {
            break label181;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label172:
          j += 1;
          break label102;
          label181:
          localObject = avgf.a(localFile);
          if (localObject != null) {
            this.mPluginInfos.put(((PluginInfo)localObject).mID, localObject);
          } else {
            localFile.delete();
          }
        }
      }
    }
    if (bool) {
      avgf.D(paramContext);
    }
    QLog.d("plugin_tag", 1, "init plugin updater :" + this.mPluginInfos.size());
  }
  
  private void a(ResourceConfig.GetResourceRespV2 paramGetResourceRespV2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doOnGetPluginConfig");
    }
    Object localObject3;
    Object localObject1;
    Object localObject2;
    HashMap localHashMap;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    if (paramGetResourceRespV2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "onGetPluginConfig GetResourceRespV2: " + paramGetResourceRespV2 + "[add: " + paramGetResourceRespV2.addedResInfo.size() + ", remove: " + paramGetResourceRespV2.deletedResInfo.size() + ", update: " + paramGetResourceRespV2.updatedResInfo.size() + "]");
      }
      localObject3 = new PluginBaseInfoHelper.PluginInfoParser();
      ((PluginBaseInfoHelper.PluginInfoParser)localObject3).setResultClass(PluginInfo.class);
      localObject1 = new ArrayList();
      localObject2 = new HashMap();
      localHashMap = new HashMap();
      localObject4 = paramGetResourceRespV2.deletedResInfo.get().iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((List)localObject1).add(((ResourceConfig.GetResourceRespInfoV2)((Iterator)localObject4).next()).pkgName.get());
      }
      localObject4 = paramGetResourceRespV2.addedResInfo.get().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (ResourceConfig.GetResourceRespInfoV2)((Iterator)localObject4).next();
        localObject6 = (PluginInfo)PluginBaseInfoHelper.parseConfig(((ResourceConfig.GetResourceRespInfoV2)localObject5).resConf.get(), (PluginBaseInfoHelper.PluginInfoParser)localObject3);
        if (localObject6 != null)
        {
          ((PluginInfo)localObject6).mType = ((ResourceConfig.GetResourceRespInfoV2)localObject5).resSubType.get();
          ((PluginInfo)localObject6).mPackageName = ((ResourceConfig.GetResourceRespInfoV2)localObject5).pkgName.get();
          ((PluginInfo)localObject6).mCurVersion = ((ResourceConfig.GetResourceRespInfoV2)localObject5).newVer.get();
          ((PluginInfo)localObject6).mState = 0;
          ((HashMap)localObject2).put(((PluginInfo)localObject6).mID, localObject6);
        }
      }
      localObject4 = paramGetResourceRespV2.updatedResInfo.get().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (ResourceConfig.GetResourceRespInfoV2)((Iterator)localObject4).next();
        localObject6 = (PluginInfo)PluginBaseInfoHelper.parseConfig(((ResourceConfig.GetResourceRespInfoV2)localObject5).resConf.get(), (PluginBaseInfoHelper.PluginInfoParser)localObject3);
        if (localObject6 != null)
        {
          ((PluginInfo)localObject6).mType = ((ResourceConfig.GetResourceRespInfoV2)localObject5).resSubType.get();
          ((PluginInfo)localObject6).mPackageName = ((ResourceConfig.GetResourceRespInfoV2)localObject5).pkgName.get();
          ((PluginInfo)localObject6).mCurVersion = ((ResourceConfig.GetResourceRespInfoV2)localObject5).newVer.get();
          ((PluginInfo)localObject6).mState = 0;
          localHashMap.put(((PluginInfo)localObject6).mID, localObject6);
        }
      }
    }
    label1153:
    label1158:
    label1161:
    label1164:
    label1169:
    label1172:
    label1177:
    label1179:
    label1182:
    for (;;)
    {
      try
      {
        localObject3 = this.mPluginInfos;
        localObject4 = ((List)localObject1).iterator();
        i = 0;
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (String)((Iterator)localObject4).next();
          localObject6 = ((Map)localObject3).values().iterator();
          if (!((Iterator)localObject6).hasNext()) {
            break label1164;
          }
          localObject1 = (PluginInfo)((Iterator)localObject6).next();
          if (!((PluginInfo)localObject1).mPackageName.equals(localObject5)) {
            continue;
          }
          if (localObject1 == null) {
            break label1161;
          }
          if (((HashMap)localObject2).containsKey(((PluginInfo)localObject1).mID))
          {
            localObject5 = (PluginInfo)((HashMap)localObject2).get(((PluginInfo)localObject1).mID);
            ((HashMap)localObject2).remove(((PluginInfo)localObject1).mID);
            localHashMap.put(((PluginInfo)localObject1).mID, localObject5);
            break label1169;
          }
          if ((this.a == null) || (!this.a.b((PluginInfo)localObject1))) {
            break label1161;
          }
          ((Map)localObject3).remove(((PluginInfo)localObject1).mID);
          if (!QLog.isColorLevel()) {
            break label1172;
          }
          QLog.d("plugin_tag", 2, "remove PluginInfo: " + localObject1);
          break label1172;
        }
        localObject1 = ((HashMap)localObject2).keySet().iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject4 = (PluginInfo)((HashMap)localObject2).get((String)((Iterator)localObject1).next());
          localObject5 = (PluginInfo)((Map)localObject3).get(((PluginInfo)localObject4).mID);
          if ((localObject5 != null) && (((PluginInfo)localObject5).mMD5 != null) && (((PluginInfo)localObject5).mMD5.equals(((PluginInfo)localObject4).mMD5)) && ((((PluginInfo)localObject5).mURL == null) || (((PluginInfo)localObject4).mForceUrl <= 0) || (((PluginInfo)localObject5).mURL.equals(((PluginInfo)localObject4).mURL)))) {
            break label1158;
          }
          ((Map)localObject3).put(((PluginInfo)localObject4).mID, localObject4);
          if (!QLog.isColorLevel()) {
            break label1177;
          }
          QLog.d("plugin_tag", 2, "add PluginInfo: " + localObject4);
          break label1177;
        }
        localObject1 = localHashMap.keySet().iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PluginInfo)localHashMap.get((String)((Iterator)localObject1).next());
          localObject4 = (PluginInfo)((Map)localObject3).get(((PluginInfo)localObject2).mID);
          if ((localObject4 == null) || (((PluginInfo)localObject4).mMD5 == null) || (!((PluginInfo)localObject4).mMD5.equals(((PluginInfo)localObject2).mMD5)) || ((((PluginInfo)localObject4).mURL != null) && (((PluginInfo)localObject2).mForceUrl > 0) && (!((PluginInfo)localObject4).mURL.equals(((PluginInfo)localObject2).mURL))))
          {
            ((Map)localObject3).put(((PluginInfo)localObject2).mID, localObject2);
            if (!QLog.isColorLevel()) {
              break label1153;
            }
            QLog.d("plugin_tag", 2, "update PluginInfo: " + localObject2);
            i = 1;
            break label1182;
          }
          if ((((PluginInfo)localObject4).mMD5.equals(((PluginInfo)localObject2).mMD5)) && (((PluginInfo)localObject4).mURL != null) && (((PluginInfo)localObject2).mForceUrl <= 0) && (!((PluginInfo)localObject4).mURL.equals(((PluginInfo)localObject2).mURL)))
          {
            ((PluginInfo)localObject4).mPackageName = ((PluginInfo)localObject2).mPackageName;
            ((PluginInfo)localObject4).mCurVersion = ((PluginInfo)localObject2).mCurVersion;
            ((PluginInfo)localObject4).mURL = ((PluginInfo)localObject2).mURL;
            i = 1;
            break label1182;
          }
        }
        else
        {
          if (this.a != null) {
            this.a.WA(true);
          }
          if (this.mPluginInfos.isEmpty())
          {
            localObject1 = new HashMap();
            anpc.d((Map)localObject1, AppSetting.getAppId());
            anpc.a(this.mContext).collectPerformance(String.valueOf(paramGetResourceRespV2.uin), "pluginUpdateEmpty", false, 0L, 0L, (HashMap)localObject1, "");
          }
          if (i != 0) {
            ezU();
          }
          return;
        }
      }
      finally {}
      break label1182;
      int i = 1;
      break label1182;
      break label1179;
      break label1169;
      localObject1 = null;
      continue;
      for (;;)
      {
        break;
        i = 1;
      }
      i = 1;
    }
  }
  
  static File n(Context paramContext)
  {
    return paramContext.getDir("plugin_info", 0);
  }
  
  public void a(a parama)
  {
    this.a = parama;
  }
  
  public void a(boolean paramBoolean, int paramInt, ResourceConfig.GetResourceRespV2 paramGetResourceRespV2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onGetPluginConfig: " + paramBoolean);
    }
    if (paramInt != 128) {
      if (this.a != null) {
        this.a.WA(false);
      }
    }
    do
    {
      return;
      if ((paramBoolean) && (paramGetResourceRespV2 != null)) {
        break;
      }
    } while (this.a == null);
    this.a.WA(false);
    return;
    a(paramGetResourceRespV2);
    this.mIsUpdating = false;
  }
  
  public void b(boolean paramBoolean, int paramInt, ResourceConfig.GetResourceRespV2 paramGetResourceRespV2)
  {
    Handler localHandler = this.mHandler;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      Message.obtain(localHandler, 2, paramInt, i, paramGetResourceRespV2).sendToTarget();
      return;
    }
  }
  
  public boolean c(PluginInfo paramPluginInfo)
  {
    Object localObject2 = null;
    if (paramPluginInfo == null) {
      return false;
    }
    PluginInfo localPluginInfo = e(paramPluginInfo.mID);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("pre: ");
      if (paramPluginInfo != null)
      {
        localObject1 = paramPluginInfo.mMD5;
        QLog.d("plugin_tag", 2, (String)localObject1);
        localStringBuilder = new StringBuilder().append("new: ");
        localObject1 = localObject2;
        if (localPluginInfo != null) {
          localObject1 = localPluginInfo.mMD5;
        }
        QLog.d("plugin_tag", 2, (String)localObject1);
      }
    }
    else
    {
      if ((localPluginInfo == null) || (paramPluginInfo == null) || (!localPluginInfo.mMD5.equals(paramPluginInfo.mMD5))) {
        break label141;
      }
    }
    label141:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      localObject1 = null;
      break;
    }
  }
  
  public PluginInfo e(String paramString)
  {
    PluginInfo localPluginInfo2 = (PluginInfo)this.mPluginInfos.get(paramString);
    PluginInfo localPluginInfo1 = localPluginInfo2;
    if (localPluginInfo2 == null) {
      localPluginInfo1 = avfs.a(this.mContext).a(paramString);
    }
    return localPluginInfo1;
  }
  
  public void eP(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "handle getPluginList");
    }
    this.mIsUpdating = true;
    Object localObject1 = new ReqUserInfo();
    ((ReqUserInfo)localObject1).cType = 1;
    ((ReqUserInfo)localObject1).stGps = new GPS();
    ((ReqUserInfo)localObject1).strAuthName = "B1_QQ_Neighbor_android";
    ((ReqUserInfo)localObject1).strAuthPassword = "NzVK_qGE";
    ((ReqUserInfo)localObject1).vCells = new ArrayList();
    ((ReqUserInfo)localObject1).vMacs = new ArrayList();
    localObject1 = new ArrayList();
    Object localObject2 = this.mPluginInfos.values().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      PluginInfo localPluginInfo = (PluginInfo)((Iterator)localObject2).next();
      ResourceConfig.GetResourceReqInfoV2 localGetResourceReqInfoV2 = new ResourceConfig.GetResourceReqInfoV2();
      localGetResourceReqInfoV2.state.set(0);
      localGetResourceReqInfoV2.lanType.set(1);
      localGetResourceReqInfoV2.resSubType.set(localPluginInfo.mType);
      localGetResourceReqInfoV2.pkgName.set(localPluginInfo.mPackageName);
      localGetResourceReqInfoV2.curVer.set(localPluginInfo.mCurVersion);
      ((ArrayList)localObject1).add(localGetResourceReqInfoV2);
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "getPluginList Add: " + localPluginInfo.mID);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "getPluginList: 128");
    }
    localObject2 = new ResourceConfig.GetResourceReqV2();
    ((ResourceConfig.GetResourceReqV2)localObject2).appid.set(AppSetting.getAppId());
    ((ResourceConfig.GetResourceReqV2)localObject2).pluginType.set(128);
    ((ResourceConfig.GetResourceReqV2)localObject2).reqVer.set(1);
    ((ResourceConfig.GetResourceReqV2)localObject2).resReqInfo.set((List)localObject1);
    ((ResourceConfig.GetResourceReqV2)localObject2).revision.set("1d5677cf");
    localObject1 = new NewIntent(BaseApplicationImpl.getApplication(), jnl.class);
    ((NewIntent)localObject1).putExtra("cmd", "ResourceConfig.ClientReqV2");
    ((NewIntent)localObject1).putExtra("data", ((ResourceConfig.GetResourceReqV2)localObject2).toByteArray());
    ((NewIntent)localObject1).setObserver(new avgp(this));
    paramQQAppInterface.startServlet((NewIntent)localObject1);
  }
  
  public void ezU()
  {
    File localFile = n(this.mContext);
    Object localObject = avgf.e(localFile);
    if (localObject != null)
    {
      int i = 0;
      while (i < localObject.length)
      {
        localObject[i].delete();
        i += 1;
      }
    }
    localObject = this.mPluginInfos.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      avgf.a((PluginInfo)((Iterator)localObject).next(), localFile);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    int i = paramMessage.arg1;
    if (paramMessage.arg2 == 1) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, i, (ResourceConfig.GetResourceRespV2)paramMessage.obj);
      return false;
    }
  }
  
  public void run()
  {
    ResourceConfig.GetResourceRespV2 localGetResourceRespV2 = new ResourceConfig.GetResourceRespV2();
    localGetResourceRespV2.result.set(0);
    a(localGetResourceRespV2);
  }
  
  public static abstract interface a
  {
    public abstract void WA(boolean paramBoolean);
    
    public abstract boolean b(PluginInfo paramPluginInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.plugin.PluginUpdater
 * JD-Core Version:    0.7.0.1
 */