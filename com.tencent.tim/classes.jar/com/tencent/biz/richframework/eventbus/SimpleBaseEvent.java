package com.tencent.biz.richframework.eventbus;

import java.io.Serializable;

public abstract class SimpleBaseEvent
  implements Serializable
{
  public static final String PROCESS_BUNDLE_KEY = "PROCESS_BUNDLE_KEY_SIMPLE_BASE_EVENT";
  public int mHashCode;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.eventbus.SimpleBaseEvent
 * JD-Core Version:    0.7.0.1
 */