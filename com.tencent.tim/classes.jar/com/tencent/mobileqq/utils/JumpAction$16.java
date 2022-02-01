package com.tencent.mobileqq.utils;

import ahlw;
import android.text.TextUtils;
import aqgo;
import aqhq;
import aqhv;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class JumpAction$16
  implements Runnable
{
  public JumpAction$16(aqhv paramaqhv, String paramString, long paramLong, HashMap paramHashMap) {}
  
  public void run()
  {
    localObject = null;
    try
    {
      str = aqhq.l(this.this$0.context, this.ctw, "opensdk_tmp");
      localObject = str;
    }
    catch (SecurityException localSecurityException)
    {
      try
      {
        String str = new String(aqgo.encode(localObject.getBytes("UTF-8"), 0));
        this.this$0.attrs.put("file_data", str);
        long l = System.currentTimeMillis() - this.asJ;
        ahlw.a("KEY_STAGE_1_SAVE_IMAGE", l, this.oS, true);
        QLog.i("JumpAction", 1, "gotoShareMsgCheck save file to:" + localObject + ",cost=" + l);
        aqhv.k(this.this$0);
        if ((this.this$0.cUe) || (MiniProgramOpenSdkUtil.isSharingMiniProgram(this.this$0.attrs)) || (!(this.this$0.context instanceof JumpActivity))) {
          break label175;
        }
        ((JumpActivity)this.this$0.context).finish();
        return;
        localSecurityException = localSecurityException;
        QLog.i("JumpAction", 2, "gotoShareMsgCheck put exception:", localSecurityException);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          QLog.i("JumpAction", 1, "gotoShareMsgCheck put exception:", localUnsupportedEncodingException);
        }
      }
    }
    if (TextUtils.isEmpty(localObject)) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpAction.16
 * JD-Core Version:    0.7.0.1
 */