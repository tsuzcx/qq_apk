package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cw;
import com.tencent.token.do;
import com.tencent.token.fi;
import com.tencent.token.utils.i;
import java.util.ArrayList;

class he
  implements View.OnClickListener
{
  he(FaceRecognitionComfirmActivity paramFaceRecognitionComfirmActivity) {}
  
  public void onClick(View paramView)
  {
    i.b(FaceRecognitionComfirmActivity.access$200(this.a));
    if ((FaceRecognitionComfirmActivity.access$300(this.a) == 7) && (FaceRecognitionComfirmActivity.access$400(this.a) == 3))
    {
      FaceRecognitionComfirmActivity.access$000(this.a).setVisibility(0);
      paramView = new ArrayList();
      if (FaceRecognitionComfirmActivity.access$500(this.a) != null) {
        paramView.add(FaceRecognitionComfirmActivity.access$500(this.a));
      }
      FaceRecognitionComfirmActivity.access$602(this.a, fi.a(paramView));
      if ((FaceRecognitionComfirmActivity.access$600(this.a) != null) && (FaceRecognitionComfirmActivity.access$600(this.a).length > 100)) {
        if (do.a().e() == null) {
          break label198;
        }
      }
    }
    label198:
    for (long l = do.a().e().mRealUin;; l = 0L)
    {
      int i = FaceRecognitionCameraActivity.getLockStatus();
      cw.a().a(0L, l, 4, FaceRecognitionComfirmActivity.access$600(this.a), i, FaceRecognitionComfirmActivity.access$700(this.a), FaceRecognitionComfirmActivity.access$800(this.a), FaceRecognitionComfirmActivity.access$900(this.a));
      FaceRecognitionComfirmActivity.access$102(this.a, 4);
      return;
      this.a.setResult(20);
      this.a.finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.he
 * JD-Core Version:    0.7.0.1
 */