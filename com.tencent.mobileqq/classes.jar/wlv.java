import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import friendlist.GetOnlineInfoResp;

class wlv
  extends altm
{
  wlv(wlu paramwlu) {}
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((!paramBoolean) || (this.a.a == null) || (paramGetOnlineInfoResp == null) || (!TextUtils.equals(paramString, this.a.a.qq))) {}
    while (wlu.a(this.a) == null) {
      return;
    }
    paramString = wlu.a(this.a);
    if (paramGetOnlineInfoResp.eIconType == 11) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString.b(paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wlv
 * JD-Core Version:    0.7.0.1
 */