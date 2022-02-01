import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;

public abstract class qjw
  extends qjj
{
  public String TAG = this.TAG_PREFIX + System.identityHashCode(this);
  private final String TAG_PREFIX = "Q.qqstory.playernew." + getClass().getSimpleName();
  public qjq a;
  protected qjx a;
  protected boolean aDK;
  public int bmB = -1;
  public int bmn = -1;
  public StoryPlayerGroupHolder c;
  @NonNull
  public final View mItemView = onCreateView(paramViewGroup);
  protected boolean mSelected;
  
  public qjw(@NonNull ViewGroup paramViewGroup) {}
  
  public boolean JN()
  {
    return this.aDK;
  }
  
  public qjw a(Class<? extends qjw> paramClass)
  {
    if (this.jdField_a_of_type_Qjx != null) {
      return this.jdField_a_of_type_Qjx.b(paramClass);
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull qjq paramqjq, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    this.TAG = (this.TAG_PREFIX + System.identityHashCode(this) + "[" + paramInt1 + "," + paramInt2 + "]");
    this.bmn = paramInt1;
    this.bmB = paramInt2;
    this.jdField_a_of_type_Qjq = paramqjq;
    this.aDK = true;
    this.c = paramStoryPlayerGroupHolder;
  }
  
  void a(qjx paramqjx)
  {
    this.jdField_a_of_type_Qjx = paramqjx;
  }
  
  public void boy()
  {
    this.bmn = -1;
    this.bmB = -1;
    this.jdField_a_of_type_Qjq = null;
    this.aDK = false;
    this.c = null;
  }
  
  public void dU(int paramInt1, int paramInt2)
  {
    this.TAG = (this.TAG_PREFIX + System.identityHashCode(this) + "[" + paramInt1 + "," + paramInt2 + "]");
    ram.a(this.TAG, "onPositionChanged, oldVer=%d, oldHor=%d, newVer=%d, newHor=%d", Integer.valueOf(this.bmn), Integer.valueOf(this.bmB), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    this.bmn = paramInt1;
    this.bmB = paramInt2;
  }
  
  public boolean isSelected()
  {
    return this.mSelected;
  }
  
  protected void onCreate() {}
  
  protected abstract View onCreateView(ViewGroup paramViewGroup);
  
  public void sE(boolean paramBoolean)
  {
    if (this.mSelected != paramBoolean)
    {
      this.mSelected = paramBoolean;
      sF(this.mSelected);
      return;
    }
    ram.e(this.TAG, "onSelected donot changed !");
  }
  
  protected void sF(boolean paramBoolean)
  {
    ram.b(this.TAG, "onSelectedChanged (ver=%d, hor=%d) , => %s", Integer.valueOf(this.bmn), Integer.valueOf(this.bmB), Boolean.valueOf(paramBoolean));
  }
  
  public String toString()
  {
    return "VideoHolderBase{, GroupPos=" + this.bmn + ", VideoPos=" + this.bmB + ", mData=" + this.jdField_a_of_type_Qjq + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qjw
 * JD-Core Version:    0.7.0.1
 */