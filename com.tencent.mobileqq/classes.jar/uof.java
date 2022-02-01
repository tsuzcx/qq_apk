import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import java.util.ArrayList;

public class uof
  extends uoe<ArrayList<stSimpleMetaFeed>>
{
  protected int a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public uof()
  {
    this.jdField_a_of_type_JavaLangObject = new ArrayList();
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  }
  
  private boolean b(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    return ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (a() == 0)) || (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramstSimpleMetaFeed.poster_id));
  }
  
  public int a()
  {
    return ((ArrayList)this.jdField_a_of_type_JavaLangObject).size();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean) {
      ulf.a().a(a());
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed == null) || (!b(paramstSimpleMetaFeed))) {
      return false;
    }
    this.jdField_a_of_type_JavaLangString = paramstSimpleMetaFeed.poster_id;
    this.jdField_a_of_type_JavaLangStringBuilder.append(paramstSimpleMetaFeed.id);
    ((ArrayList)this.jdField_a_of_type_JavaLangObject).add(paramstSimpleMetaFeed);
    return true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uof
 * JD-Core Version:    0.7.0.1
 */