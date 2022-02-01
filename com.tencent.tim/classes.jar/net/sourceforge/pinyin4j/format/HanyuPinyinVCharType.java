package net.sourceforge.pinyin4j.format;

public class HanyuPinyinVCharType
{
  public static final HanyuPinyinVCharType WITH_U_AND_COLON = new HanyuPinyinVCharType("WITH_U_AND_COLON");
  public static final HanyuPinyinVCharType WITH_U_UNICODE = new HanyuPinyinVCharType("WITH_U_UNICODE");
  public static final HanyuPinyinVCharType WITH_V = new HanyuPinyinVCharType("WITH_V");
  protected String name;
  
  protected HanyuPinyinVCharType(String paramString)
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
 * Qualified Name:     net.sourceforge.pinyin4j.format.HanyuPinyinVCharType
 * JD-Core Version:    0.7.0.1
 */