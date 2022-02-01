import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView.RadiusView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView.RadiusView.1.1;
import com.tencent.qphone.base.util.QLog;

public class ltj
  implements View.OnLayoutChangeListener
{
  public ltj(NativeMiddleBodyView.RadiusView paramRadiusView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramView = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if ((paramView.width != paramInt1) || (paramView.height != paramInt2))
    {
      paramView.width = paramInt1;
      paramView.height = paramInt2;
      this.b.post(new NativeMiddleBodyView.RadiusView.1.1(this, paramInt1, paramInt2, paramView));
    }
    QLog.i(NativeMiddleBodyView.access$000(), 1, "width:" + paramInt1 + " height:" + paramInt2 + " old: " + paramView.width + ":" + paramView.height);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ltj
 * JD-Core Version:    0.7.0.1
 */