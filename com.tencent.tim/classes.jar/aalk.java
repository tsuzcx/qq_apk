import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;

public class aalk
  extends aalq
{
  public aalk(Context paramContext, String paramString)
  {
    Aw(paramString);
  }
  
  public void Aw(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = "";; paramString = '[' + paramString + ']')
    {
      this.content = paramString;
      this.contentDescription = this.content;
      return;
    }
  }
  
  public Object a(int paramInt, aozx paramaozx, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = null;
    if ((paramMessageRecord instanceof MessageForArkApp)) {
      paramQQAppInterface = adrm.b((MessageForArkApp)paramMessageRecord);
    }
    if ((paramObject instanceof aalk))
    {
      paramObject = (aalk)paramObject;
      if (paramQQAppInterface != null) {
        paramObject.Aw(paramQQAppInterface);
      }
      paramObject.a.a(paramaozx.b);
      return paramObject;
    }
    paramObject = BaseApplication.getContext();
    if (paramQQAppInterface != null) {}
    for (;;)
    {
      paramObject = new aalk(paramObject, paramQQAppInterface);
      paramObject.a = new aozy(paramaozx.b);
      return paramObject;
      paramQQAppInterface = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aalk
 * JD-Core Version:    0.7.0.1
 */