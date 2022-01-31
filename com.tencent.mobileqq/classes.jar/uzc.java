import com.tencent.qphone.base.util.QLog;

class uzc
  extends ulw
{
  uzc(uza paramuza) {}
  
  public void a(byte paramByte)
  {
    boolean bool = true;
    this.a.a = paramByte;
    uza.c(this.a, true);
    uza localuza;
    if (paramByte != -1)
    {
      if (paramByte == 0) {
        uza.b(this.a);
      }
      localuza = this.a;
      if (paramByte != 2) {
        break label88;
      }
    }
    for (;;)
    {
      localuza.a(bool);
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
    uvt localuvt = (uvt)uwa.a(10);
    this.a.b = ((Boolean)localuvt.b("key_story_msg_tab_show", Boolean.valueOf(false))).booleanValue();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "commonConfigReceived:" + this.a.b);
    }
    uza.a(this.a);
    uza.a(this.a, true);
    uza.a(this.a, true);
    uza.b(this.a);
  }
  
  public void f(boolean paramBoolean)
  {
    if (!uza.a(this.a))
    {
      if (paramBoolean)
      {
        this.a.c = this.a.a();
        uza.a(this.a);
        uza.a(this.a, true);
      }
      uza.b(this.a, true);
      uza.b(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "onMsgTabStoryDPCCfgHasContentReceived:" + this.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uzc
 * JD-Core Version:    0.7.0.1
 */