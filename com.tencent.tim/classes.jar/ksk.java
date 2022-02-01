import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ksk
  implements kte.a
{
  private ReadInJoyCommentListView a;
  private List<ktm> gq;
  
  public ksk(ReadInJoyCommentListView paramReadInJoyCommentListView, List<ktm> paramList, kte paramkte)
  {
    this.a = paramReadInJoyCommentListView;
    this.gq = paramList;
    paramkte.a(this);
  }
  
  private kte a()
  {
    if ((this.a != null) && ((this.a.getAdapter() instanceof auts)))
    {
      auts localauts = (auts)this.a.getAdapter();
      if ((localauts.getWrappedAdapter() instanceof kte)) {
        return (kte)localauts.getWrappedAdapter();
      }
    }
    return null;
  }
  
  private int cZ(int paramInt)
  {
    int j = this.a.getWidth();
    int i = Utils.dp2px(300.0D);
    j = View.MeasureSpec.makeMeasureSpec(j, -2147483648);
    if ((Build.VERSION.SDK_INT <= 19) && (paramInt == 0)) {}
    Object localObject;
    do
    {
      return i;
      localObject = a();
    } while (localObject == null);
    try
    {
      localObject = ((kte)localObject).a(paramInt, null, this.a, true);
      ((View)localObject).measure(j, 0);
      j = ((View)localObject).getMeasuredHeight();
      QLog.d("ReadInJoyCommentItemHeightHelper", 2, "getItemMeasureHeight index : " + paramInt + " height : " + j);
      return j;
    }
    catch (Exception localException)
    {
      QLog.d("ReadInJoyCommentItemHeightHelper", 2, localException, new Object[] { " index : " + paramInt });
    }
    return i;
  }
  
  private void cv(int paramInt1, int paramInt2)
  {
    if ((this.gq != null) && (paramInt1 < this.gq.size()) && (this.gq.get(paramInt1) != null))
    {
      ((ktm)this.gq.get(paramInt1)).aLQ = paramInt2;
      QLog.d("ReadInJoyCommentItemHeightHelper", 2, "setHeight | postion " + paramInt1 + " itemHeight " + paramInt2);
    }
  }
  
  public int getHeight(int paramInt)
  {
    if ((paramInt < 0) || ((this.gq != null) && (this.gq.size() <= paramInt))) {
      return -1;
    }
    ktm localktm = (ktm)this.gq.get(paramInt);
    if (localktm.aLQ > 0) {
      return localktm.aLQ;
    }
    localktm.aLQ = cZ(paramInt);
    return localktm.aLQ;
  }
  
  public void i(int paramInt, View paramView)
  {
    if (paramView == null) {
      QLog.d("ReadInJoyCommentItemHeightHelper", 2, "onGetView view is null");
    }
    ViewTreeObserver localViewTreeObserver;
    do
    {
      return;
      localViewTreeObserver = paramView.getViewTreeObserver();
    } while (localViewTreeObserver == null);
    localViewTreeObserver.addOnGlobalLayoutListener(new ksl(this, paramInt, paramView));
  }
  
  public int size()
  {
    return this.gq.size();
  }
  
  public static abstract interface a
  {
    public abstract void onScroll(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ksk
 * JD-Core Version:    0.7.0.1
 */