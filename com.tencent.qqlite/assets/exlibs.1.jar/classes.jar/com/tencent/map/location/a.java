package com.tencent.map.location;

public final class a
{
  private static a a = null;
  
  public static a a()
  {
    try
    {
      if (a == null) {
        a = new a();
      }
      a locala = a;
      return locala;
    }
    finally {}
  }
  
  public final boolean a(String paramString1, String paramString2)
  {
    if (!i.a(paramString1)) {}
    for (;;)
    {
      return false;
      if ((i.b(paramString2)) && (new Object()
      {
        public boolean a(String arg1, String arg2) {}
      }.a(paramString1, paramString2)))
      {
        int i = 0;
        int j = 0;
        while (i < 27)
        {
          j = i.jdField_a_of_type_ArrayOfInt[((j ^ i.a(paramString2.charAt(i))) & 0xFF)] ^ j >> 8 & 0xFF;
          i += 1;
        }
        if (paramString2.charAt(27) != i.jdField_a_of_type_JavaLangString.charAt(j & 0x1F)) {
          i = 0;
        }
        while (i != 0)
        {
          return true;
          if (paramString2.charAt(28) != i.jdField_a_of_type_JavaLangString.charAt(j >> 5 & 0x1F)) {
            i = 0;
          } else {
            i = 1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.map.location.a
 * JD-Core Version:    0.7.0.1
 */