import com.tencent.qphone.base.util.QLog;

class zzx
  extends bgod
{
  zzx(zzu paramzzu, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onDone(bgoe parambgoe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViewPluginLoader", 2, "downloadUpdate loaded json = " + parambgoe.c + " code = " + parambgoe.jdField_a_of_type_Int);
    }
    boolean bool = this.jdField_a_of_type_Zzu.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.b);
    if (QLog.isColorLevel()) {
      QLog.d("ViewPluginLoader", 2, "downloadUpdate unCompressOffline" + bool);
    }
    this.jdField_a_of_type_Zzu.a();
  }
  
  public void onProgress(bgoe parambgoe)
  {
    int i = (int)(parambgoe.jdField_a_of_type_Float * 100.0F);
    if (((i % 10 == 0) || (i > 90)) && (QLog.isColorLevel())) {
      QLog.d("ViewPluginLoader", 2, "downding progress = " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzx
 * JD-Core Version:    0.7.0.1
 */