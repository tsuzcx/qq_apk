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

public class xrh
  extends xrg
{
  Map<String, xrg> a;
  
  public xrh(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    b(new VideoViewVideoHolder((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131381013)));
    b(new xpq((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131368761)));
    b(new xql((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131380949)));
    b(new xri(this.jdField_a_of_type_AndroidViewView.findViewById(2131380918)));
    b(new xrf((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131381014)));
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561816, paramViewGroup, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((xrg)localIterator.next()).a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull xqz paramxqz, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramxqz, paramStoryPlayerGroupHolder);
    yuk.a(this.jdField_a_of_type_JavaLangString, "onBind, newVer=%d, newHor=%d, data=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), paramxqz);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((xrg)localIterator.next()).a(paramInt1, paramInt2, paramxqz, paramStoryPlayerGroupHolder);
    }
  }
  
  public void a(xqn paramxqn)
  {
    super.a(paramxqn);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((xrg)localIterator.next()).a(paramxqn);
    }
  }
  
  public void a(xrh paramxrh)
  {
    super.a(this);
    paramxrh = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (paramxrh.hasNext()) {
      ((xrg)paramxrh.next()).a(this);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((xrg)localIterator.next()).a(paramBoolean);
    }
  }
  
  @Nullable
  public xrg b(Class<? extends xrg> paramClass)
  {
    return (xrg)this.jdField_a_of_type_JavaUtilMap.get(paramClass.getName());
  }
  
  public void b()
  {
    super.b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((xrg)localIterator.next()).b();
    }
  }
  
  public void b(@NonNull xrg paramxrg)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramxrg.getClass().getName(), paramxrg);
  }
  
  public void c()
  {
    super.c();
    yuk.a(this.jdField_a_of_type_JavaLangString, "onUnBind, verticalPosition=%d, horizontalPosition=%d, data=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_Xqz);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((xrg)localIterator.next()).c();
    }
  }
  
  public boolean c()
  {
    return super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xrh
 * JD-Core Version:    0.7.0.1
 */