import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public class anuv
  extends anqu
{
  private int mProgress;
  
  public anuv()
  {
    this.mTypeName = "progress";
  }
  
  public anuv(int paramInt)
  {
    this.mProgress = paramInt;
    this.mTypeName = "progress";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof ProgressBar))) {}
    for (paramContext = (ProgressBar)paramView;; paramContext = paramView)
    {
      paramContext.setTag(this);
      paramContext.setProgress(this.mProgress);
      if (this.mProgress == paramContext.getMax()) {
        paramContext.setVisibility(8);
      }
      return paramContext;
      paramView = new ProgressBar(paramContext, null, 16842872);
      paramView.setId(2131378835);
      paramView.setMax(100);
      paramView.setProgressDrawable(paramContext.getResources().getDrawable(2130838114));
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag(null, "progress");
    paramXmlSerializer.text(String.valueOf(this.mProgress));
    paramXmlSerializer.endTag(null, "progress");
  }
  
  public boolean a(ansf paramansf)
  {
    paramansf = anre.a(paramansf);
    try
    {
      this.mProgress = Integer.valueOf(paramansf).intValue();
      return true;
    }
    catch (NumberFormatException paramansf)
    {
      for (;;)
      {
        this.mProgress = 0;
      }
    }
  }
  
  public String getLayoutStr()
  {
    return "Progress";
  }
  
  public int getProgress()
  {
    return this.mProgress;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    this.mProgress = paramObjectInput.readInt();
  }
  
  public void setProgress(int paramInt)
  {
    this.mProgress = paramInt;
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    paramObjectOutput.writeInt(this.mProgress);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anuv
 * JD-Core Version:    0.7.0.1
 */