import com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleLoaderHelper.DummyCallback.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class tmo
  implements nuw
{
  private final String jdField_a_of_type_JavaLangString;
  private final String b;
  
  public tmo(tmn paramtmn, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public void a(String paramString, int paramInt)
  {
    QLog.d("TemplateFactory", 1, "loaded: bid : " + this.jdField_a_of_type_JavaLangString + " param " + paramString + " code : " + paramInt);
    if ((paramInt != 0) || (paramString == null)) {}
    try
    {
      QLog.d("TemplateFactory", 2, "下载离线样式包完成 : " + this.jdField_a_of_type_JavaLangString);
      tmz.a(tmn.a(this.jdField_a_of_type_Tmn));
      if ((paramString == null) && (tmz.a(this.jdField_a_of_type_JavaLangString).a))
      {
        QLog.d("TemplateFactory", 1, "加载离线包 : " + this.jdField_a_of_type_JavaLangString);
        usp.a(2, tmn.a(this.jdField_a_of_type_Tmn));
        this.jdField_a_of_type_Tmn.b(this.jdField_a_of_type_JavaLangString);
        bmhv.a("kandian_pts_style_update", Boolean.valueOf(true));
        tmk.a().b();
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("TemplateFactory", 1, "loaded: bid : " + this.jdField_a_of_type_JavaLangString, paramString);
    }
  }
  
  public void loaded(String paramString, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new StyleLoaderHelper.DummyCallback.1(this, paramString, paramInt));
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tmo
 * JD-Core Version:    0.7.0.1
 */