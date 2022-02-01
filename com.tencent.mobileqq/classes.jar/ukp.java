import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ukp
  extends zhc
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public ukp(Context paramContext)
  {
    this(paramContext, 2131755172);
  }
  
  protected ukp(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    b();
  }
  
  private void b()
  {
    setContentView(2131560004);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131381220));
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131381183);
    TextView localTextView = (TextView)findViewById(2131381213);
    localFrameLayout.setOnClickListener(this);
    localTextView.setOnClickListener(this);
  }
  
  private void c()
  {
    if (isShowing()) {
      dismiss();
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
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
      uvm.c();
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukp
 * JD-Core Version:    0.7.0.1
 */