import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public abstract class vpv<T>
{
  protected Context a;
  private SegmentList jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList;
  private vps jdField_a_of_type_Vps;
  protected boolean a;
  
  public vpv(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void T_() {}
  
  protected void V_() {}
  
  public abstract int a();
  
  protected int a(int paramInt)
  {
    return 0;
  }
  
  public abstract View a(int paramInt, unw paramunw, ViewGroup paramViewGroup);
  
  protected SegmentList a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList;
  }
  
  public abstract String a();
  
  public unw a(int paramInt)
  {
    SegmentList localSegmentList = a();
    if (localSegmentList == null)
    {
      vkw.a("segment:" + a() + " have not attach to listView. It can not check isOnScreen.", new Object[0]);
      return null;
    }
    int i = 0;
    if (i < localSegmentList.getChildCount())
    {
      unw localunw = (unw)localSegmentList.getChildAt(i).getTag();
      if (localunw == null) {}
      while ((!localunw.a.equals(a())) || (localunw.b != paramInt))
      {
        i += 1;
        break;
      }
      return localunw;
    }
    return null;
  }
  
  public abstract unw a(int paramInt, ViewGroup paramViewGroup);
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(vps paramvps, SegmentList paramSegmentList)
  {
    this.jdField_a_of_type_Vps = paramvps;
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList = paramSegmentList;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(unw paramunw)
  {
    SegmentList localSegmentList = a();
    if (localSegmentList == null) {
      vkw.a("segment:" + a() + " have not attach to listView. It can not check isOnScreen.", new Object[0]);
    }
    int i;
    int j;
    int k;
    do
    {
      do
      {
        return false;
      } while (paramunw == null);
      i = localSegmentList.getFirstVisiblePosition();
      j = localSegmentList.getLastVisiblePosition();
      k = paramunw.c;
    } while ((k < i) || (k > j));
    return true;
  }
  
  public void a_(unw paramunw) {}
  
  protected boolean a_(boolean paramBoolean)
  {
    return false;
  }
  
  public String b()
  {
    return "";
  }
  
  protected void b() {}
  
  public void b_(unw paramunw) {}
  
  protected void c() {}
  
  public void c(unw paramunw) {}
  
  public final void c(boolean paramBoolean)
  {
    
    if (this.jdField_a_of_type_Vps != null)
    {
      this.jdField_a_of_type_Vps.a(a(), paramBoolean);
      this.jdField_a_of_type_Vps.notifyDataSetChanged();
    }
    ulq.b("Q.qqstory.home.position", new Object[] { "notifyDataSetChanged ", Boolean.valueOf(paramBoolean) });
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
    paramInt = this.jdField_a_of_type_Vps.a(this, paramInt);
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
  
  protected int f_()
  {
    return 1;
  }
  
  public void f_(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = paramBoolean;
    }
  }
  
  public void g_(int paramInt) {}
  
  public void k() {}
  
  protected void m()
  {
    if (this.jdField_a_of_type_Vps == null) {
      return;
    }
    this.jdField_a_of_type_Vps.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vpv
 * JD-Core Version:    0.7.0.1
 */