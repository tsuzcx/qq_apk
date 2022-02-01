import android.view.View;
import android.view.ViewStub;

public class phn
  extends phl
{
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub != null)
    {
      this.mContainer = paramViewStub.inflate();
      this.mContainer.setOnClickListener(new pho(this));
    }
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    this.mData = paramObject;
    this.mPos = paramInt;
    if (isFakeFeed())
    {
      this.mContainer.setVisibility(0);
      return;
    }
    this.mContainer.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     phn
 * JD-Core Version:    0.7.0.1
 */