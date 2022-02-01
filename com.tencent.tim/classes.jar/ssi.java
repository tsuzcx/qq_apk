import com.tencent.qphone.base.util.QLog;

class ssi
  extends aquy
{
  ssi(ssf paramssf, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onDone(aquz paramaquz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViewPluginLoader", 2, "downloadUpdate loaded json = " + paramaquz.currUrl + " code = " + paramaquz.errCode);
    }
    boolean bool = this.this$0.a(this.aGi, this.aMQ, this.aMR);
    if (QLog.isColorLevel()) {
      QLog.d("ViewPluginLoader", 2, "downloadUpdate unCompressOffline" + bool);
    }
    this.this$0.bAB();
  }
  
  public void onProgress(aquz paramaquz)
  {
    int i = (int)(paramaquz.fj * 100.0F);
    if (((i % 10 == 0) || (i > 90)) && (QLog.isColorLevel())) {
      QLog.d("ViewPluginLoader", 2, "downding progress = " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ssi
 * JD-Core Version:    0.7.0.1
 */