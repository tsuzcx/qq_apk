import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;

public class aaly
  extends aalq
{
  public int mType;
  
  public aaly(Context paramContext, int paramInt)
  {
    this.mType = paramInt;
    if (paramInt == 0) {
      this.content = "";
    }
    while (paramInt != 1) {
      return;
    }
    this.content = acfp.m(2131716039);
  }
  
  public Object a(int paramInt, aozx paramaozx, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (((paramObject instanceof aaly)) && (((aaly)paramObject).mType == 0))
    {
      paramObject = (aaly)paramObject;
      paramObject.a.a(paramaozx.b);
      return paramObject;
    }
    paramObject = new aaly(BaseApplication.getContext(), 0);
    paramObject.a = new aozy(paramaozx.b);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaly
 * JD-Core Version:    0.7.0.1
 */