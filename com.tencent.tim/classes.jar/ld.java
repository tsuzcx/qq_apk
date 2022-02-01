import android.os.Bundle;
import android.text.TextUtils;
import com.etrump.mixlayout.VasFontIPCModule.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.TipsInfo;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ld
  extends QIPCModule
{
  private static ld jdField_a_of_type_Ld;
  public static String eA = "action_change_status";
  public static String eB = "action_get_action";
  public static String eC = "action_download_use_quickupdate";
  public static String eD = "action_get_shield_font";
  public static String eE = "action_get_history_signature_num";
  public static String er = "action_download_hy_so";
  public static String es = "action_download_fz_so";
  public static String et = "action_download_font";
  public static String eu = "action_download_signature_config";
  public static String ez = "action_get_my_signature";
  private AtomicBoolean N = new AtomicBoolean(false);
  private AtomicBoolean O = new AtomicBoolean(false);
  private VasQuickUpdateManager.CallBacker jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new le(this);
  private Vector<Integer> e = new Vector();
  private Vector<Integer> f = new Vector();
  private AtomicInteger k = new AtomicInteger(0);
  private AtomicInteger o = new AtomicInteger(0);
  private AtomicInteger p = new AtomicInteger(0);
  private ConcurrentHashMap<Integer, Integer> v = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> y = new ConcurrentHashMap();
  
  private ld(String paramString)
  {
    super(paramString);
  }
  
  public static ld a()
  {
    try
    {
      if (jdField_a_of_type_Ld == null) {
        jdField_a_of_type_Ld = new ld("VasFontIPCModule");
      }
      ld localld = jdField_a_of_type_Ld;
      return localld;
    }
    finally {}
  }
  
  public void C(int paramInt1, int paramInt2)
  {
    Integer localInteger;
    Object localObject;
    switch (paramInt1)
    {
    case 2: 
    case 3: 
    default: 
      return;
    case 1: 
      this.N.set(false);
      localVector = new Vector(this.e);
      localIterator = localVector.iterator();
      while (localIterator.hasNext())
      {
        localInteger = (Integer)localIterator.next();
        localObject = new Bundle();
        ((Bundle)localObject).putInt("font_type", paramInt1);
        localObject = EIPCResult.createResult(paramInt2, (Bundle)localObject);
        callbackResult(localInteger.intValue(), (EIPCResult)localObject);
      }
      this.e.removeAll(localVector);
      return;
    }
    this.O.set(false);
    Vector localVector = new Vector(this.f);
    Iterator localIterator = localVector.iterator();
    while (localIterator.hasNext())
    {
      localInteger = (Integer)localIterator.next();
      localObject = new Bundle();
      ((Bundle)localObject).putInt("font_type", paramInt1);
      localObject = EIPCResult.createResult(paramInt2, (Bundle)localObject);
      callbackResult(localInteger.intValue(), (EIPCResult)localObject);
    }
    this.f.removeAll(localVector);
  }
  
  public void D(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature", 2, "onGetHistorySigNum result = " + paramInt1);
    }
    if (this.k.get() > 0)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putInt("notify_type", 9);
      ((Bundle)localObject).putInt("result", paramInt1);
      ((Bundle)localObject).putInt("key_history_signature_num", paramInt2);
      localObject = EIPCResult.createResult(0, (Bundle)localObject);
      callbackResult(this.k.get(), (EIPCResult)localObject);
      this.k.set(0);
    }
  }
  
  public void E(int paramInt1, int paramInt2)
  {
    if ((this.p.get() > 0) && (this.o.get() > 0) && (paramInt1 == 102) && (paramInt2 == 300) && (BaseApplicationImpl.getApplication() != null) && ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)))
    {
      amev localamev = ((amhj)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(15)).a(this.p.get());
      if (localamev != null)
      {
        Object localObject = new Bundle();
        ((Bundle)localObject).putInt("notify_type", 6);
        ((Bundle)localObject).putString("url", localamev.bZO);
        ((Bundle)localObject).putInt("id", this.p.get());
        localObject = EIPCResult.createResult(0, (Bundle)localObject);
        callbackResult(this.o.get(), (EIPCResult)localObject);
        this.o.set(0);
        this.p.set(0);
        if (QLog.isColorLevel()) {
          QLog.d("Signature", 2, "IPC get action callback id = " + this.p.get() + " url = " + localamev.bZO);
        }
      }
    }
  }
  
  public void a(int paramInt1, RichStatus paramRichStatus, TipsInfo paramTipsInfo, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature", 2, "onChangeStatus result = " + paramInt1);
    }
    if (this.k.get() > 0)
    {
      paramRichStatus = new Bundle();
      paramRichStatus.putInt("notify_type", 5);
      paramRichStatus.putInt("result", paramInt1);
      paramRichStatus.putInt("type", paramInt2);
      if ((paramTipsInfo != null) && (paramTipsInfo.errorDesc != null)) {
        paramRichStatus.putString("errorDesc", paramTipsInfo.errorDesc);
      }
      if (paramInt2 == 0)
      {
        paramRichStatus.putBoolean("hasTipsInfo", false);
        if (paramTipsInfo.type > 0)
        {
          paramRichStatus.putInt("result", paramTipsInfo.ret);
          paramRichStatus.putBoolean("hasTipsInfo", true);
          paramRichStatus.putInt("tips_type", paramTipsInfo.type);
          paramRichStatus.putString("tips_titleWording", paramTipsInfo.titleWording);
          paramRichStatus.putString("tips_wording", paramTipsInfo.wording);
          paramRichStatus.putString("tips_rightBtnWording", paramTipsInfo.rightBtnWording);
          paramRichStatus.putString("tips_leftBtnWording", paramTipsInfo.leftBtnWording);
          paramRichStatus.putString("tips_vipType", paramTipsInfo.vipType);
          paramRichStatus.putInt("tips_vipMonth", paramTipsInfo.vipMonth);
          paramRichStatus.putString("tips_url", paramTipsInfo.url);
          paramRichStatus.putInt("authAppid", paramTipsInfo.authAppid);
        }
      }
      paramRichStatus = EIPCResult.createResult(0, paramRichStatus);
      callbackResult(this.k.get(), paramRichStatus);
      this.k.set(0);
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasFontIPCModule", 2, "onCall action = " + paramString);
    }
    QQAppInterface localQQAppInterface;
    if ((BaseApplicationImpl.getApplication() != null) && ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)))
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (!er.equals(paramString)) {
        break label88;
      }
      ThreadManagerV2.executeOnSubThread(new VasFontIPCModule.1(this, paramInt, localQQAppInterface), true);
    }
    label88:
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            do
            {
              return null;
              if (et.equals(paramString))
              {
                i = paramBundle.getInt("id");
                int j = paramBundle.getInt("font_type");
                ((ku)localQQAppInterface.getManager(42)).b(i, Integer.toString(paramInt), j);
                return null;
              }
              if (!es.equals(paramString)) {
                break;
              }
              if (new File(aqnl.getSoDir() + "libFounderColorFont_818.so").exists())
              {
                callbackResult(paramInt, EIPCResult.createResult(0, null));
                return null;
              }
              this.f.add(Integer.valueOf(paramInt));
            } while (!this.O.compareAndSet(false, true));
            ((VasQuickUpdateManager)localQQAppInterface.getManager(184)).downloadItem(1004L, "libColorFont_818", "VasFontIPCModule");
            return null;
            if (!eu.equals(paramString)) {
              break;
            }
            i = paramBundle.getInt("id");
          } while ((i <= 0) || (this.v.containsKey(Integer.valueOf(i))));
          this.v.put(Integer.valueOf(i), Integer.valueOf(paramInt));
          paramString = "signature.item." + i + ".json";
          paramBundle = (VasQuickUpdateManager)localQQAppInterface.getManager(184);
          paramBundle.addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
          paramBundle.downloadItem(1000L, paramString, "VasFontIPCModule");
          return null;
          if (ez.equals(paramString))
          {
            paramString = ((amhj)localQQAppInterface.getManager(15)).a(true);
            paramBundle = new Bundle();
            paramBundle.putInt("notify_type", 4);
            paramBundle.putSerializable("my_signature", paramString);
            callbackResult(paramInt, EIPCResult.createResult(0, paramBundle));
            return null;
          }
          if (eA.equals(paramString))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Signature", 2, "ACTION_CHANGE_STATUS");
            }
            this.k.set(paramInt);
            paramString = paramBundle.getSerializable("my_signature");
            if ((paramString instanceof RichStatus))
            {
              paramString = (RichStatus)paramString;
              ((amhj)localQQAppInterface.getManager(15)).a(paramString, 0);
              return null;
            }
            QLog.e("VasFontIPCModule", 1, "change status error, status is null");
            new Bundle().putInt("notify_type", 5);
            callbackResult(paramInt, EIPCResult.createResult(-102, null));
            return null;
          }
          if (!eB.equals(paramString)) {
            break label709;
          }
          i = paramBundle.getInt("id");
          paramString = ((amhj)localQQAppInterface.getManager(15)).a(i);
          if (paramString != null) {
            break;
          }
          this.o.set(paramInt);
          this.p.set(i);
        } while (!QLog.isColorLevel());
        QLog.d("Signature", 2, "IPC get action fail, wait for callback id = " + i);
        return null;
        paramBundle = new Bundle();
        paramBundle.putInt("notify_type", 6);
        paramBundle.putString("url", paramString.bZO);
        paramBundle.putInt("id", i);
        callbackResult(paramInt, EIPCResult.createResult(0, paramBundle));
      } while (!QLog.isColorLevel());
      QLog.d("Signature", 2, "IPC get action success id = " + i + " url = " + paramString.bZO);
      return null;
      long l;
      if (eC.equals(paramString))
      {
        l = paramBundle.getLong("bid");
        paramString = paramBundle.getString("scid");
        if (TextUtils.isEmpty(paramString))
        {
          callbackResult(paramInt, EIPCResult.createResult(-102, null));
          return null;
        }
        if (this.y.containsKey(paramString))
        {
          paramBundle = new Bundle();
          paramBundle.putInt("notify_type", 8);
          paramBundle.putLong("bid", l);
          paramBundle.putString("scid", paramString);
          paramBundle.putInt("download_result", 1);
          callbackResult(paramInt, EIPCResult.createResult(0, paramBundle));
          return null;
        }
        this.y.put(paramString, Integer.valueOf(paramInt));
        paramBundle = (VasQuickUpdateManager)localQQAppInterface.getManager(184);
        paramBundle.addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
        paramBundle.downloadItem(l, paramString, "VasFontIPCModule");
        return null;
      }
      if (eD.equals(paramString))
      {
        paramString = new Bundle();
        paramString.putInt("key_shield_font", lf.iN);
        callbackResult(paramInt, EIPCResult.createResult(0, paramString));
        return null;
      }
      if (eE.equals(paramString))
      {
        l = paramBundle.getLong("key_current_uin");
        this.k.set(paramInt);
        ((amhj)localQQAppInterface.getManager(15)).hP(l);
        return null;
      }
    } while (!QLog.isColorLevel());
    label709:
    QLog.d("VasFontIPCModule", 2, "onCall action = " + paramString);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ld
 * JD-Core Version:    0.7.0.1
 */