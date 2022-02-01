import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;

public abstract class wsr
  extends wrz
{
  public int a;
  @NonNull
  public final View a;
  public StoryPlayerGroupHolder a;
  public String a;
  public wsk a;
  protected wss a;
  protected boolean a;
  public int b;
  private final String b;
  protected boolean b;
  
  public wsr(@NonNull ViewGroup paramViewGroup)
  {
    this.jdField_b_of_type_JavaLangString = ("Q.qqstory.playernew." + getClass().getSimpleName());
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + System.identityHashCode(this));
    this.jdField_a_of_type_AndroidViewView = a(paramViewGroup);
  }
  
  protected abstract View a(ViewGroup paramViewGroup);
  
  public wsr a(Class<? extends wsr> paramClass)
  {
    if (this.jdField_a_of_type_Wss != null) {
      return this.jdField_a_of_type_Wss.b(paramClass);
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + System.identityHashCode(this) + "[" + paramInt1 + "," + paramInt2 + "]");
    xvv.a(this.jdField_a_of_type_JavaLangString, "onPositionChanged, oldVer=%d, oldHor=%d, newVer=%d, newHor=%d", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull wsk paramwsk, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    this.jdField_a_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + System.identityHashCode(this) + "[" + paramInt1 + "," + paramInt2 + "]");
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Wsk = paramwsk;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder = paramStoryPlayerGroupHolder;
  }
  
  void a(wss paramwss)
  {
    this.jdField_a_of_type_Wss = paramwss;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      b(this.jdField_b_of_type_Boolean);
      return;
    }
    xvv.e(this.jdField_a_of_type_JavaLangString, "onSelected donot changed !");
  }
  
  protected void b() {}
  
  protected void b(boolean paramBoolean)
  {
    xvv.b(this.jdField_a_of_type_JavaLangString, "onSelectedChanged (ver=%d, hor=%d) , => %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Boolean.valueOf(paramBoolean));
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Wsk = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder = null;
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String toString()
  {
    return "VideoHolderBase{, GroupPos=" + this.jdField_a_of_type_Int + ", VideoPos=" + this.jdField_b_of_type_Int + ", mData=" + this.jdField_a_of_type_Wsk + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsr
 * JD-Core Version:    0.7.0.1
 */