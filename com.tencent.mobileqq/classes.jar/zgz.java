import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public abstract class zgz<T>
{
  protected Context a;
  private SegmentList jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList;
  private zgw jdField_a_of_type_Zgw;
  protected boolean a;
  
  public zgz(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void P_() {}
  
  protected void R_() {}
  
  public abstract int a();
  
  protected int a(int paramInt)
  {
    return 0;
  }
  
  public abstract View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup);
  
  protected SegmentList a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList;
  }
  
  public abstract String a();
  
  public yhc a(int paramInt)
  {
    SegmentList localSegmentList = a();
    if (localSegmentList == null)
    {
      zdl.a("segment:" + a() + " have not attach to listView. It can not check isOnScreen.", new Object[0]);
      return null;
    }
    int i = 0;
    if (i < localSegmentList.getChildCount())
    {
      yhc localyhc = (yhc)localSegmentList.getChildAt(i).getTag();
      if (localyhc == null) {}
      while ((!localyhc.a.equals(a())) || (localyhc.b != paramInt))
      {
        i += 1;
        break;
      }
      return localyhc;
    }
    return null;
  }
  
  public abstract yhc a(int paramInt, ViewGroup paramViewGroup);
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(zgw paramzgw, SegmentList paramSegmentList)
  {
    this.jdField_a_of_type_Zgw = paramzgw;
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList = paramSegmentList;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(yhc paramyhc)
  {
    SegmentList localSegmentList = a();
    if (localSegmentList == null) {
      zdl.a("segment:" + a() + " have not attach to listView. It can not check isOnScreen.", new Object[0]);
    }
    int i;
    int j;
    int k;
    do
    {
      do
      {
        return false;
      } while (paramyhc == null);
      i = localSegmentList.getFirstVisiblePosition();
      j = localSegmentList.getLastVisiblePosition();
      k = paramyhc.c;
    } while ((k < i) || (k > j));
    return true;
  }
  
  public void a_(yhc paramyhc) {}
  
  protected boolean a_(boolean paramBoolean)
  {
    return false;
  }
  
  public String b()
  {
    return "";
  }
  
  protected void b() {}
  
  public void b_(yhc paramyhc) {}
  
  protected void c() {}
  
  public void c(yhc paramyhc) {}
  
  public final void c(boolean paramBoolean)
  {
    
    if (this.jdField_a_of_type_Zgw != null)
    {
      this.jdField_a_of_type_Zgw.a(a(), paramBoolean);
      this.jdField_a_of_type_Zgw.notifyDataSetChanged();
    }
    yew.b("Q.qqstory.home.position", new Object[] { "notifyDataSetChanged ", Boolean.valueOf(paramBoolean) });
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
    paramInt = this.jdField_a_of_type_Zgw.a(this, paramInt);
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
  
  public void d_(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = paramBoolean;
    }
  }
  
  protected void e() {}
  
  protected int f_()
  {
    return 1;
  }
  
  public void i_(int paramInt) {}
  
  public void k() {}
  
  protected void m()
  {
    if (this.jdField_a_of_type_Zgw == null) {
      return;
    }
    this.jdField_a_of_type_Zgw.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zgz
 * JD-Core Version:    0.7.0.1
 */