import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.tim.dingdong.DingdongPluginRemoteCmdHandler;
import java.util.ArrayList;

public class atnp
  extends acdv
{
  public atnp(DingdongPluginRemoteCmdHandler paramDingdongPluginRemoteCmdHandler) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString)
  {
    Object localObject;
    if (DingdongPluginRemoteCmdHandler.a(this.this$0))
    {
      DingdongPluginRemoteCmdHandler.a(this.this$0, false);
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (!TextUtils.isEmpty(DingdongPluginRemoteCmdHandler.a(this.this$0))) {
        DingdongPluginRemoteCmdHandler.a(this.this$0, (QQAppInterface)localObject, DingdongPluginRemoteCmdHandler.a(this.this$0), paramLong);
      }
      if (localObject != null) {
        ((QQAppInterface)localObject).removeObserver(DingdongPluginRemoteCmdHandler.a(this.this$0));
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("reqCode", 5);
      ((Intent)localObject).putExtra("isSuccess", paramBoolean);
      ((Intent)localObject).putExtra("roomId", paramLong);
      ((Intent)localObject).putExtra("discussName", paramString);
      ((Intent)localObject).putExtra("discuss_create_reason", DingdongPluginRemoteCmdHandler.a(this.this$0));
      ((Intent)localObject).putExtra("createdFlag", 1);
      if (DingdongPluginRemoteCmdHandler.b(this.this$0) == 1) {
        atni.K(10, (Intent)localObject);
      }
    }
    else
    {
      return;
    }
    atni.K(2, (Intent)localObject);
  }
  
  protected void b(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if (DingdongPluginRemoteCmdHandler.a(this.this$0))
    {
      DingdongPluginRemoteCmdHandler.a(this.this$0, false);
      paramArrayList = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramArrayList != null) {
        paramArrayList.removeObserver(DingdongPluginRemoteCmdHandler.a(this.this$0));
      }
      paramArrayList = new Intent();
      paramArrayList.putExtra("reqCode", 7);
      paramArrayList.putExtra("isSuccess", paramBoolean);
      paramArrayList.putExtra("roomId", paramLong);
      if (DingdongPluginRemoteCmdHandler.b(this.this$0) == 1) {
        atni.K(11, paramArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atnp
 * JD-Core Version:    0.7.0.1
 */