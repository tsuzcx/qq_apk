import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.image.JpegExifReader;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.troop.data.TroopGiftBagInfo;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.1;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.5;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.8;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.manager.Manager;

public class apqk
  extends Observable
  implements Manager
{
  public static volatile boolean cRX;
  public static final String cqs = String.valueOf(10000L);
  public static int dVo = 9;
  public apqk.d a;
  apwy.b jdField_a_of_type_Apwy$b = new apqn(this);
  protected apxr a;
  apyu jdField_a_of_type_Apyu;
  private SharedPreferences aa;
  public Comparator<apqk.c> ah = new apqq(this);
  private long arS;
  public apwy b;
  private boolean cRW;
  public volatile boolean cRY = true;
  String cqt;
  private int dVp;
  anyo.a f = new apqo(this);
  Activity mActivity;
  AppInterface mApp = null;
  BaseChatPie mBaseChatPie;
  Handler mHandler;
  HashMap<String, Integer> oo = new HashMap();
  HashMap<String, List<apqk.c>> op = new HashMap();
  protected HashMap<String, List<MessageForDeliverGiftTips>> oq = new HashMap();
  public int playState = 1;
  aquy u = new apqr(this);
  
  public apqk(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
    e(paramAppInterface);
    this.mHandler = new Handler(Looper.getMainLooper());
  }
  
  private void a(apqk.c paramc)
  {
    int i = 0;
    Object localObject = (List)this.op.get(paramc.getFriendUin());
    if (localObject == null)
    {
      localObject = new ArrayList();
      this.op.put(paramc.getFriendUin(), localObject);
    }
    for (;;)
    {
      int j;
      try
      {
        ((List)localObject).add(paramc);
        int m = paramc.getLimitType();
        int k = -1;
        j = 0;
        if (i < ((List)localObject).size())
        {
          paramc = (apqk.c)((List)localObject).get(i);
          if ((paramc == null) || (paramc.getLimitType() != m)) {
            break label158;
          }
          if (k == -1)
          {
            k = i;
            break label164;
          }
        }
        else
        {
          if (j > jL(m)) {
            ((List)localObject).remove(k);
          }
          return;
        }
      }
      finally {}
      break label164;
      label158:
      break label168;
      break;
      label164:
      j += 1;
      label168:
      i += 1;
    }
  }
  
  private void a(String paramString, MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if ((!this.oo.containsKey(paramString)) || (((Integer)this.oo.get(paramString)).intValue() == 4))
    {
      Object localObject = new File(aptj.g(paramString, paramMessageForDeliverGiftTips.animationType, paramMessageForDeliverGiftTips.isInteract()));
      Bundle localBundle = new Bundle();
      localBundle.putString("GiftAnimationId", paramString);
      localBundle.putString("TroopUin", paramMessageForDeliverGiftTips.frienduin);
      localBundle.putInt("GiftAnimationType", paramMessageForDeliverGiftTips.animationType);
      localBundle.putBoolean("GiftIsInteract", paramMessageForDeliverGiftTips.isInteract());
      localObject = new aquz(aptj.c(paramMessageForDeliverGiftTips), (File)localObject);
      ((aquz)localObject).retryCount = 2;
      if ((paramMessageForDeliverGiftTips instanceof MessageForTroopGift)) {
        ((MessageForTroopGift)paramMessageForDeliverGiftTips).isLoading = true;
      }
      a().a((aquz)localObject, this.u, localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("AIOAnimationControlManager", 2, "start Download PackageId:" + aptj.b(paramMessageForDeliverGiftTips));
      }
      this.oo.put(paramString, Integer.valueOf(2));
    }
  }
  
  public static boolean a(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, Object paramObject)
  {
    if ((paramObject instanceof MessageForDeliverGiftTips))
    {
      if (((MessageForDeliverGiftTips)paramObject).isInteract()) {
        break label37;
      }
      paramBaseChatPie.wi(false);
    }
    for (;;)
    {
      if (aafi.a(paramObject, paramQQAppInterface)) {
        paramBaseChatPie.wi(false);
      }
      return false;
      label37:
      if (((paramBaseChatPie.a() instanceof SplashActivity)) && (SplashActivity.bKT != 2)) {
        return true;
      }
      ((apqk)paramQQAppInterface.getManager(223)).B(paramBaseChatPie);
    }
  }
  
  private void e(AppInterface paramAppInterface)
  {
    if ((paramAppInterface != null) && ((paramAppInterface instanceof BrowserAppInterface)))
    {
      ebk();
      return;
    }
    ThreadManager.post(new AIOAnimationControlManager.1(this), 8, null, true);
  }
  
  private void ebk()
  {
    Object localObject = new File(acbn.bno);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    File[] arrayOfFile = ((File)localObject).listFiles();
    int j;
    int i;
    boolean bool;
    if (arrayOfFile != null)
    {
      j = 0;
      if (j < arrayOfFile.length) {
        if ((arrayOfFile[j].exists()) && (arrayOfFile[j].isDirectory()))
        {
          localObject = arrayOfFile[j].getName();
          if (!arrayOfFile[j].getName().endsWith("_HD")) {
            break label181;
          }
          localObject = ((String)localObject).substring(0, ((String)localObject).length() - 3);
          i = 0;
          bool = false;
        }
      }
    }
    for (;;)
    {
      label111:
      if (aptj.h((String)localObject, i, bool))
      {
        this.oo.put(localObject, Integer.valueOf(3));
        if (QLog.isColorLevel()) {
          QLog.d("AIOAnimationControlManager", 2, "Package Downloaded:" + arrayOfFile[j].getName());
        }
      }
      for (;;)
      {
        j += 1;
        break;
        label181:
        if (arrayOfFile[j].getName().endsWith("_V"))
        {
          localObject = ((String)localObject).substring(0, ((String)localObject).length() - 2);
          i = 1;
          bool = false;
          break label111;
        }
        if (!arrayOfFile[j].getName().endsWith("_NEW")) {
          break label271;
        }
        localObject = ((String)localObject).substring(0, ((String)localObject).length() - 4);
        i = 1;
        bool = true;
        break label111;
        aqhq.cn(arrayOfFile[j].getAbsolutePath());
      }
      return;
      label271:
      i = 0;
      bool = false;
    }
  }
  
  private void hY(String paramString1, String paramString2)
  {
    List localList = (List)this.op.get(paramString1);
    if ((paramString2 == null) || (localList == null)) {
      return;
    }
    int i = 0;
    label25:
    if (i < localList.size())
    {
      paramString1 = (apqk.c)localList.get(i);
      if (!(paramString1 instanceof MessageForDeliverGiftTips)) {
        break label87;
      }
      paramString1 = aptj.b((MessageForDeliverGiftTips)paramString1);
    }
    for (;;)
    {
      if (paramString2.equals(paramString1)) {
        localList.remove(i);
      }
      i += 1;
      break label25;
      break;
      label87:
      if ((paramString1 instanceof MessageForTroopEffectPic)) {
        paramString1 = ((MessageForTroopEffectPic)paramString1).effectId + "";
      } else {
        paramString1 = "";
      }
    }
  }
  
  private void hZ(String paramString1, String paramString2)
  {
    paramString1 = (List)this.oq.get(paramString1);
    if ((paramString2 == null) || (paramString1 == null)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramString1.size())
      {
        if (paramString2.equals(aptj.b((MessageForDeliverGiftTips)paramString1.get(i)))) {
          paramString1.remove(i);
        }
        i += 1;
      }
    }
  }
  
  public void B(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationControlManager", 2, "set TroopChatPie ,troopUin:" + paramBaseChatPie.sessionInfo.aTl);
    }
    if (this.mBaseChatPie != paramBaseChatPie)
    {
      this.mBaseChatPie = paramBaseChatPie;
      addObserver(this.mBaseChatPie);
      this.b = paramBaseChatPie.a();
      if (!(this.mBaseChatPie instanceof TroopChatPie)) {
        break label115;
      }
      this.b.Xh(1);
      this.jdField_a_of_type_Apxr = ((TroopChatPie)this.mBaseChatPie).a();
      this.jdField_a_of_type_Apyu = ((TroopChatPie)this.mBaseChatPie).a();
    }
    label115:
    do
    {
      return;
      if ((this.mBaseChatPie instanceof yam))
      {
        this.b.Xh(4);
        return;
      }
    } while (!(this.mBaseChatPie instanceof ybt));
    if (this.mBaseChatPie.sessionInfo.cZ == 10002)
    {
      this.b.Xh(8);
      return;
    }
    this.b.Xh(6);
  }
  
  public void Sa(boolean paramBoolean)
  {
    if ((this.mBaseChatPie == null) && (this.mActivity == null) && (!cqs.equals(this.cqt))) {}
    Object localObject3;
    Object localObject5;
    label397:
    label754:
    label892:
    String str;
    label876:
    do
    {
      Object localObject4;
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
                  return;
                  this.cRW = paramBoolean;
                  if (!cqs.equals(this.cqt)) {
                    break;
                  }
                  localObject1 = this.cqt;
                  localObject3 = (List)this.oq.get(localObject1);
                  localObject4 = (List)this.op.get(localObject1);
                } while ((!aBt()) && (aptj.isListEmpty((List)localObject3)));
                if ((this.jdField_a_of_type_Apxr == null) || (aptj.isListEmpty((List)localObject3))) {
                  break label397;
                }
              } while ((this.jdField_a_of_type_Apxr.isPlaying()) && (this.jdField_a_of_type_Apxr.aBG()));
              this.playState = 2;
              localObject5 = (MessageForDeliverGiftTips)((List)localObject3).get(0);
              localObject6 = aptj.b((MessageForDeliverGiftTips)localObject5);
              if ((!this.oo.containsKey(localObject6)) || (((Integer)this.oo.get(localObject6)).intValue() != 3)) {
                break;
              }
              if ((this.mBaseChatPie != null) && (this.mBaseChatPie.a() != null) && (this.mBaseChatPie.a().a != null) && (this.mBaseChatPie.a().a.isStart()))
              {
                this.mHandler.postDelayed(new AIOAnimationControlManager.5(this, paramBoolean), 500L);
                return;
                if (this.mBaseChatPie != null) {}
                for (localObject1 = this.mBaseChatPie.sessionInfo.aTl;; localObject1 = this.cqt) {
                  break;
                }
              }
            } while (((MessageForDeliverGiftTips)localObject5).interactState == 2);
            ((apsz)this.mApp.getManager(113)).a(((MessageForDeliverGiftTips)localObject5).frienduin, ((MessageForDeliverGiftTips)localObject5).interactId, ((MessageForDeliverGiftTips)localObject5).giftId, new apqs(this, (MessageForDeliverGiftTips)localObject5, (List)localObject3, paramBoolean, (List)localObject4, (String)localObject6));
            return;
            if ((this.oo.containsKey(localObject6)) && (((Integer)this.oo.get(localObject6)).intValue() == 4))
            {
              hZ((String)localObject1, (String)localObject6);
              this.playState = 1;
              Sa(paramBoolean);
              return;
            }
            this.playState = 3;
            return;
          } while ((this.b == null) || (aptj.isListEmpty((List)localObject4)));
          this.playState = 2;
          localObject3 = (apqk.c)((List)localObject4).get(0);
          if (!(localObject3 instanceof MessageForDeliverGiftTips)) {
            break label1300;
          }
          localObject5 = (MessageForDeliverGiftTips)localObject3;
          if ((((MessageForDeliverGiftTips)localObject5).isToAll()) && (!((MessageForDeliverGiftTips)localObject5).hasFetchButFailed))
          {
            localObject3 = ((apsz)this.mApp.getManager(113)).a((String)localObject1, ((MessageForDeliverGiftTips)localObject5).bagId, new apqu(this, (MessageForDeliverGiftTips)localObject5, (String)localObject1, paramBoolean));
            if (localObject3 == null)
            {
              this.playState = 1;
              return;
            }
            if ((!((TroopGiftBagInfo)localObject3).hasGrab()) || (((TroopGiftBagInfo)localObject3).myGrabResult == null)) {
              break label754;
            }
            ((MessageForDeliverGiftTips)localObject5).showButton = false;
            ((MessageForDeliverGiftTips)localObject5).resultText = ((TroopGiftBagInfo)localObject3).myGrabResult.tips;
            ((MessageForDeliverGiftTips)localObject5).resultType = 0;
          }
          for (;;)
          {
            if ((this.mApp instanceof QQAppInterface)) {
              ((MessageForDeliverGiftTips)localObject5).senderName = aqgv.h((QQAppInterface)this.mApp, (String)localObject1, "" + ((MessageForDeliverGiftTips)localObject5).senderUin);
            }
            localObject6 = aptj.b((MessageForDeliverGiftTips)localObject5);
            if ((!this.oo.containsKey(localObject6)) || (((Integer)this.oo.get(localObject6)).intValue() != 3)) {
              break label1244;
            }
            this.b.b(this.f);
            if (QLog.isColorLevel()) {
              QLog.d("AIOAnimationControlManager", 2, "Playing! playMaigface id:" + aptj.b((MessageForDeliverGiftTips)localObject5));
            }
            if ((this.mBaseChatPie == null) || (this.mBaseChatPie.a() == null) || (this.mBaseChatPie.a().a == null) || (!this.mBaseChatPie.a().a.isStart())) {
              break;
            }
            this.mHandler.postDelayed(new AIOAnimationControlManager.8(this, paramBoolean), 500L);
            return;
            if (((TroopGiftBagInfo)localObject3).myGrabResult != null)
            {
              ((MessageForDeliverGiftTips)localObject5).showButton = false;
              ((MessageForDeliverGiftTips)localObject5).resultText = ((TroopGiftBagInfo)localObject3).myGrabResult.tips;
              ((MessageForDeliverGiftTips)localObject5).resultType = 1;
            }
            else
            {
              ((MessageForDeliverGiftTips)localObject5).showButton = true;
            }
          }
          if (apot.a().isPlaying()) {
            apot.a().stop();
          }
          if (TextUtils.isEmpty(((MessageForDeliverGiftTips)localObject5).interactId)) {
            break;
          }
          ((List)localObject4).remove(localObject5);
        } while (this.jdField_a_of_type_Apxr == null);
        this.jdField_a_of_type_Apxr.a((MessageForDeliverGiftTips)localObject5, (String)localObject6, false, new apqv(this, paramBoolean));
        return;
        if (this.mBaseChatPie != null)
        {
          localObject3 = "0";
          if (this.mBaseChatPie == null) {
            break label1212;
          }
          localObject4 = this.mBaseChatPie.app;
          anot.a((QQAppInterface)localObject4, "P_CliOper", "Grp_flower", "", "cartoon", "show", 0, 0, (String)localObject1, (String)localObject6, (String)localObject3, "" + jlk.a(this.mApp, this.mApp.getCurrentAccountUin(), (String)localObject1));
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder().append("Check isLimitGiftAnim: isEnterAIO:").append(paramBoolean).append(", isToMeGift:");
            if (((MessageForDeliverGiftTips)localObject5).receiverUin == this.mApp.getLongAccountUin()) {
              break label1218;
            }
          }
        }
        for (boolean bool = true;; bool = false)
        {
          QLog.d("AIOAnimationControlManager", 2, bool + ", count:" + this.dVp + ", time:" + this.arS);
          if ((!paramBoolean) || (((MessageForDeliverGiftTips)localObject5).receiverUin == this.mApp.getLongAccountUin()) || (!bw(true))) {
            break label1223;
          }
          if (!(this.mApp instanceof QQAppInterface)) {
            break;
          }
          localObject1 = (QQAppInterface)this.mApp;
          localObject3 = ((QQAppInterface)localObject1).a().a().q(false).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (RecentUser)((Iterator)localObject3).next();
            if (((RecentUser)localObject4).msgType == 7)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AIOAnimationControlManager", 2, "limitGiftAnim setRead RecentUser:" + localObject4);
              }
              ((QQAppInterface)localObject1).b().a().a(((RecentUser)localObject4).uin, ((RecentUser)localObject4).getType(), true, false);
            }
          }
          break;
          localObject3 = "1";
          break label876;
          localObject4 = null;
          break label892;
        }
        this.b.a((MessageForDeliverGiftTips)localObject5);
        this.b.b = this.jdField_a_of_type_Apwy$b;
        return;
        if ((this.oo.containsKey(localObject6)) && (((Integer)this.oo.get(localObject6)).intValue() == 4))
        {
          hY((String)localObject1, (String)localObject6);
          this.playState = 1;
          Sa(paramBoolean);
          return;
        }
        this.playState = 3;
        return;
        if ((localObject3 instanceof aafi))
        {
          localObject1 = (aafi)localObject3;
          this.b.a((aafi)localObject1);
          ((aafi)localObject1).a(this.mBaseChatPie, new apql(this, paramBoolean));
          ((List)localObject4).remove(localObject3);
          return;
        }
      } while ((!(localObject3 instanceof MessageForTroopEffectPic)) || (this.jdField_a_of_type_Apyu == null));
      localObject5 = (MessageForTroopEffectPic)localObject3;
      localObject3 = "" + ((MessageForTroopEffectPic)localObject5).effectId;
      if ((((MessageForTroopEffectPic)localObject5).effectId < 40003) || (((MessageForTroopEffectPic)localObject5).effectId > 40005)) {
        this.oo.put(localObject3, Integer.valueOf(3));
      }
      if ((!this.oo.containsKey(localObject3)) || (((Integer)this.oo.get(localObject3)).intValue() != 3) || (!aptj.mj(((MessageForTroopEffectPic)localObject5).effectId))) {
        break;
      }
      Object localObject1 = ((MessageForTroopEffectPic)localObject5).getPicDownloadInfo();
      ((akxl)localObject1).protocol = "chatimg";
      Object localObject6 = ((akxl)localObject1).getFilePath();
      File localFile = new File((String)localObject6);
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localObject3 = null;
      int i;
      switch (JpegExifReader.readOrientation((String)localObject6))
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        i = 0;
      }
      for (;;)
      {
        localObject1 = localObject3;
        try
        {
          if (localFile.exists())
          {
            localObject1 = new BufferedInputStream(new FileInputStream(localFile), 2048);
            localOptions.inSampleSize = ((int)aqhu.getOptRatio((InputStream)localObject1, 720, 1080));
            ((BufferedInputStream)localObject1).close();
            localObject6 = aqhu.d((String)localObject6, localOptions);
            localObject1 = localObject3;
            if (localObject6 != null)
            {
              localObject1 = new Matrix();
              ((Matrix)localObject1).reset();
              ((Matrix)localObject1).setRotate(i);
              localObject1 = Bitmap.createBitmap((Bitmap)localObject6, 0, 0, ((Bitmap)localObject6).getWidth(), ((Bitmap)localObject6).getHeight(), (Matrix)localObject1, true);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            Object localObject2 = null;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AIOAnimationControlManager", 2, "OOM: " + QLog.getStackTraceString(localOutOfMemoryError));
            }
            str = null;
          }
        }
        if ((localObject1 == null) || (this.mBaseChatPie == null) || (!(this.mBaseChatPie instanceof TroopChatPie))) {
          break label1834;
        }
        localObject3 = (TroopChatPie)this.mBaseChatPie;
        this.jdField_a_of_type_Apyu.a(((MessageForTroopEffectPic)localObject5).effectId, (Bitmap)localObject1, ((TroopChatPie)localObject3).bYK, new apqm(this, paramBoolean));
        ((List)localObject4).remove(localObject5);
        return;
        i = 90;
        continue;
        i = 180;
        continue;
        i = 270;
      }
    } while ((this.mBaseChatPie == null) || (!(this.mBaseChatPie instanceof TroopChatPie)));
    label1212:
    label1218:
    label1223:
    label1244:
    this.playState = 3;
    label1300:
    label1834:
    this.jdField_a_of_type_Apyu.a((TroopChatPie)this.mBaseChatPie, (MessageForTroopEffectPic)localObject5, false);
    return;
    if ((this.oo.containsKey(localObject3)) && (((Integer)this.oo.get(localObject3)).intValue() == 4))
    {
      hY(str, (String)localObject3);
      this.playState = 1;
      Sa(paramBoolean);
      return;
    }
    a((MessageForTroopEffectPic)localObject5, false);
    this.playState = 3;
  }
  
  public void Ty(String paramString)
  {
    List localList = (List)this.op.remove(paramString);
    if (localList != null) {
      localList.clear();
    }
    paramString = (List)this.oq.remove(paramString);
    if (paramString != null) {
      paramString.clear();
    }
  }
  
  public aqvc a()
  {
    return ((aqva)this.mApp.getManager(47)).a(1);
  }
  
  public void a(int paramInt, String paramString, MessageForTroopEffectPic paramMessageForTroopEffectPic)
  {
    paramMessageForTroopEffectPic = "" + paramInt;
    if ((!this.oo.containsKey("" + paramInt)) || (((Integer)this.oo.get(paramMessageForTroopEffectPic)).intValue() == 4))
    {
      File localFile = new File(aptj.fN(paramInt));
      Bundle localBundle = new Bundle();
      localBundle.putString("GiftAnimationId", paramMessageForTroopEffectPic);
      localBundle.putString("TroopUin", paramString);
      paramString = new aquz(aptj.fO(paramInt), localFile);
      paramString.retryCount = 2;
      a().a(paramString, this.u, localBundle);
      this.oo.put(paramMessageForTroopEffectPic, Integer.valueOf(2));
    }
  }
  
  public boolean a(apqk.c paramc, boolean paramBoolean)
  {
    if (paramc == null) {
      return false;
    }
    if (((paramc instanceof MessageForDeliverGiftTips)) && (!aptj.c((MessageForDeliverGiftTips)paramc))) {
      return false;
    }
    a(paramc);
    if (paramBoolean)
    {
      setChanged();
      notifyObservers(paramc);
    }
    return true;
  }
  
  public boolean a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (!aBs()) {}
    do
    {
      return false;
      ebp();
    } while (!b(paramMessageForDeliverGiftTips));
    ebq();
    return true;
  }
  
  public boolean a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips, boolean paramBoolean)
  {
    if (paramMessageForDeliverGiftTips == null) {}
    while (!aptj.c(paramMessageForDeliverGiftTips)) {
      return false;
    }
    a(paramMessageForDeliverGiftTips);
    if (paramMessageForDeliverGiftTips.interactState == 2) {
      ebq();
    }
    for (;;)
    {
      return true;
      ((apsz)this.mApp.getManager(113)).a(paramMessageForDeliverGiftTips.frienduin, paramMessageForDeliverGiftTips.interactId, paramMessageForDeliverGiftTips.giftId, new apqp(this, paramMessageForDeliverGiftTips, paramBoolean));
    }
  }
  
  public boolean a(MessageForTroopEffectPic paramMessageForTroopEffectPic, boolean paramBoolean)
  {
    String str = "" + paramMessageForTroopEffectPic.effectId;
    if ((paramMessageForTroopEffectPic.effectId < 40003) || (paramMessageForTroopEffectPic.effectId > 40005))
    {
      this.oo.put(str, Integer.valueOf(3));
      if (paramBoolean) {
        return a(paramMessageForTroopEffectPic, false);
      }
      return false;
    }
    int i;
    if ((this.oo.containsKey(str)) && (((Integer)this.oo.get(str)).intValue() == 3)) {
      if (!aptj.mj(paramMessageForTroopEffectPic.effectId))
      {
        this.oo.remove(str);
        aqhq.deleteFile(aptj.fN(paramMessageForTroopEffectPic.effectId));
        a(paramMessageForTroopEffectPic.effectId, paramMessageForTroopEffectPic.frienduin, paramMessageForTroopEffectPic);
        i = 2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAnimationControlManager", 2, "MessageForTroopEffectPic id:" + str + ",state:" + i);
      }
      if (!paramBoolean) {
        break;
      }
      return a(paramMessageForTroopEffectPic, false);
      i = 3;
      continue;
      a(paramMessageForTroopEffectPic.effectId, paramMessageForTroopEffectPic.frienduin, paramMessageForTroopEffectPic);
      i = 2;
    }
    return i == 2;
  }
  
  protected boolean aBs()
  {
    return cqs.equals(this.cqt);
  }
  
  public boolean aBt()
  {
    return (this.playState == 1) || (this.playState == 4);
  }
  
  public boolean b(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (!aptj.c(paramMessageForDeliverGiftTips)) {
      return false;
    }
    String str = aptj.b(paramMessageForDeliverGiftTips);
    int i;
    boolean bool;
    if ((this.oo.containsKey(str)) && (((Integer)this.oo.get(str)).intValue() == 3)) {
      if (!aptj.h(str, paramMessageForDeliverGiftTips.animationType, paramMessageForDeliverGiftTips.isInteract()))
      {
        this.oo.remove(str);
        aqhq.cn(aptj.a(paramMessageForDeliverGiftTips));
        a(str, paramMessageForDeliverGiftTips);
        i = 2;
        if (QLog.isColorLevel()) {
          QLog.d("AIOAnimationControlManager", 2, "giftRealAnimationId:" + aptj.b(paramMessageForDeliverGiftTips) + ",state:" + i);
        }
        if ((aBs()) && (i != 3)) {
          break label189;
        }
        if (!paramMessageForDeliverGiftTips.isInteract()) {
          break label179;
        }
        bool = a(paramMessageForDeliverGiftTips, false);
      }
    }
    for (;;)
    {
      return bool;
      i = 3;
      break;
      a(str, paramMessageForDeliverGiftTips);
      i = 4;
      break;
      label179:
      bool = a(paramMessageForDeliverGiftTips, false);
      continue;
      label189:
      bool = false;
    }
  }
  
  public boolean bw(boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.arS == 0L)
    {
      bool1 = bool2;
      if (paramBoolean)
      {
        this.arS = System.currentTimeMillis();
        this.dVp = 1;
        bool1 = bool2;
      }
    }
    for (;;)
    {
      if ((this.aa != null) && (paramBoolean))
      {
        this.aa.edit().putLong("AIOAnimationControlManager_limit_gif_time", this.arS).apply();
        this.aa.edit().putInt("AIOAnimationControlManager_limit_gif_count", this.dVp).apply();
      }
      return bool1;
      if (System.currentTimeMillis() - this.arS < 3600000L)
      {
        dVo = this.aa.getInt("AIOAnimationControlManager_limit_gif_count_MAX", dVo);
        if (this.dVp >= dVo)
        {
          this.playState = 4;
          bool1 = true;
        }
        else
        {
          bool1 = bool2;
          if (paramBoolean)
          {
            this.dVp += 1;
            bool1 = bool2;
          }
        }
      }
      else
      {
        bool1 = bool2;
        if (paramBoolean)
        {
          this.arS = System.currentTimeMillis();
          this.dVp = 1;
          bool1 = bool2;
        }
      }
    }
  }
  
  public void cp(Activity paramActivity)
  {
    if (this.b == null) {
      this.b = new apwy(null, paramActivity, this.mApp);
    }
    this.b.Xh(4);
    this.mActivity = this.b.getActivity();
    this.cqt = cqs;
  }
  
  public void d(Observer paramObserver)
  {
    apqk.b.a().addObserver(paramObserver);
  }
  
  public long[] d(String paramString)
  {
    Object localObject = (List)this.op.get(paramString);
    paramString = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        apqk.c localc = (apqk.c)((Iterator)localObject).next();
        if ((localc instanceof MessageForDeliverGiftTips)) {
          paramString.add(Long.valueOf(((MessageForDeliverGiftTips)localc).getId()));
        }
      }
    }
    localObject = new long[paramString.size()];
    int i = 0;
    while (i < paramString.size())
    {
      localObject[i] = ((Long)paramString.get(i)).longValue();
      i += 1;
    }
    return localObject;
  }
  
  public void e(SharedPreferences paramSharedPreferences)
  {
    this.aa = paramSharedPreferences;
    this.arS = this.aa.getLong("AIOAnimationControlManager_limit_gif_time", 0L);
    this.dVp = this.aa.getInt("AIOAnimationControlManager_limit_gif_count", 0);
  }
  
  public void e(Observer paramObserver)
  {
    apqk.b.a().deleteObserver(paramObserver);
  }
  
  public void ebl()
  {
    int i = 0;
    Object localObject = new File(aptj.fN(0)).getParentFile();
    if (((File)localObject).exists())
    {
      localObject = ((File)localObject).listFiles();
      if (localObject == null) {}
    }
    for (;;)
    {
      if (i < localObject.length)
      {
        if (localObject[i].exists())
        {
          String str = localObject[i].getName();
          try
          {
            str = str.substring(0, str.indexOf(".mp4"));
            if (aptj.mj(Integer.parseInt(str))) {
              this.oo.put(str, Integer.valueOf(3));
            } else {
              localObject[i].delete();
            }
          }
          catch (Exception localException)
          {
            if (!QLog.isColorLevel()) {
              break label145;
            }
          }
          QLog.e("AIOAnimationControlManager", 2, "checkPicEffectPackageIdState: " + QLog.getStackTraceString(localException));
        }
      }
      else {
        return;
      }
      label145:
      i += 1;
    }
  }
  
  public void ebm()
  {
    if (this.mBaseChatPie != null) {}
    for (Object localObject = this.mBaseChatPie.sessionInfo.aTl;; localObject = this.cqt)
    {
      localObject = (List)this.op.get(localObject);
      if ((!this.cRY) || (aptj.isListEmpty((List)localObject))) {
        break label135;
      }
      int j;
      for (int i = 0; i < ((List)localObject).size(); i = j + 1)
      {
        apqk.c localc = (apqk.c)((List)localObject).get(i);
        j = i;
        if (localc.isReaded())
        {
          j = i;
          if (localc.getSenderUin() != this.mApp.getLongAccountUin())
          {
            ((List)localObject).remove(i);
            j = i - 1;
          }
        }
      }
    }
    Collections.sort((List)localObject, this.ah);
    label135:
    this.cRY = true;
  }
  
  public void ebn()
  {
    deleteObservers();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationControlManager", 2, "release TroopChatPie ,troopUin:" + this.cqt);
    }
    apqk.b.a().deleteObservers();
    this.op.remove(this.cqt);
    this.oq.remove(this.cqt);
    this.mBaseChatPie = null;
    this.b = null;
    this.playState = 1;
    this.jdField_a_of_type_Apxr = null;
  }
  
  public void ebo()
  {
    apqk.b.a().deleteObservers();
    this.mActivity = null;
    this.op.remove(this.cqt);
    this.oq.remove(this.cqt);
    this.b = null;
    this.playState = 1;
  }
  
  public void ebp()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationControlManager", 2, "releaseAnimationList");
    }
    if (this.mBaseChatPie != null) {}
    for (String str = this.mBaseChatPie.sessionInfo.aTl;; str = this.cqt)
    {
      this.op.remove(str);
      this.oq.remove(str);
      if (this.b != null)
      {
        this.b.onPause();
        this.playState = 1;
      }
      return;
    }
  }
  
  public void ebq()
  {
    Sa(false);
  }
  
  public void ebr()
  {
    if (apot.a().isPlaying()) {
      apot.a().stop();
    }
    if ((this.b != null) && (this.b.isPlaying())) {
      this.b.onPause();
    }
    if ((this.jdField_a_of_type_Apxr != null) && (!this.jdField_a_of_type_Apxr.aBG())) {
      this.jdField_a_of_type_Apxr.ecD();
    }
    if (this.jdField_a_of_type_Apyu != null) {
      this.jdField_a_of_type_Apyu.ecF();
    }
    this.playState = 1;
  }
  
  public int jL(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (1 == paramInt) {
      return aado.a().yz();
    }
    return 0;
  }
  
  public boolean nU(String paramString)
  {
    return (!this.oo.containsKey(paramString)) || (((Integer)this.oo.get(paramString)).intValue() != 3);
  }
  
  public void onDestroy()
  {
    apqk.b.a().deleteObservers();
    if ((this.mApp != null) && (QLog.isColorLevel())) {
      QLog.d("AIOAnimationControlManager", 2, "clear History. uin:" + this.mApp.getAccount() + " app=" + String.valueOf(this.mApp));
    }
    this.mBaseChatPie = null;
    this.mActivity = null;
    this.mHandler = null;
  }
  
  public boolean qH(String paramString)
  {
    List localList = (List)this.oq.get(paramString);
    if ((localList != null) && (!localList.isEmpty())) {
      return true;
    }
    paramString = (List)this.op.get(paramString);
    return (paramString != null) && (paramString.size() != 0);
  }
  
  public static class a
  {
    public String cqv;
    public boolean isFinish;
  }
  
  public static class b
    extends Observable
  {
    private static b a;
    
    public static b a()
    {
      if (a == null) {}
      try
      {
        if (a == null) {
          a = new b();
        }
        return a;
      }
      finally {}
    }
    
    public void setChanged()
    {
      super.setChanged();
    }
  }
  
  public static abstract interface c
  {
    public abstract String getFriendUin();
    
    public abstract int getLimitType();
    
    public abstract long getSenderUin();
    
    public abstract long getShmsgseq();
    
    public abstract boolean isReaded();
  }
  
  public static abstract interface d
  {
    public abstract void cR(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apqk
 * JD-Core Version:    0.7.0.1
 */