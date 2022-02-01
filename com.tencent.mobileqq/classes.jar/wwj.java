import com.tencent.qphone.base.util.QLog;

class wwj
  extends wjd
{
  wwj(wwh paramwwh) {}
  
  public void a(byte paramByte)
  {
    boolean bool = true;
    this.a.a = paramByte;
    wwh.c(this.a, true);
    wwh localwwh;
    if (paramByte != -1)
    {
      if (paramByte == 0) {
        wwh.b(this.a);
      }
      localwwh = this.a;
      if (paramByte != 2) {
        break label88;
      }
    }
    for (;;)
    {
      localwwh.a(bool);
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
    wta localwta = (wta)wth.a(10);
    this.a.b = ((Boolean)localwta.b("key_story_msg_tab_show", Boolean.valueOf(false))).booleanValue();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "commonConfigReceived:" + this.a.b);
    }
    wwh.a(this.a);
    wwh.a(this.a, true);
    wwh.a(this.a, true);
    wwh.b(this.a);
  }
  
  public void f(boolean paramBoolean)
  {
    if (!wwh.a(this.a))
    {
      if (paramBoolean)
      {
        this.a.c = this.a.a();
        wwh.a(this.a);
        wwh.a(this.a, true);
      }
      wwh.b(this.a, true);
      wwh.b(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "onMsgTabStoryDPCCfgHasContentReceived:" + this.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wwj
 * JD-Core Version:    0.7.0.1
 */