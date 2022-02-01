package com.tencent.tim.cloudfile;

import anpc;
import atfv;

public class CloudFileListFragment$3$1
  implements Runnable
{
  public CloudFileListFragment$3$1(atfv paramatfv, int paramInt) {}
  
  public void run()
  {
    if (this.val$fileType == 1)
    {
      anpc.report("tim_mine_tab_file_click_open_folder");
      return;
    }
    anpc.report("tim_mine_tab_file_click_open_file");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudFileListFragment.3.1
 * JD-Core Version:    0.7.0.1
 */