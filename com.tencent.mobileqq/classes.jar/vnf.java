import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.image.NativeVideoImage;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import mqq.os.MqqHandler;

public class vnf
  extends MqqHandler
{
  public vnf(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 10001: 
    case 10000: 
    case 10002: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                QQToast.a(AIOGalleryScene.d(this.a), 2131437361, 0).a();
                return;
                String str = AIOGalleryScene.e(this.a).getString(2131437362);
                paramMessage = (String)paramMessage.obj;
                QQToast.a(AIOGalleryScene.f(this.a), 2, str + paramMessage, 0).a();
                ImageUtil.a(AIOGalleryScene.g(this.a), paramMessage);
                return;
              } while (paramMessage.obj == null);
              paramMessage = new File((String)paramMessage.obj);
            } while (!paramMessage.exists());
            paramMessage = DialogUtil.b(AIOGalleryScene.h(this.a), 232, AIOGalleryScene.i(this.a).getResources().getString(2131437389), AIOGalleryScene.j(this.a).getResources().getString(2131437390), 2131437391, 2131434587, new vng(this, paramMessage), new vnh(this));
            try
            {
              paramMessage.show();
              return;
            }
            catch (Throwable paramMessage)
            {
              return;
            }
          } while (paramMessage.arg1 != AIOGalleryScene.a(this.a));
          this.a.w();
          QQToast.a(AIOGalleryScene.k(this.a), 1, "保存失败", 0).a();
          NativeVideoImage.resumeAll();
          AIOGalleryScene.a(this.a);
          return;
        } while (paramMessage.arg1 != AIOGalleryScene.a(this.a));
        this.a.o = true;
        this.a.d(100);
        sendEmptyMessageDelayed(10003, 200L);
        return;
      } while ((paramMessage.arg1 != AIOGalleryScene.a(this.a)) || (paramMessage.arg2 <= 0));
      this.a.i = paramMessage.arg2;
      return;
    }
    this.a.w();
    QQToast.a(AIOGalleryScene.l(this.a), 2, "已保存到系统相册", 0).a();
    NativeVideoImage.resumeAll();
    AIOGalleryScene.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vnf
 * JD-Core Version:    0.7.0.1
 */