package net.sourceforge.pinyin4j.format;

public class HanyuPinyinToneType
{
  public static final HanyuPinyinToneType WITHOUT_TONE = new HanyuPinyinToneType("WITHOUT_TONE");
  public static final HanyuPinyinToneType WITH_TONE_MARK = new HanyuPinyinToneType("WITH_TONE_MARK");
  public static final HanyuPinyinToneType WITH_TONE_NUMBER = new HanyuPinyinToneType("WITH_TONE_NUMBER");
  protected String name;
  
  protected HanyuPinyinToneType(String paramString)
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
 * Qualified Name:     net.sourceforge.pinyin4j.format.HanyuPinyinToneType
 * JD-Core Version:    0.7.0.1
 */