package com.tencent.mobileqq.pluginsdk;

class PluginManageHandler$1
  implements Runnable
{
  PluginManageHandler$1(PluginManageHandler paramPluginManageHandler) {}
  
  public void run()
  {
    if (PluginManageHandler.access$000(this.this$0) == null) {
      synchronized (this.this$0)
      {
        if ((PluginManageHandler.access$000(this.this$0) == null) && (PluginManageHandler.access$100(this.this$0) != null))
        {
          PluginManageHandler.access$002(this.this$0, PluginManageHandler.access$100(this.this$0).onGetPluginManager());
          PluginManageHandler.access$200(this.this$0);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginManageHandler.1
 * JD-Core Version:    0.7.0.1
 */