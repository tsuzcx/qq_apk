package com.google.common.base;

 enum CaseFormat$5
{
  CaseFormat$5(CharMatcher paramCharMatcher, String paramString)
  {
    super(???, ???, paramCharMatcher, paramString, null);
  }
  
  String convert(CaseFormat paramCaseFormat, String paramString)
  {
    if (paramCaseFormat == LOWER_HYPHEN) {
      return Ascii.toLowerCase(paramString.replace('_', '-'));
    }
    if (paramCaseFormat == LOWER_UNDERSCORE) {
      return Ascii.toLowerCase(paramString);
    }
    return super.convert(paramCaseFormat, paramString);
  }
  
  String normalizeWord(String paramString)
  {
    return Ascii.toUpperCase(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.CaseFormat.5
 * JD-Core Version:    0.7.0.1
 */