package net.sourceforge.pinyin4j.format;

public final class HanyuPinyinOutputFormat
{
  private HanyuPinyinCaseType caseType;
  private HanyuPinyinToneType toneType;
  private HanyuPinyinVCharType vCharType;
  
  public HanyuPinyinOutputFormat()
  {
    restoreDefault();
  }
  
  public HanyuPinyinCaseType getCaseType()
  {
    return this.caseType;
  }
  
  public HanyuPinyinToneType getToneType()
  {
    return this.toneType;
  }
  
  public HanyuPinyinVCharType getVCharType()
  {
    return this.vCharType;
  }
  
  public void restoreDefault()
  {
    this.vCharType = HanyuPinyinVCharType.WITH_U_AND_COLON;
    this.caseType = HanyuPinyinCaseType.LOWERCASE;
    this.toneType = HanyuPinyinToneType.WITH_TONE_NUMBER;
  }
  
  public void setCaseType(HanyuPinyinCaseType paramHanyuPinyinCaseType)
  {
    this.caseType = paramHanyuPinyinCaseType;
  }
  
  public void setToneType(HanyuPinyinToneType paramHanyuPinyinToneType)
  {
    this.toneType = paramHanyuPinyinToneType;
  }
  
  public void setVCharType(HanyuPinyinVCharType paramHanyuPinyinVCharType)
  {
    this.vCharType = paramHanyuPinyinVCharType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat
 * JD-Core Version:    0.7.0.1
 */