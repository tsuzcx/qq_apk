import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoWebPreDownload.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;

public class mzm
  implements kxv.a
{
  mzm(mzl parammzl, String paramString, int paramInt, long paramLong) {}
  
  public void b(kxz paramkxz)
  {
    if ((TextUtils.isEmpty(paramkxz.url)) || (TextUtils.isEmpty(paramkxz.vid)) || (!paramkxz.vid.equals(this.akW)))
    {
      if ((TextUtils.isEmpty(paramkxz.url)) && (mzl.a(this.this$0) != null))
      {
        String str = (String)mzl.a(this.this$0).get(paramkxz.vid);
        if (!TextUtils.isEmpty(str)) {
          mzl.a(this.this$0).r(paramkxz.vid, -1, str);
        }
      }
      return;
    }
    ThreadManager.post(new VideoWebPreDownload.2.1(this, paramkxz), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mzm
 * JD-Core Version:    0.7.0.1
 */