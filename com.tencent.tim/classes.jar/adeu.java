import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo.NativeSoRes;
import com.tencent.qphone.base.util.QLog;

class adeu
  implements adis.a
{
  adeu(ades paramades, ARCommonConfigInfo.NativeSoRes paramNativeSoRes) {}
  
  public void a(boolean paramBoolean, adis.b paramb)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes onARResourceDownloadComplete. result = " + paramBoolean + ", name = " + this.a.name + ", filename = " + paramb.fileName + ", url = " + paramb.url);
    if (paramBoolean) {
      if (!ades.a(this.this$0, paramb.fileName, paramb.md5))
      {
        ades.a(this.this$0, paramb.fileName);
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
      }
    }
    adis.a locala;
    do
    {
      return;
      if (this.this$0.h(paramb.name, paramb.fileName, paramb.md5) == 0) {}
      locala = ades.a(this.this$0, this.a.name);
    } while (locala == null);
    locala.a(paramBoolean, paramb);
  }
  
  public void aj(long paramLong1, long paramLong2)
  {
    adis.a locala = ades.a(this.this$0, this.a.name);
    if (locala != null) {
      locala.aj(paramLong1, paramLong2);
    }
  }
  
  public void cQU()
  {
    adis.a locala = ades.a(this.this$0, this.a.name);
    if (locala != null) {
      locala.cQU();
    }
  }
  
  public void cQV()
  {
    adis.a locala = ades.a(this.this$0, this.a.name);
    if (locala != null) {
      locala.cQV();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adeu
 * JD-Core Version:    0.7.0.1
 */