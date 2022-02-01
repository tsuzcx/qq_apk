import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.mode.CaptureModeController;

@TargetApi(18)
public class axqs
  extends axqo
{
  protected ImageView IC;
  private boolean dwh;
  protected aqju m;
  protected LinearLayout mu;
  
  public axqs(CaptureModeController paramCaptureModeController)
  {
    super(paramCaptureModeController);
    this.modeType = 1;
  }
  
  protected void YQ(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SegmentMode", 2, new Object[] { "handleSelectMode", Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void YR(boolean paramBoolean)
  {
    this.dwh = paramBoolean;
    if (paramBoolean)
    {
      ((PressDarkImageButton)this.IC).setEnableDark(true);
      this.IC.setImageAlpha(255);
      this.IC.postInvalidate();
      return;
    }
    ((PressDarkImageButton)this.IC).setEnableDark(false);
    this.IC.setImageAlpha(127);
    this.IC.postInvalidate();
  }
  
  public void eNY()
  {
    if (this.m == null) {
      this.m = aqha.a(this.jdField_b_of_type_DovComQqImCaptureModeCaptureModeController.getActivity(), 230).setMessage(this.jdField_b_of_type_DovComQqImCaptureModeCaptureModeController.getActivity().getString(2131700458)).setPositiveButton(this.jdField_b_of_type_DovComQqImCaptureModeCaptureModeController.getActivity().getString(2131721079), new axqu(this)).setNegativeButton(this.jdField_b_of_type_DovComQqImCaptureModeCaptureModeController.getActivity().getString(2131719403), new axqt(this));
    }
    try
    {
      if ((this.m != null) && (!this.m.isShowing())) {
        this.m.show();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SegmentMode", 2, "segment back dialog error:" + localThrowable);
    }
  }
  
  public void eNZ()
  {
    this.IC.setOnClickListener(new axqv(this));
  }
  
  public void jy(View paramView)
  {
    this.IC = ((ImageView)paramView.findViewById(2131364265));
    this.mu = ((LinearLayout)paramView.findViewById(2131364264));
    this.mu.setOnClickListener(this);
    this.IC.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_b_of_type_Awrq.aNt())
      {
        this.jdField_b_of_type_DovComQqImCaptureModeCaptureModeController.jdField_b_of_type_Awrq.eEZ();
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("SegmentMode", 2, "segment video error: jump to edit with no videos");
        continue;
        this.jdField_b_of_type_DovComQqImCaptureModeCaptureModeController.jdField_b_of_type_Awrq.eFb();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axqs
 * JD-Core Version:    0.7.0.1
 */