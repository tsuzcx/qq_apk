package net.sourceforge.pinyin4j;

class PinyinRomanizationType
{
  static final PinyinRomanizationType GWOYEU_ROMATZYH = new PinyinRomanizationType("Gwoyeu");
  static final PinyinRomanizationType HANYU_PINYIN = new PinyinRomanizationType("Hanyu");
  static final PinyinRomanizationType MPS2_PINYIN;
  static final PinyinRomanizationType TONGYONG_PINYIN;
  static final PinyinRomanizationType WADEGILES_PINYIN = new PinyinRomanizationType("Wade");
  static final PinyinRomanizationType YALE_PINYIN;
  protected String tagName;
  
  static
  {
    MPS2_PINYIN = new PinyinRomanizationType("MPSII");
    YALE_PINYIN = new PinyinRomanizationType("Yale");
    TONGYONG_PINYIN = new PinyinRomanizationType("Tongyong");
  }
  
  protected PinyinRomanizationType(String paramString)
  {
    setTagName(paramString);
  }
  
  String getTagName()
  {
    return this.tagName;
  }
  
  protected void setTagName(String paramString)
  {
    this.tagName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.sourceforge.pinyin4j.PinyinRomanizationType
 * JD-Core Version:    0.7.0.1
 */