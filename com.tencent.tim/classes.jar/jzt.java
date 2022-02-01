import android.view.View;
import com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail;
import com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail.b;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import java.util.List;

public class jzt
  implements AdapterView.c
{
  public jzt(PhotoWallViewForAccountDetail paramPhotoWallViewForAccountDetail) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (jzs.a)this.a.fS.get(paramInt);
    if (this.a.a == null) {
      return;
    }
    this.a.a.d(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jzt
 * JD-Core Version:    0.7.0.1
 */