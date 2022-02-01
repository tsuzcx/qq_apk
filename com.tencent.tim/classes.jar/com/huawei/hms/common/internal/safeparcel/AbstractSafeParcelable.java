package com.huawei.hms.common.internal.safeparcel;

import com.huawei.hms.support.api.client.Result;

public abstract class AbstractSafeParcelable
  extends Result
  implements SafeParcelable
{
  public final int describeContents()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.common.internal.safeparcel.AbstractSafeParcelable
 * JD-Core Version:    0.7.0.1
 */