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

public class uba
  extends uaz
{
  Map<String, uaz> a;
  
  public uba(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    b(new VideoViewVideoHolder((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131379126)));
    b(new tzj((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131368223)));
    b(new uae((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131379078)));
    b(new ubb(this.jdField_a_of_type_AndroidViewView.findViewById(2131379050)));
    b(new uay((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131379127)));
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561332, paramViewGroup, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((uaz)localIterator.next()).a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull uas paramuas, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramuas, paramStoryPlayerGroupHolder);
    ved.a(this.jdField_a_of_type_JavaLangString, "onBind, newVer=%d, newHor=%d, data=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), paramuas);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((uaz)localIterator.next()).a(paramInt1, paramInt2, paramuas, paramStoryPlayerGroupHolder);
    }
  }
  
  public void a(uag paramuag)
  {
    super.a(paramuag);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((uaz)localIterator.next()).a(paramuag);
    }
  }
  
  public void a(uba paramuba)
  {
    super.a(this);
    paramuba = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (paramuba.hasNext()) {
      ((uaz)paramuba.next()).a(this);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((uaz)localIterator.next()).a(paramBoolean);
    }
  }
  
  @Nullable
  public uaz b(Class<? extends uaz> paramClass)
  {
    return (uaz)this.jdField_a_of_type_JavaUtilMap.get(paramClass.getName());
  }
  
  public void b()
  {
    super.b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((uaz)localIterator.next()).b();
    }
  }
  
  public void b(@NonNull uaz paramuaz)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramuaz.getClass().getName(), paramuaz);
  }
  
  public void c()
  {
    super.c();
    ved.a(this.jdField_a_of_type_JavaLangString, "onUnBind, verticalPosition=%d, horizontalPosition=%d, data=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_Uas);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((uaz)localIterator.next()).c();
    }
  }
  
  public boolean c()
  {
    return super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uba
 * JD-Core Version:    0.7.0.1
 */