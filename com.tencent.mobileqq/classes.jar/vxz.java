import com.tencent.qphone.base.util.QLog;

class vxz
  extends vlc
{
  vxz(vxx paramvxx) {}
  
  public void a(byte paramByte)
  {
    boolean bool = true;
    this.a.a = paramByte;
    vxx.c(this.a, true);
    vxx localvxx;
    if (paramByte != -1)
    {
      if (paramByte == 0) {
        vxx.b(this.a);
      }
      localvxx = this.a;
      if (paramByte != 2) {
        break label88;
      }
    }
    for (;;)
    {
      localvxx.a(bool);
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
    vuq localvuq = (vuq)vux.a(10);
    this.a.b = ((Boolean)localvuq.b("key_story_msg_tab_show", Boolean.valueOf(false))).booleanValue();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "commonConfigReceived:" + this.a.b);
    }
    vxx.a(this.a);
    vxx.a(this.a, true);
    vxx.a(this.a, true);
    vxx.b(this.a);
  }
  
  public void f(boolean paramBoolean)
  {
    if (!vxx.a(this.a))
    {
      if (paramBoolean)
      {
        this.a.c = this.a.a();
        vxx.a(this.a);
        vxx.a(this.a, true);
      }
      vxx.b(this.a, true);
      vxx.b(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "onMsgTabStoryDPCCfgHasContentReceived:" + this.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxz
 * JD-Core Version:    0.7.0.1
 */