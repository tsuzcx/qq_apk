package cooperation.comic;

import avcv;
import aveb;
import aveb.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class VipComicJumpActivity$2
  extends VipComicJumpActivity.PluginCheckJob
{
  VipComicJumpActivity$2(VipComicJumpActivity paramVipComicJumpActivity, QQAppInterface paramQQAppInterface, VipComicJumpActivity.b paramb)
  {
    super(paramQQAppInterface);
  }
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.mAppRef.get();
    if (localQQAppInterface == null) {
      return;
    }
    if (aveb.p(localQQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "plugin is installed.");
      }
      this.this$0.b(this.b);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "wait for plugin installation...");
    }
    aveb.b localb = new aveb.b();
    localb.a = new VipComicJumpActivity.c(this.this$0.a);
    avcv.n(2, localQQAppInterface);
    boolean bool = aveb.a(localQQAppInterface, true, localb);
    this.this$0.downloadTime = localb.azu;
    this.this$0.installTime = localb.awO;
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "plugin install failed.");
      }
      this.this$0.a(this.b, localb.mErrCode);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "plugin is installed now.");
    }
    this.this$0.b(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.comic.VipComicJumpActivity.2
 * JD-Core Version:    0.7.0.1
 */