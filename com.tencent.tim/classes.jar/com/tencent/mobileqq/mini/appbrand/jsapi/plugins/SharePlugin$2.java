package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import java.util.HashMap;

final class SharePlugin$2
  implements Runnable
{
  SharePlugin$2(int paramInt) {}
  
  public void run()
  {
    String str = null;
    if ((this.val$flag & 0x20) != 0) {
      str = (String)SharePlugin.access$000().get(Integer.valueOf(32));
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        QQToast.a(BaseApplicationImpl.getContext(), str, 1).show();
      }
      return;
      if ((this.val$flag & 0x10) != 0) {
        str = (String)SharePlugin.access$000().get(Integer.valueOf(16));
      } else if ((this.val$flag & 0x8) != 0) {
        str = (String)SharePlugin.access$000().get(Integer.valueOf(8));
      } else if ((this.val$flag & 0x4) != 0) {
        str = (String)SharePlugin.access$000().get(Integer.valueOf(4));
      } else if ((this.val$flag & 0x2) != 0) {
        str = (String)SharePlugin.access$000().get(Integer.valueOf(2));
      } else if ((this.val$flag & 0x1) != 0) {
        str = (String)SharePlugin.access$000().get(Integer.valueOf(1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.SharePlugin.2
 * JD-Core Version:    0.7.0.1
 */