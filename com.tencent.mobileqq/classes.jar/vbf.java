import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.TextFaceLayerTouchListener.1;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class vbf
  implements uyo<uyn>
{
  private final int jdField_a_of_type_Int = vct.a(DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout), 40.0F);
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  
  private vbf(DoodleLayout paramDoodleLayout) {}
  
  public boolean a(uyn paramuyn, MotionEvent paramMotionEvent)
  {
    if ((paramuyn instanceof uxt)) {
      localRect = new Rect();
    }
    for (Rect localRect = ((uxt)paramuyn).a(localRect);; localRect = null)
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int i = (int)Math.abs(f2 - DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout));
      int j;
      int k;
      int m;
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 3: 
      case 4: 
      default: 
      case 0: 
      case 2: 
      case 5: 
      case 6: 
        do
        {
          return false;
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidWidgetRelativeLayout });
          this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
          paramuyn = this.jdField_a_of_type_AndroidGraphicsRect;
          paramuyn.top -= this.jdField_a_of_type_Int;
          paramuyn = this.jdField_a_of_type_AndroidGraphicsRect;
          paramuyn.bottom += this.jdField_a_of_type_Int;
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getGlobalVisibleRect(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect);
          DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, (int)f2);
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new DoodleLayout.TextFaceLayerTouchListener.1(this), 200L);
          return false;
        } while (i <= DoodleLayout.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout));
        if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a()) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e()) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 12))
        {
          i = (int)f1;
          j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.left;
          k = (int)f2;
          m = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.top;
          if ((this.jdField_a_of_type_AndroidGraphicsRect.contains(i + j, k + m)) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(f1, f2, localRect)))
          {
            DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, true);
            return false;
          }
          DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, false);
          return false;
        }
        if ((paramMotionEvent.getPointerCount() == 1) && (this.jdField_a_of_type_AndroidGraphicsRect.contains((int)f1, (int)f2)))
        {
          DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, true);
          return false;
        }
        DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, false);
        return false;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      if ((this.jdField_a_of_type_AndroidGraphicsRect != null) && ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a()) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e()) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 12)))
      {
        i = (int)f1;
        j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.left;
        k = (int)f2;
        m = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.top;
        if ((DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout)) && ((this.jdField_a_of_type_AndroidGraphicsRect.contains(i + j, k + m)) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(f1, f2, localRect))))
        {
          if (!(paramuyn instanceof uxt)) {
            break label661;
          }
          urk.b("DoodleLayout", "remove face.");
          ((uxt)paramuyn).b();
          DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, false);
        }
      }
      label661:
      while ((paramMotionEvent.getPointerCount() != 1) || (this.jdField_a_of_type_AndroidGraphicsRect == null) || (!this.jdField_a_of_type_AndroidGraphicsRect.contains((int)f1, (int)f2))) {
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.f();
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.d(0);
          return false;
          if ((paramuyn instanceof uyh))
          {
            urk.b("DoodleLayout", "editpic remove text.");
            paramuyn.a();
            paramuyn.b(false);
          }
          else if ((paramuyn instanceof uyf))
          {
            paramMotionEvent = ((uyf)paramuyn).a();
            if ((paramMotionEvent != null) && ((paramMotionEvent instanceof uyj)))
            {
              paramMotionEvent = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
              if (paramMotionEvent != null) {
                paramMotionEvent.a();
              }
            }
            ((uyf)paramuyn).b();
          }
        }
      }
      if ((paramuyn instanceof uyh))
      {
        urk.b("DoodleLayout", "remove text.");
        paramuyn.a();
        paramuyn.b(false);
      }
      for (;;)
      {
        DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, false);
        break;
        if ((paramuyn instanceof uxt))
        {
          urk.b("DoodleLayout", "remove face.");
          ((uxt)paramuyn).b();
        }
        else if ((paramuyn instanceof uyf))
        {
          paramMotionEvent = ((uyf)paramuyn).a();
          if ((paramMotionEvent != null) && ((paramMotionEvent instanceof uyj)))
          {
            paramMotionEvent = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
            if (paramMotionEvent != null) {
              paramMotionEvent.a();
            }
          }
          ((uyf)paramuyn).b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vbf
 * JD-Core Version:    0.7.0.1
 */