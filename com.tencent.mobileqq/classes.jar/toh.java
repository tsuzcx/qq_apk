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

public class toh
  extends tog
{
  Map<String, tog> a;
  
  public toh(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    b(new VideoViewVideoHolder((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131313286)));
    b(new tmq((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131302601)));
    b(new tnl((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131313237)));
    b(new toi(this.jdField_a_of_type_AndroidViewView.findViewById(2131313209)));
    b(new tof((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131313287)));
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495742, paramViewGroup, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((tog)localIterator.next()).a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull tnz paramtnz, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramtnz, paramStoryPlayerGroupHolder);
    urk.a(this.jdField_a_of_type_JavaLangString, "onBind, newVer=%d, newHor=%d, data=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), paramtnz);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((tog)localIterator.next()).a(paramInt1, paramInt2, paramtnz, paramStoryPlayerGroupHolder);
    }
  }
  
  public void a(tnn paramtnn)
  {
    super.a(paramtnn);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((tog)localIterator.next()).a(paramtnn);
    }
  }
  
  public void a(toh paramtoh)
  {
    super.a(this);
    paramtoh = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (paramtoh.hasNext()) {
      ((tog)paramtoh.next()).a(this);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((tog)localIterator.next()).a(paramBoolean);
    }
  }
  
  @Nullable
  public tog b(Class<? extends tog> paramClass)
  {
    return (tog)this.jdField_a_of_type_JavaUtilMap.get(paramClass.getName());
  }
  
  public void b()
  {
    super.b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((tog)localIterator.next()).b();
    }
  }
  
  public void b(@NonNull tog paramtog)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramtog.getClass().getName(), paramtog);
  }
  
  public void c()
  {
    super.c();
    urk.a(this.jdField_a_of_type_JavaLangString, "onUnBind, verticalPosition=%d, horizontalPosition=%d, data=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_Tnz);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((tog)localIterator.next()).c();
    }
  }
  
  public boolean c()
  {
    return super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     toh
 * JD-Core Version:    0.7.0.1
 */