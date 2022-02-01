import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.theme.ThemeUtil;

public class aypx
  extends aypv
{
  private boolean aIz;
  
  public aypx(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    super(paramContext, paramString1, paramString2, paramInt);
  }
  
  public int J(int paramInt)
  {
    return 0;
  }
  
  public View d(int paramInt, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(this.context).inflate(2131561917, null);
  }
  
  public void m(int paramInt, View paramView)
  {
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131364353);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131364348);
    TextView localTextView = (TextView)paramView.findViewById(2131364350);
    paramView = paramView.findViewById(2131364344);
    localTextView.setText(this.aAS);
    switch (this.bsO)
    {
    case 10002: 
    case 10003: 
    default: 
      if (this.aHE) {
        localImageView1.setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      if (!this.aIz) {
        break label177;
      }
      paramInt = -2170912;
      QQStoryContext.a();
      if (ThemeUtil.isNowThemeIsNight(QQStoryContext.c(), false, null)) {
        paramInt = -16444373;
      }
      paramView.setBackgroundColor(paramInt);
      paramView.setVisibility(0);
      return;
      localImageView2.setImageResource(2130847577);
      break;
      localImageView2.setImageResource(2130847573);
      break;
      localImageView2.setImageResource(2130847576);
      break;
      localImageView1.setVisibility(4);
    }
    label177:
    paramView.setVisibility(4);
  }
  
  public void onClick(int paramInt)
  {
    this.aHE = true;
  }
  
  public void setOpen(boolean paramBoolean) {}
  
  public void tS(boolean paramBoolean)
  {
    this.aIz = paramBoolean;
  }
  
  public int tz()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aypx
 * JD-Core Version:    0.7.0.1
 */