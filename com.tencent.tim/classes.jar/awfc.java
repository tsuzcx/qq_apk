import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mm.opensdk.modelbase.BaseResp;

final class awfc
  implements awal.a
{
  public void a(BaseResp paramBaseResp)
  {
    if ((!TextUtils.isEmpty(awfb.bxh)) && (awfb.a != null)) {
      awfb.a.callJs(awfb.bxh, new String[] { String.valueOf(paramBaseResp.errCode) });
    }
    for (;;)
    {
      awfb.bxh = null;
      awfb.a = null;
      awal.a().b(this);
      return;
      switch (paramBaseResp.errCode)
      {
      case -2: 
      case -1: 
      default: 
        rwt.ez(1, 2131720152);
        break;
      case 0: 
        rwt.ez(2, 2131720175);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awfc
 * JD-Core Version:    0.7.0.1
 */