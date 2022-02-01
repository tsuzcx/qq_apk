import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.theme.ListenTogetherTheme.FloatViewSkin.2.1;
import com.tencent.qphone.base.util.QLog;

public class aogp
  extends aqrd
{
  aogp(aogn paramaogn) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramInt == 36) && ((paramObject instanceof Integer)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FloatViewSkin", 2, "mMusicBusinessObserver: isSuccess" + paramBoolean + "  music player id:" + paramObject);
      }
      paramInt = ((Integer)paramObject).intValue();
      aogn.a(this.this$0, paramInt);
      if (paramInt > 0)
      {
        this.this$0.cLD = true;
        aqsp.a.download(null, aogn.a(this.this$0), aogn.a(this.this$0), false);
      }
    }
    else
    {
      return;
    }
    this.this$0.cLD = false;
    ThreadManagerV2.getUIHandlerV2().post(new FloatViewSkin.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aogp
 * JD-Core Version:    0.7.0.1
 */