import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public abstract class xvp<T>
{
  protected Context a;
  private SegmentList jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList;
  private xvm jdField_a_of_type_Xvm;
  protected boolean a;
  
  public xvp(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void W_() {}
  
  protected void Y_() {}
  
  public abstract int a();
  
  protected int a(int paramInt)
  {
    return 0;
  }
  
  public abstract View a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup);
  
  protected SegmentList a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList;
  }
  
  public abstract String a();
  
  public wtq a(int paramInt)
  {
    SegmentList localSegmentList = a();
    if (localSegmentList == null)
    {
      xqq.a("segment:" + a() + " have not attach to listView. It can not check isOnScreen.", new Object[0]);
      return null;
    }
    int i = 0;
    if (i < localSegmentList.getChildCount())
    {
      wtq localwtq = (wtq)localSegmentList.getChildAt(i).getTag();
      if (localwtq == null) {}
      while ((!localwtq.a.equals(a())) || (localwtq.b != paramInt))
      {
        i += 1;
        break;
      }
      return localwtq;
    }
    return null;
  }
  
  public abstract wtq a(int paramInt, ViewGroup paramViewGroup);
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(xvm paramxvm, SegmentList paramSegmentList)
  {
    this.jdField_a_of_type_Xvm = paramxvm;
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList = paramSegmentList;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(wtq paramwtq)
  {
    SegmentList localSegmentList = a();
    if (localSegmentList == null) {
      xqq.a("segment:" + a() + " have not attach to listView. It can not check isOnScreen.", new Object[0]);
    }
    int i;
    int j;
    int k;
    do
    {
      do
      {
        return false;
      } while (paramwtq == null);
      i = localSegmentList.getFirstVisiblePosition();
      j = localSegmentList.getLastVisiblePosition();
      k = paramwtq.c;
    } while ((k < i) || (k > j));
    return true;
  }
  
  public void a_(wtq paramwtq) {}
  
  protected boolean a_(boolean paramBoolean)
  {
    return false;
  }
  
  public String b()
  {
    return "";
  }
  
  protected void b() {}
  
  public void b_(wtq paramwtq) {}
  
  protected void c() {}
  
  public void c(wtq paramwtq) {}
  
  public final void c(boolean paramBoolean)
  {
    
    if (this.jdField_a_of_type_Xvm != null)
    {
      this.jdField_a_of_type_Xvm.a(a(), paramBoolean);
      this.jdField_a_of_type_Xvm.notifyDataSetChanged();
    }
    wrk.b("Q.qqstory.home.position", new Object[] { "notifyDataSetChanged ", Boolean.valueOf(paramBoolean) });
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Boolean) {
      return a();
    }
    return 0;
  }
  
  protected void d() {}
  
  public void d(int paramInt)
  {
    paramInt = this.jdField_a_of_type_Xvm.a(this, paramInt);
    a().setSelection(paramInt);
  }
  
  protected boolean d()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList == null) {
      return false;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList.a(a());
    return true;
  }
  
  protected void e() {}
  
  public void e_(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = paramBoolean;
    }
  }
  
  protected int f_()
  {
    return 1;
  }
  
  public void i_(int paramInt) {}
  
  public void k() {}
  
  protected void m()
  {
    if (this.jdField_a_of_type_Xvm == null) {
      return;
    }
    this.jdField_a_of_type_Xvm.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xvp
 * JD-Core Version:    0.7.0.1
 */