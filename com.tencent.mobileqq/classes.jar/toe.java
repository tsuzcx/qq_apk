import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.view.WSTabLayout;

public class toe
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public toe(WSTabLayout paramWSTabLayout, @NonNull View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380318));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380315));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new tof(this, paramWSTabLayout));
  }
  
  private String a(int paramInt)
  {
    if (paramInt > 99) {
      return "99+";
    }
    return paramInt + "";
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, WSTabLayout.c);
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    if ((paramBoolean) && (WSTabLayout.a(paramFloat, 0.0F))) {
      return;
    }
    float f1 = WSTabLayout.d;
    float f2 = WSTabLayout.c;
    float f3 = WSTabLayout.d;
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, f1 + (f2 - f3) * paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, WSTabLayout.d);
  }
  
  public void b(float paramFloat, boolean paramBoolean)
  {
    if ((paramBoolean) && (WSTabLayout.a(paramFloat, 0.0F))) {
      return;
    }
    float f1 = WSTabLayout.d;
    float f2 = WSTabLayout.c;
    float f3 = WSTabLayout.d;
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, f1 + (f2 - f3) * (1.0F - paramFloat));
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if (paramInt > 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      String str = a(paramInt);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     toe
 * JD-Core Version:    0.7.0.1
 */