import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FrameHelperActivity.d;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.DrawerCoverUtil.1;
import com.tencent.util.DrawerCoverUtil.3;
import com.tencent.util.DrawerCoverUtil.4;
import java.io.File;
import java.util.Map;
import mqq.os.MqqHandler;

public class aura
{
  public static String aRP;
  private static boolean djF;
  
  public static void Zw(String paramString)
  {
    aRP = paramString;
  }
  
  public static VasQuickUpdateManager.CallBacker a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, Card paramCard, RandomCoverView paramRandomCoverView, String paramString, FrameHelperActivity.d paramd, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "now is in drawer frame?" + paramBoolean);
    }
    if (!a(paramQQAppInterface, paramCard))
    {
      ThreadManager.getUIHandler().post(new DrawerCoverUtil.1(paramRandomCoverView, paramString));
      ewp();
    }
    for (;;)
    {
      return null;
      if (!b(paramQQAppInterface, paramCard))
      {
        if ((paramCard.lCurrentBgId == 160L) || (paramCard.lCurrentBgId == 1600L) || (alcs.cy(paramCard.lCurrentStyleId)))
        {
          c(paramQQAppInterface, paramCard);
          a(paramBaseActivity, paramQQAppInterface, paramCard, paramRandomCoverView, paramd, paramBoolean);
        }
        else
        {
          ((aqrc)paramQQAppInterface.getManager(235)).b.av(paramQQAppInterface, "card." + paramCard.lCurrentBgId);
          paramQQAppInterface = (VasQuickUpdateManager)paramQQAppInterface.getManager(184);
          paramBaseActivity = new aurb(paramBaseActivity, paramCard, paramRandomCoverView, paramd, paramBoolean);
          paramQQAppInterface.addWeakCallback(paramBaseActivity);
          return paramBaseActivity;
        }
      }
      else {
        a(paramBaseActivity, paramQQAppInterface, paramCard, paramRandomCoverView, paramd, paramBoolean);
      }
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, Card paramCard, RandomCoverView paramRandomCoverView, FrameHelperActivity.d paramd, boolean paramBoolean)
  {
    long l = paramCard.lCurrentBgId;
    Object localObject = (Boolean)alco.ms.get(Long.valueOf(l));
    int i;
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      i = 1;
      alco.ms.remove(Long.valueOf(l));
    }
    for (;;)
    {
      localObject = paramd.a(paramCard.strDrawerCardUrl);
      Zw(paramCard.strDrawerCardUrl);
      if ((localObject == null) || (i != 0))
      {
        if ((l == 160L) || (l == 1600L) || (alcs.cy(paramCard.lCurrentStyleId))) {}
        for (paramQQAppInterface = aqep.I(paramBaseActivity, paramCard.strDrawerCardUrl);; paramQQAppInterface = alco.b(paramQQAppInterface.getApp(), paramCard.lCurrentStyleId, paramCard.lCurrentBgId))
        {
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
          localObject = aqcu.decodeFile(paramQQAppInterface, (BitmapFactory.Options)localObject);
          if (localObject != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.", 2, "[personal card] fileName:" + paramQQAppInterface + " bitmap:" + localObject);
            }
            ThreadManager.getUIHandler().post(new DrawerCoverUtil.3(paramBaseActivity, (Bitmap)localObject, paramRandomCoverView, paramBoolean, paramd, paramCard));
          }
          return;
        }
      }
      ThreadManager.getUIHandler().post(new DrawerCoverUtil.4(paramRandomCoverView, (auvn)localObject, paramBoolean));
      return;
      i = 0;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Card paramCard)
  {
    CardHandler localCardHandler = (CardHandler)paramQQAppInterface.getBusinessHandler(2);
    if (localCardHandler == null) {}
    do
    {
      return;
      byte b = (byte)aqmj.aG(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin());
      byte[] arrayOfByte1 = null;
      byte[] arrayOfByte2 = null;
      if (0 == 0)
      {
        arrayOfByte1 = new byte[1];
        arrayOfByte1[0] = 0;
      }
      if (0 == 0)
      {
        arrayOfByte2 = new byte[1];
        arrayOfByte2[0] = 0;
      }
      long l = paramCard.feedPreviewTime;
      localCardHandler.a(paramQQAppInterface.getCurrentAccountUin(), paramQQAppInterface.getCurrentUin(), 0, l, (byte)1, 0L, 0L, arrayOfByte1, "", 0L | 1L | 0x4 | 0x8 | 0x200 | 0x10 | 0x20 | 0x400 | 0x800 | 0x2000, 10004, arrayOfByte2, b);
    } while (!QLog.isColorLevel());
    QLog.d("Q.profilecard.", 2, "fetch profilecard info failure from cache,restart to fetch from net");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Card paramCard)
  {
    paramQQAppInterface = aqep.a(paramQQAppInterface, paramCard.lCurrentStyleId, true);
    boolean bool = anlm.ayn();
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "[check cardTemplate]lCurrentStyleId:" + paramCard.lCurrentStyleId + " backgroundUrl:" + paramCard.strDrawerCardUrl + " templateRet:" + paramCard.templateRet + " isSimpleUI:" + bool);
    }
    if (bool) {}
    do
    {
      return false;
      if (alcs.cy(paramCard.lCurrentStyleId)) {
        return true;
      }
    } while ((paramCard.lCurrentStyleId <= 0L) || (paramQQAppInterface == null) || (TextUtils.isEmpty(paramCard.strDrawerCardUrl)) || (paramCard.templateRet != 0));
    return true;
  }
  
  public static boolean aJA()
  {
    return djF;
  }
  
  public static boolean aJz()
  {
    return aRP != null;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, Card paramCard)
  {
    if ((paramCard.lCurrentBgId == 160L) || (paramCard.lCurrentBgId == 1600L) || (alcs.cy(paramCard.lCurrentStyleId))) {
      return aqep.aj(paramQQAppInterface.getApp(), paramCard.strDrawerCardUrl);
    }
    return new File(alco.b(paramQQAppInterface.getApp(), paramCard.lCurrentStyleId, paramCard.lCurrentBgId)).exists();
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, Card paramCard)
  {
    Object localObject = new File(aqep.I(paramQQAppInterface.getApplication(), paramCard.strDrawerCardUrl));
    localObject = new aquz(paramCard.strDrawerCardUrl, (File)localObject);
    ((aquz)localObject).cxX = "profileCardDownload";
    ((aquz)localObject).cxW = "VIP_profilecard";
    int i = aqva.a((aquz)localObject, paramQQAppInterface);
    if (i == 0) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.e("DIYProfileTemplate.DrawerCover", 1, "download error:" + i);
    }
    for (;;)
    {
      return false;
      QLog.e("DIYProfileTemplate.DrawerCover", 1, "download {" + paramCard.strDrawerCardUrl + "} error:" + i);
    }
  }
  
  public static void ewp()
  {
    aRP = null;
  }
  
  public static void ewq()
  {
    djF = true;
  }
  
  public static void ewr()
  {
    djF = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aura
 * JD-Core Version:    0.7.0.1
 */