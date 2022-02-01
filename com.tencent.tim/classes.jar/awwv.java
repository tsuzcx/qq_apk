import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.view.AECompoundButton;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;

class awwv
  implements axzv<axfz>
{
  awwv(awwq paramawwq) {}
  
  public void a(@Nullable axfz paramaxfz)
  {
    if (paramaxfz == null) {}
    label61:
    label357:
    label381:
    do
    {
      return;
      paramaxfz = paramaxfz.g;
      awwq.a(this.this$0, paramaxfz);
      axiy.d("VideoStoryPiecesPart", "[GifAuthor]---checkShowGifAuthor when capture mode change");
      awwq.a(this.this$0);
      awwq.a(this.this$0).cox();
      if (paramaxfz == AECaptureMode.NORMAL)
      {
        awwq.a(this.this$0).XG(true);
        if (awwq.a(this.this$0) != null) {
          awwq.a(this.this$0).setCaptureMode(paramaxfz);
        }
        if (paramaxfz != AECaptureMode.NORMAL) {
          break label414;
        }
        awwq.a(this.this$0).setVisibility(0);
        if (awwq.a(this.this$0) != null)
        {
          if ((!axcg.aw(awwq.b(this.this$0).getIntent())) && (!axcg.ax(awwq.c(this.this$0).getIntent()))) {
            break label357;
          }
          awwq.a(this.this$0).setFunctionFlag(awwq.d(this.this$0).getIntent().getIntExtra("ability_flag", 2));
        }
      }
      for (;;)
      {
        awwq.a(this.this$0).setMaxDuration(awwq.QO());
        awwq.a(this.this$0).Yp(false);
        if (awwq.c(this.this$0)) {
          awwq.a(this.this$0).a(true, axjd.a);
        }
        awwq.a(this.this$0).ZR(false);
        if (awwq.c(this.this$0))
        {
          i = this.this$0.QN();
          if (i > 0)
          {
            paramaxfz = (ViewGroup.MarginLayoutParams)awwq.c(this.this$0).getLayoutParams();
            if (paramaxfz != null)
            {
              paramaxfz.bottomMargin = i;
              awwq.c(this.this$0).setLayoutParams(paramaxfz);
            }
          }
        }
        if (awwq.d(this.this$0)) {
          awwq.a(this.this$0).setVisibility(0);
        }
        awwq.a(this.this$0, 0);
        if (axcg.F(awwq.a(this.this$0).getActivity())) {
          break;
        }
        awwq.a(this.this$0).a().eGY();
        return;
        awwq.a(this.this$0).XG(false);
        break label61;
        if (!awwq.a(this.this$0)) {
          break label381;
        }
        awwq.a(this.this$0).setFunctionFlag(2);
      }
      paramaxfz = awwq.a(this.this$0);
      if (awwq.b(this.this$0)) {}
      for (int i = 1;; i = 3)
      {
        paramaxfz.setFunctionFlag(i);
        break;
      }
      if (paramaxfz == AECaptureMode.GIF)
      {
        awwq.a(this.this$0).setVisibility(0);
        awwq.a(this.this$0).setFunctionFlag(4);
        awwq.a(this.this$0).setMaxDuration(awwq.FS());
        awwq.a(this.this$0).Yp(true);
        awwq.a(this.this$0).ZR(true);
        if (awwq.d(this.this$0)) {
          awwq.a(this.this$0).setVisibility(0);
        }
        awwq.a(this.this$0).setVisibility(0);
        awwq.a(this.this$0).eIX();
        return;
      }
    } while (paramaxfz != AECaptureMode.PLAY);
    label414:
    awwq.a(this.this$0).setVisibility(8);
    awwq.a(this.this$0).setVisibility(8);
    awwq.a(this.this$0).setVisibility(8);
    awwq.a(this.this$0).setMaterial(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awwv
 * JD-Core Version:    0.7.0.1
 */