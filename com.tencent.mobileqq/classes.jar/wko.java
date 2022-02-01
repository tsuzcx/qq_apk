import java.util.HashMap;

class wko
  implements beup
{
  wko(wkm paramwkm) {}
  
  public void a(bevl parambevl, bevm parambevm)
  {
    if ((parambevl == null) || (parambevm == null)) {}
    while (!(parambevl instanceof beum)) {
      return;
    }
    beum localbeum = (beum)parambevl;
    localbeum.jdField_a_of_type_Long += parambevm.c;
    parambevm.c = 0L;
    parambevm = "bytes=" + localbeum.jdField_a_of_type_Long + "-";
    localbeum.jdField_a_of_type_JavaUtilHashMap.put("Range", parambevm);
    String str1 = localbeum.jdField_a_of_type_JavaLangString;
    if (str1.contains("range="))
    {
      String str2 = str1.substring(0, str1.lastIndexOf("range="));
      localbeum.jdField_a_of_type_JavaLangString = (str2 + "range=" + localbeum.jdField_a_of_type_Long);
    }
    parambevl = parambevl.a();
    if ((parambevl != null) && ((parambevl instanceof wkq))) {
      ((wkq)parambevl).b = true;
    }
    yuk.b("AsyncFileDownloader", String.format("breakDown , range = %s , url = %s", new Object[] { parambevm, str1 }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wko
 * JD-Core Version:    0.7.0.1
 */