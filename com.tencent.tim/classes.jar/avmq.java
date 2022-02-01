import cooperation.qqreader.VipProxyRreLoadReaderProcess.1;

public class avmq
  implements jox
{
  public avmq(VipProxyRreLoadReaderProcess.1 param1) {}
  
  public void loaded(String paramString, int paramInt)
  {
    avoc.i("VipProxyRreLoadReaderProcess", "Load offline package finish, code = " + paramInt);
    if (paramInt != 0) {
      avoc.e("VipProxyRreLoadReaderProcess", "offline update failed.");
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avmq
 * JD-Core Version:    0.7.0.1
 */