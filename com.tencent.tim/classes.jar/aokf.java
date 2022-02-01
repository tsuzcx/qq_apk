import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.transfile.FileDownloadFailedException;
import com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import mqq.app.AccountNotMatchException;

public class aokf
  extends aoja
{
  public aokf(BaseApplicationImpl paramBaseApplicationImpl)
  {
    super("ChatImageDownloader", paramBaseApplicationImpl);
  }
  
  public aokf(String paramString, BaseApplicationImpl paramBaseApplicationImpl)
  {
    super(paramString, paramBaseApplicationImpl);
  }
  
  private aokf.a a(DownloadParams paramDownloadParams)
    throws AccountNotMatchException
  {
    boolean bool = false;
    if (paramDownloadParams == null) {
      throw new FileDownloadFailedException(9302, 0L, "holy,config == null", false, false);
    }
    aokf.a locala = new aokf.a();
    locala.url = paramDownloadParams.url;
    akxe.a("PIC_TAG", "getDownloadData", "url:" + locala.url);
    locala.jdField_b_of_type_ComTencentCommonAppBaseApplicationImpl = this.jdField_b_of_type_ComTencentCommonAppBaseApplicationImpl;
    locala.startOffset = paramDownloadParams.downloaded;
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof akxw)))
    {
      Object localObject = (akxw)paramDownloadParams.tag;
      if ((localObject instanceof MessageForPic))
      {
        locala.jdField_b_of_type_ComTencentMobileqqDataMessageForPic = ((MessageForPic)localObject);
        locala.aMs = akxo.Hi();
        locala.uinType = akxo.b(locala.app, locala.jdField_b_of_type_ComTencentMobileqqDataMessageForPic.istroop, locala.jdField_b_of_type_ComTencentMobileqqDataMessageForPic.frienduin);
      }
      locala.a = ((akxw)localObject).getPicDownloadInfo();
      c(locala, "getDownloadData", "uuid:" + locala.a.uuid + ",md5：" + locala.a.md5);
      locala.host = fC(locala.a.uinType);
      paramDownloadParams = paramDownloadParams.url.getProtocol();
      if (locala.a.fileSizeFlag == 1) {
        bool = true;
      }
      locala.dPn = aoop.n(paramDownloadParams, bool);
      if (((akxw)localObject).isSendFromLocal())
      {
        locala.cMq = true;
        locala.jdField_b_of_type_Akxy = ((akxw)localObject).getPicUploadInfo();
        locala.a.cuF = true;
        if (locala.dPn != 65537) {
          break label461;
        }
        if (locala.jdField_b_of_type_Akxy.picExtraFlag != aooh.a.dQE) {
          break label427;
        }
        localObject = ((aomn)locala.jdField_b_of_type_Akxy.picExtraObject).clV;
        if (localObject != null)
        {
          paramDownloadParams = (DownloadParams)localObject;
          if (!"".equals(localObject)) {}
        }
        else
        {
          paramDownloadParams = a(locala, (String)localObject);
        }
      }
      label427:
      label461:
      for (locala.clj = paramDownloadParams;; locala.clj = locala.jdField_b_of_type_Akxy.localPath)
      {
        c(locala, "getDownloadData", "path:" + locala.jdField_b_of_type_Akxy.localPath + ",sendPath：" + locala.clj);
        return locala;
        if (locala.jdField_b_of_type_ComTencentMobileqqDataMessageForPic.isQzonePic)
        {
          paramDownloadParams = locala.jdField_b_of_type_Akxy.thumbPath;
          break;
        }
        paramDownloadParams = a(locala, null);
        break;
      }
    }
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof String)))
    {
      locala.clj = ((String)paramDownloadParams.tag);
      return locala;
    }
    if (paramDownloadParams.tag == null) {
      c(locala, "getDownloadData", "config.tag error,config.tag==null");
    }
    for (;;)
    {
      throw new FileDownloadFailedException(9302, 0L, "param error,config.tag error", false, false);
      c(locala, "getDownloadData", "config.tag error,config.tag:" + paramDownloadParams.tag);
    }
  }
  
  private String a(aokf.a parama, String paramString)
  {
    if (aqhq.fileExists(paramString)) {}
    while (!aqhq.fileExists(parama.jdField_b_of_type_Akxy.localPath)) {
      return paramString;
    }
    paramString = new CompressInfo(parama.jdField_b_of_type_Akxy.localPath, 0);
    paramString.localUUID = parama.jdField_b_of_type_Akxy.localUUID;
    akyj.c(paramString);
    return paramString.destPath;
  }
  
  private static void a(MessageRecord paramMessageRecord, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    Object localObject1 = null;
    boolean bool1 = paramString1.equals("C2C");
    boolean bool2 = paramString1.equals("Troup");
    boolean bool3 = paramString1.equals("Disscussion");
    if (bool1) {
      if (paramBoolean)
      {
        paramString1 = "dim.buddy_thumbpic_down";
        if (!paramBoolean) {
          break label108;
        }
        localObject1 = "actC2CPicSmallDownV1";
      }
    }
    for (;;)
    {
      paramString1 = new aoja.d(paramMessageRecord.frienduin, paramString1, (String)localObject1, null, null, paramString2, 0L, paramString3);
      paramString1.cLI = true;
      paramString1.msgTime = paramMessageRecord.time;
      a(paramString1, true, (int)0L, 0, "", null, null, null);
      return;
      paramString1 = "dim.buddy_pic_down";
      break;
      label108:
      localObject1 = "actC2CPicDownloadV1";
      continue;
      if (bool2)
      {
        if (paramBoolean)
        {
          paramString1 = "dim.group_thumbpic_down";
          label130:
          if (!paramBoolean) {
            break label150;
          }
        }
        label150:
        for (localObject1 = "actGroupPicSmallDownV1";; localObject1 = "actGroupPicDownloadV1")
        {
          break;
          paramString1 = "dim.group_pic_down";
          break label130;
        }
      }
      if (bool3)
      {
        if (paramBoolean)
        {
          paramString1 = "dim.discuss_thumbpic_down";
          label172:
          if (!paramBoolean) {
            break label192;
          }
        }
        label192:
        for (localObject1 = "actDiscussPicSmallDown";; localObject1 = "actDiscussPicDown")
        {
          break;
          paramString1 = "dim.discuss_pic_down";
          break label172;
        }
      }
      Object localObject2 = null;
      paramString1 = (String)localObject1;
      localObject1 = localObject2;
    }
  }
  
  public static void aG(MessageRecord paramMessageRecord)
  {
    for (int i = 0;; i = 1) {
      try
      {
        String str1 = fC(paramMessageRecord.istroop);
        Object localObject = new aooh.a();
        ((aooh.a)localObject).RZ(paramMessageRecord.msg);
        if (((aooh.a)localObject).type == 1)
        {
          String str2 = ((aooh.a)localObject).uuid;
          localObject = ((aooh.a)localObject).md5;
          if ((aqfw.mn(paramMessageRecord.msgtype)) || (paramMessageRecord.msgtype == -3001) || (paramMessageRecord.msgtype == -30002) || (paramMessageRecord.msgtype == -30003)) {
            continue;
          }
          if (i == 0)
          {
            localURL = aoop.a((MessageForPic)paramMessageRecord, 65537, null);
            if (getFile(localURL.toString()) != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ChatImageDownloader", 2, "reportClientExist thumbURL:" + localURL);
              }
              a(paramMessageRecord, str1, str2, (String)localObject, true);
            }
          }
          URL localURL = aoop.a((MessageForPic)paramMessageRecord, 65537, null);
          if (getFile(localURL.toString()) != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ChatImageDownloader", 2, "reportClientExist bigURL:" + localURL);
            }
            a(paramMessageRecord, str1, str2, (String)localObject, false);
          }
        }
        return;
      }
      catch (Exception paramMessageRecord)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("reportClientExist", 2, "error", paramMessageRecord);
        return;
      }
    }
  }
  
  private boolean b(DownloadParams paramDownloadParams)
  {
    if (!(paramDownloadParams.tag instanceof MessageForPic)) {
      return false;
    }
    paramDownloadParams = (MessageForPic)paramDownloadParams.tag;
    if ((paramDownloadParams.thumbWidthHeightDP != null) && (paramDownloadParams.thumbWidthHeightDP.mLimitSizeByServer)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static void c(Object paramObject, String paramString1, String paramString2)
  {
    if ((paramObject instanceof aokf.a)) {
      if (QLog.isColorLevel())
      {
        paramObject = (aokf.a)paramObject;
        if (paramObject.jdField_b_of_type_Akxy == null) {
          break label58;
        }
        i = aonc.gC(paramObject.dPn);
        aonc.c(paramObject.jdField_b_of_type_Akxy.uinType, false, i, String.valueOf(paramObject.jdField_b_of_type_Akxy.uniseq), paramString1, paramString2);
      }
    }
    label58:
    while (!QLog.isColorLevel())
    {
      do
      {
        int i;
        return;
        if (paramObject.a != null)
        {
          i = aonc.gC(paramObject.dPn);
          aonc.c(paramObject.a.uinType, false, i, String.valueOf(paramObject.a.uniseq), paramString1, paramString2);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ChatImageDownloader", 2, "step:" + paramString1 + ",content: " + paramString2);
      return;
    }
    QLog.d("ChatImageDownloader", 2, "step:" + paramString1 + ",content: " + paramString2);
  }
  
  static String fC(int paramInt)
  {
    String str = "";
    switch (paramInt)
    {
    default: 
      str = "C2C";
    case 6000: 
      return str;
    case 1: 
      return "Troup";
    case 3000: 
      return "Disscussion";
    }
    return "C2C";
  }
  
  aoom a(aokf.a parama)
    throws Exception
  {
    if (parama.app == null) {}
    try
    {
      parama.app = ((QQAppInterface)parama.jdField_b_of_type_ComTencentCommonAppBaseApplicationImpl.getAppRuntime(parama.a.selfUin));
      label28:
      if (parama.app == null)
      {
        c(parama, "stepDownload", "params.app == null ,selfuin:" + parama.a.selfUin);
        throw new FileDownloadFailedException(9302, 0L, "stepDownload,params.app == null ,selfuin:" + parama.a.selfUin, false, false);
      }
      akws localakws = new akws(parama.app);
      localakws.e = new akxq();
      localakws.e.j = parama.jdField_b_of_type_ComTencentMobileqqDataMessageForPic;
      localakws.logTag = "PIC_TAG";
      localakws.bUB = parama.bUB;
      parama.a.protocol = parama.url.getProtocol();
      if (parama.jdField_b_of_type_ComTencentMobileqqDataMessageForPic != null)
      {
        parama.a.bEnableEnc = parama.jdField_b_of_type_ComTencentMobileqqDataMessageForPic.bEnableEnc;
        parama.a.time = parama.jdField_b_of_type_ComTencentMobileqqDataMessageForPic.time;
      }
      akxe.M("PIC_TAG", parama.bUB, "stepDownload", "url:" + parama.url + ",info:" + parama.a);
      return localakws.a(parama.a, parama.jdField_b_of_type_ComTencentImageURLDrawableHandler, parama.url.getProtocol());
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      break label28;
    }
  }
  
  protected RoundRectBitmap a(Bitmap paramBitmap, DownloadParams paramDownloadParams)
  {
    float f1;
    int j;
    int i;
    int m;
    int k;
    int i6;
    int i7;
    int i5;
    int i4;
    int i3;
    int i2;
    label344:
    int i1;
    int n;
    try
    {
      f1 = this.jdField_b_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().density;
      i8 = this.jdField_b_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().densityDpi;
      f3 = 6.0F * f1;
      boolean bool = avfp.ns(paramDownloadParams.mImgType);
      j = aoop.H(bool);
      i = aoop.H(bool);
      m = aoop.G(bool);
      k = aoop.G(bool);
      if ((paramDownloadParams.tag instanceof MessageForPic))
      {
        localObject = (MessageForPic)paramDownloadParams.tag;
        j = wja.dp2px(((MessageForPic)localObject).getThumbWidthHeightDP(bool).mMinWidth, this.jdField_b_of_type_ComTencentCommonAppBaseApplicationImpl.getResources());
        i = wja.dp2px(((MessageForPic)localObject).getThumbWidthHeightDP(bool).mMinHeight, this.jdField_b_of_type_ComTencentCommonAppBaseApplicationImpl.getResources());
        m = wja.dp2px(((MessageForPic)localObject).getThumbWidthHeightDP(bool).mMaxWidth, this.jdField_b_of_type_ComTencentCommonAppBaseApplicationImpl.getResources());
        k = wja.dp2px(((MessageForPic)localObject).getThumbWidthHeightDP(bool).mMaxHeight, this.jdField_b_of_type_ComTencentCommonAppBaseApplicationImpl.getResources());
      }
      i6 = paramBitmap.getWidth();
      i7 = paramBitmap.getHeight();
      localObject = new Paint(1);
      ((Paint)localObject).setColor(-16777216);
      i5 = aoop.J(bool);
      i4 = aoop.J(bool);
      i3 = aoop.I(bool);
      i2 = aoop.I(bool);
      if (!(paramDownloadParams.tag instanceof MessageForPic)) {
        break label636;
      }
      MessageForPic localMessageForPic = (MessageForPic)paramDownloadParams.tag;
      i5 = localMessageForPic.getThumbWidthHeightDP(bool).mMinWidth;
      i4 = localMessageForPic.getThumbWidthHeightDP(bool).mMinHeight;
      i3 = localMessageForPic.getThumbWidthHeightDP(bool).mMaxWidth;
      i2 = localMessageForPic.getThumbWidthHeightDP(bool).mMaxHeight;
    }
    catch (OutOfMemoryError paramDownloadParams)
    {
      int i8;
      float f3;
      Object localObject;
      label387:
      return new RoundRectBitmap(paramBitmap, 6.0F);
    }
    if (b(paramDownloadParams))
    {
      return new RoundRectBitmap(akyr.a(paramBitmap, ((MessageForPic)paramDownloadParams.tag).thumbWidthHeightDP), f3);
      if (i1 < n)
      {
        m = (int)(j / i1 * n + 0.5F);
        i = m;
        if (m <= k) {
          break label723;
        }
        i = k;
        break label723;
      }
    }
    label563:
    label723:
    for (;;)
    {
      paramDownloadParams = Bitmap.createBitmap(j, i, paramBitmap.getConfig());
      paramDownloadParams.setDensity(i8);
      new Canvas(paramDownloadParams).drawBitmap(paramBitmap, new Rect(0, 0, i1, n), new Rect(0, 0, j, i), (Paint)localObject);
      paramDownloadParams = new RoundRectBitmap(paramDownloadParams, f3);
      return paramDownloadParams;
      k = (int)(i / n * i1 + 0.5F);
      j = k;
      if (k > m) {
        j = m;
      }
      continue;
      label624:
      label636:
      do
      {
        if ((i1 < i3) && (n < i2))
        {
          j = (int)(i1 * f1 + 0.5F);
          i = (int)(n * f1 + 0.5F);
          break label387;
        }
        if (i1 > n)
        {
          f1 = m / i1;
          if (i1 <= n) {
            break label624;
          }
        }
        for (float f2 = i / n;; f2 = j / i1)
        {
          f1 = Math.max(f1, f2);
          j = (int)(i1 * f1 + 0.5F);
          i = (int)(f1 * n + 0.5F);
          break;
          f1 = k / n;
          break label563;
        }
        if (i6 > i7 * 3.0F)
        {
          i1 = (int)(i7 * 3.0F);
          n = i7;
          break;
        }
        n = i7;
        i1 = i6;
        if (i7 <= i6 * 3.0F) {
          break;
        }
        n = (int)(i6 * 3.0F);
        i1 = i6;
        break;
        if (i1 < i5) {
          break label344;
        }
      } while (n >= i4);
      break label344;
    }
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    long l = SystemClock.uptimeMillis();
    if ((paramDownloadParams.urlStr != null) && (paramDownloadParams.urlStr.startsWith("chatimg"))) {}
    for (int i = 1;; i = 0)
    {
      paramDownloadParams = a(paramDownloadParams);
      paramDownloadParams.out = paramOutputStream;
      paramDownloadParams.jdField_b_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
      if ((paramDownloadParams.jdField_b_of_type_Akxy == null) || (paramDownloadParams.clj == null)) {
        break;
      }
      paramOutputStream = new File(paramDownloadParams.clj);
      if (!paramOutputStream.exists()) {
        break;
      }
      c(paramDownloadParams, "result", "success file(send) exist, copy file from:" + paramDownloadParams.clj);
      a(paramDownloadParams.out, paramOutputStream, paramDownloadParams.jdField_b_of_type_ComTencentImageURLDrawableHandler);
      return null;
    }
    paramURLDrawableHandler.publishProgress(0);
    if (paramDownloadParams.a == null)
    {
      c(paramDownloadParams, "result", "param error,params.downInfo == null,sendpath:" + paramDownloadParams.clj);
      throw new FileDownloadFailedException(9302, 0L, "param error,params.downInfo == null", false, false);
    }
    if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId())
    {
      c(paramDownloadParams, "result", "failed could not call object.wait in Main thread ,sendpath:" + paramDownloadParams.clj + ",uniseq:" + paramDownloadParams.a.uniseq);
      throw new FileDownloadFailedException(9365, 0L, "param error,could not call object.wait in Main thread", false, false);
    }
    if ((aqft.cC()) && (aqft.hE() < 20971520L)) {
      throw new IOException("SD card free space is " + aqft.hE());
    }
    aoom localaoom = a(paramDownloadParams);
    int j;
    if (localaoom.mResult == 0)
    {
      j = 1;
      if (j == 0) {
        break label374;
      }
    }
    label374:
    for (paramOutputStream = "successed";; paramOutputStream = "failed " + localaoom.clO)
    {
      c(paramDownloadParams, "result", paramOutputStream);
      if (j != 0) {
        break label482;
      }
      paramOutputStream = PicDownloadExplicitError.getPicError(localaoom);
      if (paramOutputStream == null) {
        break label402;
      }
      throw paramOutputStream;
      j = 0;
      break;
    }
    label402:
    if (localaoom.aqr == 9037L) {
      paramURLDrawableHandler.doCancel();
    }
    label482:
    while (i == 0)
    {
      return null;
      if ((localaoom.aqr == -9527L) && ("H_404_-124".equals(localaoom.clO)))
      {
        c(paramDownloadParams, "result", "successed|failed,H_404_-124,decodeFile will check");
        return null;
      }
      throw new FileDownloadFailedException((int)localaoom.aqr, 0L, localaoom.clO, false, false);
    }
    if (paramDownloadParams.app != null) {}
    for (paramOutputStream = paramDownloadParams.app.getCurrentAccountUin();; paramOutputStream = null)
    {
      akxp.e(paramOutputStream, paramDownloadParams.uinType, paramDownloadParams.aMs, SystemClock.uptimeMillis() - l);
      break;
    }
  }
  
  protected boolean a(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    Object localObject = paramDownloadParams.tag;
    if (((localObject instanceof MessageForPic)) && (acei.W((MessageForPic)localObject))) {
      return false;
    }
    return super.a(paramFile, paramDownloadParams, paramURLDrawableHandler);
  }
  
  public boolean azK()
  {
    return true;
  }
  
  public boolean azL()
  {
    return true;
  }
  
  protected boolean b(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return "chatthumb".equals(paramDownloadParams.url.getProtocol());
  }
  
  public class a
  {
    public akxl a;
    public int aMs = -1;
    QQAppInterface app;
    public akxy b;
    BaseApplicationImpl jdField_b_of_type_ComTencentCommonAppBaseApplicationImpl;
    URLDrawableHandler jdField_b_of_type_ComTencentImageURLDrawableHandler;
    public MessageForPic b;
    public String bUB = akxq.xP();
    boolean cMq;
    String clj;
    int dPn;
    public int dPo = 1;
    String host;
    OutputStream out;
    public long startOffset;
    public int uinType = -1;
    URL url;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aokf
 * JD-Core Version:    0.7.0.1
 */