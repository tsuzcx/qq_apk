package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.util.concurrent.ScheduledFuture;

@Beta
@GwtIncompatible
public abstract interface ListenableScheduledFuture<V>
  extends ListenableFuture<V>, ScheduledFuture<V>
{}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.ListenableScheduledFuture
 * JD-Core Version:    0.7.0.1
 */