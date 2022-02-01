import android.content.Intent;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emotionintegrate.EmotionGallery;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

public class afru
  extends afro
  implements afrp.a
{
  private long XF;
  public afrn a;
  private afrp.a a;
  private EmotionGallery b;
  private boolean caz;
  private HashMap<MessageForPic, afrp> kv = new HashMap();
  public SessionInfo mSessionInfo;
  public MessageRecord v;
  
  public afru(Intent paramIntent, afrt paramafrt, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_Afrn = new afrn(paramSessionInfo.aTl, paramSessionInfo.cZ);
    this.v = paramafrt.messageRecord;
    this.mSessionInfo = paramSessionInfo;
    this.XF = paramIntent.getLongExtra("key_multi_forward_seq", 0L);
    this.caz = paramIntent.getBooleanExtra("key_is_multi_forward_msg", false);
  }
  
  private aojj a(MessageForPic paramMessageForPic)
  {
    boolean bool = true;
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface != null)
    {
      akxl localakxl = new akxl();
      localakxl.fileSizeFlag = paramMessageForPic.fileSizeFlag;
      if (localakxl.fileSizeFlag == 1) {}
      for (;;)
      {
        int i = aoop.n("chatimg", bool);
        paramMessageForPic = localQQAppInterface.a().a(aooi.o(paramMessageForPic.md5, paramMessageForPic.uuid, i));
        if ((paramMessageForPic == null) || (!(paramMessageForPic instanceof aojj))) {
          break;
        }
        return (aojj)paramMessageForPic;
        bool = false;
      }
    }
    return null;
  }
  
  public int Dw()
  {
    return 1;
  }
  
  public void a(int paramInt, MessageForPic paramMessageForPic)
  {
    afrl localafrl = (afrl)this.b.getSelectedItem();
    if (!(localafrl instanceof afrt)) {}
    while (((afrt)localafrl).messageRecord != paramMessageForPic) {
      return;
    }
    this.jdField_a_of_type_Afrp$a.a(paramInt, paramMessageForPic);
  }
  
  public void a(EmotionGallery paramEmotionGallery, afrm paramafrm, long paramLong, afro.a parama)
  {
    if ((this.caz) && (paramLong == this.XF))
    {
      parama.dbG();
      return;
    }
    paramafrm = paramafrm.getData();
    Object localObject;
    if (paramafrm != null)
    {
      paramafrm = paramafrm.iterator();
      do
      {
        if (!paramafrm.hasNext()) {
          break;
        }
        localObject = (afrl)paramafrm.next();
      } while ((!(localObject instanceof afrt)) || (((afrt)localObject).messageRecord.uniseq != paramLong));
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MsgEmotionFragmentDataSource", 2, "onRevokeMsg notContain seq:" + paramLong);
        return;
      }
      paramEmotionGallery = (afrl)paramEmotionGallery.getSelectedItem();
      paramafrm = ((afrt)paramEmotionGallery).messageRecord;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("onRevokeMsg seq:").append(paramLong).append(", selectItem seq:");
        if (paramafrm == null) {
          break label216;
        }
      }
      label216:
      for (long l = paramafrm.uniseq;; l = 0L)
      {
        QLog.d("MsgEmotionFragmentDataSource", 2, l);
        if (paramafrm == null) {
          break;
        }
        if (paramLong != paramafrm.uniseq) {
          break label222;
        }
        parama.dbG();
        return;
      }
      label222:
      a(parama, paramEmotionGallery, true);
      return;
    }
  }
  
  public void a(EmotionGallery paramEmotionGallery, Handler paramHandler, afrl paramafrl, afrp.a parama)
  {
    if (!(paramafrl instanceof afrt)) {}
    do
    {
      return;
      paramafrl = (afrt)paramafrl;
    } while (!(paramafrl.messageRecord instanceof MessageForPic));
    this.jdField_a_of_type_Afrp$a = parama;
    this.b = paramEmotionGallery;
    paramEmotionGallery = (MessageForPic)paramafrl.messageRecord;
    if (QLog.isColorLevel()) {
      QLog.d("MsgEmotionFragmentDataSource", 2, "triggerDownloadPic, mr uniseq: " + paramEmotionGallery.uniseq);
    }
    paramHandler = new afrp(paramEmotionGallery, paramHandler, this);
    if (!this.kv.containsKey(paramEmotionGallery)) {
      this.kv.put(paramEmotionGallery, paramHandler);
    }
    paramafrl = a(paramEmotionGallery);
    if (paramafrl != null) {
      paramafrl.b(paramHandler);
    }
    for (;;)
    {
      AIOImageProviderService.a(getApp(), paramEmotionGallery);
      return;
      paramafrl = akxj.a(6, 1536, 1);
      paramafrl.a(paramEmotionGallery, paramEmotionGallery.getPicDownloadInfo());
      paramafrl.b(paramHandler);
      paramHandler = getApp();
      if (paramHandler != null) {
        akxj.a(paramafrl, paramHandler);
      }
    }
  }
  
  public void a(boolean paramBoolean, MessageForPic paramMessageForPic)
  {
    Object localObject = (afrp)this.kv.remove(paramMessageForPic);
    aojj localaojj = a(paramMessageForPic);
    if (localaojj != null) {
      localaojj.a((akxb)localObject);
    }
    localObject = (afrl)this.b.getSelectedItem();
    if (!(localObject instanceof afrt)) {}
    do
    {
      return;
      localObject = ((afrt)localObject).messageRecord;
      if ((localObject == null) || (paramMessageForPic == null) || (localObject == paramMessageForPic)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MsgEmotionFragmentDataSource", 2, "onUIResult, mr not equal, picMr:" + paramMessageForPic.uniseq + " mr:" + ((MessageRecord)localObject).uniseq);
    return;
    this.jdField_a_of_type_Afrp$a.a(paramBoolean, paramMessageForPic);
  }
  
  public boolean ajS()
  {
    return true;
  }
  
  public boolean b(afrl paramafrl)
  {
    if (!(paramafrl instanceof afrt)) {
      return true;
    }
    paramafrl = ((afrt)paramafrl).messageRecord;
    if ((paramafrl instanceof MessageForPic))
    {
      paramafrl = (MessageForPic)paramafrl;
      File localFile = aoiz.getFile(aoop.a(paramafrl, 1).toString());
      if (localFile == null) {
        return false;
      }
      if ((paramafrl.fileSizeFlag != 1) && (paramafrl.mShowLength > 0))
      {
        long l1 = paramafrl.size;
        if (!paramafrl.isMixed)
        {
          long l2 = localFile.length();
          if (l2 < l1)
          {
            if (QLog.isColorLevel()) {
              QLog.i("MsgEmotionFragmentDataSource", 2, "checkMsgPicReady, fileLen:" + l2 + " fileLenBySender:" + l1);
            }
            return false;
          }
        }
      }
    }
    return true;
  }
  
  protected QQAppInterface getApp()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void onDestroy()
  {
    if (!this.kv.isEmpty())
    {
      Iterator localIterator = this.kv.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        aojj localaojj = a((MessageForPic)localEntry.getKey());
        if (localaojj != null) {
          localaojj.a((akxb)localEntry.getValue());
        }
      }
    }
    this.kv.clear();
  }
  
  public List<afrl> s(boolean paramBoolean)
  {
    Object localObject2 = new ArrayList();
    long l;
    label34:
    List localList;
    Object localObject1;
    Object localObject3;
    boolean bool;
    if ((this.v != null) && (this.v.isMultiMsg))
    {
      l = this.v.msgseq;
      localList = this.jdField_a_of_type_Afrn.a(this.mSessionInfo.aTl, this.mSessionInfo.cZ, paramBoolean, l);
      if (localList == null) {
        break label358;
      }
      localObject1 = localList.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (MessageRecord)((Iterator)localObject1).next();
          if ((localObject3 != null) && (this.v != null) && (((MessageRecord)localObject3).time == this.v.time)) {
            if ((((MessageRecord)localObject3).msgtype == 1) || (((MessageRecord)localObject3).msgtype == 3000))
            {
              if (((MessageRecord)localObject3).shmsgseq != this.v.shmsgseq) {
                continue;
              }
              bool = true;
            }
          }
        }
      }
    }
    for (;;)
    {
      label161:
      if (localList != null) {
        ((List)localObject2).addAll(0, localList);
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("getEmotionDataIncremental tempList size:");
        if (localList == null)
        {
          localObject1 = "null";
          label208:
          QLog.d("MsgEmotionFragmentDataSource", 2, localObject1 + " contains:" + bool);
        }
      }
      else
      {
        if ((this.v != null) && (localList != null) && (!localList.isEmpty())) {
          break label348;
        }
        QLog.d("MsgEmotionFragmentDataSource", 1, "mCurMsgRecord or tempList is null or empty");
      }
      for (;;)
      {
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((List)localObject1).add(new afrt((MessageRecord)((Iterator)localObject2).next()));
        }
        l = -1L;
        break label34;
        bool = true;
        break label161;
        localObject1 = Integer.valueOf(localList.size());
        break label208;
        label348:
        if (!bool) {
          break;
        }
      }
      return localObject1;
      label358:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afru
 * JD-Core Version:    0.7.0.1
 */