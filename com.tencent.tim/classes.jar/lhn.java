import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.1;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.2;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.3;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.4;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.5;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.6;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.7;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.8;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.9;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo.a;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import tencent.im.oidb.channel_button.channel_button.Channel;
import tencent.im.oidb.channel_button.channel_button.Section;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.ChannelInfo;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.ReqBody;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.RspBody;
import tencent.im.oidb.cmd0xbbb.oidb_cmd0xbbb.RspBody;
import tencent.im.oidb.cmd0xbbc.oidb_cmd0xbbc.PhoneInfo;
import tencent.im.oidb.cmd0xbbc.oidb_cmd0xbbc.ReqBody;
import tencent.im.oidb.cmd0xbbc.oidb_cmd0xbbc.RspBody;
import tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.MsgChannelInfo;
import tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.MsgGetChannelInfoRsp;
import tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.PhoneInfo;
import tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.ReqBody;
import tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.RspBody;

public class lhn
  extends lho
{
  private int aOZ;
  private int aPa;
  public final int aPb = 3;
  private int aPc;
  public final String aeV = "UPDATE_CHANNEL_LIST_KEY_0xbbc";
  private HashMap<Integer, List<ChannelCoverInfo>> dQ = new HashMap();
  private HashMap<Integer, Integer> dR = new HashMap();
  private List<mgw> hS;
  private final Object mDataLock = new Object();
  private LinkedHashMap<Integer, ChannelCoverInfo> u = new LinkedHashMap();
  private long us;
  private LinkedHashMap<Integer, ChannelCoverInfo> v = new LinkedHashMap();
  private LinkedHashMap<Integer, ChannelCoverInfo> w = new LinkedHashMap();
  
  public lhn(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, lun paramlun, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramlun, paramHandler);
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "construct!");
    }
  }
  
  private boolean Ck()
  {
    if (this.aPc < 3)
    {
      this.aPc += 1;
      return true;
    }
    this.aPc = 0;
    awit.H("UPDATE_CHANNEL_LIST_KEY_0xbbc", Boolean.valueOf(false));
    return false;
  }
  
  private List<TabChannelCoverInfo> L(List<mgw> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        mgw localmgw = (mgw)paramList.next();
        if ((localmgw.iK == null) || (localmgw.iK.isEmpty())) {
          break label133;
        }
        Iterator localIterator = localmgw.iK.iterator();
        while (localIterator.hasNext())
        {
          TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localIterator.next();
          localTabChannelCoverInfo.channelConfigType = localmgw.id;
          localTabChannelCoverInfo.seq = i;
          localArrayList.add(localTabChannelCoverInfo);
          i += 1;
        }
      }
    }
    label133:
    for (;;)
    {
      break;
      return localArrayList;
    }
  }
  
  private List<mgw> M(List<mgw> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        Object localObject = (mgw)paramList.next();
        mgw localmgw = new mgw(((mgw)localObject).id, ((mgw)localObject).name, ((mgw)localObject).text);
        localObject = ((mgw)localObject).iK.iterator();
        while (((Iterator)localObject).hasNext())
        {
          TabChannelCoverInfo localTabChannelCoverInfo1 = (TabChannelCoverInfo)((Iterator)localObject).next();
          TabChannelCoverInfo localTabChannelCoverInfo2 = localTabChannelCoverInfo1.clone();
          localTabChannelCoverInfo2.channelConfigType = localTabChannelCoverInfo1.channelConfigType;
          localTabChannelCoverInfo2.seq = i;
          localmgw.iK.add(localTabChannelCoverInfo2);
          i += 1;
        }
        localArrayList.add(localmgw);
      }
    }
    return localArrayList;
  }
  
  private List<TabChannelCoverInfo> N(List<TabChannelCoverInfo> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    paramList = null;
    Iterator localIterator = ((List)localObject).iterator();
    int i = 0;
    boolean bool2 = true;
    boolean bool1 = true;
    if (localIterator.hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localIterator.next();
      if (localTabChannelCoverInfo.mChannelCoverId == 0) {
        bool2 = false;
      }
      if (localTabChannelCoverInfo.mChannelCoverId == 70) {
        bool1 = false;
      }
      if (localTabChannelCoverInfo.mChannelCoverId != oC()) {
        break label160;
      }
      i = 1;
      paramList = localTabChannelCoverInfo;
    }
    label160:
    for (;;)
    {
      break;
      if (i != 0) {
        ((List)localObject).remove(paramList);
      }
      if (oC() != -1) {
        oC();
      }
      QLog.d("ChannelCoverInfoModule", 1, new Object[] { "forceInsertChannelList insertRecommendChannel = ", Boolean.valueOf(bool2), ", insertFollowChannel = ", Boolean.valueOf(bool1) });
      return localObject;
    }
  }
  
  private int a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    int i = 0;
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null)
    {
      if (paramInt == 0) {
        i = paramQQAppInterface.getInt("readInJoy_mian_channel_cover_seq", 0);
      }
    }
    else {
      return i;
    }
    if (paramInt == 56) {
      return paramQQAppInterface.getInt("readInJoy_video_channel_cover_seq", 0);
    }
    return paramQQAppInterface.getInt("readInJoy_sub_channel_cover_seq" + paramInt, 0);
  }
  
  private ChannelCoverInfo a(int paramInt1, int paramInt2)
  {
    ChannelCoverInfo localChannelCoverInfo = null;
    localObject2 = this.mDataLock;
    if (paramInt2 == 0) {}
    for (;;)
    {
      try
      {
        localChannelCoverInfo = (ChannelCoverInfo)this.u.get(Integer.valueOf(paramInt1));
        return localChannelCoverInfo;
      }
      finally {}
      if (paramInt2 == 56) {
        localChannelCoverInfo = (ChannelCoverInfo)this.v.get(Integer.valueOf(paramInt1));
      } else if (paramInt2 == 41402) {
        localChannelCoverInfo = (ChannelCoverInfo)this.w.get(Integer.valueOf(paramInt1));
      } else if (this.dQ.containsKey(Integer.valueOf(paramInt2))) {
        localChannelCoverInfo = a(paramInt1, (List)this.dQ.get(Integer.valueOf(paramInt2)));
      }
    }
  }
  
  private ChannelCoverInfo a(int paramInt, List<ChannelCoverInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)paramList.next();
        if (localChannelCoverInfo.mChannelCoverId == paramInt) {
          return localChannelCoverInfo;
        }
      }
    }
    return null;
  }
  
  private void a(ChannelCoverInfo paramChannelCoverInfo, int paramInt)
  {
    Object localObject = this.mDataLock;
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        this.u.put(Integer.valueOf(paramChannelCoverInfo.mChannelCoverId), paramChannelCoverInfo);
        return;
      }
      finally {}
      if (paramInt == 56)
      {
        this.v.put(Integer.valueOf(paramChannelCoverInfo.mChannelCoverId), paramChannelCoverInfo);
      }
      else if (paramInt == 41402)
      {
        this.w.put(Integer.valueOf(paramChannelCoverInfo.mChannelCoverId), paramChannelCoverInfo);
      }
      else if (this.dQ.containsKey(Integer.valueOf(paramInt)))
      {
        ((List)this.dQ.get(Integer.valueOf(paramInt))).add(paramChannelCoverInfo);
      }
      else
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramChannelCoverInfo);
        this.dQ.put(Integer.valueOf(paramInt), localArrayList);
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.edit();
      if (paramInt2 != 0) {
        break label106;
      }
      paramQQAppInterface.putInt("readInJoy_mian_channel_cover_seq", paramInt1);
    }
    for (;;)
    {
      paramQQAppInterface.commit();
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverInfoModule", 2, "updateChannelCoverSeqConfig, seq =" + paramInt1 + " ;channelId = " + paramInt2);
      }
      return;
      label106:
      if (paramInt2 == 56) {
        paramQQAppInterface.putInt("readInJoy_video_channel_cover_seq", paramInt1);
      } else {
        paramQQAppInterface.putInt("readInJoy_sub_channel_cover_seq" + paramInt2, paramInt1);
      }
    }
  }
  
  private boolean a(ChannelCoverInfo paramChannelCoverInfo, int paramInt)
  {
    if (paramChannelCoverInfo == null) {
      return false;
    }
    paramChannelCoverInfo = paramChannelCoverInfo.clone();
    a(paramChannelCoverInfo, paramInt);
    this.mExecutorService.execute(new ChannelCoverInfoModule.3(this, paramChannelCoverInfo));
    return true;
  }
  
  private boolean a(TabChannelCoverInfo paramTabChannelCoverInfo, List<TabChannelCoverInfo> paramList)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (paramList != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramList.size())
      {
        TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)paramList.get(i);
        if ((localTabChannelCoverInfo == null) || (localTabChannelCoverInfo.mChannelCoverId != paramTabChannelCoverInfo.mChannelCoverId) || (localTabChannelCoverInfo.mChannelId != paramTabChannelCoverInfo.mChannelId)) {}
      }
      else
      {
        try
        {
          paramList.set(i, paramTabChannelCoverInfo);
          bool1 = true;
          return bool1;
        }
        catch (Exception paramTabChannelCoverInfo)
        {
          for (;;)
          {
            QLog.e("ChannelCoverInfoModule", 1, "findAndReplaceChannel channelCoverInfoList error!!,index:" + i + " size:channelCoverInfoList.size(),msg:" + paramTabChannelCoverInfo.toString());
          }
        }
      }
      i += 1;
    }
  }
  
  private List<ChannelCoverInfo> aI()
  {
    synchronized (this.mDataLock)
    {
      ArrayList localArrayList = new ArrayList(this.u.size());
      Iterator localIterator = this.u.keySet().iterator();
      if (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        localArrayList.add((ChannelCoverInfo)this.u.get(localInteger));
      }
    }
    return localList;
  }
  
  private List<ChannelCoverInfo> aJ()
  {
    synchronized (this.mDataLock)
    {
      ArrayList localArrayList = new ArrayList(this.v.size());
      Iterator localIterator = this.v.keySet().iterator();
      if (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        localArrayList.add((ChannelCoverInfo)this.v.get(localInteger));
      }
    }
    return localList;
  }
  
  private List<ChannelCoverInfo> aK()
  {
    synchronized (this.mDataLock)
    {
      ArrayList localArrayList = new ArrayList(this.w.size());
      Iterator localIterator = this.w.keySet().iterator();
      if (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        localArrayList.add((ChannelCoverInfo)this.w.get(localInteger));
      }
    }
    return localList;
  }
  
  private List<TabChannelCoverInfo> aL()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "loadFromDb");
    }
    return this.mEntityManager.query(TabChannelCoverInfo.class);
  }
  
  private void aMn()
  {
    for (;;)
    {
      try
      {
        localReqBody = new oidb_cmd0xbe6.ReqBody();
        localPhoneInfo = new oidb_cmd0xbe6.PhoneInfo();
        str = kxm.iT();
        if (!TextUtils.isEmpty(str))
        {
          str = arwv.toMD5(str.toLowerCase()).toLowerCase();
          localPhoneInfo.bytes_muid.set(ByteStringMicro.copyFromUtf8(str));
          localPhoneInfo.uint32_muid_type.set(1);
          i = jxp.na();
          localPhoneInfo.uint32_conn.set(i);
          i = 0;
        }
      }
      catch (Throwable localThrowable)
      {
        oidb_cmd0xbe6.ReqBody localReqBody;
        oidb_cmd0xbe6.PhoneInfo localPhoneInfo;
        String str;
        int i;
        int j;
        QLog.e("ChannelCoverInfoModule", 2, "requestWeiShiChannelCoverListFromServer failed for param error:" + kxm.getStackTrace(localThrowable));
        return;
      }
      try
      {
        j = aqgz.LU();
        i = j;
      }
      catch (Exception localException)
      {
        continue;
      }
      localPhoneInfo.uint32_carrier.set(i);
      str = aqgz.getDeviceOSVersion();
      localPhoneInfo.bytes_os_ver.set(ByteStringMicro.copyFromUtf8(str));
      str = aqgz.getQQVersion();
      localPhoneInfo.bytes_qq_ver.set(ByteStringMicro.copyFromUtf8(str));
      i = AppSetting.getAppId();
      localPhoneInfo.bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i)));
      str = cz.f(cz.s());
      localPhoneInfo.bytes_client_ip.set(ByteStringMicro.copyFromUtf8(str));
      localPhoneInfo.uint32_os_type.set(2);
      localReqBody.msg_phone_info.set(localPhoneInfo, true);
      if ((this.mApp instanceof QQAppInterface)) {
        localReqBody.string_channel_version.set(c((QQAppInterface)this.mApp));
      }
      sendPbReq(lup.makeOIDBPkg("OidbSvc.0xbe6", 3046, 1, localReqBody.toByteArray()));
      return;
      str = aqgz.be(BaseApplication.getContext());
      if (!TextUtils.isEmpty(str))
      {
        str = arwv.toMD5(str.replaceAll(":", "").toUpperCase()).toLowerCase();
        localPhoneInfo.bytes_muid.set(ByteStringMicro.copyFromUtf8(str));
        localPhoneInfo.uint32_muid_type.set(3);
      }
    }
  }
  
  private void b(ChannelCoverInfo paramChannelCoverInfo, int paramInt)
  {
    Object localObject = this.mDataLock;
    Iterator localIterator;
    if (paramInt == 0) {
      label61:
      break label150;
    }
    for (;;)
    {
      try
      {
        localIterator = this.u.keySet().iterator();
        if (localIterator.hasNext())
        {
          if (((Integer)localIterator.next()).intValue() != paramChannelCoverInfo.mChannelCoverId) {
            break;
          }
          localIterator.remove();
        }
        return;
      }
      finally {}
      if (paramInt == 56)
      {
        localIterator = this.v.keySet().iterator();
        if (!localIterator.hasNext()) {
          continue;
        }
        if (((Integer)localIterator.next()).intValue() != paramChannelCoverInfo.mChannelCoverId) {
          break label61;
        }
        localIterator.remove();
        continue;
      }
      if (paramInt == 41402)
      {
        localIterator = this.w.keySet().iterator();
        label150:
        if (!localIterator.hasNext()) {
          continue;
        }
        if (((Integer)localIterator.next()).intValue() != paramChannelCoverInfo.mChannelCoverId) {
          break label61;
        }
        localIterator.remove();
        continue;
      }
      if (this.dQ.containsKey(Integer.valueOf(paramInt))) {
        ((List)this.dQ.get(Integer.valueOf(paramInt))).remove(paramChannelCoverInfo);
      }
    }
  }
  
  private void cM(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      this.aOZ = paramInt2;
      return;
    }
    if (paramInt1 == 56)
    {
      this.aPa = paramInt2;
      return;
    }
    this.dR.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  private void cN(int paramInt1, int paramInt2)
  {
    ChannelCoverInfo localChannelCoverInfo = a(paramInt1, paramInt2);
    if (localChannelCoverInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChannelCoverInfoModule", 2, "removeChannelCoverInfoFromDBAndCache channelID=" + paramInt2 + " ;channelCoverId = " + paramInt1);
      }
      b(localChannelCoverInfo, paramInt2);
      this.mExecutorService.execute(new ChannelCoverInfoModule.2(this, localChannelCoverInfo));
    }
  }
  
  public static boolean dJ(int paramInt)
  {
    if (!((Boolean)awit.f("sp_key_channel_list_dynamic_order_switch", Boolean.valueOf(false))).booleanValue())
    {
      QLog.d("ChannelCoverInfoModule", 1, "isSupportChannelDynamicOrder, switch is off.");
      return false;
    }
    Object localObject1 = (QQAppInterface)kxm.getAppRuntime();
    if (localObject1 != null)
    {
      localObject1 = (lcd)((QQAppInterface)localObject1).getManager(163);
      if (localObject1 != null)
      {
        localObject1 = ((lcd)localObject1).b().aC();
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          TabChannelCoverInfo localTabChannelCoverInfo;
          do
          {
            localObject1 = ((List)localObject1).iterator();
            Object localObject2;
            while (!((Iterator)localObject2).hasNext())
            {
              do
              {
                if (!((Iterator)localObject1).hasNext()) {
                  break;
                }
                localObject2 = ((mgw)((Iterator)localObject1).next()).iK;
              } while ((localObject2 == null) || (((List)localObject2).size() <= 0));
              localObject2 = ((List)localObject2).iterator();
            }
            localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject2).next();
          } while (localTabChannelCoverInfo.mChannelCoverId != paramInt);
          QLog.d("ChannelCoverInfoModule", 1, new Object[] { "isSupportChannelDynamicOrder, name = ", localTabChannelCoverInfo.mChannelCoverName, ", channelID = ", Integer.valueOf(paramInt), ", dynamicSort = ", Integer.valueOf(localTabChannelCoverInfo.dynamicSort) });
          if (localTabChannelCoverInfo.dynamicSort == 1) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
        }
      }
    }
    QLog.d("ChannelCoverInfoModule", 1, "isSupportChannelDynamicOrder, channel dynamic order is off.");
    return false;
  }
  
  private int dm(int paramInt)
  {
    if (paramInt == 0) {
      return this.aOZ;
    }
    if (paramInt == 56) {
      return this.aPa;
    }
    if (this.dR.containsKey(Integer.valueOf(paramInt))) {
      return ((Integer)this.dR.get(Integer.valueOf(paramInt))).intValue();
    }
    return 0;
  }
  
  public static void i(List<TabChannelCoverInfo> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        QLog.d("ChannelCoverInfoModule", 1, new Object[] { paramString + " tabChannelCoverInfo [", Integer.valueOf(i), "]: ", ((TabChannelCoverInfo)paramList.get(i)).shortLogString() });
        i += 1;
      }
    }
  }
  
  public static String jr()
  {
    return Aladdin.getConfig(220).getString("main_feeds_channel_name", "");
  }
  
  private void m(List<mgw> paramList1, List<mgw> paramList2)
  {
    SparseArray localSparseArray = new SparseArray();
    paramList2 = paramList2.iterator();
    Object localObject1;
    Object localObject2;
    while (paramList2.hasNext())
    {
      localObject1 = ((mgw)paramList2.next()).iK.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TabChannelCoverInfo)((Iterator)localObject1).next();
        localSparseArray.put(((TabChannelCoverInfo)localObject2).mChannelCoverId, localObject2);
      }
    }
    paramList2 = paramList1.iterator();
    if (paramList2.hasNext())
    {
      localObject1 = (mgw)paramList2.next();
      localObject2 = ((mgw)localObject1).iK.iterator();
      label272:
      label285:
      label291:
      label296:
      label300:
      for (;;)
      {
        label120:
        TabChannelCoverInfo localTabChannelCoverInfo1;
        TabChannelCoverInfo localTabChannelCoverInfo2;
        label205:
        int i;
        if (((Iterator)localObject2).hasNext())
        {
          localTabChannelCoverInfo1 = (TabChannelCoverInfo)((Iterator)localObject2).next();
          localTabChannelCoverInfo2 = (TabChannelCoverInfo)localSparseArray.get(localTabChannelCoverInfo1.mChannelCoverId);
          if (localTabChannelCoverInfo2 != null)
          {
            if (localTabChannelCoverInfo1.redPoint == null) {
              break label272;
            }
            if ((!localTabChannelCoverInfo1.redPoint.isShow) && (localTabChannelCoverInfo2.redPoint != null)) {
              localTabChannelCoverInfo1.redPoint.isShow = localTabChannelCoverInfo2.redPoint.isShow;
            }
          }
          if (!kyo.Bg()) {
            break label285;
          }
          i = 11;
          label214:
          if ((paramList1.indexOf(localObject1) != 0) || (((mgw)localObject1).iK.indexOf(localTabChannelCoverInfo1) >= i)) {
            break label291;
          }
          i = 1;
          label243:
          if (ReadInJoyChannelPanelFragment.a(localTabChannelCoverInfo1) == -1) {
            break label296;
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((j == 0) || (i != 0)) {
            break label300;
          }
          ny(true);
          break label120;
          break;
          localTabChannelCoverInfo1.redPoint = localTabChannelCoverInfo2.redPoint;
          break label205;
          i = 6;
          break label214;
          i = 0;
          break label243;
        }
      }
    }
  }
  
  private void o(boolean paramBoolean, List<TabChannelCoverInfo> paramList)
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {
      lcc.a().d(paramBoolean, paramList);
    }
    while (this.mMainThreadHandler == null) {
      return;
    }
    this.mMainThreadHandler.post(new ChannelCoverInfoModule.5(this, paramBoolean, paramList));
  }
  
  public static int oC()
  {
    return Aladdin.getConfig(220).getIntegerFromString("main_feeds_channel_id", -1);
  }
  
  private List<ChannelCoverInfo> w(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "loadFromDb with selection=" + "mChannelID = ?" + ", channelId=" + paramInt);
    }
    return this.mEntityManager.query(ChannelCoverInfo.class, true, "mChannelID = ?", new String[] { String.valueOf(paramInt) }, null, null, null, null);
  }
  
  public void V(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xbbb.RspBody();
    int i = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    QLog.d("ChannelCoverInfoModule", 1, "handle0xbbbGetChannelList, result=" + i);
    if (i == 0)
    {
      if ((paramToServiceMsg.uint64_next_req_time.has()) && (paramToServiceMsg.uint64_next_req_time.get() > 0L)) {
        this.us = paramToServiceMsg.uint64_next_req_time.get();
      }
      if (paramToServiceMsg.rpt_msg_section.has()) {
        cq(paramToServiceMsg.rpt_msg_section.get());
      }
      return;
    }
    o(false, null);
  }
  
  public void W(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_cmd0xbbc.RspBody());
    QLog.d("ChannelCoverInfoModule", 1, new Object[] { "handleOxbbcUpChannelList, result = ", Integer.valueOf(i) });
    if (i == 0)
    {
      awit.H("UPDATE_CHANNEL_LIST_KEY_0xbbc", Boolean.valueOf(false));
      return;
    }
    QLog.d("ChannelCoverInfoModule", 1, "0xbbcUpChannelList failed.");
  }
  
  protected void X(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int m = ((Integer)paramToServiceMsg.getAttribute("req_channellist_source", Integer.valueOf(1))).intValue();
    int i = ((Integer)paramToServiceMsg.getAttribute("req_channellist_channel_id", Integer.valueOf(0))).intValue();
    paramToServiceMsg = new oidb_cmd0x69f.RspBody();
    int j = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "handleGetChannelAndSubscribeList, result=" + j);
    }
    if (j == 0) {
      if (!paramToServiceMsg.uint32_req_channel_id.has()) {
        break label456;
      }
    }
    label456:
    for (i = paramToServiceMsg.uint32_req_channel_id.get();; i = -1)
    {
      int n;
      if (paramToServiceMsg.uint32_channel_seq.has())
      {
        n = paramToServiceMsg.uint32_channel_seq.get();
        int k = dm(i);
        j = k;
        if (k == 0)
        {
          j = k;
          if (this.mApp != null)
          {
            j = k;
            if ((this.mApp instanceof QQAppInterface)) {
              j = a((QQAppInterface)this.mApp, i);
            }
          }
        }
        if (n <= j) {
          if (QLog.isColorLevel()) {
            QLog.d("ChannelCoverInfoModule", 2, "handleGetChannelAndSubscribeList, seq is " + n + " ;lastseq = " + j + "; not need to update");
          }
        }
      }
      do
      {
        do
        {
          do
          {
            return;
            cM(i, n);
            if ((this.mApp != null) && ((this.mApp instanceof QQAppInterface))) {
              a((QQAppInterface)this.mApp, n, i);
            }
            if ((m != 3) || (i != 0)) {
              break;
            }
          } while (!paramToServiceMsg.rpt_channel_list.has());
          n(paramToServiceMsg.rpt_channel_list.get(), 0);
          return;
          if ((m != 4) || (i != 56)) {
            break;
          }
        } while (!paramToServiceMsg.rpt_channel_list.has());
        n(paramToServiceMsg.rpt_channel_list.get(), 56);
        return;
        if (paramToServiceMsg.rpt_channel_list.has())
        {
          n(paramToServiceMsg.rpt_channel_list.get(), i);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ChannelCoverInfoModule", 2, "handle0x69fGetChannelList resp.rpt_channel_list null , channelId = " + i);
      return;
      if (m == 3) {
        lcc.a().m(false, null);
      }
      for (;;)
      {
        lcc.a().a(i, false, null);
        return;
        if (m == 4) {
          lcc.a().g(false, null);
        }
      }
    }
  }
  
  protected void Y(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 1;
    int j = 1;
    paramToServiceMsg = new oidb_cmd0xbe6.RspBody();
    if (lup.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0) {
      if ((this.mApp instanceof QQAppInterface)) {
        if (TextUtils.equals(c((QQAppInterface)this.mApp), paramToServiceMsg.string_channel_version.get())) {
          break label124;
        }
      }
    }
    label124:
    for (i = j;; i = 0)
    {
      j((QQAppInterface)this.mApp, paramToServiceMsg.string_channel_version.get());
      if ((i != 0) && (paramToServiceMsg.msg_get_channel_info_rsp.get() != null) && (paramToServiceMsg.msg_get_channel_info_rsp.rpt_msg_channel_info.get() != null)) {
        o(paramToServiceMsg.msg_get_channel_info_rsp.rpt_msg_channel_info.get(), 41402);
      }
      return;
    }
  }
  
  public List<mgw> aC()
  {
    return this.hS;
  }
  
  public void aEL()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "unInitialize!");
    }
    synchronized (this.mDataLock)
    {
      this.u.clear();
      this.v.clear();
      this.w.clear();
      this.dQ.clear();
      this.dR.clear();
      return;
    }
  }
  
  /* Error */
  public List<TabChannelCoverInfo> aH()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 836	lhn:hS	Ljava/util/List;
    //   6: ifnull +36 -> 42
    //   9: aload_0
    //   10: getfield 836	lhn:hS	Ljava/util/List;
    //   13: invokeinterface 119 1 0
    //   18: ifne +24 -> 42
    //   21: aload_0
    //   22: getfield 836	lhn:hS	Ljava/util/List;
    //   25: iconst_0
    //   26: invokeinterface 300 2 0
    //   31: checkcast 113	mgw
    //   34: getfield 116	mgw:iK	Ljava/util/List;
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: areturn
    //   42: aconst_null
    //   43: astore_1
    //   44: goto -6 -> 38
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	lhn
    //   37	7	1	localList	List
    //   47	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	47	finally
  }
  
  public void aJs() {}
  
  /* Error */
  public void aMo()
  {
    // Byte code:
    //   0: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 69
    //   8: iconst_2
    //   9: ldc_w 849
    //   12: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: ldc 57
    //   17: iconst_0
    //   18: invokestatic 85	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   21: invokestatic 554	awit:f	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast 81	java/lang/Boolean
    //   27: invokevirtual 557	java/lang/Boolean:booleanValue	()Z
    //   30: ifeq +29 -> 59
    //   33: aload_0
    //   34: invokespecial 851	lhn:Ck	()Z
    //   37: ifeq +22 -> 59
    //   40: ldc 69
    //   42: iconst_2
    //   43: ldc_w 853
    //   46: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_0
    //   50: aload_0
    //   51: getfield 836	lhn:hS	Ljava/util/List;
    //   54: iconst_3
    //   55: invokevirtual 855	lhn:m	(Ljava/util/List;I)V
    //   58: return
    //   59: getstatic 860	kfv:aeG	Z
    //   62: ifeq +13 -> 75
    //   65: ldc 69
    //   67: iconst_2
    //   68: ldc_w 862
    //   71: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: return
    //   75: invokestatic 867	java/lang/System:currentTimeMillis	()J
    //   78: ldc2_w 868
    //   81: ldiv
    //   82: aload_0
    //   83: getfield 727	lhn:us	J
    //   86: lcmp
    //   87: iflt -29 -> 58
    //   90: new 871	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody
    //   93: dup
    //   94: invokespecial 872	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:<init>	()V
    //   97: astore_2
    //   98: aload_2
    //   99: getfield 875	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:bytes_city	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   102: invokestatic 880	aczc:getCity	()Ljava/lang/String;
    //   105: invokestatic 385	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   108: invokevirtual 390	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   111: aload_2
    //   112: getfield 883	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:str_city	Lcom/tencent/mobileqq/pb/PBStringField;
    //   115: invokestatic 886	aczc:getCityCode	()Ljava/lang/String;
    //   118: invokevirtual 477	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   121: aload_0
    //   122: getfield 464	lhn:mApp	Lcom/tencent/common/app/AppInterface;
    //   125: bipush 51
    //   127: invokevirtual 889	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   130: checkcast 891	acff
    //   133: aload_0
    //   134: getfield 464	lhn:mApp	Lcom/tencent/common/app/AppInterface;
    //   137: checkcast 174	com/tencent/mobileqq/app/QQAppInterface
    //   140: invokevirtual 894	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   143: invokevirtual 897	acff:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   146: astore_3
    //   147: aload_3
    //   148: ifnull +25 -> 173
    //   151: aload_2
    //   152: getfield 900	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:uint32_age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   155: aload_3
    //   156: getfield 905	com/tencent/mobileqq/data/Friends:age	I
    //   159: invokevirtual 398	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   162: aload_2
    //   163: getfield 908	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:uint32_sex	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   166: aload_3
    //   167: getfield 912	com/tencent/mobileqq/data/Friends:gender	B
    //   170: invokevirtual 398	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   173: new 914	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo
    //   176: dup
    //   177: invokespecial 915	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:<init>	()V
    //   180: astore_3
    //   181: invokestatic 359	kxm:iT	()Ljava/lang/String;
    //   184: astore 4
    //   186: aload 4
    //   188: invokestatic 364	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   191: ifne +330 -> 521
    //   194: aload 4
    //   196: invokevirtual 369	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   199: astore 4
    //   201: aload 4
    //   203: invokestatic 375	arwv:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   206: invokevirtual 369	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   209: astore 4
    //   211: aload_3
    //   212: getfield 916	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_muid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   215: aload 4
    //   217: invokestatic 385	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   220: invokevirtual 390	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   223: aload_3
    //   224: getfield 917	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:uint32_muid_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   227: iconst_1
    //   228: invokevirtual 398	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   231: invokestatic 403	jxp:na	()I
    //   234: istore_1
    //   235: aload_3
    //   236: getfield 918	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:uint32_conn	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   239: iload_1
    //   240: invokevirtual 398	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   243: invokestatic 411	aqgz:LU	()I
    //   246: istore_1
    //   247: aload_3
    //   248: getfield 919	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:uint32_carrier	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   251: iload_1
    //   252: invokevirtual 398	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   255: invokestatic 417	aqgz:getDeviceOSVersion	()Ljava/lang/String;
    //   258: astore 4
    //   260: aload_3
    //   261: getfield 920	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_os_ver	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   264: aload 4
    //   266: invokestatic 385	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   269: invokevirtual 390	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   272: invokestatic 423	aqgz:getQQVersion	()Ljava/lang/String;
    //   275: astore 4
    //   277: aload_3
    //   278: getfield 921	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_qq_ver	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   281: aload 4
    //   283: invokestatic 385	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   286: invokevirtual 390	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   289: invokestatic 431	com/tencent/common/config/AppSetting:getAppId	()I
    //   292: istore_1
    //   293: aload_3
    //   294: getfield 922	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_appid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   297: iload_1
    //   298: invokestatic 437	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   301: invokestatic 385	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   304: invokevirtual 390	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   307: invokestatic 443	cz:s	()J
    //   310: invokestatic 447	cz:f	(J)Ljava/lang/String;
    //   313: astore 4
    //   315: aload_3
    //   316: getfield 923	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_client_ip	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   319: aload 4
    //   321: invokestatic 385	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   324: invokevirtual 390	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   327: aload_3
    //   328: getfield 924	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:uint32_os_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   331: iconst_2
    //   332: invokevirtual 398	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   335: aload_2
    //   336: getfield 928	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:msg_phone_type	Ltencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo;
    //   339: aload_3
    //   340: iconst_1
    //   341: invokevirtual 929	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;Z)V
    //   344: invokestatic 931	lbz:a	()Llbz;
    //   347: invokevirtual 934	lbz:a	()Lcom/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule;
    //   350: astore_3
    //   351: aload_3
    //   352: ifnull +132 -> 484
    //   355: aload_3
    //   356: invokevirtual 939	com/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule:a	()Lcom/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule$PositionData;
    //   359: astore_3
    //   360: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq +29 -> 392
    //   366: ldc 69
    //   368: iconst_2
    //   369: new 180	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   376: ldc_w 941
    //   379: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload_3
    //   383: invokevirtual 944	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 542	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   392: aload_3
    //   393: ifnull +91 -> 484
    //   396: aload_3
    //   397: getfield 949	com/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule$PositionData:city	Ljava/lang/String;
    //   400: invokestatic 364	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   403: ifne +81 -> 484
    //   406: new 951	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo
    //   409: dup
    //   410: invokespecial 952	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo:<init>	()V
    //   413: astore 4
    //   415: aload 4
    //   417: getfield 953	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo:bytes_city	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   420: aload_3
    //   421: getfield 949	com/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule$PositionData:city	Ljava/lang/String;
    //   424: invokestatic 385	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   427: invokevirtual 390	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   430: aload 4
    //   432: getfield 956	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo:bytes_province	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   435: aload_3
    //   436: getfield 959	com/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule$PositionData:province	Ljava/lang/String;
    //   439: invokestatic 385	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   442: invokevirtual 390	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   445: aload 4
    //   447: getfield 962	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo:bytes_country	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   450: aload_3
    //   451: getfield 965	com/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule$PositionData:country	Ljava/lang/String;
    //   454: invokestatic 385	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   457: invokevirtual 390	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   460: aload 4
    //   462: getfield 968	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo:bytes_city_code	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   465: aload_3
    //   466: getfield 971	com/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule$PositionData:cityCode	Ljava/lang/String;
    //   469: invokestatic 385	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   472: invokevirtual 390	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   475: aload_2
    //   476: getfield 975	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:msg_location_info	Ltencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo;
    //   479: aload 4
    //   481: invokevirtual 978	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   484: aload_0
    //   485: ldc_w 980
    //   488: sipush 3003
    //   491: iconst_1
    //   492: aload_2
    //   493: invokevirtual 981	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:toByteArray	()[B
    //   496: invokestatic 489	lup:makeOIDBPkg	(Ljava/lang/String;II[B)Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   499: invokevirtual 493	lhn:sendPbReq	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   502: return
    //   503: astore 4
    //   505: aload_3
    //   506: getfield 916	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_muid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   509: ldc_w 507
    //   512: invokestatic 385	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   515: invokevirtual 390	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   518: goto -295 -> 223
    //   521: invokestatic 499	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   524: invokestatic 503	aqgz:be	(Landroid/content/Context;)Ljava/lang/String;
    //   527: astore 4
    //   529: aload 4
    //   531: invokestatic 364	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   534: ifne -303 -> 231
    //   537: aload 4
    //   539: ldc_w 505
    //   542: ldc_w 507
    //   545: invokevirtual 511	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   548: invokevirtual 514	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   551: invokestatic 375	arwv:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   554: invokevirtual 369	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   557: astore 4
    //   559: aload_3
    //   560: getfield 916	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_muid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   563: aload 4
    //   565: invokestatic 385	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   568: invokevirtual 390	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   571: aload_3
    //   572: getfield 917	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:uint32_muid_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   575: iconst_3
    //   576: invokevirtual 398	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   579: goto -348 -> 231
    //   582: astore 4
    //   584: iconst_0
    //   585: istore_1
    //   586: goto -339 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	589	0	this	lhn
    //   234	352	1	i	int
    //   97	396	2	localReqBody	tencent.im.oidb.cmd0xbbb.oidb_cmd0xbbb.ReqBody
    //   146	426	3	localObject1	Object
    //   184	296	4	localObject2	Object
    //   503	1	4	localException1	Exception
    //   527	37	4	str	String
    //   582	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   201	223	503	java/lang/Exception
    //   243	247	582	java/lang/Exception
  }
  
  public void b(List<mgw> paramList1, List<mgw> paramList2, boolean paramBoolean)
  {
    if (paramList1 == null) {}
    try
    {
      QLog.d("ChannelCoverInfoModule", 1, "[saveChannelInfoListInCacheAndDb] oldSectionList is null");
      if (paramList2 == null) {
        QLog.d("ChannelCoverInfoModule", 1, "[saveChannelInfoListInCacheAndDb] sectionList is null");
      }
      paramList1 = L(paramList1);
      ((mgw)paramList2.get(0)).iK = N(((mgw)paramList2.get(0)).iK);
      this.hS = M(paramList2);
      paramList2 = L(this.hS);
      if (paramBoolean) {
        o(true, ((mgw)this.hS.get(0)).iK);
      }
      if (!QLog.isColorLevel()) {
        break label216;
      }
      QLog.i("ChannelCoverInfoModule", 2, "saveChannelInfoListInCacheAndDb remove oldList");
      localIterator = paramList1.iterator();
      while (localIterator.hasNext()) {
        QLog.i("ChannelCoverInfoModule", 2, ((TabChannelCoverInfo)localIterator.next()).toString());
      }
      QLog.i("ChannelCoverInfoModule", 2, "saveChannelInfoListInCacheAndDb save newList");
    }
    finally {}
    Iterator localIterator = paramList2.iterator();
    while (localIterator.hasNext()) {
      QLog.i("ChannelCoverInfoModule", 2, ((TabChannelCoverInfo)localIterator.next()).toString());
    }
    label216:
    this.mExecutorService.execute(new ChannelCoverInfoModule.8(this, paramList1, paramList2));
  }
  
  public String c(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0).getString("readInJoy_weishi_channel_cover_seq", "");
  }
  
  public void c(int paramInt, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "updateMainChannelCoverInfo, channelCoverId = " + paramInt + " ;articleTitle = " + paramString + " ;articleId = " + paramLong);
    }
    synchronized (this.mDataLock)
    {
      ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)this.u.get(Integer.valueOf(paramInt));
      if (localChannelCoverInfo != null)
      {
        localChannelCoverInfo.mChannelCoverSummary = paramString;
        localChannelCoverInfo.mArticleId = paramLong;
        a(localChannelCoverInfo, 0);
        r(aI(), 0);
      }
      return;
    }
  }
  
  public void cq(List<channel_button.Section> paramList)
  {
    List localList;
    JSONArray localJSONArray;
    try
    {
      localList = this.hS;
      this.hS = new ArrayList(paramList.size());
      localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        channel_button.Section localSection = (channel_button.Section)paramList.next();
        mgw localmgw = new mgw(localSection);
        localJSONArray.put(localmgw.toJson());
        localmgw.iK = lum.T(localSection.rpt_msg_channel.get());
        this.hS.add(localmgw);
      }
      m(this.hS, localList);
    }
    finally {}
    cs(this.hS);
    b(localList, this.hS, true);
    if (localJSONArray.length() > 0) {
      ThreadManager.executeOnFileThread(new ChannelCoverInfoModule.9(this, localJSONArray));
    }
  }
  
  @UiThread
  public void e(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("updateChannel: ");
    if (paramTabChannelCoverInfo != null) {}
    for (Object localObject = paramTabChannelCoverInfo.toString();; localObject = "null")
    {
      QLog.d("ChannelCoverInfoModule", 2, (String)localObject);
      if (paramTabChannelCoverInfo == null) {
        return;
      }
      paramTabChannelCoverInfo = paramTabChannelCoverInfo.clone();
      localObject = this.hS.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (a(paramTabChannelCoverInfo, ((mgw)((Iterator)localObject).next()).iK)) {
          QLog.d("ChannelCoverInfoModule", 2, "updateChannel found in channelCoverInfoList!");
        }
      }
    }
    ThreadManager.getFileThreadHandler().post(new ChannelCoverInfoModule.1(this, paramTabChannelCoverInfo));
  }
  
  public void j(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.edit();
      paramQQAppInterface.putString("readInJoy_weishi_channel_cover_seq", paramString);
      paramQQAppInterface.commit();
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverInfoModule", 2, "updateChannelCoverSeqConfig, version =" + paramString);
      }
    }
  }
  
  public void m(List<mgw> paramList, int paramInt)
  {
    QLog.d("ChannelCoverInfoModule", 1, "requestUpdateChannelLists. ");
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QLog.d("ChannelCoverInfoModule", 2, "mChannelSectionList is null, do not requestUpdateChannelLists.");
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (mgw)((Iterator)localObject1).next();
        i(((mgw)localObject2).iK, "0xbbc update sectionId=" + ((mgw)localObject2).id);
      }
    }
    Object localObject1 = new oidb_cmd0xbbc.ReqBody();
    Object localObject2 = new ArrayList();
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      mgw localmgw = (mgw)localIterator1.next();
      channel_button.Section localSection = new channel_button.Section();
      ArrayList localArrayList = new ArrayList();
      if (localmgw.iK != null)
      {
        Iterator localIterator2 = localmgw.iK.iterator();
        if (localIterator2.hasNext())
        {
          paramList = (TabChannelCoverInfo)localIterator2.next();
          channel_button.Channel localChannel = new channel_button.Channel();
          localChannel.uint64_channel_id.set(paramList.mChannelCoverId);
          localChannel.enum_reason.set(paramList.reason);
          PBStringField localPBStringField = localChannel.str_proxy;
          if (TextUtils.isEmpty(paramList.proxy)) {}
          for (paramList = "";; paramList = paramList.proxy)
          {
            localPBStringField.set(paramList);
            localArrayList.add(localChannel);
            break;
          }
        }
      }
      if (!localArrayList.isEmpty())
      {
        localSection.uint64_section_id.set(localmgw.id);
        localSection.str_section_name.set(localmgw.name);
        localSection.str_note_text.set(localmgw.text);
        localSection.rpt_msg_channel.set(localArrayList);
        ((List)localObject2).add(localSection);
      }
    }
    ((oidb_cmd0xbbc.ReqBody)localObject1).rpt_msg_section.set((List)localObject2);
    paramList = new oidb_cmd0xbbc.PhoneInfo();
    localObject2 = kxm.iT();
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = arwv.toMD5(((String)localObject2).toLowerCase()).toLowerCase();
      paramList.bytes_muid.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      paramList.uint32_muid_type.set(1);
    }
    for (;;)
    {
      int i = jxp.na();
      paramList.uint32_conn.set(i);
      i = 0;
      try
      {
        int j = aqgz.LU();
        i = j;
      }
      catch (Exception localException)
      {
        label450:
        break label450;
      }
      paramList.uint32_carrier.set(i);
      localObject2 = aqgz.getDeviceOSVersion();
      paramList.bytes_os_ver.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localObject2 = aqgz.getQQVersion();
      paramList.bytes_qq_ver.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      i = AppSetting.getAppId();
      paramList.bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i)));
      localObject2 = cz.f(cz.s());
      paramList.bytes_client_ip.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      paramList.uint32_os_type.set(2);
      ((oidb_cmd0xbbc.ReqBody)localObject1).msg_phone_type.set(paramList, true);
      ((oidb_cmd0xbbc.ReqBody)localObject1).uint32_set_type.set(paramInt);
      sendPbReq(lup.makeOIDBPkg("OidbSvc.0xbbc", 3004, 1, ((oidb_cmd0xbbc.ReqBody)localObject1).toByteArray()));
      awit.H("UPDATE_CHANNEL_LIST_KEY_0xbbc", Boolean.valueOf(true));
      return;
      localObject2 = aqgz.be(BaseApplication.getContext());
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = arwv.toMD5(((String)localObject2).replaceAll(":", "").toUpperCase()).toLowerCase();
        paramList.bytes_muid.set(ByteStringMicro.copyFromUtf8((String)localObject2));
        paramList.uint32_muid_type.set(3);
      }
    }
  }
  
  public void n(List<oidb_cmd0x69f.ChannelInfo> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverInfoModule", 2, "saveChannelCoverList, list is empty");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (QLog.isColorLevel()) {}
    for (StringBuilder localStringBuilder = new StringBuilder("saveChannelCoverList channelID=" + paramInt + "\n");; localStringBuilder = null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo1 = lum.a((oidb_cmd0x69f.ChannelInfo)paramList.next(), paramInt);
        if ((localChannelCoverInfo1.mChannelCoverName == null) || ("".equals(localChannelCoverInfo1.mChannelCoverName)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChannelCoverInfoModule", 2, "saveChannelCoverList coverName is null, filter this info");
          }
        }
        else
        {
          c(localChannelCoverInfo1);
          if ((localChannelCoverInfo1.mChannelCoverSummary == null) || ("".equals(localChannelCoverInfo1.mChannelCoverSummary)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ChannelCoverInfoModule", 2, "saveChannelCoverList coverSummary is null");
            }
            ChannelCoverInfo localChannelCoverInfo2 = a(localChannelCoverInfo1.mChannelCoverId, paramInt);
            if ((localChannelCoverInfo2 != null) && (localChannelCoverInfo2.mChannelCoverSummary != null) && (!"".equals(localChannelCoverInfo2.mChannelCoverSummary)))
            {
              localChannelCoverInfo1.mChannelCoverSummary = localChannelCoverInfo2.mChannelCoverSummary;
              if (QLog.isColorLevel()) {
                QLog.d("ChannelCoverInfoModule", 2, "saveChannelCoverList modify coverSummary, summary is " + localChannelCoverInfo2.mChannelCoverSummary);
              }
            }
          }
          localArrayList.add(localChannelCoverInfo1);
          if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
            localStringBuilder.append("[channelCoverId=").append(localChannelCoverInfo1.mChannelCoverId).append(", mChannelCoverName=").append(localChannelCoverInfo1.mChannelCoverName).append(", mChannelCoverStyle=").append(localChannelCoverInfo1.mChannelCoverStyle).append(", mChannelCoverSummary=").append(localChannelCoverInfo1.mChannelCoverSummary).append(", mChannelCoverPicUrl=").append(localChannelCoverInfo1.mChannelCoverPicUrl).append(", mChannelJumpUrl=").append(localChannelCoverInfo1.mChannelJumpUrl).append(", mArticleIds=").append(localChannelCoverInfo1.mArticleId).append(", mChannelType=").append(localChannelCoverInfo1.mChannelType).append(", isExternalExposure = ").append(localChannelCoverInfo1.isExternalExposure).append(", externalExposureIcon : ").append(localChannelCoverInfo1.externalExposureBackgroundUrl).append("]\n");
          }
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
        QLog.d("ChannelCoverInfoModule", 2, localStringBuilder.toString());
      }
      q(localArrayList, paramInt);
      return;
    }
  }
  
  public void ny(boolean paramBoolean)
  {
    if (this.mMainThreadHandler != null) {
      this.mMainThreadHandler.post(new ChannelCoverInfoModule.7(this, paramBoolean));
    }
  }
  
  public void o(List<oidb_cmd0xbe6.MsgChannelInfo> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverInfoModule", 2, "saveChannelCoverList, list is empty");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (QLog.isColorLevel()) {}
    for (StringBuilder localStringBuilder = new StringBuilder("saveChannelCoverList channelID=" + paramInt + "\n");; localStringBuilder = null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo = lum.a((oidb_cmd0xbe6.MsgChannelInfo)paramList.next(), paramInt);
        localArrayList.add(localChannelCoverInfo);
        if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
          localStringBuilder.append("[channelCoverId=").append(localChannelCoverInfo.mChannelCoverId).append(", mChannelCoverName=").append(localChannelCoverInfo.mChannelCoverName).append(", mChannelCoverStyle=").append(localChannelCoverInfo.mChannelCoverStyle).append(", mChannelCoverSummary=").append(localChannelCoverInfo.mChannelCoverSummary).append(", mChannelCoverPicUrl=").append(localChannelCoverInfo.mChannelCoverPicUrl).append(", mChannelJumpUrl=").append(localChannelCoverInfo.mChannelJumpUrl).append(", mArticleIds=").append(localChannelCoverInfo.mArticleId).append(", mChannelType=").append(localChannelCoverInfo.mChannelType).append(", isExternalExposure = ").append(localChannelCoverInfo.isExternalExposure).append(", externalExposureIcon : ").append(localChannelCoverInfo.externalExposureBackgroundUrl).append("]\n");
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
        QLog.d("ChannelCoverInfoModule", 2, localStringBuilder.toString());
      }
      q(localArrayList, paramInt);
      return;
    }
  }
  
  public void p(List<ChannelCoverInfo> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)((Iterator)localObject).next();
      localLinkedHashMap.put(Integer.valueOf(localChannelCoverInfo.mChannelCoverId), localChannelCoverInfo);
    }
    localObject = this.mDataLock;
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        this.u.clear();
        this.u.putAll(localLinkedHashMap);
        return;
      }
      finally {}
      if (paramInt == 56)
      {
        this.v.clear();
        this.v.putAll(localLinkedHashMap);
      }
      else if (paramInt == 41402)
      {
        this.w.clear();
        this.w.putAll(localLinkedHashMap);
      }
      else
      {
        this.dQ.remove(Integer.valueOf(paramInt));
        this.dQ.put(Integer.valueOf(paramInt), new ArrayList(paramList));
      }
    }
  }
  
  public void q(List<ChannelCoverInfo> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    Object localObject = r(paramInt);
    if ((localObject != null) && (paramList != null) && (QLog.isColorLevel())) {
      QLog.d("ChannelCoverInfoModule", 2, "saveNewAndRemoveOldChannelCoverInfo removeListSize =" + ((List)localObject).size() + " ;addListSize = " + paramList.size());
    }
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        cN(((ChannelCoverInfo)((Iterator)localObject).next()).mChannelCoverId, paramInt);
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((ChannelCoverInfo)paramList.next(), paramInt);
    }
    r(r(paramInt), paramInt);
  }
  
  public void qq(int paramInt)
  {
    this.mExecutorService.execute(new ChannelCoverInfoModule.4(this, paramInt));
  }
  
  public List<ChannelCoverInfo> r(int paramInt)
  {
    List localList = null;
    if (paramInt == 0) {
      localList = aI();
    }
    do
    {
      return localList;
      if (paramInt == 56) {
        return aJ();
      }
      if (paramInt == 41402) {
        return aK();
      }
    } while (!this.dQ.containsKey(Integer.valueOf(paramInt)));
    return new ArrayList((Collection)this.dQ.get(Integer.valueOf(paramInt)));
  }
  
  public void r(List<ChannelCoverInfo> paramList, int paramInt)
  {
    ct(paramList);
    if (this.mMainThreadHandler != null) {
      this.mMainThreadHandler.post(new ChannelCoverInfoModule.6(this, paramInt, paramList));
    }
  }
  
  public void rl(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "requestChannelCoverListFromServer");
    }
    if (paramInt == 41402)
    {
      aMn();
      return;
    }
    Object localObject = new oidb_cmd0x69f.ReqBody();
    long l = Long.valueOf(kxm.getAccount()).longValue();
    ((oidb_cmd0x69f.ReqBody)localObject).uint64_uin.set(l);
    ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_jump_url.set(1);
    ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_id.set(paramInt);
    ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_cover.set(1);
    if (paramInt == 0)
    {
      ((oidb_cmd0x69f.ReqBody)localObject).uint64_req_ctrl_bits.set(7L);
      int j = dm(paramInt);
      int i = j;
      if (j == 0)
      {
        i = j;
        if (this.mApp != null)
        {
          i = j;
          if ((this.mApp instanceof QQAppInterface)) {
            i = a((QQAppInterface)this.mApp, paramInt);
          }
        }
      }
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_seq.set(i);
      localObject = lup.makeOIDBPkg("OidbSvc.0x69f", 1695, 0, ((oidb_cmd0x69f.ReqBody)localObject).toByteArray());
      if (paramInt != 0) {
        break label247;
      }
      ((ToServiceMsg)localObject).getAttributes().put("req_channellist_source", Integer.valueOf(3));
    }
    for (;;)
    {
      ((ToServiceMsg)localObject).getAttributes().put("req_channellist_channel_id", Integer.valueOf(paramInt));
      sendPbReq((ToServiceMsg)localObject);
      return;
      if (paramInt == 56)
      {
        ((oidb_cmd0x69f.ReqBody)localObject).uint64_req_ctrl_bits.set(3L);
        break;
      }
      ((oidb_cmd0x69f.ReqBody)localObject).uint64_req_ctrl_bits.set(4L);
      break;
      label247:
      if (paramInt == 56) {
        ((ToServiceMsg)localObject).getAttributes().put("req_channellist_source", Integer.valueOf(4));
      }
    }
  }
  
  /* Error */
  public List<TabChannelCoverInfo> v(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 836	lhn:hS	Ljava/util/List;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 836	lhn:hS	Ljava/util/List;
    //   13: iload_1
    //   14: invokeinterface 300 2 0
    //   19: checkcast 113	mgw
    //   22: getfield 116	mgw:iK	Ljava/util/List;
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: areturn
    //   30: aconst_null
    //   31: astore_2
    //   32: goto -6 -> 26
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	lhn
    //   0	40	1	paramInt	int
    //   25	7	2	localList	List
    //   35	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	35	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lhn
 * JD-Core Version:    0.7.0.1
 */