package com.tencent.mm.sdk.plugin;

class MMPluginOAuth$1
  implements Runnable
{
  MMPluginOAuth$1(MMPluginOAuth paramMMPluginOAuth) {}
  
  public void run()
  {
    if (MMPluginOAuth.b(this.bJ) != null) {
      MMPluginOAuth.b(this.bJ).onResult(this.bJ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.plugin.MMPluginOAuth.1
 * JD-Core Version:    0.7.0.1
 */