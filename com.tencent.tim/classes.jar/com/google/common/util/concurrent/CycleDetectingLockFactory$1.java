package com.google.common.util.concurrent;

import com.google.common.collect.Lists;
import java.util.ArrayList;

final class CycleDetectingLockFactory$1
  extends ThreadLocal<ArrayList<CycleDetectingLockFactory.LockGraphNode>>
{
  protected ArrayList<CycleDetectingLockFactory.LockGraphNode> initialValue()
  {
    return Lists.newArrayListWithCapacity(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.CycleDetectingLockFactory.1
 * JD-Core Version:    0.7.0.1
 */