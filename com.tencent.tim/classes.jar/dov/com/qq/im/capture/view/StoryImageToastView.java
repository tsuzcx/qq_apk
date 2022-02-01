package dov.com.qq.im.capture.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

public class StoryImageToastView
  extends StoryToastView
{
  private ImageView II;
  private TextView ahM;
  
  public StoryImageToastView(Context paramContext)
  {
    super(paramContext);
  }
  
  public StoryImageToastView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StoryImageToastView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public StoryImageToastView a(int paramInt)
  {
    this.II.setImageResource(paramInt);
    return this;
  }
  
  public StoryImageToastView a(String paramString)
  {
    this.ahM.setText(paramString);
    return this;
  }
  
  protected void init(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131561108, this, true);
    this.ahM = ((TextView)findViewById(2131379953));
    this.II = ((ImageView)findViewById(2131379949));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.StoryImageToastView
 * JD-Core Version:    0.7.0.1
 */