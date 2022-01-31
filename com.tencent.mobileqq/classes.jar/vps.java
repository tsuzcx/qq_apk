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

public class vps
  extends vpr
{
  Map<String, vpr> a;
  
  public vps(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    b(new VideoViewVideoHolder((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131379818)));
    b(new vob((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131368369)));
    b(new vow((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131379756)));
    b(new vpt(this.jdField_a_of_type_AndroidViewView.findViewById(2131379725)));
    b(new vpq((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131379819)));
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561522, paramViewGroup, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((vpr)localIterator.next()).a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull vpk paramvpk, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramvpk, paramStoryPlayerGroupHolder);
    wsv.a(this.jdField_a_of_type_JavaLangString, "onBind, newVer=%d, newHor=%d, data=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), paramvpk);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((vpr)localIterator.next()).a(paramInt1, paramInt2, paramvpk, paramStoryPlayerGroupHolder);
    }
  }
  
  public void a(voy paramvoy)
  {
    super.a(paramvoy);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((vpr)localIterator.next()).a(paramvoy);
    }
  }
  
  public void a(vps paramvps)
  {
    super.a(this);
    paramvps = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (paramvps.hasNext()) {
      ((vpr)paramvps.next()).a(this);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((vpr)localIterator.next()).a(paramBoolean);
    }
  }
  
  @Nullable
  public vpr b(Class<? extends vpr> paramClass)
  {
    return (vpr)this.jdField_a_of_type_JavaUtilMap.get(paramClass.getName());
  }
  
  public void b()
  {
    super.b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((vpr)localIterator.next()).b();
    }
  }
  
  public void b(@NonNull vpr paramvpr)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramvpr.getClass().getName(), paramvpr);
  }
  
  public void c()
  {
    super.c();
    wsv.a(this.jdField_a_of_type_JavaLangString, "onUnBind, verticalPosition=%d, horizontalPosition=%d, data=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_Vpk);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((vpr)localIterator.next()).c();
    }
  }
  
  public boolean c()
  {
    return super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vps
 * JD-Core Version:    0.7.0.1
 */