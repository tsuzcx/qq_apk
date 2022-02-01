import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import friendlist.GetOnlineInfoResp;

class xzh
  extends anvi
{
  xzh(xzg paramxzg) {}
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((!paramBoolean) || (this.a.a == null) || (paramGetOnlineInfoResp == null) || (!TextUtils.equals(paramString, this.a.a.qq))) {}
    while (xzg.a(this.a) == null) {
      return;
    }
    paramString = xzg.a(this.a);
    if (paramGetOnlineInfoResp.eIconType == 11) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString.b(paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzh
 * JD-Core Version:    0.7.0.1
 */