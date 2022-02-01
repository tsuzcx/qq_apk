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

public class wss
  extends wsr
{
  Map<String, wsr> a;
  
  public wss(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    b(new VideoViewVideoHolder((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131380739)));
    b(new wrb((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131368786)));
    b(new wrw((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131380675)));
    b(new wst(this.jdField_a_of_type_AndroidViewView.findViewById(2131380644)));
    b(new wsq((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131380740)));
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561694, paramViewGroup, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((wsr)localIterator.next()).a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull wsk paramwsk, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramwsk, paramStoryPlayerGroupHolder);
    xvv.a(this.jdField_a_of_type_JavaLangString, "onBind, newVer=%d, newHor=%d, data=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), paramwsk);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((wsr)localIterator.next()).a(paramInt1, paramInt2, paramwsk, paramStoryPlayerGroupHolder);
    }
  }
  
  public void a(wry paramwry)
  {
    super.a(paramwry);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((wsr)localIterator.next()).a(paramwry);
    }
  }
  
  public void a(wss paramwss)
  {
    super.a(this);
    paramwss = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (paramwss.hasNext()) {
      ((wsr)paramwss.next()).a(this);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((wsr)localIterator.next()).a(paramBoolean);
    }
  }
  
  @Nullable
  public wsr b(Class<? extends wsr> paramClass)
  {
    return (wsr)this.jdField_a_of_type_JavaUtilMap.get(paramClass.getName());
  }
  
  public void b()
  {
    super.b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((wsr)localIterator.next()).b();
    }
  }
  
  public void b(@NonNull wsr paramwsr)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramwsr.getClass().getName(), paramwsr);
  }
  
  public void c()
  {
    super.c();
    xvv.a(this.jdField_a_of_type_JavaLangString, "onUnBind, verticalPosition=%d, horizontalPosition=%d, data=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_Wsk);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((wsr)localIterator.next()).c();
    }
  }
  
  public boolean c()
  {
    return super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wss
 * JD-Core Version:    0.7.0.1
 */