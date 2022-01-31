package com.tencent.token.ui;

import android.content.Intent;
import android.os.Message;
import android.widget.ProgressBar;
import com.tencent.token.core.bean.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;

class hb
  extends cb
{
  hb(FaceRecognitionComfirmActivity paramFaceRecognitionComfirmActivity)
  {
    super(paramFaceRecognitionComfirmActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    label159:
    do
    {
      do
      {
        do
        {
          return;
          FaceRecognitionComfirmActivity.access$000(this.a).setVisibility(8);
          h.c("K_MSG_POST_FACERECOGNITION = " + paramMessage.arg1);
          if (paramMessage.arg1 != 0) {
            break;
          }
        } while (paramMessage.arg2 != 4);
        paramMessage = new Intent(this.a, AddFaceResultActivity.class);
        paramMessage.putExtra("add_face_succ", true);
        paramMessage.addFlags(67108864);
        this.a.startActivity(paramMessage);
        this.a.finish();
        return;
        localObject = (f)paramMessage.obj;
        paramMessage = (c)((f)localObject).d;
      } while (paramMessage == null);
      i = FaceRecognitionComfirmActivity.access$100(this.a);
      try
      {
        int j = paramMessage.a();
        i = j;
      }
      catch (Exception localException)
      {
        break label159;
      }
      f.a(this.a.getResources(), (f)localObject);
      h.c("faceRe ret.mErrCode=" + ((f)localObject).a + "opType" + i);
    } while (i != 4);
    switch (((f)localObject).a)
    {
    case 222: 
    default: 
      this.a.setResult(20);
      this.a.finish();
      return;
    }
    h.c("canModifyFaceByRealname:-----" + paramMessage.b());
    Object localObject = new Intent(this.a, AddFaceResultActivity.class);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtra("add_face_succ", false);
    ((Intent)localObject).putExtra("can_modify_face", paramMessage.b());
    this.a.startActivity((Intent)localObject);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.hb
 * JD-Core Version:    0.7.0.1
 */