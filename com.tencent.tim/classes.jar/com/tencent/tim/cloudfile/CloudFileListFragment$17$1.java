package com.tencent.tim.cloudfile;

import atft;
import auhh;
import java.util.List;

public class CloudFileListFragment$17$1
  implements Runnable
{
  public CloudFileListFragment$17$1(atft paramatft, List paramList) {}
  
  public void run()
  {
    byte[] arrayOfByte = CloudFileListFragment.a(this.a.this$0);
    if ((CloudFileListFragment.a(this.a.this$0) != null) && (this.qD != null) && (arrayOfByte != null)) {
      CloudFileListFragment.a(this.a.this$0).a(arrayOfByte, this.qD, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudFileListFragment.17.1
 * JD-Core Version:    0.7.0.1
 */