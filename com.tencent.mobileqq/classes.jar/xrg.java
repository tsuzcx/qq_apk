import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public abstract class xrg<T>
{
  protected Context a;
  private SegmentList jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList;
  private xrd jdField_a_of_type_Xrd;
  protected boolean a;
  
  public xrg(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void Z_() {}
  
  public abstract int a();
  
  protected int a(int paramInt)
  {
    return 0;
  }
  
  public abstract View a(int paramInt, wph paramwph, ViewGroup paramViewGroup);
  
  protected SegmentList a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList;
  }
  
  public abstract String a();
  
  public wph a(int paramInt)
  {
    SegmentList localSegmentList = a();
    if (localSegmentList == null)
    {
      xmh.a("segment:" + a() + " have not attach to listView. It can not check isOnScreen.", new Object[0]);
      return null;
    }
    int i = 0;
    if (i < localSegmentList.getChildCount())
    {
      wph localwph = (wph)localSegmentList.getChildAt(i).getTag();
      if (localwph == null) {}
      while ((!localwph.a.equals(a())) || (localwph.b != paramInt))
      {
        i += 1;
        break;
      }
      return localwph;
    }
    return null;
  }
  
  public abstract wph a(int paramInt, ViewGroup paramViewGroup);
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(xrd paramxrd, SegmentList paramSegmentList)
  {
    this.jdField_a_of_type_Xrd = paramxrd;
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList = paramSegmentList;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(wph paramwph)
  {
    SegmentList localSegmentList = a();
    if (localSegmentList == null) {
      xmh.a("segment:" + a() + " have not attach to listView. It can not check isOnScreen.", new Object[0]);
    }
    int i;
    int j;
    int k;
    do
    {
      do
      {
        return false;
      } while (paramwph == null);
      i = localSegmentList.getFirstVisiblePosition();
      j = localSegmentList.getLastVisiblePosition();
      k = paramwph.c;
    } while ((k < i) || (k > j));
    return true;
  }
  
  public void a_(wph paramwph) {}
  
  protected boolean a_(boolean paramBoolean)
  {
    return false;
  }
  
  protected void ab_() {}
  
  public String b()
  {
    return "";
  }
  
  protected void b() {}
  
  public void b_(wph paramwph) {}
  
  protected void c() {}
  
  public void c(wph paramwph) {}
  
  public final void c(boolean paramBoolean)
  {
    
    if (this.jdField_a_of_type_Xrd != null)
    {
      this.jdField_a_of_type_Xrd.a(a(), paramBoolean);
      this.jdField_a_of_type_Xrd.notifyDataSetChanged();
    }
    wnb.b("Q.qqstory.home.position", new Object[] { "notifyDataSetChanged ", Boolean.valueOf(paramBoolean) });
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
    paramInt = this.jdField_a_of_type_Xrd.a(this, paramInt);
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
    if (this.jdField_a_of_type_Xrd == null) {
      return;
    }
    this.jdField_a_of_type_Xrd.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xrg
 * JD-Core Version:    0.7.0.1
 */