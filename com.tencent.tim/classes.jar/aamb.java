import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;

public class aamb
  extends aalq
{
  public aamb(Context paramContext)
  {
    this.content = acfp.m(2131700656);
    this.contentDescription = this.content;
  }
  
  public Object a(int paramInt, aozx paramaozx, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramObject instanceof aamb))
    {
      paramObject = (aamb)paramObject;
      paramObject.a.a(paramaozx.b);
      return paramObject;
    }
    paramObject = new aamb(BaseApplication.getContext());
    paramObject.a = new aozy(paramaozx.b);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aamb
 * JD-Core Version:    0.7.0.1
 */