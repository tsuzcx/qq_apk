import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.theme.ThemeUtil;

public class xkx
  extends xku
{
  private boolean c;
  
  public xkx(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext, paramString, paramInt);
  }
  
  public int a()
  {
    return 1;
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561524, null);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt, View paramView)
  {
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131364034);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131364029);
    TextView localTextView = (TextView)paramView.findViewById(2131364031);
    paramView = paramView.findViewById(2131364025);
    localTextView.setText(this.jdField_a_of_type_JavaLangString);
    switch (this.jdField_a_of_type_Int)
    {
    case 10002: 
    case 10003: 
    default: 
      if (this.jdField_a_of_type_Boolean) {
        localImageView1.setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      if (!this.c) {
        break label177;
      }
      paramInt = -2170912;
      QQStoryContext.a();
      if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
        paramInt = -16444373;
      }
      paramView.setBackgroundColor(paramInt);
      paramView.setVisibility(0);
      return;
      localImageView2.setImageResource(2130846256);
      break;
      localImageView2.setImageResource(2130846252);
      break;
      localImageView2.setImageResource(2130846255);
      break;
      localImageView1.setVisibility(4);
    }
    label177:
    paramView.setVisibility(4);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xkx
 * JD-Core Version:    0.7.0.1
 */