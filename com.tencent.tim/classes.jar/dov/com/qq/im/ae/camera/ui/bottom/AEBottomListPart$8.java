package dov.com.qq.im.ae.camera.ui.bottom;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import awtq;
import awxq;
import awxv;
import axbr;
import axbu;
import axim;
import axip;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.mode.AECaptureMode;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

public class AEBottomListPart$8
  implements Runnable
{
  public AEBottomListPart$8(awxv paramawxv, List paramList, long paramLong) {}
  
  public void run()
  {
    String str1 = null;
    int k = 0;
    int j = 1;
    axbu localaxbu;
    Object localObject2;
    String str2;
    if ((awxv.a(this.this$0) != null) && (!awxv.b(this.this$0).isFinishing()))
    {
      if (awxv.b(this.this$0)) {
        awxv.a(this.this$0).setVisibility(0);
      }
      awxv.a(this.this$0).oA(this.Md);
      localaxbu = axbr.b();
      if ((awxv.c(this.this$0) == null) || (awxv.d(this.this$0).isFinishing())) {
        break label653;
      }
      localObject2 = awxv.e(this.this$0).getIntent();
      str2 = ((Intent)localObject2).getStringExtra("KEY_CURRENT_SELECT_ID");
      localObject2 = ((Intent)localObject2).getStringExtra("KEY_CURRENT_TAB");
      if (!"null".equalsIgnoreCase(str2)) {
        break label646;
      }
    }
    for (;;)
    {
      int i;
      if (localObject2 != null)
      {
        i = k;
        if (!((String)localObject2).equals(AECaptureMode.NORMAL.name)) {}
      }
      else
      {
        if (str1 == null) {
          break label602;
        }
        if (str1.startsWith("http")) {
          try
          {
            localObject2 = new Intent(awxv.a(this.this$0).getActivity(), QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", URLDecoder.decode(str1, "UTF-8"));
            ((Intent)localObject2).putExtra("loc_play_show_material_id", str1);
            awxv.a(this.this$0).getActivity().startActivity((Intent)localObject2);
            awxv.f(this.this$0).getIntent().removeExtra("KEY_CURRENT_SELECT_ID");
            return;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            localUnsupportedEncodingException.printStackTrace();
            return;
          }
        }
        axip.a().acU("-1");
        i = awxv.a(this.this$0, localUnsupportedEncodingException);
        if (i == -1) {
          break label473;
        }
        awxv.g(this.this$0).getIntent().putExtra("widgetinfo", "camera^" + localUnsupportedEncodingException);
        localObject1 = awxv.a(this.this$0, i);
        if (localObject1 != null)
        {
          axim.a().acK(((axbu)localObject1).id);
          ((axbu)localObject1).dtW = true;
          awxv.h(this.this$0).getIntent().putExtra("key_camera_material_name", ((axbu)localObject1).cTC);
        }
      }
      for (;;)
      {
        long l = 0L;
        if (QLog.isDevelopLevel())
        {
          l = System.currentTimeMillis();
          QLog.d("AEWaterMarkListPart", 4, "foundInitPosition cost=" + (l - this.aBH));
        }
        if (i < awxv.a(this.this$0).getItemCount()) {
          awxv.a(this.this$0).scrollToPosition(i);
        }
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("AEWaterMarkListPart", 4, "hot data is real, updatePackage, cost=" + (System.currentTimeMillis() - l));
        return;
        label473:
        localObject2 = awxv.a(this.this$0);
        if ((awxv.a(this.this$0) != null) && (awxv.a(this.this$0).apb())) {}
        for (boolean bool = true;; bool = false)
        {
          localObject1 = ((axbr)localObject2).a((String)localObject1, bool);
          if (localObject1 == null) {
            break label564;
          }
          awxv.a(this.this$0).c((axbu)localObject1);
          axim.a().acK(((axbu)localObject1).id);
          ((axbu)localObject1).dtW = true;
          i = j;
          break;
        }
        label564:
        if (awxv.a(this.this$0) == AECaptureMode.NORMAL) {
          Toast.makeText(awxv.a(this.this$0).getActivity(), 2131689939, 1).show();
        }
        i = 0;
        continue;
        label602:
        i = k;
        if (localaxbu != null)
        {
          j = awxv.a(this.this$0, localaxbu.id);
          i = j;
          if (j == -1)
          {
            awxv.a(this.this$0).c(localaxbu);
            i = 1;
          }
        }
      }
      label646:
      Object localObject1 = str2;
      continue;
      label653:
      localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.8
 * JD-Core Version:    0.7.0.1
 */