import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro<*>;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_head.Head;
import tencent.im.msg.im_msg_head.HttpConnHead;
import tencent.im.msg.im_msg_head.LoginSig;

public abstract class ashv
  extends accg
{
  private List<ashv.b> JQ = new ArrayList();
  private ashu a;
  private final AtomicInteger au = new AtomicInteger();
  public ashx c = new ashw(this);
  private aolm d;
  private Object fM = new Object();
  
  protected ashv(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = ((ashu)paramQQAppInterface.getBusinessHandler(104));
    paramQQAppInterface.addObserver(this.c);
    this.d = paramQQAppInterface.getNetEngine(0);
  }
  
  private int a(int paramInt1, MessageMicro<?> paramMessageMicro, boolean paramBoolean, int paramInt2, Object paramObject)
  {
    int i = 1;
    String str = this.a.DR();
    if (this.a.ah() == null) {
      if (paramBoolean) {
        i = 2;
      }
    }
    do
    {
      do
      {
        do
        {
          return i;
        } while (this.a.a(paramInt1, paramMessageMicro, paramInt2, paramObject));
        return 3;
        if (this.a.ai() != null) {
          break;
        }
        if (paramBoolean) {
          return 4;
        }
      } while (this.a.a(paramInt1, paramMessageMicro, paramInt2, paramObject));
      return 5;
      if ((str != null) && (str.length() != 0)) {
        break;
      }
      if (paramBoolean) {
        return 6;
      }
    } while (this.a.a(paramInt1, paramMessageMicro, paramInt2, paramObject));
    return 7;
    return 0;
  }
  
  private void a(int paramInt1, MessageMicro<?> paramMessageMicro, boolean paramBoolean, int paramInt2, Object paramObject)
  {
    int i = a(paramInt1, paramMessageMicro, paramBoolean, paramInt2, paramObject);
    if (i == 1)
    {
      QLog.d("BigDataHandler", 1, "We will wait getIPList call back to do bigData Req" + paramInt1);
      if (!paramBoolean) {
        synchronized (this.fM)
        {
          this.JQ.add(new ashv.b(paramInt1, paramMessageMicro, paramInt2, paramObject));
          return;
        }
      }
    }
    else
    {
      if (i != 0)
      {
        QLog.d("BigDataHandler", 1, "USER command get key error status: " + i);
        a(paramInt1, false, null, paramInt2, paramObject);
        return;
      }
      long l;
      Object localObject2;
      try
      {
        l = Long.parseLong(this.app.getCurrentAccountUin());
        localObject2 = new Cryptor().encrypt(paramMessageMicro.toByteArray(), this.a.ah());
        paramMessageMicro = new String();
        i = 0;
        while (i < "3.4.4".length())
        {
          ??? = paramMessageMicro;
          if ("3.4.4".charAt(i) != '.') {
            ??? = paramMessageMicro.concat(Character.toString("3.4.4".charAt(i)));
          }
          i += 1;
          paramMessageMicro = (MessageMicro<?>)???;
        }
        ??? = new im_msg_head.LoginSig();
      }
      catch (Exception paramMessageMicro)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigDataHandler", 2, paramInt1 + " uin case long fail");
        }
        a(paramInt1, false, null, paramInt2, paramObject);
        return;
      }
      ((im_msg_head.LoginSig)???).uint32_type.set(22);
      ((im_msg_head.LoginSig)???).bytes_sig.set(ByteStringMicro.copyFrom(this.a.ai()));
      Object localObject3 = new im_msg_head.HttpConnHead();
      ((im_msg_head.HttpConnHead)localObject3).uint64_uin.set(l);
      ((im_msg_head.HttpConnHead)localObject3).uint32_command.set(1791);
      ((im_msg_head.HttpConnHead)localObject3).uint32_sub_command.set(paramInt2);
      ((im_msg_head.HttpConnHead)localObject3).uint32_seq.set(this.au.incrementAndGet());
      ((im_msg_head.HttpConnHead)localObject3).uint32_version.set(Integer.parseInt(paramMessageMicro));
      ((im_msg_head.HttpConnHead)localObject3).uint32_flag.set(1);
      ((im_msg_head.HttpConnHead)localObject3).uint32_compress_type.set(0);
      ((im_msg_head.HttpConnHead)localObject3).uint32_error_code.set(0);
      paramMessageMicro = new im_msg_head.Head();
      paramMessageMicro.uint32_head_type.set(4);
      paramMessageMicro.msg_login_sig.set((MessageMicro)???);
      paramMessageMicro.msg_httpconn_head.set((MessageMicro)localObject3);
      ??? = paramMessageMicro.toByteArray();
      paramMessageMicro = new ByteArrayOutputStream();
      try
      {
        localObject3 = new DataOutputStream(paramMessageMicro);
        ((DataOutputStream)localObject3).write(40);
        ((DataOutputStream)localObject3).writeInt(???.length);
        ((DataOutputStream)localObject3).writeInt(localObject2.length);
        ((DataOutputStream)localObject3).write((byte[])???);
        ((DataOutputStream)localObject3).write((byte[])localObject2);
        ((DataOutputStream)localObject3).write(41);
        ((DataOutputStream)localObject3).flush();
        ??? = this.a.DR();
        ??? = (String)??? + "cgi-bin/httpconn";
        paramMessageMicro = paramMessageMicro.toByteArray();
        localObject2 = new aoll();
        ((aoll)localObject2).bw(paramObject);
        ((aoll)localObject2).X = paramMessageMicro;
        ((aoll)localObject2).f = new ashv.a(paramInt1, this, this.a.ah(), paramInt2, paramObject);
        ((aoll)localObject2).bZ = ((String)???);
        ((aoll)localObject2).mHttpMethod = 1;
        ((aoll)localObject2).u.put("Accept-Encoding", "identity");
        if (this.d != null)
        {
          this.d.a((aomg)localObject2);
          return;
        }
      }
      catch (Exception paramMessageMicro)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigDataHandler", 2, paramMessageMicro.getMessage());
        }
        a(paramInt1, false, null, paramInt2, paramObject);
      }
    }
  }
  
  private void enA()
  {
    if (this.JQ != null)
    {
      synchronized (this.fM)
      {
        Iterator localIterator = this.JQ.iterator();
        if (localIterator.hasNext())
        {
          ashv.b localb = (ashv.b)localIterator.next();
          a(localb.Np(), false, null, localb.Nq(), localb.U());
        }
      }
      this.JQ.clear();
    }
  }
  
  private void enz()
  {
    if (this.JQ != null)
    {
      synchronized (this.fM)
      {
        Iterator localIterator = this.JQ.iterator();
        if (localIterator.hasNext())
        {
          ashv.b localb = (ashv.b)localIterator.next();
          a(localb.Np(), localb.a(), true, localb.Nq(), localb.U());
        }
      }
      this.JQ.clear();
    }
  }
  
  public void a(int paramInt1, MessageMicro<?> paramMessageMicro, int paramInt2, Object paramObject)
  {
    a(paramInt1, paramMessageMicro, false, paramInt2, paramObject);
  }
  
  protected abstract void a(int paramInt1, boolean paramBoolean, byte[] paramArrayOfByte, int paramInt2, Object paramObject);
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.app != null) {
      this.app.removeObserver(this.c);
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  static class a
    implements aolm.b
  {
    private int command = -1;
    private byte[] eR;
    private int emd = -1;
    private WeakReference<ashv> iU;
    private Object userData;
    
    public a(int paramInt1, ashv paramashv, byte[] paramArrayOfByte, int paramInt2, Object paramObject)
    {
      this.command = paramInt1;
      this.emd = paramInt2;
      this.userData = paramObject;
      this.iU = new WeakReference(paramashv);
      this.eR = paramArrayOfByte;
    }
    
    public void onResp(aomh paramaomh)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp");
      }
      ashv localashv = (ashv)this.iU.get();
      if (localashv == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp handler is null");
        }
        return;
      }
      Object localObject1;
      if ((paramaomh == null) || (paramaomh.mResult != 0))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder().append("BigDataDownloadListener$onResp | resp = ").append(paramaomh).append(" | mResult=");
          if (paramaomh == null) {
            break label130;
          }
        }
        label130:
        for (i = paramaomh.mResult;; i = 0)
        {
          QLog.d("BigDataHandler", 2, i);
          localashv.a(this.command, false, null, this.emd, this.userData);
          return;
        }
      }
      Object localObject2;
      try
      {
        localObject2 = paramaomh.mRespData;
        i = localObject2.length;
        if ((localObject2[0] != 40) || (localObject2[(i - 1)] != 41))
        {
          localObject1 = "unexpected body data, len=" + i + ", data=";
          localObject2 = localObject2.toString();
          StringBuilder localStringBuilder = new StringBuilder().append((String)localObject1);
          localObject1 = localObject2;
          if (((String)localObject2).length() > 20) {
            localObject1 = ((String)localObject2).substring(0, 20);
          }
          localObject1 = (String)localObject1;
          if (QLog.isColorLevel()) {
            QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp | resp = " + paramaomh + " | mResult=" + (String)localObject1);
          }
          localashv.a(this.command, false, null, this.emd, this.userData);
          return;
        }
      }
      catch (Exception paramaomh)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp | Exception:" + paramaomh.getMessage());
        }
        localashv.a(this.command, false, null, this.emd, this.userData);
        return;
      }
      paramaomh = new DataInputStream(new ByteArrayInputStream((byte[])localObject2));
      paramaomh.readByte();
      int k = paramaomh.readInt();
      int j = paramaomh.readInt();
      if ((k > i) || (j > i))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigDataHandler", 2, "unexpected length, headLen=" + k + ", bodyLen=" + j);
        }
        localashv.a(this.command, false, null, this.emd, this.userData);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp | headLen=" + k + " | bodyLen=" + j);
      }
      if (k > 0)
      {
        localObject1 = new byte[k];
        paramaomh.read((byte[])localObject1);
        localObject2 = new im_msg_head.Head();
        ((im_msg_head.Head)localObject2).mergeFrom((byte[])localObject1);
      }
      for (int i = ((im_msg_head.HttpConnHead)((im_msg_head.Head)localObject2).msg_httpconn_head.get()).uint32_error_code.get();; i = 0)
      {
        if ((j > 0) && (i == 0))
        {
          localObject1 = new byte[j];
          paramaomh.read((byte[])localObject1);
          paramaomh = new Cryptor().decrypt((byte[])localObject1, this.eR);
          localashv.a(this.command, true, paramaomh, this.emd, this.userData);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("BigDataHandler", 2, "BigDataDownloadListener$onResp | errorCode:" + i);
        }
        localashv.a(this.command, false, null, this.emd, this.userData);
        return;
      }
    }
    
    public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
  }
  
  public static class b
  {
    int command = 0;
    MessageMicro<?> d = null;
    int emd = 0;
    Object userData = null;
    
    public b(int paramInt1, MessageMicro<?> paramMessageMicro, int paramInt2, Object paramObject)
    {
      this.command = paramInt1;
      this.d = paramMessageMicro;
      this.emd = paramInt2;
      this.userData = paramObject;
    }
    
    public int Np()
    {
      return this.command;
    }
    
    public int Nq()
    {
      return this.emd;
    }
    
    public Object U()
    {
      return this.userData;
    }
    
    public MessageMicro<?> a()
    {
      return this.d;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ashv
 * JD-Core Version:    0.7.0.1
 */