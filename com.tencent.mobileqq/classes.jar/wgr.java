import com.tencent.common.app.AppInterface;

class wgr
  implements wgu
{
  protected bdvv a;
  
  private wgr(wgm paramwgm)
  {
    this.jdField_a_of_type_Bdvv = new wgt(this);
  }
  
  protected bdvu a()
  {
    AppInterface localAppInterface = bojv.a();
    if (localAppInterface != null) {
      return localAppInterface.getNetEngine(0);
    }
    return null;
  }
  
  public void a(wgv paramwgv)
  {
    paramwgv.jdField_d_of_type_Int = 0;
    bdvs localbdvs = new bdvs();
    localbdvs.jdField_a_of_type_JavaLangString = paramwgv.jdField_d_of_type_JavaLangString;
    localbdvs.jdField_a_of_type_Int = 0;
    localbdvs.c = paramwgv.e;
    localbdvs.jdField_d_of_type_JavaLangString = paramwgv.f;
    localbdvs.jdField_d_of_type_Int = paramwgv.g;
    localbdvs.b = 3;
    localbdvs.a(paramwgv);
    localbdvs.jdField_a_of_type_Bdvv = this.jdField_a_of_type_Bdvv;
    paramwgv.a = localbdvs;
    localbdvs.jdField_a_of_type_Bdvw = new wgs(this);
    bdvu localbdvu = a();
    if (localbdvu != null) {
      localbdvu.a(localbdvs);
    }
    yqp.a("AsyncFileDownloader", "start download with base downloader, task = %s", paramwgv);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(wgv paramwgv)
  {
    bdvs localbdvs = paramwgv.a;
    if (localbdvs != null)
    {
      if (a() != null) {
        a().b(localbdvs);
      }
      yqp.b("AsyncFileDownloader", String.format("cancel task with base downloader, task = %s", new Object[] { paramwgv }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgr
 * JD-Core Version:    0.7.0.1
 */