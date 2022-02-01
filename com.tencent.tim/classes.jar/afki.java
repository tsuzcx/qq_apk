import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class afki
  extends afke.a
{
  afki(afke paramafke, acdz paramacdz, afkz paramafkz, Object paramObject)
  {
    super(paramafke, paramacdz);
  }
  
  public void a(boolean paramBoolean, int paramInt, EmoticonResp paramEmoticonResp)
  {
    if (this.gJ.get() == null) {
      return;
    }
    ??? = (acdz)this.gJ.get();
    int i = paramEmoticonResp.epId;
    int j = paramEmoticonResp.timestamp;
    Object localObject1 = (ArrayList)paramEmoticonResp.data;
    if ((this.a.bDO != null) && (this.a.bDO.equals(paramEmoticonResp.keySeq)))
    {
      ((acdz)???).b(this);
      this.a.bYL = paramBoolean;
      this.a.cRP = paramEmoticonResp.resultcode;
      this.a.timeoutReason = paramEmoticonResp.timeoutReason;
    }
    for (;;)
    {
      synchronized (this.val$obj)
      {
        this.val$obj.notify();
        if (!QLog.isColorLevel()) {
          break;
        }
        ??? = this.this$0.TAG;
        StringBuilder localStringBuilder = new StringBuilder().append("fetchEmoticonEncryptKeys|net get key backepId=").append(i).append(" tstamp=").append(j).append(" list.size=");
        if (localObject1 == null)
        {
          localObject1 = "null";
          QLog.d((String)???, 2, localObject1 + " encryptSuccess=" + paramBoolean + " type=" + paramInt + " er.resultCode=" + paramEmoticonResp.resultcode);
          return;
        }
      }
      localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afki
 * JD-Core Version:    0.7.0.1
 */