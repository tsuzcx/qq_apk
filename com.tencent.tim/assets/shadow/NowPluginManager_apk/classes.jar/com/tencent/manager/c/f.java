package com.tencent.manager.c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

public class f
{
  public static void a(Context paramContext, Bundle paramBundle)
  {
    long l = b.a(paramBundle);
    Object localObject1 = b.g(paramBundle);
    Object localObject2 = b.c(paramBundle);
    int i;
    String str1;
    if (b.d(paramBundle))
    {
      i = 1;
      str1 = b.i(paramBundle);
      com.tencent.util.e.a.a("NowAppelper", "已安装独立版，开始跳转独立版,is_record = is_record enter_record_if_finish = " + i + " nowapp_param = " + str1);
      if (!((String)localObject2).equals("1")) {
        break label198;
      }
      localObject1 = "tnow://openpage/record?" + str1;
    }
    for (;;)
    {
      com.tencent.util.e.a.a("NowAppHelper", "开始跳转独立版 nowScheme = " + (String)localObject1);
      localObject2 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject1));
      if (paramBundle != null) {
        ((Intent)localObject2).putExtras(paramBundle);
      }
      ((Intent)localObject2).setFlags(268435456);
      paramContext.startActivity((Intent)localObject2);
      paramContext = new Bundle();
      paramContext.putString("op_name", "jump_app");
      paramContext.putString("d1", (String)localObject1);
      com.tencent.util.g.a.a(paramContext);
      return;
      i = 0;
      break;
      label198:
      localObject2 = b.b(paramBundle);
      String str2 = b.e(paramBundle);
      localObject2 = "tnow://openpage/enterroom?roomid=" + l + "&roomtype=" + (String)localObject2 + "&fromid=" + (String)localObject1 + "&startsrc=" + str2 + "&enter_record_if_finish=" + i;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(str1)) {
        localObject1 = (String)localObject2 + "&" + str1;
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    return a.b(paramContext, "com.tencent.now");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.manager.c.f
 * JD-Core Version:    0.7.0.1
 */