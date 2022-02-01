import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOTipsController.1;
import com.tencent.mobileqq.activity.aio.AIOTipsController.2;
import com.tencent.qphone.base.util.QLog;

public class wiw
{
  public wiw.a a;
  private ViewGroup cY;
  
  public wiw(ViewGroup paramViewGroup)
  {
    this.cY = paramViewGroup;
  }
  
  public void a(View paramView, yjf paramyjf)
  {
    int j;
    if (paramView != null)
    {
      j = this.cY.indexOfChild(paramView);
      if (j == -1) {
        this.cY.addView(paramView, new ViewGroup.LayoutParams(-1, -2));
      }
      int i = 0;
      while (i < this.cY.getChildCount())
      {
        this.cY.getChildAt(i).setVisibility(8);
        i += 1;
      }
      if (QLog.isColorLevel()) {
        if (paramyjf != null) {
          break label152;
        }
      }
    }
    label152:
    for (String str = "null";; str = Integer.toHexString(System.identityHashCode(paramyjf)))
    {
      QLog.d("AIOTipsController", 2, "showHearerTips called childIndex = " + j + " object=" + str);
      paramView.setVisibility(0);
      this.cY.setVisibility(0);
      this.cY.post(new AIOTipsController.1(this, paramyjf));
      return;
    }
  }
  
  public void a(wiw.a parama)
  {
    this.a = parama;
  }
  
  public void a(yjf paramyjf)
  {
    if (QLog.isColorLevel()) {
      if (paramyjf != null) {
        break label65;
      }
    }
    label65:
    for (String str = "null";; str = Integer.toHexString(System.identityHashCode(paramyjf)))
    {
      QLog.d("AIOTipsController", 2, "showHearerTips called object=" + str);
      this.cY.setVisibility(8);
      this.cY.post(new AIOTipsController.2(this, paramyjf));
      return;
    }
  }
  
  public void bYt()
  {
    this.cY.removeAllViews();
  }
  
  public static abstract interface a
  {
    public abstract void b(yjf paramyjf);
    
    public abstract void c(yjf paramyjf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wiw
 * JD-Core Version:    0.7.0.1
 */