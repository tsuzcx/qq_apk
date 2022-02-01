import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.annotation.DrawableRes;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.11;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.12;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.13;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.14;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.15;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.3;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.7;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.8;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.9;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.MessageRecord;>;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.QQWalletAioBody;
import tencent.im.msg.im_msg_body.QQWalletAioElem;
import tencent.im.oidb.cmd0x438.oidb_0x438.RedBagInfo;
import tencent.im.oidb.cmd0x438.oidb_0x438.ReqInfo;

public class zxj
  implements Manager
{
  private ackg jdField_a_of_type_Ackg;
  private ackh jdField_a_of_type_Ackh = new ackh(this.mHandler);
  private zxh jdField_a_of_type_Zxh;
  private zxj.a jdField_a_of_type_Zxj$a;
  protected Object bX = new Object();
  private final Object bY = new Object();
  private boolean bum;
  private boolean bun;
  private boolean buo;
  private boolean bup;
  public boolean buq = true;
  public boolean bur;
  public boolean bus = true;
  public boolean but = true;
  public boolean buu = true;
  public int cfu = 10;
  private QQAppInterface f;
  private HashMap<String, String> hD;
  private HashMap<String, String> hE;
  public HashMap<String, zxi> hF;
  public HashMap<String, List<String>> hG;
  public HashMap<String, List<String>> hH;
  public HashMap<String, String> hI;
  public HashMap<String, MessageForFoldMsgGrayTips> hJ;
  public HashMap<String, MessageForFoldMsgGrayTips> hK;
  public HashMap<String, String> hL = new HashMap();
  public HashMap<String, String> hM = new HashMap();
  public Map<Integer, List<Pair<String, String>>> is;
  private boolean isConfigLoaded;
  public Context mContext;
  Handler mHandler = new zxk(this, Looper.getMainLooper());
  public String mUin;
  private List<String> uP;
  public List<zxr> uQ;
  public List<zxr> uR;
  
  public zxj(QQAppInterface paramQQAppInterface)
  {
    this.f = paramQQAppInterface;
    this.mContext = this.f.getApplication();
    this.mUin = this.f.getCurrentAccountUin();
    this.jdField_a_of_type_Zxh = new zxh(this);
    this.f.addObserver(this.jdField_a_of_type_Ackh);
    this.jdField_a_of_type_Ackg = ((ackg)this.f.getBusinessHandler(76));
    this.hG = new HashMap();
    this.hH = new HashMap();
    this.is = new HashMap();
    this.hF = new QQHashMap(1008, 0, 100);
    this.hI = new HashMap();
    this.uP = new ArrayList();
    this.uQ = new ArrayList();
    this.uR = new ArrayList();
    this.bum = true;
    this.bun = true;
    this.buo = true;
    csm();
    try
    {
      paramQQAppInterface = new IntentFilter();
      this.jdField_a_of_type_Zxj$a = new zxj.a(null);
      paramQQAppInterface.addAction("grap_idiom_hb_result_action");
      this.mContext.registerReceiver(this.jdField_a_of_type_Zxj$a, paramQQAppInterface);
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("PasswdRedBagManager", 1, "regist RedPacketRefreshReceiver throw an excepion" + paramQQAppInterface);
    }
  }
  
  public static boolean I(QQAppInterface paramQQAppInterface)
  {
    bw(paramQQAppInterface);
    return ((zxj)paramQQAppInterface.getManager(125)).bus;
  }
  
  public static boolean J(QQAppInterface paramQQAppInterface)
  {
    bw(paramQQAppInterface);
    return ((zxj)paramQQAppInterface.getManager(125)).but;
  }
  
  private String a(zxi paramzxi)
  {
    if (paramzxi == null) {
      return "";
    }
    String str = "";
    if (aqmr.isEmpty(paramzxi.bbb)) {
      str = paramzxi.bba;
    }
    while (aqmr.isEmpty(str))
    {
      return "";
      String[] arrayOfString = paramzxi.bbb.trim().split("_");
      if (arrayOfString.length == 2)
      {
        str = arrayOfString[0];
        if (paramzxi.ys() == 2) {
          str = arrayOfString[1];
        }
      }
    }
    return str.trim();
  }
  
  private zxi a(SessionInfo paramSessionInfo, String paramString, Object[] paramArrayOfObject)
  {
    if (aqmr.isEmpty(paramString))
    {
      paramArrayOfObject = null;
      return paramArrayOfObject;
    }
    paramSessionInfo = fH(paramSessionInfo.cZ) + "_" + paramSessionInfo.aTl + "_";
    Object localObject3 = (List)this.hG.get(paramString);
    Object localObject2 = new ArrayList();
    Object localObject1 = this.bX;
    Object localObject5;
    Object localObject4;
    if (localObject3 != null) {
      for (;;)
      {
        try
        {
          if (((List)localObject3).isEmpty()) {
            break;
          }
          localObject3 = ((List)localObject3).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject5 = (String)((Iterator)localObject3).next();
          localObject4 = paramSessionInfo + (String)localObject5;
          if (!this.hI.containsKey(localObject4))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("msgFold", 2, "get redbagid, no find passwd redbag auth key in cache, key: " + (String)localObject4);
            continue;
          }
          localObject5 = (zxi)this.hF.get(localObject5);
        }
        finally {}
        if (localObject5 != null) {
          ((List)localObject2).add(localObject5);
        } else if (QLog.isColorLevel()) {
          QLog.d("msgFold", 2, "get redbagid, no find passwd redbag in cache, key: " + (String)localObject4);
        }
      }
    }
    localObject3 = new ArrayList();
    int j;
    int i;
    if ((iE(paramString)) || (paramString.trim().length() == 4))
    {
      localObject4 = ChnToSpell.v(paramString.trim().substring(0, 1));
      if ((localObject4 != null) && (localObject4.length > 0))
      {
        j = localObject4.length;
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        localObject5 = localObject4[i];
        if (!aqmr.isEmpty((String)localObject5))
        {
          localObject5 = (List)this.hH.get(((String)localObject5).trim());
          if ((localObject5 != null) && (!((List)localObject5).isEmpty())) {
            ((List)localObject3).addAll((Collection)localObject5);
          }
        }
      }
      else
      {
        paramString = paramString.trim();
        i = paramString.length();
        if (i > 1)
        {
          boolean bool1 = this.is.containsKey(Integer.valueOf(i));
          boolean bool2 = this.is.containsKey(Integer.valueOf(0));
          if ((bool1) || (bool2))
          {
            localObject4 = new ArrayList();
            if (bool2)
            {
              localObject5 = (List)this.is.get(Integer.valueOf(0));
              if (localObject5 != null) {
                ((List)localObject4).addAll((Collection)localObject5);
              }
            }
            if (bool1)
            {
              localObject5 = (List)this.is.get(Integer.valueOf(i));
              if (localObject5 != null) {
                ((List)localObject4).addAll((Collection)localObject5);
              }
            }
            if (((List)localObject4).size() > 0)
            {
              localObject5 = new LinkedList();
              localObject4 = ((List)localObject4).iterator();
              while (((Iterator)localObject4).hasNext())
              {
                Pair localPair = (Pair)((Iterator)localObject4).next();
                if ((!TextUtils.isEmpty((CharSequence)localPair.second)) && (paramString.contains((CharSequence)localPair.second))) {
                  ((List)localObject5).add(localPair.first);
                }
              }
              if (((List)localObject5).size() > 0) {
                ((List)localObject3).addAll((Collection)localObject5);
              }
            }
          }
        }
        if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
        {
          paramString = ((List)localObject3).iterator();
          while (paramString.hasNext())
          {
            localObject4 = (String)paramString.next();
            localObject3 = paramSessionInfo + (String)localObject4;
            if (!this.hI.containsKey(localObject3))
            {
              if (QLog.isColorLevel()) {
                QLog.d("msgFold", 2, "get redbagid, no find passwd redbag auth key in cache, key: " + (String)localObject3);
              }
            }
            else
            {
              localObject4 = (zxi)this.hF.get(localObject4);
              if (localObject4 != null) {
                ((List)localObject2).add(localObject4);
              } else if (QLog.isColorLevel()) {
                QLog.d("msgFold", 2, "get redbagid, no find passwd redbag in cache, key: " + (String)localObject3);
              }
            }
          }
        }
        if (!((List)localObject2).isEmpty())
        {
          Collections.sort((List)localObject2, new zxl(this));
          localObject2 = ((List)localObject2).iterator();
          paramString = null;
          while (((Iterator)localObject2).hasNext())
          {
            paramSessionInfo = (zxi)((Iterator)localObject2).next();
            paramArrayOfObject[1] = Long.valueOf(paramSessionInfo.baZ);
            if (4 == paramSessionInfo.type)
            {
              paramArrayOfObject[2] = null;
              paramArrayOfObject[3] = null;
            }
            for (;;)
            {
              if (!paramSessionInfo.isOpen) {
                break label999;
              }
              if ((4 != paramSessionInfo.type) || (paramSessionInfo.isFinish) || (paramSessionInfo.VU()) || (paramString != null)) {
                break;
              }
              paramString = paramSessionInfo;
              break;
              if ((!paramSessionInfo.bul) && (paramSessionInfo.expireTime >= NetConnInfoCenter.getServerTimeMillis() / 1000L))
              {
                paramArrayOfObject[2] = paramSessionInfo.redBagId;
                paramArrayOfObject[3] = paramSessionInfo.redBagIndex;
              }
            }
            label999:
            if (paramSessionInfo.isFinish)
            {
              paramArrayOfObject[0] = Integer.valueOf(2);
            }
            else if ((paramSessionInfo.bul) || (paramSessionInfo.expireTime < NetConnInfoCenter.getServerTimeMillis() / 1000L))
            {
              if (!paramSessionInfo.bul) {
                zN(paramSessionInfo.redBagId);
              }
              paramArrayOfObject[0] = Integer.valueOf(3);
            }
            else
            {
              if (4 != paramSessionInfo.type) {
                paramSessionInfo.isOpen = true;
              }
              paramArrayOfObject[0] = Integer.valueOf(1);
            }
          }
        }
        for (;;)
        {
          paramArrayOfObject = paramSessionInfo;
          if (paramSessionInfo != null) {
            break;
          }
          return paramString;
          paramSessionInfo = null;
          continue;
          paramString = null;
          paramSessionInfo = null;
        }
      }
      i += 1;
    }
  }
  
  private boolean a(String paramString1, String paramString2, zxi paramzxi)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return false;
      paramString1 = paramString1.trim();
    } while ((TextUtils.isEmpty(paramString1)) || (paramString1.length() <= 1) || (!paramString1.contains(paramString2)) || (!paramzxi.hs(paramString1.length())));
    return true;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    bool6 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
    n = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
    bool5 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX;
    bool4 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID;
    int i7 = 0;
    m = 0;
    int i8 = 0;
    i6 = 0;
    int i9 = 0;
    k = 0;
    i5 = 0;
    int i10 = 0;
    i = 0;
    i1 = i9;
    i2 = i10;
    i3 = i8;
    i4 = i7;
    bool1 = bool4;
    bool2 = bool5;
    j = n;
    bool3 = bool6;
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = paramString.split("\\|");
          i1 = i9;
          i2 = i10;
          i3 = i8;
          i4 = i7;
          bool1 = bool4;
          bool2 = bool5;
          j = n;
          bool3 = bool6;
          if (paramString != null)
          {
            i8 = paramString.length;
            i6 = 0;
            i1 = 0;
            k = 0;
            bool1 = bool4;
            m = 0;
            bool3 = bool6;
            j = n;
            bool2 = bool5;
            n = i1;
            if (i6 >= i8) {
              continue;
            }
            arrayOfString1 = paramString[i6];
          }
        }
      }
      catch (Exception paramString)
      {
        String[] arrayOfString1;
        String[] arrayOfString2;
        label246:
        i = i6;
        i1 = k;
        i2 = i5;
        i3 = i;
        i4 = m;
        bool1 = bool4;
        bool2 = bool5;
        j = n;
        bool3 = bool6;
        if (QLog.isColorLevel())
        {
          QLog.e("msgFold", 2, "updatePasswdMsgFodConfig error " + paramString.getMessage());
          bool3 = bool6;
          j = n;
          bool2 = bool5;
          bool1 = bool4;
          i4 = m;
          i3 = i;
          i2 = i5;
          i1 = k;
        }
        if (QLog.isColorLevel()) {
          QLog.d("msgFold", 2, String.format("received RedBagFoldMsgConfig remote version: %d, msgFoldSwitch: %s, msgFoldNum: %s, msgFoldIndexSwitch: %s, msgFoldIndexWithId: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool3), Integer.valueOf(j), Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
        }
        if ((i3 == 0) || (i4 == 0) || (i1 == 0) || (i2 == 0))
        {
          bool1 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT;
          i = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT;
          bool2 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX;
          bool3 = MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID;
          paramString = (zxj)paramQQAppInterface.getManager(125);
          paramString.bur = true;
          paramString.bus = bool1;
          paramString.cfu = i;
          paramString.but = bool2;
          paramString.buu = bool3;
          aqmj.a(paramQQAppInterface.getApp(), paramQQAppInterface.getAccount(), paramInt, bool1, i, bool2, bool3);
          return;
        }
        i1 = k;
        i2 = i;
        i3 = m;
        i4 = n;
        continue;
        if (m != 1) {
          continue;
        }
        bool2 = true;
        j = 1;
        bool4 = bool2;
        continue;
      }
      try
      {
        if (!arrayOfString1.contains("msgfold_switch")) {
          continue;
        }
        arrayOfString2 = arrayOfString1.split("=");
        if ((arrayOfString2 == null) || (arrayOfString2.length != 2)) {
          continue;
        }
        i1 = Integer.valueOf(arrayOfString2[1].trim()).intValue();
        if ((i1 != 1) && (i1 != 0)) {
          continue;
        }
        if (i1 != 1) {
          continue;
        }
        bool3 = true;
        n = 1;
      }
      catch (Exception paramString)
      {
        i5 = i;
        i = m;
        m = n;
        bool4 = bool1;
        bool5 = bool2;
        n = j;
        bool6 = bool3;
        continue;
      }
    }
    i2 = m;
    i1 = j;
    i5 = k;
    i4 = m;
    bool5 = bool2;
    i3 = j;
    for (;;)
    {
      try
      {
        if (arrayOfString1.contains("msgfold_num"))
        {
          i5 = k;
          i4 = m;
          bool5 = bool2;
          i3 = j;
          arrayOfString2 = arrayOfString1.split("=");
          i2 = m;
          i1 = j;
          if (arrayOfString2 != null)
          {
            i2 = m;
            i1 = j;
            i5 = k;
            i4 = m;
            bool5 = bool2;
            i3 = j;
            if (arrayOfString2.length == 2)
            {
              i5 = k;
              i4 = m;
              bool5 = bool2;
              i3 = j;
              i7 = Integer.valueOf(arrayOfString2[1].trim()).intValue();
              i2 = m;
              i1 = j;
              if (i7 >= 0)
              {
                i2 = 1;
                i1 = i7;
              }
            }
          }
        }
        j = k;
        bool4 = bool2;
        i5 = k;
        i4 = i2;
        bool5 = bool2;
        i3 = i1;
        if (arrayOfString1.contains("Index_switch"))
        {
          i5 = k;
          i4 = i2;
          bool5 = bool2;
          i3 = i1;
          arrayOfString2 = arrayOfString1.split("=");
          j = k;
          bool4 = bool2;
          if (arrayOfString2 != null)
          {
            j = k;
            bool4 = bool2;
            i5 = k;
            i4 = i2;
            bool5 = bool2;
            i3 = i1;
            if (arrayOfString2.length == 2)
            {
              i5 = k;
              i4 = i2;
              bool5 = bool2;
              i3 = i1;
              m = Integer.valueOf(arrayOfString2[1].trim()).intValue();
              if (m == 1) {
                break label1103;
              }
              j = k;
              bool4 = bool2;
              if (m == 0) {
                break label1103;
              }
            }
          }
        }
        i5 = j;
        i4 = i2;
        bool5 = bool4;
        i3 = i1;
        if (!arrayOfString1.contains("with_redbagid")) {
          continue;
        }
        i5 = j;
        i4 = i2;
        bool5 = bool4;
        i3 = i1;
        arrayOfString1 = arrayOfString1.split("=");
        if (arrayOfString1 == null) {
          continue;
        }
        i5 = j;
        i4 = i2;
        bool5 = bool4;
        i3 = i1;
        if (arrayOfString1.length != 2) {
          continue;
        }
        i5 = j;
        i4 = i2;
        bool5 = bool4;
        i3 = i1;
        k = Integer.valueOf(arrayOfString1[1].trim()).intValue();
        if ((k != 1) && (k != 0)) {
          continue;
        }
        if (k != 1) {
          continue;
        }
        bool1 = true;
        i = 1;
      }
      catch (Exception paramString)
      {
        k = i5;
        m = n;
        i5 = i;
        i = i4;
        bool4 = bool1;
        n = i3;
        bool6 = bool3;
        continue;
        bool4 = bool3;
        bool3 = bool1;
        i = j;
        bool1 = bool4;
        continue;
        continue;
      }
      i6 += 1;
      k = j;
      m = i2;
      bool2 = bool4;
      j = i1;
      break;
      bool3 = false;
      break label246;
      bool2 = false;
      break label1112;
      bool1 = false;
    }
  }
  
  private void b(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return;
      BX(false);
      if ((paramBoolean) && ((paramInt == 1) || (paramInt == 3000))) {
        aaca.K(paramString2, paramInt, paramString1);
      }
      paramString2 = (zxi)this.hF.get(paramString1);
    } while ((paramString2 == null) || (paramString2.isOpen == paramBoolean));
    paramString2.isOpen = paramBoolean;
    ThreadManager.getFileThreadHandler().post(new PasswdRedBagManager.15(this, paramString1, paramBoolean));
  }
  
  /* Error */
  private void b(zxi paramzxi)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: aload_1
    //   7: getfield 423	zxi:redBagId	Ljava/lang/String;
    //   10: astore 7
    //   12: aload_1
    //   13: getfield 248	zxi:bba	Ljava/lang/String;
    //   16: astore 8
    //   18: aload_0
    //   19: getfield 157	zxj:hF	Ljava/util/HashMap;
    //   22: aload 7
    //   24: aload_1
    //   25: invokevirtual 539	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   28: pop
    //   29: aload_1
    //   30: getfield 397	zxi:type	I
    //   33: ifne +161 -> 194
    //   36: aload_0
    //   37: getfield 146	zxj:hG	Ljava/util/HashMap;
    //   40: aload 8
    //   42: invokevirtual 287	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast 289	java/util/List
    //   48: astore 6
    //   50: aload 6
    //   52: ifnonnull +585 -> 637
    //   55: new 358	java/util/LinkedList
    //   58: dup
    //   59: invokespecial 359	java/util/LinkedList:<init>	()V
    //   62: astore 6
    //   64: aload_0
    //   65: getfield 146	zxj:hG	Ljava/util/HashMap;
    //   68: aload 8
    //   70: aload 6
    //   72: invokevirtual 539	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   75: pop
    //   76: aload_0
    //   77: getfield 72	zxj:bX	Ljava/lang/Object;
    //   80: astore 8
    //   82: aload 8
    //   84: monitorenter
    //   85: aload 6
    //   87: invokeinterface 356 1 0
    //   92: istore 5
    //   94: iconst_0
    //   95: istore_2
    //   96: iload 4
    //   98: istore_3
    //   99: iload_2
    //   100: iload 5
    //   102: if_icmpge +58 -> 160
    //   105: aload 6
    //   107: iload_2
    //   108: invokeinterface 542 2 0
    //   113: checkcast 250	java/lang/String
    //   116: astore 9
    //   118: aload 9
    //   120: invokestatic 371	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   123: ifne +518 -> 641
    //   126: aload_0
    //   127: getfield 157	zxj:hF	Ljava/util/HashMap;
    //   130: aload 9
    //   132: invokevirtual 287	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: checkcast 236	zxi
    //   138: astore 9
    //   140: aload 9
    //   142: ifnull +499 -> 641
    //   145: aload 9
    //   147: getfield 412	zxi:expireTime	J
    //   150: aload_1
    //   151: getfield 412	zxi:expireTime	J
    //   154: lcmp
    //   155: ifge +486 -> 641
    //   158: iload_2
    //   159: istore_3
    //   160: aload 6
    //   162: iload_3
    //   163: aload 7
    //   165: invokeinterface 545 3 0
    //   170: aload 8
    //   172: monitorexit
    //   173: return
    //   174: astore_1
    //   175: invokestatic 548	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   178: ifeq -8 -> 170
    //   181: aload_1
    //   182: invokevirtual 551	java/lang/Throwable:printStackTrace	()V
    //   185: goto -15 -> 170
    //   188: astore_1
    //   189: aload 8
    //   191: monitorexit
    //   192: aload_1
    //   193: athrow
    //   194: aload_1
    //   195: getfield 397	zxi:type	I
    //   198: iconst_4
    //   199: if_icmpne +441 -> 640
    //   202: aload_1
    //   203: invokevirtual 263	zxi:ys	()I
    //   206: ifeq +11 -> 217
    //   209: aload_1
    //   210: invokevirtual 263	zxi:ys	()I
    //   213: iconst_1
    //   214: if_icmpne +178 -> 392
    //   217: aload_0
    //   218: aload_1
    //   219: getfield 239	zxi:bbb	Ljava/lang/String;
    //   222: invokevirtual 555	zxj:hV	(Ljava/lang/String;)Ljava/lang/String;
    //   225: astore 8
    //   227: aload_0
    //   228: getfield 148	zxj:hH	Ljava/util/HashMap;
    //   231: aload 8
    //   233: invokevirtual 287	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   236: checkcast 289	java/util/List
    //   239: astore 6
    //   241: aload 6
    //   243: ifnonnull +391 -> 634
    //   246: new 358	java/util/LinkedList
    //   249: dup
    //   250: invokespecial 359	java/util/LinkedList:<init>	()V
    //   253: astore 6
    //   255: aload_0
    //   256: getfield 148	zxj:hH	Ljava/util/HashMap;
    //   259: aload 8
    //   261: aload 6
    //   263: invokevirtual 539	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   266: pop
    //   267: aload_0
    //   268: getfield 72	zxj:bX	Ljava/lang/Object;
    //   271: astore 8
    //   273: aload 8
    //   275: monitorenter
    //   276: aload 6
    //   278: invokeinterface 356 1 0
    //   283: istore 4
    //   285: iconst_0
    //   286: istore_2
    //   287: iload 5
    //   289: istore_3
    //   290: iload_2
    //   291: iload 4
    //   293: if_icmpge +58 -> 351
    //   296: aload 6
    //   298: iload_2
    //   299: invokeinterface 542 2 0
    //   304: checkcast 250	java/lang/String
    //   307: astore 9
    //   309: aload 9
    //   311: invokestatic 371	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   314: ifne +57 -> 371
    //   317: aload_0
    //   318: getfield 157	zxj:hF	Ljava/util/HashMap;
    //   321: aload 9
    //   323: invokevirtual 287	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   326: checkcast 236	zxi
    //   329: astore 9
    //   331: aload 9
    //   333: ifnull +38 -> 371
    //   336: aload 9
    //   338: getfield 412	zxi:expireTime	J
    //   341: aload_1
    //   342: getfield 412	zxi:expireTime	J
    //   345: lcmp
    //   346: ifge +25 -> 371
    //   349: iload_2
    //   350: istore_3
    //   351: aload 6
    //   353: iload_3
    //   354: aload 7
    //   356: invokeinterface 545 3 0
    //   361: aload 8
    //   363: monitorexit
    //   364: return
    //   365: astore_1
    //   366: aload 8
    //   368: monitorexit
    //   369: aload_1
    //   370: athrow
    //   371: iload_2
    //   372: iconst_1
    //   373: iadd
    //   374: istore_2
    //   375: goto -88 -> 287
    //   378: astore_1
    //   379: invokestatic 548	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   382: ifeq -21 -> 361
    //   385: aload_1
    //   386: invokevirtual 551	java/lang/Throwable:printStackTrace	()V
    //   389: goto -28 -> 361
    //   392: aload_1
    //   393: invokevirtual 263	zxi:ys	()I
    //   396: iconst_2
    //   397: if_icmpne +243 -> 640
    //   400: aload_1
    //   401: invokevirtual 559	zxi:dt	()Ljava/util/List;
    //   404: invokeinterface 296 1 0
    //   409: astore 8
    //   411: aload 8
    //   413: invokeinterface 301 1 0
    //   418: ifeq +222 -> 640
    //   421: aload 8
    //   423: invokeinterface 305 1 0
    //   428: checkcast 345	java/lang/Integer
    //   431: invokevirtual 473	java/lang/Integer:intValue	()I
    //   434: istore_2
    //   435: aload_0
    //   436: getfield 150	zxj:is	Ljava/util/Map;
    //   439: iload_2
    //   440: invokestatic 349	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   443: invokeinterface 353 2 0
    //   448: checkcast 289	java/util/List
    //   451: astore 6
    //   453: aload 6
    //   455: ifnonnull +176 -> 631
    //   458: new 358	java/util/LinkedList
    //   461: dup
    //   462: invokespecial 359	java/util/LinkedList:<init>	()V
    //   465: astore 6
    //   467: aload_0
    //   468: getfield 150	zxj:is	Ljava/util/Map;
    //   471: iload_2
    //   472: invokestatic 349	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   475: aload 6
    //   477: invokeinterface 560 3 0
    //   482: pop
    //   483: aload_0
    //   484: getfield 72	zxj:bX	Ljava/lang/Object;
    //   487: astore 9
    //   489: aload 9
    //   491: monitorenter
    //   492: aload 6
    //   494: invokeinterface 356 1 0
    //   499: istore_3
    //   500: iconst_0
    //   501: istore_2
    //   502: iload_2
    //   503: iload_3
    //   504: if_icmpge +122 -> 626
    //   507: aload 6
    //   509: iload_2
    //   510: invokeinterface 542 2 0
    //   515: checkcast 361	android/util/Pair
    //   518: getfield 377	android/util/Pair:first	Ljava/lang/Object;
    //   521: checkcast 250	java/lang/String
    //   524: astore 10
    //   526: aload 10
    //   528: invokestatic 371	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   531: ifne +72 -> 603
    //   534: aload_0
    //   535: getfield 157	zxj:hF	Ljava/util/HashMap;
    //   538: aload 10
    //   540: invokevirtual 287	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   543: checkcast 236	zxi
    //   546: astore 10
    //   548: aload 10
    //   550: ifnull +53 -> 603
    //   553: aload 10
    //   555: getfield 412	zxi:expireTime	J
    //   558: aload_1
    //   559: getfield 412	zxi:expireTime	J
    //   562: lcmp
    //   563: ifge +40 -> 603
    //   566: aload 6
    //   568: iload_2
    //   569: new 361	android/util/Pair
    //   572: dup
    //   573: aload 7
    //   575: aload_0
    //   576: aload_1
    //   577: getfield 239	zxi:bbb	Ljava/lang/String;
    //   580: invokevirtual 555	zxj:hV	(Ljava/lang/String;)Ljava/lang/String;
    //   583: invokespecial 563	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   586: invokeinterface 545 3 0
    //   591: aload 9
    //   593: monitorexit
    //   594: goto -183 -> 411
    //   597: astore_1
    //   598: aload 9
    //   600: monitorexit
    //   601: aload_1
    //   602: athrow
    //   603: iload_2
    //   604: iconst_1
    //   605: iadd
    //   606: istore_2
    //   607: goto -105 -> 502
    //   610: astore 6
    //   612: invokestatic 548	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   615: ifeq -24 -> 591
    //   618: aload 6
    //   620: invokevirtual 551	java/lang/Throwable:printStackTrace	()V
    //   623: goto -32 -> 591
    //   626: iconst_0
    //   627: istore_2
    //   628: goto -62 -> 566
    //   631: goto -148 -> 483
    //   634: goto -367 -> 267
    //   637: goto -561 -> 76
    //   640: return
    //   641: iload_2
    //   642: iconst_1
    //   643: iadd
    //   644: istore_2
    //   645: goto -549 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	648	0	this	zxj
    //   0	648	1	paramzxi	zxi
    //   95	550	2	i	int
    //   98	407	3	j	int
    //   4	290	4	k	int
    //   1	287	5	m	int
    //   48	519	6	localObject1	Object
    //   610	9	6	localThrowable	Throwable
    //   10	564	7	str	String
    //   16	406	8	localObject2	Object
    //   524	30	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   85	94	174	java/lang/Throwable
    //   105	140	174	java/lang/Throwable
    //   145	158	174	java/lang/Throwable
    //   160	170	174	java/lang/Throwable
    //   85	94	188	finally
    //   105	140	188	finally
    //   145	158	188	finally
    //   160	170	188	finally
    //   170	173	188	finally
    //   175	185	188	finally
    //   189	192	188	finally
    //   276	285	365	finally
    //   296	331	365	finally
    //   336	349	365	finally
    //   351	361	365	finally
    //   361	364	365	finally
    //   366	369	365	finally
    //   379	389	365	finally
    //   276	285	378	java/lang/Throwable
    //   296	331	378	java/lang/Throwable
    //   336	349	378	java/lang/Throwable
    //   351	361	378	java/lang/Throwable
    //   492	500	597	finally
    //   507	548	597	finally
    //   553	566	597	finally
    //   566	591	597	finally
    //   591	594	597	finally
    //   598	601	597	finally
    //   612	623	597	finally
    //   492	500	610	java/lang/Throwable
    //   507	548	610	java/lang/Throwable
    //   553	566	610	java/lang/Throwable
    //   566	591	610	java/lang/Throwable
  }
  
  public static void bw(QQAppInterface paramQQAppInterface)
  {
    zxj localzxj = (zxj)paramQQAppInterface.getManager(125);
    if (!localzxj.bur)
    {
      String str = paramQQAppInterface.getAccount();
      paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      if (paramQQAppInterface.contains(str + "_" + "redbag_fold_msg_config_version"))
      {
        localzxj.bus = paramQQAppInterface.getBoolean(str + "_" + "redbag_fold_msg_switch", MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_DEFAULT);
        localzxj.cfu = paramQQAppInterface.getInt(str + "_" + "redbag_fold_msg_num", MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_DISPLAY_NUM_DEFAULT);
        localzxj.but = paramQQAppInterface.getBoolean(str + "_" + "redbag_fold_index_switch", MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_SWITCH_INDEX);
        localzxj.buu = paramQQAppInterface.getBoolean(str + "_" + "redbag_fold_index_with_redbagid", MessageForFoldMsgGrayTips.PASSWD_REDBAG_MSG_INDEX_WITH_ID);
      }
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, String.format("getFoldSwitch, first init, switch: %s, num: %d, indexSwitch: %s, indexWithId: %s ", new Object[] { Boolean.valueOf(localzxj.bus), Integer.valueOf(localzxj.cfu), Boolean.valueOf(localzxj.but), Boolean.valueOf(localzxj.buu) }));
      }
    }
    localzxj.bur = true;
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    return (paramInt == 1) && (!((HotChatManager)paramQQAppInterface.getManager(60)).kj(paramString));
  }
  
  private boolean iE(String paramString)
  {
    boolean bool = true;
    if ((!aqmr.isEmpty(paramString)) && (paramString.trim().length() > 1) && (paramString.trim().matches("[a-zA-Z]+"))) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PasswdRedBagManager", 2, "isEnglishWords: " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public void BX(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (VV()) {
          cso();
        }
        if (!paramBoolean) {
          break label158;
        }
        boolean bool = this.bum;
        if (!bool) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("msgFold", 2, "loadRedBagInfoToCache sync=" + paramBoolean + ",isNeedSyncLoadRedBagInfo=" + this.bum + ",isNeedLoadRedBagInfo=" + this.bun);
        }
        Iterator localIterator = this.jdField_a_of_type_Zxh.ds().iterator();
        if (localIterator.hasNext())
        {
          zxi localzxi = (zxi)localIterator.next();
          b(localzxi);
          r(false, localzxi.redBagId, localzxi.redBagIndex);
          continue;
        }
        this.bum = false;
      }
      finally {}
      continue;
      label158:
      if ((this.bun) && (this.bum))
      {
        if (QLog.isColorLevel()) {
          QLog.d("msgFold", 2, "loadRedBagInfoToCache sync=" + paramBoolean + ",isNeedSyncLoadRedBagInfo=" + this.bum + ",isNeedLoadRedBagInfo=" + this.bun);
        }
        ThreadManager.post(new PasswdRedBagManager.9(this), 8, null, false);
        this.bun = false;
      }
    }
  }
  
  public boolean VV()
  {
    return !this.f.getCurrentAccountUin().equals(this.mUin);
  }
  
  public MessageRecord a(List<MessageRecord> paramList, MessageForFoldMsg paramMessageForFoldMsg, LinkedHashSet<String> arg3, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((QLog.isColorLevel()) && (aqmq.aFf()) && (paramList.size() > 0))
    {
      localObject1 = new StringBuilder(paramList.size() * 48 + 64);
      ((StringBuilder)localObject1).append("getFoldGrayTipsFormAIOList before insert,aioList size=").append(paramList.size()).append(":");
      if (paramBoolean2)
      {
        localObject2 = this.f.a(0).a().a(paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop);
        ((Lock)localObject2).lock();
        try
        {
          localObject3 = paramList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
            ((StringBuilder)localObject1).append("(").append(localMessageRecord.time).append(",").append(localMessageRecord.shmsgseq).append(",").append(localMessageRecord.msgtype).append(") ");
          }
        }
        finally
        {
          ((Lock)localObject2).unlock();
        }
        QLog.d("msgFold", 2, ((StringBuilder)localObject1).toString());
      }
    }
    else
    {
      if (this.hJ == null) {
        this.hJ = new HashMap();
      }
      if (this.hK == null) {
        this.hK = new HashMap();
      }
      localObject1 = paramMessageForFoldMsg.frienduin + paramMessageForFoldMsg.istroop + paramMessageForFoldMsg.redBagId;
      localObject2 = paramMessageForFoldMsg.frienduin + paramMessageForFoldMsg.istroop + paramMessageForFoldMsg.redBagIndex;
      if ((!paramBoolean1) || (!this.hK.containsKey(localObject2))) {
        break label588;
      }
      localObject3 = (MessageForFoldMsgGrayTips)this.hK.get(localObject2);
      ((MessageForFoldMsgGrayTips)localObject3).update(this.f, paramMessageForFoldMsg.frienduin, ???, paramInt, paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex);
      if (this.hJ.containsKey(localObject1)) {
        a(paramList, (String)localObject2, (String)localObject1, paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop, paramBoolean2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, String.format("update foldmsg graytips, index mode, uin: %s, type: %d, redBagId: %s, index: %s, num: %d", new Object[] { ((MessageForFoldMsgGrayTips)localObject3).frienduin, Integer.valueOf(((MessageForFoldMsgGrayTips)localObject3).istroop), paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex, Integer.valueOf(((MessageForFoldMsgGrayTips)localObject3).foldMsgCount) }));
      }
      paramList = null;
    }
    label1198:
    label1215:
    for (;;)
    {
      anot.a(this.f, "CliOper", "", "", "0X80064BC", "0X80064BC", 0, 0, "", "", "", "");
      return paramList;
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MessageRecord)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append("(").append(((MessageRecord)localObject3).time).append(",").append(((MessageRecord)localObject3).shmsgseq).append(",").append(((MessageRecord)localObject3).msgtype).append(") ");
      }
      break;
      label588:
      if ((paramBoolean1) && (this.hJ.containsKey(localObject1)))
      {
        paramList = (MessageForFoldMsgGrayTips)this.hJ.get(localObject1);
        paramList.update(this.f, paramMessageForFoldMsg.frienduin, ???, paramInt, paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex);
        if (!TextUtils.isEmpty(paramMessageForFoldMsg.redBagIndex))
        {
          this.hJ.remove(localObject1);
          this.hK.put(localObject2, paramList);
        }
        if (QLog.isColorLevel()) {
          QLog.d("msgFold", 2, String.format("update foldmsg graytips, id mode, uin: %s, type: %d, redBagId: %s, index: %s,  num: %d", new Object[] { paramList.frienduin, Integer.valueOf(paramList.istroop), paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex, Integer.valueOf(paramList.foldMsgCount) }));
        }
        paramList = null;
      }
      else
      {
        localObject1 = (MessageForFoldMsgGrayTips)anbi.d(-5011);
        anbi.a(this.f, (MessageRecord)localObject1, paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop);
        ((MessageForFoldMsgGrayTips)localObject1).shmsgseq = paramMessageForFoldMsg.shmsgseq;
        ((MessageForFoldMsgGrayTips)localObject1).time = paramMessageForFoldMsg.time;
        ((MessageForFoldMsgGrayTips)localObject1).foldMsgCount = paramInt;
        ((MessageForFoldMsgGrayTips)localObject1).init(this.f, paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.mPasswdRedBagSender, ???, paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex);
        for (;;)
        {
          synchronized (this.bY)
          {
            if (d(paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop, paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex)) {
              break;
            }
            if (paramBoolean2)
            {
              localObject2 = this.f.a(0).a().a(paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop);
              ((Lock)localObject2).lock();
              try
              {
                top.c(paramList, (MessageRecord)localObject1, true);
                ((Lock)localObject2).unlock();
                a(paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop, paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex, (MessageForFoldMsgGrayTips)localObject1);
                if ((!QLog.isColorLevel()) || (!aqmq.aFf()) || (paramList == null) || (paramList.size() <= 0)) {
                  break label1215;
                }
                ??? = new StringBuilder(paramList.size() * 48 + 64);
                ???.append("getFoldGrayTipsFormAIOList after insert,isNeedMsgListLock=").append(paramBoolean2);
                ???.append(",aioList size=").append(paramList.size()).append(":");
                paramMessageForFoldMsg = this.f.a(0).a().a(paramMessageForFoldMsg.frienduin, paramMessageForFoldMsg.istroop);
                paramMessageForFoldMsg.lock();
                try
                {
                  paramList = paramList.iterator();
                  if (!paramList.hasNext()) {
                    break label1198;
                  }
                  localObject2 = (MessageRecord)paramList.next();
                  ???.append("(").append(((MessageRecord)localObject2).time).append(",").append(((MessageRecord)localObject2).shmsgseq).append(",").append(((MessageRecord)localObject2).msgtype).append(") ");
                  continue;
                  paramList = finally;
                }
                finally
                {
                  paramMessageForFoldMsg.unlock();
                }
                paramList = finally;
              }
              finally {}
            }
          }
          top.c(paramList, (MessageRecord)localObject1, true);
        }
        QLog.i("msgFold", 1, "filter repeat msg:" + paramMessageForFoldMsg.redBagId + "_" + paramMessageForFoldMsg.redBagIndex);
        return null;
        paramMessageForFoldMsg.unlock();
        QLog.d("msgFold", 2, ???.toString());
        paramList = (List<MessageRecord>)localObject1;
      }
    }
  }
  
  public Boolean a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    int i = 0;
    if (this.cfu == 0) {
      return Boolean.valueOf(true);
    }
    Object localObject = this.f.b().k(paramString1, paramInt);
    if (localObject == null) {
      return Boolean.valueOf(false);
    }
    List localList = this.f.b().f(paramString1, paramInt);
    paramString1 = (String)localObject;
    if (localList != null)
    {
      paramString1 = (String)localObject;
      if (((List)localObject).size() < localList.size()) {
        paramString1 = localList;
      }
    }
    int j = paramString1.size() - 1;
    while (j > 0)
    {
      localObject = (MessageRecord)paramString1.get(j);
      paramInt = i;
      if ((localObject instanceof MessageForFoldMsg))
      {
        localObject = (MessageForFoldMsg)localObject;
        if ((TextUtils.isEmpty(paramString2)) || (!paramString2.equals(((MessageForFoldMsg)localObject).redBagId)))
        {
          paramInt = i;
          if (!TextUtils.isEmpty(paramString3))
          {
            paramInt = i;
            if (!paramString3.equals(((MessageForFoldMsg)localObject).redBagIndex)) {}
          }
        }
        else
        {
          i += 1;
          if (!((MessageForFoldMsg)localObject).foldFlag)
          {
            paramInt = i;
            if (i < this.cfu) {}
          }
          else
          {
            return Boolean.valueOf(true);
          }
        }
      }
      j -= 1;
      i = paramInt;
    }
    return Boolean.valueOf(false);
  }
  
  public zxi a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    BX(false);
    return (zxi)this.hF.get(paramString);
  }
  
  public void a(SessionInfo paramSessionInfo, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      aagm.a().a(new zxm(this, paramArrayList, paramSessionInfo));
    }
  }
  
  public void a(SessionInfo paramSessionInfo, zxi paramzxi, long paramLong, int paramInt)
  {
    a(paramSessionInfo, paramzxi, paramLong, 32, "", 0, paramInt, null);
  }
  
  public void a(SessionInfo paramSessionInfo, zxi paramzxi, long paramLong, int paramInt, Bundle paramBundle)
  {
    a(paramSessionInfo, paramzxi, paramLong, 524288, "", 0, paramInt, paramBundle);
  }
  
  public void a(SessionInfo paramSessionInfo, zxi paramzxi, long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    if ((paramSessionInfo == null) || (paramzxi == null)) {}
    String str2;
    do
    {
      return;
      csn();
      str2 = (String)this.hI.get(fH(paramSessionInfo.cZ) + "_" + paramSessionInfo.aTl + "_" + paramzxi.redBagId);
    } while (TextUtils.isEmpty(str2));
    int i;
    Object localObject;
    if ((paramSessionInfo.cZ == 0) || (paramSessionInfo.cZ == 2) || (paramSessionInfo.cZ == 1004) || (paramSessionInfo.cZ == 1001) || (paramSessionInfo.cZ == 10002))
    {
      i = 1;
      str1 = paramSessionInfo.aTl;
      localObject = String.valueOf(paramzxi.baZ);
      if (i != 0) {
        if (!((String)localObject).equals(this.mUin)) {
          break label412;
        }
      }
    }
    label412:
    for (String str1 = paramSessionInfo.aTl;; str1 = this.mUin)
    {
      localObject = aagc.a(this.f, paramSessionInfo);
      i = ((Bundle)localObject).getInt("groupType");
      localObject = ((Bundle)localObject).getString("name");
      paramzxi = paramzxi.redBagId;
      paramSessionInfo = aagc.a(this.f, paramSessionInfo, i, (String)localObject, paramzxi, str2, str1, "appid#1344242394|bargainor_id#1000030201|channel#msg", "graphb", null, paramInt1, 0, paramString, paramInt2, paramInt3, paramBundle);
      paramString = new Bundle();
      paramString.putString("json", paramSessionInfo.toString());
      paramString.putString("callbackSn", "0");
      paramSessionInfo = paramzxi;
      if (paramzxi != null)
      {
        paramSessionInfo = paramzxi;
        if (paramzxi.length() > 4) {
          paramSessionInfo = "****" + paramzxi.substring(4);
        }
      }
      VACDReportUtil.b(paramLong, null, "open", "groupType=" + i + "&msgType=6&redId=" + paramSessionInfo, 0, null);
      paramString.putLong("vacreport_key_seq", paramLong);
      paramSessionInfo = new Intent(this.mContext, PayBridgeActivity.class);
      paramSessionInfo.putExtras(paramString);
      paramSessionInfo.addFlags(268435456);
      paramSessionInfo.putExtra("pay_requestcode", 5);
      this.mContext.startActivity(paramSessionInfo);
      return;
      i = 0;
      break;
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, MessageForFoldMsgGrayTips paramMessageForFoldMsgGrayTips)
  {
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString2 = paramString1 + paramInt + paramString3;
      if ((this.hK != null) && (!this.hK.containsKey(paramString2)))
      {
        this.hK.put(paramString2, paramMessageForFoldMsgGrayTips);
        if (QLog.isColorLevel()) {
          QLog.d("msgFold", 2, String.format("new foldmsg graytips, uin: %s, type: %d, redBagIndex: %s num: %d", new Object[] { paramString1, Integer.valueOf(paramInt), paramString3, Integer.valueOf(paramMessageForFoldMsgGrayTips.foldMsgCount) }));
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
        } while (TextUtils.isEmpty(paramString2));
        paramString3 = paramString1 + paramInt + paramString2;
      } while ((this.hJ == null) || (this.hJ.containsKey(paramString3)));
      this.hJ.put(paramString3, paramMessageForFoldMsgGrayTips);
    } while (!QLog.isColorLevel());
    QLog.d("msgFold", 2, String.format("new foldmsg graytips, uin: %s, type: %d, redBagId: %s num: %d", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Integer.valueOf(paramMessageForFoldMsgGrayTips.foldMsgCount) }));
  }
  
  public void a(String paramString, SessionInfo paramSessionInfo, zxi paramzxi, long paramLong, int paramInt)
  {
    long l1 = zyn.getLong(this.f.getCurrentAccountUin(), "idiom_match_in_phone", 0L);
    long l2 = NetConnInfoCenter.getServerTime();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (l1 != 0L)
    {
      bool1 = bool2;
      if (l1 > l2) {
        bool1 = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PasswdRedBagManager", 2, "openSolitaireRedBagByIdiom|isServerAvailable: " + bool1);
    }
    if (bool1) {
      aagm.a().a(new zxo(this, paramzxi, paramString, paramSessionInfo, paramLong, paramInt));
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    if ((aqmr.isEmpty(paramString2)) || (aqmr.isEmpty(paramString1)) || (aqmr.isEmpty(paramString3)) || (aqmr.isEmpty(paramString4))) {
      return;
    }
    m(paramString1, paramString3, paramString4, paramInt2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    a(paramString1, paramString2, paramString3, paramString4, paramLong, paramString5, paramString6, paramString7, paramBoolean1, paramBoolean2, paramInt, "", "");
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString8, String paramString9)
  {
    if ((zxi)this.hF.get(paramString1) == null)
    {
      paramString2 = new zxi(paramString1, paramString2, paramString4, paramLong, new aofk(paramString3, 5, 16).toString(), paramBoolean1, paramBoolean2, false, paramInt, paramString8, paramString9);
      b(paramString2);
      r(true, paramString2.redBagId, paramString2.redBagIndex);
      ThreadManager.getFileThreadHandler().post(new PasswdRedBagManager.11(this, paramString2));
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString5);
    paramString2.append("_");
    paramString2.append(paramString6);
    paramString2.append("_");
    paramString2.append(paramString1);
    if (TextUtils.isEmpty((String)this.hI.get(paramString2.toString())))
    {
      this.hI.put(paramString2.toString(), paramString7);
      ThreadManager.getFileThreadHandler().post(new PasswdRedBagManager.12(this, paramString5, paramString6, paramString1, paramString7));
    }
  }
  
  public void a(List<MessageRecord> paramList, MessageForFoldMsg paramMessageForFoldMsg)
  {
    if ((paramMessageForFoldMsg.isSend()) && (!paramMessageForFoldMsg.foldFlag) && (paramMessageForFoldMsg.msgtype == -2006)) {
      return;
    }
    if ((!TextUtils.isEmpty(paramMessageForFoldMsg.redBagIndex)) && (!TextUtils.isEmpty(paramMessageForFoldMsg.redBagId))) {
      r(true, paramMessageForFoldMsg.redBagId, paramMessageForFoldMsg.redBagIndex);
    }
    if ((TextUtils.isEmpty(paramMessageForFoldMsg.redBagIndex)) && (!TextUtils.isEmpty(paramMessageForFoldMsg.redBagId)) && (this.hL.containsKey(paramMessageForFoldMsg.redBagId))) {
      paramMessageForFoldMsg.redBagIndex = ((String)this.hL.get(paramMessageForFoldMsg.redBagId));
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    localLinkedHashSet.add(paramMessageForFoldMsg.senderuin);
    a(paramList, paramMessageForFoldMsg, localLinkedHashSet, 1, true, false);
  }
  
  public void a(List<MessageRecord> paramList, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    MessageForFoldMsgGrayTips localMessageForFoldMsgGrayTips = (MessageForFoldMsgGrayTips)this.hK.get(paramString1);
    paramString2 = (MessageForFoldMsgGrayTips)this.hJ.get(paramString2);
    this.hJ.remove(paramString1);
    localMessageForFoldMsgGrayTips.update(this.f, paramString2.frienduin, paramString2.foldUinList, paramString2.foldMsgCount, paramString2.redBagId, paramString2.redBagIndex);
    if (paramBoolean)
    {
      paramString1 = this.f.a(0).a().a(paramString3, paramInt);
      paramString1.lock();
    }
    for (;;)
    {
      try
      {
        paramList.remove(paramString2);
        paramString1.unlock();
        if (QLog.isColorLevel()) {
          QLog.d("msgFold", 2, new Object[] { "update foldmsg graytips, index mode merge,", ",mst.time=", Long.valueOf(paramString2.time), ".msg.shmsgseq=", Long.valueOf(paramString2.shmsgseq), ",msg.type=", Integer.valueOf(paramString2.msgtype), ",isNeedMsgListLock=", Boolean.valueOf(paramBoolean) });
        }
        return;
      }
      finally
      {
        paramString1.unlock();
      }
      paramList.remove(paramString2);
    }
  }
  
  public void a(BusinessObserver paramBusinessObserver, int paramInt1, int paramInt2)
  {
    aagm.a().a(new zxq(this, paramInt2, paramInt1, paramBusinessObserver));
  }
  
  public void a(im_msg_body.QQWalletAioBody paramQQWalletAioBody, int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2, String paramString1, String paramString2)
  {
    a(paramQQWalletAioBody.bytes_billno.get().toStringUtf8(), paramQQWalletAioBody.string_index.get().toStringUtf8(), paramQQWalletAioBody.receiver.bytes_title.get().toStringUtf8(), String.valueOf(paramLong2), paramLong3 + 90000L, String.valueOf(paramInt1), String.valueOf(paramLong1), paramQQWalletAioBody.bytes_authkey.get().toStringUtf8(), false, false, paramInt2, paramString1, paramString2);
  }
  
  public void a(oidb_0x438.RedBagInfo paramRedBagInfo)
  {
    a(paramRedBagInfo.string_redbag_id.get().toStringUtf8(), paramRedBagInfo.string_index.get().toStringUtf8(), paramRedBagInfo.string_password.get().toStringUtf8(), String.valueOf(paramRedBagInfo.uint64_creator_uin.get()), paramRedBagInfo.uint64_expire_time.get(), String.valueOf(paramRedBagInfo.uint32_source.get()), String.valueOf(paramRedBagInfo.uint64_code.get()), paramRedBagInfo.string_authkey.get().toStringUtf8(), false, false, 0);
  }
  
  public void a(zxi paramzxi, String paramString)
  {
    if (paramzxi != null) {}
    synchronized (this.bX)
    {
      List localList = (List)this.hH.get(paramString);
      if ((localList != null) && (!localList.isEmpty()))
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext()) {
          if (((String)localIterator.next()).equals(paramzxi.redBagId)) {
            localIterator.remove();
          }
        }
      }
      if (((localList == null) || (localList.isEmpty())) && (this.hH.containsKey(paramString))) {
        this.hH.remove(paramString);
      }
      b(paramzxi);
      return;
    }
  }
  
  public boolean a(String paramString, zxi paramzxi)
  {
    if ((aqmr.isEmpty(paramString)) || (paramzxi == null)) {}
    String str;
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return false;
            str = hV(paramzxi.bbb);
            if (paramzxi.ys() != 0) {
              break;
            }
            if (paramString.trim().length() >= 4)
            {
              paramString = ChnToSpell.v(paramString.trim().substring(0, 1));
              if ((paramString != null) && (paramString.length != 0))
              {
                int j = paramString.length;
                int i = 0;
                while (i < j)
                {
                  paramzxi = paramString[i];
                  if ((!aqmr.isEmpty(str)) && (paramzxi.equals(str.trim()))) {
                    return true;
                  }
                  i += 1;
                }
              }
            }
          }
          if (paramzxi.ys() != 1) {
            break;
          }
        } while (!iE(paramString));
        paramString = paramString.trim().substring(0, 1);
      } while ((aqmr.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(str)));
      return true;
    } while ((paramzxi.ys() != 2) || (!a(paramString, str, paramzxi)));
    return true;
  }
  
  public Object[] a(SessionInfo paramSessionInfo, String paramString, int paramInt)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(0);
    arrayOfObject[1] = Long.valueOf(0L);
    arrayOfObject[2] = null;
    arrayOfObject[3] = null;
    if (paramSessionInfo == null) {
      return arrayOfObject;
    }
    if (TextUtils.isEmpty(paramString)) {
      return arrayOfObject;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.charAt(0));
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(paramString.length());
      QLog.d("PasswdRedBagManager", 2, "openPasswdRedBagByPassword, passwd = " + ((StringBuilder)localObject).toString());
    }
    long l = SystemClock.uptimeMillis();
    BX(false);
    csn();
    zxi localzxi;
    try
    {
      localObject = a(paramSessionInfo, paramString, arrayOfObject);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PasswdRedBagManager", 2, "openPasswdRedBagByPassword, selectPasswdRedBagInfo = null");
        }
        return arrayOfObject;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("PasswdRedBagManager", 2, QLog.getStackTraceString(localThrowable));
        localzxi = null;
      }
      l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendByPwd", "msgType=6", 0, null, l);
      if (localzxi.type != 0) {
        break label327;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("PasswdRedBagManager", 2, "----word hb----" + localzxi.redBagId);
    }
    if ((!aqmr.isEmpty(paramString)) && (localzxi != null) && (!aqmr.isEmpty(localzxi.bba)) && (paramString.trim().equals(localzxi.bba.trim())))
    {
      z(localzxi.redBagId, paramSessionInfo.aTl, paramSessionInfo.cZ);
      a(paramSessionInfo, localzxi, l, paramInt);
    }
    for (;;)
    {
      return arrayOfObject;
      label327:
      if (4 == localzxi.type)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PasswdRedBagManager", 2, "----word chain hb----" + localzxi.redBagId);
        }
        if (a(paramString, localzxi)) {
          a(paramString.trim(), paramSessionInfo, localzxi, l, paramInt);
        }
      }
    }
  }
  
  public Object[] a(String paramString1, SessionInfo paramSessionInfo, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PasswdRedBagManager", 2, "openPasswdRedBagById, id = " + paramString2);
    }
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(0);
    arrayOfObject[1] = Long.valueOf(0L);
    arrayOfObject[2] = null;
    arrayOfObject[3] = null;
    if (paramSessionInfo == null) {
      return arrayOfObject;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return arrayOfObject;
    }
    long l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendById", "msgType=6", 0, null);
    BX(false);
    csn();
    zxi localzxi = (zxi)this.hF.get(paramString2);
    if (localzxi == null)
    {
      VACDReportUtil.endReport(l, "pwd.end", "", -1, "no redid");
      return arrayOfObject;
    }
    arrayOfObject[1] = Long.valueOf(localzxi.baZ);
    if (4 == localzxi.type)
    {
      arrayOfObject[2] = null;
      arrayOfObject[3] = null;
    }
    while (4 != localzxi.type) {
      if (localzxi.isOpen)
      {
        VACDReportUtil.endReport(l, "pwd.end", "", -1, "opened");
        return arrayOfObject;
        if ((!localzxi.bul) && (localzxi.expireTime >= NetConnInfoCenter.getServerTimeMillis() / 1000L))
        {
          arrayOfObject[2] = paramString2;
          arrayOfObject[3] = localzxi.redBagIndex;
        }
      }
      else
      {
        if (localzxi.isFinish)
        {
          arrayOfObject[0] = Integer.valueOf(2);
          VACDReportUtil.endReport(l, "pwd.end", "", -1, "finish");
          return arrayOfObject;
        }
        if ((localzxi.bul) || (localzxi.expireTime < NetConnInfoCenter.getServerTimeMillis() / 1000L))
        {
          if (!localzxi.bul) {
            zN(paramString2);
          }
          if (4 != localzxi.type)
          {
            arrayOfObject[0] = Integer.valueOf(3);
            VACDReportUtil.endReport(l, "pwd.end", "", -1, "overdue");
            return arrayOfObject;
          }
        }
      }
    }
    if (!aqmr.isEmpty(paramString1))
    {
      if ((localzxi.type != 0) || (aqmr.isEmpty(localzxi.bba)) || (!paramString1.equals(localzxi.bba))) {
        break label432;
      }
      z(localzxi.redBagId, paramSessionInfo.aTl, paramSessionInfo.cZ);
      a(paramSessionInfo, localzxi, l, paramInt);
    }
    for (;;)
    {
      arrayOfObject[0] = Integer.valueOf(1);
      return arrayOfObject;
      label432:
      if ((4 != localzxi.type) || (!a(paramString1, localzxi)) || (localzxi.isFinish) || (localzxi.VU())) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("PasswdRedBagManager", 2, "----成语接龙红包----" + localzxi.redBagId);
      }
      a(paramString1.trim(), paramSessionInfo, localzxi, l, paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PasswdRedBagManager", 2, "openPasswdRedBagById| 根据输入文字进行匹配");
    }
    return a(paramSessionInfo, paramString1.trim(), paramInt);
  }
  
  public void b(HashSet<String> paramHashSet)
  {
    this.uP.clear();
    this.uP.addAll(paramHashSet);
    k(paramHashSet);
  }
  
  public void bm(String paramString, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.f;
    if (paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      anot.a(localQQAppInterface, "CliOper", "", "", "0X8006115", "0X8006115", 0, 0, "", str, paramString, "0");
      return;
    }
  }
  
  public void c(SessionInfo paramSessionInfo)
  {
    ThreadManagerV2.excute(new PasswdRedBagManager.3(this, paramSessionInfo), 16, null, true);
  }
  
  public void cO(String paramString, int paramInt)
  {
    String str = acfp.m(2131709404);
    if (paramInt == 8) {
      str = "匿名不能抢K歌红包哦";
    }
    for (;;)
    {
      ((apuf)this.f.getManager(81)).a(paramString, str, NetConnInfoCenter.getServerTime(), 10000L, 0, 1);
      return;
      if (paramInt == 9) {
        str = acfp.m(2131709407);
      } else if (paramInt == 10) {
        str = acfp.m(2131709403);
      } else if (paramInt == 11) {
        str = acfp.m(2131709410);
      }
    }
  }
  
  public void cP(String paramString, int paramInt)
  {
    String str = acfp.m(2131709408);
    if (paramInt == 8) {
      str = "禁言不能抢K歌红包哦";
    }
    for (;;)
    {
      ((apuf)this.f.getManager(81)).a(paramString, str, NetConnInfoCenter.getServerTime(), 10000L, 0, 1);
      return;
      if (paramInt == 9) {
        str = acfp.m(2131709405);
      } else if (paramInt == 10) {
        str = acfp.m(2131709406);
      } else if (paramInt == 11) {
        str = acfp.m(2131709409);
      }
    }
  }
  
  public void csk()
  {
    if ((this.hD == null) || (this.hD.size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      this.uQ.clear();
      localArrayList = new ArrayList();
      List localList = this.jdField_a_of_type_Zxh.F(1);
      Iterator localIterator = this.hD.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        zxr localzxr = new zxr();
        localzxr.LE = Long.parseLong((String)localObject);
        localzxr.source = 1;
        localzxr.lastUpdateTime = Long.parseLong((String)this.hD.get(localObject));
        int i = localList.indexOf(localzxr);
        if (i != -1)
        {
          localObject = (zxr)localList.get(i);
          if (localzxr.lastUpdateTime <= ((zxr)localObject).lastUpdateTime) {}
        }
        else
        {
          localObject = new oidb_0x438.ReqInfo();
          ((oidb_0x438.ReqInfo)localObject).uint64_code.set(localzxr.LE);
          ((oidb_0x438.ReqInfo)localObject).uint64_last_redbag_time.set(localzxr.lastUpdateTime);
          localArrayList.add(localObject);
          this.uQ.add(localzxr);
        }
      }
      this.hD.clear();
    } while (this.uQ.isEmpty());
    this.jdField_a_of_type_Ackg.Q(0, localArrayList);
  }
  
  public void csl()
  {
    if ((this.hE == null) || (this.hE.size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      this.uR.clear();
      localArrayList = new ArrayList();
      List localList = this.jdField_a_of_type_Zxh.F(2);
      Iterator localIterator = this.hE.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        zxr localzxr = new zxr();
        localzxr.LE = Long.parseLong((String)localObject);
        localzxr.source = 2;
        localzxr.lastUpdateTime = Long.parseLong((String)this.hE.get(localObject));
        int i = localList.indexOf(localzxr);
        if (i != -1)
        {
          localObject = (zxr)localList.get(i);
          if (localzxr.lastUpdateTime <= ((zxr)localObject).lastUpdateTime) {}
        }
        else
        {
          localObject = new oidb_0x438.ReqInfo();
          ((oidb_0x438.ReqInfo)localObject).uint64_code.set(localzxr.LE);
          ((oidb_0x438.ReqInfo)localObject).uint64_last_redbag_time.set(localzxr.lastUpdateTime);
          localArrayList.add(localObject);
          this.uR.add(localzxr);
        }
      }
      this.hE.clear();
    } while (this.uR.isEmpty());
    this.jdField_a_of_type_Ackg.Q(1, localArrayList);
  }
  
  public void csm()
  {
    try
    {
      SharedPreferences localSharedPreferences = this.mContext.getSharedPreferences("sp_passwd_configs_" + this.mUin, 0);
      if (localSharedPreferences.getBoolean("key_db_update", true))
      {
        ThreadManager.getFileThreadHandler().post(new PasswdRedBagManager.7(this));
        localSharedPreferences.edit().putBoolean("key_db_update", false);
        localSharedPreferences.edit().commit();
      }
      ThreadManager.getFileThreadHandler().post(new PasswdRedBagManager.8(this));
      return;
    }
    finally {}
  }
  
  /* Error */
  public void csn()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 617	zxj:VV	()Z
    //   6: ifeq +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 620	zxj:cso	()V
    //   13: aload_0
    //   14: getfield 174	zxj:buo	Z
    //   17: ifeq +12 -> 29
    //   20: aload_0
    //   21: getfield 565	zxj:bup	Z
    //   24: istore_1
    //   25: iload_1
    //   26: ifeq +6 -> 32
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: iconst_1
    //   34: putfield 565	zxj:bup	Z
    //   37: new 1299	com/tencent/mobileqq/activity/qwallet/PasswdRedBagManager$10
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 1300	com/tencent/mobileqq/activity/qwallet/PasswdRedBagManager$10:<init>	(Lzxj;)V
    //   45: bipush 32
    //   47: aconst_null
    //   48: iconst_1
    //   49: invokestatic 1301	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   52: goto -23 -> 29
    //   55: astore_2
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	zxj
    //   24	2	1	bool	boolean
    //   55	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	55	finally
    //   13	25	55	finally
    //   32	52	55	finally
  }
  
  public void cso()
  {
    this.mUin = this.f.getCurrentAccountUin();
    this.jdField_a_of_type_Zxh = new zxh(this);
    this.hG.clear();
    this.hI.clear();
    this.hF.clear();
    this.uP.clear();
    this.bum = true;
    this.bun = true;
    this.buo = true;
    this.bup = false;
  }
  
  public void csp()
  {
    int i = 0;
    if (this.isConfigLoaded) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject = this.mContext.getSharedPreferences("sp_passwd_configs_" + this.mUin, 0);
        if (Build.VERSION.SDK_INT < 11) {
          continue;
        }
        localObject = ((SharedPreferences)localObject).getStringSet("key_passwd_configs", new HashSet());
        if ((localObject != null) && (((Set)localObject).size() > 0)) {
          this.uP.addAll((Collection)localObject);
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        int j;
        localThrowable.printStackTrace();
        continue;
      }
      this.isConfigLoaded = true;
      return;
      j = ((SharedPreferences)localObject).getInt("key_passwd_configs_count", 0);
      if (j > 0) {
        if (i < j)
        {
          this.uP.add(((SharedPreferences)localObject).getString("key_passwd_configs_" + i, ""));
          i += 1;
        }
      }
    }
  }
  
  public boolean d(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    boolean bool = false;
    String str = paramString1 + paramInt + paramString2;
    paramString1 = paramString1 + paramInt + paramString3;
    if ((!TextUtils.isEmpty(paramString2)) && (this.hJ != null) && (this.hJ.containsKey(str)))
    {
      paramInt = 1;
      if ((TextUtils.isEmpty(paramString3)) || (this.hK == null) || (!this.hK.containsKey(paramString1))) {
        break label128;
      }
    }
    label128:
    for (int i = 1;; i = 0)
    {
      if ((paramInt != 0) || (i != 0)) {
        bool = true;
      }
      return bool;
      paramInt = 0;
      break;
    }
  }
  
  public Bitmap f(String paramString, @DrawableRes int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (BaseApplicationImpl.sImageCache != null) {}
    label145:
    for (Bitmap localBitmap1 = (Bitmap)BaseApplicationImpl.sImageCache.get(paramString);; localBitmap1 = null) {
      if (localBitmap1 == null) {
        try
        {
          Bitmap localBitmap2 = BitmapFactory.decodeResource(this.mContext.getResources(), paramInt);
          localObject1 = localBitmap2;
          localObject2 = localObject1;
          if (localObject1 != null) {}
          Object localObject3;
          return localBitmap1;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            try
            {
              localObject2 = Bitmap.createScaledBitmap(localObject1, aqcx.dip2px(this.mContext, 10.0F), aqcx.dip2px(this.mContext, 15.0F), true);
              if (localObject2 == null) {
                break label145;
              }
              if (BaseApplicationImpl.sImageCache != null) {
                BaseApplicationImpl.sImageCache.put(paramString, localObject2);
              }
              return localObject2;
            }
            catch (OutOfMemoryError localOutOfMemoryError1)
            {
              continue;
            }
            catch (Exception localException2)
            {
              continue;
            }
            localException1 = localException1;
            localException1.printStackTrace();
            localObject3 = localObject1;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          for (;;)
          {
            localObject1 = localObject3;
            localObject3 = localOutOfMemoryError2;
            localObject3.printStackTrace();
            localObject3 = localObject1;
          }
        }
      }
    }
  }
  
  public int fH(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 0: 
    case 1000: 
    case 1001: 
    case 1004: 
    case 10002: 
    case 10004: 
    case 10008: 
      return 3;
    }
    return 2;
  }
  
  public String hV(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PasswdRedBagManager", 2, "getLastIdiomPinyin|password: " + paramString);
    }
    if ((aqmr.isEmpty(paramString)) || (!paramString.contains("_"))) {
      return "";
    }
    paramString = paramString.split("_");
    if (paramString.length != 2) {
      return "";
    }
    return paramString[1];
  }
  
  public void k(Set<String> paramSet)
  {
    try
    {
      SharedPreferences.Editor localEditor = this.mContext.getSharedPreferences("sp_passwd_configs_" + this.mUin, 0).edit();
      if (Build.VERSION.SDK_INT >= 11) {
        localEditor.putStringSet("key_passwd_configs", paramSet);
      }
      for (;;)
      {
        localEditor.commit();
        return;
        localEditor.putInt("key_passwd_configs_count", paramSet.size());
        paramSet = paramSet.iterator();
        int i = 0;
        while (paramSet.hasNext())
        {
          String str = (String)paramSet.next();
          localEditor.putString("key_passwd_configs_" + i, str);
          i += 1;
        }
      }
      return;
    }
    catch (Throwable paramSet)
    {
      paramSet.printStackTrace();
    }
  }
  
  /* Error */
  public void m(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 312	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +49 -> 54
    //   8: ldc 199
    //   10: iconst_2
    //   11: new 201	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 1383
    //   21: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc_w 1385
    //   31: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_2
    //   35: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 1387
    //   41: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_3
    //   45: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 614	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: aload_1
    //   55: invokestatic 371	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: ifne +21 -> 79
    //   61: aload_2
    //   62: invokestatic 371	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   65: ifne +14 -> 79
    //   68: aload_3
    //   69: invokestatic 371	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   72: istore 6
    //   74: iload 6
    //   76: ifeq +6 -> 82
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: aload_0
    //   83: iconst_0
    //   84: invokevirtual 513	zxj:BX	(Z)V
    //   87: aload_0
    //   88: getfield 157	zxj:hF	Ljava/util/HashMap;
    //   91: aload_1
    //   92: invokevirtual 287	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   95: checkcast 236	zxi
    //   98: astore 7
    //   100: invokestatic 312	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +30 -> 133
    //   106: ldc 199
    //   108: iconst_2
    //   109: new 201	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   116: ldc_w 1389
    //   119: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload 7
    //   124: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 319	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload 7
    //   135: ifnull -56 -> 79
    //   138: aload_0
    //   139: getfield 132	zxj:jdField_a_of_type_Zxh	Lzxh;
    //   142: aload 7
    //   144: getfield 1392	zxi:extStr	Ljava/lang/String;
    //   147: invokevirtual 1396	zxh:o	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   150: astore 8
    //   152: aload 8
    //   154: ifnull -75 -> 79
    //   157: aload 8
    //   159: ldc_w 1398
    //   162: invokevirtual 1401	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   165: istore 5
    //   167: invokestatic 312	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq +69 -> 239
    //   173: ldc 199
    //   175: iconst_2
    //   176: new 201	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   183: ldc_w 1403
    //   186: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: iload 5
    //   191: invokevirtual 280	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: ldc_w 1405
    //   197: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: iload 4
    //   202: invokevirtual 280	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: ldc_w 1407
    //   208: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload 8
    //   213: invokevirtual 851	org/json/JSONObject:toString	()Ljava/lang/String;
    //   216: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: ldc_w 1409
    //   222: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload 7
    //   227: getfield 239	zxi:bbb	Ljava/lang/String;
    //   230: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 319	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: iload 4
    //   241: iload 5
    //   243: if_icmple -164 -> 79
    //   246: aload 8
    //   248: ldc_w 1398
    //   251: iload 4
    //   253: invokevirtual 1412	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   256: pop
    //   257: aload 7
    //   259: aload 8
    //   261: invokevirtual 851	org/json/JSONObject:toString	()Ljava/lang/String;
    //   264: putfield 1392	zxi:extStr	Ljava/lang/String;
    //   267: new 201	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   274: aload_2
    //   275: invokevirtual 253	java/lang/String:trim	()Ljava/lang/String;
    //   278: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: ldc 255
    //   283: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: aload_3
    //   287: invokevirtual 253	java/lang/String:trim	()Ljava/lang/String;
    //   290: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: astore_2
    //   297: invokestatic 312	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq +29 -> 329
    //   303: ldc 199
    //   305: iconst_2
    //   306: new 201	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   313: ldc_w 1414
    //   316: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_2
    //   320: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 319	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: aload 7
    //   331: aload_2
    //   332: putfield 239	zxi:bbb	Ljava/lang/String;
    //   335: aload_0
    //   336: aload 7
    //   338: aload_0
    //   339: aload 7
    //   341: getfield 239	zxi:bbb	Ljava/lang/String;
    //   344: invokevirtual 555	zxj:hV	(Ljava/lang/String;)Ljava/lang/String;
    //   347: invokevirtual 1416	zxj:a	(Lzxi;Ljava/lang/String;)V
    //   350: invokestatic 524	com/tencent/mobileqq/app/ThreadManager:getFileThreadHandler	()Lmqq/os/MqqHandler;
    //   353: new 1418	com/tencent/mobileqq/activity/qwallet/PasswdRedBagManager$16
    //   356: dup
    //   357: aload_0
    //   358: aload_1
    //   359: aload_2
    //   360: aload 8
    //   362: invokespecial 1421	com/tencent/mobileqq/activity/qwallet/PasswdRedBagManager$16:<init>	(Lzxj;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   365: invokevirtual 535	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   368: pop
    //   369: goto -290 -> 79
    //   372: astore_1
    //   373: aload_1
    //   374: invokevirtual 551	java/lang/Throwable:printStackTrace	()V
    //   377: goto -298 -> 79
    //   380: astore_1
    //   381: aload_0
    //   382: monitorexit
    //   383: aload_1
    //   384: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	this	zxj
    //   0	385	1	paramString1	String
    //   0	385	2	paramString2	String
    //   0	385	3	paramString3	String
    //   0	385	4	paramInt	int
    //   165	79	5	i	int
    //   72	3	6	bool	boolean
    //   98	242	7	localzxi	zxi
    //   150	211	8	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   138	152	372	java/lang/Throwable
    //   157	239	372	java/lang/Throwable
    //   246	329	372	java/lang/Throwable
    //   329	369	372	java/lang/Throwable
    //   2	54	380	finally
    //   54	74	380	finally
    //   82	133	380	finally
    //   138	152	380	finally
    //   157	239	380	finally
    //   246	329	380	finally
    //   329	369	380	finally
    //   373	377	380	finally
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Ackh.cLZ();
    this.f.removeObserver(this.jdField_a_of_type_Ackh);
    this.jdField_a_of_type_Zxh.onDestroy();
    if ((this.jdField_a_of_type_Zxj$a != null) && (this.mContext != null)) {
      this.mContext.unregisterReceiver(this.jdField_a_of_type_Zxj$a);
    }
  }
  
  public String qa()
  {
    csp();
    if (this.uP.size() == 0) {
      return null;
    }
    int i = new Random(System.currentTimeMillis()).nextInt(this.uP.size());
    return (String)this.uP.get(i);
  }
  
  public void r(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean) {
      BX(false);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      if (!this.hL.containsKey(paramString1)) {
        this.hL.put(paramString1, paramString2);
      }
    } while (this.hM.containsKey(paramString2));
    this.hM.put(paramString2, paramString1);
  }
  
  public void t(Context paramContext, String paramString1, String paramString2)
  {
    if ((aqmr.isEmpty(paramString1)) || (aqmr.isEmpty(paramString2))) {}
    label14:
    do
    {
      do
      {
        do
        {
          break label14;
          do
          {
            return;
          } while (!(paramContext instanceof FragmentActivity));
          paramContext = (FragmentActivity)paramContext;
        } while (paramContext.getChatFragment() == null);
        paramContext = paramContext.getChatFragment().a();
      } while (paramContext == null);
      paramContext = (wwn)paramContext.a(27);
    } while (paramContext == null);
    paramContext.dB(paramString2, paramString1);
  }
  
  public void y(HashMap<String, String> paramHashMap)
  {
    if (this.hD == null) {
      this.hD = new HashMap();
    }
    this.hD.putAll(paramHashMap);
  }
  
  public void z(String paramString1, String paramString2, int paramInt)
  {
    b(paramString1, paramString2, paramInt, true);
  }
  
  public void z(HashMap<String, String> paramHashMap)
  {
    if (this.hE == null) {
      this.hE = new HashMap();
    }
    this.hE.putAll(paramHashMap);
  }
  
  public void zM(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    zxi localzxi;
    do
    {
      return;
      BX(false);
      localzxi = (zxi)this.hF.get(paramString);
    } while ((localzxi == null) || (localzxi.isFinish));
    localzxi.isFinish = true;
    ThreadManager.getFileThreadHandler().post(new PasswdRedBagManager.13(this, paramString));
  }
  
  public void zN(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    zxi localzxi;
    do
    {
      return;
      BX(false);
      localzxi = (zxi)this.hF.get(paramString);
    } while ((localzxi == null) || (localzxi.bul));
    localzxi.bul = true;
    ThreadManager.getFileThreadHandler().post(new PasswdRedBagManager.14(this, paramString));
  }
  
  public void zO(String paramString)
  {
    anot.a(this.f, "CliOper", "", "", "0X8006116", "0X8006116", 0, 0, "", "0", paramString, "0");
  }
  
  class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int i;
      String str1;
      String str2;
      int j;
      zxi localzxi;
      if ("grap_idiom_hb_result_action".equals(paramIntent.getAction()))
      {
        i = paramIntent.getIntExtra("grap_hb_state", 0);
        paramContext = paramIntent.getStringExtra("listid");
        str1 = paramIntent.getStringExtra("grap_hb_frienduin");
        str2 = paramIntent.getStringExtra("grap_hb_idiom");
        j = paramIntent.getIntExtra("grap_hb_seq", 0);
        paramIntent = paramIntent.getStringExtra("grap_idiom_alpha");
        localzxi = zxj.this.a(paramContext);
        QLog.i("PasswdRedBagManager", 1, "grapHbState=" + i + ",passwdRedBagInfo=" + localzxi);
        if ((i != 1) && (i != 10)) {
          break label128;
        }
        zxj.a(zxj.this, paramContext, str1, 1, true);
      }
      label128:
      do
      {
        do
        {
          return;
          if (i != 12) {
            break;
          }
        } while (localzxi == null);
        zxj.a(zxj.this, paramContext, str1, 1, false);
        zxj.this.m(paramContext, str2, paramIntent, j);
        return;
      } while ((i != 0) || (localzxi.ys() != 2));
      zxj.a(zxj.this, paramContext, str1, 1, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zxj
 * JD-Core Version:    0.7.0.1
 */