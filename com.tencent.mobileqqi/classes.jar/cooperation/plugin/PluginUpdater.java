package cooperation.plugin;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import mqq.manager.ServerConfigManager;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GPS;
import protocol.KQQConfig.GetResourceReqInfoV2;
import protocol.KQQConfig.GetResourceRespInfoV2;
import protocol.KQQConfig.GetResourceRespV2;
import protocol.KQQConfig.ReqUserInfo;

public class PluginUpdater
  extends ServerConfigObserver
{
  public static final String a = "PluginUpdater";
  private static final String b = "plugin_info";
  private Context jdField_a_of_type_AndroidContentContext;
  private PluginUpdater.OnPluginInfoUpdateListener jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public PluginUpdater(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = PluginInfoUtil.a(a(paramContext));
    if (paramContext != null)
    {
      int j = paramContext.length;
      int i = 0;
      if (i < j)
      {
        File localFile = paramContext[i];
        if (localFile.isFile())
        {
          PluginInfo localPluginInfo = PluginInfoUtil.a(localFile);
          if (localPluginInfo == null) {
            break label91;
          }
          this.jdField_a_of_type_JavaUtilMap.put(localPluginInfo.mID, localPluginInfo);
        }
        for (;;)
        {
          i += 1;
          break;
          label91:
          localFile.delete();
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "init plugin updater :" + this.jdField_a_of_type_JavaUtilMap.size());
    }
  }
  
  public static PluginInfo a(String paramString, PluginInfoParser paramPluginInfoParser)
  {
    try
    {
      SAXParserFactory.newInstance().newSAXParser().parse(new ByteArrayInputStream(paramString.getBytes()), paramPluginInfoParser);
      paramString = paramPluginInfoParser.a();
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  static File a(Context paramContext)
  {
    return paramContext.getDir("plugin_info", 0);
  }
  
  private void a(GetResourceRespV2 paramGetResourceRespV2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "doOnGetPluginConfig");
    }
    Object localObject2;
    Object localObject3;
    Object localObject1;
    HashMap localHashMap;
    Object localObject4;
    Object localObject5;
    if (paramGetResourceRespV2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "onGetPluginConfig GetResourceRespV2: " + paramGetResourceRespV2 + "[add: " + paramGetResourceRespV2.vecAddedResInfo.size() + ", remove: " + paramGetResourceRespV2.vecDeletedResInfo.size() + ", update: " + paramGetResourceRespV2.vecUpdatedResInfo.size() + "]");
      }
      localObject2 = new PluginInfoParser();
      localObject3 = new ArrayList();
      localObject1 = new HashMap();
      localHashMap = new HashMap();
      localObject4 = paramGetResourceRespV2.vecDeletedResInfo.iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((List)localObject3).add(((GetResourceRespInfoV2)((Iterator)localObject4).next()).strPkgName);
      }
      localObject4 = paramGetResourceRespV2.vecAddedResInfo.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (GetResourceRespInfoV2)((Iterator)localObject4).next();
        PluginInfo localPluginInfo = a(((GetResourceRespInfoV2)localObject5).strResConf, (PluginInfoParser)localObject2);
        if (localPluginInfo != null)
        {
          localPluginInfo.mType = ((GetResourceRespInfoV2)localObject5).sResSubType;
          localPluginInfo.mPackageName = ((GetResourceRespInfoV2)localObject5).strPkgName;
          localPluginInfo.mCurVersion = ((GetResourceRespInfoV2)localObject5).uiNewVer;
          localPluginInfo.mState = 0;
          ((HashMap)localObject1).put(localPluginInfo.mID, localPluginInfo);
        }
      }
      paramGetResourceRespV2 = paramGetResourceRespV2.vecUpdatedResInfo.iterator();
      while (paramGetResourceRespV2.hasNext())
      {
        localObject4 = (GetResourceRespInfoV2)paramGetResourceRespV2.next();
        localObject5 = a(((GetResourceRespInfoV2)localObject4).strResConf, (PluginInfoParser)localObject2);
        if (localObject5 != null)
        {
          ((PluginInfo)localObject5).mType = ((GetResourceRespInfoV2)localObject4).sResSubType;
          ((PluginInfo)localObject5).mPackageName = ((GetResourceRespInfoV2)localObject4).strPkgName;
          ((PluginInfo)localObject5).mCurVersion = ((GetResourceRespInfoV2)localObject4).uiNewVer;
          ((PluginInfo)localObject5).mState = 0;
          localHashMap.put(((PluginInfo)localObject5).mID, localObject5);
        }
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "PluginInfo: " + localObject5);
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = this.jdField_a_of_type_JavaUtilMap;
        localObject3 = ((List)localObject3).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label580;
        }
        localObject4 = (String)((Iterator)localObject3).next();
        localObject5 = ((Map)localObject2).values().iterator();
        if (!((Iterator)localObject5).hasNext()) {
          break label848;
        }
        paramGetResourceRespV2 = (PluginInfo)((Iterator)localObject5).next();
        if (!paramGetResourceRespV2.mPackageName.equals(localObject4)) {
          continue;
        }
        if (paramGetResourceRespV2 == null) {
          continue;
        }
        if (((HashMap)localObject1).containsKey(paramGetResourceRespV2.mID))
        {
          localObject4 = (PluginInfo)((HashMap)localObject1).get(paramGetResourceRespV2.mID);
          ((HashMap)localObject1).remove(paramGetResourceRespV2.mID);
          localHashMap.put(paramGetResourceRespV2.mID, localObject4);
          continue;
        }
        if (this.jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener == null) {
          continue;
        }
      }
      finally {}
      if (this.jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener.a(paramGetResourceRespV2))
      {
        ((Map)localObject2).remove(paramGetResourceRespV2.mID);
        continue;
        label580:
        paramGetResourceRespV2 = ((HashMap)localObject1).keySet().iterator();
        while (paramGetResourceRespV2.hasNext())
        {
          localObject3 = (PluginInfo)((HashMap)localObject1).get((String)paramGetResourceRespV2.next());
          localObject4 = (PluginInfo)((Map)localObject2).get(((PluginInfo)localObject3).mID);
          if ((localObject4 == null) || (((PluginInfo)localObject4).mMD5 == null) || (!((PluginInfo)localObject4).mMD5.equals(((PluginInfo)localObject3).mMD5)) || ((((PluginInfo)localObject4).mURL != null) && (!((PluginInfo)localObject4).mURL.equals(((PluginInfo)localObject3).mURL)))) {
            ((Map)localObject2).put(((PluginInfo)localObject3).mID, localObject3);
          }
        }
        paramGetResourceRespV2 = localHashMap.keySet().iterator();
        while (paramGetResourceRespV2.hasNext())
        {
          localObject1 = (PluginInfo)localHashMap.get((String)paramGetResourceRespV2.next());
          localObject3 = (PluginInfo)((Map)localObject2).get(((PluginInfo)localObject1).mID);
          if ((localObject3 == null) || (((PluginInfo)localObject3).mMD5 == null) || (!((PluginInfo)localObject3).mMD5.equals(((PluginInfo)localObject1).mMD5)) || ((((PluginInfo)localObject3).mURL != null) && (!((PluginInfo)localObject3).mURL.equals(((PluginInfo)localObject1).mURL)))) {
            ((Map)localObject2).put(((PluginInfo)localObject1).mID, localObject1);
          }
        }
        if (this.jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener != null) {
          this.jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener.a(true);
        }
        a();
        return;
        label848:
        paramGetResourceRespV2 = null;
      }
    }
  }
  
  public PluginInfo a(String paramString)
  {
    return BuiltinPluginManager.a(this.jdField_a_of_type_AndroidContentContext).a(paramString);
  }
  
  public Map a()
  {
    return new HashMap(this.jdField_a_of_type_JavaUtilMap);
  }
  
  public void a()
  {
    File localFile = a(this.jdField_a_of_type_AndroidContentContext);
    Object localObject = PluginInfoUtil.a(localFile);
    if (localObject != null)
    {
      int i = 0;
      while (i < localObject.length)
      {
        localObject[i].delete();
        i += 1;
      }
    }
    localObject = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      PluginInfoUtil.a((PluginInfo)((Iterator)localObject).next(), localFile);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "handle getPluginList");
    }
    this.jdField_a_of_type_Boolean = true;
    ReqUserInfo localReqUserInfo = new ReqUserInfo();
    localReqUserInfo.cType = 1;
    localReqUserInfo.stGps = new GPS();
    localReqUserInfo.strAuthName = "B1_QQ_Neighbor_android";
    localReqUserInfo.strAuthPassword = "NzVK_qGE";
    localReqUserInfo.vCells = new ArrayList();
    localReqUserInfo.vMacs = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      PluginInfo localPluginInfo = (PluginInfo)localIterator.next();
      GetResourceReqInfoV2 localGetResourceReqInfoV2 = new GetResourceReqInfoV2();
      localGetResourceReqInfoV2.cState = 0;
      localGetResourceReqInfoV2.sLanType = 1;
      localGetResourceReqInfoV2.sResSubType = ((short)localPluginInfo.mType);
      localGetResourceReqInfoV2.strPkgName = localPluginInfo.mPackageName;
      localGetResourceReqInfoV2.uiCurVer = localPluginInfo.mCurVersion;
      localArrayList.add(localGetResourceReqInfoV2);
      if (QLog.isColorLevel()) {
        QLog.d("plugin_tag", 2, "getPluginList Add: " + localPluginInfo.mID);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "getPluginList: 128");
    }
    ((ServerConfigManager)paramQQAppInterface.getManager(4)).getPluginConfig(128, localReqUserInfo, localArrayList, this);
  }
  
  public void a(PluginUpdater.OnPluginInfoUpdateListener paramOnPluginInfoUpdateListener)
  {
    this.jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener = paramOnPluginInfoUpdateListener;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(paramString);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(PluginInfo paramPluginInfo)
  {
    if (paramPluginInfo == null) {}
    PluginInfo localPluginInfo;
    do
    {
      return false;
      localPluginInfo = a(paramPluginInfo.mID);
    } while ((localPluginInfo == null) || (paramPluginInfo == null) || (!localPluginInfo.mMD5.equals(paramPluginInfo.mMD5)));
    return true;
  }
  
  public void onGetPluginConfig(boolean paramBoolean, int paramInt, GetResourceRespV2 paramGetResourceRespV2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "onGetPluginConfig: " + paramBoolean);
    }
    if (paramInt != 128) {
      if (this.jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener != null) {
        this.jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener.a(false);
      }
    }
    do
    {
      return;
      if ((paramBoolean) && (paramGetResourceRespV2 != null)) {
        break;
      }
    } while (this.jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener == null);
    this.jdField_a_of_type_CooperationPluginPluginUpdater$OnPluginInfoUpdateListener.a(false);
    return;
    a(paramGetResourceRespV2);
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.plugin.PluginUpdater
 * JD-Core Version:    0.7.0.1
 */