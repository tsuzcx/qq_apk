public class xaj
  implements Cloneable
{
  public final int a;
  public final String a;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  public final String g;
  public String h;
  
  public xaj(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = null;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
    this.g = paramString6;
    this.jdField_a_of_type_Int = 1;
  }
  
  public xaj(vcw paramvcw)
  {
    this.jdField_a_of_type_JavaLangString = paramvcw.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramvcw.jdField_b_of_type_JavaLangString;
    this.c = paramvcw.c;
    this.d = paramvcw.d;
    this.e = paramvcw.e;
    this.f = paramvcw.g;
    this.g = paramvcw.f;
    this.jdField_a_of_type_Int = paramvcw.jdField_b_of_type_Int;
  }
  
  public String a()
  {
    return this.h;
  }
  
  public void a(String paramString)
  {
    this.h = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (xaj)paramObject;
    return this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString);
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_JavaLangString.hashCode();
  }
  
  public String toString()
  {
    return "DoodleEmojiItem{mPackId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mLogoUrl='" + this.jdField_b_of_type_JavaLangString + '\'' + ", mDownloadLogoUrl='" + this.c + '\'' + ", mPackName='" + this.d + '\'' + ", mPackDownloadUrl='" + this.e + '\'' + ", mPackMd5='" + this.g + '\'' + ", mLocalEmojiFolderPath='" + this.h + '\'' + ", mConfig='" + this.f + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xaj
 * JD-Core Version:    0.7.0.1
 */