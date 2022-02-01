package com.tribe.async.dispatch;

import android.text.TextUtils;
import com.tribe.async.objectpool.ObjectPool;
import com.tribe.async.objectpool.ObjectPoolBuilder;
import com.tribe.async.utils.AssertUtils;

final class PendingPost
{
  private static final ObjectPool<PendingPost> PENDING_POST_POOL;
  public Dispatcher.Dispatchable dispatchable;
  public String group;
  public PendingPost next;
  public Object tag;
  
  static
  {
    ObjectPoolBuilder localObjectPoolBuilder = new ObjectPoolBuilder(PendingPost.class, new PendingPost.1());
    localObjectPoolBuilder.setAllocator(new PendingPost.2(PendingPost.class));
    PENDING_POST_POOL = localObjectPoolBuilder.build();
  }
  
  static PendingPost obtainPendingPost(Object paramObject, String paramString, Dispatcher.Dispatchable paramDispatchable)
  {
    AssertUtils.checkNotNull(paramObject);
    AssertUtils.checkNotNull(paramString);
    AssertUtils.checkNotNull(paramDispatchable);
    PendingPost localPendingPost = (PendingPost)PENDING_POST_POOL.allocate();
    localPendingPost.dispatchable = paramDispatchable;
    localPendingPost.group = paramString;
    localPendingPost.tag = paramObject;
    localPendingPost.next = null;
    return localPendingPost;
  }
  
  static void releasePendingPost(PendingPost paramPendingPost)
  {
    AssertUtils.checkNotNull(paramPendingPost);
    paramPendingPost.dispatchable = null;
    paramPendingPost.group = null;
    paramPendingPost.tag = null;
    paramPendingPost.next = null;
    PENDING_POST_POOL.release(paramPendingPost);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PendingPost)) {}
    do
    {
      return false;
      paramObject = (PendingPost)paramObject;
    } while ((!paramObject.dispatchable.equals(this.dispatchable)) || (!TextUtils.equals(this.group, paramObject.group)) || (!paramObject.tag.equals(this.tag)));
    return true;
  }
  
  public int hashCode()
  {
    if (this.dispatchable == null) {
      return 0;
    }
    return this.dispatchable.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tribe.async.dispatch.PendingPost
 * JD-Core Version:    0.7.0.1
 */