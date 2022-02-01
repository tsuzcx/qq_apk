import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.GifDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pic.AioPicOperator.1;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.msg.im_msg_body.RichText;

public class akws
  extends akwv
{
  public akws() {}
  
  public akws(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(akxy paramakxy, MessageForPic paramMessageForPic)
  {
    paramakxy = paramakxy.yv;
    int i = paramakxy.size();
    int j;
    if (i == 10)
    {
      i = 9;
      j = 4;
    }
    for (;;)
    {
      if (i != -1)
      {
        paramMessageForPic.mDownloadLength = ((Integer)paramakxy.get(i)).intValue();
        paramMessageForPic.mShowLength = ((Integer)paramakxy.get(j)).intValue();
      }
      if (QLog.isColorLevel()) {
        QLog.d("peak_pgjpeg", 2, "AioPicOperator.loadPgInfo():showLen " + paramMessageForPic.mShowLength + ", downloadLen " + paramMessageForPic.mDownloadLength);
      }
      return;
      if (i == 6)
      {
        i = 5;
        j = 5;
      }
      else
      {
        j = -1;
        i = -1;
      }
    }
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
    akxe.M(this.logTag, this.bUB, "calcMD5", "md5:" + paramString + ",cost:" + (System.currentTimeMillis() - l));
    return paramString;
  }
  
  public akxm a(Intent paramIntent)
  {
    if ((paramIntent != null) && ((paramIntent instanceof Intent)))
    {
      Object localObject1 = paramIntent.getStringExtra("forward_filepath");
      Object localObject2 = paramIntent.getStringExtra("FORWARD_URL_KEY");
      int i = paramIntent.getIntExtra("FORWARD_UIN_TYPE", -1);
      String str5 = paramIntent.getStringExtra("SENDER_TROOP_UIN");
      String str6 = paramIntent.getStringExtra("FORWARD_PEER_UIN");
      String str1 = paramIntent.getStringExtra("FORWARD_SELF_UIN");
      Object localObject3 = paramIntent.getStringExtra("forward_urldrawable_thumb_url");
      String str2 = paramIntent.getStringExtra("forward_download_image_org_uin");
      int j = paramIntent.getIntExtra("forward_download_image_org_uin_type", -1);
      String str3 = paramIntent.getStringExtra("forward_download_image_server_path");
      long l1 = paramIntent.getLongExtra("forward_download_image_item_id", 0L);
      int k = paramIntent.getIntExtra("FORWARD_PHOTO_FILE_SIZE_FLAG", 0);
      String str4 = paramIntent.getStringExtra("forward_photo_md5");
      int m = paramIntent.getIntExtra("forward_photo_isSend", -1);
      long l2 = paramIntent.getLongExtra("forward_photo_group_fileid", 0L);
      long l3 = paramIntent.getLongExtra("forward_image_width", 0L);
      long l4 = paramIntent.getLongExtra("forward_image_height", 0L);
      long l5 = paramIntent.getLongExtra("forward_file_size", 0L);
      int n = paramIntent.getIntExtra("forward_image_type", 0);
      int i1 = paramIntent.getIntExtra("forward_photo_imagebiz_type", -1);
      paramIntent = new akxm();
      akxy.a locala = new akxy.a();
      locala.So(1009);
      locala.setLocalPath((String)localObject1);
      locala.kc(str1);
      locala.setProtocolType(aooh.a.dQE);
      locala.setWidth((int)l3);
      locala.setHeight((int)l4);
      akxe.M(this.logTag, this.bUB, "createForwardPicInfo(Intent obj)", "image_width = " + l3 + ",image_height = " + l4);
      locala.setFileSize((int)l5);
      locala.Ss(k);
      locala.setImageType(n);
      localObject3 = aoiz.getFile((String)localObject3);
      if (localObject3 != null) {
        locala.aA(((File)localObject3).getAbsolutePath());
      }
      locala.Sp(i);
      locala.NT(str5);
      locala.NP(str6);
      locala.setMd5(str4);
      locala.kx(l1);
      locala.Su(i1);
      paramIntent.b = locala.a();
      paramIntent.b.localUUID = ((String)localObject2);
      if (k == 1) {
        paramIntent.b.protocol = "chatraw";
      }
      for (;;)
      {
        localObject2 = paramIntent.b;
        if (avfp.is((String)localObject1)) {
          aqip.beginPile();
        }
        try
        {
          ((akxy)localObject2).yv = avfp.an((String)localObject1);
          aqip.endPile("peak_pgjpeg", "PeakUtils.getSliceInfos(" + (String)localObject1 + ")");
          if (!aqhq.fileExistsAndNotEmpty((String)localObject1))
          {
            localObject1 = new akxl.a();
            ((akxl.a)localObject1).So(1009);
            ((akxl.a)localObject1).kc(str1);
            ((akxl.a)localObject1).NP(str2);
            ((akxl.a)localObject1).Sp(j);
            ((akxl.a)localObject1).setUuid(str3);
            ((akxl.a)localObject1).kw(l1);
            ((akxl.a)localObject1).setMd5(str4);
            ((akxl.a)localObject1).Sq(m);
            paramIntent.a = ((akxl.a)localObject1).a();
            paramIntent.a.protocol = "chatimg";
            paramIntent.a.fileSizeFlag = k;
            paramIntent.a.groupFileID = l2;
          }
          akxe.M(this.logTag, this.bUB, "createForwardPicInfo", "");
          return paramIntent;
          paramIntent.b.protocol = "chatimg";
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + (String)localObject1 + "'s size is " + aqhq.getFileSizes((String)localObject1));
            }
          }
        }
      }
    }
    akxe.M(this.logTag, this.bUB, "createForwardPicInfo", "unknow obj");
    return null;
  }
  
  public akxm a(MessageForPic paramMessageForPic, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramMessageForPic == null) || (paramInt < 0) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return null;
    }
    long l = System.currentTimeMillis();
    int i;
    if ((aqfw.mn(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003)) {
      i = 1;
    }
    for (;;)
    {
      akxm localakxm;
      if (i == 0)
      {
        i = 65537;
        Object localObject = aoop.a(paramMessageForPic, i).toString();
        localakxm = new akxm();
        localakxm.bjd = paramMessageForPic.isSendFromLocal();
        akxy.a locala = new akxy.a();
        locala.So(1009);
        locala.setLocalPath(paramMessageForPic.path);
        locala.kc(paramString3);
        locala.setProtocolType(aooh.a.dQE);
        locala.setWidth((int)paramMessageForPic.width);
        locala.setHeight((int)paramMessageForPic.height);
        akxe.M(this.logTag, this.bUB, "createForwardPicInfo", "picMsg.width = " + paramMessageForPic.width + ",picMsg.height = " + paramMessageForPic.height);
        locala.setFileSize((int)paramMessageForPic.size);
        locala.Ss(paramMessageForPic.fileSizeFlag);
        locala.DY(paramMessageForPic.thumbWidth);
        locala.DZ(paramMessageForPic.thumbHeight);
        locala.setImageType(paramMessageForPic.imageType);
        localObject = aoiz.getFile((String)localObject);
        if (localObject != null) {
          locala.aA(((File)localObject).getAbsolutePath());
        }
        locala.Sp(paramInt);
        locala.NT(paramString1);
        locala.NP(paramString2);
        locala.setMd5(paramMessageForPic.md5);
        localakxm.b = locala.a();
        localakxm.b.localUUID = paramMessageForPic.localUUID;
        localakxm.b.protocol = "chatimg";
        paramString1 = localakxm.b;
        if ((paramString1.ceG < 0) && (avfp.is(paramMessageForPic.path))) {
          aqip.beginPile();
        }
      }
      try
      {
        paramString1.yv = avfp.an(paramMessageForPic.path);
        aqip.endPile("peak_pgjpeg", "PeakUtils.getSliceInfos(" + paramMessageForPic.path + ")");
        if ((paramMessageForPic.isMultiMsg) || (!aqhq.fileExistsAndNotEmpty(paramMessageForPic.path)))
        {
          paramString1 = new akxl.a();
          paramString1.So(1009);
          paramString1.kc(paramString3);
          paramString1.NP(paramMessageForPic.frienduin);
          paramString1.Sp(paramMessageForPic.istroop);
          paramString1.setUuid(paramMessageForPic.uuid);
          paramString1.kw(paramMessageForPic.uniseq);
          paramString1.setMd5(paramMessageForPic.md5);
          paramString1.Sq(paramMessageForPic.issend);
          paramString1.setTime(paramMessageForPic.time);
          localakxm.a = paramString1.a();
          localakxm.a.protocol = "chatimg";
          localakxm.a.fileSizeFlag = paramMessageForPic.fileSizeFlag;
          localakxm.a.groupFileID = paramMessageForPic.groupFileID;
        }
        akxe.M(this.logTag, this.bUB, "createForwardPicInfo", "cost:" + (System.currentTimeMillis() - l));
        paramMessageForPic = this.logTag;
        paramString1 = this.bUB;
        paramString2 = new StringBuilder().append("retry:");
        if (localakxm.b.a != null)
        {
          bool = true;
          akxe.M(paramMessageForPic, paramString1, "createForwardPicInfo", bool);
          return localakxm;
          i = 0;
          continue;
          i = 1;
        }
      }
      catch (OutOfMemoryError paramString1)
      {
        for (;;)
        {
          boolean bool;
          if (QLog.isColorLevel())
          {
            QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + paramMessageForPic.path + "'s size is " + aqhq.getFileSizes(paramMessageForPic.path));
            continue;
            bool = false;
          }
        }
      }
    }
  }
  
  public akxy a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Object localObject2 = paramIntent.getStringExtra("uin");
      String str2 = paramIntent.getStringExtra("troop_uin");
      int i = paramIntent.getIntExtra("uintype", 1003);
      int j = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      int k = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
      String str3 = paramIntent.getStringExtra("PhotoConst.PHOTO_SEND_PATH");
      int m = paramIntent.getIntExtra("entrance", 0);
      int n = paramIntent.getIntExtra("key_confess_topicid", 0);
      boolean bool1 = paramIntent.getBooleanExtra("video_sync_to_story", false);
      boolean bool2 = paramIntent.getBooleanExtra("key_story_photo_to_recent", false);
      Object localObject1 = paramIntent.getStringExtra("widgetinfo");
      String str1 = paramIntent.getStringExtra("key_camera_material_name");
      akxy.a locala = new akxy.a();
      locala.NP((String)localObject2);
      locala.setLocalPath(str3);
      locala.Sp(i);
      locala.NT(str2);
      locala.So(k);
      locala.Sr(j);
      locala.St(n);
      locala.setEntrance(m);
      locala.Nv(bool1);
      locala.Nw(bool2);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new akxx();
        ((akxx)localObject2).bUK = ((String)localObject1);
        ((akxx)localObject2).bUL = str1;
        locala.a((akxx)localObject2);
      }
      localObject1 = locala.a();
      i = paramIntent.getIntExtra("key_is_sync_qzone", 0);
      if (i == 1)
      {
        str1 = paramIntent.getStringExtra("key_qzone_album_id");
        ((akxy)localObject1).dpM = i;
        ((akxy)localObject1).bUM = str1;
        ((akxy)localObject1).aeJ = paramIntent.getLongExtra("key_qzone_batch_id", 0L);
        ((akxy)localObject1).aeK = paramIntent.getIntExtra("PhotoConst.PHOTO_COUNT", 0);
        ((akxy)localObject1).aeL = paramIntent.getIntExtra("PhotoConst.PHOTO_SEND_PATH_INDEX", 0);
      }
      akxe.M(this.logTag, this.bUB, "createPicUploadInfo", "");
      return localObject1;
    }
    akxe.M(this.logTag, this.bUB, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  public MessageRecord a(akxm paramakxm)
  {
    boolean bool = true;
    if ((paramakxm == null) || (!paramakxm.cuW)) {
      return null;
    }
    long l = System.currentTimeMillis();
    akxy localakxy = paramakxm.b;
    aomn localaomn = new aomn();
    localaomn.clV = localakxy.thumbPath;
    MessageForPic localMessageForPic = anbi.a(this.mApp, localakxy.peerUin, localakxy.bUG, localakxy.uinType);
    localMessageForPic.path = localakxy.localPath;
    localMessageForPic.type = 1;
    Object localObject = new File(localakxy.localPath);
    if (((File)localObject).exists())
    {
      if (GifDrawable.isGifFile((File)localObject)) {
        localMessageForPic.imageType = 2000;
      }
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      SafeBitmapFactory.decodeFile(localakxy.localPath, (BitmapFactory.Options)localObject);
      localMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
      localMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
      if (aonc.qi(localakxy.localPath))
      {
        localMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
        localMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
        if (QLog.isColorLevel()) {
          akxe.M(this.logTag, this.bUB, "packForwardMsg", " pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject).outHeight + ",mr.width = " + localMessageForPic.width + ",mr.height = " + localMessageForPic.height);
        }
      }
      localMessageForPic.md5 = localakxy.md5;
    }
    localMessageForPic.fileSizeFlag = paramakxm.b.dpK;
    paramakxm = paramakxm.a;
    if (paramakxm != null)
    {
      if (paramakxm.md5 != null) {
        localMessageForPic.md5 = paramakxm.md5;
      }
      if (paramakxm.uniseq != 0L) {
        localaomn.aqb = paramakxm.uniseq;
      }
      if (paramakxm.peerUin != null) {
        localaomn.clT = paramakxm.peerUin;
      }
      if (paramakxm.uinType != -1) {
        localaomn.dPP = paramakxm.uinType;
      }
      if (paramakxm.uuid != null) {
        localaomn.clU = paramakxm.uuid;
      }
    }
    if (localakxy.imageBizType != -1)
    {
      paramakxm = new PicMessageExtraData();
      paramakxm.imageBizType = localakxy.imageBizType;
      localMessageForPic.picExtraData = paramakxm;
    }
    localMessageForPic.picExtraFlag = aooh.a.dQE;
    localMessageForPic.picExtraObject = localaomn;
    if (localakxy.a != null)
    {
      if (bool)
      {
        localMessageForPic.msgseq = localakxy.a.msgseq;
        localMessageForPic.shmsgseq = localakxy.a.shmsgseq;
        localMessageForPic.msgUid = localakxy.a.msgUid;
      }
      localMessageForPic.localUUID = localakxy.localUUID;
      akxe.M(this.logTag, this.bUB, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
      localMessageForPic.imageType = avfp.fR(localakxy.localPath);
      paramakxm = localakxy.yv;
      if ((paramakxm == null) || (paramakxm.isEmpty())) {
        break label760;
      }
      a(localakxy, localMessageForPic);
      localMessageForPic.imageType = 1003;
    }
    for (;;)
    {
      localMessageForPic.serial();
      localakxy.uniseq = localMessageForPic.uniseq;
      paramakxm = this.mApp.a();
      if (paramakxm != null) {
        paramakxm.a(localMessageForPic.frienduin + localMessageForPic.uniseq, new aojn(paramakxm));
      }
      o(localMessageForPic);
      akxe.M(this.logTag, this.bUB, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      akxe.M(this.logTag, this.bUB, "packForwardMsg", "retry:" + bool);
      return localMessageForPic;
      bool = false;
      break;
      label760:
      if (QLog.isColorLevel()) {
        QLog.d("peak_pgjpeg", 2, "Slice infos is null");
      }
    }
  }
  
  public MessageRecord a(akxy paramakxy)
  {
    long l = System.currentTimeMillis();
    if ((paramakxy != null) && (paramakxy.localPath != null))
    {
      MessageForPic localMessageForPic = anbi.a(this.mApp, paramakxy.peerUin, paramakxy.bUG, paramakxy.uinType);
      localMessageForPic.busiType = paramakxy.busiType;
      localMessageForPic.path = paramakxy.localPath;
      localMessageForPic.size = 0L;
      localMessageForPic.type = 1;
      localMessageForPic.isRead = true;
      localMessageForPic.extraflag = 32772;
      if (paramakxy.protocolType == 1) {
        localMessageForPic.fileSizeFlag = 1;
      }
      boolean bool;
      label229:
      Object localObject;
      if (paramakxy.a != null)
      {
        bool = true;
        if (bool)
        {
          localMessageForPic.msgseq = paramakxy.a.msgseq;
          localMessageForPic.shmsgseq = paramakxy.a.shmsgseq;
          localMessageForPic.msgUid = paramakxy.a.msgUid;
        }
        localMessageForPic.localUUID = paramakxy.localUUID;
        akxe.M(this.logTag, this.bUB, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
        localMessageForPic.md5 = calcMD5(localMessageForPic.path);
        if (!anof.ayA()) {
          break label693;
        }
        localMessageForPic.bigThumbMsgUrl = paramakxy.thumbPath;
        localMessageForPic.thumbWidth = paramakxy.thumbWidth;
        localMessageForPic.thumbHeight = paramakxy.thumbHeight;
        localObject = new File(paramakxy.localPath);
        if (((File)localObject).exists())
        {
          if (GifDrawable.isGifFile((File)localObject)) {
            localMessageForPic.imageType = 3;
          }
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          ((BitmapFactory.Options)localObject).inSampleSize = 1;
          SafeBitmapFactory.decodeFile(paramakxy.localPath, (BitmapFactory.Options)localObject);
          localMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
          localMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
          if (aonc.qi(paramakxy.localPath))
          {
            localMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
            localMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
            if (QLog.isColorLevel()) {
              akxe.M(this.logTag, this.bUB, "packMsg", " pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject).outHeight + ",mr.width = " + localMessageForPic.width + ",mr.height = " + localMessageForPic.height);
            }
          }
        }
        localMessageForPic.extLong = paramakxy.extLong;
        localMessageForPic.extStr = paramakxy.extStr;
        localMessageForPic.msgVia = paramakxy.entrance;
        localMessageForPic.sync2Story = paramakxy.sync2Story;
        String str = anbb.ccV;
        if (!localMessageForPic.sync2Story) {
          break label705;
        }
        localObject = "1";
        label507:
        localMessageForPic.saveExtInfoToExtStr(str, (String)localObject);
        a(localMessageForPic, paramakxy);
        localMessageForPic.imageType = avfp.fR(paramakxy.localPath);
        localObject = paramakxy.yv;
        if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
          break label713;
        }
        a(paramakxy, localMessageForPic);
        localMessageForPic.imageType = 1003;
      }
      for (;;)
      {
        localMessageForPic.serial();
        paramakxy.uniseq = localMessageForPic.uniseq;
        akxe.M(this.logTag, this.bUB, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        o(localMessageForPic);
        akxe.M(this.logTag, this.bUB, "packMsg", "retry:" + bool + " info.DLSendKey:" + paramakxy.aeH);
        localMessageForPic.DSKey = paramakxy.aeH;
        return localMessageForPic;
        bool = false;
        break;
        label693:
        localMessageForPic.thumbMsgUrl = paramakxy.thumbPath;
        break label229;
        label705:
        localObject = "0";
        break label507;
        label713:
        if (QLog.isColorLevel()) {
          QLog.d("peak_pgjpeg", 2, "Slice infos is null");
        }
      }
    }
    return null;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    akxe.M(this.logTag, this.bUB, "attachRichText2Msg", "");
    if ((this.F != null) && ((this.F instanceof MessageForRichText))) {
      ((MessageForRichText)this.F).richText = paramRichText;
    }
    return this.F;
  }
  
  public CompressInfo a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    int j = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    return new CompressInfo(paramIntent.getStringExtra("PhotoConst.PHOTO_SEND_PATH"), akyj.iA(i), j);
  }
  
  public ArrayList<akxm> a(MessageForMixedMsg paramMessageForMixedMsg, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramMessageForMixedMsg == null) || (paramInt < 0) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null) || (paramMessageForMixedMsg.msgElemList == null)) {
      return null;
    }
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    paramMessageForMixedMsg = paramMessageForMixedMsg.msgElemList.iterator();
    while (paramMessageForMixedMsg.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramMessageForMixedMsg.next();
      if ((localMessageRecord instanceof MessageForPic)) {
        localArrayList.add(a((MessageForPic)localMessageRecord, paramInt, paramString1, paramString2, paramString3));
      }
    }
    akxe.M(this.logTag, this.bUB, "createForwardPicInfos", "cost:" + (System.currentTimeMillis() - l));
    return localArrayList;
  }
  
  public void a(akyf.a parama)
  {
    if (parama != null)
    {
      akxe.M(this.logTag, this.bUB, "updateMsg", "resut:" + parama);
      MessageForPic localMessageForPic = (MessageForPic)this.F;
      localMessageForPic.size = parama.size;
      localMessageForPic.uuid = parama.uuid;
      localMessageForPic.groupFileID = parama.groupFileID;
      localMessageForPic.md5 = parama.md5;
      localMessageForPic.serial();
      this.mApp.b().c(this.F.frienduin, this.F.istroop, this.F.uniseq, localMessageForPic.msgData);
    }
  }
  
  protected void a(MessageForPic paramMessageForPic, akxy paramakxy)
  {
    aegu.a(this.mApp, paramMessageForPic, paramakxy.peerUin, paramakxy.uinType, paramakxy.topicId);
    if (paramakxy.uinType == 0) {
      aegu.b(this.mApp, paramMessageForPic, paramakxy.peerUin);
    }
    for (;;)
    {
      if (paramakxy.busiType == 1036) {
        afck.ae(paramMessageForPic);
      }
      if (paramakxy.busiType == 1039) {
        acfx.d(paramMessageForPic, false);
      }
      if (paramakxy.busiType == 1040) {
        acei.d(paramMessageForPic, false);
      }
      if (paramakxy.dpM == 1)
      {
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_is_sync_qzone", String.valueOf(1));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_album_id", paramakxy.bUM);
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_id", String.valueOf(paramakxy.aeJ));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_is_raw", String.valueOf(paramakxy.protocolType));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_count", String.valueOf(paramakxy.aeK));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_photo_index", String.valueOf(paramakxy.aeL));
      }
      if (paramakxy.isStoryPhoto) {
        paramMessageForPic.isStoryPhoto = true;
      }
      return;
      if (paramakxy.uinType == 1) {
        aegu.c(this.mApp, paramMessageForPic, paramakxy.peerUin);
      }
    }
  }
  
  protected void o(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    if ((acfx.W(paramMessageForPic)) || (acei.W(paramMessageForPic)))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseMemoryCache = false;
      localURLDrawableOptions.mLoadingDrawable = FlashPicItemBuilder.a(BaseApplicationImpl.getApplication().getResources());
      URLDrawable localURLDrawable = aoop.a(paramMessageForPic, 65537, null, localURLDrawableOptions);
      if (acei.W(paramMessageForPic)) {
        localURLDrawableOptions.isFlashPic = true;
      }
      localURLDrawable.setDecodeHandler(aqbn.n);
      localURLDrawable.downloadImediatly();
    }
    for (;;)
    {
      akxe.M(this.logTag, this.bUB, "preload thumb", "cost:" + (System.currentTimeMillis() - l));
      return;
      paramMessageForPic = aoop.a(paramMessageForPic, 65537, null, null);
      paramMessageForPic.downloadImediatly();
      ThreadManagerV2.getUIHandlerV2().post(new AioPicOperator.1(this, paramMessageForPic));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akws
 * JD-Core Version:    0.7.0.1
 */