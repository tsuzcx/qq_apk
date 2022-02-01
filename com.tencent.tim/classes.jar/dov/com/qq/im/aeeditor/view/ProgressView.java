package dov.com.qq.im.aeeditor.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressView
  extends FrameLayout
{
  private ProgressBar mProgressBar;
  private TextView nM;
  
  public ProgressView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131562047, this);
    this.mProgressBar = ((ProgressBar)findViewById(2131373659));
    this.nM = ((TextView)findViewById(2131379401));
  }
  
  public void setProgressText(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (paramCharSequence.length() <= 0))
    {
      this.nM.setVisibility(8);
      return;
    }
    this.nM.setVisibility(0);
    this.nM.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.ProgressView
 * JD-Core Version:    0.7.0.1
 */