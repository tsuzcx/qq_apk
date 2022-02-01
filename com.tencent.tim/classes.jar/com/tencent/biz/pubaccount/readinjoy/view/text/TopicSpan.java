package com.tencent.biz.pubaccount.readinjoy.view.text;

import android.text.style.ForegroundColorSpan;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import nqg;
import nqi;

public class TopicSpan
  extends ForegroundColorSpan
  implements nqg, nqi
{
  private final TopicInfo a;
  
  public TopicSpan(TopicInfo paramTopicInfo)
  {
    super(-15504151);
    this.a = paramTopicInfo;
  }
  
  public TopicInfo b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.text.TopicSpan
 * JD-Core Version:    0.7.0.1
 */