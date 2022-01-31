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

public class vub
  extends vua
{
  Map<String, vua> a;
  
  public vub(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    b(new VideoViewVideoHolder((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131379876)));
    b(new vsk((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131368380)));
    b(new vtf((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131379814)));
    b(new vuc(this.jdField_a_of_type_AndroidViewView.findViewById(2131379783)));
    b(new vtz((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131379877)));
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561540, paramViewGroup, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((vua)localIterator.next()).a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull vtt paramvtt, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramvtt, paramStoryPlayerGroupHolder);
    wxe.a(this.jdField_a_of_type_JavaLangString, "onBind, newVer=%d, newHor=%d, data=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), paramvtt);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((vua)localIterator.next()).a(paramInt1, paramInt2, paramvtt, paramStoryPlayerGroupHolder);
    }
  }
  
  public void a(vth paramvth)
  {
    super.a(paramvth);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((vua)localIterator.next()).a(paramvth);
    }
  }
  
  public void a(vub paramvub)
  {
    super.a(this);
    paramvub = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (paramvub.hasNext()) {
      ((vua)paramvub.next()).a(this);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((vua)localIterator.next()).a(paramBoolean);
    }
  }
  
  @Nullable
  public vua b(Class<? extends vua> paramClass)
  {
    return (vua)this.jdField_a_of_type_JavaUtilMap.get(paramClass.getName());
  }
  
  public void b()
  {
    super.b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((vua)localIterator.next()).b();
    }
  }
  
  public void b(@NonNull vua paramvua)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramvua.getClass().getName(), paramvua);
  }
  
  public void c()
  {
    super.c();
    wxe.a(this.jdField_a_of_type_JavaLangString, "onUnBind, verticalPosition=%d, horizontalPosition=%d, data=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_Vtt);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((vua)localIterator.next()).c();
    }
  }
  
  public boolean c()
  {
    return super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vub
 * JD-Core Version:    0.7.0.1
 */