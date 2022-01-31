import java.util.List;

public class ufn
{
  public int a;
  public String a;
  public List<String> a;
  public int b;
  public String b;
  public int c;
  
  public ufn() {}
  
  public ufn(uea paramuea)
  {
    this.jdField_a_of_type_Int = paramuea.jdField_e_of_type_Int;
    if (paramuea.g > 0) {}
    for (int i = paramuea.g;; i = ufm.a(this.jdField_a_of_type_Int))
    {
      this.jdField_b_of_type_Int = i;
      this.jdField_a_of_type_JavaLangString = paramuea.jdField_e_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = paramuea.d;
      this.c = paramuea.f;
      this.jdField_a_of_type_JavaUtilList = paramuea.jdField_a_of_type_JavaUtilList;
      return;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("BaseSplitConfig =[");
    localStringBuilder1.append(" type=").append(this.jdField_a_of_type_Int);
    localStringBuilder1.append(" mTransId=").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder1.append(" mTextId=").append(this.c);
    localStringBuilder1.append(" mAlbumMinPicCount=").append(this.jdField_b_of_type_Int);
    localStringBuilder1.append(" mAlbumDesc=").append(this.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(" mTransList=");
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (String str = "";; str = this.jdField_a_of_type_JavaUtilList.toString())
    {
      localStringBuilder2.append(str);
      localStringBuilder1.append("]");
      return localStringBuilder1.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ufn
 * JD-Core Version:    0.7.0.1
 */