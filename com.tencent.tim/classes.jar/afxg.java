import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.extendfriend.pulltorefresh.LoadingLayoutBase;
import java.util.HashSet;
import java.util.Iterator;

public class afxg
  implements afxf
{
  private final HashSet<LoadingLayoutBase> be = new HashSet();
  
  public void a(LoadingLayoutBase paramLoadingLayoutBase)
  {
    if (paramLoadingLayoutBase != null) {
      this.be.add(paramLoadingLayoutBase);
    }
  }
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.be.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayoutBase)localIterator.next()).setLastUpdatedLabel(paramCharSequence);
    }
  }
  
  public void setLoadingDrawable(Drawable paramDrawable)
  {
    Iterator localIterator = this.be.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayoutBase)localIterator.next()).setLoadingDrawable(paramDrawable);
    }
  }
  
  public void setPullLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.be.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayoutBase)localIterator.next()).setPullLabel(paramCharSequence);
    }
  }
  
  public void setRefreshResultLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.be.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayoutBase)localIterator.next()).setRefreshResultLabel(paramCharSequence);
    }
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.be.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayoutBase)localIterator.next()).setRefreshingLabel(paramCharSequence);
    }
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.be.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayoutBase)localIterator.next()).setReleaseLabel(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afxg
 * JD-Core Version:    0.7.0.1
 */