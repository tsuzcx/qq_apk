import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.AsyncTask;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.RichText;

class akwy
  extends AsyncTask<Void, Void, Void>
{
  akwy(akwx paramakwx) {}
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    akxe.a(this.a.a.this$0.logTag, this.a.a.this$0.bUB, "uploadNotExistFiles start");
    int i = 0;
    paramVarArgs = null;
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      if (i < this.a.a.yt.size())
      {
        akxm localakxm = (akxm)this.a.a.xq.get(i);
        localObject2 = (akxr)this.a.a.yt.get(i);
        localObject1 = paramVarArgs;
        if (((akxr)localObject2).mResult == -2)
        {
          String str = akwx.a(this.a, localakxm);
          if (str == null) {
            break label551;
          }
          akxe.M(this.a.a.this$0.logTag, this.a.a.this$0.bUB, "uploadForwardMultiMsgPics.uploadFiles", "Upload [" + i + "]mLocalPath ＝ " + str);
          localObject2 = new aool();
          ((aool)localObject2).cMb = false;
          ((aool)localObject2).mSelfUin = ((QQAppInterface)this.a.a.n.get()).getAccount();
          ((aool)localObject2).mPeerUin = this.a.a.this$0.F.frienduin;
          ((aool)localObject2).cmn = this.a.a.this$0.F.senderuin;
          ((aool)localObject2).mUinType = this.a.a.this$0.F.istroop;
          ((aool)localObject2).mFileType = 1;
          ((aool)localObject2).mUniseq = (this.a.a.this$0.F.uniseq + i);
          for (localObject1 = ((aool)localObject2).mPeerUin + ((aool)localObject2).mUniseq; ((QQAppInterface)this.a.a.n.get()).a().cz.containsKey(localObject1); localObject1 = ((aool)localObject2).mPeerUin + ((aool)localObject2).mUniseq) {
            ((aool)localObject2).mUniseq += 100L;
          }
          ((aool)localObject2).cNy = true;
          ((aool)localObject2).mBusiType = localakxm.b.busiType;
          ((aool)localObject2).dQ = str;
          localObject1 = new aool.d();
          if (localakxm.dpD < 0)
          {
            ((aool.d)localObject1).cNJ = false;
            ((aool)localObject2).en = localObject1;
            ((aool)localObject2).b = new akwy.a(i, str);
            ((QQAppInterface)this.a.a.n.get()).a().a((aool)localObject2);
            localObject1 = paramVarArgs;
          }
        }
        else
        {
          i += 1;
          paramVarArgs = (Void[])localObject1;
          continue;
        }
        if (localakxm.dpD == 2) {}
        for (boolean bool = true;; bool = false)
        {
          ((aool.d)localObject1).cNJ = bool;
          break;
        }
        label551:
        ((akxr)localObject2).mResult = -1;
        ((akxr)localObject2).c = new akxn.a();
        ((akxr)localObject2).c.bUJ = ("Get target pic filepath of [" + i + "] failed");
        if ((localakxm.a.uinType == 1) || (localakxm.a.uinType == 3000))
        {
          ((akxr)localObject2).en = this.a.a.a(null, null, i);
          label645:
          if (!QLog.isColorLevel()) {
            break label795;
          }
          if (paramVarArgs != null) {
            break label792;
          }
          paramVarArgs = new StringBuilder();
          label663:
          paramVarArgs.append("Upload [").append(i).append("] failed, errDec ＝ ").append(((akxr)localObject2).c.bUJ).append("\n");
        }
      }
    }
    label792:
    label795:
    for (;;)
    {
      akwx.a(this.a);
      if (akwx.a(this.a) == 0) {
        akwv.a.a(this.a.a);
      }
      localObject1 = paramVarArgs;
      break;
      ((akxr)localObject2).en = this.a.a.a(null, null, i);
      break label645;
      if (paramVarArgs != null) {
        akxe.N(this.a.a.this$0.logTag, this.a.a.this$0.bUB, "uploadForwardMultiMsgPics.uploadFiles", paramVarArgs.toString());
      }
      return null;
      break label663;
    }
  }
  
  class a
    implements akyf
  {
    final akxr jdField_a_of_type_Akxr;
    final akxm b;
    final Rect cn;
    final int mL;
    
    a(int paramInt, String paramString)
    {
      this.mL = paramInt;
      this.jdField_a_of_type_Akxr = ((akxr)akwy.this.a.a.yt.get(this.mL));
      this.b = ((akxm)akwy.this.a.a.xq.get(paramInt));
      this.cn = a(paramString);
    }
    
    private Rect a(String paramString)
    {
      int j = 198;
      Rect localRect = new Rect(0, 0, 0, 0);
      int m;
      int n;
      int i;
      int k;
      float f;
      if (paramString != null)
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        SafeBitmapFactory.decodeFile(paramString, localOptions);
        m = localOptions.outWidth;
        n = localOptions.outHeight;
        i = Math.min(m, n);
        k = Math.max(m, n);
        f = k / i;
        if (i <= 198) {
          break label136;
        }
        if (f <= 3.0F) {
          break label122;
        }
        i = 66;
      }
      for (;;)
      {
        if (m < n)
        {
          localRect.right = i;
          localRect.bottom = j;
          return localRect;
          label122:
          i = (int)(i * 198.0F / k);
          continue;
          label136:
          if ((i > 66) && (i <= 198))
          {
            if (f > 3.0F)
            {
              i = 66;
              continue;
            }
            if (k >= 198) {
              i = (int)(i * 198.0F / k);
            }
          }
          else if ((i > 66) || (f <= 3.0F) || (k < 198)) {}
        }
        else
        {
          localRect.right = j;
          localRect.bottom = i;
          return localRect;
        }
        j = k;
      }
    }
    
    public MessageRecord a(im_msg_body.RichText arg1)
    {
      Object localObject1;
      if ((??? != null) && (???.elems.has()))
      {
        ??? = (im_msg_body.Elem)???.elems.get(0);
        if (??? != null) {
          if (???.not_online_image.has())
          {
            localObject1 = (im_msg_body.NotOnlineImage)???.not_online_image.get();
            ((im_msg_body.NotOnlineImage)localObject1).uint32_thumb_width.set(this.cn.right);
            ((im_msg_body.NotOnlineImage)localObject1).uint32_thumb_height.set(this.cn.bottom);
            if ((this.b.a.uinType == 1) || (this.b.a.uinType == 3000))
            {
              akxe.M(akwy.this.a.a.this$0.logTag, akwy.this.a.a.this$0.bUB, "uploadForwardMultiMsgPics.attachRichText2Msg", "convert2CustomFace for [" + this.mL + "] ");
              localObject1 = akwx.a(akwy.this.a, (im_msg_body.NotOnlineImage)localObject1);
            }
          }
        }
      }
      for (;;)
      {
        int i;
        synchronized (akwy.this.a.a.yt)
        {
          this.jdField_a_of_type_Akxr.mResult = 0;
          this.jdField_a_of_type_Akxr.en = localObject1;
          akxe.M(akwy.this.a.a.this$0.logTag, akwy.this.a.a.this$0.bUB, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.mL + "] OK, " + akwv.a.a(akwy.this.a.a, (im_msg_body.CustomFace)localObject1));
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + this.mL + "] OK");
          }
          i = 1;
          if (i != 0) {}
        }
        synchronized (akwy.this.a.a.yt)
        {
          this.jdField_a_of_type_Akxr.mResult = -1;
          this.jdField_a_of_type_Akxr.c = new akxn.a();
          this.jdField_a_of_type_Akxr.c.errCode = -1;
          this.jdField_a_of_type_Akxr.c.bUJ = ("Get target pic filepath of [" + this.mL + "] failed");
          if ((this.b.a.uinType == 1) || (this.b.a.uinType == 3000))
          {
            this.jdField_a_of_type_Akxr.en = akwy.this.a.a.a(null, null, this.mL);
            akxe.N(akwy.this.a.a.this$0.logTag, akwy.this.a.a.this$0.bUB, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.mL + "] failed, errDec ＝ " + this.jdField_a_of_type_Akxr.c.bUJ);
            if (QLog.isColorLevel()) {
              QLog.e("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + this.mL + "] failed, errDec ＝ " + this.jdField_a_of_type_Akxr.c.bUJ);
            }
            akwx.a(akwy.this.a);
            if (akwx.a(akwy.this.a) == 0) {
              akwv.a.a(akwy.this.a.a);
            }
            return null;
            localNotOnlineImage1 = finally;
            throw localNotOnlineImage1;
            synchronized (akwy.this.a.a.yt)
            {
              this.jdField_a_of_type_Akxr.mResult = 0;
              this.jdField_a_of_type_Akxr.en = localNotOnlineImage1;
              akxe.M(akwy.this.a.a.this$0.logTag, akwy.this.a.a.this$0.bUB, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.mL + "] OK, " + akwv.a.a(akwy.this.a.a, localNotOnlineImage1));
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + this.mL + "] OK");
            }
            if (???.custom_face.has())
            {
              im_msg_body.CustomFace localCustomFace1 = (im_msg_body.CustomFace)???.custom_face.get();
              localCustomFace1.uint32_thumb_width.set(this.cn.right);
              localCustomFace1.uint32_thumb_height.set(this.cn.bottom);
              if ((this.b.a.uinType == 1) || (this.b.a.uinType == 3000)) {}
              for (;;)
              {
                synchronized (akwy.this.a.a.yt)
                {
                  this.jdField_a_of_type_Akxr.mResult = 0;
                  this.jdField_a_of_type_Akxr.en = localCustomFace1;
                  akxe.M(akwy.this.a.a.this$0.logTag, akwy.this.a.a.this$0.bUB, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.mL + "] OK, " + akwv.a.a(akwy.this.a.a, localCustomFace1));
                  if (QLog.isColorLevel()) {
                    QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + this.mL + "] OK");
                  }
                  i = 1;
                }
                akxe.M(akwy.this.a.a.this$0.logTag, akwy.this.a.a.this$0.bUB, "uploadForwardMultiMsgPics.attachRichText2Msg", "convert2NotOnlineImage for [" + this.mL + "] ");
                im_msg_body.NotOnlineImage localNotOnlineImage2 = akwx.a(akwy.this.a, localCustomFace2);
                synchronized (akwy.this.a.a.yt)
                {
                  this.jdField_a_of_type_Akxr.mResult = 0;
                  this.jdField_a_of_type_Akxr.en = localNotOnlineImage2;
                  akxe.M(akwy.this.a.a.this$0.logTag, akwy.this.a.a.this$0.bUB, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.mL + "] OK, " + akwv.a.a(akwy.this.a.a, localNotOnlineImage2));
                  if (QLog.isColorLevel()) {
                    QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + this.mL + "] OK");
                  }
                }
              }
            }
            akxe.N(akwy.this.a.a.this$0.logTag, akwy.this.a.a.this$0.bUB, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.mL + "] failed, elem.not_online_image and elem.custom_face are null");
            i = 0;
            continue;
            akxe.N(akwy.this.a.a.this$0.logTag, akwy.this.a.a.this$0.bUB, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.mL + "] failed, richText.elems is null");
            for (;;)
            {
              i = 0;
              break;
              akxe.N(akwy.this.a.a.this$0.logTag, akwy.this.a.a.this$0.bUB, "uploadForwardMultiMsgPics.attachRichText2Msg", "[" + this.mL + "] failed, richText is null or richText.elems is null");
            }
          }
          this.jdField_a_of_type_Akxr.en = akwy.this.a.a.a(null, null, this.mL);
        }
      }
    }
    
    public void a(akyf.a parama) {}
    
    public void b(akyf.a parama)
    {
      synchronized (akwy.this.a.a.yt)
      {
        if (parama.result != 0)
        {
          this.jdField_a_of_type_Akxr.mResult = -1;
          this.jdField_a_of_type_Akxr.c = new akxn.a();
          this.jdField_a_of_type_Akxr.c.bUJ = parama.errStr;
          this.jdField_a_of_type_Akxr.c.errCode = parama.errCode;
          if ((this.b.a.uinType != 1) && (this.b.a.uinType != 3000)) {
            break label299;
          }
          this.jdField_a_of_type_Akxr.en = akwy.this.a.a.a(null, null, this.mL);
          akxe.M(akwy.this.a.a.this$0.logTag, akwy.this.a.a.this$0.bUB, "uploadForwardMultiMsgPics.onSend", "[" + this.mL + "] failed, errDec = " + this.jdField_a_of_type_Akxr.c.bUJ);
          if (QLog.isColorLevel()) {
            QLog.e("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] upload [" + this.mL + "] failed, errDec ＝ " + this.jdField_a_of_type_Akxr.c.bUJ);
          }
          akwx.a(akwy.this.a);
          if (akwx.a(akwy.this.a) == 0) {
            akwv.a.a(akwy.this.a.a);
          }
        }
        return;
        label299:
        this.jdField_a_of_type_Akxr.en = akwy.this.a.a.a(null, null, this.mL);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akwy
 * JD-Core Version:    0.7.0.1
 */