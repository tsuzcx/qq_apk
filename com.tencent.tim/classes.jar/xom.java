import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SubscribeResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import mqq.observer.BusinessObserver;

class xom
  implements BusinessObserver
{
  xom(xol paramxol, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    for (;;)
    {
      int i;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          mobileqq_mp.SubscribeResponse localSubscribeResponse = new mobileqq_mp.SubscribeResponse();
          localSubscribeResponse.mergeFrom(paramBundle);
          paramInt = ((mobileqq_mp.RetInfo)localSubscribeResponse.ret_info.get()).ret_code.get();
          if (paramInt == 0)
          {
            i = 1;
            paramInt = 1;
          }
        }
      }
      catch (Exception paramBundle)
      {
        paramInt = 0;
      }
      try
      {
        StructingMsgItemBuilder.a(this.a.this$0, this.a.val$activity);
        anot.a(this.a.this$0.app, "dc00899", "Pb_account_lifeservice", "", "0X8006513", "0X8006513", 0, 0, "" + paramInt, "" + this.aVM, "", "");
        return;
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramInt = i;
        }
      }
      StructingMsgItemBuilder.b(this.a.this$0, this.a.val$activity);
      break label236;
      StructingMsgItemBuilder.b(this.a.this$0, this.a.val$activity);
      break label236;
      StructingMsgItemBuilder.b(this.a.this$0, this.a.val$activity);
      continue;
      StructingMsgItemBuilder.b(this.a.this$0, this.a.val$activity);
      label236:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xom
 * JD-Core Version:    0.7.0.1
 */