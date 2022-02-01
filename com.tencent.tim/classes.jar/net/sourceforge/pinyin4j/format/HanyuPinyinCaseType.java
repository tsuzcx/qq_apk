package net.sourceforge.pinyin4j.format;

public class HanyuPinyinCaseType
{
  public static final HanyuPinyinCaseType LOWERCASE = new HanyuPinyinCaseType("LOWERCASE");
  public static final HanyuPinyinCaseType UPPERCASE = new HanyuPinyinCaseType("UPPERCASE");
  protected String name;
  
  protected HanyuPinyinCaseType(String paramString)
  {
    setName(paramString);
  }
  
  public String getName()
  {
    return this.name;
  }
  
  protected void setName(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.sourceforge.pinyin4j.format.HanyuPinyinCaseType
 * JD-Core Version:    0.7.0.1
 */