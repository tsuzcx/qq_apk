import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public abstract class ysg<T>
{
  protected Context a;
  private SegmentList jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList;
  private ysd jdField_a_of_type_Ysd;
  protected boolean a;
  
  public ysg(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void N_() {}
  
  protected void P_() {}
  
  public abstract int a();
  
  protected int a(int paramInt)
  {
    return 0;
  }
  
  public abstract View a(int paramInt, xsh paramxsh, ViewGroup paramViewGroup);
  
  protected SegmentList a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList;
  }
  
  public abstract String a();
  
  public xsh a(int paramInt)
  {
    SegmentList localSegmentList = a();
    if (localSegmentList == null)
    {
      yos.a("segment:" + a() + " have not attach to listView. It can not check isOnScreen.", new Object[0]);
      return null;
    }
    int i = 0;
    if (i < localSegmentList.getChildCount())
    {
      xsh localxsh = (xsh)localSegmentList.getChildAt(i).getTag();
      if (localxsh == null) {}
      while ((!localxsh.a.equals(a())) || (localxsh.b != paramInt))
      {
        i += 1;
        break;
      }
      return localxsh;
    }
    return null;
  }
  
  public abstract xsh a(int paramInt, ViewGroup paramViewGroup);
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(ysd paramysd, SegmentList paramSegmentList)
  {
    this.jdField_a_of_type_Ysd = paramysd;
    this.jdField_a_of_type_ComTencentBizQqstoryViewSegmentSegmentList = paramSegmentList;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(xsh paramxsh)
  {
    SegmentList localSegmentList = a();
    if (localSegmentList == null) {
      yos.a("segment:" + a() + " have not attach to listView. It can not check isOnScreen.", new Object[0]);
    }
    int i;
    int j;
    int k;
    do
    {
      do
      {
        return false;
      } while (paramxsh == null);
      i = localSegmentList.getFirstVisiblePosition();
      j = localSegmentList.getLastVisiblePosition();
      k = paramxsh.c;
    } while ((k < i) || (k > j));
    return true;
  }
  
  public void a_(xsh paramxsh) {}
  
  protected boolean a_(boolean paramBoolean)
  {
    return false;
  }
  
  public String b()
  {
    return "";
  }
  
  protected void b() {}
  
  public void b_(xsh paramxsh) {}
  
  protected void c() {}
  
  public void c(xsh paramxsh) {}
  
  public final void c(boolean paramBoolean)
  {
    
    if (this.jdField_a_of_type_Ysd != null)
    {
      this.jdField_a_of_type_Ysd.a(a(), paramBoolean);
      this.jdField_a_of_type_Ysd.notifyDataSetChanged();
    }
    xqb.b("Q.qqstory.home.position", new Object[] { "notifyDataSetChanged ", Boolean.valueOf(paramBoolean) });
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
    paramInt = this.jdField_a_of_type_Ysd.a(this, paramInt);
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
  
  protected int g_()
  {
    return 1;
  }
  
  public void h_(int paramInt) {}
  
  public void k() {}
  
  protected void m()
  {
    if (this.jdField_a_of_type_Ysd == null) {
      return;
    }
    this.jdField_a_of_type_Ysd.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ysg
 * JD-Core Version:    0.7.0.1
 */