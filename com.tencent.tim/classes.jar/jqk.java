import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;

public class jqk
  extends achq
{
  protected void a(boolean paramBoolean, OpenID paramOpenID) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    QLog.d("openid", 2, "isSuccess=" + paramBoolean + ",data=" + paramObject);
    a(paramBoolean, (OpenID)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jqk
 * JD-Core Version:    0.7.0.1
 */