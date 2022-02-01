import com.tencent.qphone.base.util.QLog;

class wso
  extends wfi
{
  wso(wsm paramwsm) {}
  
  public void a(byte paramByte)
  {
    boolean bool = true;
    this.a.a = paramByte;
    wsm.c(this.a, true);
    wsm localwsm;
    if (paramByte != -1)
    {
      if (paramByte == 0) {
        wsm.b(this.a);
      }
      localwsm = this.a;
      if (paramByte != 2) {
        break label88;
      }
    }
    for (;;)
    {
      localwsm.a(bool);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "onMsgTabStoryOIDBReceived:" + this.a.c);
      }
      return;
      label88:
      bool = false;
    }
  }
  
  public void b()
  {
    wpf localwpf = (wpf)wpm.a(10);
    this.a.b = ((Boolean)localwpf.b("key_story_msg_tab_show", Boolean.valueOf(false))).booleanValue();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "commonConfigReceived:" + this.a.b);
    }
    wsm.a(this.a);
    wsm.a(this.a, true);
    wsm.a(this.a, true);
    wsm.b(this.a);
  }
  
  public void f(boolean paramBoolean)
  {
    if (!wsm.a(this.a))
    {
      if (paramBoolean)
      {
        this.a.c = this.a.a();
        wsm.a(this.a);
        wsm.a(this.a, true);
      }
      wsm.b(this.a, true);
      wsm.b(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "onMsgTabStoryDPCCfgHasContentReceived:" + this.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wso
 * JD-Core Version:    0.7.0.1
 */