import android.view.View;
import com.tencent.qidian.PhotoWallViewForQiDianProfile;
import com.tencent.qidian.PhotoWallViewForQiDianProfile.b;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import java.util.List;

public class asgw
  implements AdapterView.c
{
  public asgw(PhotoWallViewForQiDianProfile paramPhotoWallViewForQiDianProfile) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (asia)this.a.JO.get(paramInt);
    if (this.a.a == null) {
      return;
    }
    this.a.a.a(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asgw
 * JD-Core Version:    0.7.0.1
 */