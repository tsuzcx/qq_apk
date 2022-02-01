package com.tencent.hydevteam.common.progress;

import com.tencent.hydevteam.common.annotation.API;
import java.util.concurrent.Future;

@API
public abstract interface ProgressFuture<T>
  extends Progress, Future<T>
{}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.hydevteam.common.progress.ProgressFuture
 * JD-Core Version:    0.7.0.1
 */