import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.theme.effect.QEffectApngImageView;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.QEffectView;

public class wwl
  implements wvs
{
  private long IG;
  private QEffectView a;
  private BaseChatPie c;
  
  public wwl(BaseChatPie paramBaseChatPie)
  {
    this.c = paramBaseChatPie;
  }
  
  public int[] C()
  {
    return new int[] { 3, 13, 14, 15, 16 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
    case 13: 
      do
      {
        return;
      } while (this.a == null);
      StringBuilder localStringBuilder = new StringBuilder().append("destroy qeffect, duration:");
      if (this.IG == 0L) {}
      for (long l = this.IG;; l = System.currentTimeMillis() - this.IG)
      {
        QLog.i("QEffectBgProvider", 1, l);
        if (this.a.getQEffectImpl() != null) {
          ((View)this.a.getQEffectImpl()).destroyDrawingCache();
        }
        this.a.clear();
        return;
      }
    case 14: 
      pause();
      return;
    }
    resume();
  }
  
  public void d(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    String str1;
    if ((paramSessionInfo != null) && (paramSessionInfo.a != null))
    {
      str1 = paramSessionInfo.aTl;
      if (this.a == null)
      {
        this.a = new QEffectView(paramContext);
        this.c.cL.addView(this.a, 0, new ViewGroup.LayoutParams(-1, -1));
      }
      if (paramSessionInfo.a.img == null) {
        break label335;
      }
      if ((paramSessionInfo.a.img instanceof afeh)) {
        paramSessionInfo = "aio-bg-static";
      }
    }
    for (;;)
    {
      this.a.setExtOptions(2, QEffectApngImageView.a(new int[] { 0 }, "-chatBg-"));
      String str2 = paramQQAppInterface.getCurrentUin();
      int i = ChatBackgroundManager.e(paramContext, str2, str1);
      if ((i > 0) && (ChatBackgroundManager.aqr()))
      {
        ((aqrc)paramQQAppInterface.getManager(235)).a.a(i, new wwm(this, i));
        paramSessionInfo = paramSessionInfo + "-effect";
        label181:
        QAPM.setAbFactor("AIO背景", paramSessionInfo, txd.class);
      }
      do
      {
        return;
        if (!(paramSessionInfo.a.img instanceof URLDrawable)) {
          break label335;
        }
        paramSessionInfo = "aio-bg-dynamic";
        break;
        if ((ChatBackgroundManager.i(paramContext, str2, str1)) && (ChatBackgroundManager.aqr()))
        {
          paramContext = wkj.g(paramContext, str2, str1);
          this.IG = System.currentTimeMillis();
          this.a.setSrc(paramContext.replace("aioImage", ""), "zip");
          QLog.i("QEffectBgProvider", 1, "set qeffect for custom background aioImageID:" + ChatBackgroundManager.lS(paramContext));
          paramSessionInfo = paramSessionInfo + "-3d";
          break label181;
        }
        this.a.clear();
        break label181;
      } while (this.a == null);
      this.a.clear();
      return;
      label335:
      paramSessionInfo = "aio-bg-default";
    }
  }
  
  public void pause()
  {
    if (this.a != null) {
      this.a.pause();
    }
  }
  
  public void resume()
  {
    if (this.a != null) {
      this.a.resume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wwl
 * JD-Core Version:    0.7.0.1
 */