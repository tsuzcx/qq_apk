import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class qir
  extends qjj
{
  protected String TAG = this.TAG_PREFIX + System.identityHashCode(this);
  private final String TAG_PREFIX = "Q.qqstory.playernew." + getClass().getSimpleName();
  protected qis a;
  protected boolean aDy;
  public int bmu = -1;
  public qgy.c d;
  @NonNull
  public final View mItemView;
  public List<qjq> nR = Collections.emptyList();
  
  public qir(@NonNull View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      this.mItemView = onCreateView((ViewGroup)paramView);
      return;
    }
    this.mItemView = paramView;
  }
  
  public qir(@NonNull ViewGroup paramViewGroup)
  {
    this.mItemView = onCreateView(paramViewGroup);
  }
  
  public qir a(Class<? extends qir> paramClass)
  {
    if (this.a != null) {
      return this.a.b(paramClass);
    }
    return null;
  }
  
  public qis a()
  {
    return this.a;
  }
  
  public void a(int paramInt, qgy.d paramd, @NonNull ArrayList<qjq> paramArrayList)
  {
    this.TAG = (this.TAG_PREFIX + System.identityHashCode(this) + "[" + paramInt + "]");
    this.bmu = paramInt;
    this.d = paramd.d;
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      qjq localqjq = (qjq)localIterator.next();
      if ((paramd.d instanceof qhc.a)) {
        localqjq.h = ((qhc.a)paramd.d).g;
      } else {
        localqjq.h = null;
      }
    }
    this.nR = paramArrayList;
    this.aDy = true;
  }
  
  void a(qis paramqis)
  {
    this.a = paramqis;
  }
  
  public void boy()
  {
    ram.a(this.TAG, "onUnBind, position=%d, data.size=%d, groupId=%s", Integer.valueOf(this.bmu), Integer.valueOf(this.nR.size()), this.d.groupId);
    this.aDy = false;
  }
  
  public int getVisibility()
  {
    return this.mItemView.getVisibility();
  }
  
  protected void onCreate() {}
  
  protected abstract View onCreateView(ViewGroup paramViewGroup);
  
  public void setVisibility(int paramInt)
  {
    this.mItemView.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qir
 * JD-Core Version:    0.7.0.1
 */