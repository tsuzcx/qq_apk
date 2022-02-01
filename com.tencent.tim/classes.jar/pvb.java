import com.tencent.qphone.base.util.QLog;

class pvb
  extends pmd
{
  pvb(puz parampuz) {}
  
  public void blS()
  {
    psr localpsr = (psr)psx.a(10);
    this.a.aBU = ((Boolean)localpsr.c("key_story_msg_tab_show", Boolean.valueOf(false))).booleanValue();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "commonConfigReceived:" + this.a.aBU);
    }
    puz.a(this.a);
    puz.a(this.a, true);
    puz.a(this.a, true);
    puz.b(this.a);
  }
  
  public void c(byte paramByte)
  {
    boolean bool = true;
    this.a.aJ = paramByte;
    puz.c(this.a, true);
    puz localpuz;
    if (paramByte != -1)
    {
      if (paramByte == 0) {
        puz.b(this.a);
      }
      localpuz = this.a;
      if (paramByte != 2) {
        break label88;
      }
    }
    for (;;)
    {
      localpuz.sq(bool);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "onMsgTabStoryOIDBReceived:" + this.a.aBV);
      }
      return;
      label88:
      bool = false;
    }
  }
  
  public void rV(boolean paramBoolean)
  {
    if (!puz.a(this.a))
    {
      if (paramBoolean)
      {
        this.a.aBV = this.a.Jf();
        puz.a(this.a);
        puz.a(this.a, true);
      }
      puz.b(this.a, true);
      puz.b(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "onMsgTabStoryDPCCfgHasContentReceived:" + this.a.aBV);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pvb
 * JD-Core Version:    0.7.0.1
 */