import android.graphics.Paint;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.oidb.oidb_0xdea.Comment;>;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.oidb.oidb_0xdea.Comment;

public class aeeo
{
  private static aeeo jdField_a_of_type_Aeeo;
  private aees jdField_a_of_type_Aees;
  public Paint bR;
  public int cMm = aqnm.dip2px(150.0F);
  private LruCache<String, aeeo.a> s;
  
  private aeeo()
  {
    if (this.s == null) {
      this.s = new LruCache(10485760);
    }
    if (BaseApplicationImpl.sProcessId == 1)
    {
      if (this.jdField_a_of_type_Aees == null) {
        this.jdField_a_of_type_Aees = new aees();
      }
      cWy();
    }
  }
  
  public static aeeo a()
  {
    if (jdField_a_of_type_Aeeo == null) {
      jdField_a_of_type_Aeeo = new aeeo();
    }
    return jdField_a_of_type_Aeeo;
  }
  
  public aeeo.a a(String paramString)
  {
    return (aeeo.a)this.s.get(paramString);
  }
  
  public void a(aeen paramaeen, aeep.b paramb)
  {
    if ((paramaeen.VP == 0L) || (paramaeen.groupUin == 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DanmuDataHolder", 2, String.format("request, bad parameter, topicUin:%s, groupUin:%s", new Object[] { Long.valueOf(paramaeen.VP), Long.valueOf(paramaeen.groupUin) }));
      }
      return;
    }
    Object localObject = a().h(paramaeen.groupUin, paramaeen.VP);
    aeeo.a locala = a().a((String)localObject);
    localObject = locala;
    if (locala == null)
    {
      localObject = new aeeo.a().a(paramaeen).d(0).e(0).a(paramb).a();
      QLog.d("DanmuDataHolder", 2, "request start, reqHolder is null, create it");
    }
    this.jdField_a_of_type_Aees.a((aeeo.a)localObject);
  }
  
  public void a(String paramString, aeeo.a parama)
  {
    this.s.put(paramString, parama);
  }
  
  public aeeo.a b(String paramString)
  {
    aeeo.a locala = new aeeo.a();
    a(paramString, locala);
    return locala;
  }
  
  public void cWy()
  {
    QQAppInterface localQQAppInterface = getAppInterface();
    if ((this.bR == null) && (localQQAppInterface != null)) {
      this.bR = ((TextView)LayoutInflater.from(localQQAppInterface.getApp()).inflate(2131559024, null).findViewById(2131364968)).getPaint();
    }
  }
  
  public void clear()
  {
    this.s.evictAll();
  }
  
  public List<DanmuItemBean> d(List<oidb_0xdea.Comment> paramList, long paramLong)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    QQAppInterface localQQAppInterface = getAppInterface();
    if (localQQAppInterface == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    anbg localanbg = new anbg();
    Iterator localIterator = paramList.iterator();
    Object localObject1;
    if (localIterator.hasNext()) {
      localObject1 = (oidb_0xdea.Comment)localIterator.next();
    }
    for (;;)
    {
      long l1;
      long l2;
      int i;
      try
      {
        paramList = new im_msg_body.MsgBody();
        paramList.mergeFrom(((oidb_0xdea.Comment)localObject1).bytes_comment_msg.get().toByteArray());
        Object localObject2 = new im_msg_body.RichText();
        ((im_msg_body.RichText)localObject2).mergeFrom(((im_msg_body.RichText)paramList.rich_text.get()).toByteArray());
        localObject2 = ((im_msg_body.RichText)localObject2).elems.get();
        l1 = ((oidb_0xdea.Comment)localObject1).uint64_comment_uin.get();
        l2 = ((oidb_0xdea.Comment)localObject1).uint64_seq.get();
        long l3 = ((oidb_0xdea.Comment)localObject1).uint32_comment_ctime.get();
        long l4 = ((oidb_0xdea.Comment)localObject1).uint64_comment_location.get();
        paramList = new aozx();
        paramList.frienduin = String.valueOf(paramLong);
        paramList.uinType = 1;
        Object localObject3 = localanbg.a((List)localObject2, new StringBuilder(), l2, paramList);
        if (TextUtils.isEmpty(((anbg.a)localObject3).cdm)) {
          break;
        }
        if ((TextUtils.isEmpty(((anbg.a)localObject3).b.mAnonymousNickName)) && (((anbg.a)localObject3).a != null) && (!TextUtils.isEmpty(((anbg.a)localObject3).cdm)) && (((anbg.a)localObject3).cdm.length() > ((anbg.a)localObject3).a.textLen + 1) && (((anbg.a)localObject3).cdm.startsWith(((anbg.a)localObject3).cdn)))
        {
          paramList = ((anbg.a)localObject3).cdm.substring(((anbg.a)localObject3).a.textLen + 1);
          if (!TextUtils.isEmpty(paramList)) {
            ((anbg.a)localObject3).cdm = paramList;
          }
        }
        paramList = ((oidb_0xdea.Comment)localObject1).bytes_nick.get().toStringUtf8();
        i = ((oidb_0xdea.Comment)localObject1).uint32_source.get();
        if (TextUtils.isEmpty(paramList))
        {
          localObject1 = aqgv.h(localQQAppInterface, String.valueOf(paramLong), String.valueOf(l1));
          paramList = (List<oidb_0xdea.Comment>)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("DanmuDataHolder", 2, new Object[] { "decodeCommentList, use local nickname, seq:", Long.valueOf(l2) });
            paramList = (List<oidb_0xdea.Comment>)localObject1;
          }
          paramList = aeeu.a(this.bR, paramList, this.cMm);
          localObject1 = new DanmuItemBean(l1, l2, l3, l4, ((anbg.a)localObject3).cdm, paramList);
          localArrayList.add(localObject1);
          localObject2 = ((List)localObject2).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          paramList = (im_msg_body.Elem)((Iterator)localObject2).next();
          if (!paramList.anon_group_msg.has()) {
            continue;
          }
          localObject3 = (im_msg_body.AnonymousGroupMsg)paramList.anon_group_msg.get();
          paramList = ((im_msg_body.AnonymousGroupMsg)localObject3).str_anon_nick.get().toByteArray();
          if (((im_msg_body.AnonymousGroupMsg)localObject3).uint32_flags.get() <= 0) {
            break label781;
          }
          bool = true;
          ((DanmuItemBean)localObject1).bTv = bool;
          if (paramList != null) {
            break label727;
          }
          paramList = "";
          ((DanmuItemBean)localObject1).bwD = paramList;
          ((DanmuItemBean)localObject1).cMq = ((im_msg_body.AnonymousGroupMsg)localObject3).uint32_head_portrait.get();
          QLog.d("DanmuDataHolder", 1, new Object[] { "decodeCommentList, 匿名消息,", localObject1 });
          continue;
        }
      }
      catch (Exception paramList)
      {
        QLog.d("DanmuDataHolder", 1, "decodeCommentList, e:" + paramList);
      }
      if (i == 4)
      {
        localObject1 = ((acff)localQQAppInterface.getManager(51)).b(String.valueOf(l1));
        if ((localObject1 != null) && (((Friends)localObject1).isFriend()) && (!TextUtils.isEmpty(((Friends)localObject1).remark)))
        {
          localObject1 = ((Friends)localObject1).remark;
          paramList = (List<oidb_0xdea.Comment>)localObject1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("DanmuDataHolder", 2, new Object[] { "decodeCommentList, use local remake, seq:", Long.valueOf(l2) });
          paramList = (List<oidb_0xdea.Comment>)localObject1;
          continue;
          label727:
          paramList = new String(paramList);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("DanmuDataHolder", 2, "decodeCommentList, " + localArrayList.toString());
          }
          return localArrayList;
        }
      }
      continue;
      label781:
      boolean bool = false;
    }
  }
  
  public QQAppInterface getAppInterface()
  {
    if (BaseApplicationImpl.sProcessId == 1) {
      return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return null;
  }
  
  public String h(long paramLong1, long paramLong2)
  {
    return String.valueOf(paramLong1) + paramLong2;
  }
  
  public class a
  {
    aeen jdField_a_of_type_Aeen;
    aeep.b jdField_a_of_type_Aeep$b;
    int cMn = 0;
    int cMo = 0;
    int cMp = 0;
    int count = 60;
    int intervalTime = 30;
    boolean isFinish = false;
    int lastUpdateTime = 0;
    List<Long> yK;
    List<Long> yL = new ArrayList();
    List<DanmuItemBean> yM;
    List<DanmuItemBean> yN = new ArrayList();
    
    public a() {}
    
    public a a()
    {
      aeeo.a().a(aeeo.a().h(this.jdField_a_of_type_Aeen.groupUin, this.jdField_a_of_type_Aeen.VP), this);
      return this;
    }
    
    public a a(int paramInt)
    {
      this.lastUpdateTime = paramInt;
      return this;
    }
    
    public a a(aeen paramaeen)
    {
      this.jdField_a_of_type_Aeen = paramaeen;
      return this;
    }
    
    public a a(aeep.b paramb)
    {
      this.jdField_a_of_type_Aeep$b = paramb;
      return this;
    }
    
    public a a(List<DanmuItemBean> paramList)
    {
      this.yM = paramList;
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      this.isFinish = paramBoolean;
      return this;
    }
    
    public a b(int paramInt)
    {
      if (paramInt > 0) {
        this.intervalTime = paramInt;
      }
      return this;
    }
    
    public a b(List<Long> paramList)
    {
      this.yK = paramList;
      return this;
    }
    
    public void bGa()
    {
      Iterator localIterator = this.yN.iterator();
      DanmuItemBean localDanmuItemBean;
      while (localIterator.hasNext())
      {
        localDanmuItemBean = (DanmuItemBean)localIterator.next();
        if (this.yK.contains(Long.valueOf(localDanmuItemBean.VT))) {
          localIterator.remove();
        }
      }
      if ((this.yK != null) && (!this.yK.isEmpty()))
      {
        localIterator = this.yK.iterator();
        while (localIterator.hasNext())
        {
          long l = ((Long)localIterator.next()).longValue();
          if (!this.yL.contains(Long.valueOf(l))) {
            this.yL.add(Long.valueOf(l));
          }
        }
      }
      if ((this.yM != null) && (!this.yM.isEmpty()))
      {
        localIterator = this.yM.iterator();
        while (localIterator.hasNext())
        {
          localDanmuItemBean = (DanmuItemBean)localIterator.next();
          if (!x(localDanmuItemBean.VS, localDanmuItemBean.VT)) {
            this.yN.add(localDanmuItemBean);
          }
        }
      }
    }
    
    public a c(int paramInt)
    {
      this.cMp = paramInt;
      return this;
    }
    
    public a d(int paramInt)
    {
      this.cMn = paramInt;
      return this;
    }
    
    public a e(int paramInt)
    {
      this.cMo = paramInt;
      return this;
    }
    
    public String tc()
    {
      return String.format("CacheHolder - topicUin:%s, groupUin:%s, msgType:%s, peakCached:%s, videoStartTime:%s, videoEndTime:%s, nextStartIdx:%s, count:%s", new Object[] { Long.valueOf(this.jdField_a_of_type_Aeen.VP), Long.valueOf(this.jdField_a_of_type_Aeen.groupUin), Integer.valueOf(this.jdField_a_of_type_Aeen.cMl), Boolean.valueOf(this.jdField_a_of_type_Aeen.bTt), Integer.valueOf(this.cMn), Integer.valueOf(this.cMo), Integer.valueOf(this.cMp), Integer.valueOf(this.count) });
    }
    
    public boolean x(long paramLong1, long paramLong2)
    {
      Iterator localIterator = this.yN.iterator();
      while (localIterator.hasNext())
      {
        DanmuItemBean localDanmuItemBean = (DanmuItemBean)localIterator.next();
        if ((localDanmuItemBean.VS == paramLong1) && (localDanmuItemBean.VT == paramLong2)) {
          return true;
        }
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeeo
 * JD-Core Version:    0.7.0.1
 */