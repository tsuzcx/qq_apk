import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.receipt.ReceiptMsgManager.1;
import com.tencent.mobileqq.receipt.ReceiptMsgManager.2;
import com.tencent.mobileqq.receipt.ReceiptMsgManager.3;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.a;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import tencent.im.msg.im_msg_body.RichText;

public class alte
{
  private static alte a;
  private SparseArray<Bitmap> dl = new SparseArray(8);
  public MessageForPtt f;
  private HashMap<String, String> lD = new HashMap();
  private Map<String, Boolean> mO;
  
  public static alte a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new alte();
      }
      return a;
    }
    finally {}
  }
  
  private AbsShareMsg a(int paramInt)
  {
    AbsShareMsg localAbsShareMsg = new AbsShareMsg.a(StructMsgForGeneralShare.class).c(107).a(BaseApplicationImpl.getContext().getString(2131700647)).a(3).a("viewReceiptMessage", "", null, null, null).a();
    antp localantp = new antp();
    anve localanve = new anve();
    localanve.type = paramInt;
    localantp.a(localanve);
    localAbsShareMsg.addItem(localantp);
    return localAbsShareMsg;
  }
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt)
  {
    Object localObject = ujt.a(paramQQAppInterface, paramSessionInfo, paramString);
    paramString = new ArrayList(1);
    if (localObject != null)
    {
      paramString.add(localObject);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("ReceiptMsgManager.EXTRA_KEY_PHOTO_SIZE_SPEC", paramInt);
      a(paramQQAppInterface, paramSessionInfo, paramString, (Bundle)localObject);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("ReceiptMsgManager", 2, "create pic msg error");
  }
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArrayList<ChatMessage> paramArrayList, @Nonnull Bundle paramBundle)
  {
    ThreadManager.post(new ReceiptMsgManager.2(this, paramArrayList, paramBundle, paramQQAppInterface, paramSessionInfo), 8, null, false);
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, AbsStructMsg paramAbsStructMsg, boolean paramBoolean, ArrayList<ChatMessage> paramArrayList, @Nullable Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMsgManager", 4, " sendReceiptMsg start");
    }
    paramString2 = this.lD;
    paramAbsStructMsg = aqmf.a(paramQQAppInterface, paramString1, paramInt, paramAbsStructMsg);
    if (paramAbsStructMsg != null)
    {
      paramAbsStructMsg.isReMultiMsg = true;
      if (paramBoolean) {
        paramQQAppInterface.b().t(paramString1, paramInt, 0L);
      }
      ajlc.a().a(paramQQAppInterface, paramString1, paramInt, paramArrayList, paramString2, paramAbsStructMsg, 5, paramBundle);
    }
  }
  
  private Bitmap c(Resources paramResources, int paramInt)
  {
    int i = wja.dp2px(10.0F, paramResources);
    int j = wja.dp2px(8.0F, paramResources);
    int k = wja.dp2px(175.0F, paramResources);
    int m = wja.dp2px(240.0F, paramResources);
    int n = wja.dp2px(108.0F, paramResources);
    Bitmap localBitmap1 = e(paramResources, paramInt);
    Bitmap localBitmap2 = BitmapFactory.decodeResource(paramResources, 2130838335);
    Canvas localCanvas = new Canvas();
    Bitmap localBitmap3 = Bitmap.createBitmap(m, n, Bitmap.Config.ARGB_8888);
    localBitmap3.setDensity(paramResources.getDisplayMetrics().densityDpi);
    localCanvas.setBitmap(localBitmap3);
    paramResources = new Paint();
    localCanvas.drawBitmap(localBitmap2, k, 0.0F, paramResources);
    localCanvas.drawBitmap(localBitmap1, i, j, paramResources);
    localBitmap1.recycle();
    localBitmap2.recycle();
    return localBitmap3;
  }
  
  private void c(MessageForPic paramMessageForPic, int paramInt)
  {
    CompressInfo localCompressInfo = new CompressInfo(paramMessageForPic.path, akyj.iA(paramInt), 1009);
    akyj.b(localCompressInfo);
    paramMessageForPic.path = localCompressInfo.destPath;
    paramMessageForPic.size = ahbj.getFileSize(paramMessageForPic.path);
  }
  
  private String calcMD5(String paramString)
  {
    long l = System.currentTimeMillis();
    try
    {
      String str1 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      paramString = str1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        paramString = new File(paramString);
        if (!paramString.exists()) {
          break;
        }
        try
        {
          String str2 = aszr.getFileMD5String(paramString);
          paramString = str2;
          if (str2 == null) {
            paramString = "";
          }
        }
        catch (IOException paramString)
        {
          paramString = "";
        }
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = "";
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMsgManager", 2, new Object[] { "calcMD5", "md5:" + paramString + ",cost:" + (System.currentTimeMillis() - l) });
    }
    return paramString;
  }
  
  private Bitmap d(Resources paramResources, int paramInt)
  {
    int i = wja.dp2px(10.0F, paramResources);
    int j = wja.dp2px(8.0F, paramResources);
    int k = wja.dp2px(245.0F, paramResources);
    int m = wja.dp2px(108.0F, paramResources);
    Bitmap localBitmap1 = e(paramResources, paramInt);
    Bitmap localBitmap2 = BitmapFactory.decodeResource(paramResources, 2130838334);
    Canvas localCanvas = new Canvas();
    Bitmap localBitmap3 = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
    localBitmap3.setDensity(paramResources.getDisplayMetrics().densityDpi);
    localCanvas.setBitmap(localBitmap3);
    paramResources = new Paint();
    localCanvas.drawBitmap(localBitmap2, 0.0F, 0.0F, paramResources);
    localCanvas.drawBitmap(localBitmap1, i, j, paramResources);
    localBitmap1.recycle();
    localBitmap2.recycle();
    return localBitmap3;
  }
  
  public static void d(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if (paramMessageRecord != null)
    {
      paramMessageRecord.saveExtInfoToExtStr("receipt_msg_is_read", paramString);
      paramQQAppInterface.b().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, "extStr", paramMessageRecord.extStr);
      paramQQAppInterface.b().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, "extLong", Integer.valueOf(paramMessageRecord.extLong));
    }
  }
  
  private Bitmap e(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return BitmapFactory.decodeResource(paramResources, 2130838338);
    case 2: 
      return BitmapFactory.decodeResource(paramResources, 2130838336);
    }
    return BitmapFactory.decodeResource(paramResources, 2130838337);
  }
  
  private static void e(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    paramMessageRecord.saveExtInfoToExtStr("receipt_pic_size_spec", paramString);
    paramQQAppInterface.b().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, "extStr", paramMessageRecord.extStr);
    paramQQAppInterface.b().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, "extLong", Integer.valueOf(paramMessageRecord.extLong));
  }
  
  private void f(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    Object localObject = String.format(BaseApplicationImpl.getContext().getString(2131700666), new Object[] { paramString });
    paramString = new MessageForUniteGrayTip();
    localObject = new ahwa(paramMessageRecord.frienduin, paramMessageRecord.senderuin, (String)localObject, paramMessageRecord.istroop, -5022, 3211265, paramMessageRecord.time);
    ((ahwa)localObject).ciH = false;
    paramString.initGrayTipMsg(paramQQAppInterface, (ahwa)localObject);
    paramString.msgUid = paramMessageRecord.msgUid;
    paramString.shmsgseq = paramMessageRecord.shmsgseq;
    ahwb.a(paramQQAppInterface, paramString);
    anot.a(paramQQAppInterface, "CliOper", "", "", "0X800859B", "0X800859B", 0, 0, "", "", "", "");
  }
  
  private void l(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    String str = paramMessageRecord.senderuin;
    switch (paramMessageRecord.istroop)
    {
    }
    for (;;)
    {
      f(paramQQAppInterface, paramMessageRecord, str);
      return;
      str = aqgv.b(paramQQAppInterface, paramMessageRecord.senderuin, false);
      continue;
      str = aqgv.h(paramQQAppInterface, paramMessageRecord.frienduin, paramMessageRecord.senderuin);
      continue;
      str = aqgv.k(paramQQAppInterface, paramMessageRecord.frienduin, paramMessageRecord.senderuin);
    }
  }
  
  public static String u(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.getExtInfoFromExtStr("receipt_msg_is_read");
  }
  
  public static String v(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.getExtInfoFromExtStr("receipt_pic_size_spec");
  }
  
  public Bitmap a(Resources paramResources, boolean paramBoolean, int paramInt)
  {
    int i;
    if (paramBoolean)
    {
      i = 1000;
      i += paramInt;
    }
    for (;;)
    {
      try
      {
        Bitmap localBitmap = (Bitmap)this.dl.get(i);
        if (localBitmap != null)
        {
          paramResources = localBitmap;
          return paramResources;
          i = 2000;
          break;
        }
        if (paramBoolean)
        {
          paramResources = c(paramResources, paramInt);
          this.dl.put(i, paramResources);
        }
        else
        {
          paramResources = d(paramResources, paramInt);
        }
      }
      finally {}
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt1, int paramInt2, QQRecorder.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean)
  {
    if (!QLog.isColorLevel()) {}
    for (;;)
    {
      ThreadManager.post(new ReceiptMsgManager.1(this, paramInt2, paramInt3, paramRecorderParam, paramString, paramInt1, paramBoolean, paramQQAppInterface, paramSessionInfo), 8, null, false);
      return;
      QLog.d("ReceiptMsgManager", 2, "sendPttMsg: " + this.f.toString());
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, ujt.d paramd)
  {
    ArrayList localArrayList = new ArrayList(1);
    paramString = ujt.a(paramQQAppInterface, paramSessionInfo, paramString, paramArrayList, paramd);
    if (paramString != null)
    {
      localArrayList.add(paramString);
      a(paramQQAppInterface, paramSessionInfo.aTl, paramSessionInfo.cZ, paramSessionInfo.troopUin, a(1), false, localArrayList, null);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("ReceiptMsgManager", 2, "create text msg error");
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, List<String> paramList, int paramInt)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramQQAppInterface, paramSessionInfo, (String)paramList.next(), paramInt);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, long paramLong, int paramInt2, akxb paramakxb)
  {
    ajlc.a().a(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, paramInt1, paramLong, 1035, paramakxb);
  }
  
  public void bup()
  {
    try
    {
      this.dl.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void k(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    String str = "receipt_gray_tip_showed-" + paramMessageRecord.istroop;
    if (this.mO == null) {
      this.mO = new HashMap(3);
    }
    if (this.mO.get(paramQQAppInterface.getCurrentAccountUin() + str) != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMsgManager", 2, "mGrayTipsShowedMap has key: " + paramQQAppInterface.getCurrentAccountUin() + str);
      }
    }
    SharedPreferences localSharedPreferences;
    boolean bool;
    do
    {
      return;
      localSharedPreferences = paramQQAppInterface.getPreferences();
      bool = localSharedPreferences.getBoolean(str, false);
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMsgManager", 2, "addGrayTipIfNeeded hasShowed: " + bool + " with key: " + str);
      }
    } while (bool);
    ThreadManager.postImmediately(new ReceiptMsgManager.3(this, paramQQAppInterface, paramMessageRecord), null, false);
    this.mO.put(paramQQAppInterface.getCurrentAccountUin() + str, Boolean.valueOf(true));
    localSharedPreferences.edit().putBoolean(str, true).apply();
  }
  
  public static class a
    implements akyf
  {
    MessageRecord D;
    int djI;
    String mToUin;
    WeakReference<QQAppInterface> n;
    
    public a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString, int paramInt)
    {
      this.n = new WeakReference(paramQQAppInterface);
      this.D = paramMessageRecord;
      this.mToUin = paramString;
      this.djI = paramInt;
    }
    
    public MessageRecord a(im_msg_body.RichText paramRichText)
    {
      return null;
    }
    
    public void a(akyf.a parama) {}
    
    public void b(akyf.a parama)
    {
      if (parama.result == 0)
      {
        MessageForStructing localMessageForStructing = (MessageForStructing)this.D;
        localMessageForStructing.structingMsg.mResid = parama.uuid;
        localMessageForStructing.structingMsg.mFileName = String.valueOf(localMessageForStructing.uniseq);
        ((QQAppInterface)this.n.get()).b().c(this.mToUin, this.djI, localMessageForStructing.uniseq, localMessageForStructing.structingMsg.getBytes());
        ((QQAppInterface)this.n.get()).b().b(this.D, null);
        if (QLog.isColorLevel()) {
          QLog.d("ReceiptMsgManager", 2, "send real struct msg done, uniseq: " + this.D.uniseq);
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReceiptMsgManager", 2, "upload receipt msg pack failed, result.errStr=" + parama.errCode + ",result.errStr=" + parama.errStr + " uniseq=" + this.D.uniseq);
      }
      this.D.extraflag = 32768;
      ((QQAppInterface)this.n.get()).a().e(this.mToUin, this.djI, this.D.uniseq);
      parama = ((QQAppInterface)this.n.get()).b().a(this.mToUin, this.djI);
      if ((parama != null) && (parama.uniseq == this.D.uniseq)) {
        parama.extraflag = 32768;
      }
      parama = this.mToUin;
      int i = this.djI;
      long l = this.D.uniseq;
      ((MessageHandler)((QQAppInterface)this.n.get()).getBusinessHandler(0)).notifyUI(MessageHandler.gz(this.djI), false, new Object[] { parama, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alte
 * JD-Core Version:    0.7.0.1
 */