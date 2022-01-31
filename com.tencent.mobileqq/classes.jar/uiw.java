import com.tencent.common.app.AppInterface;

class uiw
  implements uiz
{
  protected bapw a;
  
  private uiw(uir paramuir)
  {
    this.jdField_a_of_type_Bapw = new uiy(this);
  }
  
  protected bapv a()
  {
    AppInterface localAppInterface = blmf.a();
    if (localAppInterface != null) {
      return localAppInterface.getNetEngine(0);
    }
    return null;
  }
  
  public void a(uja paramuja)
  {
    paramuja.jdField_d_of_type_Int = 0;
    baps localbaps = new baps();
    localbaps.jdField_a_of_type_JavaLangString = paramuja.jdField_d_of_type_JavaLangString;
    localbaps.jdField_a_of_type_Int = 0;
    localbaps.jdField_c_of_type_JavaLangString = paramuja.e;
    localbaps.jdField_d_of_type_JavaLangString = paramuja.f;
    localbaps.e = paramuja.g;
    localbaps.jdField_c_of_type_Int = 3;
    localbaps.a(paramuja);
    localbaps.jdField_a_of_type_Bapw = this.jdField_a_of_type_Bapw;
    paramuja.a = localbaps;
    localbaps.jdField_a_of_type_Bapx = new uix(this);
    bapv localbapv = a();
    if (localbapv != null) {
      localbapv.a(localbaps);
    }
    wsv.a("AsyncFileDownloader", "start download with base downloader, task = %s", paramuja);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(uja paramuja)
  {
    baps localbaps = paramuja.a;
    if (localbaps != null)
    {
      if (a() != null) {
        a().b(localbaps);
      }
      wsv.b("AsyncFileDownloader", String.format("cancel task with base downloader, task = %s", new Object[] { paramuja }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uiw
 * JD-Core Version:    0.7.0.1
 */