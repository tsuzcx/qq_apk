package com.google.common.base;

 enum CaseFormat$1
{
  CaseFormat$1(CharMatcher paramCharMatcher, String paramString)
  {
    super(???, ???, paramCharMatcher, paramString, null);
  }
  
  String convert(CaseFormat paramCaseFormat, String paramString)
  {
    if (paramCaseFormat == LOWER_UNDERSCORE) {
      return paramString.replace('-', '_');
    }
    if (paramCaseFormat == UPPER_UNDERSCORE) {
      return Ascii.toUpperCase(paramString.replace('-', '_'));
    }
    return super.convert(paramCaseFormat, paramString);
  }
  
  String normalizeWord(String paramString)
  {
    return Ascii.toLowerCase(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.CaseFormat.1
 * JD-Core Version:    0.7.0.1
 */