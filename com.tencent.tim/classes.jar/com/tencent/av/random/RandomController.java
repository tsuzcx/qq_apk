package com.tencent.av.random;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import anot;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.b;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.PopupDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import igv;
import iiv;
import iiv.a;
import ire;
import irf;
import irg;
import iri;
import irj;
import ivv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import jjh;
import jkb;
import jkb.a;
import jko;

public class RandomController
{
  private static final RandomController jdField_a_of_type_ComTencentAvRandomRandomController = new RandomController();
  private AtomicInteger H = new AtomicInteger(0);
  private String PQ;
  public String PR;
  public String PS;
  public String PT;
  public String PW;
  public String PY;
  public String PZ;
  private boolean Ul;
  private boolean Um;
  private boolean Un;
  private boolean Uo;
  private boolean Up;
  public boolean Uq;
  public boolean Ur;
  public boolean Us;
  private boolean Ut;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private RequestFetchRunnable jdField_a_of_type_ComTencentAvRandomRandomController$RequestFetchRunnable = new RequestFetchRunnable(null);
  private RandomWebProtocol.a jdField_a_of_type_ComTencentAvRandomRandomWebProtocol$a = new ire(this);
  private RandomWebProtocol jdField_a_of_type_ComTencentAvRandomRandomWebProtocol;
  private jkb.a jdField_a_of_type_Jkb$a = new irg(this);
  private jkb jdField_a_of_type_Jkb;
  private byte[] aX;
  private int aqx;
  private int asi = -1;
  private int asj;
  private int ask = 0;
  private int asl;
  private int asm = 0;
  private int asn;
  public int aso = -1;
  public int asp = -1;
  private Bitmap bf;
  private Runnable bp = new RandomController.3(this);
  private Runnable bq = new RandomController.4(this);
  private Runnable br = new RandomController.5(this);
  private Runnable bs = new RandomController.6(this);
  private Runnable bt = new RandomController.7(this);
  public iiv e;
  private long[] m;
  private VideoAppInterface mApp;
  public long mK;
  private List<a> mListeners = new ArrayList();
  public String mSessionId;
  public int mStatus = 0;
  private int mType;
  
  public static RandomController a(VideoAppInterface paramVideoAppInterface)
  {
    jdField_a_of_type_ComTencentAvRandomRandomController.e(paramVideoAppInterface);
    return jdField_a_of_type_ComTencentAvRandomRandomController;
  }
  
  private void a(RandomWebProtocol.g paramg)
  {
    Object localObject1 = null;
    this.asp = 1011;
    if ((paramg instanceof RandomWebProtocol.h)) {
      if (this.Uq) {
        if (QLog.isColorLevel()) {
          QLog.w("RandomController", 2, "[1v1] processWebProtocol RspDouble discard this push");
        }
      }
    }
    for (;;)
    {
      return;
      this.Uq = true;
      Object localObject2 = (RandomWebProtocol.h)paramg;
      a(((RandomWebProtocol.h)localObject2).Qf, ((RandomWebProtocol.h)localObject2).Qg, ((RandomWebProtocol.h)localObject2).aY, ((RandomWebProtocol.h)localObject2).headurl, ((RandomWebProtocol.h)localObject2).bg, ((RandomWebProtocol.h)localObject2).Qh, ((RandomWebProtocol.h)localObject2).asy);
      this.jdField_a_of_type_ComTencentAvVideoController.A(this.PT, this.PW, this.PY);
      do
      {
        localObject2 = this.e.sessionId;
        this.mSessionId = igv.a(3, this.PT, new int[0]);
        igv.a().u((String)localObject2, this.mSessionId);
        if (this.mApp != null)
        {
          jko localjko = jko.a(this.mApp);
          if ((localjko != null) && (localjko.isActive())) {
            localjko.bj((String)localObject2, this.mSessionId);
          }
        }
        if (this.jdField_a_of_type_Jkb != null) {
          this.jdField_a_of_type_Jkb.kJ(this.mSessionId);
        }
        if ((this.e.uinType != 1011) && (!TextUtils.equals(this.e.peerUin, this.PT)) && (this.e.a.Rt))
        {
          this.jdField_a_of_type_ComTencentAvVideoController.O(this.e.peerUin, 221);
          this.jdField_a_of_type_ComTencentAvVideoController.ko(221);
        }
        if ((this.PQ != null) && (!TextUtils.isEmpty(this.PQ))) {
          this.e.a.Nc = (this.jdField_a_of_type_ComTencentAvVideoController.getAppContext().getString(2131697962) + this.PQ);
        }
        if (this.mType != 1) {
          break label983;
        }
        if (!TextUtils.isEmpty(this.PT)) {
          break label549;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("RandomController", 2, "uin is empty");
        return;
      } while (!(paramg instanceof RandomWebProtocol.j));
      localObject2 = (RandomWebProtocol.j)paramg;
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "processWebProtocol RspMulti [random room owner]");
      }
      if (((RandomWebProtocol.j)localObject2).asy > 0) {
        this.Ur = true;
      }
      for (;;)
      {
        this.asi = ((RandomWebProtocol.j)localObject2).asA;
        this.PZ = ((RandomWebProtocol.j)localObject2).Qk;
        this.Up = ((RandomWebProtocol.j)localObject2).Uw;
        if ((TextUtils.isEmpty(this.PZ)) && (this.Up)) {
          this.mApp.getHandler().postDelayed(this.bq, 7000L);
        }
        if (!this.Up) {
          this.PZ = null;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("RandomController", 2, "[random room owner] processWebProtocol RspMulti mRoomOwnerUin = " + this.PZ + ",mRoomOwnerEnable = " + this.Up);
        break;
        if (((RandomWebProtocol.j)localObject2).asy == 0) {
          this.Ur = false;
        }
      }
      label549:
      this.ask = 1;
      boolean bool;
      if ((this.mApp == null) || (Long.valueOf(this.mApp.getCurrentAccountUin()).longValue() <= Long.valueOf(this.PT).longValue()))
      {
        bool = true;
        label590:
        this.Uo = bool;
        this.jdField_a_of_type_ComTencentAvVideoController.alR();
        if (!this.Ur) {
          break label947;
        }
      }
      try
      {
        paramg = jjh.getRoundedCornerBitmap(this.bf, this.bf.getWidth() / 2);
        if (paramg != null) {
          this.e.a.ba = paramg;
        }
        this.e.MO = this.PW;
        this.e.a.nickName = this.PW;
        for (;;)
        {
          this.e.e(-1032L, "processWebProtocol", this.ask);
          this.e.uinType = this.asp;
          this.e.QE = true;
          this.e.signature = this.aX;
          this.e.isFriend = false;
          this.e.amK = this.ask;
          this.e.a.peerUin = this.PT;
          if (QLog.isColorLevel()) {
            QLog.d("RandomController", 2, "processWebProtocol  uinType = " + this.asp + " # peerUin = " + this.PT + " # signature = " + this.aX + " # BeginSessionType = " + this.ask + " # nickName = " + this.PW + " # roomTopic = " + this.PS + " # topTips = " + this.PQ + ", isMask: " + this.Ur);
          }
          if ((this.mApp != null) && (this.mApp.getHandler() != null)) {
            this.mApp.getHandler().removeCallbacks(this.bp);
          }
          PopupDialog.axr();
          paramg = this.mListeners.iterator();
          while (paramg.hasNext()) {
            ((a)paramg.next()).apJ();
          }
          bool = false;
          break label590;
          label947:
          ju(this.PT);
          paramg = c(this.PT, false);
          if (paramg != null)
          {
            this.e.a.ba = paramg;
            continue;
            label983:
            if (this.mType == 2)
            {
              this.ask = 3;
              this.aqx = 7;
              this.asn = 0;
              if (!(paramg instanceof RandomWebProtocol.j)) {
                break label1315;
              }
              paramg = ((RandomWebProtocol.j)paramg).Qj;
              if ((paramg == null) || (paramg.equals(""))) {
                break;
              }
              paramg = paramg.split(",");
              this.m = new long[paramg.length];
              int i = 0;
              for (;;)
              {
                if (i < paramg.length) {
                  try
                  {
                    this.m[i] = Long.parseLong(paramg[i].trim());
                    i += 1;
                  }
                  catch (NumberFormatException localNumberFormatException)
                  {
                    for (;;)
                    {
                      this.m[i] = 0L;
                      localNumberFormatException.printStackTrace();
                    }
                  }
                }
              }
              if ((this.ask == 3) || (this.ask == 4)) {
                this.e.ll = this.mK;
              }
              if (QLog.isColorLevel()) {
                QLog.d("RandomController", 2, "[random room owner] mRelationType = " + this.aqx);
              }
              this.e.relationType = this.aqx;
              this.e.PT = false;
              this.e.a.headUrl = null;
              this.e.a.nickName = null;
              this.e.a.Rs = false;
            }
          }
        }
        if ((this.mStatus == 2) || (this.mStatus == 3)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("RandomController", 2, "[warning] already in connecting. mStatus = " + this.mStatus);
        }
        this.mStatus = 2;
        if (this.mType == 1)
        {
          ly();
          return;
        }
        if (this.mType != 2) {
          continue;
        }
        k(false);
        return;
      }
      catch (OutOfMemoryError paramg)
      {
        for (;;)
        {
          paramg = localNumberFormatException;
        }
      }
      catch (Exception paramg)
      {
        for (;;)
        {
          paramg = localNumberFormatException;
          continue;
          label1315:
          paramg = null;
        }
      }
    }
  }
  
  private void a(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, Bitmap paramBitmap, String paramString4, int paramInt)
  {
    this.PT = paramString1;
    this.PW = paramString2;
    if (paramArrayOfByte != null)
    {
      this.aX = new byte[paramArrayOfByte.length + 3];
      this.aX[0] = 1;
      this.aX[1] = 1;
      this.aX[2] = -118;
      System.arraycopy(paramArrayOfByte, 0, this.aX, 3, paramArrayOfByte.length);
      this.PY = paramString3;
      this.bf = paramBitmap;
      this.PQ = paramString4;
      if (paramInt <= 0) {
        break label115;
      }
      this.Ur = true;
    }
    label115:
    while (paramInt != 0)
    {
      return;
      this.aX = new byte[] { 1, 1, -118 };
      break;
    }
    this.Ur = false;
  }
  
  private String aM(int paramInt)
  {
    String str2 = this.mApp.getApp().getString(2131697946);
    int j = paramInt / 86400;
    int k = paramInt % 86400 / 3600;
    int i = paramInt % 3600 / 60;
    if ((j == 0) && (k == 0) && (i == 0)) {
      i = 1;
    }
    for (;;)
    {
      StringBuilder localStringBuilder;
      if (j > 0)
      {
        str1 = String.format("%d天", new Object[] { Integer.valueOf(j) });
        localStringBuilder = new StringBuilder().append(str1);
        if (k <= 0) {
          break label241;
        }
        str1 = String.format("%d小时", new Object[] { Integer.valueOf(k) });
        label118:
        str1 = str1;
        localStringBuilder = new StringBuilder().append(str1);
        if (i <= 0) {
          break label249;
        }
      }
      label241:
      label249:
      for (String str1 = String.format("%d分钟", new Object[] { Integer.valueOf(i) });; str1 = "")
      {
        str1 = str2.replace("%t", str1);
        if (QLog.isColorLevel()) {
          QLog.d("RandomController", 2, "getBlockedPromoteText：" + paramInt + ",promtString:" + str1);
        }
        return str1;
        str1 = "";
        break;
        str1 = "";
        break label118;
      }
    }
  }
  
  private void apG()
  {
    if ((this.mStatus == 1) && (QLog.isColorLevel())) {
      QLog.d("RandomController", 2, "gotoMatchTimeout trigger, show timeOutDialog!");
    }
    if ((this.mApp != null) && (this.mApp.getHandler() != null) && (this.mType == 1)) {
      this.mApp.getHandler().post(this.bp);
    }
  }
  
  private void apH()
  {
    if ((this.mStatus == 1) && (QLog.isColorLevel())) {
      QLog.d("RandomController", 2, "gotoMatchError trigger, show timeOutDialog!");
    }
    this.mStatus = -2;
  }
  
  private void apI()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "showTimeoutDialog");
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.mNetType == 0) || (this.Ut)) {}
    for (;;)
    {
      return;
      if (this.mType == 1) {
        anot.a(null, "CliOper", "", "", "0X80053B3", "0X80053B3", 0, 0, "", "", "", "");
      }
      while (!this.e.isConnected())
      {
        Context localContext = this.mApp.getApp().getApplicationContext();
        PopupDialog.b(localContext, 230, null, localContext.getString(2131697949), 2131721690, 2131698056, new irj(this), new irf(this));
        this.Ut = true;
        return;
        if (this.mType == 2) {
          anot.a(null, "CliOper", "", "", "0X80053BF", "0X80053BF", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  private void b(RandomWebProtocol.g paramg)
  {
    this.mApp.getHandler().removeCallbacks(this.bp);
    if (this.mStatus == -3) {
      return;
    }
    PopupDialog.axr();
    if (this.mType == 2) {
      anot.a(null, "CliOper", "", "", "0X8005728", "0X8005728", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.mStatus = -3;
      localObject = this.mListeners.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((a)((Iterator)localObject).next()).apJ();
      }
      if (this.mType == 1) {
        anot.a(null, "CliOper", "", "", "0X8005726", "0X8005726", 0, 0, "", "", "", "");
      }
    }
    Object localObject = this.mApp.getApp().getApplicationContext();
    this.asl = paramg.asx;
    PopupDialog.b((Context)localObject, 230, this.mApp.getApp().getString(2131697947), aM(this.asl), 2131721737, 0, null, new iri(this));
    this.mApp.getHandler().postDelayed(this.bs, 60000L);
    this.asl -= 60;
  }
  
  private void e(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface != null)
    {
      if (jdField_a_of_type_ComTencentAvRandomRandomController.mApp == null) {
        jdField_a_of_type_ComTencentAvRandomRandomController.mApp = paramVideoAppInterface;
      }
      if (jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol == null) {
        jdField_a_of_type_ComTencentAvRandomRandomController.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol = new RandomWebProtocol(paramVideoAppInterface);
      }
      this.jdField_a_of_type_ComTencentAvVideoController = this.mApp.b();
    }
  }
  
  private int k(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.OB)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "startOrEnterGAudio already in room");
      }
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "startOrEnterGAudio ,retry :" + paramBoolean + ", mCurRetryTimes:" + this.asn + ", mGroupIds: " + this.m.length);
    }
    if (this.asi < 0) {
      this.asi = 150;
    }
    int i = -1;
    int j;
    do
    {
      do
      {
        j = i;
        if (this.asn >= this.m.length) {
          break;
        }
        this.mK = this.m[this.asn];
        this.asn += 1;
      } while (this.mK == 0L);
      String str = this.e.sessionId;
      this.mSessionId = igv.a(this.aqx, String.valueOf(this.mK), new int[0]);
      igv.a().u(str, this.mSessionId);
      jko localjko = jko.a(this.mApp);
      if ((localjko != null) && (localjko.isActive())) {
        localjko.bj(str, this.mSessionId);
      }
      this.jdField_a_of_type_Jkb.kJ(this.mSessionId);
      j = this.jdField_a_of_type_ComTencentAvVideoController.a(this.aqx, this.mK, this.asi, this.e.f, false);
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "startOrEnterGAudio: ret(" + j + ")==0 mCurrGroupId(" + this.mK + ") mRelationType(" + this.aqx + ") mBusinessId(" + this.asi + ")");
      }
      i = j;
    } while (j != 0);
    if (QLog.isColorLevel()) {
      QLog.e("RandomController", 2, "startOrEnterGAudio -->mCurrGroupId == " + this.mK);
    }
    return j;
  }
  
  private int ly()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "requestDoubleChat");
    }
    int j = -1;
    int i;
    if ((!this.e.sY()) && (!this.e.sZ()))
    {
      i = j;
      if (!this.e.tc()) {}
    }
    else
    {
      if (this.Uo) {
        break label148;
      }
      this.e.peerUin = this.e.a.peerUin;
      i = this.jdField_a_of_type_ComTencentAvVideoController.a(0L, this.e.peerUin, 0, 4, this.e.MR, this.e.MS, this.e.gK(), this.asp, this.e.MP, this.e.MQ, this.e.signature, this.PS, null, 0, 0, null, null);
    }
    label148:
    do
    {
      do
      {
        return i;
        i = j;
      } while (!this.e.a.Rt);
      i = j;
    } while (!TextUtils.equals(this.e.peerUin, this.e.a.peerUin));
    return this.jdField_a_of_type_ComTencentAvVideoController.a(0L, this.e.peerUin, 0, 4);
  }
  
  public void apF()
  {
    if ((this.mApp != null) && (this.mApp.getHandler() != null)) {
      this.mApp.getHandler().removeCallbacks(this.bq);
    }
  }
  
  public int av(String paramString)
  {
    int i = -1;
    if ((this.mApp.getCurrentAccountUin().equals(paramString)) && (this.e.a.anC != -1)) {
      i = this.e.a.anC;
    }
    do
    {
      return i;
      paramString = this.jdField_a_of_type_ComTencentAvVideoController.a(paramString);
    } while (paramString == null);
    return paramString.gender;
  }
  
  public Bitmap c(String paramString, boolean paramBoolean)
  {
    int i = 1;
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentAvVideoController == null)) {
      paramString = null;
    }
    Bitmap localBitmap;
    do
    {
      return paramString;
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "[pullhead] ~~~~~~ getRandomFaceBitmap ~~~~~~ uin(" + paramString + "), isMask(" + this.Ur + ")");
      }
      if (!this.Ur) {
        return this.jdField_a_of_type_ComTencentAvVideoController.n(paramString);
      }
      if (this.mType != 1) {
        break;
      }
      localBitmap = this.jdField_a_of_type_ComTencentAvVideoController.b(paramString, true);
      paramString = localBitmap;
    } while (localBitmap != null);
    this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.ba(this.PT, this.PY);
    return null;
    if (this.mType == 2)
    {
      localBitmap = this.jdField_a_of_type_ComTencentAvVideoController.b(paramString, true);
      int j;
      RandomWebProtocol localRandomWebProtocol;
      int k;
      if ((localBitmap == null) || (paramBoolean))
      {
        j = av(paramString);
        if (j == -1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("RandomController", 2, "getRandomFaceBitmap-->uin=" + paramString + ", gender" + j);
          }
          ju(paramString);
          return null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("RandomController", 2, "[pullhead] call pull Head uin(" + paramString + "), isMask(" + this.Ur + ")");
        }
        localRandomWebProtocol = this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol;
        k = this.asj;
        if (!paramString.equals(this.mApp.getAccount())) {
          break label317;
        }
      }
      for (;;)
      {
        localRandomWebProtocol.a(k, i, paramString, j, this.mK);
        return localBitmap;
        label317:
        i = 2;
      }
    }
    return null;
  }
  
  public void ju(String paramString)
  {
    if ((this.jdField_a_of_type_Jkb != null) && (this.mApp != null)) {
      this.jdField_a_of_type_Jkb.e(this.mApp, paramString);
    }
  }
  
  public void start()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "start random matching");
    }
    this.Uq = false;
    this.PQ = null;
    if (this.jdField_a_of_type_Jkb == null)
    {
      this.jdField_a_of_type_Jkb = jkb.a(this.mApp);
      this.jdField_a_of_type_Jkb.a(this.jdField_a_of_type_Jkb$a);
    }
    if (this.e == null)
    {
      this.mSessionId = this.PS;
      if (!igv.a().ci(this.mSessionId)) {
        this.e = igv.a().a(this.mSessionId, false);
      }
    }
    if (this.e == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "start random matching mSessionInfo is null!");
      }
      return;
    }
    this.mStatus = 1;
    if ((this.mApp != null) && (this.mApp.getHandler() != null)) {
      this.mApp.getHandler().postDelayed(this.bp, 7000L);
    }
    if (this.e.a.anA != 2) {
      this.e.a.anA = 1;
    }
    if (this.mType == 1) {
      if (!this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.vk())
      {
        this.Ul = true;
        if ((this.mApp != null) && (this.mApp.getHandler() != null)) {
          this.mApp.getHandler().postDelayed(this.bt, 2000L);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.e(this.e.a.anA, 1, this.e.a.Nb);
      }
    }
    for (;;)
    {
      label271:
      if (this.e != null)
      {
        this.e.a.isMask = this.Ur;
        this.e.a.Nb = this.PS;
        return;
        this.H.set(0);
        this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a(this.asj, this.asm, 1, new String[0]);
        break;
        if (this.mType == 2)
        {
          if (this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.vk()) {
            break label427;
          }
          this.Um = true;
          if ((this.mApp != null) && (this.mApp.getHandler() != null)) {
            this.mApp.getHandler().postDelayed(this.bt, 2000L);
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.e(this.e.a.anA, 3, this.e.a.Nb);
      break label271;
      break;
      label427:
      this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.s(this.Ur, this.asj);
    }
  }
  
  public void stop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "stop random matching");
    }
    this.mApp.getHandler().removeCallbacks(this.bp);
    PopupDialog.axr();
    if (this.mStatus == 4) {
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "stop random matching is already closed!");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((this.mType == 1) || (this.mType == 2)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("RandomController", 2, "stop random matching mType is invalid!");
        return;
        if (this.e != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("RandomController", 2, "stop random matching mSessionInfo = null!");
      return;
      Object localObject = jko.a(this.mApp);
      if (localObject != null) {
        ((jko)localObject).cancelNotification(this.mSessionId);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.alM();
      if (this.mStatus == 1) {
        this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.apK();
      }
      if (this.mStatus == -3)
      {
        this.mApp.getHandler().removeCallbacks(this.bs);
        PopupDialog.axr();
      }
      this.mApp.getHandler().removeCallbacks(this.bt);
      if (this.mType == 1)
      {
        this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvRandomRandomController$RequestFetchRunnable);
        localObject = this.e.peerUin;
        if ((this.PT != null) && (this.PT.equals(localObject)))
        {
          this.jdField_a_of_type_ComTencentAvVideoController.O((String)localObject, 223);
          this.jdField_a_of_type_ComTencentAvVideoController.ko(223);
          if (this.e.ana == -1) {
            this.e.ana = 0;
          }
          this.e.Qh = true;
          this.e.PV = false;
          this.jdField_a_of_type_ComTencentAvVideoController.P((String)localObject, this.e.ana);
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Jkb != null)
        {
          this.jdField_a_of_type_Jkb.axp();
          this.jdField_a_of_type_Jkb = null;
        }
        this.mStatus = 4;
        igv.a().a().a.anA = 0;
        this.jdField_a_of_type_ComTencentAvVideoController.e(0, 0, null);
        localObject = this.mListeners.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((a)((Iterator)localObject).next()).apJ();
        }
        if (this.mType == 2)
        {
          this.mApp.getHandler().removeCallbacks(this.br);
          apF();
          this.Un = false;
          if ((this.Ur) && (this.mK != 0L))
          {
            localObject = this.mApp.getCurrentAccountUin();
            this.jdField_a_of_type_ComTencentAvRandomRandomWebProtocol.a(this.asj, 4, (String)localObject, av((String)localObject), this.mK);
          }
          this.e.a.Rw = false;
          this.jdField_a_of_type_ComTencentAvVideoController.b(this.aqx, this.mK, 90);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "stop random matching mSessionId = " + this.mSessionId);
      }
      if ((this.PT != null) && (this.PT.equals(igv.a().a().peerUin))) {
        igv.a().a().bN(0L);
      }
      igv.a().a().amG();
      igv.a().c(-1042L, this.mSessionId);
      this.e = null;
      this.mSessionId = null;
      ivv.a(0L, 4, this.mApp.getApp());
    } while (!QLog.isColorLevel());
    QLog.d("RandomController", 2, "stop random matching end");
  }
  
  public class RequestFetchRunnable
    implements Runnable
  {
    RandomWebProtocol.h a;
    
    private RequestFetchRunnable() {}
    
    public void a(RandomWebProtocol.h paramh)
    {
      this.a = paramh;
    }
    
    public void run()
    {
      if (!RandomController.this.Uq)
      {
        RandomController.a(RandomController.this).incrementAndGet();
        RandomController.a(RandomController.this).a(RandomController.b(RandomController.this), RandomController.c(RandomController.this), 2, new String[] { this.a.Qi });
        if ((RandomController.a(RandomController.this) != null) && (RandomController.a(RandomController.this).getHandler() != null)) {
          RandomController.a(RandomController.this).getHandler().removeCallbacks(RandomController.a(RandomController.this));
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void apJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.random.RandomController
 * JD-Core Version:    0.7.0.1
 */