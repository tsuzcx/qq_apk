import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;

public abstract class tog
  extends tno
{
  public int a;
  @NonNull
  public final View a;
  public StoryPlayerGroupHolder a;
  public String a;
  public tnz a;
  protected toh a;
  protected boolean a;
  public int b;
  private final String b;
  protected boolean b;
  
  public tog(@NonNull ViewGroup paramViewGroup)
  {
    this.jdField_b_of_type_JavaLangString = ("Q.qqstory.playernew." + getClass().getSimpleName());
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + System.identityHashCode(this));
    this.jdField_a_of_type_AndroidViewView = a(paramViewGroup);
  }
  
  protected abstract View a(ViewGroup paramViewGroup);
  
  public tog a(Class<? extends tog> paramClass)
  {
    if (this.jdField_a_of_type_Toh != null) {
      return this.jdField_a_of_type_Toh.b(paramClass);
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + System.identityHashCode(this) + "[" + paramInt1 + "," + paramInt2 + "]");
    urk.a(this.jdField_a_of_type_JavaLangString, "onPositionChanged, oldVer=%d, oldHor=%d, newVer=%d, newHor=%d", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull tnz paramtnz, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    this.jdField_a_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + System.identityHashCode(this) + "[" + paramInt1 + "," + paramInt2 + "]");
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Tnz = paramtnz;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder = paramStoryPlayerGroupHolder;
  }
  
  void a(toh paramtoh)
  {
    this.jdField_a_of_type_Toh = paramtoh;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      b(this.jdField_b_of_type_Boolean);
      return;
    }
    urk.e(this.jdField_a_of_type_JavaLangString, "onSelected donot changed !");
  }
  
  protected void b() {}
  
  protected void b(boolean paramBoolean)
  {
    urk.b(this.jdField_a_of_type_JavaLangString, "onSelectedChanged (ver=%d, hor=%d) , => %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Boolean.valueOf(paramBoolean));
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Tnz = null;
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
    return "VideoHolderBase{, GroupPos=" + this.jdField_a_of_type_Int + ", VideoPos=" + this.jdField_b_of_type_Int + ", mData=" + this.jdField_a_of_type_Tnz + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tog
 * JD-Core Version:    0.7.0.1
 */