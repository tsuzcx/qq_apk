import com.tencent.common.app.AppInterface;

class wkm
  implements wkp
{
  protected beup a;
  
  private wkm(wkh paramwkh)
  {
    this.jdField_a_of_type_Beup = new wko(this);
  }
  
  protected beuo a()
  {
    AppInterface localAppInterface = bplq.a();
    if (localAppInterface != null) {
      return localAppInterface.getNetEngine(0);
    }
    return null;
  }
  
  public void a(wkq paramwkq)
  {
    paramwkq.jdField_d_of_type_Int = 0;
    beum localbeum = new beum();
    localbeum.jdField_a_of_type_JavaLangString = paramwkq.jdField_d_of_type_JavaLangString;
    localbeum.jdField_a_of_type_Int = 0;
    localbeum.c = paramwkq.e;
    localbeum.jdField_d_of_type_JavaLangString = paramwkq.f;
    localbeum.jdField_d_of_type_Int = paramwkq.g;
    localbeum.b = 3;
    localbeum.a(paramwkq);
    localbeum.jdField_a_of_type_Beup = this.jdField_a_of_type_Beup;
    paramwkq.a = localbeum;
    localbeum.jdField_a_of_type_Beuq = new wkn(this);
    beuo localbeuo = a();
    if (localbeuo != null) {
      localbeuo.a(localbeum);
    }
    yuk.a("AsyncFileDownloader", "start download with base downloader, task = %s", paramwkq);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(wkq paramwkq)
  {
    beum localbeum = paramwkq.a;
    if (localbeum != null)
    {
      if (a() != null) {
        a().b(localbeum);
      }
      yuk.b("AsyncFileDownloader", String.format("cancel task with base downloader, task = %s", new Object[] { paramwkq }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wkm
 * JD-Core Version:    0.7.0.1
 */