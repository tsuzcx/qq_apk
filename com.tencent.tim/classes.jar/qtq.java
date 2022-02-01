import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import friendlist.GetOnlineInfoResp;

class qtq
  extends acfd
{
  qtq(qtp paramqtp) {}
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((!paramBoolean) || (this.a.mUserUIItem == null) || (paramGetOnlineInfoResp == null) || (!TextUtils.equals(paramString, this.a.mUserUIItem.qq))) {}
    while (qtp.a(this.a) == null) {
      return;
    }
    paramString = qtp.a(this.a);
    if (paramGetOnlineInfoResp.eIconType == 11) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString.tp(paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qtq
 * JD-Core Version:    0.7.0.1
 */