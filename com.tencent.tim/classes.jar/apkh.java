import com.tencent.qphone.base.util.QLog;

class apkh
  extends aquy
{
  apkh(apke paramapke, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onDone(aquz paramaquz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "downloadUpdate loaded json = " + paramaquz.currUrl + " code = " + paramaquz.errCode);
    }
    boolean bool = apke.a(this.this$0, this.aGi, this.aMQ, this.aMR);
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "downloadUpdate unCompressOffline " + bool);
    }
    apke.b(this.this$0);
  }
  
  public void onProgress(aquz paramaquz)
  {
    int i = (int)(paramaquz.fj * 100.0F);
    if (((i % 10 == 0) || (i > 90)) && (QLog.isColorLevel())) {
      QLog.d("SoLibraryLoader", 2, "downding progress = " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apkh
 * JD-Core Version:    0.7.0.1
 */