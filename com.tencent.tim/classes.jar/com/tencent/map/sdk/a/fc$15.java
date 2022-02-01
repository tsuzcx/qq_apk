package com.tencent.map.sdk.a;

import java.sql.Timestamp;
import java.util.Date;

final class fc$15
  implements ef
{
  public final <T> ee<T> a(dn paramdn, fd<T> paramfd)
  {
    if (paramfd.a != Timestamp.class) {
      return null;
    }
    return new fc.15.1(this, paramdn.a(Date.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.fc.15
 * JD-Core Version:    0.7.0.1
 */