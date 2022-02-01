import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;

class mel
  implements mef.a.a
{
  mel(mek parammek, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void a(int paramInt, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2)
  {
    mef.b localb = mek.a(this.c);
    if (paramInt == 0)
    {
      if (paramBoolean2) {
        RIJRedPacketManager.a().aOG();
      }
      if (paramBoolean1) {
        RIJRedPacketManager.a().aOF();
      }
      if (localb != null)
      {
        localb.X(paramBoolean2, paramBoolean1);
        if ((!paramBoolean2) || (paramBoolean1)) {
          break label85;
        }
        localb.a(paramString1, paramString2, this.aQC, this.aQD, this.aQE, this.Vw);
      }
    }
    label85:
    while (mek.a(this.c) == null)
    {
      return;
      localb.aKv();
      return;
    }
    localb.aKv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mel
 * JD-Core Version:    0.7.0.1
 */