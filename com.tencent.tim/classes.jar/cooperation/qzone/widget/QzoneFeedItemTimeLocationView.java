package cooperation.qzone.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class QzoneFeedItemTimeLocationView
  extends RelativeLayout
{
  TextView agA;
  TextView agB;
  private Context mContext;
  public String timeStr;
  
  public QzoneFeedItemTimeLocationView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public QzoneFeedItemTimeLocationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public QzoneFeedItemTimeLocationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  private void init()
  {
    LayoutInflater.from(this.mContext).inflate(2131558925, this);
    this.agA = ((TextView)findViewById(2131366898));
    this.agB = ((TextView)findViewById(2131366968));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      paramInt1 = 0;
      if (this.agB != null) {
        paramInt1 = this.agB.getWidth();
      }
      paramInt2 = getWidth();
      paramInt3 = paramInt2 - (int)(this.mContext.getResources().getDimension(2131296422) + 0.5D) - (int)(this.mContext.getResources().getDimension(2131296423) + 0.5D) - (int)(this.mContext.getResources().getDimension(2131296421) + 0.5D) - paramInt1 - 1;
      this.agA.setMaxWidth(paramInt3);
      if (QLog.isColorLevel()) {
        QLog.d("QzoneFeedItemTimeLocationView", 2, "onLayout change:timeWidth:" + paramInt1 + ",feedLocationTvWidth(max):" + paramInt3 + ",feedLocationLayoutWidth:" + paramInt2);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneFeedItemTimeLocationView", 2, "onLayout");
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setTime(String paramString)
  {
    this.timeStr = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.widget.QzoneFeedItemTimeLocationView
 * JD-Core Version:    0.7.0.1
 */