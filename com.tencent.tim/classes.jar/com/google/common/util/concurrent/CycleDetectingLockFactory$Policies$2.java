package com.google.common.util.concurrent;

import java.util.logging.Level;
import java.util.logging.Logger;

 enum CycleDetectingLockFactory$Policies$2
{
  CycleDetectingLockFactory$Policies$2()
  {
    super(str, i, null);
  }
  
  public void handlePotentialDeadlock(CycleDetectingLockFactory.PotentialDeadlockException paramPotentialDeadlockException)
  {
    CycleDetectingLockFactory.access$100().log(Level.SEVERE, "Detected potential deadlock", paramPotentialDeadlockException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.CycleDetectingLockFactory.Policies.2
 * JD-Core Version:    0.7.0.1
 */