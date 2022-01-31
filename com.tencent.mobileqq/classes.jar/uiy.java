import java.util.HashMap;

class uiy
  implements bapw
{
  uiy(uiw paramuiw) {}
  
  public void a(baqv parambaqv, baqw parambaqw)
  {
    if ((parambaqv == null) || (parambaqw == null)) {}
    while (!(parambaqv instanceof baps)) {
      return;
    }
    baps localbaps = (baps)parambaqv;
    localbaps.jdField_a_of_type_Long += parambaqw.c;
    parambaqw.c = 0L;
    parambaqw = "bytes=" + localbaps.jdField_a_of_type_Long + "-";
    localbaps.jdField_a_of_type_JavaUtilHashMap.put("Range", parambaqw);
    String str1 = localbaps.jdField_a_of_type_JavaLangString;
    if (str1.contains("range="))
    {
      String str2 = str1.substring(0, str1.lastIndexOf("range="));
      localbaps.jdField_a_of_type_JavaLangString = (str2 + "range=" + localbaps.jdField_a_of_type_Long);
    }
    parambaqv = parambaqv.a();
    if ((parambaqv != null) && ((parambaqv instanceof uja))) {
      ((uja)parambaqv).b = true;
    }
    wsv.b("AsyncFileDownloader", String.format("breakDown , range = %s , url = %s", new Object[] { parambaqw, str1 }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uiy
 * JD-Core Version:    0.7.0.1
 */