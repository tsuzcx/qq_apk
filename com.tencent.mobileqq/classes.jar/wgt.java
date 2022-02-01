import java.util.HashMap;

class wgt
  implements bdvv
{
  wgt(wgr paramwgr) {}
  
  public void a(bdws parambdws, bdwt parambdwt)
  {
    if ((parambdws == null) || (parambdwt == null)) {}
    while (!(parambdws instanceof bdvs)) {
      return;
    }
    bdvs localbdvs = (bdvs)parambdws;
    localbdvs.jdField_a_of_type_Long += parambdwt.c;
    parambdwt.c = 0L;
    parambdwt = "bytes=" + localbdvs.jdField_a_of_type_Long + "-";
    localbdvs.jdField_a_of_type_JavaUtilHashMap.put("Range", parambdwt);
    String str1 = localbdvs.jdField_a_of_type_JavaLangString;
    if (str1.contains("range="))
    {
      String str2 = str1.substring(0, str1.lastIndexOf("range="));
      localbdvs.jdField_a_of_type_JavaLangString = (str2 + "range=" + localbdvs.jdField_a_of_type_Long);
    }
    parambdws = parambdws.a();
    if ((parambdws != null) && ((parambdws instanceof wgv))) {
      ((wgv)parambdws).b = true;
    }
    yqp.b("AsyncFileDownloader", String.format("breakDown , range = %s , url = %s", new Object[] { parambdwt, str1 }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgt
 * JD-Core Version:    0.7.0.1
 */