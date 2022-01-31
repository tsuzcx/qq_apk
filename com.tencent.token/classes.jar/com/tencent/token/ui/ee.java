package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.widget.TextView;
import com.tencent.jni.FaceData;
import com.tencent.token.af;
import com.tencent.token.cx;
import com.tencent.token.ge;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.FaceView;
import com.tencent.token.utils.n;
import java.util.ArrayList;

final class ee
  extends bo
{
  ee(FacePKCameraActivity paramFacePKCameraActivity)
  {
    super(paramFacePKCameraActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    e.a("facepwd msg.what=" + paramMessage.what);
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
    case 2: 
    case 11: 
      do
      {
        do
        {
          do
          {
            return;
          } while (FacePKCameraActivity.access$000(this.a));
          FacePKCameraActivity.access$002(this.a, true);
          this.a.showUserDialog(2131361808, this.a.getResources().getString(2131362118), 2131361800, new ef(this), new eg(this));
          return;
          FacePKCameraActivity.access$100(this.a).c(3);
          FacePKCameraActivity.access$200(this.a).setText(2131361844);
          paramMessage = ((FaceData)paramMessage.obj).mUploadData;
        } while (paramMessage == null);
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramMessage);
        FacePKCameraActivity.access$302(this.a, ge.a((ArrayList)localObject));
        if (FacePKCameraActivity.access$300(this.a) == null) {
          break;
        }
      } while (FacePKCameraActivity.access$100(this.a).b() == 2);
      FacePKCameraActivity.access$402(this.a, true);
      if (FacePKCameraActivity.access$500(this.a))
      {
        n.a().a(FacePKCameraActivity.access$600(this.a), FacePKCameraActivity.access$600(this.a).b(), FacePKCameraActivity.access$700(this.a));
        return;
      }
      af.a().a(0L, FacePKCameraActivity.access$300(this.a), FacePKCameraActivity.access$700(this.a), null);
      return;
      e.a("OPTYPE_VALIDATION facepk serverData == null");
      return;
    case 100: 
      e.c("RECORD_ERROR");
      af.a().a(0L, FacePKCameraActivity.access$300(this.a), FacePKCameraActivity.access$700(this.a), null);
      return;
    case 90: 
      e.c("RECORD_END");
      n.a().c();
      af.a().a(0L, FacePKCameraActivity.access$300(this.a), FacePKCameraActivity.access$700(this.a), n.a().b());
      return;
    }
    if (paramMessage.arg1 == 0)
    {
      paramMessage = (cx)paramMessage.obj;
      localObject = new Intent(this.a, FacePKActivity.class);
      ((Intent)localObject).putExtra("help_url", paramMessage.a);
      ((Intent)localObject).putExtra("share_desc", paramMessage.c);
      ((Intent)localObject).putExtra("share_title", paramMessage.b);
      this.a.startActivity((Intent)localObject);
    }
    for (;;)
    {
      this.a.finish();
      return;
      paramMessage = (d)paramMessage.obj;
      if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
        d.a(this.a.getResources(), paramMessage);
      }
      this.a.showToast(paramMessage.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ee
 * JD-Core Version:    0.7.0.1
 */