import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class xnm
  extends xnl
{
  Map<String, xnl> a;
  
  public xnm(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    b(new VideoViewVideoHolder((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131380835)));
    b(new xlv((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131368687)));
    b(new xmq((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131380772)));
    b(new xnn(this.jdField_a_of_type_AndroidViewView.findViewById(2131380741)));
    b(new xnk((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131380836)));
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561775, paramViewGroup, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((xnl)localIterator.next()).a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull xne paramxne, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramxne, paramStoryPlayerGroupHolder);
    yqp.a(this.jdField_a_of_type_JavaLangString, "onBind, newVer=%d, newHor=%d, data=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), paramxne);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((xnl)localIterator.next()).a(paramInt1, paramInt2, paramxne, paramStoryPlayerGroupHolder);
    }
  }
  
  public void a(xms paramxms)
  {
    super.a(paramxms);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((xnl)localIterator.next()).a(paramxms);
    }
  }
  
  public void a(xnm paramxnm)
  {
    super.a(this);
    paramxnm = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (paramxnm.hasNext()) {
      ((xnl)paramxnm.next()).a(this);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((xnl)localIterator.next()).a(paramBoolean);
    }
  }
  
  @Nullable
  public xnl b(Class<? extends xnl> paramClass)
  {
    return (xnl)this.jdField_a_of_type_JavaUtilMap.get(paramClass.getName());
  }
  
  public void b()
  {
    super.b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((xnl)localIterator.next()).b();
    }
  }
  
  public void b(@NonNull xnl paramxnl)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramxnl.getClass().getName(), paramxnl);
  }
  
  public void c()
  {
    super.c();
    yqp.a(this.jdField_a_of_type_JavaLangString, "onUnBind, verticalPosition=%d, horizontalPosition=%d, data=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_Xne);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((xnl)localIterator.next()).c();
    }
  }
  
  public boolean c()
  {
    return super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnm
 * JD-Core Version:    0.7.0.1
 */