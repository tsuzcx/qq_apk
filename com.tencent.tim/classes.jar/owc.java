import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.widgets.QCircleCertifiedDialogView;

public class owc
  extends rxk
{
  private QCircleCertifiedDialogView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCertifiedDialogView;
  private owa jdField_a_of_type_Owa;
  private boolean ayO;
  private ImageView lH;
  private FrameLayout q;
  private ViewStub s;
  
  private void bhW()
  {
    if (this.q != null)
    {
      this.lH.setOnClickListener(new owd(this));
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCertifiedDialogView != null) {
        break label98;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCertifiedDialogView = new QCircleCertifiedDialogView(getContext());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCertifiedDialogView.setCertifiedListener(new owe(this));
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      this.q.addView(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCertifiedDialogView, localLayoutParams);
      this.q.setVisibility(0);
      return;
      label98:
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCertifiedDialogView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCertifiedDialogView.getParent()).removeView(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCertifiedDialogView);
      }
    }
  }
  
  private void bhX()
  {
    if ((this.q != null) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCertifiedDialogView != null))
    {
      this.q.removeView(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCertifiedDialogView);
      this.q.setVisibility(8);
    }
  }
  
  private void qq(String paramString)
  {
    oux.aX(getContext(), paramString);
    if (this.ayO) {
      bhX();
    }
  }
  
  protected void dC(View paramView)
  {
    super.dC(paramView);
    this.s = ((ViewStub)paramView.findViewById(2131374502));
    if (this.s != null)
    {
      paramView = this.s.inflate();
      this.lH = ((ImageView)paramView.findViewById(2131374514));
      this.q = ((FrameLayout)paramView.findViewById(2131374513));
      this.q.setVisibility(8);
    }
  }
  
  public String getLogTag()
  {
    return "QCircleCertifiedPart";
  }
  
  public void l(String paramString, Object paramObject)
  {
    super.l(paramString, paramObject);
    if ("tag_cetrified_part_show".equals(paramString)) {
      bhW();
    }
    while (!"tag_cetrified_part_show_gone".equals(paramString)) {
      return;
    }
    bhX();
  }
  
  public void rf(boolean paramBoolean)
  {
    this.ayO = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     owc
 * JD-Core Version:    0.7.0.1
 */