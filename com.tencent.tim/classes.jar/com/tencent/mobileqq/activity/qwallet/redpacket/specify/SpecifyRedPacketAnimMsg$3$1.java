package com.tencent.mobileqq.activity.qwallet.redpacket.specify;

import aafi;
import aafk;
import aafl;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import anyo.a;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;

public class SpecifyRedPacketAnimMsg$3$1
  implements Runnable
{
  public SpecifyRedPacketAnimMsg$3$1(aafk paramaafk, PreloadManager.PathResult paramPathResult) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SpecifyRedPacketAnimMsg", 2, "showAnim start playVideo");
    }
    Object localObject;
    try
    {
      if (aafi.a(this.a.this$0)) {
        return;
      }
      localObject = (MessageForQQWalletMsg)this.a.eQ.get();
      if (localObject == null)
      {
        this.a.c.byj();
        return;
      }
    }
    catch (Throwable localThrowable1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SpecifyRedPacketAnimMsg", 2, "showAnim start playVideo err:" + localThrowable1.getMessage());
      }
      this.a.c.byj();
      return;
    }
    String str = new File(this.val$pathRes.folderPath, "video.mp4").getAbsolutePath();
    if (!new File(str).exists())
    {
      this.a.c.byj();
      return;
    }
    BaseChatPie localBaseChatPie = (BaseChatPie)this.a.eR.get();
    if ((localBaseChatPie == null) || (localBaseChatPie.vn() != 4) || (localBaseChatPie.a() == null) || (localBaseChatPie.a().isFinishing()))
    {
      this.a.c.byj();
      return;
    }
    BaseActivity localBaseActivity = localBaseChatPie.a();
    this.a.this$0.b = new SpecifyGiftView(localBaseActivity, (MessageForQQWalletMsg)localObject);
    if (Build.VERSION.SDK_INT >= 19) {}
    for (int i = 67108872;; i = 8)
    {
      localObject = new WindowManager.LayoutParams(-1, -2, 2, i, -2);
      ((WindowManager.LayoutParams)localObject).gravity = 49;
      View localView = localBaseActivity.findViewById(2131377361);
      int[] arrayOfInt = new int[2];
      localView.getLocationOnScreen(arrayOfInt);
      if (ImmersiveUtils.hasNotchInScreen(localBaseActivity)) {
        ((WindowManager.LayoutParams)localObject).y = localBaseChatPie.getTitleBarHeight();
      }
      for (;;)
      {
        this.a.this$0.mWindowManager = ((WindowManager)localBaseActivity.getSystemService("window"));
        try
        {
          this.a.this$0.mWindowManager.removeViewImmediate(this.a.this$0.b);
          label356:
          this.a.this$0.mWindowManager.addView(this.a.this$0.b, (ViewGroup.LayoutParams)localObject);
          this.a.this$0.b.a(str, this.a.c, new aafl(this));
          return;
          ((WindowManager.LayoutParams)localObject).y = (arrayOfInt[1] + localBaseChatPie.getTitleBarHeight());
        }
        catch (Throwable localThrowable2)
        {
          break label356;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.specify.SpecifyRedPacketAnimMsg.3.1
 * JD-Core Version:    0.7.0.1
 */