import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class mje
  extends lce
{
  public mje(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void a(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    QLog.d("ReadInJoyDeliverUGCActivity", 1, "onDeliverUGCResult retCode=" + paramInt1 + ", feedsId=" + paramLong + ", rowkey=" + paramString1 + ", status=" + paramInt2 + ", comment=" + paramString2 + ", errorMsg: " + paramString3);
    ReadInJoyDeliverUGCActivity.f(this.this$0, true);
    if (ReadInJoyDeliverUGCActivity.a(this.this$0) != null) {
      ReadInJoyDeliverUGCActivity.a(this.this$0).removeCallbacksAndMessages(null);
    }
    this.this$0.aAt();
    ReadInJoyDeliverUGCActivity.c(this.this$0, paramInt1);
    if (paramInt1 == 0)
    {
      ReadInJoyDeliverUGCActivity.d(this.this$0, -1);
      ReadInJoyDeliverUGCActivity.g(this.this$0, true);
    }
    try
    {
      ReadInJoyDeliverUGCActivity.a(this.this$0).put("feedsId", String.valueOf(paramLong));
      ReadInJoyDeliverUGCActivity.a(this.this$0).put("rowkey", paramString1);
      ReadInJoyDeliverUGCActivity.a(this.this$0).put("status", paramInt2);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      ReadInJoyDeliverUGCActivity.a(this.this$0).put("comment", new String(aqgo.encode(paramString1.getBytes(), 0)));
      if (ReadInJoyDeliverUGCActivity.e(this.this$0) != 12) {
        break label435;
      }
      ReadInJoyDeliverUGCActivity.a(this.this$0).put("feedsType", 4);
    }
    catch (Exception paramString1)
    {
      label256:
      label277:
      label435:
      break label256;
    }
    if (ReadInJoyDeliverUGCActivity.e(this.this$0))
    {
      KandianSubscribeManager.P(this.this$0.getActivity(), 4);
      if (ReadInJoyDeliverUGCActivity.f(this.this$0)) {
        paramString1 = new JSONObject();
      }
    }
    for (;;)
    {
      try
      {
        if (!ReadInJoyDeliverUGCActivity.d(this.this$0)) {
          continue;
        }
        paramInt1 = 70;
        paramString1.put("channel_id", paramInt1);
        paramString1.put("rowkey", "0");
        paramString1.put("topicid", ReadInJoyDeliverUGCActivity.c(this.this$0));
      }
      catch (Exception paramString2)
      {
        paramString2.printStackTrace();
        continue;
      }
      kbp.a(null, "CliOper", "", "", "0X800982D", "0X800982D", 0, 0, paramLong + "", "1", "", paramString1.toString(), false);
      if (ReadInJoyDeliverUGCActivity.f(this.this$0) != -1L) {
        ReadInJoyDeliverUGCActivity.h(this.this$0).aQ(ReadInJoyDeliverUGCActivity.g(this.this$0));
      }
      ReadInJoyDeliverUGCActivity.d(this.this$0);
      this.this$0.finish();
      return;
      if (ReadInJoyDeliverUGCActivity.e(this.this$0) == 13)
      {
        ReadInJoyDeliverUGCActivity.a(this.this$0).put("feedsType", 5);
        break;
      }
      ReadInJoyDeliverUGCActivity.a(this.this$0).put("feedsType", 4);
      break;
      lbz.a().mY(true);
      break label277;
      paramInt1 = 0;
    }
    if (paramInt1 == 33)
    {
      ReadInJoyDeliverUGCActivity.a(this.this$0, 1, paramString3);
      return;
    }
    ReadInJoyDeliverUGCActivity.b(this.this$0, 1, paramString3);
    this.this$0.aCY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mje
 * JD-Core Version:    0.7.0.1
 */