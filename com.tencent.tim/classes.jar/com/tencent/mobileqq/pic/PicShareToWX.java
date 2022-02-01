package com.tencent.mobileqq.pic;

import aeif;
import aema.a;
import akxs;
import akxt;
import akxu;
import akyf;
import akyf.a;
import amxk;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import anot;
import anpc;
import aooi;
import aool;
import aqhu;
import arhz;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;
import java.util.HashMap;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public class PicShareToWX
  implements IWXAPIEventHandler
{
  private static volatile PicShareToWX jdField_a_of_type_ComTencentMobileqqPicPicShareToWX;
  public arhz a;
  private TimeoutRunnable jdField_a_of_type_ComTencentMobileqqPicPicShareToWX$TimeoutRunnable;
  private akxs b;
  private aool e;
  private QQAppInterface mApp;
  private int mCallbackId;
  private boolean mCanceled;
  private Context mContext;
  private long mFileSize;
  private int mFromType;
  
  public static PicShareToWX a()
  {
    if (jdField_a_of_type_ComTencentMobileqqPicPicShareToWX == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqPicPicShareToWX == null) {
        jdField_a_of_type_ComTencentMobileqqPicPicShareToWX = new PicShareToWX();
      }
      return jdField_a_of_type_ComTencentMobileqqPicPicShareToWX;
    }
    finally {}
  }
  
  public static void a(String paramString, Context paramContext, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param_pic_path", paramString);
    localBundle.putInt("param_from_type", paramInt);
    paramString = new akxu();
    QIPCClientHelper.getInstance().callServer("PicSTWXQIPCModule", "action_share_pic_to_wx", localBundle, paramString);
    a().eK(paramContext);
  }
  
  public static void bJ(int paramInt, boolean paramBoolean)
  {
    String str;
    if (paramInt == 1) {
      if (paramBoolean) {
        str = "0X800A500";
      }
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      return;
      str = "0X800A501";
      continue;
      if (paramInt == 2)
      {
        if (paramBoolean) {}
        for (str = "0X800A503";; str = "0X800A504") {
          break;
        }
      }
      if (paramInt == 3)
      {
        if (paramBoolean) {}
        for (str = "0X800A506";; str = "0X800A507") {
          break;
        }
      }
      str = "";
    }
  }
  
  private void r(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {
      localHashMap.put("param_succ_flag", "1");
    }
    for (;;)
    {
      localHashMap.put("param_picSize", String.valueOf(this.mFileSize));
      localHashMap.put("param_errorStep", String.valueOf(paramInt2));
      localHashMap.put("param_FailCode", String.valueOf(paramInt1));
      localHashMap.put("param_fromType", String.valueOf(this.mFromType));
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "actPicShareToWX", paramBoolean, 0L, 0L, localHashMap, null);
      return;
      localHashMap.put("param_succ_flag", "0");
    }
  }
  
  public boolean A(File paramFile)
  {
    aema.a locala = (aema.a)aeif.a().o(530);
    return paramFile.length() < locala.Wz;
  }
  
  public void a(akxs paramakxs, int paramInt1, QQAppInterface paramQQAppInterface, String paramString, int paramInt2)
  {
    this.mFromType = paramInt2;
    this.b = paramakxs;
    this.mCallbackId = paramInt1;
    au(paramQQAppInterface, paramString);
  }
  
  public void a(String paramString, Bitmap paramBitmap, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWX", 1, "doShareToWX");
    }
    aema.a locala = (aema.a)aeif.a().o(530);
    akxt localakxt = new akxt(this, paramInt);
    String str = locala.mPath + "url=" + amxk.hu(paramString);
    WXShareHelper.a().a(localakxt);
    WXShareHelper.a().a(str, paramString, locala.mUserName, paramBitmap, locala.mTitle, locala.mDesc, locala.bVa, locala.cNK);
  }
  
  public int aj(Context paramContext)
  {
    return paramContext.getResources().getDimensionPixelSize(2131299627);
  }
  
  public void au(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.mCanceled = false;
    aool localaool = new aool();
    localaool.mFileType = 66;
    localaool.dQ = paramString;
    this.mFileSize = new File(paramString).length();
    localaool.b = new a(paramString);
    localaool.mUniseq = System.currentTimeMillis();
    this.e = localaool;
    if (paramQQAppInterface != null)
    {
      this.mApp = paramQQAppInterface;
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(localaool);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX$TimeoutRunnable = new TimeoutRunnable(null);
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX$TimeoutRunnable, 5000L);
  }
  
  public void b(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    this.mFromType = paramInt;
    eK(paramContext);
    au(paramQQAppInterface, paramString);
  }
  
  public void dDW()
  {
    if (this.mContext != null) {
      QQToast.a(this.mContext, 2131720153, 0).show();
    }
  }
  
  public void eK(Context paramContext)
  {
    this.mContext = paramContext;
    if (this.jdField_a_of_type_Arhz == null) {
      this.jdField_a_of_type_Arhz = new arhz(paramContext, aj(paramContext));
    }
    this.jdField_a_of_type_Arhz.setMessage(2131700604);
    this.jdField_a_of_type_Arhz.show();
  }
  
  public boolean isEnable()
  {
    return ((aema.a)aeif.a().o(530)).mEnable;
  }
  
  public boolean nQ(String paramString)
  {
    paramString = new File(paramString);
    aema.a locala = (aema.a)aeif.a().o(530);
    return paramString.length() < locala.Wz;
  }
  
  public void onReq(BaseReq paramBaseReq) {}
  
  public void onResp(BaseResp paramBaseResp) {}
  
  public void reset()
  {
    this.jdField_a_of_type_Arhz = null;
    this.e = null;
    this.mApp = null;
    this.mContext = null;
    this.b = null;
    this.mCallbackId = 0;
  }
  
  public void stopLoading()
  {
    if (this.jdField_a_of_type_Arhz != null) {
      this.jdField_a_of_type_Arhz.dismiss();
    }
  }
  
  class TimeoutRunnable
    implements Runnable
  {
    private TimeoutRunnable() {}
    
    public void run()
    {
      PicShareToWX.a(PicShareToWX.this, true);
      if ((PicShareToWX.a(PicShareToWX.this) != null) && (PicShareToWX.a(PicShareToWX.this) != null)) {
        PicShareToWX.a(PicShareToWX.this).a().a(PicShareToWX.a(PicShareToWX.this));
      }
      if (PicShareToWX.a(PicShareToWX.this) != null) {
        PicShareToWX.a(PicShareToWX.this).callbackResult(PicShareToWX.a(PicShareToWX.this), EIPCResult.createResult(-102, null));
      }
      PicShareToWX.bJ(PicShareToWX.b(PicShareToWX.this), false);
      PicShareToWX.a(PicShareToWX.this, false, 12345, 0);
      PicShareToWX.this.stopLoading();
      PicShareToWX.this.dDW();
      PicShareToWX.this.reset();
    }
  }
  
  public class a
    implements akyf
  {
    private String dQ;
    
    a(String paramString)
    {
      this.dQ = paramString;
    }
    
    public MessageRecord a(im_msg_body.RichText paramRichText)
    {
      return null;
    }
    
    public void a(akyf.a parama) {}
    
    public void b(akyf.a parama)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PicShareToWX", 1, "onSend, result.result = " + parama.result);
      }
      if (PicShareToWX.a(PicShareToWX.this) != null) {
        ThreadManager.getUIHandler().removeCallbacks(PicShareToWX.a(PicShareToWX.this));
      }
      if (PicShareToWX.this.a != null) {
        PicShareToWX.this.a.dismiss();
      }
      if (parama.result != 0)
      {
        if (PicShareToWX.a(PicShareToWX.this) != null) {
          PicShareToWX.a(PicShareToWX.this).callbackResult(PicShareToWX.a(PicShareToWX.this), EIPCResult.createResult(-102, null));
        }
        if (PicShareToWX.a(PicShareToWX.this) != null) {
          QQToast.a(PicShareToWX.a(PicShareToWX.this), 2131720153, 0).show();
        }
        PicShareToWX.bJ(PicShareToWX.b(PicShareToWX.this), false);
        PicShareToWX.a(PicShareToWX.this, false, parama.result, 0);
      }
      for (;;)
      {
        PicShareToWX.this.reset();
        if ((parama.result == 0) && (!PicShareToWX.a(PicShareToWX.this)))
        {
          parama = parama.downUrl;
          Object localObject = new BitmapFactory.Options();
          aqhu.a((BitmapFactory.Options)localObject, this.dQ, 400);
          localObject = SafeBitmapFactory.decodeFile(this.dQ, (BitmapFactory.Options)localObject);
          PicShareToWX.this.a(parama, (Bitmap)localObject, PicShareToWX.b(PicShareToWX.this));
        }
        return;
        if (PicShareToWX.a(PicShareToWX.this) != null) {
          PicShareToWX.a(PicShareToWX.this).callbackResult(PicShareToWX.a(PicShareToWX.this), EIPCResult.createSuccessResult(null));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicShareToWX
 * JD-Core Version:    0.7.0.1
 */