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

public class vny
  implements vlh<vlg>
{
  private final int jdField_a_of_type_Int = vpm.b(DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout), 40.0F);
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  
  private vny(DoodleLayout paramDoodleLayout) {}
  
  public boolean a(vlg paramvlg, MotionEvent paramMotionEvent)
  {
    if ((paramvlg instanceof vkm)) {
      localRect = new Rect();
    }
    for (Rect localRect = ((vkm)paramvlg).a(localRect);; localRect = null)
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
          paramvlg = this.jdField_a_of_type_AndroidGraphicsRect;
          paramvlg.top -= this.jdField_a_of_type_Int;
          paramvlg = this.jdField_a_of_type_AndroidGraphicsRect;
          paramvlg.bottom += this.jdField_a_of_type_Int;
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
          if (!(paramvlg instanceof vkm)) {
            break label661;
          }
          ved.b("DoodleLayout", "remove face.");
          ((vkm)paramvlg).b();
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
          if ((paramvlg instanceof vla))
          {
            ved.b("DoodleLayout", "editpic remove text.");
            paramvlg.a();
            paramvlg.b(false);
          }
          else if ((paramvlg instanceof vky))
          {
            paramMotionEvent = ((vky)paramvlg).a();
            if ((paramMotionEvent != null) && ((paramMotionEvent instanceof vlc)))
            {
              paramMotionEvent = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
              if (paramMotionEvent != null) {
                paramMotionEvent.a();
              }
            }
            ((vky)paramvlg).b();
          }
        }
      }
      if ((paramvlg instanceof vla))
      {
        ved.b("DoodleLayout", "remove text.");
        paramvlg.a();
        paramvlg.b(false);
      }
      for (;;)
      {
        DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, false);
        break;
        if ((paramvlg instanceof vkm))
        {
          ved.b("DoodleLayout", "remove face.");
          ((vkm)paramvlg).b();
        }
        else if ((paramvlg instanceof vky))
        {
          paramMotionEvent = ((vky)paramvlg).a();
          if ((paramMotionEvent != null) && ((paramMotionEvent instanceof vlc)))
          {
            paramMotionEvent = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
            if (paramMotionEvent != null) {
              paramMotionEvent.a();
            }
          }
          ((vky)paramvlg).b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vny
 * JD-Core Version:    0.7.0.1
 */