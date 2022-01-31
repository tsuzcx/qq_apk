import com.tencent.common.app.AppInterface;

class unf
  implements uni
{
  protected bauf a;
  
  private unf(una paramuna)
  {
    this.jdField_a_of_type_Bauf = new unh(this);
  }
  
  protected baue a()
  {
    AppInterface localAppInterface = blqr.a();
    if (localAppInterface != null) {
      return localAppInterface.getNetEngine(0);
    }
    return null;
  }
  
  public void a(unj paramunj)
  {
    paramunj.jdField_d_of_type_Int = 0;
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_JavaLangString = paramunj.jdField_d_of_type_JavaLangString;
    localbaub.jdField_a_of_type_Int = 0;
    localbaub.jdField_c_of_type_JavaLangString = paramunj.e;
    localbaub.jdField_d_of_type_JavaLangString = paramunj.f;
    localbaub.e = paramunj.g;
    localbaub.jdField_c_of_type_Int = 3;
    localbaub.a(paramunj);
    localbaub.jdField_a_of_type_Bauf = this.jdField_a_of_type_Bauf;
    paramunj.a = localbaub;
    localbaub.jdField_a_of_type_Baug = new ung(this);
    baue localbaue = a();
    if (localbaue != null) {
      localbaue.a(localbaub);
    }
    wxe.a("AsyncFileDownloader", "start download with base downloader, task = %s", paramunj);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(unj paramunj)
  {
    baub localbaub = paramunj.a;
    if (localbaub != null)
    {
      if (a() != null) {
        a().b(localbaub);
      }
      wxe.b("AsyncFileDownloader", String.format("cancel task with base downloader, task = %s", new Object[] { paramunj }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     unf
 * JD-Core Version:    0.7.0.1
 */