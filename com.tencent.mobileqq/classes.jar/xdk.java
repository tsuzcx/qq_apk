import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;

class xdk
  implements QzoneZipCacheHelperCallBack
{
  xdk(xdi paramxdi, String paramString1, String paramString2, String paramString3) {}
  
  public void onResult(boolean paramBoolean)
  {
    xdi.a(this.jdField_a_of_type_Xdi, paramBoolean, this.jdField_a_of_type_JavaLangString, this.b, this.c);
  }
  
  public void onResultOfNativeRequest(boolean paramBoolean, String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xdk
 * JD-Core Version:    0.7.0.1
 */