package com.tencent.biz.qqstory.base.videoupload;

import com.tribe.async.dispatch.Dispatcher;
import pmi;
import pnx;
import pnx.a;
import pnx.d;
import pox;
import ram;

public class StoryVideoUploadManager$4
  implements Runnable
{
  public StoryVideoUploadManager$4(pnx parampnx, pox parampox, pnx.d paramd) {}
  
  public void run()
  {
    ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "create story %s", new Object[] { this.jdField_a_of_type_Pox });
    pmi.a().dispatch(this.jdField_a_of_type_Pnx$d);
    pmi.a().dispatch(new pnx.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.4
 * JD-Core Version:    0.7.0.1
 */