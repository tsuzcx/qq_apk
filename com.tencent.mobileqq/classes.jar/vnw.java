import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vnw
  extends vhl
{
  protected ProgressBar a;
  
  public vnw(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131372239));
  }
  
  private void i()
  {
    this.jdField_a_of_type_Aage = new aage(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_Aage.a(new vnx(this));
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.addTextChangedListener(new vny(this));
    }
  }
  
  protected int a()
  {
    return 2131560791;
  }
  
  protected void a(View paramView) {}
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(paramString);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onClick:" + paramView.getId());
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.d("QCircleBaseInputPopupWindow", 1, "text_input");
      continue;
      if (this.jdField_a_of_type_Vhp != null) {
        this.jdField_a_of_type_Vhp.a();
      }
    }
  }
  
  public void show()
  {
    super.show();
    i();
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.requestFocus();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnw
 * JD-Core Version:    0.7.0.1
 */