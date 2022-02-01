package com.tencent.smtt.sdk;

class j$1
  implements Runnable
{
  j$1(j paramj) {}
  
  public void run()
  {
    if ((!TbsShareManager.forceLoadX5FromTBSDemo(j.a(this.a).getContext())) && (TbsDownloader.needDownload(j.a(this.a).getContext(), false))) {
      TbsDownloader.startDownload(j.a(this.a).getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.j.1
 * JD-Core Version:    0.7.0.1
 */