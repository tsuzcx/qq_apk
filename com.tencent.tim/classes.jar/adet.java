import com.tencent.qphone.base.util.QLog;

class adet
  implements adis.a
{
  adet(ades paramades, String paramString, adis.a parama) {}
  
  public void a(boolean paramBoolean, adis.b paramb)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes onARResourceDownloadComplete. result = " + paramBoolean + ", name = " + paramb.name + ", filename = " + paramb.fileName + ", url = " + paramb.url);
    if (paramBoolean) {
      if (!ades.a(this.this$0, paramb.fileName, paramb.md5))
      {
        ades.a(this.this$0, paramb.fileName);
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
      }
    }
    while (this.e == null)
    {
      return;
      if ((!paramb.name.equalsIgnoreCase(this.bst)) || (this.this$0.h(paramb.name, paramb.fileName, paramb.md5) != 0)) {}
    }
    this.e.a(paramBoolean, paramb);
  }
  
  public void aj(long paramLong1, long paramLong2)
  {
    if (this.e != null) {
      this.e.aj(paramLong1, paramLong2);
    }
  }
  
  public void cQU()
  {
    if (this.e != null) {
      this.e.cQU();
    }
  }
  
  public void cQV()
  {
    if (this.e != null) {
      this.e.cQV();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adet
 * JD-Core Version:    0.7.0.1
 */