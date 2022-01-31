import java.util.HashMap;

class unh
  implements bauf
{
  unh(unf paramunf) {}
  
  public void a(bave parambave, bavf parambavf)
  {
    if ((parambave == null) || (parambavf == null)) {}
    while (!(parambave instanceof baub)) {
      return;
    }
    baub localbaub = (baub)parambave;
    localbaub.jdField_a_of_type_Long += parambavf.c;
    parambavf.c = 0L;
    parambavf = "bytes=" + localbaub.jdField_a_of_type_Long + "-";
    localbaub.jdField_a_of_type_JavaUtilHashMap.put("Range", parambavf);
    String str1 = localbaub.jdField_a_of_type_JavaLangString;
    if (str1.contains("range="))
    {
      String str2 = str1.substring(0, str1.lastIndexOf("range="));
      localbaub.jdField_a_of_type_JavaLangString = (str2 + "range=" + localbaub.jdField_a_of_type_Long);
    }
    parambave = parambave.a();
    if ((parambave != null) && ((parambave instanceof unj))) {
      ((unj)parambave).b = true;
    }
    wxe.b("AsyncFileDownloader", String.format("breakDown , range = %s , url = %s", new Object[] { parambavf, str1 }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     unh
 * JD-Core Version:    0.7.0.1
 */