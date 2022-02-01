package com.tencent.mobileqq.activity.qwallet.redpacket;

import Wallet.GetGroupRedPackListReq;
import Wallet.GetGroupRedPackListRsp;
import Wallet.GetSkinListReq;
import Wallet.RedPackGrapInfo;
import Wallet.SetSelectedSkinReq;
import aaai;
import aabz.a;
import aaca;
import aadm;
import aadn;
import aadq;
import aadr;
import aads;
import aadt;
import aadu;
import aadv;
import aadw;
import aagd;
import acfp;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import aqgz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import zxj;
import zyb;

public class RedPacketManager
  implements IRedPacket
{
  public static final String CONFIG_BIG_ANIM = "bigAnimMap";
  public static final String CONFIG_MODULE = "redPack";
  public static final String CONFIG_POP_AD = "popAd";
  public static final String CONFIG_POP_ANIM = "popAnimMap";
  public static final String CONFIG_SKINS = "skinMap";
  public static final String CONFIG_TAIL = "tail";
  public static final String CONFIG_URL_DETAULT_PREFIX = "https://imgcache.qq.com/channel/static/socialpay/skin/";
  public static final String CONFIG_URL_PANEL_PREFIX = "https://i.gtimg.cn/channel/imglib/201803/";
  public static final String CONFIG_URL_THEME_PREFIX = "https://i.gtimg.cn/channel/static/socialpay/paneltheme/socialpay_theme_v1_";
  public static final String CONFIG_URL_VOICE_PREFIX = "https://imgcache.qq.com/channel/static/socialpay/voice/";
  public static List<aadm> CURRENT_PANEL_DATA = new ArrayList();
  public static final String FILE_SKINS = "skins";
  public static final int FLAG_DEFAULT_REDPKG = 1;
  public static final int FLAG_LOCK_TEXT_REDPKG = 4;
  public static final int FLAG_LOCK_VOICE_REDPKG = 8;
  public static final int FLAG_LUCK_REDPKG = 2;
  public static final String TAG = "RedPacketManager";
  public static final Map<Integer, Integer> TYPEHBINFOMAP;
  public static final int TYPE_CLEAR_CACHE = 1;
  public static final int TYPE_DEFAULT_REDPKG = 0;
  public static final int TYPE_DRAW_REDPKG = 10;
  public static final int TYPE_ENOJI_REDPKG = 8;
  public static final int TYPE_EXCLUSIVE_REDPKG = 11;
  public static final int TYPE_F2F_REDPKG = 5;
  public static final int TYPE_GOLD_REDPKG = 12;
  public static final int TYPE_H5_REDPKG = 4;
  public static final int TYPE_IDIOM_REDPACKET = 9;
  public static final int TYPE_KSONG_REDPKG = 7;
  public static final int TYPE_LOCK_TEXT_REDPKG = 2;
  public static final int TYPE_LOCK_VOICE_REDPKG = 6;
  public static final int TYPE_LUCK_REDPKG = 1;
  public static final int TYPE_MINIAPP_REDPKG = 13;
  public static final int TYPE_THEME_REDPKG = 3;
  static HashMap<Integer, aadm> hR;
  private static byte[] lock = new byte[0];
  protected BusinessObserver d = new aadu(this);
  private HashMap<String, JSONObject> hP;
  private HashMap<String, JSONObject> hQ;
  protected HashMap<String, IRedPacket.OnGetAvailableListListener> hS;
  private List<BusinessObserver> observers = new ArrayList();
  
  static
  {
    TYPEHBINFOMAP = new RedPacketManager.1();
    hR = new HashMap();
    hR.put(Integer.valueOf(0), new aadm("", 0, acfp.m(2131713795), "1102", "", "#5B6175"));
    hR.put(Integer.valueOf(1), new aadm("", 1, acfp.m(2131713807), "1101", "", "#5B6175"));
    hR.put(Integer.valueOf(6), new aadm("", 6, acfp.m(2131713797), "1292", "", "#5B6175"));
    hR.put(Integer.valueOf(2), new aadm("", 2, acfp.m(2131713784), "1293", "", "#5B6175"));
  }
  
  public static String genCacheKeyBySkin(int paramInt1, int paramInt2)
  {
    String str1 = "";
    if (paramInt1 != -1) {
      str1 = "" + "f_" + paramInt1;
    }
    String str2 = str1;
    if (paramInt2 != -1)
    {
      str2 = str1;
      if (!TextUtils.isEmpty(str1)) {
        str2 = str1 + "_";
      }
      str2 = str2 + "s_" + paramInt2;
    }
    return str2;
  }
  
  public static String[] genMatchKeys(int paramInt1, int paramInt2)
  {
    String str1 = "f_" + paramInt1;
    String str2 = "s_" + paramInt2;
    return new String[] { str1 + "_" + str2, str1, str2 };
  }
  
  public static int getEnterType(int paramInt)
  {
    Iterator localIterator = TYPEHBINFOMAP.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger1 = (Integer)localIterator.next();
      Integer localInteger2 = (Integer)TYPEHBINFOMAP.get(localInteger1);
      if ((localInteger2 != null) && (localInteger2.intValue() == paramInt)) {
        return localInteger1.intValue();
      }
    }
    return 1;
  }
  
  public static IRedPacket getInstance()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return a.a;
    }
    return b.a;
  }
  
  private boolean hu(int paramInt)
  {
    return paramInt == 101;
  }
  
  private static boolean hv(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3000);
  }
  
  public static boolean isBulletinValidDate(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    long l1 = aagd.X(paramString1);
    long l2 = aagd.X(paramString2);
    boolean bool1 = bool2;
    if (l1 != -1L)
    {
      bool1 = bool2;
      if (l2 != -1L)
      {
        bool1 = bool2;
        if (l1 < l2)
        {
          long l3 = NetConnInfoCenter.getServerTimeMillis();
          bool1 = bool2;
          if (l3 >= l1)
          {
            bool1 = bool2;
            if (l3 <= l2) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean isValidDate(String paramString1, String paramString2)
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = aagd.X(paramString1);
    long l3 = aagd.X(paramString2);
    boolean bool;
    if (l1 >= l2) {
      bool = true;
    }
    while (bool) {
      if ((l3 == -1L) || (l1 <= l3))
      {
        return true;
        bool = false;
      }
      else
      {
        return false;
      }
    }
    return bool;
  }
  
  public static boolean verifyDrawHbParams(aadm paramaadm)
  {
    return (paramaadm != null) && (paramaadm.params != null) && (paramaadm.params.optJSONArray("subjects") != null) && (paramaadm.params.optJSONArray("subjects").length() > 0);
  }
  
  public static boolean verifyEmojiHbParams(aadm paramaadm)
  {
    return (paramaadm != null) && (paramaadm.params != null) && (paramaadm.params.optJSONArray("heartList") != null) && (paramaadm.params.optJSONArray("heartList").length() != 0);
  }
  
  public static boolean verifyLingBySession(SessionInfo paramSessionInfo)
  {
    return (paramSessionInfo == null) || (!ChatActivityUtils.fY(paramSessionInfo.cZ));
  }
  
  public static boolean verifyLuckBySession(SessionInfo paramSessionInfo)
  {
    return (paramSessionInfo == null) || (hv(paramSessionInfo.cZ));
  }
  
  public void F(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    Object localObject1;
    GetGroupRedPackListRsp localGetGroupRedPackListRsp;
    int i;
    label48:
    String str;
    label65:
    int j;
    label140:
    label146:
    label152:
    do
    {
      do
      {
        return;
        localObject1 = (GetGroupRedPackListReq)paramBundle.getSerializable("req");
        localGetGroupRedPackListRsp = (GetGroupRedPackListRsp)paramBundle.getSerializable("rsp");
        paramBundle = aagd.getQQAppInterface();
      } while (paramBundle == null);
      if (localGetGroupRedPackListRsp != null)
      {
        i = localGetGroupRedPackListRsp.iRetCode;
        str = paramBundle.getCurrentAccountUin();
        if (localObject1 == null) {
          break label140;
        }
        paramBundle = ((GetGroupRedPackListReq)localObject1).sGroupUin;
        if (localObject1 == null) {
          break label146;
        }
      }
      for (j = ((GetGroupRedPackListReq)localObject1).iGroupType;; j = 0)
      {
        if ((!TextUtils.isEmpty(paramBundle)) && (!TextUtils.isEmpty(str))) {
          break label152;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("RedPacketManager", 2, "onGetGroupAavailableList groupUin or myUin is null, retCode:" + i + " groupUin:" + paramBundle);
        return;
        i = -1;
        break label48;
        paramBundle = "";
        break label65;
      }
      Object localObject2 = null;
      localObject1 = localObject2;
      if (this.hS != null)
      {
        localObject1 = localObject2;
        if (this.hS.get(paramBundle + "_" + j) != null) {
          localObject1 = (IRedPacket.OnGetAvailableListListener)this.hS.get(paramBundle + "_" + j);
        }
      }
      if (localObject1 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("RedPacketManager", 2, "onGetGroupAavailableList listener is null");
    return;
    if ((!paramBoolean) || (i != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedPacketManager", 2, "onGetGroupAavailableList error. isSuccess:" + paramBoolean + " retCode:" + i);
      }
      ThreadManager.getFileThreadHandler().post(new RedPacketManager.7(this, str, paramBundle, j));
      return;
    }
    a(str, paramBundle, j, (IRedPacket.OnGetAvailableListListener)localObject1, localGetGroupRedPackListRsp, true);
  }
  
  protected void a(String paramString1, String paramString2, int paramInt, IRedPacket.OnGetAvailableListListener paramOnGetAvailableListListener, GetGroupRedPackListRsp paramGetGroupRedPackListRsp, boolean paramBoolean)
  {
    if (paramOnGetAvailableListListener == null) {}
    label247:
    do
    {
      return;
      if ((paramGetGroupRedPackListRsp == null) || (paramGetGroupRedPackListRsp.vecRedPackList == null))
      {
        paramOnGetAvailableListListener.OnGetAvailableList(null);
        return;
      }
      long l = NetConnInfoCenter.getServerTime();
      if ((!paramBoolean) && (l > paramGetGroupRedPackListRsp.lFailureTime))
      {
        paramOnGetAvailableListListener.OnGetAvailableList(null);
        return;
      }
      Object localObject1 = aaca.n(2);
      int i = paramGetGroupRedPackListRsp.vecRedPackList.size() - 1;
      int j;
      if (i >= 0)
      {
        Object localObject2 = (RedPackGrapInfo)paramGetGroupRedPackListRsp.vecRedPackList.get(i);
        if (localObject2 == null) {
          paramGetGroupRedPackListRsp.vecRedPackList.remove(i);
        }
        for (;;)
        {
          i -= 1;
          break;
          if ((!paramBoolean) && (((RedPackGrapInfo)localObject2).lCreateTime + 864000L < l))
          {
            paramGetGroupRedPackListRsp.vecRedPackList.remove(i);
          }
          else
          {
            localObject2 = ((RedPackGrapInfo)localObject2).sBiilNo;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              if (localObject1 != null)
              {
                j = 0;
                for (;;)
                {
                  if (j >= ((ArrayList)localObject1).size()) {
                    break label247;
                  }
                  aabz.a locala = (aabz.a)((ArrayList)localObject1).get(j);
                  if ((locala != null) && (locala.mBusinessId != null) && (locala.mBusinessId.equals(localObject2)))
                  {
                    paramGetGroupRedPackListRsp.vecRedPackList.remove(i);
                    break;
                  }
                  j += 1;
                }
              }
            }
            else {
              paramGetGroupRedPackListRsp.vecRedPackList.remove(i);
            }
          }
        }
      }
      paramOnGetAvailableListListener.OnGetAvailableList(paramGetGroupRedPackListRsp.vecRedPackList);
      localObject1 = aagd.getQQAppInterface();
      paramOnGetAvailableListListener = null;
      if (localObject1 != null) {
        paramOnGetAvailableListListener = (zxj)((QQAppInterface)localObject1).getManager(125);
      }
      if (paramOnGetAvailableListListener != null)
      {
        int k = 0;
        if (k < paramGetGroupRedPackListRsp.vecRedPackList.size())
        {
          localObject1 = (RedPackGrapInfo)paramGetGroupRedPackListRsp.vecRedPackList.get(k);
          if ((localObject1 != null) && (!TextUtils.isEmpty(((RedPackGrapInfo)localObject1).sBiilNo)) && ((((RedPackGrapInfo)localObject1).iMsgType == 6) || (((RedPackGrapInfo)localObject1).iMsgType == 13) || (((RedPackGrapInfo)localObject1).iMsgType == 15) || (((RedPackGrapInfo)localObject1).iMsgType == 18) || (((RedPackGrapInfo)localObject1).iMsgType == 19) || (((RedPackGrapInfo)localObject1).iMsgType == 21) || (((RedPackGrapInfo)localObject1).iMsgType == 22)) && (paramOnGetAvailableListListener.a(((RedPackGrapInfo)localObject1).sBiilNo) == null))
          {
            if (paramInt != 1) {
              break label530;
            }
            j = 1;
            i = 0;
            if ((((RedPackGrapInfo)localObject1).iMsgType != 13) && (((RedPackGrapInfo)localObject1).iMsgType != 15)) {
              break label547;
            }
            i = 1;
          }
          for (;;)
          {
            paramOnGetAvailableListListener.a(((RedPackGrapInfo)localObject1).sBiilNo, ((RedPackGrapInfo)localObject1).sIndex, ((RedPackGrapInfo)localObject1).sTitle, String.valueOf(((RedPackGrapInfo)localObject1).lUin), ((RedPackGrapInfo)localObject1).lCreateTime + 90000L, String.valueOf(j), paramString2, ((RedPackGrapInfo)localObject1).sAuthKey, false, false, i);
            k += 1;
            break;
            if (paramInt == 2)
            {
              j = 2;
              break label443;
            }
            j = 3;
            break label443;
            if (((RedPackGrapInfo)localObject1).iMsgType == 18) {
              i = 2;
            } else if (((RedPackGrapInfo)localObject1).iMsgType == 19) {
              i = 3;
            } else if ((((RedPackGrapInfo)localObject1).iMsgType == 21) || (((RedPackGrapInfo)localObject1).iMsgType == 24) || (((RedPackGrapInfo)localObject1).iMsgType == 25)) {
              i = 4;
            } else if (((RedPackGrapInfo)localObject1).iMsgType == 22) {
              i = 5;
            } else if (((RedPackGrapInfo)localObject1).iMsgType == 23) {
              i = 6;
            }
          }
        }
      }
    } while (!paramBoolean);
    label443:
    ThreadManager.getFileThreadHandler().post(new RedPacketManager.8(this, paramGetGroupRedPackListRsp, paramString1, paramString2, paramInt));
    label530:
    label547:
    return;
  }
  
  public List<aadm> getPanelList(SessionInfo paramSessionInfo)
  {
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    int n;
    for (int j = 0;; j = n)
    {
      int m;
      for (;;)
      {
        try
        {
          Object localObject1 = aagd.getQQAppInterface();
          i = k;
          if (localObject1 == null) {
            continue;
          }
          Object localObject2 = (aaai)((QQAppInterface)localObject1).getManager(245);
          localObject1 = ((aaai)localObject2).a("redPackPanel", new String[] { "panelRedPkgList" });
          localObject2 = ((aaai)localObject2).a("redPackPanel", "#5B6175", new String[] { "themeInfo", "fontColorIcon" });
          i = k;
          if (localObject1 == null) {
            continue;
          }
          j = 0;
          m = 0;
          k = j;
          i = j;
          try
          {
            if (m >= ((JSONArray)localObject1).length()) {
              continue;
            }
            k = j;
            JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(m);
            if (localJSONObject == null)
            {
              n = j;
            }
            else
            {
              k = j;
              localaadm = new aadm();
              k = j;
              localaadm.id = localJSONObject.optString("id", "");
              k = j;
              localaadm.type = localJSONObject.optInt("type", -1);
              k = j;
              localaadm.name = localJSONObject.optString("name", "");
              k = j;
              localaadm.icon = localJSONObject.optString("icon_pic", "");
              k = j;
              localaadm.bct = ((String)localObject2);
              k = j;
              localaadm.params = localJSONObject.optJSONObject("params");
              k = j;
              if (QLog.isColorLevel())
              {
                k = j;
                QLog.i("RedPacketManager", 2, "panelData: " + localaadm);
              }
              k = j;
              if (localaadm.type == 0)
              {
                i = j | 0x1;
                k = i;
                if (localaadm.params != null) {
                  continue;
                }
                k = i;
                localArrayList.add(localaadm);
                n = i;
              }
            }
          }
          catch (Throwable localThrowable1)
          {
            i = k;
          }
        }
        catch (Throwable localThrowable2)
        {
          aadm localaadm;
          int i1;
          int i = j;
          continue;
        }
        localThrowable1.printStackTrace();
        if (((i & 0x8) != 8) && (verifyLingBySession(paramSessionInfo))) {
          localArrayList.add(0, hR.get(Integer.valueOf(6)));
        }
        if (((i & 0x4) != 4) && (verifyLingBySession(paramSessionInfo))) {
          localArrayList.add(0, hR.get(Integer.valueOf(2)));
        }
        if ((i & 0x1) != 1) {
          localArrayList.add(0, hR.get(Integer.valueOf(0)));
        }
        if (((i & 0x2) != 2) && (verifyLuckBySession(paramSessionInfo))) {
          localArrayList.add(0, hR.get(Integer.valueOf(1)));
        }
        return localArrayList;
        if (paramSessionInfo != null)
        {
          k = j;
          n = j;
          if (ChatActivityUtils.fY(paramSessionInfo.cZ)) {
            break label964;
          }
        }
        k = j;
        if (localaadm.type == 1)
        {
          k = j;
          n = j;
          if (!verifyLuckBySession(paramSessionInfo)) {
            break label964;
          }
          i = j | 0x2;
        }
        else
        {
          k = j;
          if (localaadm.type == 2)
          {
            k = j;
            n = j;
            if (!verifyLingBySession(paramSessionInfo)) {
              break label964;
            }
            i = j | 0x4;
          }
          else
          {
            k = j;
            if (localaadm.type == 6)
            {
              k = j;
              n = j;
              if (!verifyLingBySession(paramSessionInfo)) {
                break label964;
              }
              i = j | 0x8;
            }
            else
            {
              k = j;
              if (localaadm.type == 3)
              {
                k = j;
                n = j;
                if (localaadm.params == null) {
                  break label964;
                }
                k = j;
                i = localaadm.params.optInt("entry", 0);
                k = j;
                i1 = localaadm.params.optInt("theme_id", 0);
                n = j;
                if (i < 0) {
                  break label964;
                }
                n = j;
                if (i > 1) {
                  break label964;
                }
                n = j;
                if (i1 < 2) {
                  break label964;
                }
                i = j;
                if (i1 > 127)
                {
                  n = j;
                  break label964;
                }
              }
              else
              {
                k = j;
                if (localaadm.type == 4)
                {
                  k = j;
                  n = j;
                  if (localaadm.params == null) {
                    break label964;
                  }
                  i = j;
                  k = j;
                  if (TextUtils.isEmpty(localaadm.params.optString("url")))
                  {
                    n = j;
                    break label964;
                  }
                }
                else
                {
                  k = j;
                  if (localaadm.type == 8)
                  {
                    i = j;
                    k = j;
                    if (!verifyEmojiHbParams(localaadm))
                    {
                      n = j;
                      break label964;
                    }
                  }
                  else
                  {
                    k = j;
                    if (localaadm.type == 10)
                    {
                      i = j;
                      k = j;
                      if (!verifyDrawHbParams(localaadm))
                      {
                        n = j;
                        break label964;
                      }
                    }
                    else
                    {
                      k = j;
                      if (localaadm.type == 11)
                      {
                        i = j;
                        if (paramSessionInfo != null)
                        {
                          i = j;
                          k = j;
                          if (!hv(paramSessionInfo.cZ))
                          {
                            n = j;
                            break label964;
                          }
                        }
                      }
                      else
                      {
                        i = j;
                        k = j;
                        if (localaadm.type == 12)
                        {
                          k = j;
                          n = j;
                          if (localaadm.params == null) {
                            break label964;
                          }
                          i = j;
                          k = j;
                          if (TextUtils.isEmpty(localaadm.params.optString("schema")))
                          {
                            n = j;
                            break label964;
                            k = i;
                            n = i;
                            if (!isValidDate(localaadm.params.optString("begintime", ""), localaadm.params.optString("endtime", ""))) {
                              break label964;
                            }
                            k = i;
                            localArrayList.add(localaadm);
                            n = i;
                            break label964;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      label964:
      m += 1;
    }
  }
  
  public List<aadn> getPanelTabList(SessionInfo paramSessionInfo)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool = hv(paramSessionInfo.cZ);
    for (;;)
    {
      int j;
      aadn localaadn;
      int i;
      try
      {
        Object localObject1 = aagd.getQQAppInterface();
        if (localObject1 != null)
        {
          Object localObject2 = (aaai)((QQAppInterface)localObject1).getManager(245);
          localObject1 = ((aaai)localObject2).a("redPackPanel", new String[] { "panelTabList" });
          localObject2 = ((aaai)localObject2).a("redPackPanel", "#27BEF6", new String[] { "themeInfo", "fontColorTab" });
          if (localObject1 != null)
          {
            j = 0;
            if (j < ((JSONArray)localObject1).length())
            {
              Object localObject3 = ((JSONArray)localObject1).getJSONObject(j);
              if ((localObject3 == null) || ((hu(((JSONObject)localObject3).optInt("type", -1))) && (!bool))) {
                break label433;
              }
              localaadn = new aadn();
              localaadn.id = ((JSONObject)localObject3).optString("id", "");
              localaadn.type = ((JSONObject)localObject3).optInt("type", -1);
              localaadn.name = ((JSONObject)localObject3).optString("name", "");
              localaadn.bct = ((String)localObject2);
              localaadn.params = ((JSONObject)localObject3).optJSONObject("params");
              if ((localaadn.type == 100) || (localaadn.type == 102))
              {
                if (localaadn.params == null) {
                  break label433;
                }
                localObject3 = localaadn.params.optString("url");
                if (TextUtils.isEmpty((CharSequence)localObject3)) {
                  break label433;
                }
                if (localaadn.type == 100)
                {
                  if (paramSessionInfo.cZ != 1) {
                    break label368;
                  }
                  i = 1;
                  localObject3 = (String)localObject3 + "&type=" + i + "&uin=" + paramSessionInfo.aTl;
                  localaadn.params.put("url", localObject3);
                }
              }
              if (localaadn.params != null) {
                break label383;
              }
              localArrayList.add(localaadn);
            }
          }
        }
      }
      catch (Throwable paramSessionInfo)
      {
        paramSessionInfo.printStackTrace();
      }
      return localArrayList;
      label368:
      if (paramSessionInfo.cZ == 3000)
      {
        i = 2;
        continue;
        label383:
        if (isValidDate(localaadn.params.optString("begintime", ""), localaadn.params.optString("endtime", ""))) {
          localArrayList.add(localaadn);
        }
      }
      else
      {
        i = 0;
        continue;
      }
      label433:
      j += 1;
    }
  }
  
  public JSONObject getPopAd(int paramInt1, int paramInt2)
  {
    int j = 0;
    Object localObject1 = null;
    Object localObject6;
    int i;
    Object localObject3;
    try
    {
      ??? = aagd.getQQAppInterface();
      if (??? == null) {
        break label264;
      }
      localObject6 = (aaai)((QQAppInterface)???).getManager(245);
      if (this.hQ != null) {
        break label187;
      }
      synchronized (lock)
      {
        if (this.hQ != null) {
          break label184;
        }
        localObject6 = ((aaai)localObject6).a("redPack", new String[] { "popAd" });
        if (localObject6 == null) {
          break label184;
        }
        this.hQ = new HashMap();
        if (localObject6 == null) {
          break label184;
        }
        i = 0;
        if (i >= ((JSONArray)localObject6).length()) {
          break label184;
        }
        JSONObject localJSONObject = ((JSONArray)localObject6).getJSONObject(i);
        if (localJSONObject == null) {
          break label266;
        }
        String str = genCacheKeyBySkin(localJSONObject.optInt("skinId", -1), localJSONObject.optInt("redPackChannel", -1));
        if (TextUtils.isEmpty(str)) {
          break label266;
        }
        this.hQ.put(str, localJSONObject);
      }
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      localObject3 = null;
    }
    label176:
    return localObject3;
    label184:
    label187:
    if (this.hQ != null)
    {
      localObject6 = genMatchKeys(paramInt1, paramInt2);
      paramInt2 = localObject6.length;
      paramInt1 = j;
    }
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        Object localObject5 = localObject6[paramInt1];
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject5)) {
            break label273;
          }
          localObject5 = (JSONObject)this.hQ.get(localObject5);
          localObject3 = localObject5;
          if (localObject5 == null) {
            break label273;
          }
          return localObject5;
        }
        catch (Throwable localThrowable2) {}
        break label176;
      }
      return localObject3;
      label264:
      return null;
      label266:
      i += 1;
      break;
      label273:
      paramInt1 += 1;
    }
  }
  
  public List<String> getReadyResList()
  {
    return null;
  }
  
  public void getSkin(RedPacketInfoBase paramRedPacketInfoBase, IRedPacket.OnGetSkinListener paramOnGetSkinListener)
  {
    if ((paramRedPacketInfoBase == null) || (paramOnGetSkinListener == null)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = aagd.getQQAppInterface();
        if (localObject != null)
        {
          WeakReference localWeakReference = new WeakReference(paramOnGetSkinListener);
          CustomizeStrategyFactory.RedPacketInfo localRedPacketInfo = new CustomizeStrategyFactory.RedPacketInfo();
          localRedPacketInfo.type = 5;
          localRedPacketInfo.skinType = paramRedPacketInfoBase.skinType;
          localRedPacketInfo.skinId = paramRedPacketInfoBase.skinId;
          localRedPacketInfo.bigAnimId = paramRedPacketInfoBase.bigAnimId;
          localRedPacketInfo.isCache = paramRedPacketInfoBase.isCache;
          localObject = CustomizeStrategyFactory.a().a((QQAppInterface)localObject, localRedPacketInfo, new aads(this, paramRedPacketInfoBase, localWeakReference));
          if (localObject != null)
          {
            ((CustomizeStrategyFactory.RedPacketInfo)localObject).isCache = paramRedPacketInfoBase.isCache;
            paramOnGetSkinListener.onGetSkin((RedPacketInfoBase)localObject);
            return;
          }
        }
      }
      catch (Throwable paramRedPacketInfoBase)
      {
        paramRedPacketInfoBase.printStackTrace();
      }
    }
  }
  
  public JSONObject getTail(int paramInt1, int paramInt2)
  {
    int j = 0;
    Object localObject1 = null;
    Object localObject6;
    int i;
    Object localObject3;
    try
    {
      ??? = aagd.getQQAppInterface();
      if (??? == null) {
        break label264;
      }
      localObject6 = (aaai)((QQAppInterface)???).getManager(245);
      if (this.hP != null) {
        break label187;
      }
      synchronized (lock)
      {
        if (this.hP != null) {
          break label184;
        }
        localObject6 = ((aaai)localObject6).a("redPack", new String[] { "tail" });
        if (localObject6 == null) {
          break label184;
        }
        this.hP = new HashMap();
        if (localObject6 == null) {
          break label184;
        }
        i = 0;
        if (i >= ((JSONArray)localObject6).length()) {
          break label184;
        }
        JSONObject localJSONObject = ((JSONArray)localObject6).getJSONObject(i);
        if (localJSONObject == null) {
          break label266;
        }
        String str = genCacheKeyBySkin(localJSONObject.optInt("skinId", -1), localJSONObject.optInt("redPackType", -1));
        if (TextUtils.isEmpty(str)) {
          break label266;
        }
        this.hP.put(str, localJSONObject);
      }
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      localObject3 = null;
    }
    label176:
    return localObject3;
    label184:
    label187:
    if (this.hP != null)
    {
      localObject6 = genMatchKeys(paramInt1, paramInt2);
      paramInt2 = localObject6.length;
      paramInt1 = j;
    }
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        Object localObject5 = localObject6[paramInt1];
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject5)) {
            break label273;
          }
          localObject5 = (JSONObject)this.hP.get(localObject5);
          localObject3 = localObject5;
          if (localObject5 == null) {
            break label273;
          }
          return localObject5;
        }
        catch (Throwable localThrowable2) {}
        break label176;
      }
      return localObject3;
      label264:
      return null;
      label266:
      i += 1;
      break;
      label273:
      paramInt1 += 1;
    }
  }
  
  public aadw getThemeRedPkgConfById(int paramInt)
  {
    if (paramInt == -1) {}
    for (;;)
    {
      return null;
      try
      {
        localObject1 = aagd.getQQAppInterface();
        if (localObject1 != null)
        {
          localObject1 = ((aaai)((QQAppInterface)localObject1).getManager(245)).a("redPackPanel", new String[] { "panelRedPkgList" });
          if (localObject1 != null)
          {
            int j = ((JSONArray)localObject1).length();
            if (j > 0)
            {
              i = 0;
              if (i < j)
              {
                localObject2 = ((JSONArray)localObject1).getJSONObject(i);
                if ((localObject2 == null) || (((JSONObject)localObject2).optInt("type", -1) != 3)) {
                  break label501;
                }
                localJSONObject = ((JSONObject)localObject2).optJSONObject("params");
                if (localJSONObject == null) {
                  break label501;
                }
                k = localJSONObject.optInt("theme_id", -1);
                if (paramInt != k) {
                  break label501;
                }
                localObject2 = new aadw();
              }
            }
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          int i;
          try
          {
            Object localObject2;
            JSONObject localJSONObject;
            int k;
            ((aadw)localObject2).id = k;
            ((aadw)localObject2).name = localJSONObject.optString("name", "");
            ((aadw)localObject2).bcA = localJSONObject.optString("begintime", "");
            ((aadw)localObject2).bcB = localJSONObject.optString("endtime", "");
            ((aadw)localObject2).RH = localJSONObject.optInt("entry", 0);
            ((aadw)localObject2).resource_type = localJSONObject.optInt("resource_type", 0);
            if (!isValidDate(((aadw)localObject2).bcA, ((aadw)localObject2).bcB)) {
              break;
            }
            Object localObject4 = localJSONObject.optString("prefix", "");
            localObject1 = localObject4;
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject1 = "https://i.gtimg.cn/channel/static/socialpay/paneltheme/socialpay_theme_v1_";
            }
            ((aadw)localObject2).bcw = ((String)localObject1 + k);
            ((aadw)localObject2).bgUrl = ((String)localObject1 + k + "_bg");
            ((aadw)localObject2).bcx = localJSONObject.optString("tail_word", "");
            ((aadw)localObject2).bcy = localJSONObject.optString("tail_color", "");
            ((aadw)localObject2).bcz = localJSONObject.optString("tail_url", "");
            localObject1 = localJSONObject.optJSONObject("c2c");
            if (localObject1 != null)
            {
              ((aadw)localObject2).D = ((JSONObject)localObject1).optJSONArray("wish_array");
              ((aadw)localObject2).C = ((JSONObject)localObject1).optJSONArray("money_array");
            }
            localObject4 = localJSONObject.optJSONObject("group");
            localObject1 = localObject2;
            if (localObject4 != null)
            {
              ((aadw)localObject2).E = ((JSONObject)localObject4).optJSONArray("group_wish_array");
              ((aadw)localObject2).F = ((JSONObject)localObject4).optJSONArray("group_money_array");
              ((aadw)localObject2).B = ((JSONObject)localObject4).optJSONArray("group_total_num_array");
              localObject1 = localObject2;
            }
            return localObject1;
          }
          catch (Throwable localThrowable2)
          {
            localObject1 = localThrowable1;
            Object localObject3 = localThrowable2;
            continue;
          }
          localThrowable1 = localThrowable1;
          Object localObject1 = null;
          localThrowable1.printStackTrace();
          continue;
          localObject1 = null;
          continue;
          label501:
          i += 1;
        }
      }
    }
  }
  
  public void getVoiceRateRes(RedPacketInfoBase paramRedPacketInfoBase, IRedPacket.OnGetSkinListener paramOnGetSkinListener)
  {
    if ((paramRedPacketInfoBase == null) || (paramOnGetSkinListener == null)) {}
    for (;;)
    {
      return;
      try
      {
        QQAppInterface localQQAppInterface = aagd.getQQAppInterface();
        if (localQQAppInterface != null)
        {
          CustomizeStrategyFactory.RedPacketInfo localRedPacketInfo = new CustomizeStrategyFactory.RedPacketInfo();
          localRedPacketInfo.type = 6;
          localRedPacketInfo.templateId = paramRedPacketInfoBase.templateId;
          paramRedPacketInfoBase = CustomizeStrategyFactory.a().a(localQQAppInterface, localRedPacketInfo, new aadt(this, paramOnGetSkinListener));
          if (paramRedPacketInfoBase != null)
          {
            paramOnGetSkinListener.onGetSkin(paramRedPacketInfoBase);
            return;
          }
        }
      }
      catch (Throwable paramRedPacketInfoBase)
      {
        paramRedPacketInfoBase.printStackTrace();
      }
    }
  }
  
  public boolean isRiskSwitchOpen()
  {
    try
    {
      QQAppInterface localQQAppInterface = aagd.getQQAppInterface();
      if (localQQAppInterface != null)
      {
        if (((aaai)localQQAppInterface.getManager(245)).a("redPack", 0, new String[] { "riskSwitch" }) != 0) {}
        for (boolean bool = true;; bool = false)
        {
          if (QLog.isColorLevel()) {
            QLog.i("RedPacketManager", 2, "isRiskSwitchOpen = " + bool);
          }
          return bool;
        }
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void onActiveAccount()
  {
    if (this.hS != null) {
      this.hS.clear();
    }
  }
  
  public boolean onGetThemeConfig(int paramInt)
  {
    return getThemeRedPkgConfById(paramInt) != null;
  }
  
  public void onUpdate(int paramInt)
  {
    if (paramInt == 1) {
      synchronized (lock)
      {
        if (this.hQ != null)
        {
          this.hQ.clear();
          this.hQ = null;
        }
        if (this.hP != null)
        {
          this.hP.clear();
          this.hP = null;
        }
        return;
      }
    }
  }
  
  public void registRedPacketSkinListObserver(BusinessObserver paramBusinessObserver)
  {
    if (!this.observers.contains(paramBusinessObserver)) {
      this.observers.add(paramBusinessObserver);
    }
  }
  
  public void reqGroupAvailableList(String paramString, int paramInt, IRedPacket.OnGetAvailableListListener paramOnGetAvailableListListener)
  {
    if ((paramOnGetAvailableListListener == null) || (TextUtils.isEmpty(paramString)) || ((paramInt != 1) && (paramInt != 3000))) {}
    do
    {
      return;
      localObject = aagd.getQQAppInterface();
    } while (localObject == null);
    String str;
    if (paramInt == 1)
    {
      paramInt = 1;
      str = ((QQAppInterface)localObject).getCurrentUin();
      localObject = (TicketManager)((QQAppInterface)localObject).getManager(2);
      if (localObject == null) {
        break label187;
      }
    }
    label187:
    for (Object localObject = ((TicketManager)localObject).getSkey(str);; localObject = "")
    {
      if (this.hS == null) {
        this.hS = new HashMap();
      }
      this.hS.put(paramString + "_" + paramInt, paramOnGetAvailableListListener);
      paramOnGetAvailableListListener = new GetGroupRedPackListReq();
      paramOnGetAvailableListListener.sGroupUin = paramString;
      paramOnGetAvailableListListener.iPlatForm = 1;
      paramOnGetAvailableListListener.sQQVersion = aqgz.bd(BaseApplicationImpl.getApplication());
      paramOnGetAvailableListListener.iGroupType = paramInt;
      paramOnGetAvailableListListener.sUin = str;
      paramOnGetAvailableListListener.sSkey = ((String)localObject);
      zyb.a(paramOnGetAvailableListListener, this.d);
      aaca.beA();
      return;
      paramInt = 2;
      break;
    }
  }
  
  public void requestRedPacketSkinList()
  {
    requestRedPacketSkinList("", "", 0);
  }
  
  public void requestRedPacketSkinList(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      QQAppInterface localQQAppInterface = aagd.getQQAppInterface();
      if (localQQAppInterface != null)
      {
        if (this.observers.isEmpty()) {
          return;
        }
        ThreadManager.post(new RedPacketManager.2(this, localQQAppInterface), 5, null, false);
        zyb.a(new GetSkinListReq(localQQAppInterface.getLongAccountUin(), 0, "3.4.4", "Android", Build.MODEL, paramString2, paramString1, paramInt), new aadq(this, paramString1, localQQAppInterface));
        if (QLog.isColorLevel())
        {
          QLog.d("RedPacketManager", 2, "requestRedPacketSkinList");
          return;
        }
      }
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void setSelectedSkin(int paramInt, BusinessObserver paramBusinessObserver)
  {
    QQAppInterface localQQAppInterface = aagd.getQQAppInterface();
    if ((localQQAppInterface == null) || (paramBusinessObserver == null)) {}
    do
    {
      return;
      zyb.a(new SetSelectedSkinReq(localQQAppInterface.getLongAccountUin(), 0, "3.4.4", "Android", Build.MODEL, paramInt), new aadr(this, paramBusinessObserver));
    } while (!QLog.isColorLevel());
    QLog.d("RedPacketManager", 2, "setSelectedSkin2ServerIfChanged");
  }
  
  public void unregistRedPacketSkinListObserver(BusinessObserver paramBusinessObserver)
  {
    this.observers.remove(paramBusinessObserver);
  }
  
  static class a
  {
    public static final IRedPacket a = new RedPacketManager();
  }
  
  static class b
  {
    public static final IRedPacket a = new aadv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager
 * JD-Core Version:    0.7.0.1
 */