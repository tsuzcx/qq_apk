package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pmi;
import psu;
import pyc;
import pyc.a;

public class StoryManager$1
  implements Runnable
{
  public StoryManager$1(psu parampsu, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0.a(this.val$vid);
    if ((localObject == null) || (!((StoryVideoItem)localObject).isBasicInfoOK()))
    {
      localObject = new ArrayList(1);
      ((List)localObject).add(this.val$vid);
      new pyc((List)localObject, true).sendRequest();
      return;
    }
    pyc.a locala = new pyc.a();
    locala.mVideoList = Collections.singletonList(localObject);
    pmi.a().dispatch(locala);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.StoryManager.1
 * JD-Core Version:    0.7.0.1
 */