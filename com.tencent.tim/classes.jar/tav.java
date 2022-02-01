import com.tencent.gamecenter.activities.GameCenterActivity.GameCenterFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class tav
  implements tbl.b
{
  public tav(GameCenterActivity.GameCenterFragment paramGameCenterFragment, WebView paramWebView) {}
  
  public void onResponse(int paramInt, String paramString)
  {
    QLog.i("GameCenterFragment", 1, "addShot res code=" + paramInt);
    if (paramInt == 304) {
      tbl.a().e(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tav
 * JD-Core Version:    0.7.0.1
 */