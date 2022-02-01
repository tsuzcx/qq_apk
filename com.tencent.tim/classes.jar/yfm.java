import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

class yfm
  extends acfd
{
  yfm(yfh paramyfh) {}
  
  protected void onGetFriendNickBatch(boolean paramBoolean, Object paramObject)
  {
    yfh.a(this.this$0).removeMessages(24);
    HashMap localHashMap;
    int i;
    if ((this.this$0.a == null) || (!this.this$0.a.isShowing()))
    {
      localHashMap = new HashMap();
      if ((!paramBoolean) && ((paramObject instanceof Integer))) {
        i = ((Integer)paramObject).intValue();
      }
    }
    for (;;)
    {
      localHashMap.put("result", i + "");
      localHashMap.put("netType", aqiw.getSystemNetwork(BaseApplication.getContext()) + "");
      anpc.a(BaseApplication.getContext()).collectPerformance(this.this$0.app.getCurrentAccountUin(), "multiMsgNickTimeoutR", false, 30000L, 0L, localHashMap, "");
      for (;;)
      {
        return;
        if (paramBoolean) {
          break label328;
        }
        i = 1;
        break;
        if (ajlc.a().djF != 2) {
          this.this$0.a.dismiss();
        }
        ajlc.a().lD.clear();
        if ((paramBoolean) && (paramObject != null)) {
          ajlc.a().lD.putAll((Map)paramObject);
        }
        if (ajlc.a().lD.size() == 0) {
          QQToast.a(this.this$0.app.getApp(), 2131700605, 0).show(this.this$0.getTitleBarHeight());
        }
        while (QLog.isDevelopLevel())
        {
          QLog.d(this.this$0.TAG, 4, "onGetFriendNickBatch = " + paramObject);
          return;
          if (paramObject != null) {
            ((wwb)yfh.a(this.this$0).a(1)).b((Map)paramObject, ajlc.a().xL, ajlc.a().djF);
          }
        }
      }
      label328:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yfm
 * JD-Core Version:    0.7.0.1
 */