import com.tencent.qphone.base.util.QLog;

class wmu
  extends vzx
{
  wmu(wms paramwms) {}
  
  public void a(byte paramByte)
  {
    boolean bool = true;
    this.a.a = paramByte;
    wms.c(this.a, true);
    wms localwms;
    if (paramByte != -1)
    {
      if (paramByte == 0) {
        wms.b(this.a);
      }
      localwms = this.a;
      if (paramByte != 2) {
        break label88;
      }
    }
    for (;;)
    {
      localwms.a(bool);
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
    wjl localwjl = (wjl)wjs.a(10);
    this.a.b = ((Boolean)localwjl.b("key_story_msg_tab_show", Boolean.valueOf(false))).booleanValue();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "commonConfigReceived:" + this.a.b);
    }
    wms.a(this.a);
    wms.a(this.a, true);
    wms.a(this.a, true);
    wms.b(this.a);
  }
  
  public void f(boolean paramBoolean)
  {
    if (!wms.a(this.a))
    {
      if (paramBoolean)
      {
        this.a.c = this.a.a();
        wms.a(this.a);
        wms.a(this.a, true);
      }
      wms.b(this.a, true);
      wms.b(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "onMsgTabStoryDPCCfgHasContentReceived:" + this.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wmu
 * JD-Core Version:    0.7.0.1
 */