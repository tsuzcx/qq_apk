import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class afpw
  implements ajdq<EmoticonPackage>
{
  afpw(afpu paramafpu, QQAppInterface paramQQAppInterface, int paramInt, Context paramContext, SessionInfo paramSessionInfo) {}
  
  public void c(EmoticonPackage paramEmoticonPackage)
  {
    int i = aixo.dr(this.e.e.magicValue);
    if ((-1 != i) && (paramEmoticonPackage != null))
    {
      paramEmoticonPackage.rscType = i;
      ((ajdg)this.val$app.getManager(14)).m(paramEmoticonPackage);
    }
    paramEmoticonPackage = "rscType?" + i + ";value=" + this.YJ;
    this.e.e.magicValue = paramEmoticonPackage;
    if (QLog.isColorLevel()) {
      QLog.d("PicEmoticonInfo", 2, "before play,magicvalue:" + paramEmoticonPackage);
    }
    aixt localaixt = aiyh.a(this.e.e, 0);
    if ((localaixt != null) && (!localaixt.isAutoPlay))
    {
      ujt.a(this.val$app, this.val$context, this.a, this.e.e);
      return;
    }
    ((FragmentActivity)this.val$context).getChatFragment().a().a().a(this.e.e, new afpx(this, paramEmoticonPackage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afpw
 * JD-Core Version:    0.7.0.1
 */