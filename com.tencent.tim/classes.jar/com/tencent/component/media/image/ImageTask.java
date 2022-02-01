package com.tencent.component.media.image;

abstract class ImageTask
{
  protected static final int MAX_OBJECT_POOL_SIZE = 50;
  protected static final int RESULT_ON_DECODE_GIF_STREAM_SUCCEED = 17;
  protected static final int RESULT_ON_DECODE_IMAGE_FAILED = 9;
  protected static final int RESULT_ON_DECODE_IMAGE_SUCCEED = 8;
  protected static final int RESULT_ON_DONWNLOAD_CANCELED = 0;
  protected static final int RESULT_ON_DONWNLOAD_FAILED = 1;
  protected static final int RESULT_ON_DONWNLOAD_PROGRESS = 3;
  protected static final int RESULT_ON_DONWNLOAD_SUCCEED = 2;
  protected static final int RESULT_ON_IMAGE_CANCELED = 5;
  protected static final int RESULT_ON_IMAGE_FAILED = 4;
  protected static final int RESULT_ON_IMAGE_LOADED = 6;
  protected static final int RESULT_ON_IMAGE_PROGRESS = 7;
  protected static final int RESULT_ON_STREAM_APPLY_IMAGE = 15;
  protected static final int RESULT_ON_STREAM_END = 16;
  protected static final int RESULT_ON_STREAM_PROGRESS = 14;
  protected static final int RESULT_ON_TASK_CANCELED = 13;
  protected static final int RESULT_ON_TRY_GET_FILE_SUCCEED = 12;
  protected static final int RESULT_ON_TRY_GET_MEMORY_SUCCEED = 11;
  protected static int mInitAllocatedSize = 25;
  protected static boolean needRecycle = true;
  protected ImageKey mImageKey = null;
  protected ImageTask mNextTask = null;
  protected ImageTask mPreviousTask = null;
  protected ImageTaskAttribute mTaskAttribute = null;
  
  protected ImageTask(ImageKey paramImageKey)
  {
    if (paramImageKey != null)
    {
      this.mNextTask = null;
      this.mImageKey = paramImageKey;
      this.mTaskAttribute = new ImageTaskAttribute();
      this.mPreviousTask = null;
    }
  }
  
  protected ImageTask(ImageTask paramImageTask)
  {
    if (paramImageTask != null)
    {
      this.mNextTask = paramImageTask;
      this.mImageKey = paramImageTask.mImageKey;
      this.mTaskAttribute = paramImageTask.mTaskAttribute;
      this.mPreviousTask = null;
      paramImageTask.mPreviousTask = this;
    }
  }
  
  public void cancel()
  {
    ImageTaskAttribute localImageTaskAttribute = this.mTaskAttribute;
    if (localImageTaskAttribute != null) {
      localImageTaskAttribute.isCanceled = true;
    }
  }
  
  public abstract void excuteTask();
  
  public ImageKey getImageKey()
  {
    return this.mImageKey;
  }
  
  public ImageTask getNextTask()
  {
    return this.mNextTask;
  }
  
  public ImageTask getPreviousTask()
  {
    return this.mPreviousTask;
  }
  
  public boolean isCanceled()
  {
    ImageTaskAttribute localImageTaskAttribute = this.mTaskAttribute;
    if (localImageTaskAttribute != null) {
      return localImageTaskAttribute.isCanceled;
    }
    return true;
  }
  
  protected abstract void onResult(int paramInt, Object... paramVarArgs);
  
  public void recycle() {}
  
  protected void reset()
  {
    this.mNextTask = null;
    this.mPreviousTask = null;
    this.mImageKey = null;
    this.mTaskAttribute = null;
  }
  
  protected void setImageKey(ImageKey paramImageKey)
  {
    this.mNextTask = null;
    this.mImageKey = paramImageKey;
    this.mTaskAttribute = new ImageTaskAttribute();
    this.mPreviousTask = null;
  }
  
  protected void setImageTask(ImageTask paramImageTask)
  {
    this.mNextTask = paramImageTask;
    this.mImageKey = paramImageTask.mImageKey;
    this.mTaskAttribute = paramImageTask.mTaskAttribute;
    this.mPreviousTask = null;
    paramImageTask.mPreviousTask = this;
  }
  
  protected void setResult(int paramInt, Object... paramVarArgs)
  {
    if (this.mPreviousTask != null) {
      this.mPreviousTask.onResult(paramInt, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.ImageTask
 * JD-Core Version:    0.7.0.1
 */