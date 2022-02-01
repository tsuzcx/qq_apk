package dov.com.qq.im.capture.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

public class StoryTextToastView
  extends StoryToastView
{
  private TextView ahM;
  private TextView ahN;
  
  public StoryTextToastView(Context paramContext)
  {
    super(paramContext);
  }
  
  public StoryTextToastView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StoryTextToastView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public StoryTextToastView a(String paramString)
  {
    this.ahM.setText(paramString);
    return this;
  }
  
  public StoryTextToastView b(String paramString)
  {
    this.ahN.setText(paramString);
    return this;
  }
  
  protected void init(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131561107, this, true);
    this.ahM = ((TextView)findViewById(2131379953));
    this.ahN = ((TextView)findViewById(2131379954));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.StoryTextToastView
 * JD-Core Version:    0.7.0.1
 */