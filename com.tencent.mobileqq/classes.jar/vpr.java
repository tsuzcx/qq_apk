import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;

public abstract class vpr
  extends voz
{
  public int a;
  @NonNull
  public final View a;
  public StoryPlayerGroupHolder a;
  public String a;
  public vpk a;
  protected vps a;
  protected boolean a;
  public int b;
  private final String b;
  protected boolean b;
  
  public vpr(@NonNull ViewGroup paramViewGroup)
  {
    this.jdField_b_of_type_JavaLangString = ("Q.qqstory.playernew." + getClass().getSimpleName());
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + System.identityHashCode(this));
    this.jdField_a_of_type_AndroidViewView = a(paramViewGroup);
  }
  
  protected abstract View a(ViewGroup paramViewGroup);
  
  public vpr a(Class<? extends vpr> paramClass)
  {
    if (this.jdField_a_of_type_Vps != null) {
      return this.jdField_a_of_type_Vps.b(paramClass);
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + System.identityHashCode(this) + "[" + paramInt1 + "," + paramInt2 + "]");
    wsv.a(this.jdField_a_of_type_JavaLangString, "onPositionChanged, oldVer=%d, oldHor=%d, newVer=%d, newHor=%d", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, @NonNull vpk paramvpk, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    this.jdField_a_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + System.identityHashCode(this) + "[" + paramInt1 + "," + paramInt2 + "]");
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Vpk = paramvpk;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder = paramStoryPlayerGroupHolder;
  }
  
  void a(vps paramvps)
  {
    this.jdField_a_of_type_Vps = paramvps;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      b(this.jdField_b_of_type_Boolean);
      return;
    }
    wsv.e(this.jdField_a_of_type_JavaLangString, "onSelected donot changed !");
  }
  
  protected void b() {}
  
  protected void b(boolean paramBoolean)
  {
    wsv.b(this.jdField_a_of_type_JavaLangString, "onSelectedChanged (ver=%d, hor=%d) , => %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Boolean.valueOf(paramBoolean));
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Vpk = null;
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
    return "VideoHolderBase{, GroupPos=" + this.jdField_a_of_type_Int + ", VideoPos=" + this.jdField_b_of_type_Int + ", mData=" + this.jdField_a_of_type_Vpk + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vpr
 * JD-Core Version:    0.7.0.1
 */