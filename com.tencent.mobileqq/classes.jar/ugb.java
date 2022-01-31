import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import friendlist.GetOnlineInfoResp;

class ugb
  extends ajjh
{
  ugb(uga paramuga) {}
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((!paramBoolean) || (this.a.a == null) || (paramGetOnlineInfoResp == null) || (!TextUtils.equals(paramString, this.a.a.qq))) {}
    while (uga.a(this.a) == null) {
      return;
    }
    paramString = uga.a(this.a);
    if (paramGetOnlineInfoResp.eIconType == 11) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString.b(paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ugb
 * JD-Core Version:    0.7.0.1
 */