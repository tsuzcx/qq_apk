import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeGridImageView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeGridImageView.a;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;

public class lti
  implements AdapterView.c
{
  public lti(NativeGridImageView paramNativeGridImageView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    NativeGridImageView.a(this.b, paramInt, NativeGridImageView.a(this.b).getImageList());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lti
 * JD-Core Version:    0.7.0.1
 */