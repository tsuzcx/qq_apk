package com.tencent.biz.pubaccount.readinjoy.model;

import aqhq;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import lhn;
import org.json.JSONArray;

public class ChannelCoverInfoModule$9
  implements Runnable
{
  public ChannelCoverInfoModule$9(lhn paramlhn, JSONArray paramJSONArray) {}
  
  public void run()
  {
    aqhq.writeFile(BaseApplicationImpl.getApplication().getDir("readinjoy", 0).getAbsolutePath() + "/channel_section_data", this.val$array.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.9
 * JD-Core Version:    0.7.0.1
 */