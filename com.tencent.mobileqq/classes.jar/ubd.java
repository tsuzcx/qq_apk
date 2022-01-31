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

public class ubd
  extends ubc
{
  Map<String, ubc> a;
  
  public ubd(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    b(new VideoViewVideoHolder((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131379121)));
    b(new tzm((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131368223)));
    b(new uah((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131379073)));
    b(new ube(this.jdField_a_of_type_AndroidViewView.findViewById(2131379045)));
    b(new ubb((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131379122)));
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561333, paramViewGroup, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ubc)localIterator.next()).a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull uav paramuav, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramuav, paramStoryPlayerGroupHolder);
    veg.a(this.jdField_a_of_type_JavaLangString, "onBind, newVer=%d, newHor=%d, data=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), paramuav);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ubc)localIterator.next()).a(paramInt1, paramInt2, paramuav, paramStoryPlayerGroupHolder);
    }
  }
  
  public void a(uaj paramuaj)
  {
    super.a(paramuaj);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ubc)localIterator.next()).a(paramuaj);
    }
  }
  
  public void a(ubd paramubd)
  {
    super.a(this);
    paramubd = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (paramubd.hasNext()) {
      ((ubc)paramubd.next()).a(this);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ubc)localIterator.next()).a(paramBoolean);
    }
  }
  
  @Nullable
  public ubc b(Class<? extends ubc> paramClass)
  {
    return (ubc)this.jdField_a_of_type_JavaUtilMap.get(paramClass.getName());
  }
  
  public void b()
  {
    super.b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ubc)localIterator.next()).b();
    }
  }
  
  public void b(@NonNull ubc paramubc)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramubc.getClass().getName(), paramubc);
  }
  
  public void c()
  {
    super.c();
    veg.a(this.jdField_a_of_type_JavaLangString, "onUnBind, verticalPosition=%d, horizontalPosition=%d, data=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_Uav);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ubc)localIterator.next()).c();
    }
  }
  
  public boolean c()
  {
    return super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ubd
 * JD-Core Version:    0.7.0.1
 */