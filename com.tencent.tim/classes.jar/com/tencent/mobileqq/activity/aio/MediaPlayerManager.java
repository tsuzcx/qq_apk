package com.tencent.mobileqq.activity.aio;

import acbn;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import auvp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.item.PttAudioPlayView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import ija;
import mqq.manager.Manager;
import mqq.util.WeakReference;
import top;
import wja;
import wki;
import wlx;
import xeh;

public class MediaPlayerManager
  extends BroadcastReceiver
  implements AudioPlayerBase.a, Manager
{
  public static int bNM = 1000;
  public static float pC = 1.0F;
  public static float pD = 1.5F;
  public static float pE = 1.8F;
  private auvp jdField_a_of_type_Auvp;
  private CommonAudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer;
  private a jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$a;
  private b jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$b;
  private boolean bed;
  private boolean bee;
  private MediaPlayer.OnCompletionListener d = new wlx(this);
  boolean dA = false;
  private boolean dx;
  private boolean dy;
  private ChatMessage j;
  private ChatMessage k;
  private ChatMessage l;
  private ChatMessage m;
  private WeakReference<QQAppInterface> mApp;
  private boolean mAutoPlay;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private XListView mListView;
  
  public MediaPlayerManager(QQAppInterface paramQQAppInterface)
  {
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer = new CommonAudioPlayer(localBaseApplication, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.init();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localBaseApplication.registerReceiver(this, localIntentFilter);
    aR(paramQQAppInterface);
    AudioDeviceManager.a(paramQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer);
    if (Build.MODEL == "PCCM00") {
      bNM = 0;
    }
  }
  
  public static boolean C(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) < 1.0E-006F;
  }
  
  private boolean Rv()
  {
    int n;
    int i3;
    float f;
    boolean bool1;
    if ((this.j != null) && (this.jdField_a_of_type_Auvp != null))
    {
      n = a(this.j, this.jdField_a_of_type_Auvp);
      i3 = this.jdField_a_of_type_Auvp.getCount();
      if (n <= i3)
      {
        f = pC;
        if (!(this.j instanceof MessageForPtt)) {
          break label426;
        }
        bool1 = f(((MessageForPtt)this.j).playSpeedPos);
        if (bool1) {
          f = ((MessageForPtt)this.j).playSpeedPos;
        }
        ((MessageForPtt)this.j).playSpeedPos = pC;
      }
    }
    for (;;)
    {
      Object localObject = wja.a(this.mListView, this.mListView.getHeaderViewsCount() + n);
      if (n >= 0) {
        a(this.j).a(this.mListView, n, (View)localObject, this.j, true);
      }
      if (this.mAutoPlay) {
        while (n < i3 - 1)
        {
          int i2 = n + 1;
          ChatMessage localChatMessage = a(i2);
          n = i2;
          if ((localChatMessage instanceof c))
          {
            int i;
            label199:
            View localView;
            if ((this.bee) && (localObject != null))
            {
              i = 1;
              localView = wja.a(this.mListView, this.mListView.getHeaderViewsCount() + i2);
            }
            try
            {
              localObject = a(localChatMessage);
              boolean bool2 = ((a)localObject).a(this.mListView, i2, localView, localChatMessage);
              if ((bool2) && (bool1) && ((localChatMessage instanceof MessageForPtt)))
              {
                ((MessageForPtt)localChatMessage).playSpeedPos = f;
                ao(f);
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer != null) {
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.fT(((MessageForPtt)localChatMessage).msgTime);
                }
              }
              if ((bool2) && (((a)localObject).a(this.mListView, i2, localView, localChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer, 0))) {}
              for (int i1 = 1;; i1 = 0)
              {
                n = i2;
                localObject = localView;
                if (i1 == 0) {
                  break;
                }
                this.j = localChatMessage;
                if (i != 0) {
                  this.mListView.smoothScrollToPosition(this.mListView.getHeaderViewsCount() + i2);
                }
                return true;
                i = 0;
                break label199;
              }
              if (!QLog.isColorLevel()) {
                continue;
              }
            }
            catch (Exception localException)
            {
              n = i2;
              localObject = localView;
            }
            QLog.e("MediaPlayerManager", 2, "playNext", localException);
            n = i2;
            localObject = localView;
          }
        }
      }
      this.j = null;
      return false;
      label426:
      bool1 = false;
    }
  }
  
  public static int a(ChatMessage paramChatMessage, auvp paramauvp)
  {
    int i;
    int n;
    if (top.eD(paramChatMessage.istroop) == 1032)
    {
      i = 1;
      if (paramauvp != null) {
        n = 0;
      }
    }
    else
    {
      for (;;)
      {
        if (n >= paramauvp.getCount()) {
          break label150;
        }
        Object localObject = paramauvp.getItem(n);
        if (localObject != null) {
          if ((localObject instanceof ChatMessage))
          {
            if (((ChatMessage)localObject).uniseq != paramChatMessage.uniseq) {}
          }
          else {
            do
            {
              return n;
              i = 0;
              break;
              if (!(localObject instanceof RecentBaseData)) {
                break label143;
              }
              localObject = (RecentBaseData)localObject;
            } while (((i != 0) && (((RecentBaseData)localObject).ng() == 1032) && (((RecentBaseData)localObject).qx().equals(acbn.blK))) || ((paramChatMessage.frienduin.equals(((RecentBaseData)localObject).qx())) && (paramChatMessage.istroop == ((RecentBaseData)localObject).ng())));
          }
        }
        label143:
        n += 1;
      }
    }
    label150:
    return -1;
  }
  
  private a a(ChatMessage paramChatMessage)
  {
    if ((this.jdField_a_of_type_Auvp instanceof wki)) {
      return (a)((wki)this.jdField_a_of_type_Auvp).a.a(paramChatMessage, this.jdField_a_of_type_Auvp);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$a;
  }
  
  public static MediaPlayerManager a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      paramQQAppInterface = (MediaPlayerManager)paramQQAppInterface.getManager(24);
      return paramQQAppInterface;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  private ChatMessage a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_Auvp.getItem(paramInt);
    if ((localObject != null) && ((localObject instanceof ChatMessage))) {
      return (ChatMessage)localObject;
    }
    return null;
  }
  
  private void aR(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaPlayerManager", 2, "$bindApp, app = " + paramQQAppInterface);
    }
    if ((this.mApp != null) && (this.mApp.get() == paramQQAppInterface)) {
      return;
    }
    if ((this.mApp != null) && (this.mApp.get() != null)) {
      gB();
    }
    this.mApp = new WeakReference(paramQQAppInterface);
  }
  
  private int d(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    if (!this.bed)
    {
      n = a(this.j, this.jdField_a_of_type_Auvp);
      s(this.j);
      a(this.j, this.l);
      i = n;
      if (n >= 0)
      {
        localView = wja.a(this.mListView, this.mListView.getHeaderViewsCount() + n);
        a(this.j).a(this.mListView, n, localView, this.j, paramBoolean2);
        i = n;
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$a == null)
    {
      int n;
      View localView;
      return i;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$a.a(null, 0, null, this.j, paramBoolean2);
    return 0;
  }
  
  public static boolean f(float paramFloat)
  {
    return (paramFloat > 1.0F) && (Math.abs(paramFloat - 1.0F) > 0.0F);
  }
  
  private boolean i(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.stop();
      if ((this.bed) || ((this.j != null) && (this.jdField_a_of_type_Auvp != null))) {
        d(paramBoolean1, paramBoolean2);
      }
      this.j = null;
      bool2 = true;
    }
    label173:
    for (;;)
    {
      return bool2;
      if ((this.jdField_a_of_type_Auvp != null) && (this.j != null))
      {
        if (!a(this.j).e(this.j)) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.stop();
        d(paramBoolean1, paramBoolean2);
        this.j = null;
        break;
      }
      if ((this.jdField_a_of_type_Auvp != null) || (this.j == null)) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$a != null) {}
      for (boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$a.e(this.j);; bool1 = false)
      {
        if (!bool1) {
          break label173;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.stop();
        d(paramBoolean1, paramBoolean2);
        this.j = null;
        break;
      }
    }
  }
  
  public void Cl(int paramInt)
  {
    if ((this.jdField_a_of_type_Auvp == null) || (this.mListView == null)) {
      return;
    }
    int n = this.jdField_a_of_type_Auvp.getCount();
    int i = 0;
    label25:
    Object localObject;
    PttAudioWaveView localPttAudioWaveView;
    if (i < n) {
      if (paramInt != i)
      {
        localObject = a(i);
        if (!(localObject instanceof MessageForPtt)) {
          break label154;
        }
        ((MessageForPtt)localObject).playProgress = 0.0F;
        ((MessageForPtt)localObject).playSpeedPos = pC;
        localObject = wja.a(this.mListView, this.mListView.getHeaderViewsCount() + i);
        if (localObject != null)
        {
          localPttAudioWaveView = (PttAudioWaveView)((View)localObject).findViewById(2131374801);
          if (localPttAudioWaveView != null)
          {
            localPttAudioWaveView.setProgress(0.0F);
            localPttAudioWaveView.setCanSupportSlide(false);
          }
          localObject = (PttAudioPlayView)((View)localObject).findViewById(2131374800);
          if (localObject != null) {
            ((PttAudioPlayView)localObject).setPlayState(false);
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label25;
      break;
      label154:
      if ((localObject instanceof MessageForMarketFace))
      {
        localObject = (MessageForMarketFace)localObject;
        if (((MessageForMarketFace)localObject).isNewSoundType())
        {
          ((MessageForMarketFace)localObject).playProgress = 0.0F;
          localObject = wja.a(this.mListView, this.mListView.getHeaderViewsCount() + i);
          if (localObject != null)
          {
            localPttAudioWaveView = (PttAudioWaveView)((View)localObject).findViewById(2131372328);
            if (localPttAudioWaveView != null) {
              localPttAudioWaveView.setProgress(0.0F);
            }
            localObject = (PttAudioPlayView)((View)localObject).findViewById(2131372327);
            if (localObject != null) {
              ((PttAudioPlayView)localObject).setPlayState(false);
            }
          }
        }
      }
    }
  }
  
  public boolean Rw()
  {
    return (this.j != null) && ((this.j instanceof MessageForLightVideo));
  }
  
  public ChatMessage a()
  {
    return this.j;
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase)
  {
    ThreadManager.excute(new MediaPlayerManager.2(this), 16, null, false);
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (this.j != null) {
        d(true, true);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$b != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$b.zR(paramInt);
      }
      return;
    }
    this.mHandler.post(new MediaPlayerManager.4(this, paramAudioPlayerBase, paramInt));
  }
  
  public void a(b paramb, a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MediaPlayerManager", 2, "bindUI, listener = " + paramb + " ,callBack = " + parama);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$b = paramb;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a(paramb);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$a = parama;
    this.bed = true;
  }
  
  public void a(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    if (((paramChatMessage1 instanceof MessageForPtt)) && ((paramChatMessage2 instanceof MessageForPtt)) && (!paramChatMessage1.equals(paramChatMessage2))) {
      ((MessageForPtt)paramChatMessage1).playSpeedPos = pC;
    }
  }
  
  public void a(XListView paramXListView, auvp paramauvp, b paramb)
  {
    a(paramXListView, paramauvp, paramb, null, true, true);
  }
  
  public void a(XListView paramXListView, auvp paramauvp, b paramb, a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MediaPlayerManager", 2, "bindUI, mListView = " + this.mListView + " ,listView = " + paramXListView + " ,adapter = " + paramauvp + ", listener = " + paramb);
    }
    this.mListView = paramXListView;
    this.jdField_a_of_type_Auvp = paramauvp;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$b = paramb;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a(paramb);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$a = parama;
    this.mAutoPlay = paramBoolean1;
    this.bee = paramBoolean2;
    this.bed = false;
  }
  
  public boolean a(ChatMessage paramChatMessage, int paramInt)
  {
    return a(paramChatMessage, false, paramInt);
  }
  
  public boolean a(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    return a(paramChatMessage, paramBoolean, 0);
  }
  
  public boolean a(ChatMessage paramChatMessage, boolean paramBoolean, int paramInt)
  {
    if ((this.k != null) && ((this.k instanceof MessageForPtt))) {
      ((MessageForPtt)this.k).playProgress = 0.0F;
    }
    ShortVideoPTVItemBuilder.r(this.mListView);
    a(this.m, paramChatMessage);
    this.l = paramChatMessage;
    if ((this.jdField_a_of_type_Auvp != null) && (paramChatMessage != null) && (this.mApp != null)) {
      if (i(false, false))
      {
        boolean bool2;
        boolean bool3;
        int i;
        boolean bool1;
        if (((paramChatMessage instanceof MessageForLightVideo)) || (wja.Rc()))
        {
          this.dx = true;
          bool2 = ija.Y(BaseApplicationImpl.getContext());
          bool3 = AudioHelper.bL(BaseApplicationImpl.getContext());
          i = a(paramChatMessage, this.jdField_a_of_type_Auvp);
          bool1 = false;
          if (!paramBoolean) {
            break label232;
          }
        }
        label232:
        View localView;
        for (paramBoolean = bool1;; paramBoolean = a(paramChatMessage).a(this.mListView, i, localView, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer, paramInt))
        {
          if (!paramBoolean) {
            break label284;
          }
          this.j = paramChatMessage;
          this.dA = false;
          this.l = null;
          this.m = null;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$b != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$b.onPlayStart();
            this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$b.d(bool2, bool3, this.dx, false);
          }
          this.dy = false;
          return true;
          if ((this.mApp == null) || (this.mApp.get() == null)) {
            break;
          }
          this.dx = ((QQAppInterface)this.mApp.get()).getLoudSpeakerState();
          break;
          this.bee = true;
          localView = wja.a(this.mListView, this.mListView.getHeaderViewsCount() + i);
        }
        label284:
        if (QLog.isColorLevel()) {
          QLog.d("MediaPlayerManager", 2, "builder play failed.");
        }
      }
    }
    for (;;)
    {
      this.l = null;
      this.m = null;
      return false;
      if (QLog.isColorLevel())
      {
        QLog.d("MediaPlayerManager", 2, "doStop failed.");
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("MediaPlayerManager", 2, "request play failed, mAdapter = " + this.jdField_a_of_type_Auvp + ", msg = " + paramChatMessage + ", app = " + this.mApp);
        }
      }
    }
  }
  
  public void ao(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.ao(paramFloat);
    }
  }
  
  public void b(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$b != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$b.zS(paramInt);
    }
  }
  
  public boolean b(ChatMessage paramChatMessage, int paramInt)
  {
    boolean bool1 = false;
    ShortVideoPTVItemBuilder.r(this.mListView);
    if ((paramChatMessage != null) && (this.mApp != null)) {
      if (i(false, false)) {
        if (wja.Rc())
        {
          this.dx = true;
          bool2 = ija.Y(BaseApplicationImpl.getContext());
          bool3 = AudioHelper.bL(BaseApplicationImpl.getContext());
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$a.a(this.mListView, 0, null, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer, paramInt)) {
            break label170;
          }
          this.j = paramChatMessage;
          this.dA = false;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$b != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$b.onPlayStart();
            this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$b.d(bool2, bool3, this.dx, false);
          }
          this.dy = false;
          bool1 = true;
        }
      }
    }
    label170:
    while (!QLog.isColorLevel())
    {
      do
      {
        do
        {
          for (;;)
          {
            boolean bool2;
            boolean bool3;
            return bool1;
            if ((this.mApp != null) && (this.mApp.get() != null)) {
              this.dx = ((QQAppInterface)this.mApp.get()).getLoudSpeakerState();
            }
          }
        } while (!QLog.isColorLevel());
        QLog.d("MediaPlayerManager", 2, "builder play failed.");
        return false;
      } while (!QLog.isColorLevel());
      QLog.d("MediaPlayerManager", 2, "doStop failed.");
      return false;
    }
    QLog.d("MediaPlayerManager", 2, "request play failed, mAdapter = " + this.jdField_a_of_type_Auvp + ", msg = " + paramChatMessage + ", app = " + this.mApp);
    return false;
  }
  
  public void bZy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MediaPlayerManager", 2, "unBindUI");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$b = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$a = null;
  }
  
  public void bZz()
  {
    if (this.j != null) {
      this.k = this.j;
    }
  }
  
  public void c(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    this.mHandler.post(new MediaPlayerManager.5(this, paramInt));
  }
  
  public void c(XListView paramXListView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MediaPlayerManager", 2, "unBindUI");
    }
    if ((this.mListView != null) && (this.mListView == paramXListView))
    {
      this.mListView = null;
      this.jdField_a_of_type_Auvp = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$b = null;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a(null);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$a = null;
      this.mAutoPlay = false;
      this.bee = false;
    }
  }
  
  public void d(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    if ((this.mHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.isPlaying())) {
      this.mHandler.post(new MediaPlayerManager.6(this, paramInt));
    }
  }
  
  public void gB()
  {
    try
    {
      stop(true);
      c(this.mListView);
      if ((this.mApp != null) && (this.mApp.get() != null)) {
        ((QQAppInterface)this.mApp.get()).getApp().unregisterReceiver(this);
      }
      this.mApp = null;
      if (QLog.isColorLevel()) {
        QLog.d("MediaPlayerManager", 2, "$unBindApp");
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("MediaPlayerManager", 2, "", localException);
    }
  }
  
  public void gC()
  {
    if ((this.mApp != null) && (this.mApp.get() != null)) {}
    for (boolean bool = ((QQAppInterface)this.mApp.get()).getLoudSpeakerState();; bool = true)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.aM(1, bool);
      if ((bool != this.dx) && (isPlaying()) && (QLog.isColorLevel())) {
        QLog.d("MediaPlayerManager", 2, "$updateSpeakPhone| speakerOn=" + bool);
      }
      this.dx = bool;
      return;
    }
  }
  
  public boolean isPlaying()
  {
    return this.j != null;
  }
  
  public boolean k(ChatMessage paramChatMessage)
  {
    return a(paramChatMessage, false);
  }
  
  public void onDestroy()
  {
    stopBluetoothSco();
    gB();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext != null) && (paramContext.equals("tencent.av.v2q.StartVideoChat")))
    {
      bool1 = paramIntent.getBooleanExtra("updateTime", false);
      bool2 = paramIntent.getBooleanExtra("showTime", false);
      if (QLog.isColorLevel()) {
        QLog.d("MediaPlayerManager", 2, "receive action_recv_video_request. update:" + bool1 + ", show:" + bool2);
      }
      if ((bool1) && (bool2)) {
        ChatActivityUtils.bJr();
      }
      stop(true);
    }
    while (!"android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      boolean bool1;
      boolean bool2;
      return;
    }
    stop(false);
    ShortVideoPTVItemBuilder.r(this.mListView);
  }
  
  public void onStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaPlayerManager", 2, "$onStop");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$b != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$b.onPlayStop();
    }
  }
  
  public void s(ChatMessage paramChatMessage)
  {
    this.m = paramChatMessage;
  }
  
  public void setAutoScroll(boolean paramBoolean)
  {
    if ((paramBoolean) && (isPlaying())) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.bee = paramBoolean;
      return;
    }
  }
  
  public void stop(boolean paramBoolean)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (i(paramBoolean, false)) {
        onStop();
      }
      return;
    }
    this.mHandler.post(new MediaPlayerManager.1(this, paramBoolean));
  }
  
  public void stopBluetoothSco()
  {
    if (!AudioPlayer.bdf) {}
    AudioManager localAudioManager;
    do
    {
      return;
      localAudioManager = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
    } while ((!AudioPlayer.bdh) || (localAudioManager == null) || (!localAudioManager.isBluetoothScoOn()));
    if (QLog.isColorLevel()) {
      QLog.d("MediaPlayerManager", 2, "stop sco");
    }
    localAudioManager.stopBluetoothSco();
    localAudioManager.setBluetoothScoOn(false);
    AudioPlayer.bdh = false;
  }
  
  public void yB(boolean paramBoolean)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (i(paramBoolean, true)) {
        onStop();
      }
      return;
    }
    this.mHandler.post(new MediaPlayerManager.7(this, paramBoolean));
  }
  
  public static abstract interface a
  {
    public abstract void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat);
    
    public abstract void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean);
    
    public abstract boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage);
    
    public abstract boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayerBase paramAudioPlayerBase, int paramInt2);
    
    public abstract boolean e(ChatMessage paramChatMessage);
  }
  
  public static abstract interface b
    extends CommonAudioPlayer.a
  {
    public abstract void d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4);
    
    public abstract void onPlayStart();
    
    public abstract void onPlayStop();
    
    public abstract void zR(int paramInt);
    
    public abstract void zS(int paramInt);
    
    public abstract void zT(int paramInt);
  }
  
  public static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MediaPlayerManager
 * JD-Core Version:    0.7.0.1
 */