package com.tencent.av.redpacket;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import anpc;
import aqhq;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.ui.RedPacketShareFragment;
import com.tencent.av.service.AVRedPacketConfig;
import com.tencent.av.service.AVRedPacketConfig.ExpressionInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ije;
import ijo;
import iow;
import irl;
import irl.a;
import irl.b;
import irm;
import iro;
import irr;
import irt;
import irv;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import jgu;
import jgy;
import jhr.a;
import jht;
import jht.b;
import jhz;
import jik;

public class AVRedPacketManager
  extends ijo
  implements Handler.Callback
{
  static final String Qm = BaseApplicationImpl.getContext().getFilesDir() + "/pddata/prd/expressionimg/";
  public static int asH = 1;
  public static int asI = 2;
  public static int asJ = 3;
  public static int asK = 4;
  public static int asL = 1080;
  public static int asM = 10;
  public static long mQ = 25000L;
  public static long mR = 50000L;
  public static long mS = 10000L;
  public static long mT = 5000L;
  public static long mU = 5000L;
  public static long mV = 2000L;
  public static long mW = 3000L;
  final String Qn = "https://task.qq.com/index.php/opapi/reportCollectData";
  String Qo;
  boolean UA = false;
  public volatile boolean UB;
  public GameStateInfo a;
  public a a;
  public b a;
  public irl.a a;
  public irt a;
  irv a;
  public int asN;
  int asO = 0;
  int asP = 0;
  Object aw = new Object();
  public iro b;
  public Bitmap bh;
  private WeakReference<RedPacketShareFragment> bw;
  int continuousHitCount;
  public List<irl.a> expressionList;
  public boolean isDestroyed;
  public Handler mSubHandler;
  public Handler mUiHandler;
  public irl.a normalFaceExpression;
  
  public AVRedPacketManager(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$b = new irr(this);
    this.jdField_a_of_type_Irv = new irv();
    this.mApp = paramVideoAppInterface;
    paramVideoAppInterface = jgu.a();
    VideoAppInterface localVideoAppInterface = this.mApp;
    if ((paramVideoAppInterface.azi == 1) && (!jgy.xl())) {}
    for (;;)
    {
      this.jdField_a_of_type_Irt = new irt(localVideoAppInterface, bool);
      this.jdField_a_of_type_Irt.a(this.mApp.b());
      return;
      bool = false;
    }
  }
  
  private boolean I(boolean paramBoolean)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo == null) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.isDestroy)) {
      bool = false;
    }
    if ((paramBoolean) && (QLog.isColorLevel())) {
      QLog.d("AVRedPacketManager", 2, "isCurrInfoValid, result=" + bool + ", currInfo=" + this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo);
    }
    return bool;
  }
  
  public static ArrayList<Integer> a(List<Integer> paramList, int paramInt)
  {
    int i = 0;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList(paramList);
    ArrayList localArrayList3 = new ArrayList(paramList);
    int j = paramList.size();
    Collections.shuffle(localArrayList2);
    Collections.shuffle(localArrayList3);
    while (localArrayList2.get(j - 1) == localArrayList3.get(0)) {
      Collections.shuffle(localArrayList3);
    }
    ArrayList localArrayList4 = new ArrayList();
    localArrayList4.addAll(localArrayList2);
    localArrayList4.addAll(localArrayList3);
    while (i < paramInt)
    {
      localArrayList1.add(localArrayList4.get(i));
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "getRandomList totalCount = " + paramInt + ",inputList = " + paramList + ",result = " + localArrayList1);
    }
    return localArrayList1;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    if (!I(true)) {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketManager", 2, "updateHitInfo, invalid");
      }
    }
    GameStateInfo localGameStateInfo;
    LocalFrameSyncInfo localLocalFrameSyncInfo;
    LocalHitInfo localLocalHitInfo;
    boolean bool;
    do
    {
      return;
      localGameStateInfo = this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo;
      localLocalFrameSyncInfo = localGameStateInfo.currLocalFrameSyncInfo;
      localLocalHitInfo = localLocalFrameSyncInfo.localHitInfo;
      bool = localLocalFrameSyncInfo.hasHitedEmojiIds.contains(Integer.valueOf(paramInt1));
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketManager", 2, "__debug__ updateHitInfo, id=" + paramInt1 + ",hitType=" + paramInt3 + ",hasHit=" + bool);
      }
    } while (bool);
    irm.a(paramInt1, paramInt2, paramInt3, paramFloat, this.asO, this.asP);
    paramInt2 = 0;
    localLocalHitInfo.emojiId = paramInt1;
    if (paramInt3 == 3)
    {
      localLocalHitInfo.topWordTipType = 3;
      localLocalHitInfo.newAddScore = 0;
      localGameStateInfo.curCommCnt = 0;
      localLocalHitInfo.comboCnt = localGameStateInfo.curCommCnt;
      localLocalFrameSyncInfo.curScore += localLocalHitInfo.newAddScore;
      localGameStateInfo.curScore = localLocalFrameSyncInfo.curScore;
      paramInt2 = 0;
      this.asO = 0;
      this.asP = 0;
    }
    do
    {
      if (paramInt2 != 0) {
        localLocalFrameSyncInfo.hasHitedEmojiIds.add(Integer.valueOf(paramInt1));
      }
      localLocalHitInfo.hitStartTime = NetConnInfoCenter.getServerTimeMillis();
      this.UB = false;
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketManager", 2, "updateHitInfo,set needDetectFace false; mCurentStateInfo=" + this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo);
      }
      a(true, 1010, 0L, localLocalFrameSyncInfo);
      return;
      if (paramInt3 == 2)
      {
        localLocalHitInfo.topWordTipType = 2;
        localGameStateInfo.curCommCnt += 1;
        if (localGameStateInfo.curCommCnt >= 3) {}
        for (localLocalHitInfo.newAddScore = 90;; localLocalHitInfo.newAddScore = 80)
        {
          localLocalHitInfo.comboCnt = localGameStateInfo.curCommCnt;
          localLocalFrameSyncInfo.curScore += localLocalHitInfo.newAddScore;
          localGameStateInfo.curScore = localLocalFrameSyncInfo.curScore;
          paramInt2 = 1;
          break;
        }
      }
    } while ((paramInt3 != 1) && (paramInt3 != 4));
    localLocalHitInfo.topWordTipType = paramInt3;
    localGameStateInfo.curCommCnt += 1;
    if (localGameStateInfo.curCommCnt >= 3) {
      if (localGameStateInfo.curScore + 110 >= asL) {
        localLocalHitInfo.newAddScore = 90;
      }
    }
    for (;;)
    {
      localLocalHitInfo.comboCnt = localGameStateInfo.curCommCnt;
      localLocalFrameSyncInfo.curScore += localLocalHitInfo.newAddScore;
      localGameStateInfo.curScore = localLocalFrameSyncInfo.curScore;
      paramInt2 = 1;
      break;
      localLocalHitInfo.newAddScore = 110;
      continue;
      localLocalHitInfo.newAddScore = 100;
    }
  }
  
  private void a(GameInfoFromBusiServer paramGameInfoFromBusiServer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "onGameStartSuccFromServer");
    }
    if (!I(true)) {}
    jhr.a locala;
    int j;
    do
    {
      GameStateInfo localGameStateInfo;
      do
      {
        return;
        localGameStateInfo = new GameStateInfo(paramGameInfoFromBusiServer.key, 2, paramGameInfoFromBusiServer.sendRedPacketUin, paramGameInfoFromBusiServer.receiveRedPacketUin);
        localGameStateInfo.authKey = paramGameInfoFromBusiServer.authKey;
        paramGameInfoFromBusiServer = new ArrayList();
        locala = jik.a(this.mApp).a();
      } while ((locala == null) || (locala.b == null));
      ArrayList localArrayList = a(locala.b.gameExpressionIDList, locala.b.gameExpressionCount);
      j = localArrayList.size();
      if (j == locala.b.gameExpressionCount)
      {
        int i = 0;
        while (i < j)
        {
          LocalEmojiInfo localLocalEmojiInfo = new LocalEmojiInfo();
          localLocalEmojiInfo.emojiId = i;
          localLocalEmojiInfo.emojiType = ((Integer)localArrayList.get(i)).intValue();
          localLocalEmojiInfo.isBigEmoji = false;
          localLocalEmojiInfo.fallDownDuration = ((Integer)locala.b.gameExpressionDurationList.get(i)).intValue();
          if (i == j - 1) {
            localLocalEmojiInfo.isBigEmoji = true;
          }
          paramGameInfoFromBusiServer.add(localLocalEmojiInfo);
          i += 1;
        }
        a(localGameStateInfo, paramGameInfoFromBusiServer);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AVRedPacketManager", 2, "onGameStartSuccFromServer size is not equal, size = " + j + ",ExpressionCount=" + locala.b.gameExpressionCount);
  }
  
  private void a(GameStateInfo paramGameStateInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "onGameReadySuccFromC2C");
    }
    iM(false);
    if (a(paramGameStateInfo))
    {
      this.b.apW();
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.money = paramGameStateInfo.money;
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.enterType = paramGameStateInfo.enterType;
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.updateGameState(1);
      aqh();
      jik.a(this.mApp).a().g(this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.sendRedPacketUin, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.receiveRedPacketUin, paramGameStateInfo.enterType);
      lD(1);
    }
  }
  
  private boolean a(GameStateInfo paramGameStateInfo)
  {
    if (((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo != null) && (!this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.isDestroy)) || (paramGameStateInfo == null)) {}
    for (boolean bool = false;; bool = true)
    {
      QLog.d("AVRedPacketManager", 1, "initCurrGameInfo, result=" + bool + " , currInfo=" + this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo);
      return bool;
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo = new GameStateInfo(paramGameStateInfo);
      aqg();
    }
  }
  
  public static void apY()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "deleteLocalExpressionImg");
    }
    aqhq.cn(Qm);
  }
  
  private void aqc()
  {
    QLog.d("AVRedPacketManager", 1, "preloadCountDownRes");
    ThreadManager.post(new AVRedPacketManager.2(this), 8, null, true);
  }
  
  private void aqe()
  {
    QLog.d("AVRedPacketManager", 1, "cleartStateInfo");
    if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo != null) {
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.isDestroy = true;
    }
  }
  
  private void aqf()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "removeTimeOutMsg");
    }
    lz(1018);
    lz(1011);
    lz(1012);
    lz(1015);
    lz(1016);
    lz(1021);
    lz(1022);
    lz(1023);
  }
  
  private void aqg()
  {
    jhr.a locala = jik.a(this.mApp).a();
    if ((locala != null) && (locala.b != null))
    {
      mR = locala.b.game321MaxTimeOut;
      mQ = locala.b.gameSendRedBagMaxTimeOut;
      asL = locala.b.gameMaxScore;
      asM = locala.b.gameExpressionCount;
      mW = locala.b.tipsTimeout;
    }
    QLog.d("AVRedPacketManager", 1, "initConfigValue, MAX_GAME_TIMEOUT=" + mR + ",COUNTDOWN_TIMEOUT=" + mQ + ",MAX_GAME_SCORE=" + asL + ",MAX_EMOJI_CNT=" + asM + ",MAX_EMOJI_TIPS_TIME=" + mW + ",saveSwitch = " + false);
  }
  
  private void aqh()
  {
    QLog.d("AVRedPacketManager", 1, "updateFrameInfoState");
    if ((!I(false)) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState == 1)
      {
        this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo.frameSyncGameState = 1;
        return;
      }
      if ((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState == 2) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState == 3))
      {
        this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo.frameSyncGameState = 3;
        return;
      }
    } while (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState != 4);
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo.frameSyncGameState = 4;
  }
  
  public static int cs(int paramInt)
  {
    int i = -1;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketManager", 2, "getMirrorEmojiType, inputType = " + paramInt + ",result = " + i);
      }
      return i;
      i = 0;
      continue;
      i = 1;
      continue;
      i = 3;
      continue;
      i = 2;
      continue;
      i = 5;
      continue;
      i = 4;
      continue;
      i = 7;
      continue;
      i = 6;
      continue;
      i = 8;
      continue;
      i = 9;
    }
  }
  
  private void ly(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "initMusicPlayer ,bgMusicIndex = " + paramInt);
    }
    jhr.a locala = jik.a(this.mApp).a();
    if (!locala.Zp)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketManager", 2, "initMusicPlayer failed,config not ready");
      }
      return;
    }
    this.jdField_a_of_type_Irt.a(paramInt, locala);
  }
  
  private boolean vs()
  {
    boolean bool = true;
    if (ije.a(this.mApp) == null) {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "checkViedoHandler, result=" + bool);
    }
    return bool;
  }
  
  public void A(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void C(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Irt.C(paramInt, paramBoolean);
  }
  
  public Bitmap J()
  {
    return this.bh;
  }
  
  public GameStateInfo a()
  {
    return this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo;
  }
  
  public LocalEmojiInfo a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "addDisplayedEmoji, id=" + paramInt1 + ",eventType=" + paramInt2 + ",mCurentStateInfo=" + this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo + ",needDetectFace=" + this.UB + ",msfTime = " + NetConnInfoCenter.getServerTimeMillis());
    }
    Object localObject;
    if ((!I(true)) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketManager", 2, "addDisplayedEmoji, mCurentStateInfo is null OR MODE_SEND_REDPACKET");
      }
      localObject = null;
    }
    LocalEmojiInfo localLocalEmojiInfo;
    do
    {
      do
      {
        do
        {
          return localObject;
          localObject = this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo;
          localLocalEmojiInfo = new LocalEmojiInfo();
          localLocalEmojiInfo.emojiId = paramInt1;
          localLocalEmojiInfo.emojiType = paramInt4;
          localLocalEmojiInfo.startTime = paramLong;
          localLocalEmojiInfo.eventType = 1;
          localLocalEmojiInfo.trackNum = paramInt3;
          localLocalEmojiInfo.isBigEmoji = paramBoolean;
          ((LocalFrameSyncInfo)localObject).localEmojiInfos.add(localLocalEmojiInfo);
          paramLong = NetConnInfoCenter.getServerTimeMillis();
          localObject = localLocalEmojiInfo;
        } while (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.hasEmojiTip);
        localObject = localLocalEmojiInfo;
      } while (Math.abs(paramLong - this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameStartTime) < mW);
      localObject = localLocalEmojiInfo;
    } while (!this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo.hasHitedEmojiIds.isEmpty());
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.hasEmojiTip = true;
    a(true, 1005, 0L, null);
    return localLocalEmojiInfo;
  }
  
  public void a(int paramInt1, long paramLong1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, long paramLong2)
  {
    if (!I(false)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "addDisplayedEmojiInfoDelay emojiId = " + paramInt1 + ",startTime = " + paramLong1 + ",eventType = " + paramInt2 + ",trackNum = " + paramInt3 + ",emojiType = " + paramInt4 + ",isBigEmoji = " + paramBoolean + ",delay = " + paramLong2);
    }
    a(false, 1013, paramLong2, new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean) });
  }
  
  public void a(int paramInt, LocalEmojiInfo paramLocalEmojiInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "updateFocus, id=" + paramInt);
    }
    if ((!I(true)) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketManager", 2, "updateFocus, mCurentStateInfo is null OR MODE_SEND_REDPACKET");
      }
      return;
    }
    LocalFocusInfo localLocalFocusInfo = this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo.localFocusInfo;
    localLocalFocusInfo.emojiId = paramInt;
    localLocalFocusInfo.mLocalEmojiInfo = paramLocalEmojiInfo;
  }
  
  public void a(GameStateInfo paramGameStateInfo, List<LocalEmojiInfo> paramList)
  {
    QLog.d("AVRedPacketManager", 1, "preStartGame");
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "__debug__ localEmojiInfos=" + paramList);
    }
    if (!I(true)) {
      return;
    }
    if ((paramGameStateInfo != null) && (!TextUtils.isEmpty(paramGameStateInfo.authKey))) {
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.authKey = paramGameStateInfo.authKey;
    }
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.configEmojiInfos = paramList;
    a(true, 1020, 0L, null);
  }
  
  public void a(LocalEmojiInfo paramLocalEmojiInfo, float paramFloat, AVRedPacketConfig.ExpressionInfo paramExpressionInfo, int paramInt)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "onEmojiRecognise, id=" + paramLocalEmojiInfo.emojiId + ",score=" + paramFloat + ",emojiType=" + paramLocalEmojiInfo.emojiType + ",continuousHitCount = " + this.continuousHitCount + ",continuousHitThreshold = " + paramInt);
    }
    if (paramFloat >= paramExpressionInfo.coolValue)
    {
      this.continuousHitCount += 1;
      if (this.continuousHitCount >= paramInt)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AVRedPacketManager", 2, "onEmojiRecognise, id=" + paramLocalEmojiInfo.emojiId + ",score=" + paramFloat + ",emojiType=" + paramLocalEmojiInfo.emojiType + ",really hit");
        }
        this.continuousHitCount = 0;
        if (paramFloat < paramExpressionInfo.perfectValue) {
          break label231;
        }
        if (!paramLocalEmojiInfo.isBigEmoji) {
          break label225;
        }
        paramInt = 4;
      }
    }
    for (;;)
    {
      if (paramInt != 3) {
        a(paramLocalEmojiInfo.emojiId, paramLocalEmojiInfo.emojiType, paramInt, paramFloat);
      }
      label225:
      label231:
      do
      {
        return;
        paramInt = 1;
        break;
        if (paramFloat < paramExpressionInfo.coolValue) {
          break label332;
        }
        paramInt = i;
        if (!paramLocalEmojiInfo.isBigEmoji) {
          break;
        }
        paramInt = 3;
        break;
        this.continuousHitCount = 0;
        if ((paramFloat < paramExpressionInfo.coolValue) && (paramFloat >= paramExpressionInfo.coolValue - 5))
        {
          this.asO += 1;
          return;
        }
      } while ((paramFloat >= paramExpressionInfo.coolValue - 5) || (paramFloat <= paramExpressionInfo.coolValue - 10));
      this.asP += 1;
      return;
      label332:
      paramInt = 3;
    }
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a = parama;
    if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a == null) {}
  }
  
  public void a(RedPacketShareFragment paramRedPacketShareFragment)
  {
    this.bw = new WeakReference(paramRedPacketShareFragment);
  }
  
  public void a(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "raymond detectFaceExpression");
    }
    if ((!I(false)) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo == null)) {}
    Object localObject;
    int i;
    irl.b localb;
    float f1;
    jhr.a locala;
    do
    {
      do
      {
        do
        {
          return;
          localObject = this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo.localFocusInfo;
          i = ((LocalFocusInfo)localObject).emojiId;
          localObject = ((LocalFocusInfo)localObject).mLocalEmojiInfo;
          if (localObject != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("AVRedPacketManager", 2, "detectFaceExpression, emojiInfo is null, focusId=" + i);
        return;
        if ((this.expressionList != null) && (this.expressionList.size() > 0)) {
          this.jdField_a_of_type_Irl$a = ((irl.a)this.expressionList.get(cs(((LocalEmojiInfo)localObject).emojiType)));
        }
        if (QLog.isColorLevel()) {
          QLog.d("AVRedPacketManager", 2, "detectFaceExpression, targetExpression=" + this.jdField_a_of_type_Irl$a.expressionID + ",emojiType=" + ((LocalEmojiInfo)localObject).emojiType);
        }
      } while ((paramList == null) || (paramArrayOfFloat == null) || (this.jdField_a_of_type_Irl$a == null) || (this.jdField_a_of_type_Irl$a.expressionFeat == null) || (this.jdField_a_of_type_Irl$a.expressionAngle == null) || (this.jdField_a_of_type_Irl$a.expressionWeight == null));
      localb = irl.a(this.jdField_a_of_type_Irl$a, paramList, irl.a(paramArrayOfFloat));
      f1 = localb.score;
      locala = jik.a(this.mApp).a();
      if ((I(false)) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode != 1) && (locala != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AVRedPacketManager", 2, "detectFaceExpression, invalid parame");
    return;
    AVRedPacketConfig.ExpressionInfo localExpressionInfo = (AVRedPacketConfig.ExpressionInfo)locala.b.expressionInfoList.get(((LocalEmojiInfo)localObject).emojiType);
    if ((f1 > localExpressionInfo.coolValue) && (this.normalFaceExpression != null)) {
      if ((locala.b.checkEyeOpenClose) && (this.jdField_a_of_type_Irl$a.expressionWeight[0] > 0.0D) && (this.jdField_a_of_type_Irl$a.expressionWeight[1] > 0.0D) && (!irl.a(localb)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AVRedPacketManager", 2, "detectFaceExpression, invalid EyeOpenClose,reset score");
        }
        irm.lw(1);
        f1 = 0.0F;
        f2 = f1;
        if (locala.b.checkNormalFaceExpression)
        {
          f2 = f1;
          if (irl.a(localb.score, this.jdField_a_of_type_Irl$a.expressionWeight, this.jdField_a_of_type_Irl$a.cB, this.normalFaceExpression, paramList, irl.a(paramArrayOfFloat)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("AVRedPacketManager", 2, "detectFaceExpression, is normalFaceExpression,reset score");
            }
            irm.lw(2);
          }
        }
      }
    }
    for (float f2 = 0.0F;; f2 = f1)
    {
      int j = locala.b.continuousHitCount;
      i = j;
      if (j < 1) {
        i = 1;
      }
      a((LocalEmojiInfo)localObject, f2, localExpressionInfo, i);
      return;
      break;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, Object paramObject)
  {
    if (!this.isDestroyed) {
      try
      {
        if (!this.isDestroyed) {
          if (!paramBoolean) {
            break label98;
          }
        }
        label98:
        for (Handler localHandler = this.mUiHandler;; localHandler = this.mSubHandler)
        {
          localHandler.sendMessageDelayed(Message.obtain(localHandler, paramInt, 0, 0, paramObject), paramLong);
          if (QLog.isColorLevel()) {
            QLog.d("AVRedPacketManager", 2, "sendMessage, ui=" + paramBoolean + ",msg=" + paramInt + ",delay=" + paramLong);
          }
          return;
        }
        return;
      }
      finally {}
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, GameInfoFromBusiServer paramGameInfoFromBusiServer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "onGetGameinfoFromBusiServer, isSuccess=" + paramBoolean + ",actionType=" + paramInt + ",gameInfo=" + paramGameInfoFromBusiServer + ",mCurentStateInfo=" + this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo);
    }
    if (paramBoolean) {
      if (paramInt == 1) {
        a(paramGameInfoFromBusiServer);
      }
    }
    do
    {
      do
      {
        return;
      } while ((paramInt != 3) || (!I(true)));
      jik.a(this.mApp).a().a(paramGameInfoFromBusiServer.sendRedPacketUin, paramGameInfoFromBusiServer.receiveRedPacketUin, paramGameInfoFromBusiServer.key, paramGameInfoFromBusiServer.authKey, paramGameInfoFromBusiServer.currScores, asL, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo.hasHitedEmojiIds.size(), asM, String.valueOf(paramGameInfoFromBusiServer.winMoney), "0", "", true, 0);
      iM(false);
      return;
      if (paramInt == 1)
      {
        lE(4);
        return;
      }
    } while (paramInt != 3);
    lE(5);
  }
  
  public void a(boolean paramBoolean, LocalFrameSyncInfo paramLocalFrameSyncInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "onGetGameinfoFromFrmeInfo, isSuccess=" + paramBoolean + ",frameSyncInfo=" + paramLocalFrameSyncInfo);
    }
    if ((paramBoolean) && (I(false)) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1)) {
      if ((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState == 3) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState == 2))
      {
        a(true, 1006, 0L, paramLocalFrameSyncInfo);
        if ((paramLocalFrameSyncInfo == null) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo == null) || (paramLocalFrameSyncInfo.seq != this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo.seq)) {
          break label170;
        }
        if ((!hasMessages(1023)) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.kazhenTipCnt < 1)) {
          a(false, 1023, mU, null);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo = paramLocalFrameSyncInfo;
      return;
      label170:
      lz(1023);
    }
  }
  
  public void apZ()
  {
    QLog.d("AVRedPacketManager", 1, "onRedPacketCome");
    if (!I(true)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.mRedPacketComeStartTime = System.currentTimeMillis();
    a(true, 1009, 0L, null);
    a(false, 1012, mR + 10000L, null);
  }
  
  public void aqa()
  {
    QLog.d("AVRedPacketManager", 1, "onShowUserGuideForReceiver");
    if (!I(true)) {
      return;
    }
    jik.s(this.mApp);
    a(true, 1027, 0L, null);
  }
  
  public void aqb()
  {
    QLog.d("AVRedPacketManager", 1, "quitGame");
    if (!I(true)) {
      return;
    }
    c(3, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.key, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.sendRedPacketUin, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.curScore, "0");
    iM(true);
  }
  
  public void aqd()
  {
    QLog.d("AVRedPacketManager", 1, "setGameReadyCountDownFinish");
    if (!I(true)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.updateGameState(3);
    aqh();
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameStartTime = NetConnInfoCenter.getServerTimeMillis();
    a(true, 1003, 0L, Integer.valueOf(this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode));
  }
  
  public void b(boolean paramBoolean, String paramString, int paramInt)
  {
    QLog.d("AVRedPacketManager", 1, "onSendRedPacketResult, isSucc=" + paramBoolean + ",key=" + paramString + ",fromType=" + paramInt);
    if (paramBoolean)
    {
      iM(false);
      if (vs())
      {
        paramString = new GameStateInfo(paramString, 1, this.mApp.getCurrentAccountUin(), jik.ay());
        if (a(paramString))
        {
          this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.updateGameState(1);
          this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.enterType = paramInt;
          jik.a(this.mApp).a().g(this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.sendRedPacketUin, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.receiveRedPacketUin, paramInt);
          a(true, 1008, 0L, paramString);
          this.asN = lz();
          a(true, 1020, 0L, null);
        }
      }
      anpc.a(BaseApplication.getContext()).collectPerformance(this.mApp.getCurrentAccountUin(), "avRedPacketSendRedSuc", true, 0L, 0L, null, "");
    }
  }
  
  public void bN(int paramInt1, int paramInt2)
  {
    if ((I(false)) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1) && ((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState == 3) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState == 2))) {
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.syncSuccEmojiId.add(Integer.valueOf(paramInt1));
    }
  }
  
  public void bb(String paramString1, String paramString2)
  {
    QLog.d("AVRedPacketManager", 2, "onBigSmallSwitched, uinBig= " + paramString1 + ",uinSmall=" + paramString2);
    if (!I(true)) {}
    while (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode != 1) {
      return;
    }
  }
  
  public void c(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    QLog.d("AVRedPacketManager", 1, "syncGameInfoToBusiServer, actionType=" + paramInt1 + ",fromUin=" + paramString2 + ",key=" + paramString1 + ",currScores=" + paramInt2 + ",totalMoney=" + paramString3);
    lz(1018);
    if ((!I(false)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key", paramString1);
    localBundle.putString("fromUin", paramString2);
    localBundle.putString("toUin", this.mApp.getCurrentAccountUin());
    localBundle.putInt("currScores", paramInt2);
    localBundle.putString("totalMoney", paramString3);
    this.b.f(paramInt1, localBundle);
  }
  
  public void c(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    QLog.d("AVRedPacketManager", 1, "onGetGrapRedPacketResult, redPacketId: " + paramString1);
    Bundle localBundle = new Bundle();
    localBundle.putString("key", paramString1);
    localBundle.putInt("gameState", 5);
    localBundle.putInt("fromWho", 2);
    localBundle.putString("money", paramString2);
    localBundle.putInt("resultCode", Integer.parseInt(paramString3));
    localBundle.putString("resultState", paramString4);
    localBundle.putInt("hitScore", paramInt);
    g(1, localBundle);
  }
  
  public boolean cs(int paramInt)
  {
    boolean bool1 = true;
    boolean bool2;
    if ((!I(false)) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.hasScreenShotCnt >= 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketManager", 2, "isNeedScreenShot, return false");
      }
      bool2 = false;
      return bool2;
    }
    Object localObject = jik.a(this.mApp).a();
    if ((localObject != null) && (((jhr.a)localObject).b != null) && (((jhr.a)localObject).b.shareExpressionIDList != null) && (((jhr.a)localObject).b.shareExpressionIDList.contains(Integer.valueOf(paramInt)))) {
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.hasScreenShotCnt = 2;
    }
    for (;;)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AVRedPacketManager", 2, "isNeedScreenShot, emojiTypeID =" + paramInt + ",result=" + bool1);
      return bool1;
      if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.hasScreenShotCnt == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo;
        ((GameStateInfo)localObject).hasScreenShotCnt += 1;
      }
      else
      {
        bool1 = false;
      }
    }
  }
  
  public boolean cs(String paramString)
  {
    return false;
  }
  
  public Bitmap d(String paramString, boolean paramBoolean)
  {
    return jik.e(paramString, paramBoolean);
  }
  
  public void g(int paramInt, Bundle paramBundle)
  {
    QLog.d("AVRedPacketManager", 1, "sendC2CMsgGameInfo, subType: " + paramInt + ",bundle:" + paramBundle);
    this.b.g(paramInt, paramBundle);
  }
  
  public void h(Bitmap paramBitmap)
  {
    this.bh = paramBitmap;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "handleMessage, msg.what=" + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    default: 
    case 1010: 
    case 1008: 
    case 1009: 
    case 1002: 
    case 1003: 
    case 1004: 
    case 1006: 
    case 1005: 
    case 1007: 
    case 1017: 
    case 1024: 
    case 1025: 
    case 1011: 
    case 1012: 
    case 1013: 
    case 1014: 
    case 1015: 
    case 1016: 
    case 1018: 
    case 1019: 
    case 1020: 
    case 1021: 
    case 1022: 
    case 1023: 
    case 1026: 
    case 1027: 
      do
      {
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
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                return false;
                              } while ((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a == null) || (!I(false)));
                              this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a.a((LocalFrameSyncInfo)paramMessage.obj);
                              return false;
                            } while (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a == null);
                            this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a.apR();
                            return false;
                          } while (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a == null);
                          this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a.apS();
                          return false;
                          if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a != null)
                          {
                            paramMessage = (Object[])paramMessage.obj;
                            i = ((Integer)paramMessage[0]).intValue();
                            paramMessage = (List)paramMessage[1];
                            this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a.g(i, paramMessage);
                          }
                        } while ((this.bw == null) || (this.bw.get() == null));
                        ((RedPacketShareFragment)this.bw.get()).aqx();
                        return false;
                      } while (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a == null);
                      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a.lx(((Integer)paramMessage.obj).intValue());
                      return false;
                    } while (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a == null);
                    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a.apO();
                    return false;
                  } while ((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a == null) || (!I(false)));
                  this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a.b((LocalFrameSyncInfo)paramMessage.obj);
                  return false;
                } while (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a == null);
                this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a.apP();
                return false;
                paramMessage = (Object[])paramMessage.obj;
                i = ((Integer)paramMessage[0]).intValue();
                bool = ((Boolean)paramMessage[1]).booleanValue();
                ((Integer)paramMessage[2]).intValue();
              } while (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a == null);
              this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a.B(i, bool);
              return false;
              lE(1);
              return false;
              lE(2);
              return false;
              paramMessage = (Object[])paramMessage.obj;
              int i = ((Integer)paramMessage[0]).intValue();
              long l = ((Long)paramMessage[1]).longValue();
              int j = ((Integer)paramMessage[2]).intValue();
              int k = ((Integer)paramMessage[3]).intValue();
              int m = ((Integer)paramMessage[4]).intValue();
              paramMessage = a(i, l, j, k, m, ((Boolean)paramMessage[5]).booleanValue());
              if (QLog.isColorLevel()) {
                QLog.d("AVRedPacketManager", 2, "__debug__ updateFocus, emojiId =" + i + " , emojiType=" + m);
              }
              a(i, paramMessage);
              return false;
            } while (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a == null);
            this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a.iL(((Boolean)paramMessage.obj).booleanValue());
            return false;
            lE(8);
            return false;
            lE(9);
            return false;
          } while (!((Boolean)paramMessage.obj).booleanValue());
          c(3, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.key, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.sendRedPacketUin, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.curScore, "0");
          return false;
          paramMessage = (Object[])paramMessage.obj;
          if (QLog.isColorLevel()) {
            QLog.d("AVRedPacketManager", 1, "WL_DEBUG MSG_WHAT_FLOATWINDOW_ANIMATION");
          }
          this.mApp.l(new Object[] { Integer.valueOf(517), paramMessage[0], paramMessage[1] });
          return false;
        } while (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a == null);
        this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a.vp();
        aqc();
        return false;
        lE(11);
        return false;
        lE(12);
        return false;
        lE(13);
        return false;
        startGame();
        return false;
      } while (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a == null);
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$a.apU();
      return false;
    }
    aqa();
    return false;
  }
  
  boolean hasMessages(int paramInt)
  {
    boolean bool = false;
    if (!this.isDestroyed) {
      for (;;)
      {
        try
        {
          if (!this.isDestroyed)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AVRedPacketManager", 2, "hasMessage, msg=" + paramInt);
            }
            if ((!this.mUiHandler.hasMessages(paramInt)) && (!this.mSubHandler.hasMessages(paramInt))) {
              return bool;
            }
          }
          else
          {
            return false;
          }
        }
        finally {}
        bool = true;
      }
    }
    return false;
  }
  
  public void iM(boolean paramBoolean)
  {
    QLog.d("AVRedPacketManager", 1, "setGameFinish, onlyClearUi=" + paramBoolean);
    if (!paramBoolean) {
      aqf();
    }
    if (!I(true)) {
      return;
    }
    a(true, 1004, 0L, null);
    if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1) {
      a(true, 1019, 0L, new Object[] { Boolean.valueOf(true), Boolean.valueOf(false) });
    }
    if (!paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.updateGameState(4);
      aqh();
      this.UB = false;
      this.b.apX();
      aqe();
    }
    try
    {
      this.jdField_a_of_type_Irt.lF(7);
      this.jdField_a_of_type_Irt.release();
      return;
    }
    catch (Exception localException)
    {
      QLog.d("AVRedPacketManager", 1, "setGameFinish exception", localException);
    }
  }
  
  public void iN(boolean paramBoolean)
  {
    QLog.d("AVRedPacketManager", 1, "onFloatWindowSwitched, changeToBig= " + paramBoolean);
    if (!I(true)) {}
    label123:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!paramBoolean) {
              break label123;
            }
            if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode != 2) {
              break;
            }
          } while ((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState != 1) || (!hasMessages(1015)));
          lz(1015);
          lD(2);
          return;
        } while ((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode != 1) || ((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState != 2) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState != 3)));
        lE(3);
        return;
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode != 2) {
          break;
        }
      } while ((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState != 2) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState != 3));
      lE(3);
      return;
    } while ((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode != 1) || ((this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState != 2) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameState != 3)));
    try
    {
      this.jdField_a_of_type_Irt.lF(7);
      a(true, 1019, 0L, new Object[] { Boolean.valueOf(true), Boolean.valueOf(true) });
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("AVRedPacketManager", 1, "setGameFinish exception", localException);
      }
    }
  }
  
  public void lA(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "doOnGetC2CMsgTip, type=" + paramInt);
    }
    if ((!I(true)) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode != 1)) {}
    do
    {
      return;
      if (paramInt == 2)
      {
        a(true, 1007, 0L, new Object[] { Integer.valueOf(asH), Boolean.valueOf(true), Integer.valueOf(10000) });
        lz(1021);
        return;
      }
    } while (paramInt != 3);
    a(true, 1017, 0L, new Object[] { Integer.valueOf(asI), Boolean.valueOf(true), Integer.valueOf(10000) });
    lz(1021);
  }
  
  public void lB(int paramInt)
  {
    QLog.d("AVRedPacketManager", 1, "doOnExceptionFromPeer, exceptionType=" + paramInt);
    if ((!I(true)) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode != 1)) {
      return;
    }
    jik.a(this.mApp).a().a(this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.sendRedPacketUin, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.receiveRedPacketUin, "", "", 0, 0, 0, asL, "0", "0", "", false, paramInt);
    iM(false);
  }
  
  public void lC(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "removeEmojiInfo, id=" + paramInt + ",needDetectFace=" + this.UB + ",msfTime = " + NetConnInfoCenter.getServerTimeMillis());
    }
    if ((!I(true)) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketManager", 2, "removeEmojiInfo, mCurentStateInfo is null OR MODE_SEND_REDPACKET");
      }
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.configEmojiInfos.iterator();
    Object localObject2;
    int j;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (LocalEmojiInfo)((Iterator)localObject1).next();
        if (((LocalEmojiInfo)localObject2).emojiId == paramInt)
        {
          j = ((LocalEmojiInfo)localObject2).emojiType;
          i = j;
          if (QLog.isColorLevel()) {
            QLog.d("AVRedPacketManager", 2, "__debug__ removeEmojiInfo, emojiId = " + paramInt + ",testEmojiType = " + j);
          }
        }
      }
    }
    for (int i = j;; i = -1)
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo;
      localObject2 = ((GameStateInfo)localObject1).currLocalFrameSyncInfo;
      LocalEmojiInfo localLocalEmojiInfo = new LocalEmojiInfo();
      localLocalEmojiInfo.emojiId = paramInt;
      ((LocalFrameSyncInfo)localObject2).localEmojiInfos.remove(localLocalEmojiInfo);
      if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AVRedPacketManager", 2, "__debug__ removeEmojiInfo,needDetectFace set false, emojiId = " + paramInt + ",testEmojiType = " + i);
        }
        this.UB = false;
      }
      if (!((LocalFrameSyncInfo)localObject2).hasHitedEmojiIds.contains(Integer.valueOf(paramInt))) {
        a(paramInt, i, 3, -1.0F);
      }
      if ((((GameStateInfo)localObject1).configEmojiInfos != null) && (!((GameStateInfo)localObject1).configEmojiInfos.isEmpty()))
      {
        if (((LocalEmojiInfo)((GameStateInfo)localObject1).configEmojiInfos.get(((GameStateInfo)localObject1).configEmojiInfos.size() - 1)).emojiId != paramInt) {
          break label513;
        }
        paramInt = 1;
      }
      for (;;)
      {
        if ((paramInt != 0) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 2))
        {
          a(false, 1018, 1500L, Boolean.valueOf(true));
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("succRate", String.format("%.2f", new Object[] { Float.valueOf(this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.syncSuccEmojiId.size() * 1.0F / asM) }));
          anpc.a(BaseApplication.getContext()).collectPerformance(this.mApp.getCurrentAccountUin(), "avRedPacketEmojiSyncSuccRate", true, 0L, 0L, (HashMap)localObject1, "");
          return;
          paramInt = 1;
        }
        else
        {
          c(2, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.key, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.sendRedPacketUin, ((GameStateInfo)localObject1).curScore, "0");
          return;
          label513:
          paramInt = 0;
        }
      }
    }
  }
  
  public void lD(int paramInt)
  {
    QLog.d("AVRedPacketManager", 1, "checkRedPacketConditionState, isOpen= " + paramInt);
    if (!I(false)) {}
    do
    {
      return;
      if (paramInt == 1)
      {
        if (jik.l(this.mApp))
        {
          lD(2);
          return;
        }
        QLog.d("AVRedPacketManager", 1, "checkRedPacketConditionState, AVActivity not resume");
        a(false, 1015, 10000L, null);
        a(true, 1019, 0L, new Object[] { Boolean.valueOf(false), Boolean.valueOf(true) });
        g(3, null);
        return;
      }
    } while (paramInt != 2);
    if (jik.j(this.mApp)) {
      c(1, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.key, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.sendRedPacketUin, 0, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.money);
    }
    for (;;)
    {
      apZ();
      return;
      QLog.d("AVRedPacketManager", 1, "checkRedPacketConditionState, camera close");
      a(true, 1007, 0L, new Object[] { Integer.valueOf(asH), Boolean.valueOf(true), Integer.valueOf(10000) });
      a(false, 1016, 10000L, null);
      g(2, null);
    }
  }
  
  public void lE(int paramInt)
  {
    QLog.d("AVRedPacketManager", 1, "doOnLocalException, exception= " + paramInt);
    if (!I(true)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo;
    int j = this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo.frameSyncGameState;
    boolean bool1;
    int i;
    boolean bool2;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode != 1) {
        break label921;
      }
      a(false, 1022, mT, null);
      bool1 = false;
      i = 0;
      bool2 = false;
    }
    for (;;)
    {
      if (bool2)
      {
        jik.a(this.mApp).a().a(((GameStateInfo)localObject).sendRedPacketUin, ((GameStateInfo)localObject).receiveRedPacketUin, "", "", 0, asL, 0, asM, "0", "0", "", false, i);
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 2)
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("param_FailCode", Integer.toString(paramInt));
          anpc.a(BaseApplication.getContext()).collectPerformance(this.mApp.getCurrentAccountUin(), "avRedPacketLocalExp", false, 0L, 0L, (HashMap)localObject, "");
        }
      }
      if (bool1)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("alertExceptionType", i);
        g(4, (Bundle)localObject);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AVRedPacketManager", 2, "doOnLocalException, callGameEnd= " + bool2 + ",sendException=" + bool1 + ",alertExceptionType=" + i + ",frameSyncGameState=" + j);
      return;
      if ((paramInt == 4) || (paramInt == 6))
      {
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1)
        {
          iM(false);
          bool1 = false;
          i = 5;
          bool2 = true;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 2)
        {
          iM(false);
          bool1 = true;
          i = 3;
          bool2 = true;
        }
      }
      else if (paramInt == 2)
      {
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1)
        {
          iM(false);
          bool1 = false;
          i = 7;
          bool2 = true;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 2)
        {
          iM(false);
          bool1 = true;
          i = 4;
          bool2 = true;
        }
      }
      else if ((paramInt == 5) || (paramInt == 7))
      {
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1)
        {
          iM(false);
          bool1 = false;
          i = 4;
          bool2 = true;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 2)
        {
          iM(false);
          bool1 = true;
          i = 4;
          bool2 = true;
        }
      }
      else if (paramInt == 8)
      {
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 2)
        {
          iM(false);
          a(true, 1019, 0L, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
          bool1 = true;
          i = 1;
          bool2 = true;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1)
        {
          bool1 = false;
          i = 0;
          bool2 = false;
        }
      }
      else if (paramInt == 9)
      {
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 2)
        {
          iM(false);
          bool1 = true;
          i = 2;
          bool2 = true;
        }
      }
      else if (paramInt == 3)
      {
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1)
        {
          bool1 = false;
          i = 0;
          bool2 = false;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 2)
        {
          c(3, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.key, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.sendRedPacketUin, this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.curScore, "0");
          iM(true);
          bool1 = false;
          i = 0;
          bool2 = false;
        }
      }
      else if (paramInt == 11)
      {
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1)
        {
          if (j == 0)
          {
            iM(false);
            bool1 = false;
            i = 6;
            bool2 = true;
            continue;
          }
          bool1 = false;
          i = 0;
          bool2 = false;
        }
      }
      else if (paramInt == 12)
      {
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1)
        {
          if (j == 3)
          {
            a(true, 1024, 0L, new Object[] { Integer.valueOf(asJ), Boolean.valueOf(true), Integer.valueOf(5000) });
            a(false, 1012, mR, null);
            bool1 = false;
          }
          for (i = 0;; i = 3)
          {
            boolean bool3 = false;
            bool2 = bool1;
            bool1 = bool3;
            break;
            iM(false);
            bool1 = true;
          }
        }
      }
      else if (paramInt == 13)
      {
        if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 1)
        {
          GameStateInfo localGameStateInfo = this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo;
          localGameStateInfo.kazhenTipCnt += 1;
          a(true, 1025, 0L, new Object[] { Integer.valueOf(asK), Boolean.valueOf(true), Integer.valueOf(5000) });
        }
        bool1 = false;
        i = 0;
        bool2 = false;
        continue;
      }
      label921:
      bool1 = false;
      i = 0;
      bool2 = false;
    }
  }
  
  public int lz()
  {
    int j = -1;
    Object localObject = jik.a(this.mApp).a();
    int i = j;
    if (((jhr.a)localObject).Zp)
    {
      localObject = new File(((jhr.a)localObject).RY).listFiles();
      i = j;
      if (localObject != null)
      {
        i = j;
        if (localObject.length > 0)
        {
          ArrayList localArrayList = new ArrayList();
          j = localObject.length;
          i = 0;
          while (i < j)
          {
            String str = localObject[i].getName();
            if ((str.startsWith("background")) && (str.endsWith(".mp3"))) {
              localArrayList.add(str);
            }
            i += 1;
          }
          i = (int)(Math.random() * localArrayList.size());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "generateBgMusicIndex, result =" + i);
    }
    return i;
  }
  
  void lz(int paramInt)
  {
    if (!this.isDestroyed) {
      try
      {
        if (!this.isDestroyed)
        {
          this.mUiHandler.removeMessages(paramInt);
          this.mSubHandler.removeMessages(paramInt);
          if (QLog.isColorLevel()) {
            QLog.d("AVRedPacketManager", 2, "removeMessage, ,msg=" + paramInt);
          }
        }
        return;
      }
      finally {}
    }
  }
  
  public void m(boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("AVRedPacketManager", 1, "onGetC2CMsgGameInfo, isSuccess=" + paramBoolean + ",data=" + paramBundle);
    String str2 = paramBundle.getString("key", "");
    int i = paramBundle.getInt("gameState", 0);
    String str3 = paramBundle.getString("peerUin", "0");
    int j = paramBundle.getInt("fromWho", 0);
    String str1 = paramBundle.getString("money", "0");
    int k = paramBundle.getInt("resultCode", 0);
    String str4 = paramBundle.getString("resultState", "");
    int m = paramBundle.getInt("musicId", 0);
    int n = paramBundle.getInt("hitScore", 0);
    int i1 = paramBundle.getInt("enterType", 0);
    int i2 = paramBundle.getInt("maxScore", 0);
    int i3 = paramBundle.getInt("totalEmojiNum", 0);
    if (paramBoolean) {
      if (i == 1) {
        if (j == 1)
        {
          paramBundle = new GameStateInfo(str2, 2, str3, this.mApp.getCurrentAccountUin());
          paramBundle.money = str1;
          paramBundle.enterType = i1;
          this.asN = m;
          a(paramBundle);
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
          if (i != 2) {
            break;
          }
        } while (j != 2);
        asM = i3;
        asL = i2;
        startGame();
        return;
      } while ((i != 5) || (j != 2) || (!I(true)));
      jik.a(this.mApp).a().a(this.mApp.getCurrentAccountUin(), str3, "", "", n, asL, 0, 0, str1 + "", "" + k, str4, true, 0);
      iM(false);
      return;
      if ((i == 1) || (i == 2))
      {
        lE(6);
        return;
      }
    } while (i != 5);
    lE(7);
  }
  
  public Bitmap o(String paramString)
  {
    return jik.e(paramString, true);
  }
  
  public void onCreate()
  {
    this.b = ((iro)this.mApp.getBusinessHandler(2));
    this.mSubHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.mUiHandler = new Handler(Looper.getMainLooper(), this);
    apY();
  }
  
  public void startGame()
  {
    QLog.d("AVRedPacketManager", 1, "startGame");
    aqf();
    if (!I(true)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode == 2)
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("key", this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.key);
      ((Bundle)localObject1).putInt("gameState", 2);
      ((Bundle)localObject1).putInt("fromWho", 2);
      ((Bundle)localObject1).putInt("maxScore", asL);
      ((Bundle)localObject1).putInt("totalEmojiNum", asM);
      g(1, (Bundle)localObject1);
      boolean bool = iow.va();
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketManager", 2, "startGame, isSoReady = " + bool);
      }
      this.Qo = (System.currentTimeMillis() + "");
    }
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.updateGameState(2);
    aqh();
    Object localObject1 = jik.a(this.mApp).a();
    if (this.expressionList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketManager", 2, "startGame, init expressionList");
      }
      if (((jhr.a)localObject1).Zp)
      {
        Object localObject2 = ((jhr.a)localObject1).mResPath;
        localObject1 = localObject2;
        if (((String)localObject2).endsWith("/")) {
          localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
        }
        this.expressionList = irl.c((String)localObject1, "params");
        if ((this.expressionList != null) && (this.expressionList.size() > 0))
        {
          this.jdField_a_of_type_Irl$a = ((irl.a)this.expressionList.get(0));
          localObject1 = this.expressionList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (irl.a)((Iterator)localObject1).next();
            if (((irl.a)localObject2).expressionID.equals("99")) {
              this.normalFaceExpression = ((irl.a)localObject2);
            }
          }
        }
      }
    }
    a(true, 1002, 0L, new Object[] { Integer.valueOf(asM), this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.configEmojiInfos });
    a(false, 1012, mR, null);
  }
  
  public boolean vt()
  {
    boolean bool = true;
    if ((!I(false)) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode != 2) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.currLocalFrameSyncInfo == null)) {
      bool = false;
    }
    return bool;
  }
  
  public boolean vu()
  {
    boolean bool = true;
    if ((!I(false)) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager$GameStateInfo.gameMode != 1)) {
      bool = false;
    }
    return bool;
  }
  
  public boolean vv()
  {
    return this.UB;
  }
  
  public boolean vw()
  {
    jht localjht = jik.a(this.mApp);
    return (localjht.a != null) && (localjht.a.Zr);
  }
  
  public static class GameInfoFromBusiServer
    implements Serializable
  {
    public String authKey;
    public int currScores;
    public List<Integer> emojiIds = Collections.emptyList();
    public int gameRestTime;
    public int gameStartTime;
    public int gameStatus = -1;
    public String key;
    public int maxScore;
    public String receiveRedPacketUin;
    public String sendRedPacketUin;
    public int winMoney;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GameInfoFromBusiServer:");
      localStringBuilder.append("gameStatus=").append(this.gameStatus);
      localStringBuilder.append(",sendRedPacketUin=").append(this.sendRedPacketUin);
      localStringBuilder.append(",receiveRedPacketUin=").append(this.receiveRedPacketUin);
      localStringBuilder.append(",maxScore=").append(this.maxScore);
      localStringBuilder.append(",winMoney=").append(this.winMoney);
      return localStringBuilder.toString();
    }
  }
  
  public static class GameStateInfo
    implements Serializable
  {
    String authKey;
    public List<AVRedPacketManager.LocalEmojiInfo> configEmojiInfos;
    public int count_OnFrameDataSend = 0;
    int curCommCnt;
    int curScore;
    public AVRedPacketManager.LocalFrameSyncInfo currLocalFrameSyncInfo = new AVRedPacketManager.LocalFrameSyncInfo();
    public int enterType;
    public int gameMode = 0;
    long gameStartTime;
    public int gameState = 0;
    boolean hasEmojiTip;
    public int hasScreenShotCnt;
    boolean isDestroy = false;
    int kazhenTipCnt;
    public String key;
    public long mRedPacketComeStartTime;
    String money;
    String receiveRedPacketUin;
    String sendRedPacketUin;
    HashSet<Integer> syncSuccEmojiId = new HashSet();
    
    GameStateInfo(GameStateInfo paramGameStateInfo)
    {
      this.key = paramGameStateInfo.key;
      this.gameMode = paramGameStateInfo.gameMode;
      this.sendRedPacketUin = paramGameStateInfo.sendRedPacketUin;
      this.receiveRedPacketUin = paramGameStateInfo.receiveRedPacketUin;
    }
    
    GameStateInfo(String paramString1, int paramInt, String paramString2, String paramString3)
    {
      this.key = paramString1;
      this.gameMode = paramInt;
      this.sendRedPacketUin = paramString2;
      this.receiveRedPacketUin = paramString3;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GameStateInfo:");
      localStringBuilder.append("key=").append(this.key);
      localStringBuilder.append(", gameMode=").append(this.gameMode);
      localStringBuilder.append(", gameState=").append(this.gameState);
      localStringBuilder.append(", isDestroy=").append(this.isDestroy);
      localStringBuilder.append(", sendRedPacketUin=").append(this.sendRedPacketUin);
      localStringBuilder.append(", receiveRedPacketUin=").append(this.receiveRedPacketUin);
      localStringBuilder.append(", curCommCnt=").append(this.curCommCnt);
      localStringBuilder.append(", curScore=").append(this.curScore);
      localStringBuilder.append(", currFrameSyncInfo=").append(this.currLocalFrameSyncInfo);
      return localStringBuilder.toString();
    }
    
    public void updateGameState(int paramInt)
    {
      this.gameState = paramInt;
    }
  }
  
  public static class LocalEmojiInfo
    implements Serializable
  {
    public int emojiId;
    public int emojiType;
    public int eventType;
    public int fallDownDuration;
    public boolean isBigEmoji;
    public long startTime;
    public int trackNum;
    
    public boolean equals(Object paramObject)
    {
      return this.emojiId == ((LocalEmojiInfo)paramObject).emojiId;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LocalEmojiInfo:");
      localStringBuilder.append("emojiId=").append(this.emojiId);
      localStringBuilder.append(", emojiType=").append(this.emojiType);
      localStringBuilder.append(", startTime=").append(this.startTime);
      localStringBuilder.append(", trackNum=").append(this.trackNum);
      localStringBuilder.append(", isBigEmoji=").append(this.isBigEmoji);
      localStringBuilder.append(", fallDownDuration=").append(this.fallDownDuration);
      return localStringBuilder.toString();
    }
  }
  
  public static class LocalFocusInfo
    implements Serializable
  {
    public int emojiId;
    public AVRedPacketManager.LocalEmojiInfo mLocalEmojiInfo;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LocalFocusInfo:");
      localStringBuilder.append("emojiId=").append(this.emojiId);
      return localStringBuilder.toString();
    }
  }
  
  public static class LocalFrameSyncInfo
    implements Serializable
  {
    public int curScore;
    public int frameSyncGameState;
    public List<Integer> hasHitedEmojiIds = new ArrayList();
    public List<AVRedPacketManager.LocalEmojiInfo> localEmojiInfos = new ArrayList();
    public AVRedPacketManager.LocalFocusInfo localFocusInfo = new AVRedPacketManager.LocalFocusInfo();
    public AVRedPacketManager.LocalHitInfo localHitInfo = new AVRedPacketManager.LocalHitInfo();
    public int seq;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      try
      {
        localStringBuilder.append("LocalFrameSyncInfo:");
        localStringBuilder.append("frameSyncGameState=").append(this.frameSyncGameState);
        localStringBuilder.append(",emojiInfos=").append(this.localEmojiInfos);
        localStringBuilder.append(",localFocusInfo=").append(this.localFocusInfo);
        localStringBuilder.append(",localHitInfo=").append(this.localHitInfo);
        localStringBuilder.append(",curScore=").append(this.curScore);
        localStringBuilder.append(",hasHitedEmojiIds=").append(this.hasHitedEmojiIds);
        localStringBuilder.append(",seq=").append(this.seq);
        label113:
        return localStringBuilder.toString();
      }
      catch (Exception localException)
      {
        break label113;
      }
    }
  }
  
  public static class LocalHitInfo
    implements Serializable
  {
    public int comboCnt;
    public int emojiId;
    public long hitStartTime;
    public int newAddScore;
    public int topWordTipType;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LocalHitInfo:");
      localStringBuilder.append("emojiId=").append(this.emojiId);
      localStringBuilder.append(", topWordTipType=").append(this.topWordTipType);
      localStringBuilder.append(", comboCnt=").append(this.comboCnt);
      localStringBuilder.append(", newAddScore=").append(this.newAddScore);
      localStringBuilder.append(", hitStartTime=").append(this.hitStartTime);
      return localStringBuilder.toString();
    }
  }
  
  public static abstract interface a
  {
    public abstract void B(int paramInt, boolean paramBoolean);
    
    public abstract void a(int paramInt, AVRedPacketManager.b paramb);
    
    public abstract void a(AVRedPacketManager.LocalFrameSyncInfo paramLocalFrameSyncInfo);
    
    public abstract void apO();
    
    public abstract void apP();
    
    public abstract void apR();
    
    public abstract void apS();
    
    public abstract void apU();
    
    public abstract void b(AVRedPacketManager.LocalFrameSyncInfo paramLocalFrameSyncInfo);
    
    public abstract void g(int paramInt, List<AVRedPacketManager.LocalEmojiInfo> paramList);
    
    public abstract void iL(boolean paramBoolean);
    
    public abstract void lx(int paramInt);
    
    public abstract boolean vp();
  }
  
  public static abstract interface b
  {
    public abstract void u(boolean paramBoolean, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.AVRedPacketManager
 * JD-Core Version:    0.7.0.1
 */