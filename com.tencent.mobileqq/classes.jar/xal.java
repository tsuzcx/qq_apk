import com.tencent.qphone.base.util.QLog;

class xal
  extends batl
{
  xal(xai paramxai, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onDone(batm parambatm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViewPluginLoader", 2, "downloadUpdate loaded json = " + parambatm.c + " code = " + parambatm.jdField_a_of_type_Int);
    }
    boolean bool = this.jdField_a_of_type_Xai.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.b);
    if (QLog.isColorLevel()) {
      QLog.d("ViewPluginLoader", 2, "downloadUpdate unCompressOffline" + bool);
    }
    this.jdField_a_of_type_Xai.a();
  }
  
  public void onProgress(batm parambatm)
  {
    int i = (int)(parambatm.jdField_a_of_type_Float * 100.0F);
    if (((i % 10 == 0) || (i > 90)) && (QLog.isColorLevel())) {
      QLog.d("ViewPluginLoader", 2, "downding progress = " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     xal
 * JD-Core Version:    0.7.0.1
 */