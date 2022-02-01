import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.hotpicmsg.HotPicMsg.GetImgInfoReq;
import com.tencent.pb.hotpicmsg.HotPicMsg.GetImgInfoRsp;
import com.tencent.pb.hotpicmsg.HotPicMsg.ImgInfo;
import com.tencent.pb.hotpicmsg.HotPicMsg.ReqBody;
import com.tencent.pb.hotpicmsg.HotPicMsg.RspBody;
import com.tencent.pb.hotpicmsg.HotPicMsg.ThirdPartyInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.util.WeakReference;

public class afhd
  implements Manager
{
  volatile afhd.b jdField_a_of_type_Afhd$b;
  afhd.c jdField_a_of_type_Afhd$c;
  WeakReference<afhd.a> ax;
  volatile afhd.b b;
  private Object cI = new Object();
  QQAppInterface mApp;
  List<EmotionSearchItem> zE = new ArrayList();
  
  public afhd(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public static afhd a(QQAppInterface paramQQAppInterface)
  {
    return (afhd)paramQQAppInterface.getManager(367);
  }
  
  private void a(afhd.a parama)
  {
    if (parama == null) {}
    while (this.jdField_a_of_type_Afhd$c == null) {
      return;
    }
    this.jdField_a_of_type_Afhd$c.b(parama);
  }
  
  private void a(afhd.b paramb, List<EmotionSearchItem> arg2, int paramInt)
  {
    if (!paramb.a(this.b))
    {
      if (QLog.isColorLevel()) {
        QLog.e("EmotionSearchManager", 2, "handleResponsData requestTask not current error, requestTask = " + paramb.taskType + "|" + paramb.bDp);
      }
      return;
    }
    afhd.a locala = new afhd.a(paramInt);
    paramb.hasMore = false;
    if ((paramInt == 0) && (???.size() > 0) && (this.zE.size() == ((EmotionSearchItem)???.get(0)).picIndex))
    {
      this.zE.addAll(???);
      paramb.hasMore = true;
    }
    locala.c = paramb;
    locala.itemList = new ArrayList();
    locala.itemList.addAll(this.zE);
    synchronized (this.cI)
    {
      this.jdField_a_of_type_Afhd$b = this.b;
      this.b = null;
      if ((paramb.taskType == 0) && (paramInt == 0)) {
        this.ax = new WeakReference(locala);
      }
      a(locala);
      return;
    }
  }
  
  private void biW()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchManager", 2, "requestData start");
    }
    Object localObject1 = this.b;
    if (localObject1 == null)
    {
      QLog.e("EmotionSearchManager", 2, "requestData currentSearchingTask is null");
      return;
    }
    int i = ((afhd.b)localObject1).startIndex;
    int j = ((afhd.b)localObject1).startIndex;
    int k = ((afhd.b)localObject1).cQS;
    Object localObject2 = new HotPicMsg.ReqBody();
    Object localObject3 = new HotPicMsg.GetImgInfoReq();
    ((HotPicMsg.ReqBody)localObject2).setHasFlag(true);
    ((HotPicMsg.GetImgInfoReq)localObject3).uint64_src_uin.set(Long.parseLong(this.mApp.getCurrentAccountUin()));
    ((HotPicMsg.GetImgInfoReq)localObject3).uint32_src_term.set(3);
    ((HotPicMsg.GetImgInfoReq)localObject3).uint32_start_pic_index.set(i);
    ((HotPicMsg.GetImgInfoReq)localObject3).uint32_end_pic_index.set(j + 16 - 1);
    ((HotPicMsg.GetImgInfoReq)localObject3).uint32_build_ver.set(k);
    if (((afhd.b)localObject1).taskType == 1)
    {
      ((HotPicMsg.GetImgInfoReq)localObject3).uint32_search_req.set(1);
      ((HotPicMsg.GetImgInfoReq)localObject3).str_search_word.set(((afhd.b)localObject1).bDp);
      ((HotPicMsg.GetImgInfoReq)localObject3).bytes_client_ver.set(ByteStringMicro.copyFromUtf8("3.4.4"));
      ((HotPicMsg.GetImgInfoReq)localObject3).uint32_need_update.set(0);
      String str = this.mApp.getCurrentAccountUin() + SystemClock.uptimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchManager", 2, "sessionId:" + str);
      }
      ((HotPicMsg.GetImgInfoReq)localObject3).bytes_session_id.set(ByteStringMicro.copyFromUtf8(str));
      ((HotPicMsg.ReqBody)localObject2).msg_get_imginfo_req.set((MessageMicro)localObject3);
      localObject2 = ((HotPicMsg.ReqBody)localObject2).toByteArray();
      localObject3 = ByteBuffer.allocate(localObject2.length + 4);
      ((ByteBuffer)localObject3).putInt(localObject2.length + 4).put((byte[])localObject2);
      localObject3 = ((ByteBuffer)localObject3).array();
      localObject2 = new NewIntent(this.mApp.getApp(), ahzm.class);
      ((NewIntent)localObject2).putExtra("key_body", (byte[])localObject3);
      ((NewIntent)localObject2).putExtra("key_cmd", "ImagePopular.GetInfo");
      ((NewIntent)localObject2).putExtra("isFrom_EmoSearch", true);
      ((NewIntent)localObject2).putExtra("EmoSearch_reqType", ((afhd.b)localObject1).taskType);
      if (((afhd.b)localObject1).bDp != null) {
        break label423;
      }
    }
    label423:
    for (localObject1 = "";; localObject1 = ((afhd.b)localObject1).bDp)
    {
      ((NewIntent)localObject2).putExtra("EmoSearch_reqKeywords", (String)localObject1);
      this.mApp.startServlet((NewIntent)localObject2);
      return;
      ((HotPicMsg.GetImgInfoReq)localObject3).uint32_pic_tag.set(2);
      break;
    }
  }
  
  public void a(afhd.b arg1)
  {
    if (??? == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      if ("pushEmotionSearchTask start task = " + ???.taskType + "|" + ???.bDp != null) {
        break label100;
      }
    }
    label100:
    for (??? = "";; ??? = ???.bDp)
    {
      QLog.d("EmotionSearchManager", 2, (String)???);
      if (!???.a(this.b)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchManager", 2, "pushEmotionSearchTask isSame task");
      }
      a(new afhd.a(-101));
      return;
    }
    synchronized (this.cI)
    {
      this.b = ???;
      this.zE.clear();
      if ((???.taskType != 0) || (this.ax == null)) {
        break label212;
      }
      ??? = (afhd.a)this.ax.get();
      if (??? == null) {
        break label212;
      }
    }
    synchronized (this.cI)
    {
      this.zE.addAll(((afhd.a)???).itemList);
      this.jdField_a_of_type_Afhd$b = this.b;
      this.b = null;
      a((afhd.a)???);
      return;
      ??? = finally;
      throw ???;
    }
    label212:
    biW();
  }
  
  public void a(afhd.c paramc)
  {
    this.jdField_a_of_type_Afhd$c = paramc;
  }
  
  public void cZt()
  {
    synchronized (this.cI)
    {
      this.jdField_a_of_type_Afhd$b = null;
      this.b = null;
      this.zE.clear();
      this.jdField_a_of_type_Afhd$c = null;
      return;
    }
  }
  
  public void loadMore()
  {
    if (this.b != null)
    {
      a(new afhd.a(-103));
      return;
    }
    if (this.jdField_a_of_type_Afhd$b == null)
    {
      a(new afhd.a(-102));
      return;
    }
    if (!this.jdField_a_of_type_Afhd$b.hasMore)
    {
      a(new afhd.a(-104));
      return;
    }
    synchronized (this.cI)
    {
      this.b = this.jdField_a_of_type_Afhd$b;
      this.b.startIndex = this.zE.size();
      biW();
      return;
    }
  }
  
  public void onDestroy()
  {
    cZt();
    this.mApp = null;
  }
  
  public void r(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int j = 0;
    int i;
    afhd.b localb;
    try
    {
      i = paramIntent.getIntExtra("EmoSearch_reqType", 0);
      paramIntent = paramIntent.getStringExtra("EmoSearch_reqKeywords");
      localb = this.b;
      if (localb == null) {
        QLog.e("EmotionSearchManager", 2, "handleResonpse currentSearchingTask is null");
      }
      for (;;)
      {
        return;
        if (localb.y(i, paramIntent)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EmotionSearchManager", 2, "handleResonpse resp not current task current");
        }
      }
      localArrayList = new ArrayList();
    }
    finally {}
    ArrayList localArrayList;
    int k = -100;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      i = paramFromServiceMsg.getWupBuffer().length - 4;
      paramIntent = new byte[i];
      aqoj.copyData(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
      paramFromServiceMsg.putWupBuffer(paramIntent);
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          paramIntent = paramFromServiceMsg.getWupBuffer();
          paramFromServiceMsg = new HotPicMsg.RspBody();
          paramFromServiceMsg.mergeFrom(paramIntent);
          paramFromServiceMsg = (HotPicMsg.GetImgInfoRsp)paramFromServiceMsg.msg_get_imginfo_rsp.get();
          if ((paramFromServiceMsg != null) && ((paramFromServiceMsg.int32_result.get() == 0) || (paramFromServiceMsg.int32_result.get() == -5)))
          {
            k = paramFromServiceMsg.uint32_build_ver.get();
            paramIntent = new ArrayList();
            paramFromServiceMsg = paramFromServiceMsg.rpt_msg_img_info.get();
            if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
            {
              i = 0;
              if (i < paramFromServiceMsg.size())
              {
                Object localObject = (HotPicMsg.ImgInfo)paramFromServiceMsg.get(i);
                EmotionSearchItem localEmotionSearchItem = new EmotionSearchItem();
                localEmotionSearchItem.version = k;
                localEmotionSearchItem.picIndex = ((HotPicMsg.ImgInfo)localObject).uint32_pic_index.get();
                localEmotionSearchItem.fileType = ((HotPicMsg.ImgInfo)localObject).uint32_file_type.get();
                localEmotionSearchItem.sourceType = ((HotPicMsg.ImgInfo)localObject).uint32_source_type.get();
                localEmotionSearchItem.height = ((HotPicMsg.ImgInfo)localObject).uint32_thumb_file_height.get();
                localEmotionSearchItem.width = ((HotPicMsg.ImgInfo)localObject).uint32_thumb_file_width.get();
                localEmotionSearchItem.url = ((HotPicMsg.ImgInfo)localObject).bytes_thumb_down_url.get().toStringUtf8();
                localEmotionSearchItem.md5 = ((HotPicMsg.ImgInfo)localObject).bytes_thumb_file_md5.get().toStringUtf8().toUpperCase();
                localEmotionSearchItem.fileSize = ((HotPicMsg.ImgInfo)localObject).uint64_thumb_file_size.get();
                localEmotionSearchItem.originalMD5 = ((HotPicMsg.ImgInfo)localObject).bytes_file_md5.get().toStringUtf8().toUpperCase();
                localEmotionSearchItem.originalUrl = ((HotPicMsg.ImgInfo)localObject).bytes_pic_down_url.get().toStringUtf8();
                localEmotionSearchItem.originalHeight = ((HotPicMsg.ImgInfo)localObject).uint32_file_height.get();
                localEmotionSearchItem.originalWidth = ((HotPicMsg.ImgInfo)localObject).uint32_file_width.get();
                localEmotionSearchItem.oringinalSize = ((HotPicMsg.ImgInfo)localObject).uint64_file_size.get();
                if (localEmotionSearchItem.sourceType == 3)
                {
                  localObject = ((HotPicMsg.ImgInfo)localObject).msg_third_party_info;
                  localEmotionSearchItem.iconUrl = ((HotPicMsg.ThirdPartyInfo)localObject).bytes_icon_url.get().toStringUtf8();
                  localEmotionSearchItem.name = ((HotPicMsg.ThirdPartyInfo)localObject).bytes_name.get().toStringUtf8();
                  localEmotionSearchItem.jumpUrl = ((HotPicMsg.ThirdPartyInfo)localObject).bytes_jump_url.get().toStringUtf8();
                  localEmotionSearchItem.appid = ((HotPicMsg.ThirdPartyInfo)localObject).bytes_appid.get().toStringUtf8();
                }
                paramIntent.add(localEmotionSearchItem);
                i += 1;
                continue;
              }
            }
            localArrayList.addAll(paramIntent);
            i = j;
          }
        }
        catch (InvalidProtocolBufferMicroException paramIntent)
        {
          i = -100;
        }
        try
        {
          if (QLog.isColorLevel())
          {
            i = j;
            QLog.d("EmotionSearchManager", 2, "handleResonpse,REQ_GET_PIC success,size:" + localArrayList.size());
          }
          i = 0;
          a(localb, localArrayList, i);
        }
        catch (InvalidProtocolBufferMicroException paramIntent)
        {
          label670:
          break label670;
        }
      }
      j = paramFromServiceMsg.int32_result.get();
      i = j;
      if (QLog.isColorLevel())
      {
        i = j;
        QLog.d("EmotionSearchManager", 2, "handleResonpse,REQ_GET_PIC error,result:" + paramFromServiceMsg.int32_result.get());
      }
      i = j;
      continue;
      paramIntent.printStackTrace();
      continue;
      i = k;
      if (QLog.isColorLevel())
      {
        QLog.d("EmotionSearchManager", 2, "handleResonpse,msg.getResultCode() error:" + paramFromServiceMsg.getResultCode());
        i = k;
      }
    }
  }
  
  public static class a
  {
    afhd.b c;
    int cQR;
    List<EmotionSearchItem> itemList;
    
    public a(int paramInt)
    {
      this.cQR = paramInt;
    }
    
    public List<EmotionSearchItem> getItemList()
    {
      return this.itemList;
    }
    
    public int getResult()
    {
      return this.cQR;
    }
    
    public boolean isHasMore()
    {
      if (this.c == null) {
        return false;
      }
      return this.c.hasMore;
    }
  }
  
  public static class b
  {
    String bDp;
    int cQS = 0;
    boolean hasMore = true;
    int startIndex;
    int taskType;
    
    public b(int paramInt)
    {
      this(paramInt, null);
    }
    
    public b(int paramInt, String paramString)
    {
      this.taskType = paramInt;
      this.bDp = paramString;
    }
    
    public boolean a(b paramb)
    {
      if (paramb == null) {
        return false;
      }
      return y(paramb.taskType, paramb.bDp);
    }
    
    public boolean y(int paramInt, String paramString)
    {
      if (aqmr.isEmpty(this.bDp)) {}
      for (boolean bool = aqmr.isEmpty(paramString); (1 != 0) && (bool); bool = this.bDp.equalsIgnoreCase(paramString)) {
        return true;
      }
      return false;
    }
  }
  
  public static abstract interface c
  {
    public abstract void b(afhd.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afhd
 * JD-Core Version:    0.7.0.1
 */