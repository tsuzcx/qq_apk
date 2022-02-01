import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.NotOnlineImage;

class akwx
  implements aoqm.a
{
  private volatile long aey;
  private Random mRandom = new Random(System.currentTimeMillis());
  
  akwx(akwv.a parama) {}
  
  private int Hh()
  {
    ArrayList localArrayList = this.a.yt;
    int i = 0;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.a.yt.iterator();
        if (localIterator.hasNext())
        {
          if (((akxr)localIterator.next()).mResult == -2) {
            i += 1;
          }
        }
        else {
          return i;
        }
      }
      finally {}
    }
  }
  
  private String a(akxm paramakxm)
  {
    Object localObject3 = null;
    if (paramakxm.b.dpK == 1) {}
    Object localObject1;
    for (int i = 1; paramakxm.dpD >= 0; i = 0)
    {
      localObject1 = paramakxm.b.localPath;
      return localObject1;
    }
    if (aqhq.fileExistsAndNotEmpty(paramakxm.b.localPath))
    {
      localObject1 = new CompressInfo(paramakxm.b.localPath, 0, 1009);
      akyj.b((CompressInfo)localObject1);
      localObject1 = ((CompressInfo)localObject1).destPath;
      akxe.M(this.a.this$0.logTag, this.a.this$0.bUB, "uploadForwardMultiMsgPics.getTargetPicFilepath", "Compress raw to big compress image at " + (String)localObject1);
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        Object localObject2 = aoop.a(paramakxm, 1, null);
        if (localObject2 != null) {}
        for (localObject2 = aoiz.getFilePath(((URL)localObject2).toString()); aqhq.fileExistsAndNotEmpty((String)localObject2); localObject2 = null)
        {
          akxe.M(this.a.this$0.logTag, this.a.this$0.bUB, "uploadForwardMultiMsgPics.getTargetPicFilepath", "find big compress image at " + (String)localObject2);
          return localObject2;
        }
        localObject2 = localObject1;
        if (i != 0)
        {
          localObject2 = aoop.a(paramakxm, 131075, null);
          if (localObject2 == null) {
            break label416;
          }
        }
        label416:
        for (String str = aoiz.getFilePath(((URL)localObject2).toString());; str = null)
        {
          localObject2 = localObject1;
          if (aqhq.fileExistsAndNotEmpty(str))
          {
            localObject1 = new CompressInfo(str, 0);
            ((CompressInfo)localObject1).busiType = 1009;
            akyj.b((CompressInfo)localObject1);
            localObject2 = ((CompressInfo)localObject1).destPath;
            akxe.M(this.a.this$0.logTag, this.a.this$0.bUB, "uploadForwardMultiMsgPics.getTargetPicFilepath", "Compress raw to big compress image at " + (String)localObject2);
          }
          localObject1 = localObject2;
          if (localObject2 != null) {
            break;
          }
          localObject1 = aoop.a(paramakxm, 65537, null);
          paramakxm = localObject3;
          if (localObject1 != null) {
            paramakxm = aoiz.getFilePath(((URL)localObject1).toString());
          }
          localObject1 = localObject2;
          if (!aqhq.fileExistsAndNotEmpty(paramakxm)) {
            break;
          }
          akxe.M(this.a.this$0.logTag, this.a.this$0.bUB, "uploadForwardMultiMsgPics.getTargetPicFilepath", "find thumb image at " + paramakxm);
          return paramakxm;
        }
      }
      return localObject1;
      localObject1 = null;
    }
  }
  
  private im_msg_body.CustomFace a(im_msg_body.NotOnlineImage paramNotOnlineImage)
  {
    im_msg_body.CustomFace localCustomFace = new im_msg_body.CustomFace();
    try
    {
      localCustomFace.uint32_file_id.set(paramNotOnlineImage.uint32_file_id.get());
      localCustomFace.uint32_file_type.set(Integer.valueOf(66).intValue());
      localCustomFace.uint32_useful.set(1);
      if (((QQAppInterface)this.a.n.get()).getSessionKey() != null) {
        localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(((QQAppInterface)this.a.n.get()).getSessionKey()));
      }
      localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(paramNotOnlineImage.pic_md5.get().toByteArray()));
      if (paramNotOnlineImage.res_id.has()) {
        localCustomFace.str_file_path.set(paramNotOnlineImage.res_id.get().toStringUtf8());
      }
      for (;;)
      {
        localCustomFace.uint32_origin.set(paramNotOnlineImage.original.get());
        localCustomFace.biz_type.set(4);
        localCustomFace.uint32_source.set(104);
        localCustomFace.uint32_width.set(paramNotOnlineImage.pic_width.get());
        localCustomFace.uint32_height.set(paramNotOnlineImage.pic_height.get());
        localCustomFace.uint32_size.set(paramNotOnlineImage.file_len.get());
        localCustomFace.uint32_thumb_width.set(paramNotOnlineImage.uint32_thumb_width.get());
        localCustomFace.uint32_thumb_height.set(paramNotOnlineImage.uint32_thumb_height.get());
        localCustomFace.image_type.set(paramNotOnlineImage.img_type.get());
        akxe.M(this.a.this$0.logTag, this.a.this$0.bUB, "uploadForwardMultiMsgPics.convert2CustomFace", akwv.a.a(this.a, localCustomFace));
        return localCustomFace;
        if (paramNotOnlineImage.download_path.has()) {
          localCustomFace.str_file_path.set(paramNotOnlineImage.download_path.get().toStringUtf8());
        }
      }
      return null;
    }
    catch (Exception paramNotOnlineImage)
    {
      akxe.N(this.a.this$0.logTag, this.a.this$0.bUB, "uploadForwardMultiMsgPics.convert2CustomFace", "Exception, " + paramNotOnlineImage.toString());
    }
  }
  
  private im_msg_body.NotOnlineImage a(im_msg_body.CustomFace paramCustomFace)
  {
    im_msg_body.NotOnlineImage localNotOnlineImage = new im_msg_body.NotOnlineImage();
    try
    {
      localNotOnlineImage.uint32_file_id.set(paramCustomFace.uint32_file_id.get());
      localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8("BADBADBAD"));
      Object localObject = new StringBuilder();
      long l = this.aey;
      this.aey = (1L + l);
      localObject = l + "BADBADBAD" + this.mRandom.nextInt();
      localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8(paramCustomFace.str_file_path.get()));
      localNotOnlineImage.file_len.set(paramCustomFace.uint32_size.get());
      localNotOnlineImage.pic_md5.set(paramCustomFace.bytes_md5.get());
      localNotOnlineImage.pic_height.set(paramCustomFace.uint32_height.get());
      localNotOnlineImage.pic_width.set(paramCustomFace.uint32_width.get());
      localNotOnlineImage.original.set(paramCustomFace.uint32_origin.get());
      localNotOnlineImage.img_type.set(paramCustomFace.image_type.get());
      localNotOnlineImage.biz_type.set(4);
      localNotOnlineImage.uint32_thumb_width.set(paramCustomFace.uint32_thumb_width.get());
      localNotOnlineImage.uint32_thumb_height.set(paramCustomFace.uint32_thumb_height.get());
      akxe.M(this.a.this$0.logTag, this.a.this$0.bUB, "uploadForwardMultiMsgPics.createNotOnlineImage", "OK, " + akwv.a.a(this.a, localNotOnlineImage));
      return localNotOnlineImage;
    }
    catch (Exception paramCustomFace)
    {
      akxe.M(this.a.this$0.logTag, this.a.this$0.bUB, "uploadForwardMultiMsgPics.createNotOnlineImage", "Failed, Exception" + paramCustomFace.toString());
    }
    return null;
  }
  
  private boolean b(akxm paramakxm)
  {
    if (paramakxm != null)
    {
      akxe.M(this.a.this$0.logTag, this.a.this$0.bUB, "checkFowardPicInfo", "info:" + paramakxm);
      if (paramakxm.b == null)
      {
        paramakxm.gT("PicFowardInfo.check", "upInfo == null");
        return false;
      }
      if (((paramakxm.b.uinType == 1000) || (paramakxm.b.uinType == 1020) || (paramakxm.b.uinType == 1004)) && (paramakxm.b.bUG == null))
      {
        paramakxm.gT("PicFowardInfo.check", "secondId invalid,uinType:" + paramakxm.b.uinType + ",secondId:" + paramakxm.b.bUG);
        return false;
      }
      if (paramakxm.b.protocolType == -1)
      {
        paramakxm.gT("PicFowardInfo.check", "protocolType invalid,protocolType:" + paramakxm.b.protocolType);
        return false;
      }
      if (a(paramakxm) != null) {
        return true;
      }
      paramakxm.gT("PicFowardInfo.check", "getForwardMultiMsgPicsTargetFilepath == null");
      return false;
    }
    akxe.N(this.a.this$0.logTag, this.a.this$0.bUB, "checkFowardPicInfo", "info == null");
    return false;
  }
  
  private void dDJ()
  {
    int i = this.a.xq.size();
    int j = Hh();
    akxr localakxr = new akxr();
    localakxr.mResult = 0;
    localakxr.en = Integer.valueOf(i - j);
    this.a.this$0.m(6, 0, localakxr);
  }
  
  private void dDK()
  {
    new akwy(this).execute(new Void[0]);
  }
  
  public void a(aoql.a parama, aoql.b paramb)
  {
    akxe.M(this.a.this$0.logTag, this.a.this$0.bUB, "uploadForwardMultiMsgPics.onBusiProtoResp", "start");
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "onBusiProtoResp miao size =  [" + paramb.Hf.size());
    }
    if ((parama != null) && (paramb != null))
    {
      i = 0;
      if (i < paramb.Hf.size())
      {
        Object localObject1 = (akxm)this.a.xq.get(i);
        akxr localakxr = (akxr)this.a.yt.get(i);
        Object localObject2 = (aoql.b.m)paramb.Hf.get(i);
        if ((localObject2 instanceof aoql.b.b))
        {
          localObject2 = (aoql.b.b)localObject2;
          akxe.M(this.a.this$0.logTag, this.a.this$0.bUB, "uploadForwardMultiMsgPics.onBusiProtoResp", "C2CPicUpResp[" + i + "]," + ((aoql.b.b)localObject2).toString());
          if ((((aoql.b.b)localObject2).result == 0) && (((aoql.b.b)localObject2).isExist))
          {
            localObject2 = this.a.a((aoql.a.i)parama.He.get(i), (aoql.b.b)localObject2, i);
            if ((((akxm)localObject1).a.uinType != 1) && (((akxm)localObject1).a.uinType != 3000)) {
              break label412;
            }
            akxe.M(this.a.this$0.logTag, this.a.this$0.bUB, "uploadForwardMultiMsgPics.onBusiProtoResp", "convert2CustomFace for [" + i + "] ");
            localObject1 = a((im_msg_body.NotOnlineImage)localObject2);
            if (localObject1 != null)
            {
              localakxr.mResult = 0;
              localakxr.en = localObject1;
              dDJ();
              if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
              }
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label412:
          if (localObject2 != null)
          {
            localakxr.mResult = 0;
            localakxr.en = localObject2;
            dDJ();
            if (QLog.isColorLevel())
            {
              QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
              continue;
              if ((localObject2 instanceof aoql.b.e))
              {
                localObject2 = (aoql.b.e)localObject2;
                akxe.M(this.a.this$0.logTag, this.a.this$0.bUB, "uploadForwardMultiMsgPics.onBusiProtoResp", "GroupPicUpResp[" + i + "]," + ((aoql.b.e)localObject2).toString());
                if ((((aoql.b.e)localObject2).result == 0) && (((aoql.b.e)localObject2).isExist))
                {
                  localObject2 = this.a.a((aoql.a.i)parama.He.get(i), (aoql.b.e)localObject2, i);
                  if ((((akxm)localObject1).a.uinType == 1) || (((akxm)localObject1).a.uinType == 3000))
                  {
                    if (localObject2 != null)
                    {
                      localakxr.mResult = 0;
                      localakxr.en = localObject2;
                      dDJ();
                      if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
                      }
                    }
                  }
                  else
                  {
                    akxe.M(this.a.this$0.logTag, this.a.this$0.bUB, "uploadForwardMultiMsgPics.onBusiProtoResp", "convert2NotOnlineImage for [" + i + "] ");
                    localObject1 = a((im_msg_body.CustomFace)localObject2);
                    if (localObject1 != null)
                    {
                      localakxr.mResult = 0;
                      localakxr.en = localObject1;
                      dDJ();
                      if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
                      }
                    }
                  }
                }
              }
              else
              {
                akxe.N(this.a.this$0.logTag, this.a.this$0.bUB, "uploadForwardMultiMsgPics.onBusiProtoResp", "Unkown response type[" + i + "] " + localObject2.getClass().getSimpleName());
              }
            }
          }
        }
      }
    }
    int i = Hh();
    if (i > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] need upload [" + i + "] pictures");
      }
      int k = 0;
      for (int j = 0; k < this.a.yt.size(); j = i)
      {
        parama = (akxm)this.a.xq.get(k);
        paramb = (akxr)this.a.yt.get(k);
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  " + parama.b.localPath);
        }
        i = j;
        if (paramb.mResult == -2)
        {
          i = j;
          if (!b(parama))
          {
            parama.b.localPath = ajlc.x((QQAppInterface)this.a.n.get());
            parama.b.md5 = aqhq.px(parama.b.localPath);
            parama.b.dpK = 1;
            parama.b.dpI = 242;
            parama.b.dpJ = 192;
            parama.b.aeI = ajlc.gp();
            parama.b.thumbPath = parama.b.localPath;
            parama.b.thumbHeight = 192;
            parama.b.thumbWidth = 242;
            parama.a.md5 = parama.b.md5;
            paramb.aVW = true;
            j = 1;
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  " + parama.b.localPath);
              i = j;
            }
          }
        }
        k += 1;
      }
      if ((j != 0) && (!this.a.cuL))
      {
        this.a.cuL = true;
        this.a.doInBackground(new Void[0]);
        return;
      }
      this.a.cuL = false;
      dDK();
      return;
    }
    akwv.a.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akwx
 * JD-Core Version:    0.7.0.1
 */