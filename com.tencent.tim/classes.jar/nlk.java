import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class nlk
  implements nlc.b
{
  private final List<BaseData> km;
  private final XListView listView;
  
  public nlk(XListView paramXListView, List<BaseData> paramList, nlc paramnlc)
  {
    this.listView = paramXListView;
    this.km = paramList;
    paramnlc.a(this);
  }
  
  private nlc a()
  {
    if ((this.listView.getAdapter() instanceof auts))
    {
      auts localauts = (auts)this.listView.getAdapter();
      if ((localauts.getWrappedAdapter() instanceof nlc)) {
        return (nlc)localauts.getWrappedAdapter();
      }
    }
    return null;
  }
  
  private int cZ(int paramInt)
  {
    int j = this.listView.getWidth();
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
      localObject = ((nlc)localObject).a(paramInt, null, this.listView, true);
      ((View)localObject).measure(j, 0);
      j = ((View)localObject).getMeasuredHeight();
      QLog.d("ItemHeightHelper", 2, "getItemMeasureHeight index : " + paramInt + " height : " + j);
      return j;
    }
    catch (Exception localException)
    {
      QLog.d("ItemHeightHelper", 2, localException, new Object[] { " index : " + paramInt });
    }
    return i;
  }
  
  private boolean ei(int paramInt)
  {
    if ((paramInt >= this.km.size()) || (paramInt < 0)) {
      return true;
    }
    if ((BaseData)this.km.get(paramInt) == null)
    {
      wja.a("ItemHeightHelper", "", new IllegalArgumentException(" data == null index: " + paramInt + "   itemArrayList.size() :" + this.km.size()));
      return true;
    }
    return false;
  }
  
  public int get(int paramInt)
  {
    if (ei(paramInt)) {
      return -1;
    }
    BaseData localBaseData = (BaseData)this.km.get(paramInt);
    if (localBaseData.viewHeight > 0) {
      return localBaseData.viewHeight;
    }
    localBaseData.viewHeight = cZ(paramInt);
    return localBaseData.viewHeight;
  }
  
  public void i(int paramInt, View paramView)
  {
    if (ei(paramInt)) {}
    while (((BaseData)this.km.get(paramInt)).viewHeight > 0) {
      return;
    }
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(new nll(this, paramInt, paramView));
  }
  
  public void set(int paramInt1, int paramInt2)
  {
    if (ei(paramInt1)) {
      return;
    }
    ((BaseData)this.km.get(paramInt1)).viewHeight = paramInt2;
    QLog.d("ItemHeightHelper", 2, " index : " + paramInt1 + "   height: " + paramInt2);
  }
  
  public int size()
  {
    return this.km.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nlk
 * JD-Core Version:    0.7.0.1
 */