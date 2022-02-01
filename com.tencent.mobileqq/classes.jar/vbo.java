import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.widgets.QCircleCertifiedDialogView;

public class vbo
  extends vbm
{
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private QCircleCertifiedDialogView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCertifiedDialogView;
  private vbe jdField_a_of_type_Vbe;
  private boolean jdField_a_of_type_Boolean;
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new vbp(this));
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCertifiedDialogView != null) {
        break label98;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCertifiedDialogView = new QCircleCertifiedDialogView(a());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCertifiedDialogView.setCertifiedListener(new vbq(this));
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCertifiedDialogView, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      return;
      label98:
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCertifiedDialogView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCertifiedDialogView.getParent()).removeView(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCertifiedDialogView);
      }
    }
  }
  
  private void a(String paramString)
  {
    uyx.a(a(), paramString, null, -1);
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCertifiedDialogView != null))
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCertifiedDialogView);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
  }
  
  public String a()
  {
    return "QCircleCertifiedPart";
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131373902));
    if (this.jdField_a_of_type_AndroidViewViewStub != null)
    {
      paramView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373925));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131373924));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    if ("tag_cetrified_part_show".equals(paramString)) {
      a();
    }
    while (!"tag_cetrified_part_show_gone".equals(paramString)) {
      return;
    }
    b();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbo
 * JD-Core Version:    0.7.0.1
 */