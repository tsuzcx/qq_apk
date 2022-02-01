import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.theme.ListenTogetherTheme.FloatViewSkin.3.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aogq
  implements aqqq
{
  aogq(aogn paramaogn) {}
  
  public void onCompleted(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = aqsp.a.getDir(paramQQAppInterface.getApp().getApplicationContext(), paramString1);
      if ((!TextUtils.isEmpty(paramQQAppInterface)) && (aogn.a(this.this$0) != null))
      {
        aogn.a(this.this$0, true);
        this.this$0.RP(paramQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.i("FloatViewSkin", 2, "onCompleted: mSkinRootPath" + this.this$0.ckF);
        }
        if (this.this$0.cLD) {
          ThreadManagerV2.getUIHandlerV2().post(new FloatViewSkin.3.1(this));
        }
      }
    }
  }
  
  public void onProgress(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aogq
 * JD-Core Version:    0.7.0.1
 */