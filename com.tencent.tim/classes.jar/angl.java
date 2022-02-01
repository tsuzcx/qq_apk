import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import java.util.ArrayList;

class angl
  implements angp.a
{
  angl(angj paramangj, angp.b paramb) {}
  
  public void cu(int paramInt1, int paramInt2)
  {
    axiy.i(angj.access$000(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult] - BEGIN -, result=" + paramInt1 + ", serverError=" + paramInt2);
    if ((paramInt1 == 1) || (paramInt1 == 0)) {
      if (paramInt2 != 0)
      {
        axiy.i(angj.access$000(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], serverError");
        axiy.i(angj.access$000(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
        angj.b(this.jdField_a_of_type_Angj);
        if (this.jdField_a_of_type_Angp$b != null) {
          this.jdField_a_of_type_Angp$b.jy(paramInt1, paramInt2);
        }
      }
    }
    for (;;)
    {
      axiy.i(angj.access$000(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult] - END -, result=" + paramInt1 + ", serverError=" + paramInt2);
      return;
      ArrayList localArrayList = new ArrayList(1);
      if (ShortVideoResourceManager.a(angj.a(this.jdField_a_of_type_Angj), localArrayList) == 0)
      {
        axiy.i(angj.access$000(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], configList valid");
        angj.a(this.jdField_a_of_type_Angj).dPn();
        if (this.jdField_a_of_type_Angp$b != null) {
          this.jdField_a_of_type_Angp$b.jy(paramInt1, paramInt2);
        }
      }
      else
      {
        axiy.i(angj.access$000(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], configList invalid");
        axiy.i(angj.access$000(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
        angj.b(this.jdField_a_of_type_Angj);
        if (this.jdField_a_of_type_Angp$b != null)
        {
          this.jdField_a_of_type_Angp$b.jy(paramInt1, paramInt2);
          continue;
          axiy.i(angj.access$000(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], result invalid");
          axiy.i(angj.access$000(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
          angj.b(this.jdField_a_of_type_Angj);
          if (this.jdField_a_of_type_Angp$b != null) {
            this.jdField_a_of_type_Angp$b.jy(paramInt1, paramInt2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     angl
 * JD-Core Version:    0.7.0.1
 */