package com.tencent.mobileqq.emosm.favroaming;

import acef;
import afht;
import afhu;
import afhv;
import afnu;
import akyf;
import akyf.a;
import aool;
import axol;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import tencent.im.msg.im_msg_body.RichText;

public class FavEmoSingleSend
  extends AsyncStep
  implements akyf
{
  private acef a;
  private afhu jdField_b_of_type_Afhu;
  private afhv jdField_b_of_type_Afhv;
  private aool c;
  private final Object dA = new Object();
  private CustomEmotionData e;
  private boolean isResend;
  public boolean isSuccess;
  private Timer timer;
  
  public FavEmoSingleSend(CustomEmotionData paramCustomEmotionData, boolean paramBoolean)
  {
    this.isResend = paramBoolean;
    this.e = paramCustomEmotionData;
    initManager();
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(akyf.a parama) {}
  
  public void b(akyf.a arg1)
  {
    int j = 7;
    if (QLog.isColorLevel()) {
      QLog.d("FavEmoSingleSend", 2, new Object[] { "uploadCameraEmoList, ", ??? });
    }
    if (???.result == 0)
    {
      QLog.e("FavEmoSingleSend", 1, "uploadCameraEmoList success");
      j("isUpdate", 0, 0, 0);
      afnu.c(null, 3, ???.md5, null);
    }
    for (;;)
    {
      synchronized (this.dA)
      {
        this.dA.notify();
        return;
        if (-1 != ???.result) {
          continue;
        }
        QLog.e("FavEmoSingleSend", 1, new Object[] { "uploadCameraEmoList fail,  ret:", Integer.valueOf(???.errCode) });
        int i = 5;
        if (400010 == ???.errCode)
        {
          i = 6;
          j("failed", j, i, ???.errCode);
          continue;
        }
        if (400011 == ???.errCode)
        {
          j = 8;
          i = 7;
        }
      }
      j = 0;
    }
  }
  
  public void initManager()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)axol.getAppInterface();
    this.jdField_b_of_type_Afhv = ((afhv)localQQAppInterface.getManager(103));
    this.jdField_b_of_type_Afhu = ((afhu)localQQAppInterface.getManager(149));
    this.a = ((acef)localQQAppInterface.getBusinessHandler(72));
  }
  
  public void j(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramString == "isUpdate") {}
    for (boolean bool = true;; bool = false)
    {
      this.isSuccess = bool;
      this.e.RomaingType = paramString;
      this.jdField_b_of_type_Afhu.b(this.e);
      this.jdField_b_of_type_Afhu.trimCache();
      this.a.notifyUI(2, true, Integer.valueOf(paramInt1));
      afht.p(this.isSuccess, paramInt2, paramInt3);
      return;
    }
  }
  
  public int od()
  {
    QLog.d("FavEmoSingleSend", 1, new Object[] { "doStep, isResend: ", Boolean.valueOf(this.isResend), " ", this.e });
    this.c = this.jdField_b_of_type_Afhv.b(this.e, this);
    if (this.c == null)
    {
      QLog.d("FavEmoSingleSend", 1, "doStep, network not support");
      j("failed", 0, 3, 0);
      return 7;
    }
    this.timer = new Timer();
    this.timer.schedule(new FavEmoSingleSend.1(this), 30000L);
    try
    {
      synchronized (this.dA)
      {
        this.dA.wait(40000L);
        label126:
        this.timer.cancel();
        return 7;
      }
    }
    catch (Exception localException)
    {
      break label126;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavEmoSingleSend
 * JD-Core Version:    0.7.0.1
 */