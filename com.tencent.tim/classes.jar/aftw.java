import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import org.json.JSONObject;

class aftw
  implements MiniAppCmdInterface
{
  aftw(aftv paramaftv, aftv.a parama) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject = paramJSONObject.opt("data");
      if ((paramJSONObject instanceof MiniAppRecommInfo))
      {
        aftv.a(this.this$0, (MiniAppRecommInfo)paramJSONObject);
        this.this$0.a(aftv.a(this.this$0));
        if (this.a != null) {
          this.a.a(true, aftv.a(this.this$0));
        }
      }
    }
    while (this.a == null) {
      return;
    }
    this.a.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aftw
 * JD-Core Version:    0.7.0.1
 */