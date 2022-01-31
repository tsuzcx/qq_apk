import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class vsi
  extends vti
{
  public int a;
  @NonNull
  public final View a;
  protected String a;
  public List<vtt> a;
  public vpm a;
  protected vsj a;
  protected boolean a;
  private final String b = "Q.qqstory.playernew." + getClass().getSimpleName();
  
  public vsi(@NonNull View paramView)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = Collections.emptyList();
    this.jdField_a_of_type_JavaLangString = (this.b + System.identityHashCode(this));
    if ((paramView instanceof ViewGroup))
    {
      this.jdField_a_of_type_AndroidViewView = a((ViewGroup)paramView);
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public vsi(@NonNull ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = Collections.emptyList();
    this.jdField_a_of_type_JavaLangString = (this.b + System.identityHashCode(this));
    this.jdField_a_of_type_AndroidViewView = a(paramViewGroup);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidViewView.getVisibility();
  }
  
  protected abstract View a(ViewGroup paramViewGroup);
  
  public vsi a(Class<? extends vsi> paramClass)
  {
    if (this.jdField_a_of_type_Vsj != null) {
      return this.jdField_a_of_type_Vsj.b(paramClass);
    }
    return null;
  }
  
  public vsj a()
  {
    return this.jdField_a_of_type_Vsj;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
  }
  
  public void a(int paramInt, vpn paramvpn, @NonNull ArrayList<vtt> paramArrayList)
  {
    this.jdField_a_of_type_JavaLangString = (this.b + System.identityHashCode(this) + "[" + paramInt + "]");
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Vpm = paramvpn.jdField_a_of_type_Vpm;
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      vtt localvtt = (vtt)localIterator.next();
      if ((paramvpn.jdField_a_of_type_Vpm instanceof vqa)) {
        localvtt.a = ((vqa)paramvpn.jdField_a_of_type_Vpm).a;
      } else {
        localvtt.a = null;
      }
    }
    this.jdField_a_of_type_JavaUtilList = paramArrayList;
    this.jdField_a_of_type_Boolean = true;
  }
  
  void a(vsj paramvsj)
  {
    this.jdField_a_of_type_Vsj = paramvsj;
  }
  
  protected void b() {}
  
  public void c()
  {
    wxe.a(this.jdField_a_of_type_JavaLangString, "onUnBind, position=%d, data.size=%d, groupId=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), this.jdField_a_of_type_Vpm.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vsi
 * JD-Core Version:    0.7.0.1
 */