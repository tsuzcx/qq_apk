import com.tencent.qphone.base.util.QLog;

class uut
  extends uhn
{
  uut(uur paramuur) {}
  
  public void a(byte paramByte)
  {
    boolean bool = true;
    this.a.a = paramByte;
    uur.c(this.a, true);
    uur localuur;
    if (paramByte != -1)
    {
      if (paramByte == 0) {
        uur.b(this.a);
      }
      localuur = this.a;
      if (paramByte != 2) {
        break label88;
      }
    }
    for (;;)
    {
      localuur.a(bool);
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
    urk localurk = (urk)urr.a(10);
    this.a.b = ((Boolean)localurk.b("key_story_msg_tab_show", Boolean.valueOf(false))).booleanValue();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "commonConfigReceived:" + this.a.b);
    }
    uur.a(this.a);
    uur.a(this.a, true);
    uur.a(this.a, true);
    uur.b(this.a);
  }
  
  public void f(boolean paramBoolean)
  {
    if (!uur.a(this.a))
    {
      if (paramBoolean)
      {
        this.a.c = this.a.a();
        uur.a(this.a);
        uur.a(this.a, true);
      }
      uur.b(this.a, true);
      uur.b(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "onMsgTabStoryDPCCfgHasContentReceived:" + this.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uut
 * JD-Core Version:    0.7.0.1
 */