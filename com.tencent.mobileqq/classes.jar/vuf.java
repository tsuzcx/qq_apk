import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.util.VersionUtils;

public class vuf
  implements View.OnSystemUiVisibilityChangeListener
{
  public vuf(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if (paramInt == 4102) {}
    while (!VersionUtils.isHoneycomb()) {
      return;
    }
    this.a.getWindow().getDecorView().setSystemUiVisibility(4102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vuf
 * JD-Core Version:    0.7.0.1
 */