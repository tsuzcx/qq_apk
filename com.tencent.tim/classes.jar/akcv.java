import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.data.NearbyPeopleCard;

public abstract class akcv
{
  protected View de;
  protected Context mContext;
  
  public akcv(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public abstract void b(NearbyPeopleCard paramNearbyPeopleCard);
  
  protected void cG(View paramView) {}
  
  protected abstract int getContentLayoutId();
  
  public View getContentView()
  {
    if (this.de != null) {
      return this.de;
    }
    int i = getContentLayoutId();
    if (i > 0)
    {
      this.de = LayoutInflater.from(this.mContext).inflate(i, null);
      cG(this.de);
    }
    for (;;)
    {
      return this.de;
      this.de = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akcv
 * JD-Core Version:    0.7.0.1
 */