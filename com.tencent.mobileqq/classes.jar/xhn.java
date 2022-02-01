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

public class xhn
  extends xhm
{
  Map<String, xhm> a;
  
  public xhn(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    b(new VideoViewVideoHolder((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131381090)));
    b(new xfw((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131368945)));
    b(new xgr((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131381025)));
    b(new xho(this.jdField_a_of_type_AndroidViewView.findViewById(2131380992)));
    b(new xhl((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131381091)));
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561762, paramViewGroup, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((xhm)localIterator.next()).a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull xhf paramxhf, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    super.a(paramInt1, paramInt2, paramxhf, paramStoryPlayerGroupHolder);
    ykq.a(this.jdField_a_of_type_JavaLangString, "onBind, newVer=%d, newHor=%d, data=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), paramxhf);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((xhm)localIterator.next()).a(paramInt1, paramInt2, paramxhf, paramStoryPlayerGroupHolder);
    }
  }
  
  public void a(xgt paramxgt)
  {
    super.a(paramxgt);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((xhm)localIterator.next()).a(paramxgt);
    }
  }
  
  public void a(xhn paramxhn)
  {
    super.a(this);
    paramxhn = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (paramxhn.hasNext()) {
      ((xhm)paramxhn.next()).a(this);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((xhm)localIterator.next()).a(paramBoolean);
    }
  }
  
  @Nullable
  public xhm b(Class<? extends xhm> paramClass)
  {
    return (xhm)this.jdField_a_of_type_JavaUtilMap.get(paramClass.getName());
  }
  
  public void b()
  {
    super.b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((xhm)localIterator.next()).b();
    }
  }
  
  public void b(@NonNull xhm paramxhm)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramxhm.getClass().getName(), paramxhm);
  }
  
  public void c()
  {
    super.c();
    ykq.a(this.jdField_a_of_type_JavaLangString, "onUnBind, verticalPosition=%d, horizontalPosition=%d, data=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b), this.jdField_a_of_type_Xhf);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((xhm)localIterator.next()).c();
    }
  }
  
  public boolean c()
  {
    return super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xhn
 * JD-Core Version:    0.7.0.1
 */