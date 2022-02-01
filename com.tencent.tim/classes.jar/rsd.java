import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public abstract class rsd<T>
{
  private SegmentList jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList;
  private rsb jdField_a_of_type_Rsb;
  protected Context context;
  protected boolean isDisplay = true;
  
  public rsd(Context paramContext)
  {
    this.context = paramContext;
  }
  
  protected int J(int paramInt)
  {
    return 0;
  }
  
  protected boolean Ma()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList == null) {
      return false;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList.sk(getKey());
    return true;
  }
  
  protected boolean Z(boolean paramBoolean)
  {
    return false;
  }
  
  public abstract View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup);
  
  protected SegmentList a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList;
  }
  
  public qyd a(int paramInt)
  {
    SegmentList localSegmentList = a();
    if (localSegmentList == null)
    {
      rom.fail("segment:" + getKey() + " have not attach to listView. It can not check isOnScreen.", new Object[0]);
      return null;
    }
    int i = 0;
    if (i < localSegmentList.getChildCount())
    {
      qyd localqyd = (qyd)localSegmentList.getChildAt(i).getTag();
      if (localqyd == null) {}
      while ((!localqyd.azf.equals(getKey())) || (localqyd.position != paramInt))
      {
        i += 1;
        break;
      }
      return localqyd;
    }
    return null;
  }
  
  public abstract qyd a(int paramInt, ViewGroup paramViewGroup);
  
  public void a(rsb paramrsb, SegmentList paramSegmentList)
  {
    this.jdField_a_of_type_Rsb = paramrsb;
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList = paramSegmentList;
  }
  
  public boolean a(qyd paramqyd)
  {
    SegmentList localSegmentList = a();
    if (localSegmentList == null) {
      rom.fail("segment:" + getKey() + " have not attach to listView. It can not check isOnScreen.", new Object[0]);
    }
    int i;
    int j;
    int k;
    do
    {
      do
      {
        return false;
      } while (paramqyd == null);
      i = localSegmentList.getFirstVisiblePosition();
      j = localSegmentList.getLastVisiblePosition();
      k = paramqyd.bov;
    } while ((k < i) || (k > j));
    return true;
  }
  
  protected void bqO() {}
  
  public void bqo() {}
  
  public void brN() {}
  
  protected void bwd()
  {
    if (this.jdField_a_of_type_Rsb == null) {
      return;
    }
    this.jdField_a_of_type_Rsb.notifyDataSetChanged();
  }
  
  public void e(qyd paramqyd) {}
  
  public void g(qyd paramqyd) {}
  
  public abstract int getCount();
  
  public int getItemCount()
  {
    if (this.isDisplay) {
      return getCount();
    }
    return 0;
  }
  
  public abstract String getKey();
  
  protected int getViewTypeCount()
  {
    return 1;
  }
  
  public void h(qyd paramqyd) {}
  
  public boolean isDisplay()
  {
    return this.isDisplay;
  }
  
  public boolean isEnd()
  {
    return true;
  }
  
  public String ne()
  {
    return "";
  }
  
  public final void notifyDataSetChanged(boolean paramBoolean)
  {
    
    if (this.jdField_a_of_type_Rsb != null)
    {
      this.jdField_a_of_type_Rsb.aC(getKey(), paramBoolean);
      this.jdField_a_of_type_Rsb.notifyDataSetChanged();
    }
    qwp.d("Q.qqstory.home.position", new Object[] { "notifyDataSetChanged ", Boolean.valueOf(paramBoolean) });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void onCreate() {}
  
  protected void onDestroy() {}
  
  protected void onPause() {}
  
  protected void onResume() {}
  
  public void setDisplay(boolean paramBoolean)
  {
    if (paramBoolean != this.isDisplay) {
      this.isDisplay = paramBoolean;
    }
  }
  
  public void setSelection(int paramInt)
  {
    paramInt = this.jdField_a_of_type_Rsb.a(this, paramInt);
    a().setSelection(paramInt);
  }
  
  public void wG(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rsd
 * JD-Core Version:    0.7.0.1
 */